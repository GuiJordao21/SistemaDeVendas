package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.NotaFiscalBeans;
import br.com.fiap.conexao.Conexao;

public class NotaFiscalDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
    public NotaFiscalDAO() throws Exception{
		
		con = new Conexao().getconnection();	
	}
	
	public void fechar()throws Exception{
		con.close();
	}
	
	//esse método cria uma NF no banco de dados, para ser atualizada com os valores dos itens venda
	public int cadastrar(String op,String data)throws Exception {
				
		stmt=con.prepareStatement("SELECT CD_CLASSIFICACAO FROM T_SPG_CLASS_FISCAL WHERE DS_NATUREZA_OP=?");
		stmt.setString(1, op);
		rs=stmt.executeQuery();
		
		int cd=0;
		
		if(rs.next()){
			cd=rs.getInt("CD_CLASSIFICACAO");
		}
		
		stmt=con.prepareStatement("INSERT INTO T_SPG_NOTA_FISCAL VALUES (SEQ_NOTA_FISCAL.NEXTVAL,?,?,?,?)");
		stmt.setInt(1, cd);
		stmt.setString(2,op);
		stmt.setString(3,data);
		stmt.setDouble(4, 0);
		stmt.executeUpdate();
		
		stmt=con.prepareStatement("SELECT CD_NF FROM T_SPG_NOTA_FISCAL");
		rs=stmt.executeQuery();
		
		int num=0;
		
		while(rs.next()) {
			if(num<rs.getInt("CD_NF")) {
				num=rs.getInt("CD_NF");
			}
		}
		
		stmt.close();
		con.close();
		rs.close();
		
		return num;
		
	}//fim do método
	
	//Esse método retorna uma lista com as notas fiscais
	public List<NotaFiscalBeans> consultar()throws Exception{
		
		stmt=con.prepareStatement("SELECT * FROM T_SPG_NOTA_FISCAL");
		rs=stmt.executeQuery();
		
		NotaFiscalBeans nf=null;
		List<NotaFiscalBeans> lista=new ArrayList<>();
		
		while(rs.next()) {
			
			nf=new NotaFiscalBeans(
									rs.getInt("CD_NF"),
									rs.getString("DS_TIPO"),
									rs.getString("DT_EMISSAO"),
									rs.getDouble("VL_TOTAL_NOTA_FISCAL")
									);
			lista.add(nf);
			
		}//fim while
		
		stmt.close();
		con.close();
		rs.close();
		
		return lista;
		
	}//fim método
	
	//atualiza o valor total da nota fiscal
	public String attValor(int cdv, int cd)throws Exception{
		
		stmt=con.prepareStatement("SELECT VL_TOTAL_ITEM FROM T_SPG_ITEM_VENDA WHERE CD_VENDA=?");
		stmt.setInt(1, cdv);
		rs=stmt.executeQuery();
		
		double vlTot=0;
		
		while(rs.next()) {
			vlTot+=rs.getDouble("VL_TOTAL_ITEM");
		}
		
		stmt=null;
		stmt=con.prepareStatement("UPDATE T_SPG_NOTA_FISCAL SET VL_TOTAL_NOTA_FISCAL=? WHERE CD_NF=?");		
		stmt.setDouble(1, vlTot);
		stmt.setInt(2, cd);
		stmt.executeUpdate();
		
		return "valor atualizado, valor final: "+vlTot;
		
	}//fim do método
	
	public String apagar(int cdnf)throws Exception{
		
		stmt=con.prepareStatement("DELETE FROM T_SPG_NOTA_FISCAL WHERE CD_NF=?");
		stmt.setInt(1, cdnf);
		
		int y=stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
		return y+" nota apagada.";
		
	}
	
}
