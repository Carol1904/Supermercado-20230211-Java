public class Produto {
    private int codigo; // Unique product code
    private String nome; // Product name
    private double valorUnitario; // Selling price per unit
    private int quantidade; // Available stock quantity
    private String tipo; // Product type (e.g., Food, Utensil, etc.)
    private Integer validade;  // Product validity in days (Can be null)

    // Constructor adjusted to accept nullable validity
    public Produto(int codigo, String nome, double valorUnitario, int quantidade, String tipo, Integer validade) {
        this.codigo = codigo; // Assigns the product code
        this.nome = nome; // Assigns the product name
        this.valorUnitario = valorUnitario; // Assigns the unit price of the product
        this.quantidade = quantidade; // Assigns the initial stock quantity of the product
        this.tipo = tipo; // Assigns the product type (e.g., Food, Utensil, Electronic)
        this.validade = validade; // Assigns the product validity (can be null for products without validity)
    }

    // Getters (methods to access private attributes)
    public int getCodigo() { return codigo; } // Returns the product code
    public String getNome() { return nome; } // Returns the product name
    public double getValorUnitario() { return valorUnitario; } // Returns the unit price of the product
    public int getQuantidade() { return quantidade; } // Returns the product quantity in stock
    public String getTipo() { return tipo; } // Returns the product type
    public Integer getValidade() { return validade; } // Returns the product validity (can be null)

    // Methods for manipulating the quantity of the product in stock
    public void reduzirQuantidade(int qtd) {
        this.quantidade -= qtd; // Reduces the available stock quantity of the product
    }

    public void aumentarQuantidade(int qtd) {
        this.quantidade += qtd; // Increases the available stock quantity of the product
    }

    // Method to generate the product's string representation
    @Override
    public String toString() {
        // Checks if the validity is null. If not, shows the validity; otherwise, it won't be displayed.
        String validadeInfo = (validade != null) ? ", Validade: " + validade + " dias" : "";
        // Returns the full product description, including validity if available
        return "Código: " + codigo + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: R$" + valorUnitario + ", Quantidade: " + quantidade + validadeInfo;
    }
}
