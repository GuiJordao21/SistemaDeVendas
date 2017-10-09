package br.com.fiap.BO;

import br.com.fiap.beans.DepartamentoBeans;
import br.com.fiap.DAO.DepartamentoDAO;

public class DepartamentoBO {
	DepartamentoDAO dao = null;
	public String cadastraDepartamento(DepartamentoBeans d, String usuario, String senha) throws Exception{
		if(d.getDescricao()==null || d.getDescricao().length()<2) {
			return "Departamento inválido";
		}
		if(d.getQtdFuncionarios()<0) {
			return "Departamento invalido!";
		}
		dao = new DepartamentoDAO(usuario, senha);
		dao.cadastraDepartamento(d);
		dao.fechar();
		return"";
	}
	
	public String atualizaDepartamento(DepartamentoBeans d, String usuario, String senha) throws Exception{
		if(d.getDescricao()==null || d.getDescricao().length()<2) {
			return "Departamento inválido";
		}
		if(d.getQtdFuncionarios()<0) {
			return "Departamento invalido!";
		}
		dao = new DepartamentoDAO(usuario, senha);
		dao.atualizaDepartamento(d);
		dao.fechar();
		return"";
	}
}
