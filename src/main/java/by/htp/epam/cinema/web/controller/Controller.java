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

public class Controller extends HttpServlet {

	private static Logger logger = LoggerFactory.getLogger(Controller.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) {
		BaseAction action = ActionManager.defineAction(req);
		String page = action.executeAction(req);
		if (page != null) {
			try {
				req.getRequestDispatcher(page).forward(req, resp);
			} catch (ServletException | IOException e) {
				logger.error(e.getMessage()+" in Controller class", e);
			}
		}
	}
}
