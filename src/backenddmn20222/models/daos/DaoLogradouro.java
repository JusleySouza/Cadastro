package backenddmn20222.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddmn20222.database.ConnectionDatabase;
import backenddmn20222.models.beans.Logradouro;
import backenddmn20222.models.beans.PessoaFisica;

public class DaoLogradouro {

	private final Connection c;

	public DaoLogradouro() throws SQLException, ClassNotFoundException {
		this.c = ConnectionDatabase.conectaBD();
	}

	public Logradouro inserir(Logradouro logradouro) throws SQLException {
		String sql = "insert into logradouro" + " (endereco, cep, numero, complemento)" + " values (?,?,?,?)";
		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, logradouro.getEndereco());
		stmt.setString(2, logradouro.getCep());
		stmt.setInt(3, logradouro.getNumero());
		stmt.setString(4, logradouro.getComplemento());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			logradouro.setId(id);
		}
		stmt.close();
		return logradouro;
	}

	public Logradouro buscar(Logradouro logradouro) throws SQLException {
		String sql = "select * from logradouro WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);
		stmt.setInt(1, logradouro.getId());
		ResultSet rs = stmt.executeQuery();
		Logradouro logradouroSaida = null;
		while (rs.next()) {
			logradouroSaida = new Logradouro(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getInt(4),
					rs.getString(5));
		}
		stmt.close();
		return logradouroSaida;
	}

	public Logradouro alterar(Logradouro logradouro) throws SQLException {
		String sql = "UPDATE logradouro SET endereco = ?, cep = ?, numero = ?, complemento = ? WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, logradouro.getEndereco());
		stmt.setString(2, logradouro.getCep());
		stmt.setInt(3, logradouro.getNumero());
		stmt.setString(4, logradouro.getComplemento());
		stmt.setInt(5, logradouro.getId());
		stmt.execute();
		stmt.close();
		return logradouro;
	}

	public Logradouro excluir(Logradouro logradouro) throws SQLException {
		String sql = "delete from logradouro WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, logradouro.getId());
		stmt.execute();
		stmt.close();
		c.close();
		return logradouro;
	}

	public List<Logradouro> listar(Logradouro logradouroEntrada) throws SQLException {
		List<Logradouro> logradouros = new ArrayList<>();
		String sql = "select * from logradouro where cep like ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, "%" + logradouroEntrada.getCep() + "%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Logradouro logradouro = new Logradouro(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getInt(4),
					rs.getString(5));
			logradouros.add(logradouro);
		}

		rs.close();
		stmt.close();
		return logradouros;
	}
}
