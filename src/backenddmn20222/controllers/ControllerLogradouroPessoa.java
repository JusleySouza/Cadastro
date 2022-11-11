package backenddmn20222.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.models.beans.Logradouro;
import backenddmn20222.models.beans.LogradouroPessoa;
import backenddmn20222.models.beans.PessoaFisica;
import backenddmn20222.models.daos.DaoLogradouroPessoa;


public class ControllerLogradouroPessoa {

	ControllerLogradouro controllerLogradouro;
	ControllerPessoaFisica controllerPessoa;
	DaoLogradouroPessoa dao;

	public LogradouroPessoa inserir(LogradouroPessoa logradouroPessoa) throws ClassNotFoundException, SQLException {
		dao = new DaoLogradouroPessoa();
		logradouroPessoa = dao.inserir(logradouroPessoa);
		return logradouroPessoa;
	}

	public LogradouroPessoa alterar(LogradouroPessoa logradouroPessoa) throws ClassNotFoundException, SQLException {
		dao = new DaoLogradouroPessoa();
		logradouroPessoa = dao.alterar(logradouroPessoa);
		return logradouroPessoa;
	}
	
	 public LogradouroPessoa buscar(LogradouroPessoa logradouroPessoa) throws SQLException, ClassNotFoundException {

	        dao = new DaoLogradouroPessoa();
	        LogradouroPessoa logradouroPessoaSaida = dao.buscar(logradouroPessoa);

	        Logradouro logradouro = new Logradouro(logradouroPessoaSaida.getIdLogradouro());
	        controllerLogradouro = new ControllerLogradouro();
	        logradouroPessoaSaida.setLogradouro(controllerLogradouro.buscar(logradouro));
	        
	        PessoaFisica pes = new PessoaFisica(logradouroPessoaSaida.getIdPessoa());
	        controllerPessoa = new ControllerPessoaFisica();
	        logradouroPessoaSaida.setPessoa(controllerPessoa.buscar(pes));

	        return logradouroPessoaSaida;
	    }

	 public List<LogradouroPessoa> listar(LogradouroPessoa logradouroPessoa) throws SQLException, ClassNotFoundException {
	        dao = new DaoLogradouroPessoa();

	        List<LogradouroPessoa> listalogradouroPessoaAux = dao.listar(logradouroPessoa);

	        List<LogradouroPessoa> listalogradouroPessoa = new ArrayList<>();
	                
	        for(LogradouroPessoa logpes : listalogradouroPessoaAux) {        
	        	listalogradouroPessoa.add(buscar(logpes));
	        }

	        return listalogradouroPessoa;
	    }

	public LogradouroPessoa excluir(LogradouroPessoa logradouroPessoa) throws ClassNotFoundException, SQLException {
		dao = new DaoLogradouroPessoa();
		logradouroPessoa = dao.excluir(logradouroPessoa);
		return logradouroPessoa;
	}
	
}
