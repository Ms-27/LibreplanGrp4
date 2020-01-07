package eql.projet1.fr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;

public class BddConnexion {
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/libreplan";
	private static final String USER = "libreplan";
	private static final String PASSWORD = "libreplan";
	
	public static void setDataBase(String sql_path) throws ClassNotFoundException, SQLException, FileNotFoundException {
		
		// Load, in my case, postgreSQL jdbc driver
		Class.forName(DRIVER);
		
		// Create Connection to database
		Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		
		// Initialize the script runner
		ScriptRunner sr = new ScriptRunner(connection);
		
		// Creating a reader object
		Reader reader = new BufferedReader(new FileReader(sql_path));
		
		// Running the script
		sr.runScript(reader);
	}

}
