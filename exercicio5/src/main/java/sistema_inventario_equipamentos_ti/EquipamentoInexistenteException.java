package sistema_inventario_equipamentos_ti;

public class EquipamentoInexistenteException extends Exception{
    public EquipamentoInexistenteException(String mensagem){
        super(mensagem);
    }

}
