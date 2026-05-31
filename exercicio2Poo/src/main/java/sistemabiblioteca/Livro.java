package sistemabiblioteca;

import java.util.Objects;

public class Livro {
    private String nome;
    private String autor;
    private String categoria;
    private int anoDePublicacao;
    private String editora;
    private String idioma;
    private int quantPaginas;
    private boolean disponivel = true;

    public Livro(String nome, String autor, String categoria, int anoDePublicacao,
                 String editora, String idioma, int quantPaginas){
        this.nome = nome;
        this.autor = autor;
        this.categoria = categoria;
        this.anoDePublicacao = anoDePublicacao;
        this.editora = editora;
        this.idioma = idioma;
        this.quantPaginas = quantPaginas;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getQuantPaginas() {
        return quantPaginas;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public boolean isDisponivel(){
        return this.disponivel;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nAutor: " + autor +
                "\nCategoria: " + categoria +
                "\nAno de publicação: " + anoDePublicacao +
                "\nEditora: " + editora +
                "\nIdioma: " + idioma +
                "\nQuantidade de páginas: " + quantPaginas +
                "\nStatus: " + (disponivel ? "Disponível para empréstimo" : "Emprestado");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return anoDePublicacao == livro.anoDePublicacao && Objects.equals(nome, livro.nome) && Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, autor, anoDePublicacao);
    }


}

