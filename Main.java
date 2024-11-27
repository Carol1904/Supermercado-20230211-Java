import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creating the inventory system and cash register with an initial balance of R$1000
        SistemaEstoque sistemaEstoque = new SistemaEstoque();
        Caixa caixa = new Caixa(1000.0, sistemaEstoque);

        // Variable to control the main menu loop
        boolean continuar = true;

        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        while (continuar) {
            try {
                // Displaying the menu options in Portuguese
                System.out.println("\nMenu do Caixa:");
                System.out.println("1. Abrir nova venda");
                System.out.println("2. Listar Estoque");
                System.out.println("3. Adicionar Produto ao Estoque");
                System.out.println("4. Remover Produto do Estoque");
                System.out.println("5. Fechar Caixa");
                System.out.println("6. Sair");

                // Check if there's input available from the user
                if (scanner.hasNext()) {
                    String input = scanner.next();  // Capture user input

                    try {
                        // Try to convert the input to an integer
                        int escolha = Integer.parseInt(input);

                        // Switch to handle the user's choice
                        switch (escolha) {
                            case 1:
                                caixa.abrirVenda(scanner); // Call method to open a new sale
                                break;
                            case 2:
                                sistemaEstoque.listarEstoque(); // List the products in inventory
                                break;
                            case 3:
                                adicionarProdutoAoEstoque(sistemaEstoque, scanner); // Call method to add product to inventory
                                break;
                            case 4:
                                removerProdutoDoEstoque(sistemaEstoque, scanner); // Call method to remove product from inventory
                                break;
                            case 5:
                                caixa.fecharCaixa(); // Call method to close the cash register
                                break;
                            case 6:
                                continuar = false; // Exit the loop and the program
                                System.out.println("Encerrando...");
                                break;
                            default:
                                System.out.println("Opção inválida! Digite um número entre 1 e 6.");
                        }

                    } catch (NumberFormatException e) {
                        // Catch exception if input is not a valid number
                        System.out.println("Entrada inválida! Digite um número.");
                    }

                } else {
                    // If no input is available
                    System.out.println("Nenhuma entrada disponível. Encerrando...");
                    continuar = false;  // Exit the loop
                }

            } catch (NoSuchElementException e) {
                // Catch error if input stream is unexpectedly closed
                System.out.println("Erro no fluxo de entrada. Encerrando...");
                break;

            } catch (Exception e) {
                // Catch any other exceptions
                System.out.println("Ocorreu um erro: " + e.getMessage());
                scanner.nextLine();  // Clear the scanner buffer in case of error
            }
        }

        // Close the scanner at the end to avoid resource leakage
        scanner.close();
    }

    // Helper method to add product to the inventory
    private static void adicionarProdutoAoEstoque(SistemaEstoque sistemaEstoque, Scanner scanner) {
        try {
            // Displaying options to choose the type of product
            System.out.println("\nEscolha o tipo de produto:");
            System.out.println("1. Alimento");
            System.out.println("2. Utensílio");
            System.out.println("3. Eletroeletrônico");

            // Capture the product type choice
            int tipoOpcao = scanner.nextInt();
            scanner.nextLine(); // Consume the new line (enter)

            // Collect product information
            System.out.println("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Consume the new line

            System.out.println("Nome: ");
            String nome = scanner.nextLine();

            System.out.println("Valor por unidade: ");
            double valor = scanner.nextDouble();

            System.out.println("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consume the new line

            // Variables for type and validity (if needed)
            String tipo;
            Integer validade = null;  // Validity is optional for some types of product

            // Set the product type based on the choice
            switch (tipoOpcao) {
                case 1:
                    tipo = "Alimento";
                    System.out.println("Validade em dias: ");
                    validade = scanner.nextInt();  // Capture validity if it's food
                    scanner.nextLine(); // Consume the new line
                    break;
                case 2:
                    tipo = "Utensílio";
                    break;
                case 3:
                    tipo = "Eletroeletrônico";
                    break;
                default:
                    System.out.println("Tipo inválido!"); // Error message for invalid type
                    return;
            }

            // Create a Product object with the collected information
            Produto produto = new Produto(codigo, nome, valor, quantidade, tipo, validade);

            // Add the product to the inventory
            sistemaEstoque.adicionarProdutoAoEstoque(produto);

        } catch (Exception e) {
            // Catch error during product addition and display error message
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
            scanner.nextLine(); // Clear the buffer in case of error
        }
    }

    // Helper method to remove a product from the inventory
    private static void removerProdutoDoEstoque(SistemaEstoque sistemaEstoque, Scanner scanner) {
        // Ask for the product code to be removed
        System.out.println("\nDigite o código do produto a ser removido:");

        // Check if the input code is a valid integer
        if (scanner.hasNextInt()) {
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Consume the new line

            // Remove the product from the inventory using the code
            sistemaEstoque.removerProdutoDoEstoque(codigo);
        } else {
            // Display error message if the code is not a valid number
            System.out.println("Código inválido!");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}
