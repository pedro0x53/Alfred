package assistant.alfred;

import android.content.pm.ApplicationInfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import assistant.alfred.Controllers.ActivityController;
import assistant.alfred.Controllers.MessageController;
import assistant.alfred.Controllers.RegexController;
import assistant.alfred.Utils.Strings;
import assistant.alfred.Utils.RegexStrings;


class Assistente{


    private ActivityController activityController;
    private MessageController messageController;

    Assistente(ActivityController activityController) {
        this.activityController = activityController;
        this.messageController = new MessageController(this.activityController.context);
    }

    void startListen() {
        activityController.startSpeechRecognizer();
    }

    void process(ArrayList<String> data) {
        String[] res = RegexController.getResponse(data);
        int code = Integer.parseInt(res[0]);

        String listen = res[1];
        messageController.createMessage(listen, 1);

        switch (code) {
            case 10:
                break;
            case 20:
                runApp(listen);
                break;
            case 30:
                schedulingMode(listen);
                break;
            case 40:
                schedule(listen);
                break;
            case 50:
                verAgendamento(listen);
                break;
            case 1000:
                cancelingFunction(listen);
                break;
            case -1:
                messageController.createMessage(Strings.ERROR, 2);
        }
    }

    public void tutorial(){
        for(final String message : Strings.TUTORIAL) {
            messageController.createMessage(message, 2);
        }

        messageController.scrollUp();
    }
    private void runApp(String req) {
        boolean status = false;
        String appReq = req.replaceFirst(RegexStrings.REGEX_REPLACE_RUN_APP, "");
        ArrayList<ApplicationInfo> appList = activityController.getInstalledApplications();
        for (ApplicationInfo appInfo : appList) {
            if (appInfo.packageName.contains(appReq.toLowerCase())) {
                status = true;
                activityController.run(appInfo);
            }
        }

        if (status) {
            messageController.createMessage(Strings.STARTING_APP(appReq), 2);
        } else {
            messageController.createMessage(Strings.STARTING_APP_FAILED(appReq), 2);
        }

    }


    public void schedulingMode(String req) {
        String string = req.toLowerCase();
        if (string.contains("agendamento")){
            messageController.createMessage(Strings.STARTING_AGENDAMENTO, 2);
            messageController.createMessage(Strings.SELECTION_OPTIONS_AGENDAMENTO, 2);
        } else {
            messageController.createMessage(Strings.ERROR, 2);
        }
    }

    private void verAgendamento(String req) {
        String string = req.toLowerCase();
        String day = string.replaceFirst(RegexStrings.REGEX_REPLACE_DAYS, "");
        messageController.createMessage("Agendamento de " + day + ":", 2 );
        leitor(day +".txt", string);
            // agendado ou já existe
            //ja existe : deseja marcar esse compromisso por cima?
    }


    public void schedule(String req) {
        String string = req.toLowerCase();
        String day = string.replaceFirst(RegexStrings.REGEX_REPLACE_CONFIRM_AGENDAMENTO_DAY , "");
        escritor(day + ".txt", string);
        messageController.createMessage("Tarefa salva com sucesso", 2);

    }

    private void cancelingFunction(String req) {
        String string = req.replaceFirst(RegexStrings.REGEX_REPLACE_RUN_APP, "");
        if (string.contains("agendamento")) {
            messageController.createMessage("Modo a AGENDAMENTO CANCELADO", 2);
        } else {
            messageController.createMessage("MODO AGENDAMENTO FECHADO", 2);
        }
    }


    private void leitor(String fileName, String frase) {
        String conteudo = "";
        try {
            FileReader arq = new FileReader("/data/data/assistant.alfred/files/" + fileName);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha= "";
            try {
                linha = lerArq.readLine();
                while(linha != null){
                    messageController.createMessage(linha,2);
                    conteudo += linha + "";
                    linha = lerArq.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void escritor(String fileName, String phrase ) {
        String hours_1 = phrase.replaceFirst(RegexStrings.REGEX_REPLACE_CONFIRM_AGENDAMENTO_HOURS_1,"");
        String hours_2 = hours_1.replaceFirst(RegexStrings.REGEX_REPLACE_CONFIRM_AGENDAMENTO_HOURS_2,"");
        String action = phrase.replaceFirst(RegexStrings.REGEX_REPLACE_CONFIRM_AGENDAMENTO_ACTION, "");
        String day = phrase.replaceFirst(RegexStrings.REGEX_REPLACE_CONFIRM_AGENDAMENTO_DAY,"");
        String frase = "Action: ["+ action + "] "+" Hours: ["+ hours_2 +"].";

        try {
            FileWriter arquivo = new FileWriter("/data/data/assistant.alfred/files/" + fileName, true);
            PrintWriter gravarArq = new PrintWriter(arquivo);
            gravarArq.println(frase);
            gravarArq.close();
        } catch (Exception e) {
            e.printStackTrace();
            messageController.createMessage(e.toString(), 2);
            messageController.createMessage("erro  aqui", 2);
        }
    }

    public void verifyFiles(){
            String[] files = new String[7];
            files[0] = "domingo.txt";
            files[1] = "segunda.txt";
            files[2] = "terça.txt";
            files[3] = "quarta.txt";
            files[4] = "quinta.txt";
            files[5] = "sexta.txt";
            files[6] = "sábado.txt";


            for (String file: files) {
                try {
                    FileWriter arquivo = new FileWriter("/data/data/assistant.alfred/files/" + file);
                    arquivo.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    messageController.createMessage(e.toString(), 2);
                }
            }
        }



}