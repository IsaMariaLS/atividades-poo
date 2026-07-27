package sistema_gerenciamento_de_equipamentos_ti;

import java.util.Map;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class SistemaInventario implements Inventario {

    private Map<String, Equipamento> equipamentos;
    private GravadorDeDados gravador;

    public SistemaInventario(boolean iniciarVazio) {
        gravador = new GravadorDeDados();
        equipamentos = new HashMap<>();
    }

    public SistemaInventario() throws IOException {
        gravador = new GravadorDeDados();
        equipamentos = gravador.recuperarEquipamentos();
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
        if(equipamento == null){
            throw new EquipamentoInexistenteException("O equipamento não foi encontrado!");
        }
        return equipamento;
    }

    @Override
    public void removerEquipamento(String patrimonio) throws EquipamentoInexistenteException{
       
        Equipamento equipamento = equipamentos.get(patrimonio);
        if(equipamento == null){
            throw new EquipamentoInexistenteException("O equipamento não foi encontrado!");
        }
        equipamentos.remove(patrimonio);
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

    @Override
    public void atualizarStatus(String patrimonio, StatusEquipamento novoStatus) throws EquipamentoInexistenteException {

        Equipamento equipamento = equipamentos.get(patrimonio);
        if(equipamento == null){
            throw new EquipamentoInexistenteException("O equipamento não foi encontrado!");
        }
        equipamento.setStatus(novoStatus);
    }

    @Override
    public Collection<Equipamento> pesquisarPorCategoria(Categoria categoria) {

        return equipamentos.values().stream()
                .filter(equipamento -> equipamento.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Equipamento> pesquisarPorMarca(String marca) {

        return equipamentos.values().stream()
                .filter(equipamento -> equipamento.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Equipamento> pesquisarPorStatus(StatusEquipamento status) {

        return equipamentos.values().stream()
                .filter(equipamento -> equipamento.getStatus() == status)
                .collect(Collectors.toList());
    }

    @Override
    public int contarEquipamentos() {
        return equipamentos.size();
    }

    @Override
    public Map<StatusEquipamento, Long> contarPorStatus() {

        return equipamentos.values().stream()
                .collect(Collectors.groupingBy(
                        Equipamento::getStatus,
                        Collectors.counting()
                ));
    }

    @Override
    public void emprestarEquipamento(String patrimonio, String responsavel, String setor) throws EquipamentoInexistenteException {

        Equipamento equipamento = equipamentos.get(patrimonio);
        if (equipamento == null) {
            throw new EquipamentoInexistenteException("O equipamento não foi encontrado!");
        }
        equipamento.setResponsavel(responsavel);
        equipamento.setSetor(setor);
        equipamento.setStatus(StatusEquipamento.EM_USO);

    }

    @Override
    public void devolverEquipamento(String patrimonio) throws EquipamentoInexistenteException {

        Equipamento equipamento = equipamentos.get(patrimonio);
        if (equipamento == null) {
            throw new EquipamentoInexistenteException("O equipamento não foi encontrado!");
        }
        equipamento.setResponsavel(null);
        equipamento.setSetor(null);
        equipamento.setStatus(StatusEquipamento.DISPONIVEL);

    }
}

   






    
 