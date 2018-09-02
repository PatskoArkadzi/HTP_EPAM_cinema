package by.htp.epam.cinema.domain.CompositeEntities;

import java.io.Serializable;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.TicketsOrder;

public class CompositeTicket implements Serializable {

	private static final long serialVersionUID = 8309250469553709557L;

	private int id;

	private FilmSession filmSession;

	private Film film;

	private Seat seat;

	private TicketsOrder ticketsOrder;

	public CompositeTicket() {
	}

	public CompositeTicket(int id, FilmSession filmSession, Film film, Seat seat, TicketsOrder ticketsOrder) {
		super();
		this.id = id;
		this.filmSession = filmSession;
		this.film = film;
		this.seat = seat;
		this.ticketsOrder = ticketsOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FilmSession getFilmSession() {
		return filmSession;
	}

	public void setFilmSession(FilmSession filmSession) {
		this.filmSession = filmSession;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public TicketsOrder getTicketsOrder() {
		return ticketsOrder;
	}

	public void setTicketsOrder(TicketsOrder ticketsOrder) {
		this.ticketsOrder = ticketsOrder;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + ((filmSession == null) ? 0 : filmSession.hashCode());
		result = prime * result + id;
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ((ticketsOrder == null) ? 0 : ticketsOrder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeTicket other = (CompositeTicket) obj;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (filmSession == null) {
			if (other.filmSession != null)
				return false;
		} else if (!filmSession.equals(other.filmSession))
			return false;
		if (id != other.id)
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (ticketsOrder == null) {
			if (other.ticketsOrder != null)
				return false;
		} else if (!ticketsOrder.equals(other.ticketsOrder))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompositeTicket [id=" + id + ", filmSession=" + filmSession + ", film=" + film + ", seat=" + seat
				+ ", ticketsOrder=" + ticketsOrder + "]";
	}
}
