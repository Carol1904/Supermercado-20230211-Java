import java.util.ArrayList;

public class SistemaEstoque {
    private ArrayList<Produto> estoque; // List to store the products in stock

    // Constructor: Initializes the stock list
    public SistemaEstoque() {
        estoque = new ArrayList<>(); // Creates an empty list of products
    }

    // Method to add a product to the stock
    public void adicionarProduto(Produto produto) {
        estoque.add(produto); // Adds the product to the stock list
        System.out.println("Produto adicionado: " + produto.getNome()); // Displays a confirmation message
    }

    // Method to list all products in the stock
    public void listarEstoque() {
        if (estoque.isEmpty()) { // Checks if the stock is empty
            System.out.println("Estoque vazio."); // Informs that the stock is empty
            return;
        }
        System.out.println("\nEstoque Atual:");
        for (Produto p : estoque) {
            System.out.println(p); // Displays the information of each product in stock
        }
    }

    // Method to search for a product in the stock by its code
    public Produto pesquisarProduto(int codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) { // If the product is found by its code
                return produto; // Returns the found product
            }
        }
        return null; // Returns null if the product is not found
    }

    // Method to remove a product from the stock by its code
    public boolean removerProduto(int codigo) {
        Produto produto = pesquisarProduto(codigo); // Searches for the product by its code
        if (produto != null) { // If the product is found
            estoque.remove(produto); // Removes the product from stock
            return true; // Returns true to indicate that the product was removed
        }
        return false; // Returns false if the product was not found
    }

    // Method for restocking after a sale cancellation
    public void reporEstoque(ArrayList<Produto> itens) {
        System.out.println("Reposição de estoque após cancelamento.");
    }

    // Additional method to add product to stock (similar to the first one)
    public void adicionarProdutoAoEstoque(Produto produto) {
        estoque.add(produto); // Adds the product to the stock list
        System.out.println("Produto adicionado ao estoque: " + produto.getNome()); // Displays a confirmation message
    }

    // Method to remove product from stock with a custom message
    public boolean removerProdutoDoEstoque(int codigo) {
        Produto produto = pesquisarProduto(codigo); // Searches for the product by its code
        if (produto != null) { // If the product is found
            estoque.remove(produto); // Removes the product from stock
            System.out.println("Produto removido do estoque: " + produto.getNome()); // Displays confirmation message
            return true; // Returns true indicating that the removal was successful
        } else {
            System.out.println("Produto não encontrado no estoque."); // Informs that the product was not found
            return false; // Returns false if the product was not found
        }
    }

    // Method to check if there is enough stock of a product
    public boolean verificarEstoque(int codigo, int quantidade) {
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo && produto.getQuantidade() >= quantidade) {
                return true; // Returns true if there is enough stock
            }
        }
        return false; // Returns false if there is not enough stock or the product does not exist
    }

    // Method to update the stock quantity after a sale
    public void atualizarEstoque(int codigo, int quantidadeVendida) {
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) { // Finds the product by its code
                produto.reduzirQuantidade(quantidadeVendida); // Reduces the quantity of the sold product
                System.out.println("Estoque atualizado: " + produto.getQuantidade() + " unidades restantes de " + produto.getNome());
            }
        }
    }
}
