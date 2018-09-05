package by.htp.epam.cinema.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp.epam.cinema.db.pool.impl.CustomConnectionPool;

/**
 * listener class for initialize and destroy connection pool
 * 
 * @author Arkadzi Patsko
 *
 */
public class InitializeConnectionPoolListener implements ServletContextListener {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		CustomConnectionPool.initializeConnectionPool();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CustomConnectionPool.destroyConnectionPool();
	}
}
