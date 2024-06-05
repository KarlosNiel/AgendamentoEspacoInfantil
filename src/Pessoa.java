public abstract class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        // muda cor no terminal
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";

        return ANSI_YELLOW + "Nome: " + ANSI_RESET + nome + ", " +
                ANSI_BLUE + "Idade: " + ANSI_RESET + idade;
    }
}
