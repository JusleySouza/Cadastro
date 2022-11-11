package backenddmn20222.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.models.beans.PessoaFisica;
import backenddmn20222.models.beans.Usuario;
import backenddmn20222.models.beans.UsuarioPessoa;
import backenddmn20222.models.daos.DaoUsuarioPessoa;


public class ControllerUsuarioPessoa {

	ControllerUsuario controllerUsuario;
	ControllerPessoaFisica controllerPessoa;
	DaoUsuarioPessoa dao;

	public UsuarioPessoa inserir(UsuarioPessoa UsuarioPessoa) throws ClassNotFoundException{
		try {
			dao = new DaoUsuarioPessoa();
			UsuarioPessoa = dao.inserir(UsuarioPessoa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UsuarioPessoa;
	}

	public UsuarioPessoa alterar(UsuarioPessoa UsuarioPessoa) throws ClassNotFoundException{
		try {
			dao = new DaoUsuarioPessoa();
			UsuarioPessoa = dao.alterar(UsuarioPessoa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UsuarioPessoa;
	}
	
	 public UsuarioPessoa buscar(UsuarioPessoa usupesEnt) throws ClassNotFoundException {

	        UsuarioPessoa usupesSaida = new UsuarioPessoa();
			try {
				dao = new DaoUsuarioPessoa();
				usupesSaida = dao.buscar(usupesEnt);
				Usuario usuEnt = new Usuario(usupesSaida.getIdUsuario());
				controllerUsuario = new ControllerUsuario();
				usupesSaida.setUsuario(controllerUsuario.buscar(usuEnt));
				
				PessoaFisica pes = new PessoaFisica(usupesSaida.getIdPessoa());
				controllerPessoa = new ControllerPessoaFisica();
				usupesSaida.setPessoa(controllerPessoa.buscar(pes));
			} catch (SQLException e) {
				e.printStackTrace();
			}


	        return usupesSaida;
	    }

	 public List<UsuarioPessoa> listar(UsuarioPessoa usupesEnt) throws ClassNotFoundException {
	        List<UsuarioPessoa> listaUsuPesAux;
	        List<UsuarioPessoa> listaUsuPesRetorno = new ArrayList<>();
			try {
				dao = new DaoUsuarioPessoa();
				listaUsuPesAux = dao.listar(usupesEnt);
				
				for(UsuarioPessoa usupes : listaUsuPesAux) {        
					listaUsuPesRetorno.add(buscar(usupes));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

	        return listaUsuPesRetorno;
	    }

	public UsuarioPessoa excluir(UsuarioPessoa UsuarioPessoa) throws ClassNotFoundException {
		try {
			dao = new DaoUsuarioPessoa();
			UsuarioPessoa = dao.excluir(UsuarioPessoa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UsuarioPessoa;
	}
	
}