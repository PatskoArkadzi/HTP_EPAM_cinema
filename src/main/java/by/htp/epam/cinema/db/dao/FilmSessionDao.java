package by.htp.epam.cinema.db.dao;

import java.util.List;
import java.util.Map;

import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;


public interface FilmSessionDao extends BaseDao<FilmSession> {

//	List<FilmSession> readAllWhereEq(Map<String,Object> map);

//	List<FilmSession> readAllWhereEq(String property, Object value);

	List<FilmSession> readAllWhereSeatNotFree(Seat seat);
}
