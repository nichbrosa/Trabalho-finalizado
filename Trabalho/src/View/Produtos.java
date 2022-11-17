package View;

public class Produtos {
	private int id;
	private String produto;
	private int quantidade;
	
	public Produtos(String produto) {
		super();
		this.produto = produto;
	}
	
	public Produtos(int id) {
		super();
		this.id = id;
	}

	public Produtos(int id, String produto) {
		super();
		this.id = id;
		this.produto = produto;
	}

	public Produtos(int id, String Produto, int quantidade) {
		super();
		this.id = id;
		this.produto = Produto;
		this.quantidade = quantidade;
	}

	public Produtos(String produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
