package Exceptions;

public class EntradaInesperadaException extends Exception {
    public EntradaInesperadaException(String msg) {
        super(msg);
    }

    public String message() {
        return "Entrada Inesperada! Favor, tente novamente seguindo as instruções do menu.";
    }
}
