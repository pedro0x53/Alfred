package assistant.alfred;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import assistant.alfred.Controllers.ActivityController;

public class MainActivity extends AppCompatActivity {
    private Assistente a;

    final Activity mainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityController activityController = new ActivityController(mainActivity);

        a = new Assistente(activityController);

        ImageButton mic = findViewById(R.id.mic);
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a.startListen();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
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
                    a.process(res);
                }
            }
            catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
