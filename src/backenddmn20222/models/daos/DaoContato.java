package backenddmn20222.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.database.ConnectionDatabase;
import backenddmn20222.models.beans.Contato;

public class DaoContato {

	private final Connection c;

	public DaoContato() throws SQLException, ClassNotFoundException {
		this.c = ConnectionDatabase.conectaBD();
	}

	public Contato inserir(Contato contato) throws SQLException {
		String sql = "insert into contato" + " (telefone, email)" + " values (?,?)";
		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, contato.getTelefone());
		stmt.setString(2, contato.getEmail());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			contato.setId(id);
		}
		stmt.close();
		return contato;
	}

	public Contato buscar(Contato contato) throws SQLException {
		String sql = "select * from contato WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, contato.getId());
		ResultSet rs = stmt.executeQuery();
		Contato contatoSaida = null;
		while (rs.next()) {
			contatoSaida = new Contato(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		stmt.close();
		return contatoSaida;
	}

	public Contato alterar(Contato contato) throws SQLException {
		String sql = "UPDATE contato SET telefone = ?, email = ? WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, contato.getTelefone());
		stmt.setString(2, contato.getEmail());
		stmt.setInt(3, contato.getId());
		stmt.execute();
		stmt.close();
		return contato;
	}

	public Contato excluir(Contato contato) throws SQLException {
		String sql = "delete from contato WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, contato.getId());
		stmt.execute();
		stmt.close();
		c.close();
		return contato;
	}

	public List<Contato> listar(Contato contatoEntrada) throws SQLException {
		List<Contato> contatos = new ArrayList<>();
		String sql = "select * from contato where email like ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, "%" + contatoEntrada.getEmail() + "%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Contato contato = new Contato(rs.getInt(1), rs.getString(2), rs.getString(3));
			contatos.add(contato);
		}

		rs.close();
		stmt.close();
		return contatos;
	}
}
