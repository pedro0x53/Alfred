package assistant.alfred;

import android.widget.TextView;
import java.util.ArrayList;

public class Assistente {

    protected void processar(ArrayList<String> res, TextView tv) {
        for (String word: res) {
            tv.setText(word);
        }
    }
}
