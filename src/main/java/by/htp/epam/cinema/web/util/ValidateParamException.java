package by.htp.epam.cinema.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom exception class
 * 
 * @author Arkadzi Patsko
 *
 */
public class ValidateParamException extends RuntimeException {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 969443519136553553L;
	private static Logger logger = LoggerFactory.getLogger(ValidateParamException.class);

	/**
	 * constructor without parameters
	 */
	public ValidateParamException() {
	}

	/**
	 * constructor without parameters
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause
	 */
	public ValidateParamException(String message, Throwable cause) {
		super(message, cause);
		logger.error(message + " " + cause);
	}

	/**
	 * constructor without parameters
	 * 
	 * @param message
	 *            the detail message.
	 */
	public ValidateParamException(String message) {
		super(message);
		logger.error(message);
	}

	/**
	 * constructor without parameters
	 * 
	 * @param cause
	 *            the cause
	 */
	public ValidateParamException(Throwable cause) {
		super(cause);
		logger.error("{}", cause);
	}
}
