package sistema_inventario_equipamentos_ti;

import java.io.IOException;
import java.util.Collection;

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
}