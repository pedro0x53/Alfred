package assistant.alfred;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


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
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        a = new Assistente(activityController);
        a.verifyFiles();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_tutorial) {
            a.tutorial();
        }
        return super.onOptionsItemSelected(item);
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
