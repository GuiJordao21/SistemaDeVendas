package br.com.fiap.BO;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.DAO.VendaDAO;
import br.com.fiap.beans.VendaBeans;
import br.com.fiap.retorno.RetornoVenda;

public class VendaBO {
	
	public static VendaBeans cadastro(int x,String email,String data,String hora, Connection con)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		
		if(email.indexOf('@')<0){
			VendaBeans vb=new VendaBeans();
			return vb;
		}else{
			VendaBeans vb=dao.cadastrar(x, email, data, hora, con);		
			return vb;
		}		
	}
	
	public static String attValor(int cdv, int cd, Connection con)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<RetornoVenda> lista=dao.consultar(con);
		
		if(cdv<=0||(cdv>lista.size()+1)) {
			return "Código de venda inválido";
		}else {			
			String ret=dao.attValor(cdv, cd, con);		
			return ret;
		}		
	}
	
	public static String deletar(int cd, Connection con)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<RetornoVenda> lista=dao.consultar(con);
		
		if(cd<=0||cd>lista.size()) {
			return "Código de venda inválido";
		}else {			
			String ret=dao.deletar(cd, con);		
			return ret;
		}			
	}
	
	public static List<RetornoVenda> consultar(Connection con)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<RetornoVenda> lista=dao.consultar(con);
		
		if(lista.size()>0) {
			return lista;
		}else {
			throw new RuntimeException();
		}
		
	}
	
	public static String desconto(int cdv, double desc, Connection con)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		if (cdv>0&&desc>0&&desc<100) {
			
			String ret=dao.desconto(cdv, desc, con);
			
			return ret;
		}else {
			throw new RuntimeException();
		}
		
	}
	
	public static String aumento(int cdv, double desc, Connection con)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		if (cdv>0&&desc>0) {			
			String ret=dao.aumento(cdv, desc, con);	
			return ret;
		}else {
			throw new RuntimeException();
		}
		
	}

}
