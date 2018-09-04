package by.htp.epam.cinema.domain;

/**
 * Class describing Ticket entity
 * 
 * @author Arkadzi Patsko
 *
 */
public class Ticket extends BaseEntity {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -4113164580477789927L;
	/**
	 * Film session id
	 */
	private int filmSession_id;
	/**
	 * Seat id
	 */
	private int seat_id;
	/**
	 * Order id
	 */
	private int ticketsOrder_id;

	/**
	 * Constructor without parameters
	 */
	private Ticket() {
	}

	/**
	 * @return {@link #filmSession_id}
	 */
	public int getFilmSessionId() {
		return filmSession_id;
	}

	/**
	 * @return {@link #seat_id}
	 */
	public int getSeatId() {
		return seat_id;
	}

	/**
	 * @return {@link #ticketsOrder_id}
	 */
	public int getTicketsOrderId() {
		return ticketsOrder_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + filmSession_id;
		result = prime * result + seat_id;
		result = prime * result + ticketsOrder_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (filmSession_id != other.filmSession_id)
			return false;
		if (seat_id != other.seat_id)
			return false;
		if (ticketsOrder_id != other.ticketsOrder_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + getId() + ", filmSession_id=" + filmSession_id + ", seat_id=" + seat_id
				+ ", ticketsOrder_id=" + ticketsOrder_id + "]";
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder newBuilder() {
		return new Ticket().new Builder();
	}

	/**
	 * Inner class for build Ticket class object
	 * 
	 * @author Arkadzi Patsko
	 *
	 */
	public class Builder {
		/**
		 * Constructor without parameters
		 */
		private Builder() {
		}

		/**
		 * Sets id
		 * 
		 * @param id
		 *            {@link #id}
		 * @return Builder class object
		 */
		public Builder setId(int id) {
			Ticket.this.setId(id);
			return this;
		}

		/**
		 * Sets film session id
		 * 
		 * @param filmSession_id
		 *            {@link #filmSession_id}
		 * @return Builder class object
		 */
		public Builder setFilmSessionId(int filmSession_id) {
			Ticket.this.filmSession_id = filmSession_id;
			return this;
		}

		/**
		 * Sets seat id
		 * 
		 * @param seat_id
		 *            {@link #seat_id}
		 * @return Builder class object
		 */
		public Builder setSeatId(int seat_id) {
			Ticket.this.seat_id = seat_id;
			return this;
		}

		/**
		 * Sets order id
		 * 
		 * @param ticketsOrder_id
		 *            {@link #ticketsOrder_id}
		 * @return Builder class object
		 */
		public Builder setTicketsOrderId(int ticketsOrder_id) {
			Ticket.this.ticketsOrder_id = ticketsOrder_id;
			return this;
		}

		/**
		 * @return ready Ticket class object
		 */
		public Ticket build() {
			return Ticket.this;
		}
	}
}
