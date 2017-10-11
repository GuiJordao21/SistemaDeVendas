package br.com.fiap.beans;

import java.io.Serializable;

public class pedidoMatPrima implements Comparable<pedidoMatPrima>,Serializable{

	private static final long serialVersionUID = 224969670048020588L;
	private int qtPedidos;
	private String datapedido;
	private String horapedido;
	private String descricao;
	private double quantProcessada;
	private double vlMatProcessada;
	private String dataProcessamento;
	private String horaProcessamento;
	private double quantFornecida;
	private double vlMatFornecida;
	
	public int compareTo(pedidoMatPrima outro){
		return this.descricao.compareTo(outro.descricao);
	}
	
	public pedidoMatPrima(int qtPedidos, String datapedido, String horapedido, String descricao, double quantProcessada,
			double vlMatProcessada, String dataProcessamento, String horaProcessamento, double quantFornecida,
			double vlMatFornecida) {
		super();
		this.qtPedidos = qtPedidos;
		this.datapedido = datapedido;
		this.horapedido = horapedido;
		this.descricao = descricao;
		this.quantProcessada = quantProcessada;
		this.vlMatProcessada = vlMatProcessada;
		this.dataProcessamento = dataProcessamento;
		this.horaProcessamento = horaProcessamento;
		this.quantFornecida = quantFornecida;
		this.vlMatFornecida = vlMatFornecida;
	}
	public pedidoMatPrima() {
		super();
	
	}
	public int getQtPedidos() {
		return qtPedidos;
	}
	public void setQtPedidos(int qtPedidos) {
		this.qtPedidos = qtPedidos;
	}
	public String getDatapedido() {
		return datapedido;
	}
	public void setDatapedido(String datapedido) {
		this.datapedido = datapedido;
	}
	public String getHorapedido() {
		return horapedido;
	}
	public void setHorapedido(String horapedido) {
		this.horapedido = horapedido;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getQuantProcessada() {
		return quantProcessada;
	}
	public void setQuantProcessada(double quantProcessada) {
		this.quantProcessada = quantProcessada;
	}
	public double getVlMatProcessada() {
		return vlMatProcessada;
	}
	public void setVlMatProcessada(double vlMatProcessada) {
		this.vlMatProcessada = vlMatProcessada;
	}
	public String getDataProcessamento() {
		return dataProcessamento;
	}
	public void setDataProcessamento(String dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}
	public String getHoraProcessamento() {
		return horaProcessamento;
	}
	public void setHoraProcessamento(String horaProcessamento) {
		this.horaProcessamento = horaProcessamento;
	}
	public double getQuantFornecida() {
		return quantFornecida;
	}
	public void setQuantFornecida(double quantFornecida) {
		this.quantFornecida = quantFornecida;
	}
	public double getVlMatFornecida() {
		return vlMatFornecida;
	}
	public void setVlMatFornecida(double vlMatFornecida) {
		this.vlMatFornecida = vlMatFornecida;
	}
	
	
}
