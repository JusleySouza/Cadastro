package backenddmn20222;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import backenddmn20222.views.ManterContato;
import backenddmn20222.views.ManterContatoPessoa;
import backenddmn20222.views.ManterLogradouro;
import backenddmn20222.views.ManterLogradouroPessoa;
import backenddmn20222.views.ManterPessoaFisica;
import backenddmn20222.views.ManterUsuario;
import backenddmn20222.views.ManterUsuarioPessoa;

public class BackEndDmN20222 {

	public static void main(String[] args) throws HeadlessException, ClassNotFoundException, SQLException {
		if (ManterUsuario.validar()) {
			menu();
		} else {
			JOptionPane.showMessageDialog(null, "Usuario Inválido");
		}
	}

	public static void menu() throws ClassNotFoundException, SQLException {
		String msg = " 0 - Sair \n 1 - Usuario \n 2 - Pessoa \n 3 - Usuario_Pessoa \n 4 - Logradouro \n 5 - Logradouro_Pessoa \n 6 - Contato \n 7 - Contato_Pessoa ";
		int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
		switch (num) {
		case 0:
			int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
			if (sair > 0)
				menu();
			break;
		case 1:
			ManterUsuario.menu();
			break;
		case 2:
			ManterPessoaFisica.menu();
			break;
		case 3:
			ManterUsuarioPessoa.menu();
			break;
		case 4:
			ManterLogradouro.menu();
			break;
		case 5:
			ManterLogradouroPessoa.menu();
			break;
		case 6:
			ManterContato.menu();
			break;
		case 7:
			ManterContatoPessoa.menu();
			break;
		default:
			System.out.println("Opção inválido");
		}
	}

}
