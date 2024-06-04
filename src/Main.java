import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Administrador admin = new Administrador("Pâmella", 19, 123456789);
        admin.setSenha("admin123");

        Cliente cliente = new Cliente("Maria", 20);
        cliente.setEmail("maria@example.com");
        cliente.setSenha(1234);
        cliente.setQuantidadeCriancas(2);

        Criancas crianca1 = new Criancas("Laninha", 10);
        Criancas crianca2 = new Criancas("Darth Vader", 1);
        cliente.adicionarCrianca(crianca1);
        cliente.adicionarCrianca(crianca2);

        AgendamentoAdm agendamentoAdm = new AgendamentoAdm();
        agendamentoAdm.setAdm(admin);

        agendamentoAdm.AbrirEvento("Festa de Aniversário");
        agendamentoAdm.AbrirEvento("Caça ao Tesouro");

        AgendamentoCliente agendamentoCliente = new AgendamentoCliente();

        boolean running = true;

        while (running) {
            System.out.println("Menu Principal");
            System.out.println("1. Entrar como Administrador");
            System.out.println("2. Entrar como Cliente");
            System.out.println("3. Encerrar");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    boolean adminMenu = true;
                    while (adminMenu) {
                        System.out.println("Menu Administrador");
                        System.out.println("1. Exibir Eventos");
                        System.out.println("2. Limpar Inscrições de Eventos");
                        System.out.println("3. Voltar ao Menu Principal");

                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (adminChoice) {
                            case 1:
                                System.out.println("Eventos disponíveis:");
                                for (String evento : Datas.listaEventosGerais) {
                                    System.out.println(evento);
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Limpando inscrições de eventos...");
                                agendamentoAdm.limparInscritosEventos();
                                System.out.println("Eventos e inscritos após limpeza:");
                                agendamentoCliente.mostrarEventosEInscritos();
                                System.out.println();
                                break;
                            case 3:
                                adminMenu = false;
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                    break;
                case 2:
                    boolean clienteMenu = true;
                    while (clienteMenu) {
                        System.out.println("Menu Cliente");
                        System.out.println("1. Exibir Crianças");
                        System.out.println("2. Exibir Eventos");
                        System.out.println("3. Inscrever Criança em Evento");
                        System.out.println("4. Requerer Agendamento");
                        System.out.println("5. Solicitar Remoção de Agendamento");
                        System.out.println("6. Exibir Solicitações de Agendamento");
                        System.out.println("7. Voltar ao Menu Principal");

                        int clienteChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (clienteChoice) {
                            case 1:
                                System.out.println("Crianças cadastradas no sistema:");
                                cliente.exibirCriancas();
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Eventos disponíveis:");
                                for (String evento : Datas.listaEventosGerais) {
                                    System.out.println(evento);
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Inscrever criança em evento");
                                System.out.println("Digite o nome do evento:");
                                String evento = scanner.nextLine();
                                System.out.println("Digite o nome da criança:");
                                String nomeCrianca = scanner.nextLine();
                                agendamentoCliente.inscricaoEventos(evento, nomeCrianca);
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Digite a data para requerir agendamento (dd/MM/yyyy HH:mm):");
                                String dataAgendamento = scanner.nextLine();
                                agendamentoCliente.requerirAgendamento(dataAgendamento);
                                System.out.println();
                                break;
                            case 5:
                                System.out.println("Digite a data para solicitar remoção do agendamento (dd/MM/yyyy HH:mm):");
                                String dataRemocao = scanner.nextLine();
                                agendamentoCliente.solicitarRemocao(dataRemocao);
                                System.out.println();
                                break;
                            case 6:
                                System.out.println("Solicitações de agendamento:");
                                agendamentoCliente.exibirSolicitacoes();
                                System.out.println();
                                break;
                            case 7:
                                clienteMenu = false;
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
