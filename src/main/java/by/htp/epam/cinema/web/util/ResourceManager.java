package by.htp.epam.cinema.web.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Enum for resources control
 * 
 * @author Arkadzi Patsko
 *
 */
public enum ResourceManager {

	/**
	 * localization control
	 */
	LOCALIZATION("localization.msg"),
	/**
	 * database properties control
	 */
	DATA_BASE("db_config"),
	/**
	 * timer property control
	 */
	TIMER("timer");

	private ResourceBundle resourceBundle;

	/**
	 * resource name
	 */
	private final String resourceName;

	/**
	 * constructor with parameter
	 * 
	 * @param resourceName
	 *            name of resource
	 */
	private ResourceManager(String resourceName) {
		Locale.setDefault(Locale.US);
		this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
		this.resourceName = resourceName;
	}

	/**
	 * changes locale
	 * 
	 * @param locale
	 *            need locale
	 */
	public void changeResource(Locale locale) {
		resourceBundle = ResourceBundle.getBundle(resourceName, locale);
	}

	/**
	 * gets value by key
	 * 
	 * @param key
	 *            resource key
	 * @return value from property files
	 */
	public String getValue(String key) {
		return resourceBundle.getString(key);
	}
}
