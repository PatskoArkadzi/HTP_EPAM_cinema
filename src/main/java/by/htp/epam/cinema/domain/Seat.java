package by.htp.epam.cinema.domain;

/**
 * Class describing Seat entity
 * 
 * @author Arkadzi Patsko
 *
 */
public class Seat extends BaseEntity {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -1644042888154752842L;
	/**
	 * Seat row
	 */
	private int row;
	/**
	 * Seat number
	 */
	private int number;
	/**
	 * Seat state
	 */
	private State state;

	/**
	 * Constructor without parameters
	 */
	private Seat() {
	}

	/**
	 * @return {@link #row}
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return {@link #number}
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return {@link #state}
	 */
	public State getState() {
		return state;
	}

	/**
	 * Sets seat state
	 * 
	 * @param state
	 *            {@link #state}
	 */
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + number;
		result = prime * result + row;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Seat other = (Seat) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (number != other.number)
			return false;
		if (row != other.row)
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seat [id=" + getId() + ", row=" + row + ", number=" + number + ", state=" + state + "]";
	}

	/**
	 * Inner enum for define seat state during choose ones States that can be used
	 * <p>
	 * {@link #FREE}
	 * </p>
	 * <p>
	 * {@link #BOOKED}
	 * </p>
	 * <p>
	 * {@link #OCCUPIED}
	 * </p>
	 * 
	 * @author Arkadzi Patsko
	 *
	 */
	public enum State {

		/**
		 * Seat is free
		 */
		FREE("green"),
		/**
		 * Seat is booked
		 */
		BOOKED("yellow"),
		/**
		 * Seat is occupied
		 */
		OCCUPIED("red");
		/**
		 * The color in which seat should be painted in UI
		 */
		String buttonColor;

		/**
		 * ENUM Constructor
		 * 
		 * @param buttonColor
		 *            {@link #buttonColor}
		 */
		State(String buttonColor) {
			this.buttonColor = buttonColor;
		}

		/**
		 * @return {@link #buttonColor}
		 */
		public String getButtonColor() {
			return buttonColor;
		}
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder newBuilder() {
		return new Seat().new Builder();
	}

	/**
	 * Inner class for build Seat class object
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
			Seat.this.setId(id);
			return this;
		}

		/**
		 * Sets seat row
		 * 
		 * @param row
		 *            {@link #row}
		 * @return Builder class object
		 */
		public Builder setRow(int row) {
			Seat.this.row = row;
			return this;
		}

		/**
		 * Sets seat number
		 * 
		 * @param number
		 *            {@link #number}
		 * @return Builder class object
		 */
		public Builder setNumber(int number) {
			Seat.this.number = number;
			return this;
		}

		/**
		 * Sets seat state
		 * 
		 * @param state
		 *            {@link #state}
		 * @return Builder class object
		 */
		public Builder setState(State state) {
			Seat.this.state = state;
			return this;
		}

		/**
		 * @return ready Seat class object
		 */
		public Seat build() {
			return Seat.this;
		}
	}
}
