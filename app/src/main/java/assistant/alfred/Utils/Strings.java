package assistant.alfred.Utils;

public class Strings {
    public static String
            GREETEING = "Olá! Qual o seu nome?",
            ERROR = "Desculpe, não consegui entender, pode repetir?",

    //tutorial:
            SALUTATION = "Oi, meu nome é Alfred, sou seu mais novo assistente de voz.\n",
            TUTORIAL =  "Minhas funcionalidades são adicionadas e atualizadas a cada patch de atualização, pelos meus desenvolvedores.\n" +
                        "Eu possuo dois tipos de funções, simples e compostas. As funções simples são ativadas com uma simples frase.\n" +
                        "As funções compostas possuem instruições dentro delas quando convocadas.\n",
            NAMES_FUNCTIONS=  "Funções Disponiveis: \n" +
                        "Para abrir algum aplicativo, fale:\n  ºAbrir NOME DO APLICATIVO.\n" +
                        "Para organizar suas tarefas, fale :\n  ºModo agendamento.",

    //agendamento:
            STARTING_AGENDAMENTO = "Modo Agendamento",
            SELECTION_OPTIONS_AGENDAMENTO = "Para Agendar fale:\n  ºAção ás Horas de Dia da Semana.\n" +
                                            "Para Ver Agendamentos fale:\n  ºVer Agendamentos de Dia da Semana.\n" +
                                            "Sair Modo Agendamento fale:\n  ºCancelar modo agendamento.",
            CONFIRMED_AGENDAMENTO = "Agendamento confirmado.",
            OPTION_VER_AGENDAMENTOS="Opção VER AGENDAMENTO selecionada",
            VER_AGENDAMENTO = "Fale o dia da semana que deseja ver agendamentos.",
            TUTORIAL_AGENDAMENTO = "Fale: 'AÇÂO ás HORAS de DIA DA SEMANA'";



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

