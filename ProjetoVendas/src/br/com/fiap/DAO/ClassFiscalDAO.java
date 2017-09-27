package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.ClassFiscalBeans;
import br.com.fiap.conexao.Conexao;


public class ClassFiscalDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
public ClassFiscalDAO() throws Exception{
		
		con = new Conexao().getconnection();	
	}
	
	public void fechar()throws Exception {
		con.close();
	}
	
	//esse método cadastra uma nova classificão fiscal
	public String cadastrar(ClassFiscalBeans x)throws Exception{
		
		stmt=con.prepareStatement("INSERT INTO T_SPG_CLASS_FISCAL VALUES(SEQ_CLASS_FISCAL.NEXTVAL,?,?)");
		stmt.setInt(1, x.getCfop());
		stmt.setString(2, x.getOperacao());
		int y=stmt.executeUpdate();
		stmt.close();
		con.close();
		
		return y+" Classificação Inserida";
	}//fim método cadastro
	
	
	//Esse método procura uma pela natureza da operação
	public List<ClassFiscalBeans> consultaNome(String x)throws Exception{
		
		stmt=con.prepareStatement("SELECT * FROM T_SPG_CLASS_FISCAL WHERE DS_NATUREZA_OP=?");
		stmt.setString(1,x);
		rs=stmt.executeQuery();
		
		List<ClassFiscalBeans> lista=new ArrayList<>();
		ClassFiscalBeans cfb=null;
		
		while(rs.next()) {
			cfb=new ClassFiscalBeans();
			cfb.setCfop(rs.getInt(2));
			cfb.setOperacao(rs.getString(3));
			lista.add(cfb);
		}
		
		stmt.close();
		rs.close();
		con.close();
		
		return lista;
		
	}//fim método
	
	//Esse método procura pelo cfop
	public List<ClassFiscalBeans> consultaNumero(int x)throws Exception{
			
		stmt=con.prepareStatement("SELECT * FROM T_SPG_CLASS_FISCAL WHERE NR_CFOP=?");
		stmt.setInt(1,x);
		rs=stmt.executeQuery();
		
		List<ClassFiscalBeans> lista=new ArrayList<>();
		ClassFiscalBeans cfb=null;
		
		while(rs.next()) {
			cfb=new ClassFiscalBeans();
			cfb.setCfop(rs.getInt(2));
			cfb.setOperacao(rs.getString(3));
			lista.add(cfb);
		}
		
		stmt.close();
		rs.close();
		con.close();
		
		return lista;
			
	}//fim método
	
	//esse método procura o nome da operaçaõ para apaga-la(o nome deve ser escrito exatamente como no banco)
	public String deletarNome(String x)throws Exception{
	
		stmt=con.prepareStatement("DELETE FROM T_SPG_CLASS_FISCAL WHERE DS_NATUREZA_OP=?");
		stmt.setString(1, x);
		int y=stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
		return y+" operações deletadas";
		
	}//fim do método
	
	//esse método procura o numero da operação e a apaga do banco	
	public String deletarNumero(int x)throws Exception{
		
		stmt=con.prepareStatement("DELETE FROM T_SPG_CLASS_FISCAL WHERE NR_CFOP=?");
		stmt.setInt(1, x);
		int y=stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
		return y+" operações deletadas";
		
	}//fim do método
	
	//atualiza o nome das operações
	public String attNome(String x, String y)throws Exception{
		
		stmt=con.prepareStatement("UPDATE T_SPG_CLASS_FISCAL SET DS_NATUREZA_OP=? WHERE DS_NATUREZA_OP=?");
		stmt.setString(1, y);
		stmt.setString(2, x);
		int z=stmt.executeUpdate();
		
		stmt.close();
		con.close();

		return z+" operação atualizada.";
		
	}//fim método
	
	//ATULIZA O NUMERO DA OPERAÇÃO
	public String attNumero(int x, int y)throws Exception{
		
		stmt=con.prepareStatement("UPDATE T_SPG_CLASS_FISCAL SET NR_CFOP=? WHERE NR_CFOP=?");
		stmt.setInt(1, y);
		stmt.setInt(2, x);
		int z=stmt.executeUpdate();
		
		stmt.close();
		con.close();

		return z+" operação atualizada.";
		
	}//fim método
	
}//fim classe
