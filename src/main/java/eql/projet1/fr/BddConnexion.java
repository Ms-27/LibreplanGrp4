package eql.projet1.fr;

import java.io.File;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.db2.Db2Connection;
import org.dbunit.operation.DatabaseOperation;

public class BddConnexion {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/libreplan";
	private static final String USER = "libreplan";
	private static final String PASSWORD = "libreplan";

	private static IDataSet readDataSet(String filename) throws Exception {
		return new FlatXmlDataSetBuilder().build(new File(filename));
	}

	public static void insertData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}

	public static void deleteAllData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.DELETE_ALL);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}

	public static void deleteSpecificData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);

		IDatabaseConnection dbConn = databaseTester.getConnection();
		DatabaseConfig dbCfg = dbConn.getConfig();
		dbCfg.setProperty(DatabaseConfig.FEATURE_ALLOW_EMPTY_FIELDS, Boolean.TRUE);

//		System.out.println("getCfg -> " + dbConn.getConfig().getProperty(DatabaseConfig.FEATURE_ALLOW_EMPTY_FIELDS));
//		System.out.println("dbCfg  -> " + dbCfg.getProperty(DatabaseConfig.FEATURE_ALLOW_EMPTY_FIELDS));

		databaseTester.setSetUpOperation(DatabaseOperation.DELETE);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}

	// DefaultColumnFilter columnFilter = new DefaultColumnFilter();
	// columnFilter.excludeColumn(column_to_exclude);
	// FilteredTableMetaData metaData = new
	// FilteredTableMetaData(originalTable.getTableMetaData(), columnFilter);

	// DatabaseConfig config = connection.getConfig();
	// dataset.setProperty(DatabaseConfig.FEATURE_ALLOW_EMPTY_FIELDS, Boolean.TRUE);

}
