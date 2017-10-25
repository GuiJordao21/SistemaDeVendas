package br.com.fiap.BO;

import br.com.fiap.beans.DepartamentoBeans;

import java.sql.Connection;

import br.com.fiap.DAO.DepartamentoDAO;

public class DepartamentoBO {
	DepartamentoDAO dao = null;
	public String cadastraDepartamento(DepartamentoBeans d, Connection con) throws Exception{
		if(d.getDescricao()==null || d.getDescricao().length()<2) {
			return "Departamento inválido";
		}
		if(d.getQtdFuncionarios()<0) {
			return "Departamento invalido!";
		}
		dao = new DepartamentoDAO();
		dao.cadastraDepartamento(d, con);
		return"";
	}
	
	public String atualizaDepartamento(DepartamentoBeans d, Connection con) throws Exception{
		if(d.getDescricao()==null || d.getDescricao().length()<2) {
			return "Departamento inválido";
		}
		if(d.getQtdFuncionarios()<0) {
			return "Departamento invalido!";
		}
		dao = new DepartamentoDAO();
		dao.atualizaDepartamento(d, con);
		return"";
	}
}
