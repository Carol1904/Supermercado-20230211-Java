public class Caixa {
    private double saldoInicial;
    private double saldoAtual;

    public Caixa(double saldoInicial) {
        this.saldoInicial = saldoInicial;
        this.saldoAtual = saldoInicial;
    }

    public void abrirCaixa() {
        System.out.println("O caixa está iniciando com o valor: R$ " + saldoInicial);
    }

    public void registrarVenda(double valor) {
        saldoAtual += valor;
    }

    public void fecharCaixa() {
        System.out.println("Saldo final do caixa: R$ " + saldoAtual);
        System.out.println("Lucro do dia: R$ " + (saldoAtual - saldoInicial));
    }
}