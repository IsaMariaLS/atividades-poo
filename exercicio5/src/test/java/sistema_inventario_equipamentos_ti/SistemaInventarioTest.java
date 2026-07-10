package sistema_inventario_equipamentos_ti;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaInventarioTest {

    @Test
    public void testaCadastroPesquisaRemocao() {

        SistemaInventario inventario = new SistemaInventario();

        Equipamento notebook = new Equipamento(
                "001",
                "Notebook Dell",
                Categoria.NOTEBOOK,
                "Dell",
                "Inspiron"
        );

        Equipamento monitor = new Equipamento(
                "002",
                "Monitor Samsung",
                Categoria.MONITOR,
                "Samsung",
                "Odyssey"
        );

        try {
            inventario.cadastrarEquipamento(notebook);
            inventario.cadastrarEquipamento(monitor);

            Equipamento encontrado = inventario.pesquisarEquipamento("001");

            assertNotNull(encontrado);
            assertEquals("Notebook Dell", encontrado.getNome());
            assertEquals(Categoria.NOTEBOOK, encontrado.getCategoria());

            inventario.removerEquipamento("002");

            assertEquals(1, inventario.listarEquipamentos().size());

        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }


    @Test
    public void testaPersistenciaDados() {

        SistemaInventario inventario = new SistemaInventario();

        Equipamento mouse = new Equipamento(
                "003",
                "Mouse Logitech",
                Categoria.MOUSE,
                "Logitech",
                "G203"
        );

        try {
            inventario.cadastrarEquipamento(mouse);

            inventario.salvarDados();

            SistemaInventario novoInventario = new SistemaInventario();

            novoInventario.recuperarDados();

            Equipamento recuperado =
                    novoInventario.pesquisarEquipamento("003");

            assertNotNull(recuperado);
            assertEquals("Mouse Logitech", recuperado.getNome());

        } catch (Exception e) {
            fail("Erro na persistência: " + e.getMessage());
        }
    }
}