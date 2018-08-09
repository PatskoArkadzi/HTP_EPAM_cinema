package by.htp.epam.cinema.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.dao.FilmDao;
import by.htp.epam.cinema.db.pool.ConnectionPool;
import by.htp.epam.cinema.domain.Film;

public class FilmDaoImpl implements FilmDao {

	private static Logger logger = LoggerFactory.getLogger(FilmDaoImpl.class);

	private final String SQL_QUERY_FILM_CREATE = "INSERT INTO `cinema_v2.0`.`films` (`filmName`, `description`, `posterUrl`, `youTubeVideoId`) VALUES (?,?,?,?);";
	private final String SQL_QUERY_FILM_READ = "SELECT `id`, `filmName`, `description`, `posterUrl`, `youTubeVideoId` FROM `cinema_v2.0`.`films` WHERE  `id`=?;";
	private final String SQL_QUERY_FILM_READ_ALL = "SELECT `id`, `filmName`, `description`, `posterUrl`, `youTubeVideoId` FROM `cinema_v2.0`.`films`;";
	private final String SQL_QUERY_FILM_READ_ALL_BY_GENRE_ID = "SELECT `id`, `filmName`, `description`, `posterUrl`, `youTubeVideoId` FROM `cinema_v2.0`.`films` f "
			+ "inner join `cinema_v2.0`.`films_genres` fg on f.id=fg.film_id where fg.genre_id=?;";
	private final String SQL_QUERY_FILM_UPDATE = "UPDATE `cinema_v2.0`.`films` SET `filmName`=?, `description`=?, `posterUrl`=?, `youTubeVideoId`=? WHERE `id`=?;";
	private final String SQL_QUERY_FILM_DELETE = "DELETE FROM `cinema_v2.0`.`films` WHERE  `id`=?;";

	@Override
	public void create(Film entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_CREATE)) {
			ps.setString(1, entity.getFilmName());
			ps.setString(2, entity.getDescription());
			ps.setString(3, entity.getPosterUrl());
			ps.setString(4, entity.getYouTubeVideoId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in create method of FilmDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public Film read(int id) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildFilm(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of FilmDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public List<Film> readAll() {
		List<Film> films = null;
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (Statement ps = con.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_FILM_READ_ALL);
			films = new ArrayList<>();
			while (rs.next()) {
				films.add(buildFilm(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of FilmDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return films;
	}

	@Override
	public List<Film> readAllFilmsWhereGenreIdPresent(int genreId) {
		List<Film> films = null;
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_READ_ALL_BY_GENRE_ID)) {
			ps.setInt(1, genreId);
			rs = ps.executeQuery();
			films = new ArrayList<>();
			while (rs.next()) {
				films.add(buildFilm(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAllFilmsWhereGenreIdPresent method of FilmDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return films;
	}

	@Override
	public void update(Film entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_UPDATE)) {
			ps.setString(1, entity.getFilmName());
			ps.setString(2, entity.getDescription());
			ps.setString(3, entity.getPosterUrl());
			ps.setString(4, entity.getYouTubeVideoId());
			ps.setInt(5, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in update method of FilmDaoImpl class", e);
		}finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public void delete(Film entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_DELETE)) {
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in delete method of FilmDaoImpl class", e);
		}finally {
			ConnectionPool.putConnection(con);
		}
	}

	private Film buildFilm(ResultSet rs) throws SQLException {
		Film film = new Film();
		film.setId(rs.getInt("id"));
		film.setFilmName(rs.getString("filmName"));
		film.setDescription(rs.getString("description"));
		film.setPosterUrl(rs.getString("posterUrl"));
		film.setYouTubeVideoId(rs.getString("youTubeVideoId"));
		return film;
	}

	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SQLException in close method of FilmDaoImpl class", e);
			}
		}
	}
}
