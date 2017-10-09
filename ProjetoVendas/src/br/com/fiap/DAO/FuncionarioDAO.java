package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.beans.FuncionarioBeans;

public class FuncionarioDAO {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	FuncionarioBeans f = null;

	public FuncionarioDAO(String usuario,String senha) throws Exception{
		con = new Conexao().getConnection(usuario,senha);
	}

	public void fechar() throws SQLException{
		con.close();
	}

	public String novoFuncionario(FuncionarioBeans f) throws SQLException{
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_USUARIO"
						+ "(CD_USUARIO, NM_NOME,DS_EMAIL,DS_SENHA)"
						+ "VALUES (SEQ_FUNCIONARIO.NEXTVAL,?,?,?)");
		stmt.setString(1, f.getNmUsuario());
		stmt.setString(2, f.getDsemail());
		stmt.setString(3, f.getSenha());
		stmt.executeUpdate();

		stmt = con.prepareStatement(
				"SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL = ?");
		stmt.setString(1, f.getDsemail());
		rs = stmt.executeQuery();
		int cdu = 0;
		while(rs.next()) {
			cdu = rs.getInt("CD_USUARIO");
		}

		stmt = con.prepareStatement(
				"SELECT CD_DEPARTAMENTO FROM T_SPG_DEPARTAMENTO WHERE DS_DEPARTAMENTO = ?");
		stmt.setString(1, f.getDepartamento());
		rs = stmt.executeQuery();
		int cdd = 0;
		while(rs.next()) {
			cdd = rs.getInt("CD_DEPARTAMENTO");
		}

		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_FUNCIONARIO"
						+ "(CD_USUARIO,CD_DEPARTAMENTO,DS_RG,NR_CPF)"
						+ "VALUES(?,?,?,?)");
		stmt.setInt(1, cdu);
		stmt.setInt(2, cdd);
		stmt.setString(3, f.getRg());
		stmt.setString(4, f.getCpf());
		int l = stmt.executeUpdate();
		return l + " Funcionario Cadastrado!";
	}

	public String atualizaFuncionario(FuncionarioBeans f) throws SQLException{
		stmt = con.prepareStatement(
				"UPDATE T_SPG_USUARIO"
						+ "SET NM_NOME = ?, DS_EMAIL = ?, DS_SENHA = ?");
		stmt.setString(1, f.getNmUsuario());
		stmt.setString(2, f.getDsemail());
		stmt.setString(3, f.getSenha());
		stmt.executeUpdate();

		stmt = con.prepareStatement(
				"UPDATE T_SPG_FUNCIONARIO"
						+ "SET DS_RG = ?, NR_CPF = ?");
		stmt.setString(1, f.getRg());
		stmt.setString(2,f.getCpf());
		int l = stmt.executeUpdate();
		return l + " Funcionario Atualizado!";
	}

	public String deletaFuncionario(String email)throws SQLException {
		stmt = con.prepareStatement(
				"SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL = ? ");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		int cdf = 0;
		while(rs.next()) {
			cdf = rs.getInt("CD_USUARIO");
		}

		stmt = con.prepareStatement(
				"DELETE * FROM T_SPG_FUNCIONARIO WHERE CD_USUARIO = ?");
		stmt.setInt(1, cdf);
		stmt.executeUpdate();

		stmt = con.prepareStatement(
				"DELETE * FROM T_SPG_USUARIO WHERE CD_USUARIO = ?");
		stmt.setInt(1, cdf);
		int l = stmt.executeUpdate();
		return l + "Funcionario Deletado!";
	}

	public FuncionarioBeans retornaFuncionario(String email) throws SQLException{
		f = new FuncionarioBeans();

		stmt = con.prepareStatement(
				"SELECT * FROM T_SPG_USUARIO WHERE DS_EMAIL = ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		int cdu = 0;
		while(rs.next()) {
			f.setNmUsuario(rs.getString("NM_NOME"));
			f.setDsemail(rs.getString("DS_EMAIL"));
			f.setSenha(rs.getString("DS_SENHA"));
			cdu = rs.getInt("CD_USUARIO");
		}

		stmt = con.prepareStatement(
				"SELECT * FROM T_SPG_FUNCIONARIO WHERE CD_USUARIO = ?");
		stmt.setInt(1, cdu);
		while(rs.next()) {
			f.setRg(rs.getString("DS_RG"));
			f.setCpf(rs.getString("NR_CPF"));
		}
		return f;
	}

	public List<FuncionarioBeans> listarFuncionarios() throws SQLException{
		List<FuncionarioBeans> listaFuncionario = new ArrayList<>();
		
		stmt = con.prepareStatement("SELECT * FROM T_SPG_USUARIO");
		stmt.executeQuery();
		while(rs.next()) {
			f = new FuncionarioBeans();
			f.setNmUsuario(rs.getString("NM_NOME"));
			f.setDsemail(rs.getString("DS_EMAIL"));
			f.setSenha(rs.getString("DS_SENHA"));
			
			stmt = con.prepareStatement("SELECT * FROM T_SPG_FUNCIONARIO");
			stmt.executeQuery();
			while(rs.next()) {
				f.setRg(rs.getString("DS_RG"));
				f.setCpf(rs.getString("NR_CPF"));
			}
			listaFuncionario.add(f);
		}
		return listaFuncionario;
	}
}
