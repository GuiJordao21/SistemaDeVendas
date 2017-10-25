package br.com.fiap.conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public final class Conexao {
	
	private static Conexao conexao=null;
	
	public static Conexao controlarInstancia(){
		if (conexao==null) {
			conexao=new Conexao();
		}
		return conexao;
	}
	
	public Connection getConnection(String usuario, String senha) throws Exception{
		
		//FileReader arquivo=new FileReader("conexao/conexao.txt");
		FileReader arquivo=new FileReader(System.getProperty("user.dir")+"/conexao/conexao.txt");
		BufferedReader dados=new BufferedReader(arquivo);
		
		String url=dados.readLine();
		//retiramos a criação das variaveis usuario e senha
		
		if (url.indexOf("oracle")>0){
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}else if(url.indexOf("mysql")>0){
			Class.forName("com.mysql.jdbc.Driver");
		}
		
		dados.close();
		return DriverManager.getConnection(url,usuario,senha);
	}

}