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

import by.htp.epam.cinema.db.dao.SeatDao;
import by.htp.epam.cinema.db.pool.ConnectionPool;
import by.htp.epam.cinema.domain.Seat;

public class SeatDaoImpl implements SeatDao {

	private static Logger logger = LoggerFactory.getLogger(SeatDaoImpl.class);

	private final String SQL_QUERY_SEAT_CREATE = "INSERT INTO `cinema_v2.0`.`seats` (`row`, `number`) VALUES (?,?);";
	private final String SQL_QUERY_SEAT_READ = "SELECT `id`, `row`, `number` FROM `cinema_v2.0`.`seats` WHERE  `id`=?;";
	private final String SQL_QUERY_SEAT_READ_BY_ROW_AND_NUMBER = "SELECT `id`, `row`, `number` FROM `cinema_v2.0`.`seats` WHERE `row`=? AND `number`=?;";
	private final String SQL_QUERY_SEAT_READ_ALL = "SELECT `id`, `row`, `number` FROM `cinema_v2.0`.`seats`;";
	private final String SQL_QUERY_SEAT_UPDATE = "UPDATE `cinema_v2.0`.`seats` SET `row`=?, `number`=? WHERE `id`=?;";
	private final String SQL_QUERY_SEAT_DELETE = "DELETE FROM `cinema_v2.0`.`seats` WHERE  `id`=?;";

	@Override
	public void create(Seat entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_SEAT_CREATE)) {
			ps.setInt(1, entity.getRow());
			ps.setInt(2, entity.getNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in create method of SeatDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public Seat read(int id) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_SEAT_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildSeat(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of SeatDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public Seat read(int row, int number) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_SEAT_READ_BY_ROW_AND_NUMBER)) {
			ps.setInt(1, row);
			ps.setInt(2, number);
			rs = ps.executeQuery();
			if (rs.next())
				return buildSeat(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of SeatDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public List<Seat> readAll() {
		List<Seat> seats = null;
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (Statement ps = con.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_SEAT_READ_ALL);
			seats = new ArrayList<>();
			while (rs.next()) {
				seats.add(buildSeat(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of SeatDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return seats;
	}

	@Override
	public void update(Seat entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_SEAT_UPDATE)) {
			ps.setInt(1, entity.getRow());
			ps.setInt(2, entity.getNumber());
			ps.setInt(3, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in update method of SeatDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public void delete(Seat entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_SEAT_DELETE)) {
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in delete method of SeatDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	private Seat buildSeat(ResultSet rs) throws SQLException {
		Seat seat = new Seat();
		seat.setId(rs.getInt("id"));
		seat.setRow(rs.getInt("row"));
		seat.setNumber(rs.getInt("number"));
		return seat;
	}

	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SQLException in close method of SeatDaoImpl class", e);
			}
		}
	}
}
