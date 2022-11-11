package backenddmn20222.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDatabase {
static Connection conexao = null;
static PreparedStatement stm;

public static String status = "Não conectado...";
	
public ConnectionDatabase() {
	
}

	public static Connection conectaBD() {
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver"); 	
	    	conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_faculdade"+"?useTimezone=true&serverTimezone=UTC","root","1234");
	    } catch (Exception e) {
	    		System.out.println("Não foi possível conectar ao bd: " + e.getMessage());
	    	}
		
		return conexao;
	}

public static boolean FecharConexao() {
    try {
       ConnectionDatabase.conectaBD().close();
       return true;
    } catch (SQLException e) {
        return false;
    }
}

public static java.sql.Connection ReiniciarConexao() {
    FecharConexao();
    return ConnectionDatabase.conectaBD();
}

}
