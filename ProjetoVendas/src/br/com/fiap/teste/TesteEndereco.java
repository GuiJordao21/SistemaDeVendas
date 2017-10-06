package br.com.fiap.teste;

import br.com.fiap.DAO.EnderecoDAO;
import br.com.fiap.beans.EnderecoBeans;
import br.com.fiap.entrada.Dados;

public class TesteEndereco {
	
	static String usuario=new String();
	static String senha=new String();
	
	public static void main(String[] args) {
		
		try{
			usuario=Dados.texto("Insira seu Usuario");
			senha=Dados.texto("Insira a senha");
	
			EnderecoBeans e=new EnderecoBeans(
											  Dados.inteiro("Digite o número da casa"),
											  Dados.texto("insira cep"),
											  Dados.texto("insira o complemento"),
											  Dados.texto("tipo do log"),
											  Dados.texto("logradouro"),
											  Dados.texto("bairro"),
											  Dados.texto("cidade"),
											  Dados.texto("estado")
											  );
			
			EnderecoDAO dao=new EnderecoDAO(usuario,senha);
			dao.novoEndereco(e);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
