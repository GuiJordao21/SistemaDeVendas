package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.TelefoneBeans;
import br.com.fiap.conexao.Conexao;

public class TelefoneDAO {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	TelefoneBeans t = null;
	
	public TelefoneDAO(String usuario, String senha) throws Exception{
		con = new Conexao().getConnection(usuario,senha);
	}
	
	public void fechar() throws SQLException{
		con.close();
	}
	
	public String novoTelefone(TelefoneBeans t, String email) throws SQLException {
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_TELEFONE"
				+ "(CD_FONE, CD_TIPO_FONE,NR_DDD,NR_TELEFONE)"
				+ "VALUES(SEQ_TELEFONE.NEXTVAL, ?,?,?)");
		stmt.setInt(1, t.getTipoFone());
		stmt.setInt(2, t.getDdd());
		stmt.setString(3, t.getNumero());
		stmt.executeUpdate();
		
		stmt = con.prepareStatement(
				"SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL = ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		int cd = 0;
		if(rs.next()) {
			cd = rs.getInt("CD_USUARIO");
		}
		
		stmt = con.prepareStatement(
				"SELECT CD_FONE FROM T_SPG_TELEFONE WHERE NR_TELEFONE = ?");
		stmt.setString(1, t.getNumero());
		rs = stmt.executeQuery();
		int cdf = 0;
		if(rs.next()) {
			cdf = rs.getInt("CD_FONE");
		}
		
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_USUARIO_FONE "
				+ "(CD_FONE,CD_USUARIO,NR_RAMAL)"
				+ "VALUES (?,?,?)");
		stmt.setInt(1,cdf);
		stmt.setInt(2, cd);
		stmt.setInt(3, t.getRamal());
		stmt.executeQuery();
		stmt.close();
		con.close();
		
		return "Um telefone cadastrado!";
	}
	
	public String deletaTelefone(String email) throws SQLException{
		stmt = con.prepareStatement(
				"SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL = ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		int cd = 0;
		if(rs.next()) {
			cd = rs.getInt("CD_USUARIO");
		}
		
		stmt = con.prepareStatement(
				"SELECT CD_FONE FROM T_SPG_USUARIO_FONE WHERE CD_USUARIO = ?");
		stmt.setInt(1, cd);
		rs = stmt.executeQuery();
		int cdf = 0;
		if(rs.next()) {
			cdf = rs.getInt("CD_FONE");
		}
		
		stmt = con.prepareStatement(
				"DELETE * FROM T_SPG_USUARIO_FONE WHERE CD_USUARIO = ?");
		stmt.setInt(1, cd);
		stmt.executeUpdate();
		
		stmt = con.prepareStatement(
				"DELETE * FROM T_SPG_TELEFONE WHERE CD_FONE = ?");
		stmt.setInt(1, cdf);
		int l = stmt.executeUpdate();
		
		return l + " Telefone Deletado!";
	}
	
	public String atualizaTelefone(TelefoneBeans t, String email) throws SQLException{
		stmt = con.prepareStatement("UPDATE T_SPG_TELEFONE SET "
				+ " CD_TIPO_FONE = ? ,NR_DDD = ?,NR_TELEFONE = ?");
		stmt.setInt(1, t.getTipoFone());
		stmt.setInt(2, t.getDdd());
		stmt.setString(3, t.getNumero());
		stmt.executeUpdate();
		
		stmt = con.prepareStatement(
				"UPDATE T_SPG_USUARIO_FONE SET NR_RAMAL = ?");
		stmt.setInt(1, t.getRamal());
		int l = stmt.executeUpdate();
		return l + " Telefone Atualizado!";
	}
	
	public List<TelefoneBeans> listaTelefone(String email) throws SQLException{
		stmt = con.prepareStatement(
				"SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL = ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		int cd = 0;
		while(rs.next()) {
			cd = rs.getInt("CD_USUARIO");
		}
		
		stmt = con.prepareStatement(
				"SELECT * FROM T_SPG_USUARIO_FONE WHERE CD_USUARIO = ?");
		stmt.setInt(1,cd);
		rs = stmt.executeQuery();
		int cdf = 0;
		int ramal = 0;
		while(rs.next()) {
			cdf = rs.getInt("CD_FONE");
			ramal = rs.getInt("NR_RAMAL");
		}
		
		stmt = con.prepareStatement("SELECT * FROM T_SPG_TELEFONE WHERE CD_TELEFONE = ?");
		stmt.setInt(1, cdf);
		rs = stmt.executeQuery();
		List<TelefoneBeans> listaTelefone = new ArrayList<>();

		while(rs.next()) {
			t = new TelefoneBeans();
			t.setDdd(rs.getInt("NR_DDD"));
			t.setNumero(rs.getString("NR_TELEFONE"));
			t.setTipoFone(rs.getInt("CD_TIPO_FONE"));
			t.setRamal(ramal);
			listaTelefone.add(t);
		}
		return listaTelefone;	
	}	
}
