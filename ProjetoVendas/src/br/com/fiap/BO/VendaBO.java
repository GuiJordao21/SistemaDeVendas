package br.com.fiap.BO;

import java.util.List;

import br.com.fiap.DAO.VendaDAO;
import br.com.fiap.beans.VendaBeans;
import br.com.fiap.retorno.RetornoVenda;

public class VendaBO {
	
	public static VendaBeans cadastro(int x,String email,String data,String hora)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		
		if(email.indexOf('@')<0){
			VendaBeans vb=new VendaBeans();
			dao.fechar();
			return vb;
		}else{
			VendaBeans vb=dao.cadastrar(x, email, data, hora);
			dao.fechar();			
			return vb;
		}		
	}
	
	public static String attValor(int cdv, int cd)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<RetornoVenda> lista=dao.consultar();
		
		if(cdv<=0||(cdv>lista.size()+1)) {
			dao.fechar();
			return "Código de venda inválido";
		}else {			
			String ret=dao.attValor(cdv, cd);
			dao.fechar();			
			return ret;
		}		
	}
	
	public static String deletar(int cd)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<RetornoVenda> lista=dao.consultar();
		
		if(cd<=0||cd>lista.size()) {
			dao.fechar();
			return "Código de venda inválido";
		}else {			
			String ret=dao.deletar(cd);
			dao.fechar();			
			return ret;
		}			
	}
	
	public static List<RetornoVenda> consultar()throws Exception{
		
		VendaDAO dao=new VendaDAO();
		List<RetornoVenda> lista=dao.consultar();
		dao.fechar();
		
		if(lista.size()>0) {
			return lista;
		}else {
			throw new RuntimeException();
		}
		
	}
	
	public static String desconto(int cdv, double desc)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		if (cdv>0&&desc>0&&desc<100) {
			
			String ret=dao.desconto(cdv, desc);
			dao.fechar();
			
			return ret;
		}else {
			dao.fechar();
			throw new RuntimeException();
		}
		
	}
	
	public static String aumento(int cdv, double desc)throws Exception{
		
		VendaDAO dao=new VendaDAO();
		if (cdv>0&&desc>0) {			
			String ret=dao.aumento(cdv, desc);	
			dao.fechar();
			return ret;
		}else {
			dao.fechar();
			throw new RuntimeException();
		}
		
	}

}
