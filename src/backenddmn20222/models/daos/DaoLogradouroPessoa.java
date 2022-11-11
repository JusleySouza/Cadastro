package backenddmn20222.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.database.ConnectionDatabase;
import backenddmn20222.models.beans.LogradouroPessoa;
import backenddmn20222.models.beans.UsuarioPessoa;

public class DaoLogradouroPessoa {
	
	 private final Connection c;
	    
	    public DaoLogradouroPessoa() throws SQLException, ClassNotFoundException{
	        this.c = ConnectionDatabase.conectaBD();
	    }


	    public LogradouroPessoa inserir(LogradouroPessoa logradouroPessoa) throws SQLException{
	        String sql = "insert into logradouro_pessoa " + " (id_logradouro, id_pessoa, observacao)" + " values (?,?,?)";
	    
	        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        stmt.setInt(1,logradouroPessoa.getIdLogradouro());
	        stmt.setInt(2,logradouroPessoa.getIdPessoa());
	        stmt.setString(3,logradouroPessoa.getObs());
	        stmt.executeUpdate();
	        ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            int id = rs.getInt(1);
	            logradouroPessoa.setId(id);
	        }
	        stmt.close();
	        return logradouroPessoa;
	    }

	    public LogradouroPessoa alterar(LogradouroPessoa logradouroPessoa) throws SQLException{
	        String sql = "UPDATE logradouro_pessoa SET id_logradouro = ?, id_pessoa = ?, observacao = ? WHERE id = ?";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setInt(1,logradouroPessoa.getIdLogradouro());
	        stmt.setInt(2,logradouroPessoa.getIdPessoa());
	        stmt.setString(3,logradouroPessoa.getObs());
	        stmt.setInt(4,logradouroPessoa.getId());
	        stmt.execute();
	        stmt.close();
	        return logradouroPessoa;
	    }

	    public LogradouroPessoa buscar(LogradouroPessoa logradouroPessoa) throws SQLException{
	        String sql = "select * from logradouro_pessoa WHERE id = ?";
	        PreparedStatement stmt = this.c.prepareStatement(sql);
	            stmt.setInt(1,logradouroPessoa.getId());
	            ResultSet rs = stmt.executeQuery();
	            LogradouroPessoa logradouroSaida = null;
	            while (rs.next()) {      
	                logradouroSaida = new LogradouroPessoa(
	                    rs.getInt(1),
	                    rs.getInt(2),
	                    rs.getInt(3),
	                    rs.getString(4));
	            }
	            stmt.close();
	        return logradouroSaida;
	   }

	    public List<LogradouroPessoa> listar(LogradouroPessoa logradouroPessoa) throws SQLException{

	        List<LogradouroPessoa> logradouroPessoas = new ArrayList<>();
	        
	        String sql = "select * from logradouro_pessoa where observacao like ?";
	        PreparedStatement stmt = this.c.prepareStatement(sql);
	        stmt.setString(1,"%" + logradouroPessoa.getObs()+ "%");
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {      
	        	LogradouroPessoa logpes = new LogradouroPessoa(
	                rs.getInt(1),
	                rs.getInt(2),
	                rs.getInt(3),
	                rs.getString(4));
	            logradouroPessoas.add(logpes);
	        }
	        
	        rs.close();
	        stmt.close();
	        return logradouroPessoas;
	   
	   }
	  
	    public LogradouroPessoa excluir(LogradouroPessoa logradouroPessoa) throws SQLException{
	        String sql = "delete from logradouro_pessoa WHERE id = ?";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setInt(1,logradouroPessoa.getId());
	        stmt.execute();
	        stmt.close();
	        c.close();
	        return logradouroPessoa;
	    }

}
