package model;

public class JavaBeans {

	private String idcon;
	private String nome;
	private String categoria;
	private String total;
	
	public void salvar() {
		new DAO().inserirAtleta(this);
	}
	
	
	public JavaBeans(String idcon, String nome, String categoria, String total) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.categoria = categoria;
		this.total = total;
	}
	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	public JavaBeans() {
		super();
		
	}
	
	
	
	
	
	
	
}
