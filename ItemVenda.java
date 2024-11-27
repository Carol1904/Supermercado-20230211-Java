public class ItemVenda {
    private Produto produto; // Product associated with the sale item
    private int quantidade;  // Quantity of the product sold

    // Constructor of the class that initializes the product and quantity of the sold item
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto; // Assigns the product to the class variable
        this.quantidade = quantidade; // Assigns the quantity to the class variable
    }

    // Getter method to access the product associated with the sale item
    public Produto getProduto() {
        return produto; // Returns the product associated with the sale item
    }

    // Method to calculate the total sale amount (quantity * unit price of the product)
    public double getTotal() {
        return produto.getValorUnitario() * quantidade; // Multiplies the product's unit price by the quantity
    }

    // toString() method to display a textual representation of the sale item
    @Override
    public String toString() {
        return produto.getNome() + " - " + quantidade + " un - Total: R$" + getTotal(); // Returns item information in a readable format
    }
}
