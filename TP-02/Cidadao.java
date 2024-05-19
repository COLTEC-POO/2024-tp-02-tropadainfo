import java.util.Date;

public class Cidadao {

    //variaveis da Super classe Cidadao, no qual é o usuario primitivo da bliblioteca
    protected String nome_cliente;
    protected String cpf_cliente;
    protected Date data_nascimento;
    protected int id;
    protected Livro[] livro_alugados = new Livro[2];
    protected int numLivros = 0;





    //Construtor da Super Classe
    public Cidadao(String nome_cliente, String cpf_cliente, Date data_nascimento, int id) {
        this.nome_cliente = nome_cliente;
        this.cpf_cliente = cpf_cliente;
        this.data_nascimento = data_nascimento;
        this.id = id;

    }
    //metodo para obtencao do atributo de livros_alugados
    public void adiciona_livro(Livro livro_recebido) {}
    //Funcao da superclasse
    public void imprimi_cidadao()
    {
        System.out.println("Nome : " + this.nome_cliente);
        System.out.println("cpf : " + this.cpf_cliente);
        System.out.println("Data de Nascimento : " + this.data_nascimento);
        System.out.println("Id: " + this.id);
    }

    public int aprova_livro(int d)
    {
        return d;
    }

    //Getters e Setter principais//
    public String getNome_cliente() {return nome_cliente;}
    public void setNome_cliente(String nome_cliente) {this.nome_cliente = nome_cliente;}
    public int getNumLivros() {return numLivros;}
    public void setNumLivros(int numLivros) {this.numLivros = numLivros;}
    public String getCpf_cliente() { return cpf_cliente;}
    public void setCpf_cliente(String cpf_cliente) { this.cpf_cliente = cpf_cliente;}
    public Date getData_nascimento() {return data_nascimento;}
    public void setData_nascimento(Date data_nascimento) {this.data_nascimento = data_nascimento; }
    public int getId() {return id;}
    //Getter e Setter para livros//
    public Livro[] getLivro_alugados() {return livro_alugados;}
    public void setLivro_alugados(Livro[] livro_alugados) {this.livro_alugados = livro_alugados;}

    //metodos desta classe

    public boolean pegar_livro()
    {
       return true;
    }

    public boolean devolver_livro(int indiceLivro) {
        return false;
    }

    public void imprimir_livros_do_usuario() {
    }

}
