package br.com.fiap.BO;

import java.util.List;

import br.com.fiap.DAO.EstoqueDAO;
import br.com.fiap.beans.EstoqueBeans;

public class EstoqueBO {
	
	public static String validaCodigo(int cd) throws Exception{
		if (cd < 0 || cd > 10000) {
			return "Codigo Inválido!";
		}
		return"";
	}
	
	public static String novoEstoque(EstoqueBeans e, String usuario, String senha) throws Exception{
		if(e.getEndereco().getCep().length()!=9 || e.getEndereco().getCep() == null) {
			return "CEP inválido!";
		}
		if(e.getQntLimite()<0 || e.getQntLimite()>999999) {
			return "Quantidade limite inválida!";
		}
		if(e.getDisponibilidade().length()<4
				|| e.getDisponibilidade().length()>20 
				|| e.getDisponibilidade() == null) {
			return "Disponibilidade inválida!";
		}
		String y = new EstoqueDAO(usuario,senha).novoEstoque(e,usuario,senha);
		return y;
	}
	
	public static String deletaEstoque(int cd, String usuario, String senha) throws Exception{
		validaCodigo(cd);
		EstoqueDAO dao=new EstoqueDAO(usuario, senha);
		return dao.deletaEstoque(cd);
	}
	
	public static String atualizaEstoque(EstoqueBeans e, String usuario, String senha) throws Exception{
		if(e.getEndereco().getCep().length()!=9 || e.getEndereco().getCep() == null) {
			return "CEP inválido!";
		}
		if(e.getQntLimite()<0 || e.getQntLimite()>999999) {
			return "Quantidade limite inválida!";
		}
		if(e.getDisponibilidade().length()<4
				|| e.getDisponibilidade().length()>20 
				|| e.getDisponibilidade() == null) {
			return "Disponibilidade inválida!";
		}
		
		EstoqueDAO dao=new EstoqueDAO(usuario, senha);
		return dao.atualizaEstoque(e);
	}
	
	public static EstoqueBeans retornaEstoque(int cd, String usuario, String senha) throws Exception{
		validaCodigo(cd);
		EstoqueDAO dao=new EstoqueDAO(usuario, senha);
		return dao.retornaEstoque(cd);
	}
	
	public static List<EstoqueBeans> listarEstoques(String usuario, String senha) throws Exception{
		EstoqueDAO dao=new EstoqueDAO(usuario, senha);
		return dao.listarEstoques();	
	}
}
