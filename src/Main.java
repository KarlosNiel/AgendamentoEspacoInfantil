public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Romário", 46);

        AgendamentoCliente agendamentoCliente = new AgendamentoCliente();

        Datas.listaEventosGerais.add("teste");

        agendamentoCliente.inscricaoEventos("teste", "Mario");

        agendamentoCliente.mostrarEventosEInscritos();

        System.out.println(Datas.listaInscricaoNosEventos);



    }
}