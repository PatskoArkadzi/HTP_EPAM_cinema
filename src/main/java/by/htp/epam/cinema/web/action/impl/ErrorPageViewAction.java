package by.htp.epam.cinema.web.action.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.epam.cinema.web.action.BaseAction;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_ERROR;

import java.io.IOException;

/**
 * Class implementing BaseAction interface
 * 
 * @author Arkadzi Patsko
 *
 */
public class ErrorPageViewAction implements BaseAction {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
	}
}
