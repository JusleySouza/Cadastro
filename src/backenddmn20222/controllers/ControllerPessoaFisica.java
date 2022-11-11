package backenddmn20222.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.models.beans.PessoaFisica;
import backenddmn20222.models.daos.DaoPessoaFisica;

public class ControllerPessoaFisica {
	DaoPessoaFisica dao;

	public PessoaFisica inserir(PessoaFisica pessoa) throws ClassNotFoundException{
		try {
			dao = new DaoPessoaFisica();
			pessoa = dao.inserir(pessoa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}

	public PessoaFisica alterar(PessoaFisica pessoa) throws ClassNotFoundException{
		try {
			dao = new DaoPessoaFisica();
			pessoa = dao.alterar(pessoa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}

	public PessoaFisica buscar(PessoaFisica pessoa) throws ClassNotFoundException{
		try {
			dao = new DaoPessoaFisica();
			pessoa = dao.buscar(pessoa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}

	public List<PessoaFisica> listar(PessoaFisica pessoa) throws ClassNotFoundException{
		List<PessoaFisica> listaPessoa = new ArrayList<PessoaFisica>();
		try {
			dao = new DaoPessoaFisica();
			listaPessoa = dao.listar(pessoa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPessoa;
	}
	
	public PessoaFisica excluir(PessoaFisica pessoa) throws ClassNotFoundException{
		try {
			dao = new DaoPessoaFisica();
			pessoa = dao.excluir(pessoa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}
	
}
