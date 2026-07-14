package sistema_gerencia_funcionarios_restaurant_test;

import org.junit.jupiter.api.Test;
import sistema_gerencia_funcionarios_restaurante.*;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFuncionariosBomPratoTest {
    @Test
    public void testCadastroEPesquisa(){
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try{
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças",
                    TipoFuncionario.GERENTE, 3000));
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");
            sistema.cadastrarFuncionario(new Funcionario("222.222.222-22", "João Paulo Silva", TipoFuncionario.COZINHEIRO, 5000));
            assertEquals(2, sistema.pesquisarFuncionariosComSalarioMaiorQue(2000).size());
            assertEquals(1, sistema.contarFuncionariosDoTipo(TipoFuncionario.COZINHEIRO));

        }catch (FuncionarioJaExisteException | FuncionarioInexistenteException e) {
            fail("Não deveria lançar exceção");

        }
    }
    @Testgit commit -m "Adiciona exercício 6 - Sistema de Funcionários"
    public void testPesquisarFuncionarioInexistente() {
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();

        assertThrows(FuncionarioInexistenteException.class, () -> {
            sistema.pesquisarFuncionario("000.000.000-00");
        });
    }

}
