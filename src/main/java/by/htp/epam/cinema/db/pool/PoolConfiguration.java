package by.htp.epam.cinema.db.pool;

import by.htp.epam.cinema.web.util.ResourceManager;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.*;

public class PoolConfiguration {

	protected final static int POOL_SIZE = 10;

	private final static ResourceManager RM = ResourceManager.DATA_BASE;
	protected static final String DRIVER = RM.getValue(DB_CONNECTION_DRIVER);
	protected static final String URL = RM.getValue(DB_CONNECTION_URL);
	protected static final String LOGIN = RM.getValue(DB_CONNECTION_LOGIN);
	protected static final String PASSWORD = RM.getValue(DB_CONNECTION_PASSWORD);
}
