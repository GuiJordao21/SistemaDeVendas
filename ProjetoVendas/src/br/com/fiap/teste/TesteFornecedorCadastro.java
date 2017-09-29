package br.com.fiap.teste;

import br.com.fiap.DAO.FornecedorDAO;
import br.com.fiap.beans.FornecedorBeans;
import br.com.fiap.entrada.Dados;

//TESTAR DEPOIS EM CASA POR PROBLEMAS DE CONEXÃO

public class TesteFornecedorCadastro {

	public static void main(String[] args) throws Exception{

		FornecedorDAO dao=new FornecedorDAO();
		
		FornecedorBeans fb=new FornecedorBeans(
												Dados.texto("nome"),
												Dados.texto("email"),
												Dados.longo("cnpj"),
												Dados.texto("Razão Social:")
												);
		Dados.mensagem(dao.cadastrar(fb));
		
		dao.consultarNome(Dados.texto("Qual o nome do fornecedor"));
				

	}

}
