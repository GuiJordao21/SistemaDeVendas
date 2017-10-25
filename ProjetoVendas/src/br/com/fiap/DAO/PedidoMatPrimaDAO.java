package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.pedidoMatPrima;

public class PedidoMatPrimaDAO {

	PreparedStatement stmt;
	ResultSet rs;

	// GRAVAR
	public String gravarPedido(pedidoMatPrima obj, String email, Connection con)throws Exception{
		
		stmt=con.prepareStatement("SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL=?");
		stmt.setString(1, email);
		rs=stmt.executeQuery();
		int cd=0;
		
		if(rs.next()) {
			cd=rs.getInt("CD_USUARIO");
		}
		
		 stmt=con.prepareStatement("INSERT INTO T_SPG_PEDIDO_MATERIA_PRIMA "
		 		+ "(CD_USUARIO, CD_PEDIDO, QT_PEDIDO, DT_PEDIDO, HR_PEDIDO, DS_PEDIDO) "
		 		+ "VALUES (?,SEQ_PEDIDO_MATERIA_PRIMA.NEXTVAL, ?, ?, ?, ?)");
		 
		 stmt.setInt(1, cd);
		 stmt.setInt(2, obj.getQtPedidos());
		 stmt.setString(3, obj.getDatapedido());
		 stmt.setString(4, obj.getHorapedido());
		 stmt.setString(5, obj.getDescricao());
		
		 
		 
		 stmt.execute();
		 
		 stmt.close();
		return "Pedido Gravado com sucesso";
		
	}
	//GRAVAR
	public String gravarProcessamento(pedidoMatPrima obj, int cdfor, int cdmat,String email, int cdped, Connection con)throws Exception{
		
		stmt=con.prepareStatement("SELECT CD_USUARIO FROM T_SPG_USUARIO WHERE DS_EMAIL=?");
		stmt.setString(1, email);
		rs=stmt.executeQuery();
		
		int cd=0;
		
		if(rs.next()) {
			cd=rs.getInt("CD_USUARIO");
		}
		
		stmt=con.prepareStatement("INSERT INTO T_SPG_MAT_SOLICITADA "
		 		+ "(CD_MATERIA_PRIMA, CD_USUARIO, CD_FORNECEDOR, QT_COMPRADA, DT_SOLICITACAO, HR_SOLICITACAO, VL_MAT_SOLICITADA, CD_PEDIDO) "
		 		+ "VALUES (?, ?, ?, ?, ?, ?, ?,?)");
		stmt.setInt(1, cdmat);
		stmt.setInt(2, cd);
		stmt.setInt(3, cdfor);
		stmt.setDouble(4,obj.getQuantProcessada());
		stmt.setString(5, obj.getDataProcessamento());
		stmt.setString(6, obj.getHoraProcessamento());
		stmt.setDouble(7, obj.getVlMatProcessada());
		stmt.setInt(8, cdped);
		
		stmt.execute();
		stmt.close();
		
		return "Processamento gravado";
	}
	
	//GRAVAR
	public String gravarFornecida(pedidoMatPrima obj, int cdfor, int cdmat, int cdped, Connection con)throws Exception{
		stmt=con.prepareStatement("INSERT INTO T_SPG_MAT_PRIMA_FORNECIDA"
		 		+ "(CD_MATERIA_PRIMA, CD_FORNECEDOR, QT_MATERIA_FORNECIDA, VL_MAT_FORN, CD_PEDIDO) "
		 		+ "VALUES (?, ?, ?, ?,?)");
		
		stmt.setInt(1, cdmat);
		stmt.setInt(2, cdfor);
		stmt.setDouble(3, obj.getQuantFornecida());
		stmt.setDouble(4, obj.getVlMatFornecida());
		stmt.setInt(5, cdped);
		
		stmt.execute();
		
		
		return "Gravada Materia prima Fornecida";
	}
	
	//UPDATE PEDIDO
	public String atualizaPedido(pedidoMatPrima obj, int num, Connection con)throws Exception{
		stmt=con.prepareStatement("UPDATE T_SPG_PEDIDO_MATERIA_PRIMA SET QT_PEDIDO=?, DS_PEDIDO=? WHERE CD_PEDIDO=?");
		stmt.setInt(1, obj.getQtPedidos());
		stmt.setString(2, obj.getDescricao());
		stmt.setInt(3, num);
		stmt.executeUpdate();
		stmt.close();
		return "Pedido Atualizado";
	}
	//UPDATE PED PROCESSADO
	
	public String atualizaProcessamento(pedidoMatPrima obj, int num, Connection con)throws Exception{
		stmt=con.prepareStatement("UPDATE T_SPG_MAT_SOLICITADA SET QT_COMPRADA=?,  VL_MAT_SOLICITADA=? WHERE CD_PEDIDO=?");
		stmt.setDouble(1, obj.getQuantProcessada());
		stmt.setDouble(2, obj.getVlMatProcessada());
		stmt.setInt(3, num);
		stmt.executeUpdate();
		stmt.close();
		return "Pedido Atualizado";
	}
	
	//UPDATE PED FORNECIDO
	public String atualizaFornercida(pedidoMatPrima obj, int num, Connection con)throws Exception{
		stmt=con.prepareStatement("UPDATE T_SPG_MAT_PRIMA_FORNECIDA SET QT_MATERIA_FORNECIDA=?,  VL_MAT_FORN=? WHERE CD_PEDIDO=?");
		stmt.setDouble(1, obj.getQuantFornecida());
		stmt.setDouble(2, obj.getVlMatFornecida());
		stmt.setInt(3, num);
		stmt.executeUpdate();
		stmt.close();
		return "Pedido Atualizado";
	}
	
	
	
	
	//DELETAR PEDIDO
	public String deletaPedido(int n, Connection con)throws Exception{
		stmt=con.prepareStatement("DELETE * FROM T_SPG_PEDIDO_MATERIA_PRIMA WHERE CD_PEDIDO=?");
		stmt.setInt(1, n);
		stmt.executeUpdate();
		stmt.close();
		return "Pedido Excluído";
	}
	
