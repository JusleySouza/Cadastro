package backenddmn20222.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.models.beans.Usuario;
import backenddmn20222.models.daos.DaoUsuario;

public class ControllerUsuario {

	 DaoUsuario daoUsu;
	    
	    public boolean validar (Usuario usu) throws ClassNotFoundException, SQLException {
	        boolean retorno = false;
	        daoUsu = new DaoUsuario();
	        Usuario usuSaida = daoUsu.validar(usu);
	        System.out.println("Controller " + usuSaida.getLogin());
	        retorno = usuSaida.getLogin().equals(usu.getLogin());
	        return retorno;
	    }

	    public Usuario validaWeb (Usuario usuEntrada) throws ClassNotFoundException {
	        try {
				daoUsu = new DaoUsuario();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        usuEntrada = daoUsu.validar(usuEntrada);
	        return usuEntrada;
	    }

	    public Usuario inserir(Usuario usuEnt) throws ClassNotFoundException {
	        try {
				daoUsu = new DaoUsuario();
				usuEnt = daoUsu.inserir(usuEnt);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuEnt;
	    }

	    public Usuario alterar(Usuario usuEnt) throws ClassNotFoundException{
	        try {
				daoUsu = new DaoUsuario();
				usuEnt = daoUsu.alterar(usuEnt);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuEnt;
	    }

	    public List<Usuario> listar(Usuario usuEnt) throws ClassNotFoundException {
	    	List<Usuario> listaUsu = new ArrayList<Usuario>();
	        try {
				daoUsu = new DaoUsuario();
				listaUsu = daoUsu.listar(usuEnt);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return listaUsu;
	    }

	    public Usuario excluir(Usuario usuEnt) throws ClassNotFoundException{
	        try {
				daoUsu = new DaoUsuario();
				usuEnt = daoUsu.excluir(usuEnt);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuEnt;
	    }

	    public Usuario buscar(Usuario usuEnt) throws ClassNotFoundException{
	        try {
				daoUsu = new DaoUsuario();
				usuEnt = daoUsu.buscar(usuEnt);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuEnt;
	    }
	    
}
