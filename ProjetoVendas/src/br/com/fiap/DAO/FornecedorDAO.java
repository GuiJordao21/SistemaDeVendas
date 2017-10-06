package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.FornecedorBeans;
import br.com.fiap.conexao.Conexao;

public class FornecedorDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
     public FornecedorDAO(String usuario, String senha) throws Exception{
		
		con = new Conexao().getConnection(usuario, senha);	
	}
	public void fechar()throws Exception {
		con.close();
	}
	
	//método para cadastro de fornecedores
	public String cadastrar(FornecedorBeans fb)throws Exception{
		
		stmt=con.prepareStatement("INSERT INTO T_SPG_FORNECEDOR VALUES("
				+ "SEQ_FORNECEDOR.NEXTVAL,?,?,?,?)");
		stmt.setString(1,fb.getNome());
		stmt.setString(2,fb.getEmail());
		stmt.setLong(3,fb.getCnpj());
		stmt.setString(4,fb.getRzSocial());
		stmt.executeUpdate();
				
		return "Fornecedor Cadastrado";
		
	}//fim do método
	
	//método para listar os fornecedores existentes no sistema
	public List<FornecedorBeans> consultarNome(String nome)throws Exception{
		
		stmt=con.prepareStatement("SELECT * FROM T_SPG_FORNECEDOR WHERE "
				+ "NM_FORNECEDOR LIKE ?");
		stmt.setString(1, "%"+nome+"%");
		rs=stmt.executeQuery();
		
		FornecedorBeans fb=null;
		List<FornecedorBeans> lista=new ArrayList<>();
		
		while(rs.next()){
			fb=new FornecedorBeans(
									rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getLong(4),
									rs.getString(5)
									);
			lista.add(fb);
		}
		
		stmt.close();
		rs.close();
		
		return lista;
	}//fim do método
		
	//atualizar infos do fornecedor
	public String atualizarN(int cd,String info)throws Exception{
		//att nome
		stmt=con.prepareStatement("UPDATE T_SPG_FORNECEDOR SET NM_FORNECEDOR=? "
				+ "WHERE CD_FORNECEDOR=?");
		stmt.setString(1, info);
		stmt.setInt(2, cd);
		int x=stmt.executeUpdate();
		
		stmt.close();
		
		return x+" nome atualizado.";
	}
	
	public String atualizarE(int cd,String info)throws Exception{
		//att email
		stmt=con.prepareStatement("UPDATE T_SPG_FORNECEDOR SET DS_EMAIL=? "
				+ "WHERE CD_FORNECEDOR=?");
		stmt.setString(1, info);
		stmt.setInt(2, cd);
		int x=stmt.executeUpdate();
		
		stmt.close();
		
		return x+" email atualizado.";
	}
	
	public String atualizarR(int cd,String info)throws Exception{
		//att razão social
		stmt=con.prepareStatement("UPDATE T_SPG_FORNECEDOR SET DS_RAZAO_SOCIAL=? "
				+ "WHERE CD_FORNECEDOR=?");
		stmt.setString(1, info);
		stmt.setInt(2, cd);
		int x=stmt.executeUpdate();
		
		stmt.close();
		
		return x+" Razão Social atualizada.";
	}
	
	public String atualizarC(int cd, long info)throws Exception{
		
		stmt=con.prepareStatement("UPDATE T_SPG_FORNECEDOR SET NR_CNPJ=? "
				+ "WHERE CD_FORNECEDOR=?");
		stmt.setLong(1, info);
		stmt.setInt(2, cd);
		int x=stmt.executeUpdate();
		
		stmt.close();
		
		return x+" cnpf atualizado.";
	}
	//fim dos métodos de Atualização
	
	public String deletar(int cd)throws Exception{
		
		stmt=con.prepareStatement("DELETE FROM T_SPG_FORNECEDOR WHERE CD_FORNECEDOR=?");
		stmt.setInt(1, cd);
		stmt.executeUpdate();
		
		return "Deletado com sucesso!";	
	}
	
}//fim da classe
