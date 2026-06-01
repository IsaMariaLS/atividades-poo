package br.ufpb.dcx.amigosecreto;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        try {
            sistema.cadastraAmigo("José", "jose@email.com");
            sistema.cadastraAmigo("Maria", "maria@email.com");

            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");

            sistema.enviarMensagemParaAlguem("Oi José!", "maria@email.com", "jose@email.com", true);

            sistema.enviarMensagemParaTodos("Feliz Natal a todos!", "maria@email.com", true);

            for (Mensagem m : sistema.pesquisaMensagensAnonimas()) {
                System.out.println(m.getTextoCompletoAExibir());
            }

            String emailAmigoSecreto = sistema.pesquisaAmigoSecretoDe("jose@email.com");
            if (emailAmigoSecreto.equals("maria@email.com")) {
                System.out.println("Ok");
            }

        } catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }
    }
}
