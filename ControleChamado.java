package controlechamado;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleChamado {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        ArrayList<Equipe> equipes = new ArrayList<>();
        ArrayList<Chamado> chamados = new ArrayList<>();
        ArrayList<Atendimento> atendimentos = new ArrayList<>();

        // Guardar qual cliente abriu cada chamado
        Map<Chamado, Cliente> clienteDoChamado = new HashMap<>();

        // Guardar atendimentos de cada chamado
        Map<Chamado, ArrayList<Atendimento>> historicoChamado = new HashMap<>();

       int opcao;

        do {

            System.out.println(" CONTROLE DE CHAMADOS");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar técnico");
            System.out.println("3 - Cadastrar equipe");
            System.out.println("4 - Abrir chamado");
            System.out.println("5 - Listar chamados");
            System.out.println("6 - Visualizar detalhes do chamado");
            System.out.println("7 - Atribuir técnico ao chamado");
            System.out.println("8 - Registrar atendimento");
            System.out.println("9 - Alterar status do chamado");
            System.out.println("10 - Encerrar chamado");
            System.out.println("11 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                //CADASTRAR CLIENTE
               

                case 1: {

                    System.out.println("\n===== CADASTRAR CLIENTE =====");

                    System.out.print("ID: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String emailCliente = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefoneCliente = scanner.nextLine();

                    System.out.print("CPF/CNPJ: ");
                    String cpfCnpj = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    Cliente cliente = new Cliente(
                            idCliente,
                            nomeCliente,
                            emailCliente,
                            telefoneCliente,
                            cpfCnpj,
                            endereco
                    );

                    clientes.add(cliente);

                    System.out.println("Cliente cadastrado com sucesso!");

                    break;
                }


                //CADASTRAR TÉCNICO

                case 2: {

                    System.out.println("\n===== CADASTRAR TÉCNICO =====");

                    System.out.print("ID: ");
                    long idTecnico = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nomeTecnico = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String emailTecnico = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefoneTecnico = scanner.nextLine();

                    System.out.print("Especialidade: ");
                    String especialidade = scanner.nextLine();

                    Tecnico tecnico = new Tecnico(
                            idTecnico,
                            nomeTecnico,
                            emailTecnico,
                            telefoneTecnico,
                            especialidade,
                            LocalDate.now()
                    );

                    tecnicos.add(tecnico);

                    System.out.println("Técnico cadastrado com sucesso!");

                    break;
                }


                //CADASTRAR EQUIPE

                case 3: {

                    System.out.println("\n===== CADASTRAR EQUIPE =====");

                    System.out.print("ID: ");
                    long idEquipe = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Nome da equipe: ");
                    String nomeEquipe = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricaoEquipe = scanner.nextLine();

                    Equipe equipe = new Equipe(
                            idEquipe,
                            nomeEquipe,
                            descricaoEquipe
                    );

                    equipes.add(equipe);

                    System.out.println("Equipe cadastrada com sucesso!");

                    break;
                }


                //ABRIR CHAMADO

                case 4: {

                    System.out.println("\n===== ABRIR CHAMADO =====");

                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }

                    System.out.println("\nClientes cadastrados:");

                    for (Cliente c : clientes) {
                        System.out.println(
                                c.getId() + " - " + c.getNome()
                        );
                    }

                    System.out.print("\nID do cliente: ");
                    int idClienteChamado = scanner.nextInt();
                    scanner.nextLine();

                    Cliente clienteSelecionado = null;

                    for (Cliente c : clientes) {

                        if (c.getId() == idClienteChamado) {
                            clienteSelecionado = c;
                            break;
                        }
                    }

                    if (clienteSelecionado == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("ID do chamado: ");
                    long idChamado = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricaoChamado = scanner.nextLine();

                    System.out.println("\nEscolha a prioridade:");
                    System.out.println("1 - BAIXA");
                    System.out.println("2 - MEDIA");
                    System.out.println("3 - ALTA");
                    System.out.print("Opção: ");

                    int opcaoPrioridade = scanner.nextInt();
                    scanner.nextLine();

                    Prioridade prioridade;

                    if (opcaoPrioridade == 1) {

                        prioridade = Prioridade.BAIXA;

                    } else if (opcaoPrioridade == 2) {

                        prioridade = Prioridade.MEDIA;

                    } else if (opcaoPrioridade == 3) {

                        prioridade = Prioridade.ALTA;

                    } else {

                        System.out.println("Prioridade inválida.");
                        break;
                    }

                    Chamado chamado = new Chamado(
                            idChamado,
                            titulo,
                            descricaoChamado,
                            prioridade,
                            StatusChamado.ABERTO,
                            LocalDateTime.now(),
                            null
                    );

                    chamados.add(chamado);

                    //Guardar cliente que abriu o chamado
                    clienteDoChamado.put(
                            chamado,
                            clienteSelecionado
                    );

                    // Cria o histórico vazio do chamado
                    historicoChamado.put(
                            chamado,
                            new ArrayList<>()
                    );

                    System.out.println("\nChamado aberto com sucesso!");

                    break;
                }


                //LISTAR CHAMADOS

                case 5: {

                    System.out.println("\n===== LISTAR CHAMADOS =====");

                    if (chamados.isEmpty()) {
                        System.out.println("Nenhum chamado cadastrado.");
                        break;
                    }

                    System.out.println("\nEscolha o filtro:");
                    System.out.println("1 - Todos");
                    System.out.println("2 - Por status");
                    System.out.println("3 - Por prioridade");
                    System.out.println("4 - Por técnico");
                    System.out.print("Opção: ");

                    int filtro = scanner.nextInt();
                    scanner.nextLine();

                    if (filtro == 1) {

                        for (Chamado c : chamados) {

                            System.out.println("-----------------------------");
                            System.out.println("ID: " + c.getId());
                            System.out.println("Título: " + c.getTitulo());
                            System.out.println("Prioridade: " + c.getPrioridade());
                            System.out.println("Status: " + c.getStatus());

                            if (c.tecnico != null) {
                                System.out.println(
                                        "Técnico: " +
                                        c.tecnico.getNome()
                                );
                            } else {
                                System.out.println(
                                        "Técnico: Não atribuído"
                                );
                            }
                        }

                    } else if (filtro == 2) {

                        System.out.println("\n1 - ABERTO");
                        System.out.println("2 - EM_ATENDIMENTO");
                        System.out.println("3 - AGUARDANDO_CLIENTE");
                        System.out.println("4 - ENCERRADO");

                        System.out.print("Status: ");
                        int opcaoFiltroStatus = scanner.nextInt();
                        scanner.nextLine();

                        StatusChamado statusFiltro;

                        if (opcaoFiltroStatus == 1) {
                            statusFiltro = StatusChamado.ABERTO;
                        } else if (opcaoFiltroStatus == 2) {
                            statusFiltro = StatusChamado.EM_ATENDIMENTO;
                        } else if (opcaoFiltroStatus == 3) {
                            statusFiltro =
                                    StatusChamado.AGUARDANDO_CLIENTE;
                        } else if (opcaoFiltroStatus == 4) {
                            statusFiltro = StatusChamado.ENCERRADO;
                        } else {
                            System.out.println("Status inválido.");
                            break;
                        }

                        for (Chamado c : chamados) {

                            if (c.getStatus() == statusFiltro) {

                                System.out.println("-----------------------------");
                                System.out.println(
                                        "ID: " + c.getId()
                                );
                                System.out.println(
                                        "Título: " + c.getTitulo()
                                );
                                System.out.println(
                                        "Status: " + c.getStatus()
                                );
                            }
                        }

                    } else if (filtro == 3) {

                        System.out.println("\n1 - BAIXA");
                        System.out.println("2 - MEDIA");
                        System.out.println("3 - ALTA");

                        System.out.print("Prioridade: ");
                        int opcaoFiltroPrioridade =
                                scanner.nextInt();
                        scanner.nextLine();

                        Prioridade prioridadeFiltro;

                        if (opcaoFiltroPrioridade == 1) {
                            prioridadeFiltro = Prioridade.BAIXA;
                        } else if (opcaoFiltroPrioridade == 2) {
                            prioridadeFiltro = Prioridade.MEDIA;
                        } else if (opcaoFiltroPrioridade == 3) {
                            prioridadeFiltro = Prioridade.ALTA;
                        } else {
                            System.out.println("Prioridade inválida.");
                            break;
                        }

                        for (Chamado c : chamados) {

                            if (c.getPrioridade() ==
                                    prioridadeFiltro) {

                                System.out.println("-----------------------------");
                                System.out.println(
                                        "ID: " + c.getId()
                                );
                                System.out.println(
                                        "Título: " + c.getTitulo()
                                );
                                System.out.println(
                                        "Prioridade: " +
                                        c.getPrioridade()
                                );
                            }
                        }

                    } else if (filtro == 4) {

                        if (tecnicos.isEmpty()) {
                            System.out.println(
                                    "Nenhum técnico cadastrado."
                            );
                            break;
                        }

                        System.out.println("\nTécnicos:");

                        for (Tecnico t : tecnicos) {
                            System.out.println(
                                    t.getId() + " - " + t.getNome()
                            );
                        }

                        System.out.print("ID do técnico: ");
                        long idTecnicoFiltro = scanner.nextLong();
                        scanner.nextLine();

                        for (Chamado c : chamados) {

                            if (c.tecnico != null &&
                                    c.tecnico.getId() ==
                                    idTecnicoFiltro) {

                                System.out.println(
                                        "-----------------------------"
                                );

                                System.out.println(
                                        "ID: " + c.getId()
                                );

                                System.out.println(
                                        "Título: " + c.getTitulo()
                                );

                                System.out.println(
                                        "Técnico: " +
                                        c.tecnico.getNome()
                                );
                            }
                        }

                    } else {

                        System.out.println("Filtro inválido.");
                    }

                    break;
                }


                // DETALHES DO CHAMADO

                case 6: {

                    System.out.println(
                            "\n===== DETALHES DO CHAMADO ====="
                    );

                    System.out.print("ID do chamado: ");
                    long idDetalhes = scanner.nextLong();
                    scanner.nextLine();

                    Chamado chamadoDetalhes = null;

                    for (Chamado c : chamados) {

                        if (c.getId() == idDetalhes) {
                            chamadoDetalhes = c;
                            break;
                        }
                    }

                    if (chamadoDetalhes == null) {
                        System.out.println("Chamado não encontrado.");
                        break;
                    }

                    System.out.println(
                            "\nID: " + chamadoDetalhes.getId()
                    );

                    System.out.println(
                            "Título: " +
                            chamadoDetalhes.getTitulo()
                    );

                    System.out.println(
                            "Descrição: " +
                            chamadoDetalhes.getDescricao()
                    );

                    System.out.println(
                            "Prioridade: " +
                            chamadoDetalhes.getPrioridade()
                    );

                    System.out.println(
                            "Status: " +
                            chamadoDetalhes.getStatus()
                    );

                    System.out.println(
                            "Data de abertura: " +
                            chamadoDetalhes.getDataAbertura()
                    );

                    Cliente clienteChamado =
                            clienteDoChamado.get(chamadoDetalhes);

                    if (clienteChamado != null) {

                        System.out.println(
                                "Cliente: " +
                                clienteChamado.getNome()
                        );
                    }

                    if (chamadoDetalhes.tecnico != null) {

                        System.out.println(
                                "Técnico: " +
                                chamadoDetalhes.tecnico.getNome()
                        );

                    } else {

                        System.out.println(
                                "Técnico: Não atribuído"
                        );
                    }

                    if (chamadoDetalhes.getDataEncerramento()
                            != null) {

                        System.out.println(
                                "Data de encerramento: " +
                                chamadoDetalhes.getDataEncerramento()
                        );
                    }

                    System.out.println("\n===== HISTÓRICO =====");

                    ArrayList<Atendimento> historico =
                            historicoChamado.get(chamadoDetalhes);

                    if (historico == null || historico.isEmpty()) {

                        System.out.println(
                                "Nenhum atendimento registrado."
                        );

                    } else {

                        for (Atendimento a : historico) {

                            System.out.println("-----------------------------");

                            System.out.println(
                                    "Data/hora: " +
                                    a.getDataHora()
                            );

                            System.out.println(
                                    "Técnico: " +
                                    a.getRealizadoPor().getNome()
                            );

                            System.out.println(
                                    "Descrição: " +
                                    a.getDescricao()
                            );
                        }
                    }

                    break;
                }


                //ATRIBUIR TÉCNICO

                case 7: {

                    System.out.println(
                            "\n===== ATRIBUIR TÉCNICO ====="
                    );

                    if (tecnicos.isEmpty()) {
                        System.out.println(
                                "Nenhum técnico cadastrado."
                        );
                        break;
                    }

                    System.out.print("ID do chamado: ");
                    long idChamadoTecnico = scanner.nextLong();
                    scanner.nextLine();

                    Chamado chamadoTecnico = null;

                    for (Chamado c : chamados) {

                        if (c.getId() == idChamadoTecnico) {
                            chamadoTecnico = c;
                            break;
                        }
                    }

                    if (chamadoTecnico == null) {
                        System.out.println(
                                "Chamado não encontrado."
                        );
                        break;
                    }

                    System.out.println("\nTécnicos:");

                    for (Tecnico t : tecnicos) {

                        System.out.println(
                                t.getId() + " - " +
                                t.getNome() + " - " +
                                t.getEspecialidade()
                        );
                    }

                    System.out.print("ID do técnico: ");
                    long idTecnicoEscolhido =
                            scanner.nextLong();
                    scanner.nextLine();

                    Tecnico tecnicoEscolhido = null;

                    for (Tecnico t : tecnicos) {

                        if (t.getId() == idTecnicoEscolhido) {
                            tecnicoEscolhido = t;
                            break;
                        }
                    }

                    if (tecnicoEscolhido == null) {
                        System.out.println(
                                "Técnico não encontrado."
                        );
                        break;
                    }

                    chamadoTecnico.atribuirTecnico(
                            tecnicoEscolhido
                    );

                    System.out.println(
                            "Técnico atribuído com sucesso!"
                    );

                    break;
                }


                //REGISTRAR ATENDIMENTO

                case 8: {

                    System.out.println(
                            "\n===== REGISTRAR ATENDIMENTO ====="
                    );

                    System.out.print("ID do chamado: ");
                    long idChamadoAtendimento =
                            scanner.nextLong();
                    scanner.nextLine();

                    Chamado chamadoAtendimento = null;

                    for (Chamado c : chamados) {

                        if (c.getId() ==
                                idChamadoAtendimento) {

                            chamadoAtendimento = c;
                            break;
                        }
                    }

                    if (chamadoAtendimento == null) {

                        System.out.println(
                                "Chamado não encontrado."
                        );

                        break;
                    }

                    if (chamadoAtendimento.tecnico == null) {

                        System.out.println(
                                "O chamado não possui técnico."
                        );

                        break;
                    }

                    System.out.print("ID do atendimento: ");
                    long idAtendimento = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print(
                            "Descrição da solução/ação: "
                    );

                    String descricaoAtendimento =
                            scanner.nextLine();

                    Atendimento novoAtendimento =
                            new Atendimento(
                                    idAtendimento,
                                    LocalDateTime.now(),
                                    descricaoAtendimento,
                                    chamadoAtendimento.tecnico
                            );

                    atendimentos.add(novoAtendimento);

                    historicoChamado
                            .get(chamadoAtendimento)
                            .add(novoAtendimento);

                    chamadoAtendimento.alterarStatus(
                            StatusChamado.EM_ATENDIMENTO
                    );

                    System.out.println(
                            "Atendimento registrado com sucesso!"
                    );

                    break;
                }


                //ALTERAR STATUS

                case 9: {

                    System.out.println(
                            "\n===== ALTERAR STATUS ====="
                    );

                    System.out.print("ID do chamado: ");
                    long idChamadoStatus =
                            scanner.nextLong();
                    scanner.nextLine();

                    Chamado chamadoStatus = null;

                    for (Chamado c : chamados) {

                        if (c.getId() == idChamadoStatus) {
                            chamadoStatus = c;
                            break;
                        }
                    }

                    if (chamadoStatus == null) {

                        System.out.println(
                                "Chamado não encontrado."
                        );

                        break;
                    }

                    System.out.println("\nNovo status:");
                    System.out.println("1 - ABERTO");
                    System.out.println("2 - EM_ATENDIMENTO");
                    System.out.println("3 - AGUARDANDO_CLIENTE");
                    System.out.println("4 - ENCERRADO");

                    System.out.print("Opção: ");
                    int opcaoStatus = scanner.nextInt();
                    scanner.nextLine();

                    StatusChamado novoStatus;

                    if (opcaoStatus == 1) {

                        novoStatus = StatusChamado.ABERTO;

                    } else if (opcaoStatus == 2) {

                        novoStatus =
                                StatusChamado.EM_ATENDIMENTO;

                    } else if (opcaoStatus == 3) {

                        novoStatus =
                                StatusChamado.AGUARDANDO_CLIENTE;

                    } else if (opcaoStatus == 4) {

                        novoStatus =
                                StatusChamado.ENCERRADO;

                    } else {

                        System.out.println(
                                "Status inválido."
                        );

                        break;
                    }

                    chamadoStatus.alterarStatus(
                            novoStatus
                    );

                    System.out.println(
                            "Status alterado com sucesso!"
                    );

                    break;
                }


                //ENCERRAR CHAMADO

                case 10: {

                    System.out.println(
                            "\n===== ENCERRAR CHAMADO ====="
                    );

                    System.out.print("ID do chamado: ");
                    long idEncerrar =
                            scanner.nextLong();
                    scanner.nextLine();

                    Chamado chamadoEncerrar = null;

                    for (Chamado c : chamados) {

                        if (c.getId() == idEncerrar) {
                            chamadoEncerrar = c;
                            break;
                        }
                    }

                    if (chamadoEncerrar == null) {

                        System.out.println(
                                "Chamado não encontrado."
                        );

                        break;
                    }

                    chamadoEncerrar.encerrar();

                    System.out.println(
                            "Chamado encerrado com sucesso!"
                    );

                    break;
                }


                // RELATÓRIOS

                case 11: {

                    System.out.println("\n===== RELATÓRIOS =====");

                    System.out.println(
                            "1 - Chamados por status"
                    );

                    System.out.println(
                            "2 - Chamados por técnico"
                    );

                    System.out.println(
                            "3 - Chamados por período"
                    );

                    System.out.print("Opção: ");
                    int opcaoRelatorio =
                            scanner.nextInt();
                    scanner.nextLine();


                    //RELATÓRIO POR STATUS

                    if (opcaoRelatorio == 1) {

                        int quantidadeAbertos = 0;
                        int quantidadeEmAtendimento = 0;
                        int quantidadeAguardando = 0;
                        int quantidadeEncerrados = 0;

                        for (Chamado c : chamados) {

                            if (c.getStatus() ==
                                    StatusChamado.ABERTO) {

                                quantidadeAbertos++;

                            } else if (
                                    c.getStatus() ==
                                    StatusChamado.EM_ATENDIMENTO) {

                                quantidadeEmAtendimento++;

                            } else if (
                                    c.getStatus() ==
                                    StatusChamado.AGUARDANDO_CLIENTE) {

                                quantidadeAguardando++;

                            } else if (
                                    c.getStatus() ==
                                    StatusChamado.ENCERRADO) {

                                quantidadeEncerrados++;
                            }
                        }

                        System.out.println(
                                "\n===== RELATÓRIO POR STATUS ====="
                        );

                        System.out.println(
                                "Abertos: " +
                                quantidadeAbertos
                        );

                        System.out.println(
                                "Em atendimento: " +
                                quantidadeEmAtendimento
                        );

                        System.out.println(
                                "Aguardando cliente: " +
                                quantidadeAguardando
                        );

                        System.out.println(
                                "Encerrados: " +
                                quantidadeEncerrados
                        );


                    //RELATÓRIO POR TÉCNICO

                    } else if (opcaoRelatorio == 2) {

                        if (tecnicos.isEmpty()) {

                            System.out.println(
                                    "Nenhum técnico cadastrado."
                            );

                            break;
                        }

                        System.out.println("\nTécnicos:");

                        for (Tecnico t : tecnicos) {

                            System.out.println(
                                    t.getId() + " - " +
                                    t.getNome()
                            );
                        }

                        System.out.print(
                                "ID do técnico: "
                        );

                        long idTecnicoRelatorio =
                                scanner.nextLong();
                        scanner.nextLine();

                        boolean encontrou = false;

                        System.out.println(
                                "\n===== CHAMADOS DO TÉCNICO ====="
                        );

                        for (Chamado c : chamados) {

                            if (c.tecnico != null &&
                                    c.tecnico.getId() ==
                                    idTecnicoRelatorio) {

                                encontrou = true;

                                System.out.println(
                                        "ID: " +
                                        c.getId()
                                );

                                System.out.println(
                                        "Título: " +
                                        c.getTitulo()
                                );

                                System.out.println(
                                        "Status: " +
                                        c.getStatus()
                                );

                                System.out.println(
                                        "Prioridade: " +
                                        c.getPrioridade()
                                );

                                System.out.println(
                                        "-----------------------------"
                                );
                            }
                        }

                        if (!encontrou) {

                            System.out.println(
                                    "Nenhum chamado encontrado."
                            );
                        }


                    //RELATÓRIO POR PERÍODO

                    } else if (opcaoRelatorio == 3) {

                        System.out.println(
                                "\nDigite as datas no formato:"
                        );

                        System.out.println(
                                "AAAA-MM-DD"
                        );

                        System.out.print(
                                "Data inicial: "
                        );

                        String dataInicialTexto =
                                scanner.nextLine();

                        System.out.print(
                                "Data final: "
                        );

                        String dataFinalTexto =
                                scanner.nextLine();

                        LocalDate dataInicial =
                                LocalDate.parse(
                                        dataInicialTexto
                                );

                        LocalDate dataFinal =
                                LocalDate.parse(
                                        dataFinalTexto
                                );

                        boolean encontrou = false;

                        System.out.println(
                                "\n===== CHAMADOS DO PERÍODO ====="
                        );

                        for (Chamado c : chamados) {

                            LocalDate dataChamado =
                                    c.getDataAbertura()
                                    .toLocalDate();

                            if (
                                    !dataChamado.isBefore(
                                            dataInicial
                                    )
                                    &&
                                    !dataChamado.isAfter(
                                            dataFinal
                                    )
                            ) {

                                encontrou = true;

                                System.out.println(
                                        "ID: " +
                                        c.getId()
                                );

                                System.out.println(
                                        "Título: " +
                                        c.getTitulo()
                                );

                                System.out.println(
                                        "Data: " +
                                        dataChamado
                                );

                                System.out.println(
                                        "Status: " +
                                        c.getStatus()
                                );

                                System.out.println(
                                        "-----------------------------"
                                );
                            }
                        }

                        if (!encontrou) {

                            System.out.println(
                                    "Nenhum chamado encontrado nesse período."
                            );
                        }


                    } else {

                        System.out.println(
                                "Opção de relatório inválida."
                        );
                    }

                    break;
                }


                //SAIR

                case 0:

                    System.out.println(
                            "\nSistema encerrado."
                    );

                    break;


                //OPÇÃO INVÁLIDA

                default:

                    System.out.println(
                            "\nOpção inválida!"
                    );
            }

        } while (opcao != 0);

        scanner.close();
    }
}