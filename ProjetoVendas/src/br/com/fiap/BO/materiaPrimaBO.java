package br.com.fiap.BO;

import java.sql.Connection;

import br.com.fiap.DAO.materiaPrimaDAO;
import br.com.fiap.beans.materiaPrima;

public class materiaPrimaBO {

	public static String validaCodigo(int cd)throws Exception{
		if(cd<0 || cd>9999){
			return "Codigo inválido!";
		}
		return"";
	}

	public static String Gravar(materiaPrima m, Connection con) throws Exception{
		if(m.getCdMatPrima()<0 || m.getCdMatPrima()>9999) {
			return "Codigo inválido!";
		}
		if(m.getDescricao().length()<3 || m.getDescricao().length()>20 || m.getDescricao() == null){
			return "Descrição inválida!";
		}
		if(m.getValor()<0 || m.getValor()>999999) {
			return "Valor Inválido!";
		}
		if(m.getUnidMedida().length()==0 || m.getUnidMedida().length()>20 ||  m.getUnidMedida() == null) {
			return "Unidade de medida inválida!";
		}
		new materiaPrimaDAO().Gravar(m, con);
		return "";
	}

	public static String apagar(int cd, Connection con) throws Exception{
		validaCodigo(cd);
		new materiaPrimaDAO().apagar(cd, con);
		return"";
	}

	public static String atualizarMatP(int cd, materiaPrima m, Connection con)throws Exception{
		validaCodigo(cd);
		if(m.getDescricao().length()<3 || m.getDescricao().length()>20 || m.getDescricao() == null){
			return "Descrição inválida!";
		}
		if(m.getValor()<0 || m.getValor()>999999) {
			return "Valor Inválido!";
		}
		if(m.getUnidMedida().length()==0 || m.getUnidMedida().length()>20 ||  m.getUnidMedida() == null) {
			return "Unidade de medida inválida!";
		}
		new materiaPrimaDAO().atualizarMatP(cd, m, con);
		return"";
	}
	
	public static String pesquisa(int cd, Connection con) throws Exception{
		validaCodigo(cd);
		new materiaPrimaDAO().pesquisa(cd, con);
		return"";
	}
	
	public static String listaMat(Connection con) throws Exception{
		new materiaPrimaDAO().listaMat(con);
		return"";
	}
	
	
	
}
