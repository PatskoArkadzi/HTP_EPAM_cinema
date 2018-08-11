package by.htp.epam.cinema.db.dao;

import java.util.List;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.Genre;

public interface GenreDao extends BaseDao<Genre> {

	List<Genre> readAll(Film film);
	
	//TODO add specific methods
}
