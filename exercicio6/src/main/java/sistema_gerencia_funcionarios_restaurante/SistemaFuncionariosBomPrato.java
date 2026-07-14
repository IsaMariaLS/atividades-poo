package sistema_gerencia_funcionarios_restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class SistemaFuncionariosBomPrato implements SistemaFuncionarios {
    private Map<String, Funcionario> funcionarios;


    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<String, Funcionario>();

    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(funcionario.getCpf())) {
            throw new FuncionarioJaExisteException(
                    "Já existe funcionário com o cpf " + funcionario.getCpf());
        } else {
            this.funcionarios.put(funcionario.getCpf(), funcionario);
        }

    }

    @Override
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario
            tipo, double salario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(cpf)) {
            throw new FuncionarioJaExisteException(
                    "Já existe funcionário com o cpf " + cpf);
        } else {
            this.funcionarios.put(cpf, new Funcionario(cpf, nome, tipo, salario));
        }
    }

    @Override
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) throws FuncionarioInexistenteException {
        Funcionario funcionario = funcionarios.get(cpfFuncionario);

        if (funcionario == null) {
            throw new FuncionarioInexistenteException("Não existe funcionário com esse cpf");
        }
        funcionario.setSalario(novoSalario);
    }

    @Override
    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        int cont = 0;
        for (Funcionario f : funcionarios.values()) {
            if (f.getTipo().equals(tipo)) {
                cont++;
            }
        }
        return cont;
    }

    @Override
    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return funcionarios.containsKey(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        List<Funcionario> listaFunciorioTipo = new ArrayList<>();
        for (Funcionario f: funcionarios.values()) {
            if (f.getTipo() == (tipo)){
                listaFunciorioTipo.add(f);
            }
        }
        return listaFunciorioTipo;
    }

    @Override
    public Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException {

        Funcionario funcionario = funcionarios.get(cpfFuncionario);
        if (funcionario == null){
            throw new FuncionarioInexistenteException("Esse funcionario não existe!");
        }
        else{
            return funcionario;
        }
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        List<Funcionario> maiorSalario = new ArrayList<>();
        for (Funcionario f : funcionarios.values()) {
            if (f.getSalario() > valor) {
                maiorSalario.add(f);
            }
        }
        return maiorSalario;
    }

}