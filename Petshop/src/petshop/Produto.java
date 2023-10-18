package petshop;

class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, String categoria, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void vender(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

	public String toString() {
    return "Nome: " + nome + ", Categoria: " + categoria + ", Preço: " + preco +
           ", Quantidade em Estoque: " + quantidadeEstoque;
	}
}