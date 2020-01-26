package assistant.alfred.Controllers;

import java.util.ArrayList;
import static assistant.alfred.Utils.RegexStrings.*;

public class RegexController {


    private static boolean key_activation_scheduling = false;


    public static String[] getResponse(ArrayList<String> reqList) {
        String[] res = {"-1", reqList.get(0)};
        for(String req: reqList) {
            if(req.matches(REGEX_START_LISTEN)) {
                res[0] = "10";
                res[1] = req;
            }
            else if(req.matches(REGEX_RUN_APP)) {
                res[0] = "20";
                res[1] = req;
            }

            else if(req.matches(REGEX_REPLACE_MODO_AGENDAMENTO)){
                key_activation_scheduling = true;
                res[0] = "30";
                res[1] = req;
            }

            else if(req.matches(REGEX_CONFIRM_AGENDAMENTO)&& key_activation_scheduling) {
                res[0] = "40";
                res[1] = req;
            }
            else if(req.matches(REGEX_VER_AGENDAMENTO_DAY) && key_activation_scheduling){
                res[0] = "50";
                res[1] = req;
            }
            else if(req.matches(REGEX_EXIT_FUNCTIONS) && key_activation_scheduling){
                res[0] = "1000";
                res[1] = req;
                key_activation_scheduling = false;
            }

        }
        return res;
    }
}
