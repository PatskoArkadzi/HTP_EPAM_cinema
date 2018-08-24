package by.htp.epam.cinema.db.dao;

import java.util.List;

import by.htp.epam.cinema.domain.Ticket;

public interface TicketDao extends BaseDao<Ticket> {

	List<Ticket> readAllWhereOrderIdPresent(int orderId);

	// List<Ticket> readAll(String property, Object value);

}
