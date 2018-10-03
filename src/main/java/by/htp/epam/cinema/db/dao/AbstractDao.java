package by.htp.epam.cinema.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.pool.BaseConnectionPool;

/**
 * Abstract class for daoImpl classes
 * 
 * @author Arkadzi Patsko
 */
public abstract class AbstractDao {

	private static Logger logger = LoggerFactory.getLogger(AbstractDao.class);

	/**
	 * Connection pool
	 */
	public BaseConnectionPool connectionPool;

	/**
	 * Sets connection pool
	 * 
	 * @param connectionPool
	 *            {@link #connectionPool}
	 */
	public void setConnectionPool(BaseConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	/**
	 * closes resultSet
	 * 
	 * @param rs
	 *            resultSet for closing
	 */
	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SQLException in close method", e);
			}
		}
	}
}
