package br.com.fiap.beans;

public class ClassFiscalBeans {
	
	private int cfop;
	private String operacao=new String();
	
	public ClassFiscalBeans() {}
	
	public ClassFiscalBeans(String operacao) {
		setOperacao(operacao);
	}
	
	public ClassFiscalBeans(int cfop, String operacao) {
		super();
		setCfop(cfop);
		setOperacao(operacao);
	}
	public int getCfop() {
		return cfop;
	}
	public void setCfop(int cfop) {
		this.cfop = cfop;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao.toUpperCase();
	}
	
	

}
