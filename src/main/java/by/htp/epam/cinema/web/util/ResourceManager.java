package by.htp.epam.cinema.web.util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

	LOCALIZATION("localization.msg"), DATA_BASE("db_config");

	private ResourceBundle resourceBundle;
	private final String resourceName;

	private ResourceManager(String resourceName) {
		Locale.setDefault(Locale.US);
		this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
		// this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.US);
		this.resourceName = resourceName;
	}

	public void changeResource(Locale locale) {
		resourceBundle = ResourceBundle.getBundle(resourceName, locale);
	}

	public String getValue(String key) {
		return resourceBundle.getString(key);
	}
}
