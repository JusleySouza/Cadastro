package backenddmn20222.views;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import backenddmn20222.controllers.ControllerLogradouro;
import backenddmn20222.models.beans.Logradouro;

public class ManterLogradouro {

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
	        String endereco = JOptionPane.showInputDialog("Endereço: ");
	        int numero = Integer.parseInt(JOptionPane.showInputDialog("Numero: "));
	        String cep = JOptionPane.showInputDialog("Cep: ");
	        String complemento = JOptionPane.showInputDialog("Complemento: ");
	        Logradouro logradouroEntrada = new Logradouro(endereco,cep,numero, complemento);
	        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
	        Logradouro logradouroSaida = controllerLogradouro.inserir(logradouroEntrada);
	        JOptionPane.showMessageDialog(null, logradouroSaida.toString());
	    }
	    
	    public static void alterar() throws ClassNotFoundException, SQLException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
	        String endereco  = JOptionPane.showInputDialog("Endereço: ");
	        int numero = Integer.parseInt(JOptionPane.showInputDialog("Numero: "));
	        String cep = JOptionPane.showInputDialog("Cep: ");
	        String complemento = JOptionPane.showInputDialog("Complemento: ");
	        Logradouro logradouroEntrada = new Logradouro(id, endereco, cep, numero, complemento);
	        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
	        Logradouro logradouroSaida = controllerLogradouro.alterar(logradouroEntrada);
	        JOptionPane.showMessageDialog(null, logradouroSaida.toString());
	    }

	    public static void buscar() throws ClassNotFoundException, SQLException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
	        Logradouro logradouroEntrada = new Logradouro(id);
	        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
	        Logradouro logradouroSaida = controllerLogradouro.buscar(logradouroEntrada);
	        JOptionPane.showMessageDialog(null, logradouroSaida.toString());
	        
	    }
	    
	    public static void excluir() throws ClassNotFoundException, SQLException {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
	        Logradouro logradouroEntrada = new Logradouro(id);
	        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
	        Logradouro logradouroSaida = controllerLogradouro.excluir(logradouroEntrada);
	        JOptionPane.showMessageDialog(null, "Usuário Deletado");
	    }
	    
	    public static void listar() throws ClassNotFoundException, SQLException {
	        String cep = JOptionPane.showInputDialog("Cep: ");
	        Logradouro logradouroEntrada = new Logradouro(cep);
	        ControllerLogradouro controllerLogradouro = new ControllerLogradouro();
	        List<Logradouro> listaLogradouro = controllerLogradouro.listar(logradouroEntrada);
	        DefaultListModel model = new DefaultListModel();
			JList list = new JList(model);
			for (int i = 0; i < listaLogradouro.size(); i++) {
				model.add(i, listaLogradouro.get(i));
			}
			list.show();
			JOptionPane.showMessageDialog(null, list);
	        
	    }
	
}
