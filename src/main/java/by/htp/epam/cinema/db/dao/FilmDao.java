package by.htp.epam.cinema.db.dao;

import java.util.List;

import by.htp.epam.cinema.domain.Film;

public interface FilmDao extends BaseDao<Film> {

	List<Film> readAllFilmsWhereGenreIdPresent(int genreId);

}
