package by.htp.epam.cinema.db.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static by.htp.epam.cinema.db.pool.PoolConfiguration.*;

public class ConnectionPool {

	private static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
	private static BlockingQueue<Connection> connectionPool = new ArrayBlockingQueue<>(POOL_SIZE, true);

	private ConnectionPool() {
	}

	static {
		try {
			Class.forName(DRIVER);
			for (int i = 0; i < POOL_SIZE; i++) {
				connectionPool.add(DriverManager.getConnection(URL, LOGIN, PASSWORD));
			}
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage()+" in static block in ConnectionPool class", e);
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return connectionPool.take();
		} catch (InterruptedException e) {
			logger.error(e.getMessage()+" in getConnection method in ConnectionPool class", e);
			e.printStackTrace();
		}
		return null;
	}
	
	public static void putConnection(Connection connection) {
			try {
				connectionPool.put(connection);
			} catch (InterruptedException e) {
				logger.error(e.getMessage()+" in putConnection method in ConnectionPool class", e);
				e.printStackTrace();
			}
	}
}
