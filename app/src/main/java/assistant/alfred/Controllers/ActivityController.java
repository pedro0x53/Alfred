package assistant.alfred.Controllers;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.speech.RecognizerIntent;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {
    public Activity context;
    private PackageManager packageManager;
    private Intent speechRecognizer;

    public ActivityController(Activity context) {
        this.context = context;

        packageManager = context.getPackageManager();

        speechRecognizer = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizer.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
        speechRecognizer.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR");
    }

    public void startSpeechRecognizer() {
        context.startActivityForResult(speechRecognizer, 10);
    }

    public ArrayList<ApplicationInfo> getInstalledApplications() {
        ArrayList<ApplicationInfo> appList = new ArrayList<ApplicationInfo>();
        List<ApplicationInfo> packageList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo info : packageList) {
            try {
                if (null != packageManager.getLaunchIntentForPackage(info.packageName)) {
                    appList.add(info);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return appList;
    }

    public void run(ApplicationInfo appInfo) {
        Intent launcher = packageManager.getLaunchIntentForPackage(appInfo.packageName);
        context.startActivity(launcher);
    }

}
