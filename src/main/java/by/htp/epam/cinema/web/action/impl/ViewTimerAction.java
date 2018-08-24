package by.htp.epam.cinema.web.action.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.Timer;

public class ViewTimerAction implements BaseAction {

	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Timer timer = Timer.getInstance();
		PrintWriter out = response.getWriter();
		if (!timer.isAlive()) {
			request.getSession().setAttribute("isTimerNeed", false);
			out.write("Time is over");
		} else {
			out.write(String.format("%02d : %02d", timer.getMinutesDisplay(), timer.getSecondsDisplay()));
		}
	}
}
