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

import by.htp.epam.cinema.db.dao.TicketDao;
import by.htp.epam.cinema.db.pool.ConnectionPool;
import by.htp.epam.cinema.domain.Ticket;

public class TicketDaoImpl implements TicketDao {

	private static Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);

	private final String SQL_QUERY_TICKET_CREATE = "INSERT INTO `cinema_v2.0`.`tickets` (`session_id`, `seat_id`, `order_id`) VALUES (?,?,?);";
	private final String SQL_QUERY_TICKET_READ = "SELECT `id`, `session_id`, `seat_id`, `order_id` FROM `cinema_v2.0`.`tickets` WHERE  `id`=?;";
	private final String SQL_QUERY_TICKET_READ_ALL = "SELECT `id`, `session_id`, `seat_id`, `order_id` FROM `cinema_v2.0`.`tickets`;";
	private final String SQL_QUERY_TICKET_UPDATE = "UPDATE `cinema_v2.0`.`tickets` SET `session_id`=?, `seat_id`=?, `order_id`=? WHERE  `id`=?;";
	private final String SQL_QUERY_TICKET_DELETE = "DELETE FROM `cinema_v2.0`.`tickets` WHERE  `id`=?;";
	

	@Override
	public void create(Ticket entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_CREATE)) {
			ps.setInt(1, entity.getFilmSession_id());
			ps.setInt(2, entity.getSeat_id());
			ps.setInt(3, entity.getTicketsOrder_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in create method of TicketDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public Ticket read(int id) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildTicket(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of TicketDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public List<Ticket> readAll() {
		List<Ticket> tickets = null;
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (Statement ps = con.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_TICKET_READ_ALL);
			tickets = new ArrayList<>();
			while (rs.next()) {
				tickets.add(buildTicket(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of TicketDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return tickets;
	}

	@Override
	public void update(Ticket entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_UPDATE)) {
			ps.setInt(1, entity.getFilmSession_id());
			ps.setInt(2, entity.getSeat_id());
			ps.setInt(3, entity.getTicketsOrder_id());
			ps.setInt(4, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in update method of TicketDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public void delete(Ticket entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_TICKET_DELETE)) {
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in delete method of TicketDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	private Ticket buildTicket(ResultSet rs) throws SQLException {
		Ticket ticket = new Ticket();
		ticket.setId(rs.getInt("id"));
		ticket.setFilmSession_id(rs.getInt("session_id"));
		ticket.setSeat_id(rs.getInt("seat_id"));
		ticket.setTicketsOrder_id(rs.getInt("order_id"));
		return ticket;
	}

	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SQLException in close method of TicketDaoImpl class", e);
			}
		}
	}
}