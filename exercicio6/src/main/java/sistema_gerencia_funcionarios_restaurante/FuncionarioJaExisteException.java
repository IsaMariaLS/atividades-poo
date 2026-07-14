package sistema_gerencia_funcionarios_restaurante;

public class FuncionarioJaExisteException extends RuntimeException {

    public FuncionarioJaExisteException(String message) {
        super(message);
    }
}