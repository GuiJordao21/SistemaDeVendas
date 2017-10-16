package br.com.fiap.beans;

import java.io.Serializable;

public class FornecedorBeans implements Serializable,Comparable<FornecedorBeans>{

	private static final long serialVersionUID = -879717588533084464L;
	private int cd;
	private String nome=new String();
	private String email=new String();
	private long cnpj;
	private String rzSocial=new String();
	private int cdm;

	public int compareTo(FornecedorBeans outro){
		return this.rzSocial.compareTo(outro.rzSocial);
	}
	
	public FornecedorBeans(){}
	
	public FornecedorBeans(String nome, String email, long cnpj, String rzSocial) {
		setNome(nome);
		setEmail(email);
		setCnpj(cnpj);
		setRzSocial(rzSocial);
	}
	
	public FornecedorBeans(int cd, String nome, String email, long cnpj, String rzSocial,int cdm) {
		setCd(cd);
		setNome(nome);
		setEmail(email);
		setCnpj(cnpj);
		setRzSocial(rzSocial);
		setCdm(cdm);
	}
	
	//getters setters
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public String getRzSocial() {
		return rzSocial;
	}
	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial.toUpperCase();
	}
	public int getCdm() {
		return cdm;
	}
	public void setCdm(int cdm) {
		this.cdm = cdm;
	}
}
