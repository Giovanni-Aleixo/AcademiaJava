package petshop;

import java.util.ArrayList;
import java.util.Scanner;

public class PetshopAmigoFiel {
    public static void main(String[] args) {
        ArrayList<Animal> listaAnimais = new ArrayList<>();
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        ArrayList<Agenda> listaAgendamentos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n***** Petshop 'Amigo Fiel *****");
            System.out.println("1- Cadastrar Animal");
            System.out.println("2- Cadastrar Produto");
            System.out.println("3- Agendar Serviço");
            System.out.println("4- Vender Produto");
            System.out.println("5- Sair");
            System.out.print("Escolha a opção desejada: ");

            int opcao = scanner.nextInt();
            
            

            switch (opcao) {
                case 1:
                    // Cadastro de Animal
                    System.out.println("--- Cadastro de Animal ---");
                    
                  
                    System.out.print("Nome do animal: ");
                    String nomeAnimal = scanner.next();
                    System.out.print("Espécie: ");
                    String especie = scanner.next();
                    System.out.print("Raça: ");
                    String raca = scanner.next();
                    System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                    String dataNascimento = scanner.next();
                    System.out.print("Proprietário: ");
                    String proprietario = scanner.next();
                    
            
                    Animal novoAnimal = new Animal(nomeAnimal, especie, raca, dataNascimento, proprietario);
                    
                
                    listaAnimais.add(novoAnimal);
                    
                    System.out.println("Animal cadastrado com sucesso!");
                    break;
                    
                case 2:
                  
                    System.out.println("--- Cadastro de Produto ---");

                 // Cadastro de Produto
                    System.out.print("Nome do produto: ");
                    String nomeProduto = scanner.next();
                    System.out.print("Categoria: ");
                    String categoria = scanner.next();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade em Estoque: ");
                    int quantidadeEstoque = scanner.nextInt();

             
                    Produto novoProduto = new Produto(nomeProduto, categoria, preco, quantidadeEstoque);

                   
                    listaProdutos.add(novoProduto);

                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 3:
                  
                    System.out.println("--- Agendamento de Serviço ---");

              
                    System.out.println("Animais disponíveis para agendamento:");
                    for (int i = 0; i < listaAnimais.size(); i++) {
                        System.out.println((i + 1) + ". " + listaAnimais.get(i).getNome());
                    }

                    System.out.print("Escolha o número do animal para o agendamento: ");
                    int escolhaAnimal = scanner.nextInt();

               
                    if (escolhaAnimal < 1 || escolhaAnimal > listaAnimais.size()) {
                        System.out.println("Escolha de animal inválida. Tente novamente.");
                        break;
                    }

                    // Escolha do serviço
                    System.out.println("Serviços disponíveis para agendamento:");
                    System.out.println("1. Banho");
                    System.out.println("2. Tosa");
                    System.out.println("3. Consulta Veterinária");
                    System.out.print("Escolha o número do serviço: ");
                    int escolhaServico = scanner.nextInt();

               
                    Servico servicoAgendado = null;
                    switch (escolhaServico) {
                        case 1:
                            servicoAgendado = new Banho();
                            break;
                        case 2:
                            servicoAgendado = new Tosa();
                            break;
                        case 3:
                            servicoAgendado = new ConsultaVeterinaria();
                            break;
                        default:
                            System.out.println("Escolha de serviço inválida. Tente novamente.");
                            break;
                    }

                    if (servicoAgendado != null) {
                        
                    	// Escolha do agendamento
                        System.out.print("Data do agendamento (dd/mm/aaaa): ");
                        String dataAgendamento = scanner.next();
                        System.out.print("Horário do agendamento: ");
                        String horarioAgendamento = scanner.next();

                      
                        Agenda novoAgendamento = new Agenda(listaAnimais.get(escolhaAnimal - 1), servicoAgendado, dataAgendamento, horarioAgendamento);

                    
                        listaAgendamentos.add(novoAgendamento);

                        System.out.println("Agendamento realizado com sucesso!!");
                    }

                    break;


                case 4:
              
                    System.out.println("--- Venda de Produto ---");

                
                    System.out.println("Produtos disponíveis para venda:");
                    for (int i = 0; i < listaProdutos.size(); i++) {
                        Produto produto = listaProdutos.get(i);
                        System.out.println((i + 1) + ". " + produto.getNome() + " (Preço: " + produto.getPreco() + ", Estoque: " + produto.getQuantidadeEstoque() + ")");
                    }

                    System.out.print("Escolha o número do produto para a venda: ");
                    int escolhaProduto = scanner.nextInt();

                
                    if (escolhaProduto < 1 || escolhaProduto > listaProdutos.size()) {
                        System.out.println("Escolha de produto inválida. Tente novamente.");
                        break;
                    }

                    Produto produtoEscolhido = listaProdutos.get(escolhaProduto - 1);

            
                    System.out.print("Quantidade a ser vendida: ");
                    int quantidadeVendida = scanner.nextInt();

                    if (quantidadeVendida <= 0 || quantidadeVendida > produtoEscolhido.getQuantidadeEstoque()) {
                        System.out.println("Quantidade inválida ou insuficiente em estoque. Tente novamente.");
                        break;
                    }

          
                    produtoEscolhido.vender(quantidadeVendida);

                    System.out.println("Venda realizada com sucesso!");
                    break;

                case 5:
                    System.out.println("Saindo do sistema PetShop AmigoFiel. Obrigado!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por Favor tente novamente.");
                   
            }
        }
    }
}

