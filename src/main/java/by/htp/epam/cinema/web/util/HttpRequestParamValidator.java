package by.htp.epam.cinema.web.util;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestParamValidator {

	private static Logger logger = LoggerFactory.getLogger(HttpRequestParamValidator.class);
	public static final String EMAIL_INPUT_VALIDATION_REGEX = "(\\w{5,})@(\\w+\\.)([a-z]{2,4})";

	public static void validateRequestParamNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				throw new ValidateNullParamException(
						"Empty param recieved in " + new Exception().getStackTrace()[1].getClassName());
			}
		}
	}

	public static boolean isPost(HttpServletRequest reg) {
		return reg.getMethod().toUpperCase().equals("POST");
	}

	public static boolean validateEmailInput(String email) {
		return Pattern.matches(EMAIL_INPUT_VALIDATION_REGEX, email);
	}

}
