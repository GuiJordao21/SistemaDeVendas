package br.com.fiap.beans;

import java.io.Serializable;

public class ClassFiscalBeans implements Comparable<ClassFiscalBeans>,Serializable{
	
	private static final long serialVersionUID = 2952486963567417844L;
	private int cfop;
	private String operacao=new String();
	
	public int compareTo(ClassFiscalBeans outro) {
		return this.operacao.compareTo(outro.operacao);
	}
	
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
