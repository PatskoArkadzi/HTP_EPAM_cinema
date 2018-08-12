package by.htp.epam.cinema.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.dao.GenreDao;
import by.htp.epam.cinema.db.dao.impl.GenreDaoImpl;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.service.GenreService;

public class GenreServiceImpl implements GenreService {
	
	private GenreDao genreDao = new GenreDaoImpl();

	private static Logger logger = LoggerFactory.getLogger(GenreServiceImpl.class);

	@Override
	public List<Genre> getAllGenres() {
		return genreDao.readAll();
	}

}
