package backenddmn20222.utils;

import backenddmn20222.database.ConnectionDatabase;

public class TesteConexao {

	public static void main(String[] args) {
		System.out.println(ConnectionDatabase.conectaBD());
	}
}
