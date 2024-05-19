import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Biblioteca
{
    //atributos da classe Biblioteca
    public static Scanner sc = new Scanner(System.in);
    public Livro[] livros;
    public static int numLivros = 0;
    public Cidadao[] cidadaos;
    public String nome;
    //indices para o numero de representantes de cada classe
    //Livros
    public int quantia_de_livros_cadastrados = 0;
    //Pessoas (moradores) / (alunos) / (professores)
    public int numero_de_moradores_biblioteca = 0;
    public int numero_de_alunos_biblioteca = 0;
    public int numero_de_professores_biblioteca = 0;
    public int numero_de_cidadaos = 0;


    //funcao de cadastrar livros na biblioteca
    public void cadastrar_livro(int num)
    {

        //variaveis locais para enviar ao construtor
        String titulo_livro ;
        String autor ;
        int ano_publi ;
        String editora ;

        //cadastro de um livro localmente
        System.out.println("Qual é o titulo do livro recebido:");
        sc.nextLine();
        titulo_livro = sc.nextLine();

        System.out.println("Digite o nome do autor deste livro:");
        autor = sc.nextLine();

        System.out.println("Digite o ano de publicacão desta obra:");
        ano_publi = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite a editora na qual publicou este livro:");
        editora = sc.nextLine();

        //Deixando o livro como disponivel

        //envio dos dados ao construtor na Classe Livro
        livros[num] = new Livro(titulo_livro , autor , ano_publi , editora);
        livros[num].setEmprestado(false);
        numLivros++;

        //impressao para checagem de dados

        System.out.println("-----------------------");
        System.out.println("Livro cadastrado com Sucesso");
        System.out.println("---------------------------");
        livros[num].imprimir_livros_pub();
        System.out.println("---------------------------");


    }

    public void cadastrar_cidadao() {
        //Variaveis locais que serão enviadas ao construtor
        String nome;
        String cpf;
        Date data_de_nascimento = null;
        String data_obitda;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // o Id = numero_cidadaos + 1 //

        //variaveis de escolha
        int tipo_de_cidadao;
        int opcao_cadastro;
        System.out.println("Bem vindo a nossa biblioteca, " + this.nome + " !!!");
        System.out.println("Vamos começar seu cadastro?");
        System.out.println("[1] Sim || [0] Não");

        opcao_cadastro = sc.nextInt();

        if (opcao_cadastro == 1) {
            System.out.println("Digite qual tipo de cidadao você é :");
            System.out.println("[1] - Morador");
            System.out.println("[2] - Aluno ");
            System.out.println("[3] - Professor");
            tipo_de_cidadao = sc.nextInt();

            switch (tipo_de_cidadao) {
                case 1:
                    //coleta de dados
                    System.out.println("Digite seu nome: ");
                    sc.nextLine();
                    nome = sc.nextLine();

                    System.out.println("Digite seu cpf: ");
                    cpf = sc.nextLine();

                    System.out.println("Digite sua data de nascimento dd/MM/yyyy");
                    data_obitda = sc.nextLine();

                     //captura da data atraves do uso do try & catch

                    try {

                        data_de_nascimento = sdf.parse(data_obitda);
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Use dd/MM/yyyy. Tente novamente...");
                        break;
                    }


                    //declaracao do array de forma polimorfica
                    cidadaos[numero_de_cidadaos] = new Morador(nome, cpf, data_de_nascimento, (numero_de_cidadaos + 1));
                    //Checkagem dos dados
                    System.out.println("-------------------------");
                    System.out.println("Cadastro realizado com sucesso :");
                    cidadaos[numero_de_cidadaos].imprimi_cidadao();
                    System.out.println("------------------------");
                    numero_de_cidadaos++;
                    numero_de_moradores_biblioteca++;

                    break;

                case 2:
                    //variavel local de aluno

                    String escola;

                    //coleta de dados
                    System.out.println("Digite seu nome : ");
                    sc.nextLine();
                    nome = sc.nextLine();

                    System.out.println("Digite seu cpf : ");
                    cpf = sc.nextLine();

                    System.out.println("Digite o nome da escola na qual voce esta matriculado : ");
                    escola = sc.nextLine();

                    System.out.println("Digite sua data de nascimento dd/MM/yyyy");
                    data_obitda = sc.nextLine();

                     //captura da data atraves do uso do try & catch

                    try {
                        data_de_nascimento = sdf.parse(data_obitda);
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Use dd/MM/yyyy.Tente novamente...");
                        break;
                    }

                    //declaracao do array
                    cidadaos[numero_de_cidadaos] = new Aluno(nome, cpf, data_de_nascimento, (numero_de_cidadaos + 1), escola);
                    //Checagem de dados
                    System.out.println("-----------------------");
                    System.out.println("Cadastro realizado com sucesso :");

                    cidadaos[numero_de_cidadaos].imprimi_cidadao();
                    System.out.println("-----------------------");

                    numero_de_cidadaos++;
                    numero_de_alunos_biblioteca++;

                    break;
                case 3:
                    //variavel exclusiva de professores
                    String formacao;

                    System.out.println("Digite seu nome : ");
                    sc.nextLine();
                    nome = sc.nextLine();

                    System.out.println("Digite seu cpf : ");
                    cpf = sc.nextLine();

                    System.out.println("Digite o grau de formacao na qual voce se encontra : ");
                    formacao = sc.nextLine();

                    System.out.println("Digite sua data de nascimento dd/MM/yyyy");
                    data_obitda = sc.nextLine();

                    //captura da data atraves do uso do try & catch
                    try {
                        data_de_nascimento = sdf.parse(data_obitda);
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Use dd/MM/yyyy.Tente novamente...");
                        break;
                    }

                    //declaracao do array
                    cidadaos[numero_de_cidadaos] = new Professor(nome, cpf, data_de_nascimento, (numero_de_cidadaos + 1), formacao);
                    //Checagem de dados
                    System.out.println("----------------------");
                    System.out.println("Cadastro realizado com sucesso :");
                    cidadaos[numero_de_cidadaos].imprimi_cidadao();
                    System.out.println("---------------------------:");
                    numero_de_cidadaos++;
                    numero_de_professores_biblioteca++;
                    break;

                default:
                    System.out.println("piadista você , caso realmente queira ser cadastrado aqui na biblioteca tente novamente");
                    break;
            }
        } else if (opcao_cadastro == 0) {
            System.out.println("Encerrando...");

        } else {
            System.out.println("Opcao Invalida , tente novamente...");
        }
    }

    //realizacao dos emprestimos de nossa biblioteca
    public void realizar_emprestimo()
    {
        //variavel para que seje possivel fazer os emprestimos
        int opcao_de_emprestimo;
        int numero_do_livro;
        int id_passado;
        int idLido;
        int indice = 0;
        boolean idValido = false;

        if(numLivros < 1) {
            System.out.println("Nao ha livros disponiveis para emprestimo.");
        } else if (numero_de_cidadaos < 1) {
            System.out.println("E necessario realizar seu cadastro primeiro.");
        } else {
            System.out.println("Vamos comecar o emprestimo de um livro!!!");
            System.out.println("Abaixo segue a lista dos livros disponiveis para o emprestimo : ");
            //mostra os livros disponiveis
            mostrar_livros_da_biblioteca();

            System.out.println("Voce deseja fazer o emprestimo de algum destes livros ? ");
            System.out.println("Se sim digite [1]");
            System.out.println("Se nao digite [2]");
            opcao_de_emprestimo = sc.nextInt();

            if (opcao_de_emprestimo == 1) {
                System.out.println("Digite o seu Id de registro na biblioteca : ");
                id_passado = sc.nextInt();
                for(int i = 0; i < numero_de_cidadaos; i++) {
                    idLido = cidadaos[i].getId();

                    if(idLido == id_passado){
                        idValido = true;
                        indice = i;
                        break;
                    }
                }

                if(idValido) {
                    System.out.println("Digite o numero do livro no qual voce quer fazer o emprestimo : ");
                    numero_do_livro = (sc.nextInt() - 1);

                    if (livros[numero_do_livro].isEmprestado()) {
                        livros[numero_do_livro].indicador_livro = false;
                    } else {
                        livros[numero_do_livro].indicador_livro = true;
                    }

                    if (livros[numero_do_livro].indicador_livro) {
                        System.out.println(indice);
                        cidadaos[indice].adiciona_livro(livros[numero_do_livro]);
                        System.out.println(livros[numero_do_livro]);
                    } else {
                        System.out.println("Este livro ja esta emprestado, tente alugar outro");

                    }
                } else System.out.println("Nao foi possivel fazer o emprestimo, id invalido.");

            } else if (opcao_de_emprestimo == 2) {
                System.out.println("Encerrando o processo de emprestimo...");
            } else {
                System.out.println("Opcao invalida , tente novamente...");
            }
        }
    }

    public void realizar_devolucao()
    {
        int opcao_de_devolucao;
        int livroDevolver;
        int id_passado;
        int idLido;
        int indice = 0;
        boolean idValido = false;


        System.out.println("Vamos comecar a devolucao de um livro !!!");
        System.out.println("Se sim digite [1]");
        System.out.println("Se nao digite [2]");

        opcao_de_devolucao = sc.nextInt();

        if(opcao_de_devolucao == 1)
        {
           System.out.println("Digite seu id.");
           id_passado = sc.nextInt();

           for(int i = 0; i < numero_de_cidadaos; i++) {
                idLido = cidadaos[i].getId();

                if(idLido == id_passado){
                    idValido = true;
                    indice = i;
                    break;
                }
           }

           if(idValido) {
               cidadaos[indice].imprimir_livros_do_usuario();

               System.out.println("Qual dos livros deseja devolver?");
               livroDevolver = sc.nextInt();
               if(!cidadaos[indice].devolver_livro(livroDevolver - 1)) System.out.println("indice de livro inválido.");
           } else System.out.println("Id invalido.");
        }
        else if(opcao_de_devolucao == 2)
        {
            System.out.println("Encerrando o processo de devolucao...");
        }
        else
        {
            System.out.println("Opcao invalida, tente novamente... ");
        }

    }

   public void mostrar_livros_da_biblioteca()
   {

        for(int i = 0; i < numLivros; i++){
            System.out.println("------------------------");
            System.out.println("Livro " + (i + 1));
            System.out.println("---------------------------");
            livros[i].imprimir_livros_pub();
            System.out.println("---------------------------");

    }
   }
   public static void main(String [] args)
   {
        Biblioteca biblioteca;
        int opcao;
        biblioteca = new Biblioteca();
        biblioteca.nome = "Desinformados";
        //declaracao de livro
        biblioteca.livros = new Livro[1000];
        //declaracao dos cidadaos
        biblioteca.cidadaos = new Cidadao[1000];

        do
        {

            //informacoes de uso
            System.out.println("-------------------------------------------------------------------");
            System.out.println("BILBIOTECA :  " + biblioteca.nome);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("DIGITE OS SEGUINTES NUMEROS PARA :");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("[1] -- CADASTRO DE CLIENTES");
            System.out.println("[2] -- CADASTRO DE LIVROS");
            System.out.println("[3] -- EMPRESTIMO");
            System.out.println("[4] -- DEVOLUCAO");
            System.out.println("[5] -- LIVROS DISPONIVEIS PARA EMPRESTIMO");
            System.out.println("[0] -- SAIR");

            opcao = sc.nextInt();

            //case para escolha da funcao
            switch (opcao) {
                case 0:
                System.out.println("Encerrando...");
                break;
                case 1:
                    biblioteca.cadastrar_cidadao();
                    break;

                case 2:
                    biblioteca.cadastrar_livro(biblioteca.quantia_de_livros_cadastrados);
                    biblioteca.quantia_de_livros_cadastrados++;
                    break;

                case 3:
                    biblioteca.realizar_emprestimo();
                    break;

                case 4:
                    biblioteca.realizar_devolucao();
                    break;

                case 5:
                    biblioteca.mostrar_livros_da_biblioteca();
                    break;

                default:
                    System.out.println("Comando inexistente , tente novamente");
                    break;
            }

        }while(opcao != 0);

   }
}