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
		
		char opt=Dados.texto("Qual dado deseja atualizar?"
				+ " -NOME-"
				+ "/n-EMAIL-"
				+ "/n-CNPJ-"
				+ "/n-RAZÃO SOCIAL-").toUpperCase().charAt(0);
		
		if (opt=='N'){
			
			dao.atualizar(Dados.inteiro("Insira o código"),
					"NM_FORNECEDOR",
					Dados.texto("Insira o novo nome:"));
			
		}else if(opt=='E'){
			
			dao.atualizar(Dados.inteiro("Insira o código"),
					"DS_EMAIL",
					Dados.texto("Insira o novo email:"));
			
		}else if(opt=='C'){

			dao.atualizar(Dados.inteiro("Insira o código"),
					"NR_CNPJ",
					Dados.longo("Insira o novo CNPJ:"));
			
		}else if(opt=='R'){
			
			dao.atualizar(Dados.inteiro("Insira o código"),
					"DS_RAZAO_SOCIAL",
					Dados.texto("Insira a nova Razão Social:"));
			
		}else{
			Dados.mensagem("Opção inválida.");
		}

	}

}
