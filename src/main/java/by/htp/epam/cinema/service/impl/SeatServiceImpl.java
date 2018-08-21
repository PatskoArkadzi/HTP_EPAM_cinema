package by.htp.epam.cinema.service.impl;

import java.util.List;

import by.htp.epam.cinema.db.dao.SeatDao;
import by.htp.epam.cinema.db.dao.TicketsOrderDao;
import by.htp.epam.cinema.db.dao.impl.SeatDaoImpl;
import by.htp.epam.cinema.db.dao.impl.TicketsOrderDaoImpl;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.service.SeatService;

public class SeatServiceImpl implements SeatService {
	private SeatDao seatDao = new SeatDaoImpl();
	private TicketsOrderDao ticketsOrderDao = new TicketsOrderDaoImpl();

	@Override
	public List<Seat> getSeatsWithState(int filmSessionId) {
		List<Seat> seats = seatDao.readAll();
		for (int i = 0; i < seats.size(); i++) {
			Seat seat = seats.get(i);
			TicketsOrder ticketsOrder = ticketsOrderDao.read(seat.getId(), filmSessionId);
			seats.set(i, initState(seat, ticketsOrder));
		}
		return seats;
	}

	private Seat initState(Seat seat, TicketsOrder ticketsOrder) {
		if (ticketsOrder == null) {
			seat.setState(Seat.State.FREE);
		} else if (ticketsOrder.getIsPaid()) {
			seat.setState(Seat.State.OCCUPIED);
		} else {
			seat.setState(Seat.State.BOOKED);
		}
		return seat;
	}
}
