public class Administrador extends Pessoa {
    private int cpf;
    private String senha;
    private AgendamentoAdm agendamento;

    public Administrador(String nome, int idade, int cpf) {
        super(nome, idade);
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public AgendamentoAdm getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(AgendamentoAdm agendamento) {
        this.agendamento = agendamento;
    }
}