package by.htp.epam.cinema.db.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp.epam.cinema.domain.Film;

public interface FilmDao extends BaseDao<Film> {

	List<Film> readAllFilmsWhereGenreIdPresent(int genreId);

	void createFilmWithGenres(Film film, List<Integer> genresId) throws SQLException;

	void updateFilmWithGenres(Film film, List<Integer> genresId) throws SQLException;

}
