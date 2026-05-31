package sistemabiblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = -1;

        while (opcao != 0){
            try{
                System.out.println("""
                       ==========================================
                        Bem vindo ao Sistema da Biblioteca!\s
                        Digite a opção desejada:
                        1 - Adicionar livro
                        2 - Pesquisar livro
                        3 - Remover livro
                        4 - Emprestar livro
                        5 - Devolver livro
                        0 - Sair
                       ==========================================""");
                opcao = sc.nextInt();
                sc.nextLine();
                if (opcao == 1){
                    System.out.println("Digite o nome do livro: ");
                    String nome = sc.nextLine();
                    System.out.println("Informe o nome do autor: ");
                    String autor = sc.nextLine();
                    System.out.println("Informe a categoria: ");
                    String categoria = sc.nextLine();
                    System.out.println("Informe o ano de publicação: ");
                    int anoDePublicacao = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Informe a editora: ");
                    String editora = sc.nextLine();
                    System.out.println("Informe o idioma: ");
                    String idioma = sc.nextLine();
                    System.out.println("Informe a quantidade de páginas");
                    int quantPaginas = sc.nextInt();
                    sc.nextLine();

                   biblioteca.adicionarLivro(nome, autor,categoria, anoDePublicacao, editora, idioma, quantPaginas);
                }
                else if (opcao == 2) {
                    System.out.println("Digite o nome do livro que deseja pesquisar: ");
                    String nome = sc.nextLine();
                    Livro resultado = biblioteca.buscarLivro(nome);
                    System.out.println("Livro encontrado!\n" + resultado);
                }
                else if (opcao == 3) {
                    System.out.println("Digite o nome do livro que deseja remover: ");
                    String nome = sc.nextLine();
                    biblioteca.removerLivro(nome);
                    System.out.println("Livro removido com sucesso!");
                }
                else if (opcao == 4) {
                    System.out.println("Digite o nome do livro que deseja pegar emprestado: ");
                    String nome = sc.nextLine();
                    biblioteca.emprestarLivro(nome);
                }
                else if (opcao == 5) {
                    System.out.println("Digite o nome do livro que deseja devolver: ");
                    String nome = sc.nextLine();
                    biblioteca.devolverLivro(nome);
                }
                else if (opcao == 0) {
                    System.out.println("Saindo do sistema. Até logo!");
                }
                else {
                    System.out.println("Opção inválida, tente novamente!");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Opção inválida!");
                sc.nextLine();
            }catch (LivroJaExisteException e) {
                System.out.println(e.getMessage());
            } catch (LivroNaoEncontradoException e) {
                System.out.println(e.getMessage());
            }

        }


    }


}
