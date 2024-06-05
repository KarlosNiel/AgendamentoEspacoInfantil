import Exceptions.NaoEstaInscritoNesteEventoException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
        for (String eventos: Datas.listaEventosGerais) {
            if (evento.equals(eventos)) {
                Datas.listaInscricaoNosEventos.add(nomeDaCrianca + " Está inscrita em: " + evento);
            }
        }
    }

    public void removerInscricaoEvento(String evento, String nomeDaCrianca) throws NaoEstaInscritoNesteEventoException {
        for (String eventos: Datas.listaEventosGerais) {
            if (evento.equals(eventos)) {
                Datas.listaInscricaoNosEventos.remove(nomeDaCrianca + " Está inscrita em: " + evento);
            } else {
                throw new NaoEstaInscritoNesteEventoException("Não está escrito nesse evento!");
            }
        }
    }

    public void mostrarEventos(int vagasTotal) {
        int contador = 0;
        for (String inscricoes : Datas.listaInscricaoNosEventos) {
            contador++;
        }

        for (String eventos : Datas.listaEventosGerais) {
            System.out.println(eventos + " " + (vagasTotal - contador) + " vagas.");
        }

    }

    public void mostrarInscritosEvento() {
        for (String inscritos: Datas.listaInscricaoNosEventos) {
            System.out.println(inscritos);
        }
    }
}