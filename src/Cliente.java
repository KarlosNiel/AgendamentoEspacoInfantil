import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cliente extends Pessoa{
    private String email;
    private int senha;
    private int quantidadeCriancas;
    private ArrayList<Criancas> listaCriancas = new ArrayList<>();

    public Cliente(String nome, int idade) {
        super(nome, idade);
    }

    public void adicionarCrianca(Criancas crianca) {
        listaCriancas.add(crianca);
    }

    public void exibirCriancas() {
        for (Criancas crianca : listaCriancas) {
            System.out.println(crianca);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getQuantidadeCriancas() {
        return quantidadeCriancas;
    }

    public void setQuantidadeCriancas(int quantidadeCriancas) {
        this.quantidadeCriancas = quantidadeCriancas;
    }
}