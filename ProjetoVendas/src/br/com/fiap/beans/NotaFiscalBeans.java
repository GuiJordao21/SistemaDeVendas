package br.com.fiap.beans;

public class NotaFiscalBeans {
	
	private int cd;
	private String tipo=new String();
	private String emissao=new String();
	private double valorTot;
	
	public NotaFiscalBeans() {}
	
	public NotaFiscalBeans(String tipo, String emissao, double valorTot) {
		super();
		this.tipo = tipo;
		this.emissao = emissao;
		this.valorTot = valorTot;
	}
	
	public NotaFiscalBeans(int cd, String tipo, String emissao, double valorTot) {
		super();
		this.cd=cd;
		this.tipo = tipo;
		this.emissao = emissao;
		this.valorTot = valorTot;
	}
	
	//GETTERS SETTERS//GETTERS SETTERS
	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEmissao() {
		return emissao;
	}
	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}
	public double getValorTot() {
		return valorTot;
	}
	public void setValorTot(double valorTot) {
		this.valorTot = valorTot;
	}
	
}
