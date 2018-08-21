package by.htp.epam.cinema.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.web.action.ActionManager;
import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.util.ResourceManager;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_ERROR_MESSAGE;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_LOG_IN_ACTION_REPEATED_LOGGING;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = -8681427004682803228L;
	private static Logger logger = LoggerFactory.getLogger(Controller.class);
	private static final ResourceManager resourceManager = ResourceManager.LOCALIZATION;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actions currentAction = ActionManager.defineAction(req);
		Actions nextAction = null;
		try {
			nextAction = currentAction.action.executeAction(req);
			if (nextAction.equals(Actions.CHANGE_LOCALE)) {
				resp.sendRedirect(req.getHeader("Referer"));
			} else if (nextAction == null || nextAction == currentAction) {
				req.getRequestDispatcher(currentAction.jspPage).forward(req, resp);
			} else
				resp.sendRedirect("cinema?action=" + nextAction.toString().toLowerCase());
		} catch (ServletException | IOException | NullPointerException e) {
			logger.error(e.getMessage() + " in Controller class", e);
			req.getSession().setAttribute(SESSION_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_LOG_IN_ACTION_REPEATED_LOGGING));
			req.getRequestDispatcher(Actions.ERROR.jspPage).forward(req, resp);
		}
	}
}