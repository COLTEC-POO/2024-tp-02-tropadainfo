import java.util.Date;

public class Professor extends Cidadao {




    //atributos exclusivos de Professor(subclasse de Cidadao)
    private String formacao;
    private Livro[] livro_alugados = new Livro[10];
    public int numero_do_livro_P = 0;

    //getter para os livros alugados deste Professor




     //Construtor de Professor
     public Professor(String nome_cliente, String cpf_cliente, Date data_nascimento, int id, String formacao)
     {
        super(nome_cliente, cpf_cliente, data_nascimento, id);
        this.formacao = formacao;
     }
     //funcao polimorfica para a obtencao de livros
    public void adiciona_livro(Livro livro_recebido)
    {

            if(numero_do_livro_P < livro_alugados.length){
                livro_alugados[numero_do_livro_P] = livro_recebido;
                numero_do_livro_P++;
                setNumLivros(getNumLivros() + 1);
                System.out.println("Emprestimo realizado com sucesso");

                livro_recebido.setEmprestado(true);

            }
            else
            {

                livro_recebido.setEmprestado(false);
                System.out.println("Limite de emprestimos alcancados");
                System.out.println("Para um novo emprestimo é nescessario a realizacao de uma devolucao");


            }
    }

    public boolean devolver_livro(int indiceLivro) {
        if (indiceLivro >= 0 && indiceLivro < numero_do_livro_P) {
            livro_alugados[indiceLivro].setEmprestado(false);
            for (int i = indiceLivro; i <= numero_do_livro_P - 1; i++) {
                livro_alugados[i] = livro_alugados[i + 1];
            }
            livro_alugados[numero_do_livro_P - 1] = null;
            numero_do_livro_P--;
            setNumLivros(getNumLivros() - 1);
            System.out.println("Devolução realizada com sucesso.");
            return true;
        } else {
            System.out.println("Índice de livro inválido.");
            return false;
        }
    }


    //funcao polimorfica como método de proteção dos dados
    public boolean pegar_livro(boolean sinal_recebido)
    {
       if(sinal_recebido == true)
       {
            return sinal_recebido;
       }
       else
       {
            return sinal_recebido;
       }
    }
    //funcao polimorfica de imprimir dados do Professor
     public void imprimi_cidadao()
     {
         System.out.println("Nome : " + getNome_cliente());
         System.out.println("cpf : " + getCpf_cliente());
         System.out.println("Data de Nascimento : " + getData_nascimento() );
         System.out.println("Id: " + getId());
         System.out.println("Formacao : " + this.formacao);
     }

    public void imprimir_livros_do_usuario() {
        System.out.println("Numero de livros: " + numLivros);
        for (int i = 0; i < numLivros; i++) {
            System.out.println("-------------------------------");
            System.out.println("Livro " + (i + 1) + ": ");
            livro_alugados[i].imprimir_livros_cidadao();
            System.out.println("-------------------------------");
        }
    }
}
