package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.BO.EnderecoBO;
import br.com.fiap.BO.TelefoneBO;
import br.com.fiap.beans.ClienteBeans;
import br.com.fiap.beans.EnderecoBeans;
import br.com.fiap.beans.TelefoneBeans;
import br.com.fiap.conexao.Conexao;

public class ClienteDAO {

	private PreparedStatement stmt;
    private ResultSet rs;
	
	//GRAVAR
	public String gravar(String y,ClienteBeans objCliente,EnderecoBeans e,TelefoneBeans t, Connection con) throws Exception {
		
		stmt=con.prepareStatement("SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL=?");
        stmt.setString(1, y);
        rs=stmt.executeQuery();
        
        int ex=0;
        
        if(rs.next()) {
        	ex=rs.getInt("CD_USUARIO");
        }   
        
		stmt=con.prepareStatement("INSERT INTO T_SPG_CLIENTE (CD_USUARIO,NR_CNPJ,DS_RAZAO_SOCIAL,DS_INSCRICAO_ESTADUAL,DS_URL) VALUES (?,?,?,?,?)");
		stmt.setInt(1, ex);
		stmt.setLong(2, objCliente.getCnpj());
		stmt.setString(3, objCliente.getRzSocial());
		stmt.setString(4, objCliente.getiE());
		stmt.setString(5, objCliente.getUrl());
		stmt.execute();
		stmt.close();
		
		EnderecoBO.cadastrar(ex,e,con);
		TelefoneBO.novoTelefone(ex,t,con);
		
		return "Cliente cadastrado com sucesso";
	
}
	
	//UPDATE
	public String updateCliente(String y, ClienteBeans email, Connection con) throws Exception{
		
		stmt =con.prepareStatement("UPDATE T_SPG_USUARIO SET DS_EMAIL=? WHERE DS_EMAIL=?");
		stmt.setString(1, email.getDsemail());
		stmt.setString(2, y);
		stmt.executeUpdate();
		stmt.close();
	
		return "Email Alterado com Sucesso";
	
	}
	
	//DELETE
	
	 public String apagar(String y, Connection con) throws Exception{
		
		  stmt=con.prepareStatement("SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL=?");
	      stmt.setString(1, y);
	      rs=stmt.executeQuery();
	      int ex=0;
	      if(rs.next()) {
	      ex=rs.getInt("CD_USUARIO");
	        }   
		 stmt =con.prepareStatement("DELETE FROM T_SPG_CLIENTE WHERE CD_USUARIO =?");
		 stmt.setInt(1, ex);
		 stmt.executeUpdate();
		 stmt =con.prepareStatement("DELETE FROM T_SPG_USUARIO WHERE DS_EMAIL =?");
		 stmt.setString(1, y);
		 stmt.executeUpdate();
		 stmt.close();
		 
		 return "Cliente apagado co sucesso";
		 
	 }
	 
	 //CONSULTAR
	 public ClienteBeans consultar(String y, Connection con)throws Exception{
		    stmt=con.prepareStatement("SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL=?");
	        stmt.setString(1, y);
	        rs=stmt.executeQuery();
	        int ex=0;
	        if(rs.next()) {
	        	ex=rs.getInt("CD_USUARIO");
	        }
		 
	        ClienteBeans cli = new ClienteBeans();
			 stmt =con.prepareStatement("SELECT * FROM T_SPG_USUARIO WHERE DS_EMAIL=?");
			 stmt.setString(1, y);
			 ResultSet resultado = stmt.executeQuery();
			 
			 if (resultado.next()) {
				
				cli.setNmUsuario(resultado.getString("NM_NOME"));
				 cli.setDsemail(resultado.getString("DS_EMAIL"));
				cli.setSenha(resultado.getString("DS_SENHA"));
				 
			 }
		 stmt =con.prepareStatement("SELECT * FROM T_SPG_CLIENTE WHERE CD_USUARIO=?");
		 stmt.setInt(1, ex);
		 ResultSet resultado1 = stmt.executeQuery();
		 if (resultado.next()) {
			 cli.setCdUsuario(resultado1.getInt("NR_CNPJ"));
			 cli.setRzSocial(resultado1.getString("DS_RAZAO_SOCIAL"));
			 cli.setiE(resultado1.getString("DS_INSCRICAO_ESTADUAL"));
			 cli.setUrl(resultado1.getString("DS_URL"));

		 }
		 
		 stmt.close();
		 return cli;
	 }
	 
	 
	//LISTAR
	 public List<ClienteBeans> listaCliente(Connection con) throws Exception {    
		    
		    List<ClienteBeans> minhalista = new ArrayList<ClienteBeans>();
		    ClienteBeans cli = new ClienteBeans ();
			stmt =con.prepareStatement("SELECT C.NM_NOME, C.DS_EMAIL, C.DS_SENHA, F.CD_USUARIO,F.NR_CNPJ,F.DS_RAZAO_SOCIAL,F.DS_INSCRICAO_ESTADUAL,F.DS_URL FROM T_SPG_USUARIO C, T_SPG_CLIENTE F WHERE C.CD_USUARIO=F.CD_USUARIO"); 
		    ResultSet resultado2 = stmt.executeQuery();
		    while(resultado2.next()) {
		    	cli =new ClienteBeans();
		    	
		    	 cli.setNmUsuario(resultado2.getString("NM_NOME"));
				 cli.setDsemail(resultado2.getString("DS_EMAIL"));
				 cli.setSenha(resultado2.getString("DS_SENHA")); 
		    	 cli.setCdUsuario(resultado2.getInt("CD_USUARIO"));
		    	 cli.setCnpj(resultado2.getInt("NR_CNPJ"));
				 cli.setRzSocial(resultado2.getString("DS_RAZAO_SOCIAL"));
				 cli.setiE(resultado2.getString("DS_INSCRICAO_ESTADUAL"));
				 cli.setUrl(resultado2.getString("DS_URL"));
				 
		    	minhalista.add(cli);
		    }
		    stmt.close();
	 return minhalista;
	 
	 }	
}

	 
	 
	 
	 
