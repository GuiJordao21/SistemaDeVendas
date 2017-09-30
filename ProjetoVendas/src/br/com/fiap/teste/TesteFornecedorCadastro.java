package br.com.fiap.teste;

import java.util.List;

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
		
		
		List<FornecedorBeans> lista=dao.consultarNome(Dados.texto("Qual o nome do fornecedor"));
		
		for (FornecedorBeans fb1: lista) {
			System.out.println(fb1.getCd());
			System.out.println(fb1.getNome());
		}
		
		
		
		char opt=Dados.texto("Qual dado deseja atualizar?"
				+ "\n-NOME-"
				+ "\n-EMAIL-"
				+ "\n-CNPJ-"
				+ "\n-RAZÃO SOCIAL-").toUpperCase().charAt(0);
		
		switch (opt) {
		
			case 'N':				
				Dados.mensagem(dao.atualizarN(
						Dados.inteiro("Insira o código: "),
						Dados.texto("Novo nome: ").toUpperCase()));
				break;
			case 'E':
				Dados.mensagem(dao.atualizarE(
						Dados.inteiro("Insira o código: "),
						Dados.texto("Novo email: ")));				
				break;
			case 'C':
				Dados.mensagem(dao.atualizarC(
						Dados.inteiro("Insira o código: "),
						Dados.longo("Novo CNPJ: ")));				
				break;
				
			case 'R':
				Dados.mensagem(dao.atualizarR(
						Dados.inteiro("Insira o código: "),
						Dados.texto("Nova Razão Social: ").toUpperCase()));				
				break;
			default:
				
				Dados.mensagem("Opção inválida.");
				
				break;
		}
		
		
		Dados.mensagem(dao.deletar(
				Dados.inteiro("Insira o código do fornecedor a ser deletado: ")));
		
	}

}
