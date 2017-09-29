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
import br.com.fiap.entrada.Dados;
import br.com.fiap.excecao.Excecao;

public class Menu {

	public static void main(String[] args) {
		
		try {	 
		do {char op1 =JOptionPane.showInputDialog("DIGITE UMA OPÇÃO: \n"+""
				+ "P- PRODUTO\n"
				+ "C- CLIENTE\n"
				+ "V- VENDA\n"
				+ "R- RELATORIO DE PRODUTO MAIS VENDIDO\n").toUpperCase().charAt(0);
		
		
		//----------------------------------------------------------------------------------------------------
		
		
		// CLIENTE
		if (op1=='C') {
			
			ClienteDAO Dao =null;
			UsuarioDAO dao=null;
			
			do {char opcli =JOptionPane.showInputDialog("DIGITE A OPÇÃO PARA O CLIENTE: \n"+"C- CADASTRAR\n"
													+ "N- CONSULTAR\n"
													+ "E- EXCLUIR\n"
													+ "A- MUDAR EMAIL\n"
													+ "L- LISTAR\n").toUpperCase().charAt(0);
				if(opcli =='C') {
					
					ClienteBeans cli= new ClienteBeans(
														Dados.texto("Nome: "),
														Dados.texto("Email: "),
														Dados.texto("Senha: "),
														Dados.inteiro("CNPJ"),
														Dados.texto("Inscrição Estadual: "),
														Dados.texto("Razão Social: "),
														Dados.texto("URL: ")
														);
					
					System.out.println(ClienteBO.gravar(cli));
					
				}else if (opcli =='N') {
					
					Dao = new ClienteDAO();
					ClienteBeans cli= new ClienteBeans();
					cli=Dao.consultar(Dados.texto("Email:"));
					System.out.println("Nome do usuário: " +cli.getNmUsuario()+
									   "\nEMmail: "+cli.getDsemail()+
									   "\nSenha: "+cli.getSenha()+
									   "\nRazão Social: "+cli.getRzSocial()+
									   "\nCNPJ: "+cli.getCnpj()+
									   "\nURL: "+cli.getUrl()+
									   "\nIE: "+cli.getiE());
					
				}else if (opcli =='E') {
					
					Dao = new ClienteDAO(); 
					System.out.println(Dao.apagar(
											Dados.texto(
													"Digite o Email:")
											)
										);
					
				}else if (opcli =='A') {
					
					dao= new UsuarioDAO();
					System.out.println(dao.update(
											Dados.texto(
													"Digite o email Atual:"),
											Dados.texto(
													"Digite o Novo Email")
											)
										);
					
				}else if (opcli =='L') {
					
					Dao = new ClienteDAO();
					
					List<ClienteBeans> lista= Dao.listaCliente();
					for (ClienteBeans c: lista) {
						
						System.out.println("---------CLIENTE--------");
						System.out.println("Código do Usuário: "+c.getCdUsuario()+
										   "\nNome: "+c.getNmUsuario()+
										   "\nEmail: "+c.getDsemail()+
										   "\nSenha: "+c.getSenha()+
										   "\nCNPJ: "+c.getCnpj()+
										   "\nRazão Social: "+c.getRzSocial()+
										   "\nInscrição Estadual: "+c.getRzSocial()+
										   "\nURL: "+c.getUrl());
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
			
			ProdutoDAO dao=null;
			
			do {char opprod =JOptionPane.showInputDialog("DIGITE A OPÇÃO PARA O PRODUTO: \n"
													+"C- CADASTRAR\n"
													+"N- CONSULTAR\n"
													+"E- EXCLUIR\n"
													+"A- ALTERAR PRODUTO\n"
													+"L- LISTAR\n").toUpperCase().charAt(0);
				if(opprod =='C') {
					ProdutoBeans pb = new ProdutoBeans(
														Dados.texto("Nome: "),
														Dados.texto("URL"),
														Dados.decimal("Preço: "),
														Dados.texto("Descrição: "),
														Dados.texto("Disponibilidade: ")
														);
		
					System.out.println(ProdutoBO.novoProduto(pb));
					
				}else if (opprod =='N') {
					dao= new ProdutoDAO();
					ProdutoBeans pb = dao.pesquisaProduto(
							Dados.inteiro(
									"Codigo do produto pesquisado: "
									)
							);
					
					System.out.println(
									   "ID: " + pb.getIdProd()+
									   "Nome:" + pb.getNomeProd()+
									   "Descricao: " + pb.getDescProd()+
									   "Preço: " + pb.getPrecoProd()+
									   "Disponibilidade: " + pb.getDisp()
									   );
					
				}else if (opprod =='E') {
					
					System.out.println(ProdutoBO.deletaProduto(
							Dados.inteiro(
									"Código do produto a ser deletado: ")
										)
							);
					
				}else if (opprod =='A') {
					
					//Dar a opção para atualizar apenas o desejado.
					
					ProdutoBeans pb = new ProdutoBeans(
							Integer.parseInt(JOptionPane.showInputDialog("ID do produto a ser alterado: ")),
							JOptionPane.showInputDialog("Novo nome: "),
							JOptionPane.showInputDialog("Nova URL: "),
							Double.parseDouble(JOptionPane.showInputDialog("Novo preço: ")),
							JOptionPane.showInputDialog("Nova descricão: "),
							JOptionPane.showInputDialog("Nova disponibilidade: "));

					System.out.println(ProdutoBO.atualizaProduto(pb));
					
				}else if (opprod =='L') {
					
					dao = new ProdutoDAO();
					List<ProdutoBeans> lista = dao.listarProduto();
					
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
			
			NotaFiscalDAO dao=null;
			
			do {char opvend =JOptionPane.showInputDialog("DIGITE A OPÇÃO PARA A VENDA: \n"+"C- CADASTRAR\n"
													+ "N- CONSULTAR\n"
													+ "E- EXCLUIR\n"
													+ "A- ATUALIZAR VALOR DA VENDA \n"
													+ "L- LISTAR\n").toUpperCase().charAt(0);
				if(opvend =='C') {
					
					dao=new NotaFiscalDAO();
					int nf=dao.cadastrar("VENDA", new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
					
					
					
					VendaBeans vb=VendaBO.cadastro(nf, 
									Dados.texto("insira email: "),
									new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()),
									new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime())
									);	
					
					do {
						JOptionPane.showMessageDialog(null, ItemVendaBO.adicionar(
																				Dados.inteiro(
																						"Digite o código do produto (1 até 8): "), 
																				vb.getCd(),
																				Dados.inteiro(
																						"Insira Quantidade: ")
																				));
						
					} while (JOptionPane.showConfirmDialog(null,"Deseja Inserir mais um item?","VENDA",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
					
					VendaBO.attValor(vb.getCd(), nf);
					dao=new NotaFiscalDAO();
					dao.attValor(vb.getCd(), nf);
					
				}else if (opvend =='N') {
					
					List<ItemVendaBeans> lista=ItemVendaBO.consultar
													(Dados.inteiro
															("Insira o código da venda:")
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
												Dados.inteiro(
														"Insira o código da venda: "),
												Dados.decimal(
														"Insira o a porcentagem de aumento (apenas números): ")
												)
										);
						
					}else if(att=='D') {
						
						JOptionPane.showMessageDialog(null,
										VendaBO.desconto(
												Dados.inteiro(
														"Insira o código da venda: "),
												Dados.decimal(
														"Insira o a porcentagem de desconto (apenas números): ")
												)
										);
						
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
				
			}while (JOptionPane.showConfirmDialog(
						null,"CONTINUAR NA VENDA?","VENDA",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
		
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
				
			}while (JOptionPane.showConfirmDialog(
					null,"CONTINUAR NOS RELATORIOS?","RELATORIO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
				
		}
		
		}while (JOptionPane.showConfirmDialog(
				null,"CONTINUAR NO SISTEMA?","Projeto NAC",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
				
         } catch (Exception e) {
	        Excecao.getException(e);
          }
		
		
		
	}
}
