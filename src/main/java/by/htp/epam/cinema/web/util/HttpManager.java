package by.htp.epam.cinema.web.util;

/**
 * Util class HttpManager
 * 
 * @author Arkadzi Patsko
 *
 */
public class HttpManager {

	/**
	 * gets location for redirect
	 * 
	 * @param actionName
	 *            action name for redirect
	 * @return direction for redirect
	 */
	public static String getLocationForRedirect(String actionName) {
		return "cinema?action=" + actionName;
	}
}
