package br.com.fiap.beans;

import java.io.Serializable;

public class ProdutoBeans implements Comparable<ProdutoBeans>,Serializable{

	private static final long serialVersionUID = -4371178774692160793L;
	private int idProd;
	private String nomeProd;
	private String urlImg;
	private double precoProd;
	private String descProd;
	private String disp;
	
	public int compareTo(ProdutoBeans outro) {
		return this.nomeProd.compareTo(outro.nomeProd);
	}
	
	public ProdutoBeans() {
	}

	public ProdutoBeans(int idProd, String nomeProd, String urlImg, double precoProd, String descProd,String disp) {
		super();
		setIdProd(idProd);
		setNomeProd(nomeProd);
		setUrlImg(urlImg);
		setPrecoProd(precoProd);
		setDescProd(descProd);
		setDisp(disp);
	}

	public long getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd.toUpperCase();
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public double getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(double precoProd) {
		this.precoProd = precoProd;
	}

	public String getDescProd() {
		return descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd.toUpperCase();
	}

	public String getDisp() {
		return disp;
	}

	public void setDisp(String disp) {
		this.disp = disp;
	}

}
