package br.com.fiap.BO;

import br.com.fiap.beans.FuncionarioBeans;
import br.com.fiap.DAO.FuncionarioDAO;

public class FuncionarioBO {
	
	public static String novoFuncionario(FuncionarioBeans f, String usuario, String senha) throws Exception{
		if(f.getNmUsuario().length()<3 || f.getNmUsuario().length() > 20 || f.getNmUsuario() == null) {
			return "Nome de funcionário inválido!";
		}
		if(f.getDsemail() == null || f.getDsemail().indexOf('@')<1 || f.getDsemail().indexOf('@')>1) {
			return "Email inválido!";
		}
		if(f.getSenha() == null || f.getSenha().length()<4 || f.getSenha().length()>20){
			return "Senha inválida!";
		}
		if(f.getRg() == null || f.getRg().length()<9 || f.getRg().length()>10) {
			return "RG inválido!";
		}
		if(f.getCpf() == null || f.getCpf().length()!=14) {
			return "CPF invalido";
		}
		new FuncionarioDAO(usuario, senha).novoFuncionario(f);
		return "";
	}
	
	public static String atualizaFuncionario(FuncionarioBeans f, String usuario, String senha) throws Exception{
		if(f.getNmUsuario().length()<3 || f.getNmUsuario().length() > 20 || f.getNmUsuario() == null) {
			return "Nome de funcionário inválido!";
		}
		if(f.getDsemail() == null || f.getDsemail().indexOf('@')<1 || f.getDsemail().indexOf('@')>1) {
			return "Email inválido!";
		}
		if(f.getSenha() == null || f.getSenha().length()<4 || f.getSenha().length()>20){
			return "Senha inválida!";
		}
		if(f.getRg() == null || f.getRg().length()<9 || f.getRg().length()>10) {
			return "RG inválido!";
		}
		if(f.getCpf() == null || f.getCpf().length()!=14) {
			return "CPF invalido";
		}
		new FuncionarioDAO(usuario, senha).atualizaFuncionario(f);
		return"";
	}
	
	public static String validaEmail(String email) throws Exception{
		if(email.indexOf('@')<1 || email.indexOf('@')>1 || email.length()>20) {
			return "Email inválido!";
		}
		return"";
	}
	
	public static String deletaFuncionario(String email, String usuario, String senha) throws Exception {
		validaEmail(email);
		new FuncionarioDAO(usuario, senha).deletaFuncionario(email);
		return"";
	}
	
	public static String retornaFuncionario(String email, String usuario, String senha) throws Exception{
		validaEmail(email);
		new FuncionarioDAO(usuario, senha).retornaFuncionario(email);
		return"";
	}
}
