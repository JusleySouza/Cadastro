package backenddmn20222.views;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import backenddmn20222.controllers.ControllerUsuario;
import backenddmn20222.models.beans.Usuario;

public class ManterUsuario {
	
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
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        String status = JOptionPane.showInputDialog("Status: ");
        String tipo = JOptionPane.showInputDialog("Tipo: ");
        Usuario usuarioEntrada = new Usuario(login,senha,status, tipo);
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        Usuario usuarioSaida = controllerUsuario.inserir(usuarioEntrada);
        JOptionPane.showMessageDialog(null, usuarioSaida.toString());
    }
    
    public static void alterar() throws ClassNotFoundException, SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        String status = JOptionPane.showInputDialog("Status: ");
        String tipo = JOptionPane.showInputDialog("Tipo: ");
        Usuario usuarioEntrada = new Usuario(id,login,senha,status, tipo);
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        Usuario usuarioSaida = controllerUsuario.alterar(usuarioEntrada);
        JOptionPane.showMessageDialog(null, usuarioSaida.toString());
    }

    public static void buscar() throws ClassNotFoundException, SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
        Usuario usuarioEntrada = new Usuario(id);
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        Usuario usuarioSaida = controllerUsuario.buscar(usuarioEntrada);
        JOptionPane.showMessageDialog(null, usuarioSaida.toString());
        
    }
    
    public static void excluir() throws ClassNotFoundException, SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
        Usuario usuarioEntrada = new Usuario(id);
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        Usuario usuarioSaida = controllerUsuario.excluir(usuarioEntrada);
        JOptionPane.showMessageDialog(null, "Usuário Deletado");
    }
    
    public static void listar() throws ClassNotFoundException, SQLException {
        String login = JOptionPane.showInputDialog("Login: ");
        Usuario usuarioEntrada = new Usuario(login);
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        List<Usuario> listaUsuario = controllerUsuario.listar(usuarioEntrada);
        DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		for (int i = 0; i < listaUsuario.size(); i++) {
			model.add(i, listaUsuario.get(i));
		}
		list.show();
		JOptionPane.showMessageDialog(null, list);
       
    }

    public static boolean validar() throws ClassNotFoundException {
        boolean retorno = false;
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        Usuario usuarioEntrada = new Usuario(login,senha);
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        try {
			retorno = controllerUsuario.validar(usuarioEntrada);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return retorno;
    }

}
