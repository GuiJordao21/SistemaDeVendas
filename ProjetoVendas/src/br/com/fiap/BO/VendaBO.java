package br.com.fiap.BO;

import java.util.List;

import br.com.fiap.DAO.VendaDAO;
import br.com.fiap.beans.VendaBeans;

public class VendaBO {
	
	public static VendaBeans cadastro(int x,String email,String data,String hora)throws Exception{
		
		VendaDAO dao=new VendaDAO();		
		if(email.indexOf('@')<0){
			VendaBeans vb=new VendaBeans();
			return vb;
		}else{
			return dao.cadastrar(x, email, data, hora);
		}		
	}
	
	public static String attValor(int cdv, int cd)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<VendaBeans> lista=dao.consultar();
		
		if(cdv<=0||(cdv>lista.size()+1)) {
			return "Código de venda inválido";
		}else {
			return dao.attValor(cdv, cd);
		}		
	}
	
	public static String deletar(int cd)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<VendaBeans> lista=dao.consultar();
		
		if(cd<=0||cd>lista.size()) {
			return "Código de venda inválido";
		}else {
			return dao.deletar(cd);
		}			
	}
	
	public static List<VendaBeans> consultar()throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<VendaBeans> lista=dao.consultar();
		
		if(lista.size()>0) {
			return lista;
		}else {
			throw new RuntimeException();
		}
		
	}
	
	public static String desconto(int cdv, double desc)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		if (cdv>0&&desc>0&&desc<100) {
			return dao.desconto(cdv, desc);
		}else {
			throw new RuntimeException();
		}
		
	}
	
	public static String aumento(int cdv, double desc)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		if (cdv>0&&desc>0) {
			return dao.aumento(cdv, desc);
		}else {
			throw new RuntimeException();
		}
		
	}

}
