package br.ufpb.dcx.amigosecreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();

        System.out.println("Digite a quantidade de amigos: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Nome do amigo " + (i + 1) + ": ");
            String nome = sc.nextLine();
            System.out.println("Email do amigo " + (i + 1) + ": ");
            String email = sc.nextLine();
            try {
                sistema.cadastraAmigo(nome, email);
            } catch (AmigoJaExisteException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Digite o email de quem vai ter o amigo secreto configurado: ");
        String emailPessoa = sc.nextLine();
        System.out.println("Digite o email do amigo secreto sorteado: ");
        String emailSorteado = sc.nextLine();
        try {
            sistema.configuraAmigoSecretoDe(emailPessoa, emailSorteado);
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Digite o email do remetente: ");
        String emailRemetente = sc.nextLine();
        System.out.println("Digite o texto da mensagem: ");
        String texto = sc.nextLine();
        System.out.println("A mensagem é anônima? (true/false): ");
        boolean anonima = sc.nextBoolean();
        sistema.enviarMensagemParaTodos(texto, emailRemetente, anonima);

        System.out.println("Mensagem enviada com sucesso!");
        sc.close();
    }
}