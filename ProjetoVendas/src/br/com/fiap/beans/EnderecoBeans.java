package br.com.fiap.beans;

import java.io.Serializable;

public class EnderecoBeans implements Serializable,Comparable<EnderecoBeans>{
	
	private static final long serialVersionUID = -1688725306809489939L;
	private int numero;
	private String cep = new String();
	private String complemento=new String();
	private String tipoLog=new String();
	private String nomeRua=new String();
	private String bairro=new String();
	private String cidade=new String();
	private String estado=new String();
	
	public int compareTo(EnderecoBeans outro){
		return this.estado.compareTo(outro.estado);
	}
	
	public EnderecoBeans(){}
	
	public EnderecoBeans(int numero,String cep, String complemento){		
		setNumero(numero);
		setCep(cep);
		setComplemento (complemento);		
	}
	
	public EnderecoBeans(int numero,String cep, String complemento, String tipoLog, String nomeRua, String bairro, String cidade,
			String estado) {
		setNumero(numero);
		setCep(cep);
		setComplemento (complemento);
		setTipoLog(tipoLog);
		setNomeRua(nomeRua);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
	}
	
	//getters setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep.toUpperCase();
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento.toUpperCase();
	}
	public String getTipoLog() {
		return tipoLog;
	}
	public void setTipoLog(String tipoLog) {
		this.tipoLog = tipoLog.toUpperCase();
	}
	public String getNomeRua() {
		return nomeRua;
	}
	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua.toUpperCase();
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado.toUpperCase();
	}
}
