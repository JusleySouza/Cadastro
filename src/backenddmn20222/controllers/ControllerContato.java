package backenddmn20222.controllers;

import java.sql.SQLException;
import java.util.List;

import backenddmn20222.models.beans.Contato;
import backenddmn20222.models.beans.Logradouro;
import backenddmn20222.models.daos.DaoContato;

public class ControllerContato {
	DaoContato daoContato;

	public Contato inserir(Contato contato) throws ClassNotFoundException, SQLException {
		daoContato = new DaoContato();
		contato = daoContato.inserir(contato);
		return contato;
	}

	public Contato alterar(Contato contato) throws ClassNotFoundException, SQLException {
		daoContato = new DaoContato();
		contato = daoContato.alterar(contato);
		return contato;
	}

	public List<Contato> listar(Contato contato) throws ClassNotFoundException, SQLException {
		daoContato = new DaoContato();
		List<Contato> listaContato = daoContato.listar(contato);
		return listaContato;
	}

	public Contato excluir(Contato contato) throws ClassNotFoundException, SQLException {
		daoContato = new DaoContato();
		contato = daoContato.excluir(contato);
		return contato;
	}

	public Contato buscar(Contato contato) throws ClassNotFoundException, SQLException {
		daoContato = new DaoContato();
		contato = daoContato.buscar(contato);
		return contato;
	}
}
