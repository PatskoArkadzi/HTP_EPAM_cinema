package by.htp.epam.cinema.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp.epam.cinema.db.pool.impl.ConnectionPool;

public class InitializeConnectionPoolListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ConnectionPool.initializeConnectionPool();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ConnectionPool.destroyConnectionPool();
	}
}
