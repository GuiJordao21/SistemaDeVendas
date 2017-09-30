package br.com.fiap.retorno;

import java.io.Serializable;

import br.com.fiap.beans.ClienteBeans;
import br.com.fiap.beans.NotaFiscalBeans;
import br.com.fiap.beans.VendaBeans;

public class RetornoVenda implements Serializable,Comparable<RetornoVenda>{

	private static final long serialVersionUID = -430283974611310127L;
	private VendaBeans v;
	private NotaFiscalBeans n;
	private ClienteBeans c;
	
	public int compareTo(RetornoVenda outro) {
		return this.c.compareTo(outro.c);
	}
	
	public RetornoVenda() {}
	
	public RetornoVenda(VendaBeans v, NotaFiscalBeans n, ClienteBeans c) {
		super();
		this.v = v;
		this.n = n;
		this.c = c;
	}
	
	public VendaBeans getV() {
		return v;
	}
	public void setV(VendaBeans v) {
		this.v = v;
	}
	public NotaFiscalBeans getN() {
		return n;
	}
	public void setN(NotaFiscalBeans n) {
		this.n = n;
	}
	public ClienteBeans getC() {
		return c;
	}
	public void setC(ClienteBeans c) {
		this.c = c;
	}
	
}
