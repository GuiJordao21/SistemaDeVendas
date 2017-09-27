package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.BO.ClienteBO;
import br.com.fiap.BO.ItemVendaBO;
import br.com.fiap.BO.ProdutoBO;
import br.com.fiap.BO.VendaBO;
import br.com.fiap.DAO.ClienteDAO;
import br.com.fiap.DAO.NotaFiscalDAO;
import br.com.fiap.DAO.ProdutoDAO;
import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.beans.ClienteBeans;
import br.com.fiap.beans.ItemVendaBeans;
import br.com.fiap.beans.ProdutoBeans;
import br.com.fiap.beans.VendaBeans;
import br.com.fiap.excecao.Excecao;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteDAO Dao =null;
		UsuarioDAO dao=null;
		ProdutoDAO dao1=null;
		
try {	 
		do {char op1 =JOptionPane.showInputDialog("DIGITE UMA OPÇÃO: \n"+""
				+ "P- PRODUTO\n"
				+ "C- CLIENTE\n"
				+ "V- VENDA\n"
				+ "R- RELATORIO DE PRODUTO MAIS VENDIDO\n").toUpperCase().charAt(0);
		
		
		//----------------------------------------------------------------------------------------------------
		
		
		// CLIENTE
		if (op1=='C') {
			do {char opcli =JOptionPane.showInputDialog("DIGITE A OPÇÃO PARA O CLIENTE: \n"+"C- CADASTRAR\n"
													+ "N- CONSULTAR\n"
													+ "E- EXCLUIR\n"
													+ "A- MUDAR EMAIL\n"
													+ "L- LISTAR\n").toUpperCase().charAt(0);
				if(opcli =='C') {
					ClienteBeans cli= new ClienteBeans();
					cli.setNmUsuario(JOptionPane.showInputDialog("NOME:"));
					cli.setDsemail(JOptionPane.showInputDialog("EMAIL:"));
					cli.setSenha(JOptionPane.showInputDialog("Senha"));
					cli.setCnpj(Integer.parseInt(JOptionPane.showInputDialog("Cnpj: ")));
					cli.setiE(JOptionPane.showInputDialog("Incrição estadual: "));
					cli.setRzSocial(JOptionPane.showInputDialog("Razao Social: "));
					cli.setUrl(JOptionPane.showInputDialog("url: "));
					System.out.println(ClienteBO.gravar(cli));
				}else if (opcli =='N') {
					Dao = new ClienteDAO();
					ClienteBeans cli= new ClienteBeans();
					dao=new UsuarioDAO();
					cli=Dao.consultar(JOptionPane.showInputDialog("Email:"));
					System.out.println("NOME USUARIO: " +cli.getNmUsuario());
					System.out.println("EMAIL: "+cli.getDsemail());
					System.out.println("SENHA: "+cli.getSenha());
					System.out.println("RAZAO SOCIAL: "+cli.getRzSocial());
					System.out.println("CNPJ: "+cli.getCnpj());
					System.out.println("URL: "+cli.getUrl());
					System.out.println("IE: "+cli.getiE());
				}else if (opcli =='E') {
					Dao = new ClienteDAO();
					String x = Dao.apagar(JOptionPane.showInputDialog("Digite o Email:"));
					System.out.println(x);
				}else if (opcli =='A') {
					dao= new UsuarioDAO();
					String alt = dao.update(JOptionPane.showInputDialog("Digite o email Atual:"),JOptionPane.showInputDialog("Digite o Novo Email"));
					System.out.println(alt);
				}else if (opcli =='L') {
					Dao = new ClienteDAO();
					dao=new UsuarioDAO();
					List<ClienteBeans> lista= Dao.listaCliente();
					for (ClienteBeans c: lista) {
						System.out.println("---------CLIENTE--------");
						System.out.println("CD_USUARIO: "+c.getCdUsuario());
						System.out.println("NOME: "+c.getNmUsuario());
						System.out.println("EMAIL: "+c.getDsemail());
						System.out.println("SENHA: "+c.getSenha());
						System.out.println("CNPJ: "+c.getCnpj());
						System.out.println("RAZAO SOCIAL: "+c.getRzSocial());
						System.out.println("INSCRÇÃO ESTADUAL: "+c.getRzSocial());
						System.out.println("URL: "+c.getUrl());
						System.out.println("");
					}
				}else {
				System.out.println("Opção invalida");
				}
			}while (JOptionPane.showConfirmDialog(null,"CONTINUAR NO CLIENTE?","CLIENTE",JOptionPane.YES_NO_OPTION)==0);
		}
		
		
	//----------------------------------------------------------------------------------------------------------------------	
		
		
		
		
		
		
		//PRODUTO
		if (op1=='P') {
			do {char opprod =JOptionPane.showInputDialog("DIGITE A OPÇÃO PARA O PRODUTO: \n"+"C- CADASTRAR\n"
													+ "N- CONSULTAR\n"
													+ "E- EXCLUIR\n"
													+ "A- ALTERAR PRODUTO\n"
													+ "L- LISTAR\n").toUpperCase().charAt(0);
				if(opprod =='C') {
					ProdutoBeans pb = new ProdutoBeans();
					pb.setNomeProd(
							JOptionPane.showInputDialog("Nome:"));
					pb.setUrlImg(
							JOptionPane.showInputDialog("URL: "));
					pb.setPrecoProd(
							Double.parseDouble(
									JOptionPane.showInputDialog("Preço: ")));
					pb.setDescProd(
							JOptionPane.showInputDialog("Descricao: "));
					pb.setDisp(
							JOptionPane.showInputDialog("Disponibilidade: "));
					System.out.println(ProdutoBO.novoProduto(pb));
				}else if (opprod =='N') {
					dao1= new ProdutoDAO();
					ProdutoBeans pb = dao1.pesquisaProduto(
							Integer.parseInt(
									JOptionPane.showInputDialog("Codigo do produto pesquisado: ")));
					
					System.out.println("ID: " + pb.getIdProd());
					System.out.println("Nome:" + pb.getNomeProd());
					System.out.println("Descricao: " + pb.getDescProd());
					System.out.println("URL: " + pb.getUrlImg());
					System.out.println("Preço: " + pb.getPrecoProd());
					System.out.println("Disponibilidade: " + pb.getDisp());
				}else if (opprod =='E') {
					int n = Integer.parseInt(
							JOptionPane.showInputDialog("Codigo do produto a deletar: "));
					
					System.out.println(ProdutoBO.deletaProduto(n));	
				}else if (opprod =='A') {
					ProdutoBeans pb = new ProdutoBeans(
							Integer.parseInt(JOptionPane.showInputDialog("ID do produto a ser alterado: ")),
							JOptionPane.showInputDialog("Novo nome: "),
							JOptionPane.showInputDialog("Nova URL: "),
							Double.parseDouble(JOptionPane.showInputDialog("Novo preço: ")),
							JOptionPane.showInputDialog("Nova descricão: "),
							JOptionPane.showInputDialog("Nova disponibilidade: "));

					System.out.println(ProdutoBO.atualizaProduto(pb));
				}else if (opprod =='L') {
					dao1 = new ProdutoDAO();
					List<ProdutoBeans> lista = dao1.listarProduto();
					for(ProdutoBeans p : lista) {
						System.out.println("---------------------------------------------------");
						System.out.println("ID: " + p.getIdProd());
						System.out.println("Nome : " + p.getNomeProd());
						System.out.println("Preço: " + p.getPrecoProd());
						System.out.println("Descrição: " + p.getDescProd());
						System.out.println("Disponibilidade: " + p.getDisp());
						System.out.println("UrlImg: " + p.getUrlImg());
						System.out.println("---------------------------------------------------");
					}
				}else {
				System.out.println("Opção invalida");
				}
			}while (JOptionPane.showConfirmDialog(null,"CONTNUAR NO PRODUTO?","PRODUTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
		}
		
		
	//-----------------------------------------------------------------------------------------------------------------------------	
		
		
		
		
		
		
		
		//VENDA
		if (op1=='V') {
			do {char opvend =JOptionPane.showInputDialog("DIGITE A OPÇÃO PARA A VENDA: \n"+"C- CADASTRAR\n"
													+ "N- CONSULTAR\n"
													+ "E- EXCLUIR\n"
													+ "A- ATUALIZAR VALOR DA VENDA \n"
													+ "L- LISTAR\n").toUpperCase().charAt(0);
				if(opvend =='C') {
					
					NotaFiscalDAO dao11=new NotaFiscalDAO();
					int nf=dao11.cadastrar("VENDA", new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
					
					
					
					VendaBeans vb=VendaBO.cadastro(nf, 
									JOptionPane.showInputDialog("insira email: "),
									new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()),
									new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime())
									);	
					
					do {
						JOptionPane.showMessageDialog(null, ItemVendaBO.adicionar(
																				Integer.parseInt(
																						JOptionPane.showInputDialog(
																								"Digite o código do produto (1 até 8): ")), 
																				vb.getCd(),
																				Integer.parseInt(JOptionPane.showInputDialog("Insira Quantidade: "))
																				)
													);
					} while (JOptionPane.showConfirmDialog(null,"Deseja Inserir mais um item?","VENDA",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
					
					VendaBO.attValor(vb.getCd(), nf);
					NotaFiscalDAO dao111=new NotaFiscalDAO();
					dao111.attValor(vb.getCd(), nf);
					
				}else if (opvend =='N') {
					
					List<ItemVendaBeans> lista=ItemVendaBO.consultar
													(Integer.parseInt
															(JOptionPane.showInputDialog
																	("Insira o código da venda:"))
													);
					for (ItemVendaBeans i : lista) {
						System.out.println("------------------------");
						System.out.println("Código do Item: "+i.getCd_item());
						System.out.println("Preço do item"+i.getPreco());
						System.out.println("Preço total:"+i.getPrecoTot());
						System.out.println("Quantidade: "+i.getQtd());
					}
					
				}else if (opvend =='E') {
					
					int cd=Integer.parseInt(JOptionPane.showInputDialog("Insira o código da venda a ser deletada: "));
					
					ItemVendaBO.deletarVenda(cd);
					JOptionPane.showMessageDialog(null, VendaBO.deletar(cd));
					
				}else if (opvend =='A') {
					
					char att=JOptionPane.showInputDialog("AUMENTO <A> \n DESCONTO <D>").toUpperCase().charAt(0);
					if (att=='A') {
						JOptionPane.showMessageDialog(null,
										VendaBO.aumento(
												Integer.parseInt(
														JOptionPane.showInputDialog(
																"Insira o código da venda: ")),
												Double.parseDouble(
														JOptionPane.showInputDialog(
																"Insira o a porcentagem de aumento (apenas números): "))));
					}else if(att=='D') {
						
						JOptionPane.showMessageDialog(null,
										VendaBO.desconto(
												Integer.parseInt(
														JOptionPane.showInputDialog(
																"Insira o código da venda: ")),
												Double.parseDouble(
														JOptionPane.showInputDialog(
																"Insira o a porcentagem de desconto (apenas números): "))));
						
					}
				}else if (opvend =='L') {
					
					List<VendaBeans> lista=VendaBO.consultar();
					
					for (VendaBeans vb : lista) {
						
						System.out.println("-----------------------");
						System.out.println("CÓDIGO: "+vb.getCd());
						System.out.println("VALOR: "+vb.getValor());
						System.out.println("DATA: "+vb.getData());
						System.out.println("HORA: "+vb.getHora());
						
					}
					
				}else {
				System.out.println("Opção invalida");
				}
			}while (JOptionPane.showConfirmDialog(null,"CONTINUAR NA VENDA?","VENDA",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
		}
		
		
		//RELATORIO
		if (op1=='R') {
			do {
				
				List<ItemVendaBeans> lista=ItemVendaBO.maiorItemVenda();
				
				Collections.sort(lista);
				for (ItemVendaBeans i : lista) {
				
					System.out.println("-------------------------");
					System.out.println("PRODUTO "+i.getCd_item());
					System.out.println("VALOR VENDIDO: "+i.getPrecoTot());
					
					
				}
				
			}while (JOptionPane.showConfirmDialog(null,"CONTINUAR NOS RELATORIOS?","RELATORIO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
				
		}
		
		}while (JOptionPane.showConfirmDialog(null,"CONTINUAR NO SISTEMA?","Projeto NAC",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
				
         } catch (Exception e) {
	        Excecao.getException(e);
          }
		
		
		
	}
}
