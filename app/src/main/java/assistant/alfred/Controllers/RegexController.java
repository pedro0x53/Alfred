package assistant.alfred.Controllers;

import java.util.ArrayList;
import static assistant.alfred.Utils.RegexStrings.*;

public class RegexController {
    public static String[] getResponse(ArrayList<String> reqList) {
        String[] res = {"-1", ""};
        for(String req: reqList) {
            if(req.matches(REGEX_START_LISTEN)) {
                res[0] = "10";
                res[1] = req;
            }
            else if(req.matches(REGEX_RUN_APP)) {
                res[0] = "20";
                res[1] = req;
            }
        }
        return res;
    }
}
