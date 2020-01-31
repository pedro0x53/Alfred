# Alfred
## Assistente de Voz

  O Alfred é um assistente virtual, que pode ser ativado por comandos de voz. Desenvolvido pelos alunos Moyses Miranda, João Sousa, no IFCE Campus Maracanaú, utilizando a linguagem de programação Java, durante o 3º semestre do curso de Ciência da Computação.
  Com o objetivo princiapl do “Projeto Alfred” é aplicar conceitos de OO, inicialmente, não utilizará banco de dados e estará disponível apenas para o Sistema Operacional Android 6.0 ou superior.


### OBJETIVOS

1. Desenvolver um assistente virtual capaz de auxiliar o usuário com tarefas simples.
1. Utilizar uma estrutura o mais simples possível para a estrutura do projeto, assim qualquer programados independente de seu nível, conseguirá adicionar novas funções.
1. Aplicar os conceitos de POO aprendidos durante o semestre.


### ESTRUTURA
  
  Utilizadno uma estrutura focada, para que o projeto seja compreendido por alunos de todos os níveis.

  O layout segue, basicamente, o mesmo estilo dos assistentes existentes, um chat que exibe as mensagens trocadas entre usuário e asistente, atravás dos comandos solicitados.

  O projeto foi dividido em 3 tripos de classes: Principais, Controladoras e Utilidades.
  
  #### Principal
  - Assistente, objeto principal, onde as funções predefinidas estão localizadas.
  - MainActivity, tela principal, inicialização do assistente e função dos botõesde microfone e menu
 
 #### Controladoras
 - ActivityController, responsável por criar todas as atividades, iniciar o microfone ou executar outro aplicativo, durante a execução das funções.
 - MessageController, responsável por criar mensagens e definir o seu layout, seja uma requisição do usuário ou uma resposta do assistente.
 - RegexController, resnsável por processar os comandos de voz reconhecidos a partir das expressões regulares definidas em Utils/RegexStrings.java
 
 #### Utilidades
 - Strings, classe onde todas as strings, estáticas e dinâmicas, devem ser definidas.
 - RegexStrings, classe onde todas as expressoes regulares devem ser definidas.
 
 
### COMO FUNCIONA?
  
  O fluxo principal da aplicação é definido por: ouvir a solicitação > processar o texto > executar a função
  O sistema utiliza da biblioteca de reconhecimento de voz padão do Android, que funciona como uma activity, retornando um etor de strings com as possíveis frases identificadas no resultado da atividade (onActivityResult).

  Para adicionar novas funções é necessário alterar alguns poucos arquivos, para a compreensão completa sobre o fluxo de processamento siga essa ordem abaixo:

  1. Utils/RegexStrings.java, uma espressão regular que identifica o padrão da frase para a acionar a nova função, deverá ser adicionada.
  1. Controllers/RegexController.java novo condicional, definido um novo código de resposta, que deve ser um inteiro, a variável "req" deve ser sempre retornada como segundo valor do vetor "res".
  1. Assistente.java, na função process(), um novo case deve ser adicionado de acordo com o código definido em Controller/RegexController.java. A nova função também deve ser adicionanda nesse arquivo, tendo como parametro a variável "listen", caso haja a necessidade de procesar o texto internamente.
