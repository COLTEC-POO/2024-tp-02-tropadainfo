public class Livro {
    
    //atributos dos livros
    private String titulo;
    private boolean emprestado;
    private String autor;
    private int ano_de_publicacao;
    private String editora;
    public boolean indicador_livro;
   

    public Livro(String titulo, String autor, int ano_de_publicacao, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano_de_publicacao = ano_de_publicacao;
        this.editora = editora;

    }

    //metodo Getter sendo criado para titulo pois assim é possivel acessarmos apenas o titulo e exibirmos em nossa biblioteca
    public String getTitulo() {return titulo;}

    public boolean isEmprestado() {return emprestado;}
    
    public void setEmprestado(boolean emprestado) {this.emprestado = emprestado;} 

    //metodo de impressão detalhada sobre cada um dos livros e implementacao de uma verificacao se o livro esta ou nao emprestado//
    public void imprimir_livros_pub()
    {
        if(!emprestado) {
            System.out.println("Titulo: " + this.titulo);
            System.out.println("Autor: " + this.autor);
            System.out.println("Ano: " + this.ano_de_publicacao);
            System.out.println("Editora: " + this.editora);
        } else {
            System.out.println("Livro atualmente emprestado");
            System.out.println("Indisponivel pra emprestimos");
        }
    }

    public void imprimir_livros_cidadao(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano: " + this.ano_de_publicacao);
        System.out.println("Editora: " + this.editora);
    }
    
}
