package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.EstoqueBeans;

public class EstoqueDAO {

	PreparedStatement stmt = null;
	ResultSet rs = null;
	EstoqueBeans e = null;

	public String novoEstoque(EstoqueBeans e, Connection con) throws SQLException{
		
		EnderecoDAO dao=null;
		
		try{
			dao=new EnderecoDAO();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		dao.novoEndereco(e.getEndereco(),con);
		
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_ESTOQUE"
				+ "(CD_ESTOQUE, NR_CEP, QT_LIMITE, DS_DISPONIBILIDADE)"
				+ "VALUES (SEQ_ESTOQUE.NEXTVAL,?,?,?)");
		stmt.setString(1, e.getEndereco().getCep());
		stmt.setInt(2, e.getQntLimite());
		stmt.setString(3, e.getDisponibilidade());
		int l = stmt.executeUpdate();
		return l + " Estoque cadastrado!";
	}
	
	public String deletaEstoque(int cd, Connection con) throws SQLException{
		stmt = con.prepareStatement(
				"DELETE * FROM T_SPG_ESTOQUE WHERE CD_ESTOQUE = ?");
		stmt.setInt(1, cd);
		int l = stmt.executeUpdate();
		return l + " Estoque Deletado!";
	}
	
	public String atualizaEstoque(EstoqueBeans e, Connection con) throws SQLException{
		stmt = con.prepareStatement(
				"UPDATE T_SPG_ESTOQUE SET QT_LIMITE = ?, DS_DISPONIBILIDADE = ?");
		stmt.setInt(1, e.getQntLimite());
		stmt.setString(2, e.getDisponibilidade());
		int l = stmt.executeUpdate();
		return l + " Estoque atualizado!";
	}
	
	public EstoqueBeans retornaEstoque(int cd, Connection con) throws SQLException{
		stmt = con.prepareStatement(
				"SELECT * FROM T_SPG_ESTOQUE WHERE CD_ESTOQUE = ?");
		stmt.setInt(1, cd);
		stmt.executeQuery();
		while(rs.next()) {
			e = new EstoqueBeans();
			e.setQntLimite(rs.getInt("QT_LIMITE"));
			e.setDisponibilidade(rs.getString("DS_DISPONIBILIDADE"));
		}
		return e;
	}
	
	public List<EstoqueBeans> listarEstoques(Connection con) throws SQLException{
		List<EstoqueBeans> listaEstoque = new ArrayList<>();
		stmt = con.prepareStatement(
				"SELECT A.CD_ESTOQUE,"
				+ " A.NR_CEP,"
				+ " A.QT_LIMITE,"
				+ " A.DS_DISPONIBILIDADE,"
				+ " B.NR_LOGRADOURO,"
				+ " B.DS_COMPLEMENTO "
				+ "FROM T_SPG_ESTOQUE A, T_SPG_ESTOQUE_END B "
				+ "WHERE A.NR_CEP=B.NR_CEP");
		stmt.executeQuery();
		while(rs.next()) {
			e = new EstoqueBeans();
			e.setQntLimite(rs.getInt("QT_LIMITE"));
			e.setDisponibilidade(rs.getString("DS_DISPONIBILIDADE"));
			e.getEndereco().setCep(rs.getString("NR_CEP"));
			e.getEndereco().setNumero(rs.getInt("NR_LOGRADOURO"));
			e.getEndereco().setComplemento(rs.getString("DS_COMPLEMENTO"));
			listaEstoque.add(e);
		}
		return listaEstoque;
	}
	
}
