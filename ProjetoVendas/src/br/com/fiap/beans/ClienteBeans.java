package br.com.fiap.beans;

public class ClienteBeans extends UsuarioBeans implements Serializable{

	private int cdUsuario;
	private int cnpj;
	private String rzSocial;
	private String iE;
	private String url;
	
	
	public ClienteBeans() {
		super();

	}
	public ClienteBeans(String nmUsuario, String dsemail, String senha) {
		super(nmUsuario, dsemail, senha);

	}
	public ClienteBeans(String nmUsuario, String dsemail, String senha, int cdUsuario, int cnpj, String rzSocial, String iE,
			String url) {
		super(nmUsuario, dsemail, senha);
		this.cdUsuario = cdUsuario;
		this.cnpj = cnpj;
		this.rzSocial = rzSocial;
		this.iE = iE;
		this.url = url;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public String getRzSocial() {
		return rzSocial;
	}
	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}
	public String getiE() {
		return iE;
	}
	public void setiE(String iE) {
		this.iE = iE;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
}