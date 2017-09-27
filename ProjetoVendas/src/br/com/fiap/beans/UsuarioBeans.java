package br.com.fiap.beans;

public class UsuarioBeans {
  
  
  private String nmUsuario;
  private String dsemail;
  private String senha;
  
  
public UsuarioBeans() {
	super();
	// TODO Auto-generated constructor stub
}



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
	this.nmUsuario = nmUsuario;
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
