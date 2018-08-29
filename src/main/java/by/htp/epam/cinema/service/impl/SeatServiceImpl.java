package by.htp.epam.cinema.service.impl;

import java.util.List;

import by.htp.epam.cinema.db.dao.SeatDao;
import by.htp.epam.cinema.db.dao.TicketsOrderDao;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.Seat.State;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.service.SeatService;
import static by.htp.epam.cinema.db.dao.DaoFactory.CUSTOM_CONNECTION_POOL;
import static by.htp.epam.cinema.db.dao.DaoFactory.getSeatDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.getTicketsOrderDao;

public class SeatServiceImpl implements SeatService {

	private SeatDao seatDao = getSeatDao(CUSTOM_CONNECTION_POOL);
	private TicketsOrderDao ticketsOrderDao = getTicketsOrderDao(CUSTOM_CONNECTION_POOL);

	@Override
	public List<Seat> getSeatsWithState(int filmSessionId) {
		List<Seat> seats = seatDao.readAll();
		for (int i = 0; i < seats.size(); i++) {
			Seat seat = seats.get(i);
			TicketsOrder ticketsOrder = ticketsOrderDao.read(seat.getId(), filmSessionId);
			seats.set(i, initSeatState(seat, ticketsOrder));
		}
		return seats;
	}

	private Seat initSeatState(Seat seat, TicketsOrder ticketsOrder) {
		State state = defineState(ticketsOrder);
		seat.setState(state);
		return seat;
	}

	private State defineState(TicketsOrder ticketsOrder) {
		if (ticketsOrder == null) {
			return State.FREE;
		} else if (ticketsOrder.getIsPaid()) {
			return State.OCCUPIED;
		} else {
			return State.BOOKED;
		}
	}

	@Override
	public boolean isSeatFree(int seatId, int filmSessionId) {
		TicketsOrder ticketsOrder = ticketsOrderDao.read(seatId, filmSessionId);
		State state = defineState(ticketsOrder);
		return state.equals(State.FREE);
	}

	@Override
	public Seat getSeat(int seatId) {
		return seatDao.read(seatId);
	}
}
