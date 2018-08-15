package by.htp.epam.cinema.web.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestParamValidator {

	private static Logger logger = LoggerFactory.getLogger(HttpRequestParamValidator.class);

	public static boolean validateRequestParamNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				logger.error("Empty param recieved");
				return false;
			}
		}
		return true;
	}

	public static boolean isPost(HttpServletRequest reg) {
		return reg.getMethod().toUpperCase().equals("POST");
	}

}
