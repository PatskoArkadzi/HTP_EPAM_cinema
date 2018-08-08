package by.htp.epam.cinema.db.dao;

import java.util.List;
import java.util.Map;

import by.htp.epam.cinema.domain.Film;


public interface FilmDao extends BaseDao<Film> {

	List<Film> readAllWhereEq(Map<String, Object> map);

	List<Film> readAllFilmsWhereGenreIdPresent(int genreId);

}
