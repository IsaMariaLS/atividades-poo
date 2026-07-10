package sistema_inventario_equipamentos_ti;

public class EquipamentoJaExisteException extends Exception {
    public EquipamentoJaExisteException(String mensagem){
        super(mensagem);
    }

}
