package by.htp.epam.cinema.domain;

public class Seat extends BaseEntity {

	private int row;

	private int number;

	private State state;

	public enum State {
		FREE("green"), BOOKED("yellow"), OCCUPIED("red");

		String buttonColor;

		State(String buttonColor) {
			this.buttonColor = buttonColor;
		}

		public String getButtonColor() {
			return buttonColor;
		}
	}

	public Seat() {
		super();
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public State getState() {
		return state;
	}

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
		return "Seat [row=" + row + ", number=" + number + ", state=" + state + "]";
	}

}
