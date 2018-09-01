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

import by.htp.epam.cinema.db.dao.AbstractDao;
import by.htp.epam.cinema.db.dao.TicketDao;
import by.htp.epam.cinema.domain.Ticket;

public class TicketDaoImpl extends AbstractDao implements TicketDao {

	private static Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);

	private static final String SQL_QUERY_TICKET_CREATE = "INSERT INTO `cinema_v2.0`.`tickets` (`session_id`, `seat_id`, `order_id`) VALUES (?,?,?);";
	private static final String SQL_QUERY_TICKET_READ = "SELECT `id`, `session_id`, `seat_id`, `order_id` FROM `cinema_v2.0`.`tickets` WHERE  `id`=?;";
	private static final String SQL_QUERY_TICKET_READ_ALL = "SELECT `id`, `session_id`, `seat_id`, `order_id` FROM `cinema_v2.0`.`tickets`;";
	private static final String SQL_QUERY_TICKET_READ_ALL_BY_ORDER_ID = "SELECT `id`, `session_id`, `seat_id`, `order_id` FROM `cinema_v2.0`.`tickets` WHERE `order_id`=?;";
	private static final String SQL_QUERY_TICKET_READ_ALL_BY_FILMSESSION_ID = "SELECT `id`, `session_id`, `seat_id`, `order_id` FROM `cinema_v2.0`.`tickets` WHERE `session_id`=?;";
	private static final String SQL_QUERY_TICKET_UPDATE = "UPDATE `cinema_v2.0`.`tickets` SET `session_id`=?, `seat_id`=?, `order_id`=? WHERE  `id`=?;";
	private static final String SQL_QUERY_TICKET_DELETE = "DELETE FROM `cinema_v2.0`.`tickets` WHERE  `id`=?;";

	@Override
	public void create(Ticket entity) {
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_CREATE)) {
			ps.setInt(1, entity.getFilmSessionId());
			ps.setInt(2, entity.getSeatId());
			ps.setInt(3, entity.getTicketsOrderId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in create method of TicketDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
		}
	}

	@Override
	public Ticket read(int id) {
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildTicket(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of TicketDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public List<Ticket> readAll() {
		List<Ticket> tickets = null;
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (Statement ps = con.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_TICKET_READ_ALL);
			tickets = new ArrayList<>();
			while (rs.next()) {
				tickets.add(buildTicket(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of TicketDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return tickets;
	}

	@Override
	public List<Ticket> readAllWhereOrderIdPresent(int orderId) {
		List<Ticket> tickets = null;
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_READ_ALL_BY_ORDER_ID)) {
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			tickets = new ArrayList<>();
			while (rs.next()) {
				tickets.add(buildTicket(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of TicketDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return tickets;
	}

	@Override
	public List<Ticket> readAllWhereFilmSessionIdPresent(int filmSessionId) {
		List<Ticket> tickets = null;
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_READ_ALL_BY_FILMSESSION_ID)) {
			ps.setInt(1, filmSessionId);
			rs = ps.executeQuery();
			tickets = new ArrayList<>();
			while (rs.next()) {
				tickets.add(buildTicket(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of TicketDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			close(rs);
		}
		return tickets;
	}

	@Override
	public void update(Ticket entity) {
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_UPDATE)) {
			ps.setInt(1, entity.getFilmSessionId());
			ps.setInt(2, entity.getSeatId());
			ps.setInt(3, entity.getTicketsOrderId());
			ps.setInt(4, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in update method of TicketDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
		}
	}

	@Override
	public void delete(int entityId) {
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_DELETE)) {
			ps.setInt(1, entityId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in delete method of TicketDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
		}
	}

	private Ticket buildTicket(ResultSet rs) throws SQLException {
		return Ticket.newBuilder().setId(rs.getInt("id")).setFilmSessionId(rs.getInt("session_id"))
				.setSeatId(rs.getInt("seat_id")).setTicketsOrderId(rs.getInt("order_id")).build();
	}
}
