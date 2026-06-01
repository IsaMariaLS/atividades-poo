package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nome, String email) throws AmigoJaExisteException {
        if (amigos.containsKey(email)) {
            throw new AmigoJaExisteException("Amigo já existe!");
        }
        amigos.put(email, new Amigo(nome, email));
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        if (!amigos.containsKey(email)) {
            throw new AmigoInexistenteException("Amigo não encontrado!");
        }
        return amigos.get(email);
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