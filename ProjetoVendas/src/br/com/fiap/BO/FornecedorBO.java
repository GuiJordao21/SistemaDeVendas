package br.com.fiap.BO;

import br.com.fiap.DAO.FornecedorDAO;
import br.com.fiap.beans.EnderecoBeans;
import br.com.fiap.beans.FornecedorBeans;

public class FornecedorBO {

	public static String cadastrar(FornecedorBeans fb,EnderecoBeans e,String usuario, String senha)throws Exception{
		
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
		
		FornecedorDAO dao=new FornecedorDAO(usuario, senha);
		return dao.cadastrar(fb,e,usuario,senha);
		
	}

}
