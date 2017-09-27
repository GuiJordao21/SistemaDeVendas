package br.com.fiap.excecao;

import javax.swing.JOptionPane;

public class Excecao extends Exception{		
	
	private static final long serialVersionUID = 1L;

	public Excecao() {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
	}
	
	public static String getException(Exception e) {
		if(e.getClass().getName().equals("java.lang.NumberFormatException")) {
			return "Numero Inváido!";
		}else if(e.getClass().getName().equals("java.lang.NullPointerEception")) {
			return "Ocorreu um erro inesperado	";
		}else if(e.getClass().getName().equals("java.lang.RuntimeException")) {
			return "Tempo de eceussão excedido!"; 
		}else {
			return "Ocorreu um erro desconhecido!";
		}
	}
}

