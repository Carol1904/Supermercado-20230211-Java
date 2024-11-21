public abstract class Produto {
    private String codigo;
    private String nome;
    private double valorUnitario;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, double valorUnitario, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void exibirInfoProduto() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Valor Unitário: R$ " + valorUnitario);
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
    }
}
