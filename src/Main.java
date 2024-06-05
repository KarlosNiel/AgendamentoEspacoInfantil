import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Administrador admin = new Administrador("Pâmella", 19, 123456789)
                .setSenha("admin123");

        Criancas crianca1 = new Criancas("Laninha", 10);
        Criancas crianca2 = new Criancas("Darth Vader", 1);

        // Aplicado (method chaining) para simplificar o código
        Cliente cliente = new Cliente("Maria", 20)
                .setEmail("maria@example.com")
                .setSenha(1234)
                .setQuantidadeCriancas(2)
                .adicionarCrianca(crianca1)
                .adicionarCrianca(crianca2);

        AgendamentoAdm agendamentoAdm = new AgendamentoAdm()
                .setAdm(admin)
                .AbrirEvento("Festa de Aniversário", 20)
                .AbrirEvento("Caça ao Tesouro", 6);

        AgendamentoCliente agendamentoCliente = new AgendamentoCliente();

        boolean running = true;

        while (running) {
            System.out.println("""
                    ==== Menu Principal =====
                    1. Entrar como Administrador
                    2. Entrar como Cliente
                    3. Encerrar""");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    boolean adminMenu = true;
                    while (adminMenu) {
                        System.out.println("""
                                ==== Menu Administrador ====
                                1. Exibir Eventos
                                2. Limpar Inscrições de Eventos
                                3. Mostrar Inscritos nos Eventos
                                4. Voltar ao Menu Principal""");

                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (adminChoice) {
                            case 1:
                                System.out.println("==== Eventos disponíveis ====");
                                for (String evento : Datas.listaEventosGerais) {
                                    System.out.println(" - " + evento);
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Limpando inscrições de eventos...");
                                agendamentoAdm.limparInscritosEventos();
                                System.out.println("Eventos e inscritos após limpeza:");
                                agendamentoCliente.mostrarInscritosEvento();
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("==== Inscritos nos eventos ====");
                                agendamentoCliente.mostrarInscritosEvento();
                                System.out.println();
                                break;
                            case 4:
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
                        System.out.println("==== Menu Cliente ====");
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
                                System.out.println("==== Crianças cadastradas ====");
                                cliente.exibirCriancas();
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("==== Eventos disponíveis ====");
                                for (String evento : Datas.listaEventosGerais) {
                                    System.out.println(" - " + evento);
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("==== Inscrever criança em evento ====");
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
                                System.out.println("Digite a data para solicitar remoção (dd/MM/yyyy HH:mm):");
                                String dataRemocao = scanner.nextLine();
                                agendamentoCliente.solicitarRemocao(dataRemocao);
                                System.out.println();
                                break;
                            case 6:
                                System.out.println("==== Solicitações de agendamento ====");
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
                    System.out.println("Encerrando o programa...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
