import Exceptions.NaoEstaInscritoNesteEventoException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class AgendamentoCliente {
    private Cliente cliente;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void requerirAgendamento(String data) {
        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        Datas.listaSolicitacaoCliente.add(dateTime);
        Datas.listaDatasGerais.add(dateTime);
    }

    public void solicitarRemocao(String data) {
        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        Datas.listaSolicitacaoCliente.remove(dateTime);
        Datas.listaDatasGerais.remove(dateTime);
    }

    public void exibirSolicitacoes() {
        for (LocalDateTime dateTime : Datas.listaSolicitacaoCliente) {
            System.out.println(dateTime);
        }
    }

    public void inscricaoEventos(String evento, String nomeDaCrianca) {
        if (Datas.listaEventosGerais.contains(evento)) {
            Datas.listaInscricaoNosEventos.add(nomeDaCrianca + " Está inscrita em: " + evento);
        }
    }

    public void removerInscricaoEvento(String evento, String nomeDaCrianca) throws NaoEstaInscritoNesteEventoException {
        String inscricao = nomeDaCrianca + " Está inscrita em: " + evento;
        if (!Datas.listaInscricaoNosEventos.remove(inscricao)) {
            throw new NaoEstaInscritoNesteEventoException("Não está inscrito nesse evento!");
        }
    }

    public void mostrarEventos(int vagasTotal) {
        int contador = Datas.listaInscricaoNosEventos.size();
        for (String eventos : Datas.listaEventosGerais) {
            System.out.println(eventos + " " + (vagasTotal - contador) + " vagas.");
        }
    }

    public void mostrarInscritosEvento() {
        if (Datas.listaInscricaoNosEventos.isEmpty()) {
            System.out.println("Nenhum inscrito encontrado.");
        } else {
            for (String inscritos : Datas.listaInscricaoNosEventos) {
                System.out.println(inscritos);
            }
        }
    }
}
