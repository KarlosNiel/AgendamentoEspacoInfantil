import Exceptions.DataNaoEncontradaException;
import Exceptions.EntradaInesperadaException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgendamentoAdm {
    private Administrador adm;
    private Cliente cliente;

    public AgendamentoAdm AbrirEvento(String evento, int vagas) {
        Datas.listaEventosGerais.add(evento);
        return this;
    }

    public void fecharEvento(String evento) {
        Datas.listaEventosGerais.remove(evento);
    }

    public void limparInscritosEventos() {
        for (String limparEventos: Datas.listaInscricaoNosEventos) {
            Datas.listaInscricaoNosEventos.remove(limparEventos);
        }
    }

    public void Agendar() throws EntradaInesperadaException {
        Scanner scanner = new Scanner(System.in);

        for (LocalDateTime verificar: Datas.listaSolicitacaoCliente) {
            System.out.println("Aprovar agendamento de " + verificar + "? (sim/nao)");

            if (scanner.nextLine().equals("sim".toLowerCase())) {
                Datas.listaDatasConfirmadas.add(verificar);
            } else {
                throw new EntradaInesperadaException("Entrada Inesperada! Favor, tente novamente seguindo as instruções do menu.");
            }
        }
    }

    public void Remover() throws DataNaoEncontradaException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 'solicitar' para remover datas da lista geral ou Digite 'confirmado' para remover da lista de confirmação");

        if (scanner.nextLine().equals("solicitar".toLowerCase())) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

            for (LocalDateTime data: Datas.listaSolicitacaoCliente) {
                if (dateTime == data) {
                    Datas.listaSolicitacaoCliente.remove(data);
                } else {
                    throw new DataNaoEncontradaException("Data não encontrada em nossa Agenda");
                }
            }

        } else if (scanner.nextLine().equals("confirmado".toLowerCase())) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

            for (LocalDateTime data: Datas.listaDatasConfirmadas) {
                if (dateTime == data) {
                    Datas.listaDatasConfirmadas.remove(data);
                } else {
                    throw new DataNaoEncontradaException("Data não encontrada em nossa Agenda");
                }
            }

        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public AgendamentoAdm setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Administrador getAdm() {
        return adm;
    }

    public AgendamentoAdm setAdm(Administrador adm) {
        this.adm = adm;
        return this;
    }


}