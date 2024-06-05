package Exceptions;

public class NaoEstaInscritoNesteEventoException extends Exception {
    public NaoEstaInscritoNesteEventoException(String msg) {
        super(msg);
    }

    public String message() {
        return "Você não está escrito nesse evento!";
    }
}
