package backenddmn20222.views;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import backenddmn20222.controllers.ControllerContato;
import backenddmn20222.models.beans.Contato;

public class ManterContato {

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
	        String telefone = JOptionPane.showInputDialog("Telefone: ");
	        String email = JOptionPane.showInputDialog("Email: ");
	        Contato contatoEntrada = new Contato(telefone, email);
	        ControllerContato controllerContato = new ControllerContato();
	        Contato contatoSaida = controllerContato.inserir(contatoEntrada);
	        JOptionPane.showMessageDialog(null, contatoSaida.toString());
	    }
	    
	    public static void alterar() throws ClassNotFoundException, SQLException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
	        String telefone  = JOptionPane.showInputDialog("Telefone: ");
	        String email = JOptionPane.showInputDialog("Email: ");
	        Contato contatoEntrada = new Contato(id, telefone, email);
	        ControllerContato controllerContato = new ControllerContato();
	        Contato contatoSaida = controllerContato.alterar(contatoEntrada);
	        JOptionPane.showMessageDialog(null, contatoSaida.toString());
	    }

	    public static void buscar() throws ClassNotFoundException, SQLException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
	        Contato contatoEntrada = new Contato(id);
	        ControllerContato controllerContato = new ControllerContato();
	        Contato contatoSaida = controllerContato.buscar(contatoEntrada);
	        JOptionPane.showMessageDialog(null, contatoSaida.toString());
	        
	    }
	    
	    public static void excluir() throws ClassNotFoundException, SQLException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
	        Contato contatoEntrada = new Contato(id);
	        ControllerContato controllerContato = new ControllerContato();
	        Contato contatoSaida = controllerContato.excluir(contatoEntrada);
	        JOptionPane.showMessageDialog(null, "Usuário Deletado");
	    }
	    
	    public static void listar() throws ClassNotFoundException, SQLException {
	        String email = JOptionPane.showInputDialog("Email: ");
	        Contato contatoEntrada = new Contato(email);
	        ControllerContato controllerContato = new ControllerContato();
	        List<Contato> listaContato = controllerContato.listar(contatoEntrada);
	        DefaultListModel model = new DefaultListModel();
			JList list = new JList(model);
			for (int i = 0; i < listaContato.size(); i++) {
				model.add(i, listaContato.get(i));
			}
			list.show();
			JOptionPane.showMessageDialog(null, list);
	        
	    }
	
}
