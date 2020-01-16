package assistant.alfred.Utils;

public class Strings {
    public static String
            GREETEING = "Olá! Qual o seu nome?",
            ERROR = "Desculpe, não consegui entender, pode repetir?";

    public static String STARTING_APP(String APP_NAME){
        return "Iniciando " + APP_NAME;
    }
    public static String STARTING_APP_FAILED(String APP_NAME){
        return "Ops! Não foi possível encontrar o app " + APP_NAME;
    }
}
