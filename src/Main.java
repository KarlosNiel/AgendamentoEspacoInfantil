import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do administrador:");
        String nomeAdmin = scanner.nextLine();
        System.out.println("Digite a idade do administrador:");
        int idadeAdmin = scanner.nextInt();
        System.out.println("Digite o CPF do administrador:");
        int cpfAdmin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a senha do administrador:");
        String senhaAdmin = scanner.nextLine();

        Administrador admin = new Administrador(nomeAdmin, idadeAdmin, cpfAdmin).setSenha(senhaAdmin);

        System.out.println("Digite o nome do cliente:");
        scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        System.out.println("Digite a idade do cliente:");
        int idadeCliente = scanner.nextInt();
        System.out.println("Digite o email do cliente:");
        scanner.nextLine();
        String emailCliente = scanner.nextLine();
        System.out.println("Digite a senha do cliente:");
        String senhaCliente = scanner.nextLine();
        System.out.println("Digite a quantidade de crianças do cliente:");
        int quantidadeCriancas = scanner.nextInt();

        Cliente cliente = new Cliente(nomeCliente, idadeCliente)
                .setEmail(emailCliente)
                .setSenha(senhaCliente)
                .setQuantidadeCriancas(quantidadeCriancas);

        for (int i = 0; i < quantidadeCriancas; i++) {
            scanner.nextLine();
            System.out.println("Digite o nome da criança " + (i + 1) + ":");
            String nomeCrianca = scanner.nextLine();
            System.out.println("Digite a idade da criança " + (i + 1) + ":");
            int idadeCrianca = scanner.nextInt();
            Criancas crianca = new Criancas(nomeCrianca, idadeCrianca);
            cliente.adicionarCrianca(crianca);
        }

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
