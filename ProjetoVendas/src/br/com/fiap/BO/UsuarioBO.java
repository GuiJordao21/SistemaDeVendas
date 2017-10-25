package br.com.fiap.BO;

import java.sql.Connection;

import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.beans.UsuarioBeans;

public class UsuarioBO {

public static boolean logIn(String email, String senhaLog, Connection con) throws Exception{
		
		UsuarioDAO dao=new UsuarioDAO();
		UsuarioBeans ub=dao.logIn(email, senhaLog, con);
	
		if((ub.getDsemail().equals(email))&&(ub.getSenha().equals(senhaLog))){
			return true;
		}else{
			return false;
		}
	}
	
}
