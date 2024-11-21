public abstract class Eletroeletronico extends Produto {
    private int garantiaMeses;

    public Eletroeletronico(String codigo, String nome, double valorUnitario, int quantidadeEstoque, int garantiaMeses) {
        super(codigo, nome, valorUnitario, quantidadeEstoque);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() { return garantiaMeses; }
}
