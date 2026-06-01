package br.ufpb.dcx.amigosecreto;

public class AmigoInexistenteException extends Exception {
    public AmigoInexistenteException(String mensagem) {
        super(mensagem);
    }
}