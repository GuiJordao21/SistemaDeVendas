package br.com.fiap.BO;

import br.com.fiap.DAO.FornecedorDAO;
import br.com.fiap.beans.FornecedorBeans;

public class FornecedorBO {

	public static String cadastrar(FornecedorBeans fb)throws Exception{
		
		if(fb.getEmail().indexOf('@')<0) {
			return "email inválido";
		}
		
		if(fb.getNome().length()==0||fb.getNome().length()>20){
			return "Nome inválido";
		}
		
		if(fb.getCnpj()>14||fb.getCnpj()<14) {
			return "CNPJ inválido";
		}
		
		if(fb.getRzSocial().length()>20||fb.getRzSocial().length()==0) {
			return "razão social inválida";
		}
		
		FornecedorDAO dao=new FornecedorDAO();
		return dao.cadastrar(fb);
		
	}

}
