package backenddmn20222.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.database.ConnectionDatabase;
import backenddmn20222.models.beans.PessoaFisica;
import backenddmn20222.models.beans.UsuarioPessoa;

public class DaoUsuarioPessoa {
	
	 private final Connection c;
	    
	    public DaoUsuarioPessoa() throws SQLException, ClassNotFoundException{
	        this.c = ConnectionDatabase.conectaBD();
	    }


	    public UsuarioPessoa inserir(UsuarioPessoa usupesEnt) {
	        String sql = "insert into usuario_pessoa " + " (id_usuario, id_pessoa, observacao)" + " values (?,?,?)";
	    
	        try {
	        	PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1,usupesEnt.getIdUsuario());
                                stmt.setInt(2,usupesEnt.getIdPessoa());
				stmt.setString(3,usupesEnt.getObs());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					usupesEnt.setId(id);
				}
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usupesEnt;
	    }

	    public UsuarioPessoa alterar(UsuarioPessoa usupesEnt){
	        String sql = "UPDATE usuario_pessoa SET id_usuario = ?, id_pessoa = ?, observacao = ? WHERE id = ?";
	        try {
	        	PreparedStatement stmt = c.prepareStatement(sql);
                                stmt.setInt(1,usupesEnt.getIdUsuario());
				stmt.setInt(2,usupesEnt.getIdPessoa());
				stmt.setString(3,usupesEnt.getObs());
				stmt.setInt(4,usupesEnt.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usupesEnt;
	    }

	    public UsuarioPessoa buscar(UsuarioPessoa usupesEnt) {
	        String sql = "select * from usuario_pessoa WHERE id = ?";
	        UsuarioPessoa usupesSaida = null;
	            try {
	            	PreparedStatement stmt = this.c.prepareStatement(sql);
					stmt.setInt(1,usupesEnt.getId());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {      
						usupesSaida = new UsuarioPessoa(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4));
					}
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        return usupesSaida;
	   }

	    public List<UsuarioPessoa> listar(UsuarioPessoa usupesEnt) {

	        List<UsuarioPessoa> usupess = new ArrayList<>();
	        
	        String sql = "select * from usuario_pessoa where observacao like ?";
	        try {
	        	PreparedStatement stmt = this.c.prepareStatement(sql);
				stmt.setString(1,"%" + usupesEnt.getObs()+ "%");
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {      
					UsuarioPessoa usupes = new UsuarioPessoa(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getString(4));
					usupess.add(usupes);
				}
				
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	        return usupess;
	   
	   }
	   
	    public UsuarioPessoa excluir(UsuarioPessoa usupesEnt){
	        String sql = "delete from usuario_pessoa WHERE id = ?";
	        try {
	        	PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setInt(1,usupesEnt.getId());
				stmt.execute();
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return usupesEnt;
	    }


}
