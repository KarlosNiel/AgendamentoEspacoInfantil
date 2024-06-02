import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AgendamentoCliente {
    private Cliente cliente;
    private ArrayList<LocalDateTime> listaSolicitacaoCliente = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void requerirAgendamento(String data) {
        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        listaSolicitacaoCliente.add(dateTime);
    }

    public void solicitarRemocao(String data) {
        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        listaSolicitacaoCliente.remove(dateTime);
    }

    public void exibirSolicitacoes() {
        for (LocalDateTime dateTime : listaSolicitacaoCliente) {
            System.out.println(dateTime);
        }
    }

    public void inscricaoEventos(String evento, String nomeDaCrianca) {
        for (String eventos: Datas.listaEventosGerais) {
            if (evento.equals(eventos)) {
                Datas.listaInscricaoNosEventos.add(nomeDaCrianca + " Está inscrita em: " + evento);
            }
        }
    }

    public void removerInscricaoEvento(String evento, String nomeDaCrianca) {
        for (String eventos: Datas.listaEventosGerais) {
            if (evento.equals(eventos)) {
                Datas.listaInscricaoNosEventos.remove(nomeDaCrianca + " Está inscrita em: " + evento);
            }
        }
    }

    public void mostrarEventosEInscritos() {
        for (String eventos: Datas.listaEventosGerais) {
            System.out.println(eventos);
        }

        for (String inscritos: Datas.listaInscricaoNosEventos) {
            System.out.println(inscritos);
        }
    }
}