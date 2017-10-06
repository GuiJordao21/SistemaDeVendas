package br.com.fiap.BO;

import java.util.List;

import br.com.fiap.DAO.ItemVendaDAO;
import br.com.fiap.beans.ItemVendaBeans;

public class ItemVendaBO {

	public static String adicionar(int cp, int cdv, int qtd,String usuario, String senha)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO(usuario, senha);
		if((cp>0)&&(cdv>0)&&(qtd>0)) {
			return dao.adicionar(cp, cdv, qtd);
		}else {
			throw new RuntimeException();
		}		
	}
	
	public static String deletar(int cd,String usuario, String senha)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO(usuario, senha);
		if(cd>0){
			return dao.deletar(cd);
		}else{
			throw new RuntimeException();
		}		
	}
	
	public static String deletarVenda(int cd,String usuario, String senha)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO(usuario, senha);
		if(cd>0){
			return dao.deletarVenda(cd);
		}else{
			throw new RuntimeException();
		}		
	}
	
	public static String attValor(int cd, double vl,String usuario, String senha)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO(usuario, senha);
		
		if(cd>0||vl>=0) {
			return dao.attItem(cd, vl);
		}else {
			throw new RuntimeException();
		}	
	}
	
	public static List<ItemVendaBeans> consultar(int cd,String usuario, String senha)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO(usuario, senha);
		
		if(cd>0) {
			List<ItemVendaBeans> lista=dao.consultar(cd);
			return lista;
		}else{
			throw new RuntimeException();
		}
	}
	
	public static List<ItemVendaBeans> maiorItemVenda(String usuario, String senha)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO(usuario, senha);
		
		List<ItemVendaBeans> lista=dao.consultMaiorVal(usuario, senha);
		
		if(lista!=null) {
			return lista;
		}else {
			throw new RuntimeException();
		}
		
	}
	
}
