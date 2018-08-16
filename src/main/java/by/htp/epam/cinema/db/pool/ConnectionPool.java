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
	private static BlockingQueue<CustomConnection> connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);
	private static BlockingQueue<CustomConnection> givenAwayConectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);

	private ConnectionPool() {
	}

	public static void initializeConnectionPool() {
		try {
			Class.forName(DRIVER);
			for (int i = 1; i <= POOL_SIZE; i++) {
				Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
				CustomConnection customConnection = new CustomConnection("Connection №" + i, connection);
				connectionQueue.add(customConnection);
				logger.info(customConnection.getConnectionName() + " was successfully added to the pool");
			}
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage() + " in static block in ConnectionPool class", e);
		}
	}

	public static void destroyConnectionPool() {
		closeConnectionQueue(connectionQueue);
		closeConnectionQueue(givenAwayConectionQueue);
	}

	private static void closeConnectionQueue(BlockingQueue<CustomConnection> queue) {
		CustomConnection customConnection = null;
		while ((customConnection = queue.poll()) != null) {
			try {
				customConnection.close();
				logger.info("{} was successfully closed", customConnection.getConnectionName());
			} catch (SQLException e) {
				logger.error("{} can't be closed ", customConnection.getConnectionName());
			}
		}
	}

	public static CustomConnection getConnection() {
		CustomConnection customConnection = null;
		try {
			customConnection = connectionQueue.take();
			givenAwayConectionQueue.add(customConnection);
			logger.info("{} was successfully removed from connectionQueue to givenAwayConectionQueue",
					customConnection.getConnectionName());
		} catch (InterruptedException e) {
			logger.error(e.getMessage() + " in getConnection method in ConnectionPool class", e);
			e.printStackTrace();
		}
		return customConnection;
	}

	public static void putConnection(Connection connection) {
		try {
			CustomConnection customConnection = givenAwayConectionQueue.take();
			connectionQueue.add(customConnection);
			logger.info("{} was successfully removed from givenAwayConectionQueue to connectionQueue",
					customConnection.getConnectionName());
		} catch (InterruptedException e) {
			logger.error(e.getMessage() + " in putConnection method in ConnectionPool class", e);
			e.printStackTrace();
		}
	}
}
