package br.com.fiap.BO;

import br.com.fiap.beans.TelefoneBeans;
import br.com.fiap.DAO.TelefoneDAO;

public class TelefoneBO {
	TelefoneDAO dao = null;
	
	public static String validaEmail(String email) throws Exception{
		if(email.indexOf('@')<1 || email.indexOf('@')>1 || email.length()>20) {
			return "Email inválido!";
		}
		return"";
	}
	
	public static String novoTelefone(int ex, TelefoneBeans t, String usuario, String senha) throws Exception{

		if(t.getDdd()<99 || t.getDdd()>100) {
			return "DDD inválido!";
		}
		if(t.getNumero().length()<8 || t.getNumero().length()>9 || t.getNumero() == null) {
			return "Numero Inválido!";
		}
		if(t.getRamal()==0) {
			return "Ramal inválido!";
		}
		new TelefoneDAO(usuario, senha).novoTelefone(ex, t);
		return "";
	}

	public static String deletaTelefone(String email, String usuario, String senha) throws Exception{
		validaEmail(email);
		new TelefoneDAO(usuario, senha).deletaTelefone(email);
		return"";
	}

	public static String atualizaTelefone(TelefoneBeans t, String email, String usuario, String senha) throws Exception{
		validaEmail(email);
		if(t.getDdd()<99 || t.getDdd()>100) {
			return "DDD inválido!";
		}
		if(t.getNumero().length()<8 || t.getNumero().length()>9 || t.getNumero() == null) {
			return "Numero Inválido!";
		}
		if(t.getRamal()==0) {
			return "Ramal inválido!";
		}
		new TelefoneDAO(usuario, senha).atualizaTelefone(t, email);
		return"";
	}
}

