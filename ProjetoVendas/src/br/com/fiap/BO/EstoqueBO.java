package br.com.fiap.BO;

import java.sql.Connection;
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
	
	public static String novoEstoque(EstoqueBeans e, Connection con) throws Exception{
		if(e.getEndereco().getCep().length()!=8 || e.getEndereco().getCep() == null) {
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
		String y = new EstoqueDAO().novoEstoque(e,con);
		return y;
	}
	
	public static String deletaEstoque(int cd, Connection con) throws Exception{
		validaCodigo(cd);
		EstoqueDAO dao=new EstoqueDAO();
		return dao.deletaEstoque(cd, con);
	}
	
	public static String atualizaEstoque(EstoqueBeans e, Connection con) throws Exception{
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
		
		EstoqueDAO dao=new EstoqueDAO();
		return dao.atualizaEstoque(e, con);
	}
	
	public static EstoqueBeans retornaEstoque(int cd, Connection con) throws Exception{
		validaCodigo(cd);
		EstoqueDAO dao=new EstoqueDAO();
		return dao.retornaEstoque(cd, con);
	}
	
	public static List<EstoqueBeans> listarEstoques(Connection con) throws Exception{
		EstoqueDAO dao=new EstoqueDAO();
		return dao.listarEstoques(con);	
	}
}
