package br.com.fiap.beans;

import java.io.Serializable;

public class NotaFiscalBeans implements Comparable<NotaFiscalBeans>,Serializable{

	private static final long serialVersionUID = 6983158163017336573L;
	private int cd;
	private String tipo=new String();
	private String emissao=new String();
	private double valorTot;
	
	public int compareTo(NotaFiscalBeans outro) {
		if (this.valorTot>outro.valorTot) {
			return 1;
		}else if(this.valorTot<outro.valorTot) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public NotaFiscalBeans() {}
	
	public NotaFiscalBeans(String tipo, String emissao, double valorTot) {
		setTipo(tipo);
		setEmissao(emissao);
		setValorTot(valorTot);
	}
	
	public NotaFiscalBeans(int cd, String tipo, String emissao, double valorTot) {
		setCd(cd);
		setTipo(tipo);
		setEmissao(emissao);
		setValorTot(valorTot);
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
		this.tipo = tipo.toUpperCase();
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
