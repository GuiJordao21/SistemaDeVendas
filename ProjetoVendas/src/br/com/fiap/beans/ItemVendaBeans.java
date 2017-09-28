package br.com.fiap.beans;

import java.io.Serializable;

public class ItemVendaBeans implements Comparable<ItemVendaBeans>,Serializable{

	private static final long serialVersionUID = 4984584039342664179L;
	private int cd_item;
	private double preco;
	private double qtd;
	private double precoTot;
	
	public int compareTo(ItemVendaBeans outro) {
		if (this.precoTot<outro.precoTot) {
			return 1;
		}else if(this.precoTot>outro.precoTot) {
			return -1;
		}else {
			return 1;
		}	
	}
	
	//construtores
	public ItemVendaBeans() {}
	
	public ItemVendaBeans(int cd_item, double preco, double qtd, double precoTot) {
		super();
		setCd_item(cd_item);
		setPreco(preco);
		setQtd(qtd);
		setPrecoTot(precoTot);
	}
	
	//getters setters
	public int getCd_item() {
		return cd_item;
	}
	public void setCd_item(int cd_item) {
		this.cd_item = cd_item;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getQtd() {
		return qtd;
	}
	public void setQtd(double qtd) {
		this.qtd = qtd;
	}
	public double getPrecoTot() {
		return precoTot;
	}
	public void setPrecoTot(double precoTot) {
		this.precoTot = precoTot;
	}
	
}
