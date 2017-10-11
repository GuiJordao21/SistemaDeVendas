package br.com.fiap.BO;

import br.com.fiap.DAO.pedidoMatPrimaDAO;
import br.com.fiap.beans.pedidoMatPrima;

public class pedidoMatPrimaBO {

	public static String validaCodigo(int cd) {
		if(cd<0 ||cd>9999) {
			return "Código inválido!";
		}
		return"";
	}

	public static String gravarPedido(pedidoMatPrima m, String email, String usuario, String senha)throws Exception{
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
		
		new pedidoMatPrimaDAO(usuario, senha).gravarPedido(m, email);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return "Materia Prima Cadastrada";
	}

	public String gravarProcessamento(pedidoMatPrima m, int cdfor, int cdmat,String email, int cdped, String usuario, String senha)throws Exception{
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
		new pedidoMatPrimaDAO(usuario, senha).gravarProcessamento(m, cdfor, cdmat, email, cdped);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return"";
	}

	public String gravarFornecida(pedidoMatPrima m, int cdfor, int cdmat, int cdped, String usuario, String senha)throws Exception{
		validaCodigo(cdfor);
		validaCodigo(cdmat);
		validaCodigo(cdped);
		if(m.getQuantFornecida() <0 || m.getQuantFornecida()>999999) {
			return "Quantidade fornecida inválida!";
		}
		if(m.getVlMatFornecida()<0.0 || m.getVlMatFornecida() > 999999){
			return "Valor quantidade fornecida invalida!";
		}
		new pedidoMatPrimaDAO(usuario, senha).gravarFornecida(m, cdfor, cdmat, cdped);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return"";
	}

	public String atualizaPedido(pedidoMatPrima m, int num, String usuario, String senha)throws Exception{
		validaCodigo(num);
		if(m.getQtPedidos() <0 || m.getQtPedidos() > 999999) {
			return "Quantidade de pedido inválida!";
		}
		if(m.getDescricao().length() <3 || m.getDescricao().length() >20 || m.getDescricao() == null) {
			return "Descrição Inválida!";
		}
		new pedidoMatPrimaDAO(usuario, senha).atualizaPedido(m, num);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return"";
	}

	public static String atualizaProcessamento(pedidoMatPrima m, int num, String usuario, String senha)throws Exception{
		validaCodigo(num);
		if(m.getQuantProcessada() <0 || m.getQuantProcessada() > 999999) {
			return "Quantidade de pedido inválida!";
		}
		if(m.getVlMatProcessada()<0.0 || m.getVlMatProcessada()>999999) {
			return "Valor invalido";
		}
		new pedidoMatPrimaDAO(usuario, senha).atualizaProcessamento(m, num);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return"";
	}

	public String atualizaFornercida(pedidoMatPrima m, int num, String usuario, String senha)throws Exception{
		validaCodigo(num);
		if(m.getQuantFornecida() <0 || m.getQuantFornecida()>999999) {
			return "Quantidade fornecida inválida!";
		}
		if(m.getVlMatFornecida()<0.0 || m.getVlMatFornecida() > 999999){
			return "Valor quantidade fornecida invalida!";
		}
		new pedidoMatPrimaDAO(usuario, senha).atualizaFornercida(m, num);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return"";
	}
	
	public static String deletaPedido(int n, String usuario, String senha)throws Exception{
		validaCodigo(n);
		new pedidoMatPrimaDAO(usuario, senha).deletaPedido(n);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return "";
	}
	
	public static String deletaProcessamento(int n, String usuario, String senha)throws Exception{
		validaCodigo(n);
		new pedidoMatPrimaDAO(usuario, senha).deletaProcessamento(n);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return"";
	}
	
	public static String deletaFornecida(int n, String usuario, String senha)throws Exception{
		validaCodigo(n);
		new pedidoMatPrimaDAO(usuario, senha).deletaProcessamento(n);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return"";
	}
	
	public static String pesquisa(int n, String usuario, String senha)throws Exception{
		validaCodigo(n);
		new pedidoMatPrimaDAO(usuario, senha).pesquisa(n);
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return "";
	}
	
	public static String listar(String usuario, String senha)throws Exception{
		new pedidoMatPrimaDAO(usuario, senha).listar();
		new pedidoMatPrimaDAO(usuario, senha).fechar();
		return "";
	}
	
	
}
