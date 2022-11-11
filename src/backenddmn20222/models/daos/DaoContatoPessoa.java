package backenddmn20222.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.database.ConnectionDatabase;
import backenddmn20222.models.beans.ContatoPessoa;

public class DaoContatoPessoa {
	
	 private final Connection c;
	    
	    public DaoContatoPessoa() throws SQLException, ClassNotFoundException{
	        this.c = ConnectionDatabase.conectaBD();
	    }


	    public ContatoPessoa inserir(ContatoPessoa contatoPessoa) throws SQLException{
	        String sql = "insert into contato_pessoa " + " (id_contato, id_pessoa, observacao)" + " values (?,?,?)";
	    
	        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        stmt.setInt(1,contatoPessoa.getIdContato());
	        stmt.setInt(2,contatoPessoa.getIdPessoa());
	        stmt.setString(3,contatoPessoa.getObs());
	        stmt.executeUpdate();
	        ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            int id = rs.getInt(1);
	            contatoPessoa.setId(id);
	        }
	        stmt.close();
	        return contatoPessoa;
	    }

	    public ContatoPessoa alterar(ContatoPessoa contatoPessoa) throws SQLException{
	        String sql = "UPDATE contato_pessoa SET id_contato = ?, id_pessoa = ?, observacao = ? WHERE id = ?";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setInt(1,contatoPessoa.getIdContato());
	        stmt.setInt(2,contatoPessoa.getIdPessoa());
	        stmt.setString(3,contatoPessoa.getObs());
	        stmt.setInt(4,contatoPessoa.getId());
	        stmt.execute();
	        stmt.close();
	        return contatoPessoa;
	    }

	    public ContatoPessoa buscar(ContatoPessoa contatoPessoa) throws SQLException{
	        String sql = "select * from contato_pessoa WHERE id = ?";
	        PreparedStatement stmt = this.c.prepareStatement(sql);
	            stmt.setInt(1,contatoPessoa.getId());
	            ResultSet rs = stmt.executeQuery();
	            ContatoPessoa contatoSaida = null;
	            while (rs.next()) {      
	                contatoSaida = new ContatoPessoa(
	                    rs.getInt(1),
	                    rs.getInt(2),
	                    rs.getInt(3),
	                    rs.getString(4));
	            }
	            stmt.close();
	        return contatoSaida;
	   }

	    public List<ContatoPessoa> listar(ContatoPessoa contatoPessoa) throws SQLException{

	        List<ContatoPessoa> contatoPessoas = new ArrayList<>();
	        
	        String sql = "select * from contato_pessoa where observacao like ?";
	        PreparedStatement stmt = this.c.prepareStatement(sql);
	        stmt.setString(1,"%" + contatoPessoa.getObs()+ "%");
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {      
	        	ContatoPessoa conPessoa = new ContatoPessoa(
	                rs.getInt(1),
	                rs.getInt(2),
	                rs.getInt(3),
	                rs.getString(4));
	            contatoPessoas.add(conPessoa);
	        }
	        
	        rs.close();
	        stmt.close();
	        return contatoPessoas;
	   
	   }
	    
	    public ContatoPessoa excluir(ContatoPessoa contatoPessoa) throws SQLException{
	        String sql = "delete from contato_pessoa WHERE id = ?";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setInt(1,contatoPessoa.getId());
	        stmt.execute();
	        stmt.close();
	        c.close();
	        return contatoPessoa;
	    }

}
