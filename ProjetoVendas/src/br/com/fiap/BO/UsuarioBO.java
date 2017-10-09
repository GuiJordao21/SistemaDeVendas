package br.com.fiap.BO;

import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.beans.UsuarioBeans;

public class UsuarioBO {

public static boolean logIn(String email, String senhaLog,String usuario, String senha) throws Exception{
		
		UsuarioDAO dao=new UsuarioDAO(usuario, senha);
		UsuarioBeans ub=dao.logIn(email, senhaLog);
	
		if((ub.getDsemail().equals(email))&&(ub.getSenha().equals(senhaLog))){
			return true;
		}else{
			return false;
		}
	}
	
}
