package br.com.fiap.BO;

import br.com.fiap.DAO.materiaPrimaDAO;
import br.com.fiap.beans.materiaPrima;

public class materiaPrimaBO {

	public static String validaCodigo(int cd)throws Exception{
		if(cd<0 || cd>9999){
			return "Codigo inv�lido!";
		}
		return"";
	}

	public static String Gravar(materiaPrima m, String usuario, String senha) throws Exception{
		if(m.getCdMatPrima()<0 || m.getCdMatPrima()>9999) {
			return "Codigo inv�lido!";
		}
		if(m.getDescricao().length()<3 || m.getDescricao().length()>20 || m.getDescricao() == null){
			return "Descri��o inv�lida!";
		}
		if(m.getValor()<0 || m.getValor()>999999) {
			return "Valor Inv�lido!";
		}
		if(m.getUnidMedida().length()==0 || m.getUnidMedida().length()>20 ||  m.getUnidMedida() == null) {
			return "Unidade de medida inv�lida!";
		}
		new materiaPrimaDAO(usuario, senha).Gravar(m);
		new materiaPrimaDAO(usuario, senha).fechar();
		return "";
	}

	public static String apagar(int cd, String usuario, String senha) throws Exception{
		validaCodigo(cd);
		new materiaPrimaDAO(usuario, senha).apagar(cd);
		new materiaPrimaDAO(usuario, senha).fechar();
		return"";
	}

	public static String atualizarMatP(int cd, materiaPrima m, String usuario, String senha)throws Exception{
		validaCodigo(cd);
		if(m.getDescricao().length()<3 || m.getDescricao().length()>20 || m.getDescricao() == null){
			return "Descri��o inv�lida!";
		}
		if(m.getValor()<0 || m.getValor()>999999) {
			return "Valor Inv�lido!";
		}
		if(m.getUnidMedida().length()==0 || m.getUnidMedida().length()>20 ||  m.getUnidMedida() == null) {
			return "Unidade de medida inv�lida!";
		}
		new materiaPrimaDAO(usuario, senha).atualizarMatP(cd, m);
		new materiaPrimaDAO(usuario, senha).fechar();
		return"";
	}
	
	public static String pesquisa(int cd, String usuario, String senha) throws Exception{
		validaCodigo(cd);
		new materiaPrimaDAO(usuario, senha).pesquisa(cd);
		new materiaPrimaDAO(usuario, senha).fechar();
		return"";
	}
	
	public static String listaMat(String usuario, String senha) throws Exception{
		new materiaPrimaDAO(usuario, senha).listaMat();
		new materiaPrimaDAO(usuario, senha).fechar();
		return"";
	}
	
	
	
}
