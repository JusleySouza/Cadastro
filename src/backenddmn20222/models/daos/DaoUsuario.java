package backenddmn20222.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.database.ConnectionDatabase;
import backenddmn20222.models.beans.Usuario;

public class DaoUsuario {
	
	 private final Connection c;
	    
	    public DaoUsuario() throws SQLException, ClassNotFoundException{
	        this.c = ConnectionDatabase.conectaBD();
	    }
	
	    public Usuario validar(Usuario usuEnt)  {
	        String sql = "select * from usuario WHERE login = ? AND senha = ?";
	        PreparedStatement stmt;
	        Usuario usuSaida = null;
	        try {
				stmt = this.c.prepareStatement(sql);
				stmt.setString(1,usuEnt.getLogin());
				stmt.setString(2,usuEnt.getSenha());
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {      
					usuSaida = new Usuario(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5));
				}
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuSaida; 
	    }

	    public Usuario inserir(Usuario usuEnt){
	        String sql = "insert into usuario" + " (login, senha, status_usuario, tipo)" + " values (?,?,?,?)";
	        try {
	        	PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        	stmt.setString(1,usuEnt.getLogin());
	        	stmt.setString(2,usuEnt.getSenha());
	        	stmt.setString(3,usuEnt.getStatus());
				stmt.setString(4,usuEnt.getTipo());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					usuEnt.setId(id);
				}
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuEnt;
	    }

	    public Usuario alterar(Usuario usuEnt){
	        String sql = "UPDATE usuario SET login = ?, senha = ?, status_usuario = ?, tipo = ? WHERE id = ?";
	        try {
	        	PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setString(1,usuEnt.getLogin());
				stmt.setString(2,usuEnt.getSenha());
				stmt.setString(3,usuEnt.getStatus());
				stmt.setString(4,usuEnt.getTipo());
				stmt.setInt(5,usuEnt.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuEnt;
	    }

	    public List<Usuario> listar(Usuario usuEnt){
	        List<Usuario> usus = new ArrayList<>();
	        String sql = "select * from usuario where login like ?";
	        try {
	        	PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setString(1,"%" + usuEnt.getLogin() + "%");
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {      
					Usuario usu = new Usuario(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5)
							);
					usus.add(usu);
				}
				
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usus;
	   
	   }

	    public Usuario excluir(Usuario usuEnt){
	        String sql = "delete from usuario WHERE id = ?";
	        PreparedStatement stmt;
			try {
				stmt = c.prepareStatement(sql);
				stmt.setInt(1,usuEnt.getId());
				stmt.execute();
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuEnt;
	    }

	    public Usuario buscar(Usuario usuEnt){
	        String sql = "select * from usuario WHERE id = ?";
	        PreparedStatement stmt;
	        Usuario usuSaida = null;
			try {
				stmt = this.c.prepareStatement(sql);
				stmt.setInt(1,usuEnt.getId());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {      
					usuSaida = new Usuario(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5));
				}
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usuSaida;
	   }
}
