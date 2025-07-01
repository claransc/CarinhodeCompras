import java.util.HashMap;

public class EstoqueProdutos {
    private HashMap<String, ProdutoEstoque> produtos;

    public EstoqueProdutos() {
        produtos = new HashMap<>();
    }

    public void adicionaProduto(ProdutoEstoque produto) {
        produtos.put(produto.getNome().toLowerCase(), produto); // garante case-insensitive
    }

    public ProdutoEstoque buscarProduto(String nome) {
        return produtos.get(nome.toLowerCase());
    }

    public void listarEstoque() {
        System.out.println("\n=== Estoque Atualizado ===");
        for (ProdutoEstoque produto : produtos.values()) {
            System.out.println("Produto: " + produto.getNome() +
                               " | Preço: R$" + produto.getValor() +
                               " | Quantidade: " + produto.getQuantidade());
        }
    }
}
