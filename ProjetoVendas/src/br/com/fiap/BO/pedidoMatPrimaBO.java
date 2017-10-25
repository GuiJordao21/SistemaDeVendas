package br.com.fiap.BO;

import java.sql.Connection;

import br.com.fiap.DAO.PedidoMatPrimaDAO;
import br.com.fiap.beans.pedidoMatPrima;

public class pedidoMatPrimaBO {

	public static String validaCodigo(int cd) {
		if(cd<0 ||cd>9999) {
			return "Código inválido!";
		}
		return"";
	}

	public static String gravarPedido(pedidoMatPrima m, String email, Connection con)throws Exception{
		if((email.indexOf('@') !=1) || (email.indexOf('.') == 0)) {
			return "Email inválido!";
		}
		if(m.getQtPedidos() <0 || m.getQtPedidos() > 999999) {
			return "Quantidade de pedido inválida!";
		}
		if(m.getDatapedido().length()<2 || m.getDatapedido().length()>10 || m.getDatapedido() == null) {
			return "Data inválida!";
		}
		if(m.getHorapedido().length()<4 || m.getHorapedido().length()>5 || m.getHorapedido() == null) {
			return "Hora invalida!";
		}
		if(m.getDescricao().length() <3 || m.getDescricao().length() >20 || m.getDescricao() == null) {
			return "Descrição Inválida!";
		}
		
		new PedidoMatPrimaDAO().gravarPedido(m, email, con);
		return "Materia Prima Cadastrada";
	}

	public String gravarProcessamento(pedidoMatPrima m, int cdfor, int cdmat,String email, int cdped, Connection con)throws Exception{
		validaCodigo(cdfor);
		validaCodigo(cdmat);
		validaCodigo(cdped);
		if((email.indexOf('@') !=1) || (email.indexOf('.') == 0)) {
			return "Email inválido!";
		}
		if(m.getQuantProcessada() <0 || m.getQuantProcessada() > 999999) {
			return "Quantidade de pedido inválida!";
		}
		if(m.getDataProcessamento().length()<2 || m.getDataProcessamento().length()>10 || m.getDataProcessamento() == null) {
			return "Data inválida!";
		}
		if(m.getHoraProcessamento().length()<4 || m.getHoraProcessamento().length()>5 || m.getHoraProcessamento() == null) {
			return "Hora invalida!";
		}
		if(m.getVlMatProcessada()<0.0 || m.getVlMatProcessada()>999999) {
			return "Valor invalido";
		}
		new PedidoMatPrimaDAO().gravarProcessamento(m, cdfor, cdmat, email, cdped, con);
		return"";
	}

	public String gravarFornecida(pedidoMatPrima m, int cdfor, int cdmat, int cdped, Connection con)throws Exception{
		validaCodigo(cdfor);
		validaCodigo(cdmat);
		validaCodigo(cdped);
		if(m.getQuantFornecida() <0 || m.getQuantFornecida()>999999) {
			return "Quantidade fornecida inválida!";
		}
		if(m.getVlMatFornecida()<0.0 || m.getVlMatFornecida() > 999999){
			return "Valor quantidade fornecida invalida!";
		}
		new PedidoMatPrimaDAO().gravarFornecida(m, cdfor, cdmat, cdped, con);
		return"";
	}

	public String atualizaPedido(pedidoMatPrima m, int num, Connection con)throws Exception{
		validaCodigo(num);
		if(m.getQtPedidos() <0 || m.getQtPedidos() > 999999) {
			return "Quantidade de pedido inválida!";
		}
		if(m.getDescricao().length() <3 || m.getDescricao().length() >20 || m.getDescricao() == null) {
			return "Descrição Inválida!";
		}
		new PedidoMatPrimaDAO().atualizaPedido(m, num, con);
		return"";
	}

	public static String atualizaProcessamento(pedidoMatPrima m, int num, Connection con)throws Exception{
		validaCodigo(num);
		if(m.getQuantProcessada() <0 || m.getQuantProcessada() > 999999) {
			return "Quantidade de pedido inválida!";
		}
		if(m.getVlMatProcessada()<0.0 || m.getVlMatProcessada()>999999) {
			return "Valor invalido";
		}
		new PedidoMatPrimaDAO().atualizaProcessamento(m, num, con);
		return"";
	}

	public String atualizaFornercida(pedidoMatPrima m, int num, Connection con)throws Exception{
		validaCodigo(num);
		if(m.getQuantFornecida() <0 || m.getQuantFornecida()>999999) {
			return "Quantidade fornecida inválida!";
		}
		if(m.getVlMatFornecida()<0.0 || m.getVlMatFornecida() > 999999){
			return "Valor quantidade fornecida invalida!";
		}
		new PedidoMatPrimaDAO().atualizaFornercida(m, num, con);
		return"";
	}
	
	public static String deletaPedido(int n, Connection con)throws Exception{
		validaCodigo(n);
		new PedidoMatPrimaDAO().deletaPedido(n, con);
		return "";
	}
	
	public static String deletaProcessamento(int n, Connection con)throws Exception{
		validaCodigo(n);
		new PedidoMatPrimaDAO().deletaProcessamento(n, con);
		return"";
	}
	
	public static String deletaFornecida(int n, Connection con)throws Exception{
		validaCodigo(n);
		new PedidoMatPrimaDAO().deletaFornecida(n, con);
		return"";
	}
	
	public static String pesquisa(int n, Connection con)throws Exception{
		validaCodigo(n);
		new PedidoMatPrimaDAO().pesquisa(n,con);
		return "";
	}
	
	public static String listar(Connection con)throws Exception{
		new PedidoMatPrimaDAO().listar(con);
		return "";
	}
	
	
}
