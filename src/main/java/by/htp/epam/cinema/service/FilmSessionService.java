package by.htp.epam.cinema.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.FilmSession;

public interface FilmSessionService extends Service {

	public List<FilmSession> getFilmSessions(int filmId);

	public FilmSession getFilmSession(int filmSessionId);

	public FilmSession buildFilmSession(HttpServletRequest request);

	public void createFilmSession(FilmSession filmSession);

	public void updateFilmSession(FilmSession filmSession);

	public void deleteFilmSession(int filmSessionId);

	public boolean isRemovalPossible(int filmSessionId);

	public boolean isFilmSessionTimeFree(FilmSession filmSession);

}
