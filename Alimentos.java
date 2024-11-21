public class Alimentos {
    // Atributos da classe
    private String nome;
    private double preco;
    private int validadeEmDias;

    // Construtor da classe Alimentos
    public Alimentos(String nome, double preco, int validadeEmDias) {
        this.nome = nome;
        this.preco = preco;
        this.validadeEmDias = validadeEmDias;
    }

    // Métodos getters (acessores)
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getValidadeEmDias() {
        return validadeEmDias;
    }

    // Método para verificar se o alimento está dentro da validade
    public boolean estaValido() {
        return validadeEmDias > 0;
    }

    // Método para diminuir a validade do alimento (exemplo de lógica)
    public void passarDia() {
        if (validadeEmDias > 0) {
            validadeEmDias--;
        }
    }

    // Método para exibir informações sobre o alimento
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Validade: " + validadeEmDias + " dias");
        if (estaValido()) {
            System.out.println("O produto está dentro da validade.");
        } else {
            System.out.println("O produto está fora da validade.");
        }
    }
}