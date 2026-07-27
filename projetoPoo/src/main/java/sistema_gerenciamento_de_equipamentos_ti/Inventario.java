package sistema_gerenciamento_de_equipamentos_ti;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * Interface responsável por definir as operações
 * principais de um sistema de inventário de equipamentos.
 *
 * O sistema permite cadastrar, pesquisar, remover,
 * listar e persistir equipamentos em arquivo.
 */

public interface Inventario {
    
    /**
     * Cadastra um equipamento no inventário.
     *
     * @param equipamento equipamento que será armazenado.
     * @throws EquipamentoJaExisteException caso já exista
     * um equipamento com o mesmo patrimônio.
     */
       void cadastrarEquipamento(Equipamento equipamento) throws EquipamentoJaExisteException;


    /**
     * Pesquisa um equipamento pelo seu patrimônio.
     *
     * @param patrimonio identificação do equipamento.
     * @return equipamento encontrado.
     * @throws EquipamentoInexistenteException caso o equipamento
     * não exista no inventário.
     */

    Equipamento pesquisarEquipamento(String patrimonio) throws EquipamentoInexistenteException;


    /**
     * Remove um equipamento do inventário.
     *
     * @param patrimonio identificação do equipamento.
     * @throws EquipamentoInexistenteException caso o equipamento
     * não seja encontrado.
     */
    void removerEquipamento(String patrimonio) throws EquipamentoInexistenteException;


    /**
     * Lista todos os equipamentos cadastrados.
     *
     * @return coleção contendo os equipamentos armazenados.
     */
    Collection<Equipamento> listarEquipamentos();


    /**
     * Salva os dados do inventário em arquivo.
     *
     * @throws IOException caso ocorra erro durante a gravação.
     */
    void salvarDados() throws IOException;


    /**
     * Recupera os dados do inventário a partir do arquivo.
     *
     * @throws IOException caso ocorra erro durante a leitura.
     */
    void recuperarDados() throws IOException;


    /**
     * Atualiza apenas o status de um equipamento já cadastrado.
     *
     * @param patrimonio identificação do equipamento.
     * @param novoStatus novo status a ser atribuído ao equipamento.
     * @throws EquipamentoInexistenteException caso o equipamento
     * não seja encontrado.
     */
    void atualizarStatus(String patrimonio, StatusEquipamento novoStatus)
            throws EquipamentoInexistenteException;


    /**
     * Pesquisa todos os equipamentos de uma determinada categoria.
     *
     * @param categoria categoria a ser filtrada.
     * @return coleção de equipamentos que pertencem à categoria informada.
     */
    Collection<Equipamento> pesquisarPorCategoria(Categoria categoria);


    /**
     * Pesquisa todos os equipamentos de uma determinada marca.
     *
     * @param marca marca a ser filtrada.
     * @return coleção de equipamentos que pertencem à marca informada.
     */
    Collection<Equipamento> pesquisarPorMarca(String marca);


    /**
     * Pesquisa todos os equipamentos com um determinado status.
     *
     * @param status status a ser filtrado.
     * @return coleção de equipamentos que possuem o status informado.
     */
    Collection<Equipamento> pesquisarPorStatus(StatusEquipamento status);

    /**
     * Conta o total de equipamentos cadastrados no inventário.
     *
     * @return quantidade total de equipamentos.
     */
    int contarEquipamentos();


    /**
     * Conta quantos equipamentos existem para cada status
     * (disponível, em uso, em manutenção, descartado).
     *
     * @return mapa relacionando cada status à quantidade de
     * equipamentos que se encontram nesse status.
     */
    Map<StatusEquipamento, Long> contarPorStatus();


    /**
     * Registra o empréstimo de um equipamento, associando-o a um
     * responsável e a um setor, e alterando seu status para EM_USO.
     *
     * @param patrimonio identificação do equipamento.
     * @param responsavel nome da pessoa responsável pelo uso do equipamento.
     * @param setor setor ou local onde o equipamento será utilizado.
     * @throws EquipamentoInexistenteException caso o equipamento
     * não seja encontrado.
     */
    void emprestarEquipamento(String patrimonio, String responsavel, String setor)
            throws EquipamentoInexistenteException;


    /**
     * Registra a devolução de um equipamento, removendo o responsável
     * e o setor associados, e alterando seu status para DISPONIVEL.
     *
     * @param patrimonio identificação do equipamento.
     * @throws EquipamentoInexistenteException caso o equipamento
     * não seja encontrado.
     */
    void devolverEquipamento(String patrimonio)
            throws EquipamentoInexistenteException;
}