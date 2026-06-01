package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nome, String email) throws AmigoJaExisteException {
        for (Amigo a : amigos) {
            if (a.getEmail().equals(email)) {
                throw new AmigoJaExisteException("Amigo já existe!");
            }
        }
        amigos.add(new Amigo(nome, email));
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        for (Amigo a : amigos) {
            if (a.getEmail().equals(email)) {
                return a;
            }
        }
        throw new AmigoInexistenteException("Amigo não encontrado!");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        mensagens.add(new MensagemParaTodos(texto, emailRemetente, anonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        amigo.setAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo.getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException("Amigo secreto não sorteado!");
        }
        return amigo.getEmailAmigoSorteado();
    }
}