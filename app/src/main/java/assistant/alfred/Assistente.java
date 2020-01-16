package assistant.alfred;

import android.content.pm.ApplicationInfo;
import java.util.ArrayList;

import assistant.alfred.Controllers.ActivityController;
import assistant.alfred.Controllers.MessageController;
import assistant.alfred.Controllers.RegexController;
import assistant.alfred.Utils.Strings;
import assistant.alfred.Utils.RegexStrings;

class Assistente {
    private ActivityController activityController;
    private MessageController messageController;

    Assistente(ActivityController activityController) {
        this.activityController = activityController;
        this.messageController = new MessageController(this.activityController.context);
    }

    void startListen() {
        activityController.startSpeechRecognizer();
    }

    void process(ArrayList<String> data) {
        String[] res = RegexController.getResponse(data);
        int code = Integer.parseInt(res[0]);

        String listen = res[1];
        messageController.createMessage(listen, 1);

        switch (code) {
            case 10:
                break;
            case 20:
                runApp(listen);
                break;
            case -1:
                messageController.createMessage(Strings.ERROR, 2);
        }
    }

    private void runApp(String req) {
        boolean status = false;
        String appReq = req.replaceFirst(RegexStrings.REGEX_REPLACE_RUN_APP, "");
        ArrayList<ApplicationInfo> appList = activityController.getInstalledApplications();
        for(ApplicationInfo appInfo : appList) {
            if (appInfo.packageName.contains(appReq.toLowerCase())) {
                status = true;
                activityController.run(appInfo);
            }
        }

        if(status){
            messageController.createMessage(Strings.STARTING_APP(appReq), 2);
        }else {
            messageController.createMessage(Strings.STARTING_APP_FAILED(appReq), 2);
        }

    }
}
