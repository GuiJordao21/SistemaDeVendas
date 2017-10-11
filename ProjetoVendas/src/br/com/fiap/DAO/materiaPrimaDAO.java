package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.materiaPrima;
import br.com.fiap.conexao.Conexao;

public class materiaPrimaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public materiaPrimaDAO(String usuario, String senha) throws Exception{
		con = new Conexao().getConnection(usuario, senha);
	}
	
	public void fechar() throws Exception{
		con.close();
	}
	
	public String Gravar(materiaPrima obj)throws Exception{
		stmt=con.prepareStatement("INSERT INTO T_SPG_UN_MEDIDA (CD_UN_MEDIDA, DS_UN_MEDIDA) VALUES (SEQ_UN_MEDIDA.NEXTVAL,?)");
		stmt.setString(1, obj.getUnidMedida());
		stmt.execute();
		
		stmt=con.prepareStatement("SELECT CD_UN_MEDIDA FROM T_SPG_UN_MEDIDA");
		rs=stmt.executeQuery();
		
		int cd=0;
		
		if(rs.next()) {
			cd=rs.getInt("CD_UN_MEDIDA");
		}
		
		stmt=con.prepareStatement("INSERT INTO T_SPG_MATERIA_PRIMA (CD_MATERIA_PRIMA,DS_MAT_PRIMA, VL_MAT_PRIMA,CD_UN_MEDIDA) VALUES (SEQ_MATERIA_PRIMA.NEXTVAL,?,?,?)");
		stmt.setString(1, obj.getDescricao());
		stmt.setDouble(2, obj.getValor());
		stmt.setInt(3, cd);
		
		stmt.execute();
		stmt.close();
		
		return "Materia Prima Cadastrada com ssucesso";
	}
	
	
	public String apagar(int num)throws Exception {
		stmt=con.prepareStatement("DELETE FROM T_SPG_MATERIA_PRIMA WHERE CD_MATERIA_PRIMA=?");
		stmt.setInt(1, num);
		stmt.executeUpdate();
		
		
		
		stmt=con.prepareStatement("DELETE FROM T_SPG_UN_MEDIDA WHERE CD_UN_MEDIDA=?");
		stmt.setInt(1, num);
		stmt.executeUpdate();
		
		
		stmt.close();
		
		
		return "Materia Prima Apagada";
	}
	
	
	public String atualizarMatP(int n, materiaPrima obj)throws Exception{
		stmt=con.prepareStatement("UPDATE T_SPG_MATERIA_PRIMA SET DS_MAT_PRIMA=?, VL_MAT_PRIMA=? WHERE CD_MATERIA_PRIMA=?");
		stmt.setString(1, obj.getDescricao());
		stmt.setDouble(2, obj.getValor());
		stmt.setInt(3, n);
		stmt.executeUpdate();
		
		stmt=con.prepareStatement("UPDATE T_SPG_UN_MEDIDA SET DS_UN_MEDIDA=? WHERE CD_UN_MEDIDA=?");
		stmt.setString(1, obj.getUnidMedida());
		stmt.setInt(2, n);
		stmt.executeUpdate();
		
		stmt.executeUpdate();
		stmt.close();
		
		
		return "Materia Prima Atualizada";
	}
	
	public materiaPrima pesquisa(int n) throws Exception{
		materiaPrima obj = new materiaPrima();
		stmt=con.prepareStatement("SELECT * FROM T_SPG_MATERIA_PRIMA WHERE CD_MATERIA_PRIMA=?");
		stmt.setInt(1, n);
		rs = stmt.executeQuery();
		if (rs.next()) {
			obj.setCdMatPrima(rs.getInt("CD_MATERIA_PRIMA"));
			obj.setDescricao(rs.getString("DS_MAT_PRIMA"));
			obj.setValor(rs.getDouble("VL_MAT_PRIMA"));
			
		}
		stmt=con.prepareStatement("SELECT * FROM T_SPG_UN_MEDIDA WHERE CD_UN_MEDIDA=?");
		stmt.setInt(1, n);
		rs = stmt.executeQuery();
		if (rs.next()) {
			obj.setUnidMedida(rs.getString("DS_UN_MEDIDA"));
			
		}
		
		
		
		stmt.close();
		
		return obj;
	}
	
	public List<materiaPrima> listaMat()throws Exception{
		List<materiaPrima> lista = new ArrayList<materiaPrima>();
		materiaPrima mat = new materiaPrima();
		stmt=con.prepareStatement("SELECT A.DS_UN_MEDIDA, B.DS_MAT_PRIMA, B.VL_MAT_PRIMA, B.CD_MATERIA_PRIMA FROM T_SPG_UN_MEDIDA A,T_SPG_MATERIA_PRIMA B WHERE A.CD_UN_MEDIDA=B.CD_UN_MEDIDA");
		rs=stmt.executeQuery();
		while (rs.next()){
			mat = new materiaPrima();
			mat.setCdMatPrima(rs.getInt("CD_MATERIA_PRIMA"));
			mat.setDescricao(rs.getString("DS_MAT_PRIMA"));
			mat.setValor(rs.getDouble("VL_MAT_PRIMA"));
			mat.setUnidMedida(rs.getString("DS_UN_MEDIDA"));
			lista.add(mat);
		}
		stmt.close();
		return lista;
	}
	
	
	
}
