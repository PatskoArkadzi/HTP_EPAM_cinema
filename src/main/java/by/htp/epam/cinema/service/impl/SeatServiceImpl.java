package by.htp.epam.cinema.service.impl;

import java.util.List;

import by.htp.epam.cinema.db.dao.SeatDao;
import by.htp.epam.cinema.db.dao.TicketsOrderDao;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.Seat.State;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.service.SeatService;

/**
 * Class implementing SeatService interface
 * 
 * @author Arkadzi Patsko
 *
 */
public class SeatServiceImpl implements SeatService {
	/**
	 * seatDao
	 */
	private SeatDao seatDao;
	/**
	 * ticketsOrderDao
	 */
	private TicketsOrderDao ticketsOrderDao;

	/**
	 * Constructor with parameters
	 * 
	 * @param seatDao
	 *            {@link #seatDao}
	 * @param ticketsOrderDao
	 *            {@link #ticketsOrderDao}
	 */
	public SeatServiceImpl(SeatDao seatDao, TicketsOrderDao ticketsOrderDao) {
		this.seatDao = seatDao;
		this.ticketsOrderDao = ticketsOrderDao;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSeatFree(int seatId, int filmSessionId) {
		TicketsOrder ticketsOrder = ticketsOrderDao.read(seatId, filmSessionId);
		State state = defineState(ticketsOrder);
		return state.equals(State.FREE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Seat getSeat(int seatId) {
		return seatDao.read(seatId);
	}

	/**
	 * initializes seat state
	 * 
	 * @param seat
	 *            initializing seat
	 * @param ticketsOrder
	 *            order for checking it's paid or not
	 * @return initialized seat
	 */
	private Seat initSeatState(Seat seat, TicketsOrder ticketsOrder) {
		State state = defineState(ticketsOrder);
		seat.setState(state);
		return seat;
	}

	/**
	 * define seat state
	 * 
	 * @param ticketsOrder
	 *            order for checking it's paid or not
	 * @return seat state
	 */
	private State defineState(TicketsOrder ticketsOrder) {
		if (ticketsOrder == null) {
			return State.FREE;
		} else if (ticketsOrder.getIsPaid()) {
			return State.OCCUPIED;
		} else {
			return State.BOOKED;
		}
	}
}
