package br.com.fiap.BO;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.DAO.ItemVendaDAO;
import br.com.fiap.beans.ItemVendaBeans;

public class ItemVendaBO {

	public static String adicionar(int cp, int cdv, int qtd, Connection con)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO();
		if((cp>0)&&(cdv>0)&&(qtd>0)) {
			return dao.adicionar(cp, cdv, qtd, con);
		}else {
			throw new RuntimeException();
		}		
	}
	
	public static String deletar(int cd, Connection con)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO();
		if(cd>0){
			return dao.deletar(cd, con);
		}else{
			throw new RuntimeException();
		}		
	}
	
	public static String deletarVenda(int cd, Connection con)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO();
		if(cd>0){
			return dao.deletarVenda(cd, con);
		}else{
			throw new RuntimeException();
		}		
	}
	
	public static String attValor(int cd, double vl, Connection con)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO();
		
		if(cd>0||vl>=0) {
			return dao.attItem(cd, vl, con);
		}else {
			throw new RuntimeException();
		}	
	}
	
	public static List<ItemVendaBeans> consultar(int cd, Connection con)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO();
		
		if(cd>0) {
			List<ItemVendaBeans> lista=dao.consultar(cd, con);
			return lista;
		}else{
			throw new RuntimeException();
		}
	}
	
	public static List<ItemVendaBeans> maiorItemVenda(Connection con)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO();
		
		List<ItemVendaBeans> lista=dao.consultMaiorVal(con);
		
		if(lista!=null) {
			return lista;
		}else {
			throw new RuntimeException();
		}
		
	}
	
}
