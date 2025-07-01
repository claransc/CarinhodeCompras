//import java.util.ArrayList;
import java.util.HashMap;

public class CarrinhoCompra {
    private EstoqueProdutos estoque;
    private HashMap<String, Item> itens;


    public CarrinhoCompra(EstoqueProdutos estoque) {
        this.estoque = estoque;
        this.itens = new HashMap<>();
    }

    public void adicionaItem(Item novoItem) {
    ProdutoEstoque produto = estoque.buscarProduto(novoItem.getNome());
    
    if (produto == null) {
        System.out.println("Produto não encontrado no estoque.");
        return;
    }

    int qtdDisponivel = produto.getQuantidade();
    int qtdNova = novoItem.getQuantidade();

    Item itemExistente = itens.get(novoItem.getNome());

    // Se já existe no carrinho, soma as quantidades
    int qtdTotal = (itemExistente != null ? itemExistente.getQuantidade() : 0) + qtdNova;

    if (qtdTotal > qtdDisponivel) {
        System.out.println(" Estoque insuficiente. Só temos " + qtdDisponivel + " unidades.");
        return;
    }

    itens.put(novoItem.getNome(), new Item(novoItem.getNome(), qtdTotal));
    System.out.println(" Item '" + novoItem.getNome() + "' atualizado no carrinho com " + qtdTotal + " unidade(s).");
}
//itens.values adicionando o mesmo item várias vezes, o carrinho soma as quantidades automaticamente, e respeita o limite do estoque.

    public void finalizaCompra() {
        for (Item item : itens.values()) {
            ProdutoEstoque produto = estoque.buscarProduto(item.getNome());
            if (produto != null) {
                produto.debitarQuantidade(item.getQuantidade());
            }
        }
        System.out.println("✅ Compra finalizada!");
    }

    public void removerItem(String nomeItem) {
    if (itens.containsKey(nomeItem)) {
        itens.remove(nomeItem);
        System.out.println("Item '" + nomeItem + "' removido do carrinho.");
    } else {
        System.out.println("Item não encontrado no carrinho.");
    }
}


    public double calculaTotal() {
        double total = 0;
        for (Item item : itens.values()) {
            ProdutoEstoque produto = estoque.buscarProduto(item.getNome());
            if (produto != null) {
                total += produto.getValor() * item.getQuantidade();
            }
        }
        return total;
    }

    public void mostrarNotaFiscal() {
        System.out.println("\n=== Nota Fiscal ===");
        for (Item item : itens.values()) {
            ProdutoEstoque produto = estoque.buscarProduto(item.getNome());
            if (produto != null) {
                double subtotal = produto.getValor() * item.getQuantidade();
                System.out.println(item.getNome() + " x" + item.getQuantidade() + " = R$" + subtotal);
            }
        }
        System.out.println("Total: R$" + calculaTotal());
    }
}



