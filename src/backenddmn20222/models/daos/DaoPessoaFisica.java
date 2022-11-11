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
import backenddmn20222.models.beans.Usuario;

public class DaoPessoaFisica {

	private final Connection c;

	public DaoPessoaFisica() throws SQLException, ClassNotFoundException {
		this.c = ConnectionDatabase.conectaBD();
	}

	public PessoaFisica inserir(PessoaFisica pessoaEntrada){
		String sql = "insert into pessoa" + " (nome, rg, cpf)" + " values (?,?,?)";
		try {
			PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, pessoaEntrada.getNome());
			stmt.setString(2, pessoaEntrada.getRg());
			stmt.setString(3, pessoaEntrada.getCpf());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				pessoaEntrada.setId(id);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoaEntrada;
	}

	public PessoaFisica alterar(PessoaFisica pessoaEntrada) {
		String sql = "UPDATE pessoa SET nome = ?, rg = ?, cpf = ? WHERE id = ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, pessoaEntrada.getNome());
			stmt.setString(2, pessoaEntrada.getRg());
			stmt.setString(3, pessoaEntrada.getCpf());
			stmt.setInt(4, pessoaEntrada.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoaEntrada;
	}

	public PessoaFisica buscar(PessoaFisica pessoaEntrada){
		String sql = "select * from pessoa WHERE id = ?";
		PreparedStatement stmt;
		PessoaFisica pessoaSaida = null;
		try {
			stmt = this.c.prepareStatement(sql);
			stmt.setInt(1, pessoaEntrada.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pessoaSaida = new PessoaFisica(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoaSaida;
	}

	public List<PessoaFisica> listar(PessoaFisica pessoaEntrada) throws SQLException {
		List<PessoaFisica> pessoas = new ArrayList<>();
		String sql = "select * from pessoa where nome like ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, "%" + pessoaEntrada.getNome() + "%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			PessoaFisica pessoa = new PessoaFisica(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			pessoas.add(pessoa);
		}

		rs.close();
		stmt.close();
		return pessoas;
	}

	public PessoaFisica excluir(PessoaFisica pessoaEntrada) {
		String sql = "delete from pessoa WHERE id = ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, pessoaEntrada.getId());
			stmt.execute();
			stmt.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoaEntrada;
	}

}
