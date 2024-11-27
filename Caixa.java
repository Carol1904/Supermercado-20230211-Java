import java.util.ArrayList;
import java.util.Scanner;

public class Caixa {
    private double saldoInicial;  // Initial balance of the cash register
    private double saldoFinal;    // Final balance after the sales
    private double totalVendas;  // Total accumulated sales
    private SistemaEstoque sistemaEstoque;  // Reference to the inventory system

    // Constructor that initializes the cash register with the initial balance and the inventory system
    public Caixa(double saldoInicial, SistemaEstoque sistemaEstoque) {
        this.saldoInicial = saldoInicial;  // Setting the initial balance
        this.saldoFinal = saldoInicial;    // Initializing the final balance with the initial balance
        this.sistemaEstoque = sistemaEstoque;  // Reference to the inventory system
        this.totalVendas = 0.0;  // Initializing the total sales to 0
        System.out.println("O caixa está iniciando com R$" + saldoInicial);  // Message showing the initial balance
    }

    // Method to open a new sale
    public void abrirVenda(Scanner scanner) {
        ArrayList<Produto> itensVenda = new ArrayList<>();  // List of items to be sold
        double subtotal = 0.0;  // Sale subtotal, starts at 0
        boolean continuarVenda = true;  // Control variable for the sale loop

        // Loop that allows adding products until the user decides not to add more
        while (continuarVenda) {
            System.out.println("\nDigite o código do produto:");  // Prompt for product code
            int codigo = scanner.nextInt();  // Reads the product code
            Produto produto = sistemaEstoque.pesquisarProduto(codigo);  // Searches for the product in the inventory system

            if (produto != null) {  // If the product is found
                System.out.println("Produto encontrado: " + produto.getNome());  // Displays the name of the found product
                System.out.println("Digite a quantidade:");  // Prompt for the quantity
                int quantidade = scanner.nextInt();  // Reads the quantity of the product

                // Checks if there is enough stock for the requested quantity
                if (sistemaEstoque.verificarEstoque(codigo, quantidade)) {
                    sistemaEstoque.atualizarEstoque(codigo, quantidade);  // Updates the stock after the sale
                    subtotal += produto.getValorUnitario() * quantidade;  // Updates the sale subtotal
                    System.out.println("Subtotal atual: R$" + subtotal);  // Displays the current subtotal
                } else {
                    System.out.println("Estoque insuficiente para o produto: " + produto.getNome());  // If stock is insufficient
                }
            } else {
                System.out.println("Produto não encontrado.");  // If the product is not found
            }

            // Asks the user if they want to add more items to the sale
            System.out.println("\nDeseja adicionar mais itens? (s/n)");
            String resposta = scanner.next();  // Reads the response
            if (resposta.equalsIgnoreCase("n")) {  // If the response is "n", stops the sale
                continuarVenda = false;
            }
        }

        // Asks the user if they want to finalize the sale
        System.out.println("\nDeseja finalizar a venda? (s/n)");
        if (scanner.next().equalsIgnoreCase("s")) {  // If the response is "s", finalizes the sale
            finalizarVenda(itensVenda, subtotal);
        } else {
            System.out.println("Venda cancelada.");  // If the user cancels the sale
            sistemaEstoque.reporEstoque(itensVenda);  // Restores stock of the un-sold items
        }
    }

    // Method to finalize the sale
    private void finalizarVenda(ArrayList<Produto> itens, double subtotal) {
        System.out.println("\nResumo da venda:");  // Displays the sale summary
        for (Produto p : itens) {
            System.out.println(p.getNome() + " - R$" + p.getValorUnitario());  // Displays product name and price
        }
        System.out.println("Total da venda: R$" + subtotal);  // Displays total sale amount

        saldoFinal += subtotal;  // Updates the final balance with the sale subtotal
        totalVendas += subtotal;  // Updates the total sales

        // Updates the stock, removing the sold units
        for (Produto produto : itens) {
            sistemaEstoque.atualizarEstoque(produto.getCodigo(), produto.getQuantidade());
        }

        System.out.println("Venda finalizada com sucesso!");  // Success message for the sale
    }

    // Method to close the cash register
    public void fecharCaixa() {
        System.out.println("\nFechamento do caixa:");  // Displays closing information
        System.out.println("Saldo inicial: R$" + saldoInicial);  // Displays the initial balance
        System.out.println("Total em vendas: R$" + totalVendas);  // Displays total sales made
        System.out.println("Saldo final: R$" + saldoFinal);  // Displays the final balance
        System.out.println("Lucro do dia: R$" + (saldoFinal - saldoInicial));  // Displays the profit
    }
}
