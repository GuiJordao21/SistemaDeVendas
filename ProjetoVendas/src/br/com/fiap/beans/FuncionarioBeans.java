package br.com.fiap.beans;

public class FuncionarioBeans extends UsuarioBeans{

	private static final long serialVersionUID = -4451495485086372000L;
	private String rg;
	private String cpf;
	private String departamento;
	
	public FuncionarioBeans() {
		super();
	}
	
	public FuncionarioBeans(String nmUsuario, String dsemail, String senha, String rg, String cpf,
			String departamento) {
		super(nmUsuario, dsemail, senha);
		setRg(rg);
		setCpf(cpf);
		setDepartamento(departamento);
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
