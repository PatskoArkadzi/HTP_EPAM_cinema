package by.htp.epam.cinema.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * util class for safe password store
 * 
 * @author Arkadzi Patsko
 *
 */
public class PasswordSecurity {

	private static final int SALT_SIZE = 16;
	private static final String ALGORITHM_NAME = "SHA-512";

	private static Logger logger = LoggerFactory.getLogger(PasswordSecurity.class);

	/**
	 * generates salt for password
	 *
	 * @return salt for user
	 */
	public static String getSalt() {
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[SALT_SIZE];
		sr.nextBytes(salt);
		return byteArrayToHexString(salt);
	}

	/**
	 * salts and hashes password
	 *
	 * @param password
	 *            user password
	 * @param salt
	 *            user salt
	 * @return hashed password
	 */
	public static String getHashPassword(String password, String salt) {
		try {
			MessageDigest md = MessageDigest.getInstance(ALGORITHM_NAME);
			md.update(salt.getBytes());
			byte[] hashPassword = md.digest(password.getBytes());
			return byteArrayToHexString(hashPassword);
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException in getHash() in PasswordSecurity class");
		}
		return null;
	}

	/**
	 * transforms byte array to hexString
	 *
	 * @param arr
	 *            array of bytes
	 * @return hexStrig
	 */
	private static String byteArrayToHexString(byte[] arr) {
		StringBuilder sb = new StringBuilder();
		for (byte b : arr) {
			String hexByte = Integer.toString((b & 255) + 256, 16).substring(1);
			sb.append(hexByte);
		}
		return sb.toString();
	}
}
