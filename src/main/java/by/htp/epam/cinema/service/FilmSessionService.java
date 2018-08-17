package by.htp.epam.cinema.service;

import java.util.List;

import by.htp.epam.cinema.domain.FilmSession;

public interface FilmSessionService extends Service {

	List<FilmSession> getFilmSessions(int filmId);

}
