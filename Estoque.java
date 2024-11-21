import java.util.ArrayList;

public class Estoque<Produto> {
    private ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto buscarProduto(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().contains(codigo)) return p;
        }
        return null;
    }

    public void removerProduto(String codigo) {
        produtos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    public void atualizarEstoque(String codigo, int quantidadeVendida) {
        Produto produto = buscarProduto(codigo);
        if (produto != null) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidadeVendida);
        }
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }
}