package br.com.fiap.beans;

import java.io.Serializable;

public class materiaPrima implements Comparable<materiaPrima>,Serializable{

	private static final long serialVersionUID = -1785634588954720037L;
	private int cdMatPrima;
	private String descricao;
	private double valor;
	private String unidMedida;
	
	public int compareTo(materiaPrima outro){
		return this.descricao.compareTo(outro.descricao);
	}
	
	public materiaPrima() {
		super();		
	}

	public materiaPrima(int cdMatPrima, String descricao, double valor, String unidMedida) {
		super();
		this.cdMatPrima = cdMatPrima;
		this.descricao = descricao;
		this.valor = valor;
		this.unidMedida = unidMedida;
	}

	public int getCdMatPrima() {
		return cdMatPrima;
	}

	public void setCdMatPrima(int cdMatPrima) {
		this.cdMatPrima = cdMatPrima;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUnidMedida() {
		return unidMedida;
	}

	public void setUnidMedida(String unidMedida) {
		this.unidMedida = unidMedida;
	}
}