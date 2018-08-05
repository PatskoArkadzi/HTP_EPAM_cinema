package by.htp.epam.cinema.domain;

public class TicketsOrder extends BaseEntity {

	private int orderNumber; // SQL trigger-generated column

	private boolean isPaid;

	private int user_id;

	public TicketsOrder() {
	}

	public TicketsOrder(int id, int orderNumber, boolean isPaid, int user_id) {
		super(id);
		this.orderNumber = orderNumber;
		this.isPaid = isPaid;
		this.user_id = user_id;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + (isPaid ? 1231 : 1237);
		result = prime * result + orderNumber;
		result = prime * result + user_id;
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
		TicketsOrder other = (TicketsOrder) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (isPaid != other.isPaid)
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketsOrder [orderNumber=" + orderNumber + ", isPaid=" + isPaid + ", user_id=" + user_id + "]";
	}

}
