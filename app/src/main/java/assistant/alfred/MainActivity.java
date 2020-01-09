package assistant.alfred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import assistant.alfred.Controllers.ActivityController;

public class MainActivity extends AppCompatActivity {
    private Assistente a;
    private TextView tv;
    private PackageManager packageManager;
    private ActivityController activityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityController = new ActivityController(this);

        a = new Assistente(activityController, packageManager);

        tv = findViewById(R.id.mainResponse);
        tv.setText("");

        ImageButton mic = findViewById(R.id.mic);
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a.startListen();
                }
                catch (Exception e) {
                    tv.setText(e.getMessage());
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null){
            ArrayList<String> res = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            try {
                if (!(res.isEmpty())) {
                    a.process(res, tv);
                }
            }
            catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
