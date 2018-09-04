package by.htp.epam.cinema.domain.CompositeEntities;

import java.io.Serializable;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;

/**
 * CompositeTicket class for passing entities to request context
 * 
 * @author Arkadzi Patsko
 *
 */
public class CompositeTicket implements Serializable {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 8309250469553709557L;
	/**
	 * Ticket id
	 */
	private int id;
	/**
	 * Film session
	 */
	private FilmSession filmSession;
	/**
	 * Film
	 */
	private Film film;
	/**
	 * Seat
	 */
	private Seat seat;
	/**
	 * Order
	 */
	private TicketsOrder ticketsOrder;
	/**
	 * User
	 */
	private User user;

	/**
	 * Constructor without parameters
	 */
	public CompositeTicket() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param id
	 *            {@link #id}
	 * @param filmSession
	 *            {@link #filmSession}
	 * @param film
	 *            {@link #film}
	 * @param seat
	 *            {@link #seat}
	 * @param ticketsOrder
	 *            {@link #ticketsOrder}
	 * @param user
	 *            {@link #user}
	 */
	public CompositeTicket(int id, FilmSession filmSession, Film film, Seat seat, TicketsOrder ticketsOrder,
			User user) {
		this.id = id;
		this.filmSession = filmSession;
		this.film = film;
		this.seat = seat;
		this.ticketsOrder = ticketsOrder;
		this.user = user;
	}

	/**
	 * @return {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets ticket id
	 * 
	 * @param id
	 *            {@link #id}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return {@link #filmSession}
	 */
	public FilmSession getFilmSession() {
		return filmSession;
	}

	/**
	 * Sets film session
	 * 
	 * @param filmSession
	 *            {@link #filmSession}
	 */
	public void setFilmSession(FilmSession filmSession) {
		this.filmSession = filmSession;
	}

	/**
	 * @return {@link #seat}
	 */
	public Seat getSeat() {
		return seat;
	}

	/**
	 * Sets seat
	 * 
	 * @param seat
	 *            {@link #seat}
	 */
	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	/**
	 * @return {@link #ticketsOrder}
	 */
	public TicketsOrder getTicketsOrder() {
		return ticketsOrder;
	}

	/**
	 * Sets order
	 * 
	 * @param ticketsOrder
	 *            {@link #ticketsOrder}
	 */
	public void setTicketsOrder(TicketsOrder ticketsOrder) {
		this.ticketsOrder = ticketsOrder;
	}

	/**
	 * @return {@link #film}
	 */
	public Film getFilm() {
		return film;
	}

	/**
	 * Sets film
	 * 
	 * @param film
	 *            {@link #film}
	 */
	public void setFilm(Film film) {
		this.film = film;
	}

	/**
	 * @return {@link #user}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets user
	 * 
	 * @param user
	 *            {@link #user}
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + ((filmSession == null) ? 0 : filmSession.hashCode());
		result = prime * result + id;
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ((ticketsOrder == null) ? 0 : ticketsOrder.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String toString() {
		return "CompositeTicket [id=" + id + ", filmSession=" + filmSession + ", film=" + film + ", seat=" + seat
				+ ", ticketsOrder=" + ticketsOrder + ", user=" + user + "]";
	}
}
