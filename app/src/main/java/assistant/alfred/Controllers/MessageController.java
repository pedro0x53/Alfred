package assistant.alfred.Controllers;

import android.app.Activity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import assistant.alfred.R;

public class MessageController {

    private Activity context;
    private LinearLayout chat;
    private ScrollView scrollView;

    public MessageController(Activity context) {
        this.context = context;
        chat = context.findViewById(R.id.chat);
        scrollView = context.findViewById(R.id.scrollView);
    }

    public void createMessage(String content, int code) {
        TextView message = new TextView(context);

        float density = context.getResources().getDisplayMetrics().density;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, Math.round(5 * density), 0, Math.round(5 * density));

        if(code == 1){
            message = (TextView)context.getLayoutInflater().inflate(R.layout.user_message, null);

            params.setMarginStart(Math.round(80 * density));
            params.gravity = Gravity.END;
        }
        else if(code == 2) {
            message = (TextView)context.getLayoutInflater().inflate(R.layout.assistant_message, null);

            params.setMarginEnd(Math.round(80 * density));
            params.gravity = Gravity.START;
        }

        message.setLayoutParams(params);
        message.setText(content);

        chat.addView(message);

        scrollDown();

    }

    public void clearMessages() {
        chat.removeAllViews();
    }

    public void scrollDown() {
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        }, 100L);
    }

    public void scrollUp() {
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        }, 100L);
    }
}
