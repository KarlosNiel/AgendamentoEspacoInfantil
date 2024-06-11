package Exceptions;

public class DataNaoEncontradaException extends Exception {
    public DataNaoEncontradaException(String msg) {
        super(msg);
    }

    public String message() {
        return "Data não encontrada em nossa Agenda";
    }
}
