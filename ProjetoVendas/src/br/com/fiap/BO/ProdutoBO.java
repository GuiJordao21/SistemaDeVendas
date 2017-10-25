package br.com.fiap.BO;

import br.com.fiap.beans.ProdutoBeans;

import java.sql.Connection;

import br.com.fiap.DAO.ProdutoDAO;

public class ProdutoBO {
	public static String novoProduto(ProdutoBeans p, Connection con) throws Exception{
		if(p.getNomeProd().length()==0 || p.getNomeProd().length()>20 || p.getNomeProd() == null) {
			return "Nome invalido!";
		}
		
		if(p.getPrecoProd()<0 || p.getPrecoProd()>999.99){
			return "Valor Invalido!";
		}
		
		if(p.getDescProd().length()== 0 || p.getDescProd().length()>50 || p.getDescProd() == null) {
			return "Descrição inválida!";
		}
		
		if(p.getDisp().length()<0||p.getDisp().length()>50) {
			return "Valor Invalido!";
		}
		
		if(p.getUrlImg().length()==0 || p.getUrlImg().length()>100 || p.getUrlImg() == null) {
			return "URL invalida!";
		}
		ProdutoDAO dao = new ProdutoDAO();
		String msg = dao.novoProduto(p, con);
		return msg;
	}
	
	public static String deletaProduto(int n, Connection con) throws Exception{
		if(n<1 || n>99) {
			return "Codigo invalido!";
		}
		ProdutoDAO dao = new ProdutoDAO();
		String i = dao.deletaProduto(n, con);
		return i;
	}
	
	public static String atualizaProduto(ProdutoBeans p, Connection con) throws Exception{
		if(p.getIdProd()<=0 || p.getIdProd()>99) {
			return "ID invalido!";
		}
		
		if(p.getNomeProd().length()==0 || p.getNomeProd().length()>20 || p.getNomeProd() == null) {
			return "Nome invalido!";
		}
		
		if(p.getPrecoProd()<0 || p.getPrecoProd()>999.99){
			return "Valor Invalido!";
		}
		
		if(p.getDescProd().length()== 0 || p.getDescProd().length()>50 || p.getDescProd() == null) {
			return "Descrição inválida!";
		}
		
		if(p.getDisp().length()<0||p.getDisp().length()>50) {
			return "Valor Invalido!";
		}
		
		if(p.getUrlImg().length()==0 || p.getUrlImg().length()>100 || p.getUrlImg() == null) {
			return "URL invalida!";
		}
		ProdutoDAO dao = new ProdutoDAO();
		String msg = dao.atualizaProduto(p, con);
		return msg;
	}
	
	public static ProdutoBeans pesquisaProduto(int n, Connection con) throws Exception{
		if(n<0) {
			throw new RuntimeException();
		}
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoBeans p = dao.pesquisaProduto(n, con);
		return p;
	}
	
	
}

