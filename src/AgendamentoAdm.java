import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgendamentoAdm {
    private Administrador adm;
    private Cliente cliente;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    Scanner scanner = new Scanner(System.in);

    public int AbrirEvento(String evento, int vagas) {
        Datas.listaEventosGerais.add(evento);
        return vagas;
    }

    public void fecharEvento(String evento){
        Datas.listaEventosGerais.remove(evento);
    }

    public void limparInscritosEventos() {
        for (String limparEventos: Datas.listaInscricaoNosEventos) {
            Datas.listaInscricaoNosEventos.remove(limparEventos);
        }
    }

    public void Agendar(){
        for (LocalDateTime verificar: Datas.listaSolicitacaoCliente) {
            System.out.println("Aprovar agendamento de " + verificar + "?");
            if (scanner.nextLine().equals("sim".toLowerCase())) {
                Datas.listaDatasConfirmadas.add(verificar);
            }
        }
    }

    public void Remover(){
        System.out.println("Digite 'solicitar' para remover datas da lista geral ou Digite 'confirmado' para remover da lista de confirmação");
        if (scanner.nextLine().equals("solicitar".toLowerCase())) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), formatter);
            for (LocalDateTime data: Datas.listaSolicitacaoCliente) {
                if (dateTime == data) {
                    Datas.listaSolicitacaoCliente.remove(data);
                }
            }
        } else if (scanner.nextLine().equals("confirmado".toLowerCase())) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), formatter);
            for (LocalDateTime data: Datas.listaDatasConfirmadas) {
                if (dateTime == data) {
                    Datas.listaDatasConfirmadas.remove(data);
                }
            }
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }


}