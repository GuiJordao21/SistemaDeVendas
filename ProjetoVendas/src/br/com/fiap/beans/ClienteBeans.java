package br.com.fiap.beans;

import java.io.Serializable;

public class ClienteBeans extends UsuarioBeans implements Serializable{

	private static final long serialVersionUID = -8674589315074693334L;
	private int cdUsuario;
	private long cnpj;
	private String rzSocial;
	private String iE;
	private String url;

	
	public ClienteBeans() {
		super();
	}
	
	public ClienteBeans(int cdUsuario) {
		setCdUsuario(cdUsuario);
	}
	
	public ClienteBeans(String nmUsuario, String dsemail, String senha) {
		super(nmUsuario, dsemail, senha);
	}
	
	public ClienteBeans(String nmUsuario, String dsemail, String senha, long cnpj, String rzSocial, String iE,
			String url) {
		super(nmUsuario, dsemail, senha);
		setCnpj(cnpj);
		setRzSocial(rzSocial);
		setiE(iE);
		setUrl(url);
	}
	
	public ClienteBeans(String nmUsuario, String dsemail, String senha, int cdUsuario, long cnpj, String rzSocial, String iE,
			String url) {
		super(nmUsuario, dsemail, senha);
		setCdUsuario(cdUsuario);
		setCnpj(cnpj);
		setRzSocial(rzSocial);
		setiE(iE);
		setUrl(url);
	}
	
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
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
	public String getiE() {
		return iE;
	}
	public void setiE(String iE) {
		this.iE = iE.toUpperCase();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
}