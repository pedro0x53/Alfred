package assistant.alfred;

import java.util.ArrayList;
import static assistant.alfred.Utils.RegexStrings.*;

class RegexController {
    public static String[] getResponse(ArrayList<String> reqList) {
        String[] res = {"", ""};
        for(String req: reqList) {
            if(req.matches(REGEX_START_LISTEN)) {
                res[0] = "10";
                res[1] = req;
            }
            else if(req.matches(REGEX_RUN_APP)) {
                res[0] = "10";
                res[1] = req;
            }
        }
        return res;
    }
}
