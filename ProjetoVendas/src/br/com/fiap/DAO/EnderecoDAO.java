package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.beans.EnderecoBeans;
import br.com.fiap.conexao.Conexao;

public class EnderecoDAO {
	Connection con= null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public EnderecoDAO(String usuario,String senha) throws Exception{
		con = new Conexao().getConnection(usuario,senha);
	}
	
	public void fechar() throws SQLException{
		con.close();
	}
	
	public void novoEndereco(EnderecoBeans e) throws SQLException{
		
		
		stmt = con.prepareStatement(
				"SELECT CD_ESTADO FROM T_SPG_ESTADO WHERE NM_ESTADO = ?");
		stmt.setString(1, e.getEstado());
		rs = stmt.executeQuery();
		int cde = 0;
		if(rs.next()) {
			cde = rs.getInt("CD_ESTADO");
		}
		
		stmt = con.prepareStatement(""
				+ "INSERT INTO T_SPG_CIDADE"
				+ "(CD_CIDADE, CD_ESTADO, NM_CIDADE)"
				+ "VALUES (SEQ_CIDADE.NEXTVAL,?,?)");
		stmt.setInt(1, cde);
		stmt.setString(2, e.getCidade());
		stmt.executeUpdate();
		
		stmt = con.prepareStatement(
				"SELECT CD_CIDADE FROM T_SPG_CIDADE WHERE NM_CIDADE = ?");
		stmt.setString(1, e.getCidade());
		rs = stmt.executeQuery();
		int cdc = 0;
		if(rs.next()) {
			cdc = rs.getInt("CD_CIDADE");
		}
		
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_BAIRRO"
				+ "(CD_BAIRRO,CD_CIDADE,NM_BAIRRO)"
				+ "VALUES (SEQ_BAIRRO.NEXTVAL,?,?)");
		stmt.setInt(1, cdc);
		stmt.setString(2, e.getBairro());
		stmt.executeUpdate();
		
		stmt = con.prepareStatement(
				"SELECT CD_BAIRRO FROM T_SPG_BAIRRO WHERE NM_BAIRRO = ?");
		stmt.setString(1, e.getBairro());
		rs = stmt.executeQuery();
		int cdb = 0;
		if(rs.next()) {
			cdb = rs.getInt("CD_BAIRRO");
		}
		
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_TIPO_LOG"
				+ "(CD_TIPO_LOGRADOURO,DS_TIPO_LOGRADOURO)"
				+ "VALUES (SEQ_TIPO_LOG.NEXTVAL,?)");
		stmt.setString(1, e.getTipoLog());
		stmt.executeUpdate();
		
		stmt = con.prepareStatement(
				"SELECT CD_TIPO_LOGRADOURO FROM T_SPG_TIPO_LOG WHERE DS_TIPO_LOGRADOURO = ?");
		stmt.setString(1, e.getTipoLog());
		rs = stmt.executeQuery();
		int cdtl = 0;
		if(rs.next()) {
			cdtl = rs.getInt("CD_TIPO_LOGRADOURO");
		}
		
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_LOGRADOURO"
				+ "(NR_CEP,CD_BAIRRO,CD_TIPO_LOGRADOURO)"
				+ "VALUES (SEQ_BAIRRO.NEXTVAL,?,?)");
		stmt.setString(1, e.getCep());
		stmt.setInt(2, cdb);
		stmt.setInt(3, cdtl);
		stmt.executeUpdate();
		
		
	}
}
