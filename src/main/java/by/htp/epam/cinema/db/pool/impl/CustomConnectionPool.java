package by.htp.epam.cinema.db.pool.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.pool.BaseConnectionPool;
import by.htp.epam.cinema.web.util.ResourceManager;

import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.*;

/**
 * Class provides connections to the database
 * 
 * @author Arkadzi Patsko
 *
 */
public class CustomConnectionPool implements BaseConnectionPool {
	/**
	 * Singleton instance
	 */
	private static CustomConnectionPool instance;
	/**
	 * Connection pool size
	 */
	private static final int POOL_SIZE = 10;
	/**
	 * Resource manager enum constant which provides property for getting connection
	 */
	private static final ResourceManager RM = ResourceManager.DATA_BASE;

	private static final Logger logger = LoggerFactory.getLogger(CustomConnectionPool.class);
	/**
	 * queue for containing free connections
	 */
	private static BlockingQueue<Connection> connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);
	/**
	 * queue for containing occupied connections
	 */
	private static BlockingQueue<Connection> givenAwayConectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);

	/**
	 * Constructor without parameters
	 */
	private CustomConnectionPool() {
	}

	/**
	 * static method for getting instance of connection pool
	 * 
	 * @return BaseConnectionPool
	 */
	public static BaseConnectionPool getInstance() {
		if (instance == null) {
			synchronized (CustomConnectionPool.class) {
				if (instance == null) {
					instance = new CustomConnectionPool();
				}
			}
		}
		return instance;
	}

	/**
	 * fill connection pool in InitializeConnectionPoolListener class during context
	 * initializing
	 */
	public static void initializeConnectionPool() {
		try {
			Class.forName(RM.getValue(DB_CONNECTION_DRIVER));
			for (int i = 1; i <= POOL_SIZE; i++) {
				Connection connection = DriverManager.getConnection(RM.getValue(DB_CONNECTION_URL),
						RM.getValue(DB_CONNECTION_LOGIN), RM.getValue(DB_CONNECTION_PASSWORD));
				connectionQueue.add(connection);
				logger.info("connection was successfully added to the pool");
			}
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage() + " in static block in ConnectionPool class", e);
		}
	}

	/**
	 * destroy connection pool in InitializeConnectionPoolListener class during
	 * context destroying
	 */
	public static void destroyConnectionPool() {
		closeConnectionQueue(connectionQueue);
		closeConnectionQueue(givenAwayConectionQueue);
	}

	/**
	 * purge queue with connections
	 * 
	 * @param queue
	 *            queue for purging
	 */
	private static void closeConnectionQueue(BlockingQueue<Connection> queue) {
		Connection connection = null;
		while ((connection = queue.poll()) != null) {
			try {
				connection.close();
				logger.info("connection was successfully closed");
			} catch (SQLException e) {
				logger.error("connection can't be closed ");
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = connectionQueue.take();
			givenAwayConectionQueue.add(connection);
		} catch (InterruptedException e) {
			logger.error("InterruptedException in getConnection method in ConnectionPool class", e);
		}
		return connection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void putConnection(Connection connection) {
		try {
			if (connection.isClosed()) {
				logger.error("Already closed connection can't be closed ");
			}
			if (connection.isReadOnly()) {
				connection.setReadOnly(false);
			}
			if (!givenAwayConectionQueue.remove(connection)) {
				logger.error("Connection can't be deleted from givenAwayConectionQueue");
			}
			if (!connectionQueue.offer(connection)) {
				logger.error("Connection can't be added to connectionQueue");
			}
		} catch (SQLException e) {
			logger.error("{} in putConnection() in ConnectionPool class", e);
		}
	}
}
