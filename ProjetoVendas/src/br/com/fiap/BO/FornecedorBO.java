package br.com.fiap.BO;

import br.com.fiap.DAO.FornecedorDAO;
import br.com.fiap.beans.EnderecoBeans;
import br.com.fiap.beans.FornecedorBeans;

public class FornecedorBO {

	public static String cadastrar(FornecedorBeans fb,EnderecoBeans e,String usuario, String senha)throws Exception{
		
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
		
		FornecedorDAO dao=new FornecedorDAO(usuario, senha);
		return dao.cadastrar(fb,e,usuario,senha);
		
	}

}
