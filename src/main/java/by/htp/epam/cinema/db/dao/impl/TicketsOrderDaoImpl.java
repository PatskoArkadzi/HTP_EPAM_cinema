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

import by.htp.epam.cinema.db.dao.TicketsOrderDao;
import by.htp.epam.cinema.db.pool.ConnectionPool;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;

public class TicketsOrderDaoImpl implements TicketsOrderDao {

	private static Logger logger = LoggerFactory.getLogger(TicketsOrderDaoImpl.class);

	private static final String SQL_QUERY_TICKETS_ORDER_CREATE = "INSERT INTO `cinema_v2.0`.`orders` (`user_id`, `isPaid`) VALUES (?,?);";
	private static final String SQL_QUERY_TICKETS_ORDER_READ = "SELECT `id`, `orderNumber`, `user_id`, `isPaid` FROM `cinema_v2.0`.`orders` WHERE  `id`=?;";
	private static final String SQL_QUERY_TICKETS_ORDER_READ_NON_PAID_BY_USER = "SELECT `id`, `orderNumber`, `user_id`, `isPaid` FROM `cinema_v2.0`.`orders` WHERE  `user_id`=? AND isPaid=0;";
	private static final String SQL_QUERY_TICKETS_ORDER_READ_BY_SEAT_AND_FILMSESSION = "SELECT o.`id`, o.`orderNumber`, o.`user_id`, o.`isPaid` FROM `cinema_v2.0`.`orders` o "
			+ "INNER JOIN `cinema_v2.0`.`tickets` t ON o.`id`=t.`order_id` WHERE t.`seat_id`=? AND t.`session_id`=?";
	private static final String SQL_QUERY_TICKETS_ORDER_READ_ALL = "SELECT `id`, `orderNumber`, `user_id`, `isPaid` FROM `cinema_v2.0`.`orders`;";
	private static final String SQL_QUERY_TICKETS_ORDER_UPDATE = "UPDATE `cinema_v2.0`.`orders` SET `user_id`='?, `isPaid`=? WHERE  `id`=?;";
	private static final String SQL_QUERY_TICKETS_ORDER_DELETE = "DELETE FROM `cinema_v2.0`.`orders` WHERE  `id`=?;";

	@Override
	public void create(TicketsOrder entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKETS_ORDER_CREATE)) {
			ps.setInt(1, entity.getUser_id());
			ps.setBoolean(2, entity.isPaid());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in create method of TicketsOrderDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public TicketsOrder read(int id) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKETS_ORDER_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildTicketsOrder(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of TicketsOrderDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public TicketsOrder read(User user) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKETS_ORDER_READ_NON_PAID_BY_USER)) {
			ps.setInt(1, user.getId());
			rs = ps.executeQuery();
			if (rs.next())
				return buildTicketsOrder(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of TicketsOrderDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public TicketsOrder read(Seat seat, FilmSession filmSession) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKETS_ORDER_READ_BY_SEAT_AND_FILMSESSION)) {
			ps.setInt(1, seat.getId());
			ps.setInt(2, filmSession.getId());
			rs = ps.executeQuery();
			if (rs.next())
				return buildTicketsOrder(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of TicketsOrderDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public List<TicketsOrder> readAll() {
		List<TicketsOrder> orders = null;
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (Statement ps = con.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_TICKETS_ORDER_READ_ALL);
			orders = new ArrayList<>();
			while (rs.next()) {
				orders.add(buildTicketsOrder(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of TicketsOrderDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return orders;
	}

	@Override
	public void update(TicketsOrder entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKETS_ORDER_UPDATE)) {
			ps.setInt(1, entity.getUser_id());
			ps.setBoolean(2, entity.isPaid());
			ps.setInt(3, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in update method of TicketsOrderDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public void delete(TicketsOrder entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKETS_ORDER_DELETE)) {
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in delete method of TicketsOrderDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	private TicketsOrder buildTicketsOrder(ResultSet rs) throws SQLException {
		TicketsOrder ticketsOrder = new TicketsOrder();
		ticketsOrder.setId(rs.getInt("id"));
		ticketsOrder.setOrderNumber(rs.getInt("orderNumber"));
		ticketsOrder.setUser_id(rs.getInt("user_id"));
		ticketsOrder.setPaid(rs.getBoolean("isPaid"));
		return ticketsOrder;
	}

	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SQLException in close method of TicketsOrderDaoImpl class", e);
			}
		}
	}

}
