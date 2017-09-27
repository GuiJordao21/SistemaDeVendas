package br.com.fiap.conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static String lerArq()throws Exception{
		
		FileReader arquivo=new FileReader("c:\\conexaoBanco.txt");
		BufferedReader dados=new BufferedReader(arquivo);
		String resultado="";
		while(dados.ready()){ 
			resultado+=dados.readLine();
		}
		dados.close();
		arquivo.close();
		
		return resultado;
		
	}

	
	public Connection getconnection() throws Exception{
		
		return DriverManager.getConnection(lerArq());
		
	}
	
}
