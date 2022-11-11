package backenddmn20222.views;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import backenddmn20222.controllers.ControllerPessoaFisica;
import backenddmn20222.models.beans.PessoaFisica;
import backenddmn20222.models.beans.UsuarioPessoa;

public class ManterPessoaFisica {

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
		String nome = JOptionPane.showInputDialog("Nome: ");
		String cpf = JOptionPane.showInputDialog("Cpf: ");
		String rg = JOptionPane.showInputDialog("Rg: ");
		PessoaFisica pessoaEntrada = new PessoaFisica(nome, cpf, rg);
		ControllerPessoaFisica controllerPessoa = new ControllerPessoaFisica();
		PessoaFisica pessoaSaida = controllerPessoa.inserir(pessoaEntrada);
		JOptionPane.showMessageDialog(null, pessoaSaida.toString());
	}

	public static void alterar() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		String nome = JOptionPane.showInputDialog("Nome: ");
		String cpf = JOptionPane.showInputDialog("Cpf: ");
		String rg = JOptionPane.showInputDialog("Rg: ");
		PessoaFisica pessoaEntrada = new PessoaFisica(id, nome, cpf, rg);
		ControllerPessoaFisica controllerPessoa = new ControllerPessoaFisica();
		PessoaFisica pessoaSaida = controllerPessoa.alterar(pessoaEntrada);
		JOptionPane.showMessageDialog(null, pessoaSaida.toString());
	}

	public static void buscar() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		PessoaFisica pessoaEntrada = new PessoaFisica(id);
		ControllerPessoaFisica controllerPessoa = new ControllerPessoaFisica();
		PessoaFisica pessoaSaida = controllerPessoa.buscar(pessoaEntrada);
		JOptionPane.showMessageDialog(null, pessoaSaida.toString());
	}

	public static void listar() throws ClassNotFoundException, SQLException {
		String nome = JOptionPane.showInputDialog("Nome: ");
		PessoaFisica pessoaFisica = new PessoaFisica(nome);
		ControllerPessoaFisica controllerPessoa = new ControllerPessoaFisica();
		List<PessoaFisica> listaPessoa = controllerPessoa.listar(pessoaFisica);
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		for (int i = 0; i < listaPessoa.size(); i++) {
			model.add(i, listaPessoa.get(i));
		}
		list.show();
		JOptionPane.showMessageDialog(null, list);
	}

	public static void excluir() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		PessoaFisica pessoaEntrada = new PessoaFisica(id);
		ControllerPessoaFisica controllerPessoa = new ControllerPessoaFisica();
		PessoaFisica pessoaSaida = controllerPessoa.excluir(pessoaEntrada);
		JOptionPane.showMessageDialog(null, "Usuário Deletado");
	}

}
