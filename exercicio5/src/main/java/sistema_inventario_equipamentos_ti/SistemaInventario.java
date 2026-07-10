package sistema_inventario_equipamentos_ti;

import java.util.Map;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class SistemaInventario implements Inventario {

    private Map<String, Equipamento> equipamentos;
    private GravadorDeDados gravador;

    public SistemaInventario(){
        equipamentos = new HashMap<>();
        gravador = new GravadorDeDados();
    }

    @Override
    public void cadastrarEquipamento(Equipamento equipamento) throws EquipamentoJaExisteException{

        if(equipamentos.containsKey(equipamento.getPatrimonio())){ 
            throw new EquipamentoJaExisteException("O equipamento já foi cadastrado!");
            
        }
        equipamentos.put(equipamento.getPatrimonio(), equipamento);
    }

    @Override
    public Equipamento pesquisarEquipamento(String patrimonio)throws EquipamentoInexistenteException{
        
        Equipamento equipamento = equipamentos.get(patrimonio);
        if(equipamento != null){
            return equipamento;
        }
        throw new EquipamentoInexistenteException("O equipamento não foi encontrado!");
    }

    @Override
    public void removerEquipamento(String patrimonio) throws EquipamentoInexistenteException{
       
        Equipamento equipamento = equipamentos.get(patrimonio);
        if(equipamento != null){
            equipamentos.remove(patrimonio);
        }
        else{
            throw new EquipamentoInexistenteException("O equipamento não foi encontrado!");
        }
    }

    @Override
    public Collection<Equipamento> listarEquipamentos(){
        return equipamentos.values();
    }

    @Override
    public void salvarDados() throws IOException{
      gravador.salvar(equipamentos);
    }

    @Override
    public void recuperarDados() throws IOException{
        equipamentos = gravador.recuperarEquipamentos();
        
    }
}

   






    
 