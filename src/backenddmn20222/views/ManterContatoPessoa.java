package backenddmn20222.views;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import backenddmn20222.controllers.ControllerContatoPessoa;
import backenddmn20222.controllers.ControllerLogradouroPessoa;
import backenddmn20222.controllers.ControllerUsuarioPessoa;
import backenddmn20222.models.beans.ContatoPessoa;
import backenddmn20222.models.beans.LogradouroPessoa;
import backenddmn20222.models.beans.UsuarioPessoa;

public class ManterContatoPessoa {

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
		int idContato = Integer.parseInt(JOptionPane.showInputDialog("Id Contato: "));
		int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa: "));
		String obs = JOptionPane.showInputDialog("Observação: ");
		ContatoPessoa contatoPessoaEntrada = new ContatoPessoa(idContato, idPessoa, obs);
		ControllerContatoPessoa controllerContatoPessoa = new ControllerContatoPessoa();
		ContatoPessoa contatoPessoaSaida = controllerContatoPessoa.inserir(contatoPessoaEntrada);
		JOptionPane.showMessageDialog(null, contatoPessoaSaida.toString());
	}

	public static void alterar() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		int idContato = Integer.parseInt(JOptionPane.showInputDialog("Id Contato: "));
		int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa: "));
		String obs = JOptionPane.showInputDialog("Observação: ");
		ContatoPessoa contatoPessoaEntrada = new ContatoPessoa(id, idContato, idPessoa, obs);
		ControllerContatoPessoa controllerContatoPessoa = new ControllerContatoPessoa();
		ContatoPessoa contatoPessoaSaida = controllerContatoPessoa.alterar(contatoPessoaEntrada);
		JOptionPane.showMessageDialog(null, contatoPessoaSaida.toString());
	}

	public static void buscar() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		ContatoPessoa contatoPessoaEntrada = new ContatoPessoa(id);
		ControllerContatoPessoa controllerContatoPessoa = new ControllerContatoPessoa();
		ContatoPessoa contatoPessoaSaida = controllerContatoPessoa.buscar(contatoPessoaEntrada);
		JOptionPane.showMessageDialog(null, contatoPessoaSaida.toString());
	}

	public static void listar() throws SQLException, ClassNotFoundException {
		String obs = JOptionPane.showInputDialog("Observação: ");
		ContatoPessoa contatoPessoaEntrada = new ContatoPessoa(obs);
		ControllerContatoPessoa controllerContatoPessoa = new ControllerContatoPessoa();
		List<ContatoPessoa> listaContatoPessoa = controllerContatoPessoa.listar(contatoPessoaEntrada);
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		for (ContatoPessoa contatoPessoa : listaContatoPessoa) {
			model.add(0, contatoPessoa.toString());
			model.add(1, contatoPessoa.getPessoa().toString());
			model.add(2, contatoPessoa.getContato().toString());
		}
		list.show();
		JOptionPane.showMessageDialog(null, list);
	}

	public static void excluir() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		ContatoPessoa contatoPessoaEntrada = new ContatoPessoa(id);
		ControllerContatoPessoa controllerContatoPessoa = new ControllerContatoPessoa();
		ContatoPessoa contatoPessoaSaida = controllerContatoPessoa.excluir(contatoPessoaEntrada);
		JOptionPane.showMessageDialog(null, "Usuário Deletado");
	}

}
