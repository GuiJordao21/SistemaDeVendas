package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.VendaBeans;
import br.com.fiap.conexao.Conexao;


public class VendaDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
     public VendaDAO() throws Exception{
		
		con = new Conexao().getconnection();	
	}
	public void fechar()throws Exception {
		con.close();
	}
	
	public VendaBeans cadastrar(int x, String email,String data,String hora)throws Exception{
		
		stmt=con.prepareStatement("SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL=?");
		stmt.setString(1, email);
		rs=stmt.executeQuery();
		
		int cd=0;
		
		if(rs.next()) {
			cd=rs.getInt("CD_USUARIO");
		}
		
		stmt=con.prepareStatement("INSERT INTO T_SPG_VENDA VALUES (SEQ_VENDA.NEXTVAL,?,?,?,?,?)");
		stmt.setInt(1,x);
		stmt.setInt(2, cd);
		stmt.setDouble(3, 0);
		stmt.setString(4, data);
		stmt.setString(5, hora);
		stmt.executeUpdate();
		
		stmt=con.prepareStatement("SELECT CD_VENDA FROM T_SPG_VENDA");
		rs=stmt.executeQuery();
		
		VendaBeans vb=new VendaBeans();
		
		while(rs.next()) {
			vb.setCd(rs.getInt("CD_VENDA"));
		}
		
		stmt.close();
		con.close();
		rs.close();
		
		return vb;
	}
	
	public String attValor(int cdv, int cd)throws Exception{
		
		stmt=con.prepareStatement("SELECT VL_TOTAL_ITEM FROM T_SPG_ITEM_VENDA WHERE CD_VENDA=?");
		stmt.setInt(1, cdv);
		rs=stmt.executeQuery();
		
		double vlTot=0;
		
		while(rs.next()) {
			vlTot+=rs.getDouble("VL_TOTAL_ITEM");
		}
		
		stmt=null;
		stmt=con.prepareStatement("UPDATE T_SPG_VENDA SET VL_VENDA=? WHERE CD_NF=?");		
		stmt.setDouble(1, vlTot);
		stmt.setInt(2, cd);
		stmt.executeUpdate();
		
		stmt.close();
		con.close();
		rs.close();
		
		return "valor atualizado, valor final: "+vlTot;

		
	}
	
	public String deletar(int cd)throws Exception{
		
		stmt=con.prepareStatement("DELETE FROM T_SPG_VENDA WHERE CD_VENDA=?");
		stmt.setInt(1, cd);
		int y=stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
		return y+" venda Deletada";
		
	}
	
	public List<VendaBeans> consultar()throws Exception{
		
		stmt=con.prepareStatement("SELECT * FROM T_SPG_VENDA");
		rs=stmt.executeQuery();
		
		VendaBeans v=null;
		List<VendaBeans> lista=new ArrayList<>();
		
		while(rs.next()) {
			v=new VendaBeans();
			v.setCd(rs.getInt(1));
			v.setValor(rs.getDouble(4));
			v.setData(rs.getString(5));
			v.setHora(rs.getString(6));
			lista.add(v);
		}
		
		return lista;
		
	}
	
	public String desconto(int cdv, double desc)throws Exception{
		
		stmt=con.prepareStatement("UPDATE T_SPG_VENDA SET VL_VENDA=VL_VENDA-(VL_VENDA*?) WHERE CD_VENDA=?");
		stmt.setDouble(1, desc/100);
		stmt.setInt(2, cdv);
		stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
		return "Atualizado com sucesso!";
	}
	
	public String aumento(int cdv, double aum)throws Exception{
		
		stmt=con.prepareStatement("UPDATE T_SPG_VENDA SET VL_VENDA=VL_VENDA+(VL_VENDA*?) WHERE CD_VENDA=?");
		stmt.setDouble(1, aum/100);
		stmt.setInt(2, cdv);
		stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
		return "Atualizado com sucesso!";
	}
	
}
