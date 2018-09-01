package by.htp.epam.cinema.domain;

public class Ticket extends BaseEntity {

	private static final long serialVersionUID = -4113164580477789927L;

	private int filmSession_id;

	private int seat_id;

	private int ticketsOrder_id;

	public Ticket() {
	}

	public Ticket(int id, int filmSession_id, int seat_id, int ticketsOrder_id) {
		super(id);
		this.filmSession_id = filmSession_id;
		this.seat_id = seat_id;
		this.ticketsOrder_id = ticketsOrder_id;
	}

	public int getFilmSessionId() {
		return filmSession_id;
	}

	public void setFilmSessionId(int filmSession_id) {
		this.filmSession_id = filmSession_id;
	}

	public int getSeatId() {
		return seat_id;
	}

	public void setSeatId(int seat_id) {
		this.seat_id = seat_id;
	}

	public int getTicketsOrderId() {
		return ticketsOrder_id;
	}

	public void setTicketsOrderId(int ticketsOrder_id) {
		this.ticketsOrder_id = ticketsOrder_id;
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

	public static Builder newBuilder() {
		return new Ticket().new Builder();
	}

	public class Builder {

		private Builder() {
		}

		public Builder setId(int id) {
			Ticket.this.setId(id);
			return this;
		}

		public Builder setFilmSessionId(int filmSession_id) {
			Ticket.this.filmSession_id = filmSession_id;
			return this;
		}

		public Builder setSeatId(int seat_id) {
			Ticket.this.seat_id = seat_id;
			return this;
		}

		public Builder setTicketsOrderId(int ticketsOrder_id) {
			Ticket.this.ticketsOrder_id = ticketsOrder_id;
			return this;
		}

		public Ticket build() {
			return Ticket.this;
		}
	}
}
