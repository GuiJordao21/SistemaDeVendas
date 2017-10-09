package br.com.fiap.beans;

import java.io.Serializable;

public class TelefoneBeans implements Comparable<TelefoneBeans>,Serializable{
	
	private static final long serialVersionUID = -3202555297208372907L;
	private int ddd;
	private String numero;
	private int tipoFone;
	private int ramal;
	
	public int compareTo(TelefoneBeans outro){
		return this.numero.compareTo(outro.numero);
	}
	
	public TelefoneBeans() {
		super();
	}
	
	public TelefoneBeans(int ddd, String numero, int ramal, int tipoFone) {
		super();
		setDdd(ddd);
		setNumero(numero);
		setTipoFone(tipoFone);
		setRamal(ramal);
	}
	
	public int getTipoFone() {
		return tipoFone;
	}

	public void setTipoFone(int tipoFone) {
		this.tipoFone = tipoFone;
	}

	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getRamal() {
		return ramal;
	}
	public void setRamal(int ramal) {
		this.ramal = ramal;
	}	
}
