package br.com.fiap.beans;

import java.io.Serializable;

public class DepartamentoBeans implements Comparable<DepartamentoBeans>,Serializable{

	private static final long serialVersionUID = -5893910556908862275L;
	private String descricao;
	private int qtdFuncionarios;
	
	public int compareTo(DepartamentoBeans outro){
		return this.descricao.compareTo(outro.descricao);
	}
	
	public DepartamentoBeans() {
		super();
	}
	
	public DepartamentoBeans(String descricao, int qtdFuncionarios) {
		super();
		setDescricao(descricao);
		setQtdFuncionarios(qtdFuncionarios);
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}
	
	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
}
