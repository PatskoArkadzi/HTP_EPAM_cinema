package by.htp.epam.cinema.domain;

import java.math.BigDecimal;

/**
 * Class describing FilmSession entity
 * 
 * @author Arkadzi Patsko
 *
 */
public class FilmSession extends BaseEntity {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -7160885760512229728L;
	/**
	 * FilmSession name
	 */
	private String date;
	/**
	 * FilmSession time
	 */
	private String time;
	/**
	 * FilmSession ticket price
	 */
	private BigDecimal ticketPrice;
	/**
	 * Film id of this FilmSession
	 */
	private int film_id;

	/**
	 * Constructor without parameters
	 */
	private FilmSession() {
	}

	/**
	 * @return {@link #date}
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return {@link #time}
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @return {@link #ticketPrice}
	 */
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * @return {@link #film_id}
	 */
	public int getFilmId() {
		return film_id;
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

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder newBuilder() {
		return new FilmSession().new Builder();
	}

	/**
	 * Inner class for build FilmSession class object
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
			FilmSession.this.setId(id);
			return this;
		}

		/**
		 * Sets film session date
		 * 
		 * @param date
		 *            {@link #date}
		 * @return Builder class object
		 */
		public Builder setDate(String date) {
			FilmSession.this.date = date;
			return this;
		}

		/**
		 * Sets film session time
		 * 
		 * @param time
		 *            {@link #time}
		 * @return Builder class object
		 */
		public Builder setTime(String time) {
			FilmSession.this.time = time;
			return this;
		}

		/**
		 * Sets film session ticket price
		 * 
		 * @param ticketPrice
		 *            {@link #ticketPrice}
		 * @return Builder class object
		 */
		public Builder setTicketPrice(BigDecimal ticketPrice) {
			FilmSession.this.ticketPrice = ticketPrice;
			return this;
		}

		/**
		 * Sets film id
		 * 
		 * @param film_id
		 *            {@link #film_id}
		 * @return Builder class object
		 */
		public Builder setFilmId(int film_id) {
			FilmSession.this.film_id = film_id;
			return this;
		}

		/**
		 * @return ready FilmSession class object
		 */
		public FilmSession build() {
			return FilmSession.this;
		}
	}
}