	//DELETAR PED PROCESSAMENTO
	public String deletaProcessamento(int n, Connection con)throws Exception{
		stmt=con.prepareStatement("DELETE * FROM T_SPG_MAT_SOLICITADA WHERE CD_PEDIDO=?");
		stmt.setInt(1, n);
		stmt.executeUpdate();
		stmt.close();
	return "Pedido Excluído";
	}
		
    // DELETAR PED FORNECIDO
	public String deletaFornecida(int n, Connection con)throws Exception{
		stmt=con.prepareStatement("DELETE * FROM T_SPG_MAT_PRIMA_FORNECIDA WHERE CD_PEDIDO=?");
		stmt.setInt(1, n);
		stmt.executeUpdate();
		stmt.close();
	return "Pedido Excluído";
	}		
	
	// Pesquisar
		
	public pedidoMatPrima pesquisa(int n, Connection con)throws Exception{
		pedidoMatPrima prod = new pedidoMatPrima();
	    stmt=con.prepareStatement("SELECT * FROM T_SPG_PEDIDO_MATERIA_PRIMA WHERE CD_PEDIDO=?");
	    stmt.setInt(1, n);
	    rs=stmt.executeQuery();
	    if (rs.next()) {
	    	prod.setQtPedidos(rs.getInt("QT_PEDIDO"));
	    	prod.setDescricao(rs.getString("DS_PEDIDO"));
	    	prod.setDatapedido(rs.getString("DT_PEDIDO"));
	    	prod.setHorapedido(rs.getString("HR_PEDIDO"));
	    }
	    stmt=con.prepareStatement("SELECT * FROM T_SPG_MAT_SOLICITADA WHERE CD_PEDIDO=?");
	    stmt.setInt(1, n);
	    rs=stmt.executeQuery();
	    if (rs.next()) {
	    	prod.setDataProcessamento(rs.getString("DT_SOLICITACAO"));
	    	prod.setHoraProcessamento(rs.getString("HR_SOLICITACAO"));
	    	prod.setQuantProcessada(rs.getDouble("QT_COMPRADA"));
	    	prod.setVlMatProcessada(rs.getDouble("VL_MAT_SOLICITADA"));
	    }
	    stmt=con.prepareStatement("SELECT * FROM T_SPG_MAT_PRIMA_FORNECIDA WHERE CD_PEDIDO=?");
	    stmt.setInt(1, n);
	    rs=stmt.executeQuery();
	    if (rs.next()) {
	    	prod.setQuantFornecida(rs.getDouble("QT_MATERIA_FORNECIDA"));
	    	prod.setVlMatFornecida(rs.getDouble("VL_MAT_FORN"));
	    }
	    
		return prod;
	}
		
	public List<pedidoMatPrima> listar(Connection con)throws Exception{
		pedidoMatPrima prod = new pedidoMatPrima();
		List<pedidoMatPrima> minhalista = new ArrayList<pedidoMatPrima>();
		stmt=con.prepareStatement("SELECT A.CD_USUARIO, A.CD_PEDIDO, A.QT_PEDIDO, A.DT_PEDIDO, A.HR_PEDIDO, A.DS_PEDIDO, A.CD_ORDEM,"
				                      + "B.CD_MATERIA_PRIMA, B.CD_USUARIO, B.CD_FORNECEDOR, B.QT_COMPRADA, B.DT_SOLICITACAO, B.HR_SOLICITACAO, B.VL_MAT_SOLICITADA, B.CD_PEDIDO,"
				                      + "C.CD_MATERIA_PRIMA, C.CD_FORNECEDOR, C.QT_MATERIA_FORNECIDA, C.VL_MAT_FORN, C.CD_PEDIDO "
				                      + "FROM T_SPG_PEDIDO_MATERIA_PRIMA A, T_SPG_MAT_SOLICITADA B, T_SPG_MAT_PRIMA_FORNECIDA C WHERE "
				                      + "A.CD_PEDIDO=B.CD_PEDIDO AND B.CD_PEDIDO=C.CD_PEDIDO");
		rs=stmt.executeQuery();
		
		while (rs.next()) {
			prod= new pedidoMatPrima();
	    	prod.setDescricao(rs.getString("DS_PEDIDO"));
	    	prod.setDatapedido(rs.getString("DT_PEDIDO"));
	    	prod.setHorapedido(rs.getString("HR_PEDIDO"));
	    	
	    	prod.setDataProcessamento(rs.getString("DT_SOLICITACAO"));
	    	prod.setHoraProcessamento(rs.getString("HR_SOLICITACAO"));
	    	prod.setQuantProcessada(rs.getDouble("QT_COMPRADA"));
	    	prod.setVlMatProcessada(rs.getDouble("VL_MAT_SOLICITADA"));
	    	
	    	prod.setQuantFornecida(rs.getDouble("QT_MATERIA_FORNECIDA"));
	    	prod.setVlMatFornecida(rs.getDouble("VL_MAT_FORN"));
	    	
	    	minhalista.add(prod);
			
		}
		stmt.close();
		return minhalista;		
	}
		
		
}
