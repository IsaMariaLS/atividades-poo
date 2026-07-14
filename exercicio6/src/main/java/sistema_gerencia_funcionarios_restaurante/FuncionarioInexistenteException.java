package sistema_gerencia_funcionarios_restaurante;

public class FuncionarioInexistenteException extends RuntimeException {

    public FuncionarioInexistenteException(String message) {
        super(message);
    }
}