package assistant.alfred.Utils;

public class RegexStrings {
    public static String
            REGEX_START_LISTEN = "^(?i)(ei alfred|olá alfred|oi alfred|alfred)$",
            REGEX_RUN_APP = "^(?i)(.)*(iniciar|inicie|execute|executar|abrir)( o)? ([a-z0-9]*)$",
            REGEX_VER_AGENDAMENTO = "^(?i)(ver agendamento)",
            REGEX_REPLACE_RUN_APP = "(?i)(.)*(iniciar|inicie|execute|executar|abrir)( o)? ",
            REGEX_REPLACE_MODO_AGENDAMENTO = "^(?i)(agendamento|modo agendamento)",
            REGEX_REPLACE_AGENDAMENTO = "^(?i)agendar",
            REGEX_EXIT_FUNCTIONS = "^(?i)(sair|cancelar|desligar) (modo agendamento|agendamento)",
            REGEX_VER_AGENDAMENTO_DAY = "ver agendamento de (segunda|segunda feira|segunda-feira|terça|terça feira|terça-feira|quarta|quarta feira|quarta-feira|quinta|quinta feira|quinta-feira|sexta|sexta feira|sexta-feira|sábado|domingo)",
            REGEX_REPLACE_DAYS = "ver agendamento de ",
            REGEX_CONFIRM_AGENDAMENTO= "(.)* (ás|às) (([01]?[0-9]|2[0-3]):[0-5][0-9]|([01]?[0-9]|2[0-3])) (horas de|hora de| de) (segunda|segunda feira|segunda-feira|terça|terça feira|terça-feira|quarta|quarta feira|quarta-feira|quinta|quinta feira|quinta-feira|sexta|sexta feira|sexta-feira|sábado|domingo)",
            REGEX_REPLACE_CONFIRM_AGENDAMENTO_ACTION = " (ás|às) (([01]?[0-9]|2[0-3]):[0-5][0-9]|([01]?[0-9]|2[0-3])) (horas de|hora de| de) (segunda|segunda feira|segunda-feira|terça|terça feira|terça-feira|quarta|quarta feira|quarta-feira|quinta|quinta feira|quinta-feira|sexta|sexta feira|sexta-feira|sábado|domingo)",
            REGEX_REPLACE_CONFIRM_AGENDAMENTO_HOURS_1 = "(.)* (ás|às) ",
            REGEX_REPLACE_CONFIRM_AGENDAMENTO_HOURS_2 = " (horas de|hora de| de) (segunda|segunda feira|segunda-feira|terça|terça feira|terça-feira|quarta|quarta feira|quarta-feira|quinta|quinta feira|quinta-feira|sexta|sexta feira|sexta-feira|sábado|domingo)",
            REGEX_REPLACE_CONFIRM_AGENDAMENTO_DAY = "(.)* (ás|às) (([01]?[0-9]|2[0-3]):[0-5][0-9]|([01]?[0-9]|2[0-3])) (horas de|hora de| de) ";

}
