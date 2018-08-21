package by.htp.epam.cinema.service;

import java.util.List;

import by.htp.epam.cinema.domain.Seat;

public interface SeatService extends Service {

	List<Seat> getSeatsWithState(int filmSessionId);

}
