import Exceptions.DataNaoEncontradaException;
import Exceptions.EntradaInesperadaException;
import java.util.Iterator;
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
        Iterator<String> iterator = Datas.listaInscricaoNosEventos.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
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

        String escolha = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        if (escolha.equalsIgnoreCase("solicitar")) {
            if (!Datas.listaSolicitacaoCliente.remove(dateTime)) {
                throw new DataNaoEncontradaException("Data não encontrada em nossa Agenda");
            }
        } else if (escolha.equalsIgnoreCase("confirmado")) {
            if (!Datas.listaDatasConfirmadas.remove(dateTime)) {
                throw new DataNaoEncontradaException("Data não encontrada em nossa Agenda");
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
