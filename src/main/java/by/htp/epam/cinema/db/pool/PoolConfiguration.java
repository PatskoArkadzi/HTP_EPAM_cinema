package by.htp.epam.cinema.db.pool;

import java.util.ResourceBundle;

public class PoolConfiguration {

	final static int POOL_SIZE = 10;
	
	private final static ResourceBundle rb = ResourceBundle.getBundle("db_config");

	final static String DRIVER = rb.getString("db.driver");
	final static String URL = rb.getString("db.url");
	final static String LOGIN = rb.getString("db.login");
	final static String PASSWORD = rb.getString("db.pass");
}
