package backenddmn20222.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.models.beans.Contato;
import backenddmn20222.models.beans.ContatoPessoa;
import backenddmn20222.models.beans.PessoaFisica;
import backenddmn20222.models.daos.DaoContatoPessoa;


public class ControllerContatoPessoa {

	ControllerContato controllerContato;
	ControllerPessoaFisica controllerPessoa;
	DaoContatoPessoa dao;

	public ContatoPessoa inserir(ContatoPessoa contatoPessoa) throws ClassNotFoundException, SQLException {
		dao = new DaoContatoPessoa();
		contatoPessoa = dao.inserir(contatoPessoa);
		return contatoPessoa;
	}

	public ContatoPessoa alterar(ContatoPessoa contatoPessoa) throws ClassNotFoundException, SQLException {
		dao = new DaoContatoPessoa();
		contatoPessoa = dao.alterar(contatoPessoa);
		return contatoPessoa;
	}
	
	 public ContatoPessoa buscar(ContatoPessoa contatoPessoa) throws SQLException, ClassNotFoundException {

	        dao = new DaoContatoPessoa();
	        ContatoPessoa contatoPessoaSaida = dao.buscar(contatoPessoa);

	        Contato contato = new Contato(contatoPessoaSaida.getIdContato());
	        controllerContato = new ControllerContato();
	        contatoPessoaSaida.setContato(controllerContato.buscar(contato));
	        
	        PessoaFisica pes = new PessoaFisica(contatoPessoaSaida.getIdPessoa());
	        controllerPessoa = new ControllerPessoaFisica();
	        contatoPessoaSaida.setPessoa(controllerPessoa.buscar(pes));

	        return contatoPessoaSaida;
	    }

	 public List<ContatoPessoa> listar(ContatoPessoa contatoPessoa) throws SQLException, ClassNotFoundException {
	        dao = new DaoContatoPessoa();

	        List<ContatoPessoa> listaContatoPessoaAux = dao.listar(contatoPessoa);

	        List<ContatoPessoa> listaContatoPessoa = new ArrayList<>();
	                
	        for(ContatoPessoa contatoPes : listaContatoPessoaAux) {        
	        	listaContatoPessoa.add(buscar(contatoPes));
	        }

	        return listaContatoPessoa;
	    }

	public ContatoPessoa excluir(ContatoPessoa contatoPessoa) throws ClassNotFoundException, SQLException {
		dao = new DaoContatoPessoa();
		contatoPessoa = dao.excluir(contatoPessoa);
		return contatoPessoa;
	}
	
}
