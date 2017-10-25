package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.ItemVendaBeans;
import br.com.fiap.beans.ProdutoBeans;

public class ItemVendaDAO {

	private PreparedStatement stmt;
	private ResultSet rs;
	
	//adiciona um item ao item venda
	public String adicionar(int x, int cdv, int qtd, Connection con)throws Exception{
		
		stmt=con.prepareStatement("SELECT * FROM T_SPG_PRODUTO WHERE CD_PRODUTO=?");
		stmt.setInt(1, x);
		rs=stmt.executeQuery();
		
		ProdutoBeans pb=new ProdutoBeans();;
		
		if(rs.next()) {
			pb.setPrecoProd(rs.getDouble("VL_PRECO_UNITARIO"));
		}
		
		stmt=con.prepareStatement("INSERT INTO T_SPG_ITEM_VENDA VALUES(?,?,SEQ_ITEM_VENDA.NEXTVAL,?,?)");
		stmt.setInt(1, cdv);
		stmt.setInt(2, x);
		stmt.setDouble(3, pb.getPrecoProd());
		stmt.setDouble(4, (pb.getPrecoProd()*qtd));
		
		int y=stmt.executeUpdate();
		
		return y+" item adicionado";
	}//fim método
	
	//deletar item venda
	public String deletar(int cd, Connection con)throws Exception{
		
		stmt=con.prepareStatement("DELETE FROM T_SPG_ITEM_VENDA WHERE CD_ITEM=?");
		stmt.setInt(1, cd);
		int y=stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
		return y+" Um item deletado";
		
	}//fim método
	
	public String deletarVenda(int cd, Connection con)throws Exception{
		
		stmt=con.prepareStatement("DELETE FROM T_SPG_ITEM_VENDA WHERE CD_VENDA=?");
		stmt.setInt(1, cd);
		int y=stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
		return y+" Um item deletado";
		
	}
	
	//atualiza valor do item
	public String attItem(int cd, double vl, Connection con)throws Exception{
		
		stmt=con.prepareStatement("SELECT * FROM T_SPG_ITEM_VENDA WHERE CD_ITEM=?");
		stmt.setInt(1, cd);
		rs=stmt.executeQuery();
		
		int qtd=0;
		
		if(rs.next()) {
			qtd=(int)(rs.getDouble("VL_TOTAL_ITEM")/rs.getDouble("VL_UNITARIO_VENDA"));
		}
		
		stmt=con.prepareStatement("UPDATE T_SPG_ITEM_VENDA SET VL_UNITARIO_VENDA=?,VL_TOTAL_ITEM=? WHERE CD_ITEM=?");
		stmt.setDouble(1, vl);
		stmt.setDouble(2, (vl*qtd));
		stmt.setInt(3, cd);
		int y=stmt.executeUpdate();
		
		stmt.close();
		con.close();
		rs.close();
		
		return y+" item atualizado";
		
	}//fim do método
	
	public List<ItemVendaBeans> consultar(int cd, Connection con)throws Exception{
		
		stmt=con.prepareStatement("SELECT * FROM T_SPG_ITEM_VENDA WHERE CD_VENDA=?");
		stmt.setInt(1, cd);
		rs=stmt.executeQuery();
		
		ItemVendaBeans iv=null;
		List<ItemVendaBeans> lista=new ArrayList<>();
		
		while(rs.next()) {
			
			iv=new ItemVendaBeans();
			iv.setCd_item(rs.getInt("CD_ITEM"));
			iv.setPreco(rs.getDouble("VL_UNITARIO_VENDA"));
			iv.setPrecoTot(rs.getDouble("VL_TOTAL_ITEM"));
			iv.setQtd((rs.getDouble("VL_TOTAL_ITEM")/rs.getDouble("VL_UNITARIO_VENDA")));
			lista.add(iv);
			
		}
		
		stmt.close();
		con.close();
		rs.close();
		
		return lista;
		
	}
	
	private List<ProdutoBeans> listaTudo(Connection con)throws Exception{
		
		stmt=con.prepareStatement("SELECT * FROM T_SPG_PRODUTO");
		rs=stmt.executeQuery();
		
		ProdutoBeans iv=null;
		List<ProdutoBeans> lista=new ArrayList<>();
		
		while(rs.next()) {
			
			iv=new ProdutoBeans();
			iv.setIdProd(rs.getInt("CD_PRODUTO"));

			lista.add(iv);
			
		}
				
		stmt.close();
		con.close();
		rs.close();
				
		return lista;
	}
	
	public List<ItemVendaBeans> consultMaiorVal(Connection con)throws Exception{
		
		ItemVendaDAO dao=new ItemVendaDAO();
		
		List<ProdutoBeans> controle=dao.listaTudo(con);
		
		List<ItemVendaBeans> lista=new ArrayList<>();
		ItemVendaBeans item=null;
		
		for (int i=1;i<=controle.size(); i++) {
			stmt=con.prepareStatement("SELECT SUM(VL_TOTAL_ITEM) FROM T_SPG_ITEM_VENDA WHERE CD_PRODUTO=?");
			stmt.setInt(1, i);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				item=new ItemVendaBeans();
				item.setCd_item(i);
				item.setPrecoTot(rs.getDouble("SUM(VL_TOTAL_ITEM)"));
				lista.add(item);
			}
			
		}
		
		stmt.close();
		con.close();
		rs.close();
		
		return lista;
		
	}

}
