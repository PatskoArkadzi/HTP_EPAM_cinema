package by.htp.epam.cinema.domain;

public class TicketsOrder extends BaseEntity {

	private static final long serialVersionUID = -5147482581752279068L;

	/**
	 * SQL trigger-generated column
	 */
	private int orderNumber;

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

	public boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
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
		return "TicketsOrder [id=" + getId() + ", orderNumber=" + orderNumber + ", isPaid=" + isPaid + ", user_id="
				+ user_id + "]";
	}

	public static Builder newBuilder() {
		return new TicketsOrder().new Builder();
	}

	public class Builder {

		private Builder() {
		}

		public Builder setId(int id) {
			TicketsOrder.this.setId(id);
			return this;
		}

		public Builder setOrderNumber(int orderNumber) {
			TicketsOrder.this.orderNumber = orderNumber;
			return this;
		}

		public Builder setIsPaid(boolean isPaid) {
			TicketsOrder.this.isPaid = isPaid;
			return this;
		}

		public Builder setUserId(int user_id) {
			TicketsOrder.this.user_id = user_id;
			return this;
		}

		public TicketsOrder build() {
			return TicketsOrder.this;
		}
	}
}
