import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 0;
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ProdutorDAO produtorDAO = new ProdutorDAO();
        Scanner scan = new Scanner(System.in);

        System.out.println("Seja bem vindo ao projeto! \n");

        do {
            System.out.println("\nO que deseja fazer?");
            System.out.println("[1] - Cadastro de cliente.");
            System.out.println("[2] - Cadastro de produtor.");
            System.out.println("[3] - Cadastro de produto.");
            System.out.println("[4] - Sair.");
            a = scan.nextInt();

            switch (a) {
                case 1:
                    Cliente cliente = new Cliente();

                    System.out.println("Qual é o nome de usuário do cliente?");
                    cliente.setNomeDeUsuario(scan.next());
                    System.out.println("Qual é o email do cliente?");
                    cliente.setEmail(scan.next());
                    System.out.println("Qual é o telefone do cliente?");
                    cliente.setTelefone(scan.next());
                    System.out.println("Qual é a senha do cliente?");
                    cliente.setSenha(scan.next());

                    System.out.println("\nCliente cadastrado com sucesso!");
                    System.out.println("Detalhes do cliente:");
                    System.out.println("Nome de usuário: " + cliente.getNomeDeUsuario());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    System.out.println("Senha: " + cliente.getSenha());

                    try {
                        int resultado = clienteDAO.gravar(cliente);

                        if (resultado > 0) {
                            System.out.println("\nCliente cadastrado com sucesso no banco de dados!");
                        } else {
                            System.out.println("\nErro ao cadastrar o cliente no banco de dados.");
                        }
                    } catch (Exception ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }

                    break;
                case 2:
                    Produto produto = new Produto();

                    System.out.println("Qual é o nome do produto?");
                    produto.setNomeProduto(scan.next());
                    System.out.println("Qual é o preço do produto?");
                    produto.setPrecoProduto(scan.nextDouble());
                    System.out.println("Qual é a unidade de medida do produto?");
                    produto.setUnidadeDeMedida(scan.next());
                    System.out.println("Qual é o peso do produto?");
                    produto.setPeso(scan.nextDouble());
                    System.out.println("Qual é a quantidade em estoque do produto?");
                    produto.setQtdeProduto(scan.nextInt());

                    System.out.println("\nProduto cadastrado com sucesso!");
                    System.out.println("Detalhes do produto:");
                    System.out.println("Nome: " + produto.getNomeProduto());
                    System.out.println("Preço: " + produto.getPrecoProduto());
                    System.out.println("Unidade de medida: " + produto.getUnidadeDeMedida());
                    System.out.println("Peso: " + produto.getPeso());
                    System.out.println("Quantidade: " + produto.getQtdeProduto());

                    try {
                        int resultado = produtoDAO.gravar(produto);

                        if (resultado > 0) {
                            System.out.println("\nProduto cadastrado com sucesso no banco de dados!");
                        } else {
                            System.out.println("\nErro ao cadastrar o produto no banco de dados.");
                        }
                    } catch (Exception ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }

                    break;

                case 3:
                    Produtor produtor = new Produtor();

                    System.out.println("Qual é o nome de usuário do produtor?");
                    produtor.setNomeDeUsuario(scan.next());
                    System.out.println("Qual é o email do produtor?");
                    produtor.setEmail(scan.next());
                    System.out.println("Qual é o telefone do produtor?");
                    produtor.setTelefone(scan.next());
                    System.out.println("Qual é a senha do produtor?");
                    produtor.setSenha(scan.next());
                    System.out.println("Qual é o certificado do produtor?");
                    produtor.setCertificado(scan.next());

                    System.out.println("\nProdutor cadastrado com sucesso!");
                    System.out.println("Detalhes do produtor:");
                    System.out.println("Nome de usuário: " + produtor.getNomeDeUsuario());
                    System.out.println("Email: " + produtor.getEmail());
                    System.out.println("Telefone: " + produtor.getTelefone());
                    System.out.println("Senha: " + produtor.getSenha());
                    System.out.println("Certificado: " + produtor.getCertificado());

                    try {
                        int resultado = produtorDAO.gravar(produtor);

                        if (resultado > 0) {
                            System.out.println("\nProdutor cadastrado com sucesso no banco de dados!");
                        } else {
                            System.out.println("\nErro ao cadastrar o produtor no banco de dados.");
                        }
                    } catch (Exception ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (a != 4);

        System.out.println("Programa encerrado.");
        scan.close();
    }
}
