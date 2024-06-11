import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cliente extends Pessoa{
    private String email;
    private String senha;
    private int quantidadeCriancas;
    private ArrayList<Criancas> listaCriancas = new ArrayList<>();

    public Cliente(String nome, int idade) {
        super(nome, idade);
    }

    public Cliente adicionarCrianca(Criancas crianca) {
        listaCriancas.add(crianca);
        return this;
    }

    public void exibirCriancas() {
        for (Criancas crianca : listaCriancas) {
            System.out.println(crianca);
        }
    }

    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Cliente setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public int getQuantidadeCriancas() {
        return quantidadeCriancas;
    }

    public Cliente setQuantidadeCriancas(int quantidadeCriancas) {
        this.quantidadeCriancas = quantidadeCriancas;
        return this;
    }
}