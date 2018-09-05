package by.htp.epam.cinema.web.util;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_SIGN_UP_ACTION_LOGIN_IS_NOT_VALID;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_SIGN_UP_ACTION_EMAIL_IS_NOT_VALID;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_SIGN_UP_ACTION_PASSWORD_IS_NOT_VALID;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_LOG_IN_ACTION_AUTHENTICATION_ERROR;

/**
 * Class for param validation
 * 
 * @author Arkadzi Patsko
 *
 */
public class HttpRequestParamValidator {

	private static final ResourceManager RM = ResourceManager.LOCALIZATION;
	private static final String LOGIN_INPUT_VALIDATION_REGEX = "[A-Za-z0-9_]{5,15}";
	private static final String EMAIL_INPUT_VALIDATION_REGEX = "(\\w{5,})@(\\w+\\.)([a-z]{2,4})";
	private static final String PASSWORD_INPUT_VALIDATION_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{5,10}";
	private static final String LOCALE_PARAM_VALIDATION_REGEX = "[a-zA-Z]{2}_[a-zA-Z]{2}";

	private static final String METHOD_NAME_POST = "POST";
	private static final String ERROR_MSG_EMPTY_PARAM = "Empty param recieved";
	private static final String ERROR_MSG_UNDEFINED_LOCALE = "Undefined locale";

	/**
	 * validates param(s). Check is param null or not
	 * 
	 * @param str
	 *            param(s)
	 * @throws ValidateParamException
	 *             if param null
	 */
	public static void validateRequestParamNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				throw new ValidateParamException(ERROR_MSG_EMPTY_PARAM);
			}
		}
	}

	/**
	 * validates locale
	 * 
	 * @param locale
	 *            locale
	 * @throws ValidateParamException
	 *             if locale not valid
	 */
	public static void validateRequestParamLocale(String locale) {
		if (locale == null || !Pattern.matches(LOCALE_PARAM_VALIDATION_REGEX, locale))
			throw new ValidateParamException(ERROR_MSG_UNDEFINED_LOCALE);
	}

	/**
	 * check method post or not
	 * 
	 * @param reg
	 *            HttpServletRequest object
	 * @return {@code true} if method post, {@code false} otherwise
	 */
	public static boolean isPost(HttpServletRequest reg) {
		return reg.getMethod().toUpperCase().equals(METHOD_NAME_POST);
	}

	/**
	 * validates user input during log in operation
	 * 
	 * @param login
	 *            user login
	 * @param password
	 *            user password
	 * @throws ValidateParamException
	 *             if input not valid
	 */
	public static void validateUserCredentialsInput(String login, String password) {
		validateRequestParamNotNull(login, password);
		if (!validateLoginInput(login) || !validatePasswordInput(password))
			throw new ValidateParamException(RM.getValue(ERROR_MSG_LOG_IN_ACTION_AUTHENTICATION_ERROR));
	}

	/**
	 * validates user input during sign up operation
	 * 
	 * @param login
	 *            user login
	 * @param email
	 *            user email
	 * @param password
	 *            user password
	 * @throws ValidateParamException
	 *             if input not valid
	 */
	public static void validateUserCredentialsInput(String login, String email, String password) {
		validateRequestParamNotNull(login, email, password);
		if (!validateLoginInput(login))
			throw new ValidateParamException(RM.getValue(ERROR_MSG_SIGN_UP_ACTION_LOGIN_IS_NOT_VALID));
		if (!validateEmailInput(email))
			throw new ValidateParamException(RM.getValue(ERROR_MSG_SIGN_UP_ACTION_EMAIL_IS_NOT_VALID));
		if (!validatePasswordInput(password))
			throw new ValidateParamException(RM.getValue(ERROR_MSG_SIGN_UP_ACTION_PASSWORD_IS_NOT_VALID));
	}

	/**
	 * validates user login
	 * 
	 * @param login
	 *            user login
	 * @return {@code true} if login valid, {@code false} otherwise
	 */
	public static boolean validateLoginInput(String login) {
		return Pattern.matches(LOGIN_INPUT_VALIDATION_REGEX, login);
	}

	/**
	 * validates user email
	 * 
	 * @param email
	 *            user email
	 * @return {@code true} if email valid, {@code false} otherwise
	 */
	public static boolean validateEmailInput(String email) {
		return Pattern.matches(EMAIL_INPUT_VALIDATION_REGEX, email);
	}

	/**
	 * validates user password
	 * 
	 * @param password
	 *            user password
	 * @return {@code true} if password valid, {@code false} otherwise
	 */
	public static boolean validatePasswordInput(String password) {
		return Pattern.matches(PASSWORD_INPUT_VALIDATION_REGEX, password);
	}
}
