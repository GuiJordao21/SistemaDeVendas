package br.com.fiap.beans;

import java.io.Serializable;

public class EstoqueBeans implements Comparable<EstoqueBeans>,Serializable{

	private static final long serialVersionUID = 5587197232126332487L;
	private int qntLimite;
	private String disponibilidade;
	private EnderecoBeans endereco;
	
	public int compareTo(EstoqueBeans outro){
		return this.endereco.compareTo(outro.endereco);
	}
	
	public EstoqueBeans() {
		super();
	}
	
	public EstoqueBeans(int qntLimite, String disponibilidade) {
		super();
		setQntLimite(qntLimite);
		setDisponibilidade(disponibilidade);
	}

	public EstoqueBeans(int qntLimite, String disponibilidade, EnderecoBeans endereco) {
		super();
		setQntLimite(qntLimite);
		setDisponibilidade(disponibilidade);
		setEndereco(endereco);
	}
	
	public int getQntLimite() {
		return qntLimite;
	}
	public void setQntLimite(int qntLimite) {
		this.qntLimite = qntLimite;
	}
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public EnderecoBeans getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoBeans endereco) {
		this.endereco = endereco;
	}
}