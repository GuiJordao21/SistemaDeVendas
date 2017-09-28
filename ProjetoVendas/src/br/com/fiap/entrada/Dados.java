package br.com.fiap.entrada;

import javax.swing.JOptionPane;

public class Dados {

	public static String texto(String msg){
		return JOptionPane.showInputDialog(msg);
	}
	
	public static int inteiro(String msg) {
		return Integer.parseInt(texto(msg));
	}
	
	public static double decimal(String msg){
		return Double.parseDouble(texto(msg));
	}
	
	public static long longo(String msg){
		return Long.parseLong(texto(msg));
	}
	
}
