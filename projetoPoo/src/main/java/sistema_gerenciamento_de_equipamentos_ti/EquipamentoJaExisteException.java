package sistema_gerenciamento_de_equipamentos_ti;

public class EquipamentoJaExisteException extends Exception {
    public EquipamentoJaExisteException(String mensagem){
        super(mensagem);
    }

}
