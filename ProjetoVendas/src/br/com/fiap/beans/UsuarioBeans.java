package br.com.fiap.beans;

import java.io.Serializable;

public class UsuarioBeans implements Comparable<UsuarioBeans>,Serializable{

	private static final long serialVersionUID = -7643631043193667379L;
	private String nmUsuario;
	private String dsemail;
	private String senha;
  
	public int compareTo(UsuarioBeans outro) {
		return this.nmUsuario.compareTo(outro.nmUsuario);
	}
  
	public UsuarioBeans() {}
	
	public UsuarioBeans(String nmUsuario, String dsemail, String senha) {
		super();
		setNmUsuario(nmUsuario);
		setDsemail(dsemail);
		setSenha(senha);	
	}
	
	public String getNmUsuario() {
		return nmUsuario;
	}
	
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario.toUpperCase();
	}
	
	public String getDsemail() {
		return dsemail;
	}
	
	public void setDsemail(String dsemail) {
		this.dsemail = dsemail;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
