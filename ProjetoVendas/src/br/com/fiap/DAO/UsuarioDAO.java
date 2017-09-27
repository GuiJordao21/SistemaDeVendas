package br.com.fiap.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.ClienteBeans;
import br.com.fiap.beans.UsuarioBeans;
import br.com.fiap.conexao.Conexao;

public class UsuarioDAO {

	private Connection con;
	private PreparedStatement stmt;
    private ResultSet rs;
	
	
	public UsuarioDAO() throws Exception{
		
		con = new Conexao().getconnection();	
	}
	
	public void fechar() throws Exception{
		con.close();
	}
	
	//INSERT
	public String gravarUsuario(ClienteBeans obj) throws Exception {
		stmt =con.prepareStatement("INSERT INTO T_SPG_USUARIO (CD_USUARIO,NM_NOME, DS_EMAIL, DS_SENHA) VALUES (SEQ_USUARIO.NEXTVAL,?,?,?)");
	
		stmt.setString(1, obj.getNmUsuario());
		stmt.setString(2, obj.getDsemail());
		stmt.setString(3, obj.getSenha());
		stmt.execute();
		stmt.close();
	
		
		
		return "Usuario cadastrado";
	}
	
	
	// UPDATE
	 public String update(String emailAntigo, String emailAtual) throws Exception{
			stmt =con.prepareStatement("UPDATE T_SPG_USUARIO SET DS_EMAIL=? WHERE DS_EMAIL=?");
			stmt.setString(1, emailAtual);
			stmt.setString(2, emailAntigo);
			stmt.executeUpdate();
			stmt.close();
		
			return " Usuario alterado com sucesso";
	
	 }
	
	 //APAGAR
	 public String apagar(int x) throws Exception{
		 stmt =con.prepareStatement("DELETE T_SPG_USUARIO WHERE CD_USUARIO=?");
		 stmt.setInt(1, x);
		 stmt.executeUpdate();
		 stmt.close();
		 
		 return "Cliente apagado co sucesso";
	 }
	 
	 //CONSULTAR
	 public UsuarioBeans consultar(int x)throws Exception{
		 UsuarioBeans usu = new UsuarioBeans();
		 stmt =con.prepareStatement("SELECT * FROM T_SPG_USUARIO WHERE CD_USUARIO=?");
		 stmt.setInt(1, x);
		 ResultSet resultado = stmt.executeQuery();
		 
		 if (resultado.next()) {
			
			 usu.setNmUsuario(resultado.getString("NM_NOME"));
			 usu.setDsemail(resultado.getString("DS_EMAIL"));
			 usu.setSenha(resultado.getString("DS_SENHA"));
			 
		 }
		 stmt.close();
		 return usu;
	 }
	 //LISTAR
	 public List<UsuarioBeans> listarUsuario() throws Exception{
			List<UsuarioBeans> minhalista = new ArrayList<UsuarioBeans>();
			UsuarioBeans usu = new UsuarioBeans ();
			stmt =con.prepareStatement("SELECT * FROM T_SPG_USUARIO"); 
		    rs = stmt.executeQuery();
		    
		    while(rs.next()) {
		    	usu =new UsuarioBeans();
		    	
		    	 usu.setNmUsuario(rs.getString("NM_NOME"));
				 usu.setDsemail(rs.getString("DS_EMAIL"));
				 usu.setSenha(rs.getString("DS_SENHA")); 
		    	minhalista.add(usu);
		    }
		    
		    rs.close();
		    stmt.close();
		    
			return minhalista;
	 } 
}
