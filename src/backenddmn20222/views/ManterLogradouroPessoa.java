package backenddmn20222.views;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import backenddmn20222.controllers.ControllerLogradouroPessoa;
import backenddmn20222.models.beans.LogradouroPessoa;

public class ManterLogradouroPessoa {

	public static void menu() throws ClassNotFoundException, SQLException {
		String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar ";
		int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
		switch (num) {
		case 1:
			inserir();
			break;
		case 2:
			alterar();
			break;
		case 3:
			buscar();
			break;
		case 4:
			excluir();
			break;
		case 5:
			listar();
			break;
		default:
			System.out.println("Opcao inválida");
		}
	}

	public static void inserir() throws ClassNotFoundException, SQLException {
		int idLogradouro = Integer.parseInt(JOptionPane.showInputDialog("Id Logradouro: "));
		int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa: "));
		String obs = JOptionPane.showInputDialog("Observação: ");
		LogradouroPessoa logradouroPessoaEntrada = new LogradouroPessoa(idLogradouro, idPessoa, obs);
		ControllerLogradouroPessoa controllerLogradouroPessoa = new ControllerLogradouroPessoa();
		LogradouroPessoa logradouroPessoaSaida = controllerLogradouroPessoa.inserir(logradouroPessoaEntrada);
		JOptionPane.showMessageDialog(null, logradouroPessoaSaida.toString());
	}

	public static void alterar() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		int idLogradouro = Integer.parseInt(JOptionPane.showInputDialog("Id Logradouro: "));
		int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa: "));
		String obs = JOptionPane.showInputDialog("Observação: ");
		LogradouroPessoa logradouroPessoaEntrada = new LogradouroPessoa(id, idLogradouro, idPessoa, obs);
		ControllerLogradouroPessoa controllerLogradouroPessoa = new ControllerLogradouroPessoa();
		LogradouroPessoa logradouroPessoaSaida = controllerLogradouroPessoa.alterar(logradouroPessoaEntrada);
		JOptionPane.showMessageDialog(null, logradouroPessoaSaida.toString());
	}

	public static void buscar() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		LogradouroPessoa logradouroPessoaEntrada = new LogradouroPessoa(id);
		ControllerLogradouroPessoa controllerLogradouroPessoa = new ControllerLogradouroPessoa();
		LogradouroPessoa logradouroPessoaSaida = controllerLogradouroPessoa.buscar(logradouroPessoaEntrada);
		JOptionPane.showMessageDialog(null, logradouroPessoaSaida.toString());
	}

	public static void listar() throws SQLException, ClassNotFoundException {
		String obs = JOptionPane.showInputDialog("Observação: ");
		LogradouroPessoa logradouroPessoaEntrada = new LogradouroPessoa(obs);
		ControllerLogradouroPessoa controllerLogradouroPessoa = new ControllerLogradouroPessoa();
		List<LogradouroPessoa> listaLogradouroPessoa = controllerLogradouroPessoa.listar(logradouroPessoaEntrada);
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		for (LogradouroPessoa logradouroPessoa : listaLogradouroPessoa) {
			model.add(0, logradouroPessoa.toString());
			model.add(1, logradouroPessoa.getPessoa().toString());
			model.add(2, logradouroPessoa.getLogradouro().toString());
		}
		list.show();
		JOptionPane.showMessageDialog(null, list);
	}

	public static void excluir() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		LogradouroPessoa logradouroPessoaEntrada = new LogradouroPessoa(id);
		ControllerLogradouroPessoa controllerLogradouroPessoa = new ControllerLogradouroPessoa();
		LogradouroPessoa logradouroPessoaSaida = controllerLogradouroPessoa.excluir(logradouroPessoaEntrada);
		JOptionPane.showMessageDialog(null, "Usuário Deletado");
	}

}
