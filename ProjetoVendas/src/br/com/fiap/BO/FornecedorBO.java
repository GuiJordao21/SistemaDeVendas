package br.com.fiap.BO;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.DAO.FornecedorDAO;
import br.com.fiap.beans.EnderecoBeans;
import br.com.fiap.beans.FornecedorBeans;

public class FornecedorBO {

	public static String cadastrar(FornecedorBeans fb,EnderecoBeans e, Connection con)throws Exception{
		
		if(fb.getEmail().indexOf('@')<0) {
			return "email inv�lido";
		}
		
		if(fb.getNome().length()==0||fb.getNome().length()>20){
			return "Nome inv�lido";
		}
		
		if(fb.getCnpj()>14||fb.getCnpj()<14) {
			return "CNPJ inv�lido";
		}
		
		if(fb.getRzSocial().length()>20||fb.getRzSocial().length()==0) {
			return "raz�o social inv�lida";
		}
		
		FornecedorDAO dao=new FornecedorDAO();
		String x=dao.cadastrar(fb, e, con);
		
		return x;
		
	}
	
	public static List<FornecedorBeans> consultarNome(String nome, Connection con)throws Exception{
		
		FornecedorDAO dao=new FornecedorDAO();
		List<FornecedorBeans> lista=dao.consultarNome(nome,con);
		return lista;
		
	}
	
	public static String deletar(int cd, Connection con)throws Exception{
		
		FornecedorDAO dao=new FornecedorDAO();
		return dao.deletar(cd, con);
		
	}

}
