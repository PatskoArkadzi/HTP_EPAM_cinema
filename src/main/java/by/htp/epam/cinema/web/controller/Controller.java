package by.htp.epam.cinema.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.web.action.ActionManager;
import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.ResourceManager;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_ERROR_MESSAGE;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_CONTROLLER_INDEFINITE_ERROR;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_ERROR;

/**
 * Controller class
 * 
 * @author Arkadzi Patsko
 *
 */
public class Controller extends HttpServlet {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -8681427004682803228L;
	private static Logger logger = LoggerFactory.getLogger(Controller.class);
	/**
	 * resourceManager field
	 */
	private static final ResourceManager resourceManager = ResourceManager.LOCALIZATION;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	/**
	 * defines action and execute appropriate logic
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
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BaseAction action = ActionManager.defineAction(req);
			action.executeAction(req, resp);
		} catch (NullPointerException | ServletException | IOException e) {
			logger.error(e.getMessage() + " in Controller class", e);
			req.setAttribute(REQUEST_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_CONTROLLER_INDEFINITE_ERROR));
			req.getRequestDispatcher(PAGE_ERROR).forward(req, resp);
		}
	}
}