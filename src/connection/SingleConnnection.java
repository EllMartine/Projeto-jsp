package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/projeto-jsp?autoReconnect=true";
	private static String user = "admin";
	private static String password = "postgres"; 
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if(connection ==  null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar no banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	 
	
}
