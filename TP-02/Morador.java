import java.util.Date;

public class Morador extends Cidadao {

    //Atributos de Morador
    private Livro[] livro_alugados = new Livro[2];
    public int numero_do_livro_M = 0;

    //Getter e Setter para livros
    public Livro[] getLivro_alugados() {return livro_alugados;}
    public void setLivro_alugados(Livro[] livro_alugados) {this.livro_alugados = livro_alugados;}

    //Construtor para Morador
    public Morador(String nome_cliente, String cpf_cliente, Date data_nascimento, int id) {
        super(nome_cliente, cpf_cliente, data_nascimento, id);
    }
    //Funcao polimorfica para receber os livros
    public void adiciona_livro(Livro livro_recebido) {
        System.out.println(livro_recebido);
        if (numero_do_livro_M < livro_alugados.length) {
            livro_alugados[numero_do_livro_M] = livro_recebido;
            System.out.println(numero_do_livro_M);
            numero_do_livro_M++;
            setNumLivros(getNumLivros() + 1);
            System.out.println("Empréstimo realizado com sucesso");

            livro_recebido.setEmprestado(true);
        } else {
            livro_recebido.setEmprestado(false);
            System.out.println("Limite de empréstimos alcançado");
            System.out.println("Para um novo empréstimo é necessário a realização de uma devolução");
        }
    }


    public boolean devolver_livro(int indiceLivro) {
        if (indiceLivro >= 0 && indiceLivro < numero_do_livro_M) {
            livro_alugados[indiceLivro].setEmprestado(false);
            for (int i = indiceLivro; i <= numero_do_livro_M - 1; i++) {
                livro_alugados[i] = livro_alugados[i + 1];
            }
            livro_alugados[numero_do_livro_M - 1] = null;
            numero_do_livro_M--;
            setNumLivros(getNumLivros() - 1);
            System.out.println("Devolução realizada com sucesso.");
            return true;
        } else {
            return false;
        }
    }




    //funcao polimorfica como método de proteção dos dados
    public boolean pegar_livro(boolean sinal_recebido)
    {
       if(sinal_recebido)
       {
            return sinal_recebido;
       }
       else
       {
            return sinal_recebido;
       }
    }
    //funcao polimorfica de imprimir dados do Morador
    public void imprimi_cidadao()
    {
        System.out.println("Nome : " + getNome_cliente());
        System.out.println("cpf : " + getCpf_cliente());
        System.out.println("Data de Nascimento : " + getData_nascimento() );
        System.out.println("Id: " + getId());
    }

    public void imprimir_livros_do_usuario() {
        System.out.println("Numero de livros: " + numLivros);
        for (int i = 0; i < numLivros; i++) {
            System.out.println("-------------------------------");
            System.out.println("Livro " + (i + 1) + ": ");
            System.out.println("-------------------------------");
            livro_alugados[i].imprimir_livros_cidadao();
            System.out.println("-------------------------------");
        }
    }
}
