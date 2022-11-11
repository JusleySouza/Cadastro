package backenddmn20222.controllers;

import java.sql.SQLException;
import java.util.List;

import backenddmn20222.models.beans.Logradouro;
import backenddmn20222.models.daos.DaoLogradouro;

public class ControllerLogradouro {
	DaoLogradouro daoLog;

	public Logradouro inserir(Logradouro logradouro) throws ClassNotFoundException, SQLException {
		daoLog = new DaoLogradouro();
		logradouro = daoLog.inserir(logradouro);
		return logradouro;
	}

	public Logradouro alterar(Logradouro logradouro) throws ClassNotFoundException, SQLException {
		daoLog = new DaoLogradouro();
		logradouro = daoLog.alterar(logradouro);
		return logradouro;
	}

	public List<Logradouro> listar(Logradouro logradouro) throws ClassNotFoundException, SQLException {
		daoLog = new DaoLogradouro();
		List<Logradouro> listaLogradouro = daoLog.listar(logradouro);
		return listaLogradouro;
	}

	public Logradouro excluir(Logradouro logradouro) throws ClassNotFoundException, SQLException {
		daoLog = new DaoLogradouro();
		logradouro = daoLog.excluir(logradouro);
		return logradouro;
	}

	public Logradouro buscar(Logradouro logradouro) throws ClassNotFoundException, SQLException {
		daoLog = new DaoLogradouro();
		logradouro = daoLog.buscar(logradouro);
		return logradouro;
	}
}
