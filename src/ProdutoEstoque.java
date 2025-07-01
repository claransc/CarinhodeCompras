public class ProdutoEstoque {
    private String nome;
    private double valor;
    private int quantidade;

    public ProdutoEstoque(String nome, double valor, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;

    
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean temEstoque(int qtd) {
        return quantidade >= qtd;
    }

    public void debitarQuantidade(int qtd) {
        if (temEstoque(qtd)) {
            this.quantidade -= qtd;
        }
    }
}

