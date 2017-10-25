package br.com.fiap.BO;

import java.sql.Connection;

import br.com.fiap.DAO.EnderecoDAO;
import br.com.fiap.beans.EnderecoBeans;

public class EnderecoBO{
	
	public static String cadastrar(int cdU,EnderecoBeans e, Connection con) throws Exception{
		
		EnderecoDAO dao=new EnderecoDAO();
		return dao.novoEndereco(cdU,e,con);
		
	}

}
