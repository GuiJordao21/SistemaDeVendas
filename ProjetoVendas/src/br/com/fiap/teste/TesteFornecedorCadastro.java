package br.com.fiap.teste;

import br.com.fiap.DAO.FornecedorDAO;
import br.com.fiap.beans.FornecedorBeans;
import br.com.fiap.entrada.Dados;

//TESTAR DEPOIS EM CASA POR PROBLEMAS DE CONEX�O

public class TesteFornecedorCadastro {

	public static void main(String[] args) throws Exception{

		FornecedorDAO dao=new FornecedorDAO();
		
		FornecedorBeans fb=new FornecedorBeans(
												Dados.texto("nome"),
												Dados.texto("email"),
												Dados.longo("cnpj"),
												Dados.texto("Raz�o Social:")
												);
		Dados.mensagem(dao.cadastrar(fb));
		
		dao.consultarNome(Dados.texto("Qual o nome do fornecedor"));
		
		char opt=Dados.texto("Qual dado deseja atualizar?"
				+ " -NOME-"
				+ "/n-EMAIL-"
				+ "/n-CNPJ-"
				+ "/n-RAZ�O SOCIAL-").toUpperCase().charAt(0);
		
		if (opt=='N'){
			
			dao.atualizar(Dados.inteiro("Insira o c�digo"),
					"NM_FORNECEDOR",
					Dados.texto("Insira o novo nome:"));
			
		}else if(opt=='E'){
			
			dao.atualizar(Dados.inteiro("Insira o c�digo"),
					"DS_EMAIL",
					Dados.texto("Insira o novo email:"));
			
		}else if(opt=='C'){

			dao.atualizar(Dados.inteiro("Insira o c�digo"),
					"NR_CNPJ",
					Dados.longo("Insira o novo CNPJ:"));
			
		}else if(opt=='R'){
			
			dao.atualizar(Dados.inteiro("Insira o c�digo"),
					"DS_RAZAO_SOCIAL",
					Dados.texto("Insira a nova Raz�o Social:"));
			
		}else{
			Dados.mensagem("Op��o inv�lida.");
		}

	}

}
