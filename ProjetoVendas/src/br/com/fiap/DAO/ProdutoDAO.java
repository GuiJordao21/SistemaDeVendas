package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.ProdutoBeans;


public class ProdutoDAO {

	private PreparedStatement stmt = null;
	private ResultSet rs=null;
	
	public String novoProduto(ProdutoBeans p, Connection con) throws SQLException{
		stmt = con.prepareStatement(
				"INSERT INTO T_SPG_PRODUTO"
				+ "(CD_PRODUTO,DS_PRODUTO,VL_PRECO_UNITARIO,DS_DISPONIBILIDADE,NM_PRODUTO,DS_URL)"
				+ "VALUES (SEQ_PRODUTO.NEXTVAL,?,?,?,?,?)");
		stmt.setString(1,p.getDescProd());
		stmt.setDouble(2,p.getPrecoProd());
		stmt.setString(3,p.getDisp());
		stmt.setString(4,p.getNomeProd());
		stmt.setString(5,p.getUrlImg());
		int l = stmt.executeUpdate();
		stmt.close();
		return l + " Produto Cadastrado!";
	}
	
	public String deletaProduto(int n, Connection con) throws SQLException{
		stmt = con.prepareStatement(
				"DELETE FROM T_SPG_PRODUTO WHERE CD_PRODUTO = ?");
		stmt.setInt(1, n);
		int l = stmt.executeUpdate();
		stmt.close();
		return l + " Produto Excluido!";
	}
	
	public String atualizaProduto(ProdutoBeans p, Connection con) throws SQLException{
		stmt = con.prepareStatement(
				"UPDATE T_SPG_PRODUTO SET DS_PRODUTO = ?, VL_PRECO_UNITARIO = ?, DS_DISPONIBILIDADE = ?, NM_PRODUTO = ?, DS_URL = ? WHERE CD_PRODUTO = ?");
		stmt.setString(1,p.getDescProd());
		stmt.setDouble(2,p.getPrecoProd());
		stmt.setString(3,p.getDisp());
		stmt.setString(4,p.getNomeProd());
		stmt.setString(5,p.getUrlImg());
		stmt.setLong(6, p.getIdProd());
		int l = stmt.executeUpdate();
		stmt.close();
		
		return l + " Produto alterado!";
	}
	
	public ProdutoBeans pesquisaProduto(int n, Connection con) throws SQLException{
		ProdutoBeans p = new ProdutoBeans();
		stmt = con.prepareStatement("SELECT * FROM T_SPG_PRODUTO WHERE CD_PRODUTO = ?");
		stmt.setInt(1, n);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			p.setIdProd(rs.getInt("CD_PRODUTO"));
			p.setDescProd(rs.getString("DS_PRODUTO"));
			p.setPrecoProd(rs.getInt("VL_PRECO_UNITARIO"));
			p.setDisp(rs.getString("DS_DISPONIBILIDADE"));
			p.setNomeProd(rs.getString("NM_PRODUTO"));
			p.setUrlImg(rs.getString("DS_URL"));	
		}
		return p;
	}
	
	public List<ProdutoBeans> listarProduto(Connection con){	
		try {
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM T_SPG_PRODUTO");
			ResultSet rs = ps.executeQuery();
			List<ProdutoBeans> listaProd = new ArrayList<ProdutoBeans>();
			ProdutoBeans p = null;	
			while(rs.next()){
				p = new ProdutoBeans();
				p.setIdProd(rs.getInt(1));
				p.setNomeProd(rs.getString(2));
				p.setUrlImg(rs.getString(3));
				p.setPrecoProd(rs.getDouble(4));

				p.setDescProd(rs.getString(5));
				p.setDisp(rs.getNString(6));
				listaProd.add(p);
			}
			rs.close();
			ps.close();
			con.close();
			return listaProd;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
		return null;		
	}
}
