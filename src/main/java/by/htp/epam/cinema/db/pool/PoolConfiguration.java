package by.htp.epam.cinema.db.pool;

import java.util.ResourceBundle;

public class PoolConfiguration {

	final static int POOL_SIZE = 10;
	
	private final static ResourceBundle rb = ResourceBundle.getBundle("db_config");

	public static final String DRIVER = rb.getString("db.driver");
	public static final String URL = rb.getString("db.url");
	public static final String LOGIN = rb.getString("db.login");
	public static final String PASSWORD = rb.getString("db.pass");
}
