package br.com.fiap.BO;

import br.com.fiap.DAO.EnderecoDAO;
import br.com.fiap.beans.EnderecoBeans;

public class EnderecoBO{
	
	public static String cadastrar(int cdU,EnderecoBeans e,String usuario,String senha) throws Exception{
		
		EnderecoDAO dao=new EnderecoDAO(usuario,senha);
		return dao.novoEndereco(cdU,e);
		
	}

}
