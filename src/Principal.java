import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        CarrinhoCompra carrinho = new CarrinhoCompra(estoque);
        Scanner sc = new Scanner(System.in);

        boolean executando = true;

        estoque.adicionaProduto(new ProdutoEstoque("monitor", 500.0, 100));
        estoque.adicionaProduto(new ProdutoEstoque("telefone", 150.0, 300));
        estoque.adicionaProduto(new ProdutoEstoque("teclado", 70.0, 50));
        estoque.adicionaProduto(new ProdutoEstoque("mouse", 50.0, 50));


        while (executando) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Adicionar produto ao estoque");
            System.out.println("2. Ver estoque");
            System.out.println("3. Adicionar item ao carrinho");
            System.out.println("4. Ver carrinho (nota fiscal)");
            System.out.println("5. Finalizar compra");
            System.out.println("6. Remover item do carrinho"); 
            System.out.println("7. Sair"); 
            System.out.print("Escolha uma opção: ");
            

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço do produto: ");
                    double preco = sc.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    estoque.adicionaProduto(new ProdutoEstoque(nome, preco, qtd));
                    break;

                case 2:
                    estoque.listarEstoque();
                    break;

                case 3:
                    System.out.print("Nome do produto que deseja comprar: ");
                    String nomeItem = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtdItem = sc.nextInt();
                    carrinho.adicionaItem(new Item(nomeItem, qtdItem));
                    break;

                case 4:
                    carrinho.mostrarNotaFiscal();
                    break;

                case 5:
                    carrinho.finalizaCompra();
                    carrinho.mostrarNotaFiscal();
                    estoque.listarEstoque();
                    break;

                case 6:
                System.out.print("Digite o nome do item que deseja remover do carrinho: ");
                String itemRemover = sc.nextLine();
                carrinho.removerItem(itemRemover);
                    break;

                case 7:
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
