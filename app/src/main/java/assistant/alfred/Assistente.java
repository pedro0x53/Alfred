package assistant.alfred;

import android.widget.TextView;
import java.util.ArrayList;

public class Assistente {

    public void processar(ArrayList<String> data, TextView tv) {
        String[] code = RegexController.getResponse(data);
        String action = "Code: " + code[0] + "\nRequest: " + code[1];
        tv.setText(action);
    }
}
