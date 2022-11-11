package backenddmn20222.views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import backenddmn20222.controllers.ControllerUsuarioPessoa;
import backenddmn20222.models.beans.UsuarioPessoa;

public class ManterUsuarioPessoa {
	
	public static void menu() throws ClassNotFoundException, SQLException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
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
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Id Usuario: "));
        int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa: "));
        String obs = JOptionPane.showInputDialog("Observação: ");
        UsuarioPessoa usuarioPessoaEntrada = new UsuarioPessoa(idUsuario, idPessoa, obs);
        ControllerUsuarioPessoa controllerUsuarioPessoa = new ControllerUsuarioPessoa();
        UsuarioPessoa UsuarioPessoaSaida = controllerUsuarioPessoa.inserir(usuarioPessoaEntrada);
        JOptionPane.showMessageDialog(null, UsuarioPessoaSaida.toString());
    }
	
	public static void alterar() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		 int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Id Usuario: "));
	        int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa: "));
	        String obs = JOptionPane.showInputDialog("Observação: ");
	        UsuarioPessoa usuarioPessoaEntrada = new UsuarioPessoa(id, idUsuario, idPessoa, obs);
	        ControllerUsuarioPessoa controllerUsuarioPessoa = new ControllerUsuarioPessoa();
	        UsuarioPessoa usuarioPessoaSaida = controllerUsuarioPessoa.alterar(usuarioPessoaEntrada);
	        JOptionPane.showMessageDialog(null, usuarioPessoaSaida.toString());
	}
	
	public static void buscar() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
	    UsuarioPessoa usuarioPessoaEntrada = new UsuarioPessoa(id);
	    ControllerUsuarioPessoa controllerUsuarioPessoa = new ControllerUsuarioPessoa();
	    UsuarioPessoa usuarioPessoaSaida = controllerUsuarioPessoa.buscar(usuarioPessoaEntrada);
	    JOptionPane.showMessageDialog(null, usuarioPessoaSaida.toString());
	}
	
	public static void listar() throws SQLException, ClassNotFoundException  {
	       String obs = JOptionPane.showInputDialog("Observação: ");
	        UsuarioPessoa usuarioPessoaEntrada = new UsuarioPessoa(obs);
	        ControllerUsuarioPessoa controllerUsuarioPessoa = new ControllerUsuarioPessoa();
	        List<UsuarioPessoa> listaUsuarioPessoa = controllerUsuarioPessoa.listar(usuarioPessoaEntrada);
	        DefaultListModel model = new DefaultListModel();
			JList list = new JList(model);
			for(UsuarioPessoa usuarioPessoa: listaUsuarioPessoa) {
				model.add(0, usuarioPessoa.toString());
				model.add(1, usuarioPessoa.getPessoa().toString());
				model.add(2, usuarioPessoa.getUsuario().toString());
			}
			list.show();
			JOptionPane.showMessageDialog(null, list);
	}
	
	public static void excluir() throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		UsuarioPessoa usuarioPessoaEntrada = new UsuarioPessoa(id);
	    ControllerUsuarioPessoa controllerUsuarioPessoa = new ControllerUsuarioPessoa();
	    UsuarioPessoa usuarioPessoaSaida = controllerUsuarioPessoa.excluir(usuarioPessoaEntrada);
	    JOptionPane.showMessageDialog(null, "Usuário Deletado");
	}
	
}
