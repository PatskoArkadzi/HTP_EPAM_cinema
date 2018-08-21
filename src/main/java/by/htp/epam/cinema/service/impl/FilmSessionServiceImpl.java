package by.htp.epam.cinema.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.dao.FilmSessionDao;
import by.htp.epam.cinema.db.dao.impl.FilmDaoImpl;
import by.htp.epam.cinema.db.dao.impl.FilmSessionDaoImpl;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.service.FilmSessionService;

public class FilmSessionServiceImpl implements FilmSessionService {

	private FilmSessionDao filmSessionDao = new FilmSessionDaoImpl();

	private static Logger logger = LoggerFactory.getLogger(FilmDaoImpl.class);

	@Override
	public List<FilmSession> getFilmSessions(int filmId) {
		return filmSessionDao.readAll(filmId);
	}

	@Override
	public FilmSession getFilmSession(int filmSessionId) {
		return filmSessionDao.read(filmSessionId);
	}
}
