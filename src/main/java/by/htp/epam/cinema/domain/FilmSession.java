package by.htp.epam.cinema.domain;

import java.math.BigDecimal;

public class FilmSession extends BaseEntity {

	private static final long serialVersionUID = -7160885760512229728L;

	private String date;

	private String time;

	private BigDecimal ticketPrice;

	private int film_id;

	public FilmSession() {
	}

	public FilmSession(int id, String date, String time, BigDecimal ticketPrice, int film_id) {
		super(id);
		this.date = date;
		this.time = time;
		this.ticketPrice = ticketPrice;
		this.film_id = film_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + film_id;
		result = prime * result + ((ticketPrice == null) ? 0 : ticketPrice.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		FilmSession other = (FilmSession) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (film_id != other.film_id)
			return false;
		if (ticketPrice == null) {
			if (other.ticketPrice != null)
				return false;
		} else if (!ticketPrice.equals(other.ticketPrice))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FilmSession [id=" + getId() + ", date=" + date + ", time=" + time + ", ticketPrice=" + ticketPrice
				+ ", film_id=" + film_id + "]";
	}

	public static Builder newBuilder() {
		return new FilmSession().new Builder();
	}

	public class Builder {
		private Builder() {
		}

		public Builder setId(int id) {
			FilmSession.this.setId(id);
			return this;
		}

		public Builder setDate(String date) {
			FilmSession.this.date = date;
			return this;
		}

		public Builder setTime(String time) {
			FilmSession.this.time = time;
			return this;
		}

		public Builder setTicketPrice(BigDecimal ticketPrice) {
			FilmSession.this.ticketPrice = ticketPrice;
			return this;
		}

		public Builder setFilm_id(int film_id) {
			FilmSession.this.film_id = film_id;
			return this;
		}

		public FilmSession build() {
			return FilmSession.this;
		}
	}
}
