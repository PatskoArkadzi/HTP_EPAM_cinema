package by.htp.epam.cinema.db.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.dao.FilmSessionDao;
import by.htp.epam.cinema.db.pool.BaseConnectionPool;
import by.htp.epam.cinema.db.pool.impl.ConnectionPool;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;

public class FilmSessionDaoImpl implements FilmSessionDao {

	BaseConnectionPool connectionPool = ConnectionPool.getInstance();
	private static Logger logger = LoggerFactory.getLogger(FilmSessionDaoImpl.class);

	private static final String SQL_QUERY_FILM_SESSION_CREATE = "INSERT INTO `cinema_v2.0`.`sessions` (`film_id`, `date`, `time`, `ticketPrice`) VALUES (?,?,?,?);";
	private static final String SQL_QUERY_FILM_SESSION_READ = "SELECT `id`, `film_id`, `date`, `time`, `ticketPrice` FROM `cinema_v2.0`.`sessions` WHERE  `id`=?;";
	private static final String SQL_QUERY_FILM_SESSION_READ_BY_DATE_AND_TIME = "SELECT `id`, `film_id`, `date`, `time`, `ticketPrice` FROM `cinema_v2.0`.`sessions` WHERE `date`=? AND `time`=?;";
	private static final String SQL_QUERY_FILM_SESSION_READ_ALL = "SELECT `id`, `film_id`, `date`, `time`, `ticketPrice` FROM `cinema_v2.0`.`sessions`;";
	private static final String SQL_QUERY_FILM_SESSION_READ_ALL_BY_FILM_ID = "SELECT `id`, `film_id`, `date`, `time`, `ticketPrice` FROM `cinema_v2.0`.`sessions` WHERE `film_id`=?;";
	private static final String SQL_QUERY_FILM_SESSION_UPDATE = "UPDATE `cinema_v2.0`.`sessions` SET `film_id`=?, `date`=?, `time`=?, `ticketPrice`=? WHERE `id`=?;";
	private static final String SQL_QUERY_FILM_SESSION_DELETE = "DELETE FROM `cinema_v2.0`.`sessions` WHERE  `id`=?;";
	private static final String SQL_QUERY_FILM_SESSION_READ_ALL_WHERE_SEAT_NOT_FREE = "SELECT s.`id`, s.`film_id`, s.`date`, s.`time`, s.`ticketPrice`"
			+ "FROM `cinema_v2.0`.`sessions` s INNER JOIN `cinema_v2.0`.`tickets` t ON s.id=t.session_id WHERE t.seat_id = ?";

	@Override
	public void create(FilmSession entity) {
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_SESSION_CREATE)) {
			ps.setInt(1, entity.getFilm_id());
			ps.setString(2, entity.getDate());
			ps.setString(3, entity.getTime());
			ps.setBigDecimal(4, entity.getTicketPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in create method of FilmSessionDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
		}
	}

	@Override
	public FilmSession read(int id) {
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_SESSION_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildFilmSession(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of FilmSessionDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public FilmSession readByDateAndTime(String date, String time) {
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_SESSION_READ_BY_DATE_AND_TIME)) {
			ps.setString(1, date);
			ps.setString(2, time);
			rs = ps.executeQuery();
			if (rs.next())
				return buildFilmSession(rs);
		} catch (SQLException e) {
			logger.error("SQLException in readByDateAndTime method of FilmSessionDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public List<FilmSession> readAll() {
		List<FilmSession> filmSessions = null;
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (Statement ps = con.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_FILM_SESSION_READ_ALL);
			filmSessions = new ArrayList<>();
			while (rs.next()) {
				filmSessions.add(buildFilmSession(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of FilmSessionDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return filmSessions;
	}

	@Override
	public List<FilmSession> readAll(int filmId) {
		List<FilmSession> filmSessions = null;
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_SESSION_READ_ALL_BY_FILM_ID)) {
			ps.setInt(1, filmId);
			rs = ps.executeQuery();
			filmSessions = new ArrayList<>();
			while (rs.next()) {
				filmSessions.add(buildFilmSession(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll(int filmId) method of FilmSessionDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return filmSessions;
	}

	@Override
	public List<FilmSession> readAllWhereSeatNotFree(Seat seat) {
		List<FilmSession> filmSessions = null;
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_SESSION_READ_ALL_WHERE_SEAT_NOT_FREE)) {
			ps.setInt(1, seat.getId());
			rs = ps.executeQuery();
			filmSessions = new ArrayList<>();
			while (rs.next()) {
				filmSessions.add(buildFilmSession(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAllWhereSeatNotFree method of FilmSessionDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return filmSessions;
	}

	@Override
	public void update(FilmSession entity) {
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_SESSION_UPDATE)) {
			ps.setInt(1, entity.getFilm_id());
			ps.setString(2, entity.getDate());
			ps.setString(3, entity.getTime());
			ps.setBigDecimal(4, entity.getTicketPrice());
			ps.setInt(5, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in update method of FilmSessionDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
		}
	}

	@Override
	public void delete(int entityId) {
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_FILM_SESSION_DELETE)) {
			ps.setInt(1, entityId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in delete method of FilmSessionDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
		}
	}

	private FilmSession buildFilmSession(ResultSet rs) throws SQLException {
		FilmSession filmSession = new FilmSession();
		filmSession.setId(rs.getInt("id"));
		filmSession.setFilm_id(rs.getInt("film_id"));
		filmSession.setDate(rs.getString("date"));
		filmSession.setTime(rs.getString("time"));
		filmSession.setTicketPrice(new BigDecimal(rs.getString("ticketPrice")));
		return filmSession;
	}

	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SQLException in close method of FilmSessionDaoImpl class", e);
			}
		}
	}
}
