package assistant.alfred;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;
import java.util.ArrayList;

import assistant.alfred.Controllers.ActivityController;
import assistant.alfred.Controllers.RegexController;
import assistant.alfred.Utils.RegexStrings;

class Assistente {
    private ActivityController activityController;

    Assistente(ActivityController activityController, PackageManager packageManager) {
        this.activityController = activityController;
    }

    void startListen() {
        activityController.startSpeechRecognizer();
    }

    void process(ArrayList<String> data, TextView tv) {
        String[] res = RegexController.getResponse(data);
        int code = Integer.parseInt(res[0]);
        String listen = res[1];

        switch (code) {
            case 10:
                break;
            case 20:
                runApp(listen, tv);
                break;
        }
    }

    private void runApp(String req, TextView tv) {
        boolean status = false;
        String res = "";
        String appReq = req.replaceFirst(RegexStrings.REGEX_REPLACE_RUN_APP, "");
        ArrayList<ApplicationInfo> appList = activityController.getInstalledApplications();
        for(ApplicationInfo appInfo : appList) {
            if (appInfo.packageName.contains(appReq.toLowerCase())) {
                status = true;
                activityController.run(appInfo);
            }
        }

        if(status){
            res = "Iniciando " + appReq;
        }else {
            res = "Ops! Não foi possível encontrar o app " + appReq;
        }

        tv.setText(res);
    }
}
