package assistant.alfred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.mainResponse);
        tv.setText("");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        tv = findViewById(R.id.mainResponse);
        if (resultCode == RESULT_OK && null != data){
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            int size = result.size();
            if(size < 0) {
                for (int i = 0; i < result.size(); i++) {
                    tv.setText(result.get(i));
                }
            }
        }
    }

    public void ouvir(View view){
        try {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            //intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR");
            startActivityForResult(intent, 10);
        }catch (Exception e){
            tv = findViewById(R.id.mainResponse);
            tv.setText(e.getMessage());
        }
    }

}
