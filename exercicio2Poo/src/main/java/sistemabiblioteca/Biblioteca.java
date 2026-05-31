package sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca(){
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String nome, String autor, String categoria, int anoDePublicacao,
                               String editora, String idioma, int quantPaginas) throws LivroJaExisteException{

        Livro livro = new Livro(nome, autor, categoria, anoDePublicacao, editora, idioma, quantPaginas);
        if (this.livros.contains(livro)) {
            throw new LivroJaExisteException("O livro já está cadastrado!");
        }
        livros.add(livro);
    }

    public Livro buscarLivro(String nome) throws LivroNaoEncontradoException{

        for (Livro l : livros) {
            if (l.getNome().equals(nome)){
                return l;
            }
        }throw new LivroNaoEncontradoException("O livro pesquisado não encontrado!");
    }

    public void removerLivro(String nome) throws LivroNaoEncontradoException{
        for (Livro l : livros) {
            if (l.getNome().equals(nome)){
                livros.remove(l);
                return;
            }
        }throw new LivroNaoEncontradoException("Livro não encontrado ou já removido!");

    }
    public void emprestarLivro(String nome) throws LivroNaoEncontradoException {
        Livro livro = buscarLivro(nome);
        if (!livro.isDisponivel()) {
            throw new LivroNaoEncontradoException("Este livro já está emprestado!");
        }
        livro.setDisponivel(false);
        System.out.println("Livro '" + livro.getNome() + "' emprestado com sucesso!");
    }

    public void devolverLivro(String nome) throws LivroNaoEncontradoException {
        Livro livro = buscarLivro(nome);
        if (livro.isDisponivel()) {
            throw new LivroNaoEncontradoException("Este livro já está disponível!");
        }
        livro.setDisponivel(true);
        System.out.println("Livro '" + livro.getNome() + "' devolvido com sucesso!");
    }




}
