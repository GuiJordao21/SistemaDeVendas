package br.com.fiap.beans;

public class VendaBeans {
	
	private int cd;
	private double valor;
	private String data=new String();
	private String hora=new String();
		
	public VendaBeans(double valor, String data, String hora) {
		super();
		setValor(valor);
		setData(data);
		setHora(hora);
	}
	
	public VendaBeans(int cd, double valor, String data, String hora) {
		super();
		setCd(cd);
		setValor(valor);
		setData(data);
		setHora(hora);
	}
	
	public VendaBeans() {}
	
	public VendaBeans(int cd) {
		setCd(cd);
	}
	
	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
