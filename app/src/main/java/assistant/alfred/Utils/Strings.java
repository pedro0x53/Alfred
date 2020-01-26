package assistant.alfred.Utils;

public class Strings {
    public static String
            ERROR = "Desculpe, não consegui entender, pode repetir?",

    // Agendamento:
            STARTING_AGENDAMENTO = "Modo Agendamento",
            SELECTION_OPTIONS_AGENDAMENTO = "Para Agendar fale:\nNOME DO EVENTO ás HORA de DIA DA SEMANA.\n" +
                                            "Para Ver Agendamentos fale:\n- Ver Agendamentos de Dia da Semana.\n" +
                                            "Sair Modo Agendamento fale:\n- Cancelar modo agendamento.",
            CONFIRMED_AGENDAMENTO = "Agendamento confirmado.",
            OPTION_VER_AGENDAMENTOS="Opção VER AGENDAMENTO selecionada",
            VER_AGENDAMENTO = "Fale o dia da semana que deseja ver agendamentos.",
            TUTORIAL_AGENDAMENTO = "Fale: 'AÇÃO ás HORAS de DIA DA SEMANA'";

    // Tutorial
    public static String[] TUTORIAL = {
            "Oi, meu nome é Alfred, sou seu mais novo assistente de voz.",
            "Minhas funcionalidades são adicionadas e atualizadas a cada patch de atualização, pelos meus desenvolvedores.",
            "Eu possuo dois tipos de funções, simples e compostas.",
            "As funções simples são ativadas com uma simples frase.",
            "As funções compostas possuem instruições dentro delas quando convocadas.",
            "Funções Disponiveis: ",
            "[SIMPLES] Para abrir algum aplicativo, fale: \nAbrir/Iniciar/Executar o NOME DO APLICATIVO.",
            "[COMPOSTA] Para organizar suas tarefas, fale: \n\"Modo agendamento\" e siga as instruções."
    };

    // Strings dinamicas
    public static String STARTING_APP(String APP_NAME){
        return "Iniciando " + APP_NAME;
    }
    public static String STARTING_APP_FAILED(String APP_NAME){
        return "Ops! Não foi possível encontrar o app " + APP_NAME;
    }
    public static String Exit(String FUNCTION_NAME){
        return "Saindo: " + FUNCTION_NAME;
    }

}

