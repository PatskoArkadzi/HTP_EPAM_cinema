package by.htp.epam.cinema.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.cinema.web.util.ResourceManager;

/**
 * Interface providing executeAction method
 * 
 * @author Arkadzi Patsko
 *
 */
public interface BaseAction {

	/**
	 * resourceManager field
	 */
	public static final ResourceManager resourceManager = ResourceManager.LOCALIZATION;

	/**
	 * gets http request and forms http response
	 * 
	 * @param request
	 *            request from client to server
	 * @param response
	 *            response from server to client
	 * @throws ServletException
	 *             if ServletException occurs
	 * @throws IOException
	 *             if IOException occurs
	 */
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
