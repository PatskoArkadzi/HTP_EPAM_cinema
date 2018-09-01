package by.htp.epam.cinema.db.dao;

import java.util.List;

import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;

public interface FilmSessionDao extends BaseDao<FilmSession> {

	List<FilmSession> readAll(int filmId);

	List<FilmSession> readAllWhereSeatNotFree(Seat seat);

	FilmSession readByDateAndTime(String date, String time);
}
