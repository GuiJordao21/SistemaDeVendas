package br.com.fiap.BO;

import br.com.fiap.DAO.ClienteDAO;
import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.beans.ClienteBeans;
import br.com.fiap.beans.EnderecoBeans;
import br.com.fiap.beans.TelefoneBeans;

public class ClienteBO {

	 public static String gravar(ClienteBeans obj,EnderecoBeans e,TelefoneBeans t,String usuario, String senha) throws Exception{
		    if(obj.getNmUsuario().length()==0 || obj.getNmUsuario().length()>40 || obj.getNmUsuario() == null) {
				return "Nome invalido!";
			}
	    	
	    	if (obj.getDsemail().indexOf('@')<0) {
	    	     return "Email Invalido";	
	    	}
	    	
	    	if (obj.getDsemail().length()==0 || obj.getDsemail().length()>40 || obj.getNmUsuario() == null) {
	    		return "Email invalido";
	    	}
	    	
	    	if (obj.getSenha().length()==0 || obj.getSenha().length()>30 || obj.getSenha()== null) {
	    		return "Senha Invalida";
	    	}
	    
	    	if (obj.getRzSocial().length()==0 || obj.getRzSocial().length()>30|| obj.getRzSocial()== null) {
	    		return "Senha Invalida";
	    	}
	    	if (obj.getiE().length()==0 || obj.getiE().length()>30 || obj.getiE()== null) {
	    		return "Senha Invalida";
	    	}
	    	
	    	
	    	//IMPORTANTE ESSA ORDEM
	    	ClienteDAO dao = new ClienteDAO(usuario, senha);
			UsuarioDAO dao2=new UsuarioDAO(usuario, senha);
	    	ClienteBeans resposta = dao.consultar(obj.getDsemail());
	    	if (resposta.getDsemail() == obj.getDsemail()) {
	    		dao.fechar();
	    		return "Cliente ja cadastrado";
	    	}
	    	dao2.gravarUsuario(obj);
	    	String msg = dao.gravar(obj.getDsemail(),obj,e,t,usuario,senha);
	    	dao.fechar();
	    	return msg;
	    }
	
	 
	 
	 
	
	 
	
}






