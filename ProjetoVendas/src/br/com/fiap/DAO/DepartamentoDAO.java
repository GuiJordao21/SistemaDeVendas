package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.beans.DepartamentoBeans;

public class DepartamentoDAO {
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Connection con = null;
	DepartamentoBeans d = null;
	
	public DepartamentoDAO(String usuario,String senha) throws Exception{
		con = new Conexao().getConnection(usuario,senha);
	}
	
	public void fechar() throws SQLException{
		con.close();
	}
	
	public String cadastraDepartamento(DepartamentoBeans d) throws SQLException{
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_DEPARTAMENTO"
				+ "(CD_DEPARTAMENTO, DS_DEPARTAMENTO,QT_FUNCIONARIOS)"
				+ "VALUES (SEQ_DEPARTAMENTO.NEXTVAL, ?,?)");
		stmt.setString(1, d.getDescricao());
		stmt.setInt(2, d.getQtdFuncionarios());
		int l = stmt.executeUpdate();
		return l + "Departamento cadastrado!";
	}
	
	public DepartamentoBeans consultaDepartamento(String nome) throws SQLException{
		d = new DepartamentoBeans();
		stmt = con.prepareStatement(
				"SELECT * FROM T_SPG_DEPARTAMENTO WHERE DS_DEPARTAMENTO = ?");
		stmt.setString(1, nome);
		rs = stmt.executeQuery();
		while(rs.next()) {
			d.setDescricao(rs.getString("DS_DEPARTAMENTO"));
			d.setQtdFuncionarios(rs.getInt("QT_FUNCIONARIOS"));
		}
		return d;
	}
	
	public String deletaDepartamento(String desc) throws SQLException{
		stmt = con.prepareStatement(
				"DELETE * FROM T_SPG_DEPARTAMENTO WHERE DS_DEPARTAMENTO = ?");
		stmt.setString(1, desc);
		int l = stmt.executeUpdate();
		return l + "Telefone deletado";
	}
	
	public String atualizaDepartamento(DepartamentoBeans d) throws SQLException{
		stmt = con.prepareStatement(
				"UPDATE T_SPG_DEPARTAMENTO"
				+ " SET DS_DEPARTAMENTO = ?,QT_FUNCIONARIOS = ?");
		stmt.setString(1, d.getDescricao());
		stmt.setInt(2, d.getQtdFuncionarios());
		int l = stmt.executeUpdate();
		return l + "Telefone atualizado!";
	}
	
	public List<DepartamentoBeans> listarDepartamento() throws SQLException{
		stmt = con.prepareStatement("SELECT * FROM T_SPG_DEPARTAMENTO");
		rs = stmt.executeQuery();
		List<DepartamentoBeans> listaDepto = new ArrayList<>();
		while(rs.next()){
			d = new DepartamentoBeans();
			d.setDescricao(rs.getString("DS_DEPARTAMENTO"));
			d.setQtdFuncionarios(rs.getInt("QT_FUNCIONARIOS"));
			listaDepto.add(d);
		}
		return listaDepto;
	}
}
