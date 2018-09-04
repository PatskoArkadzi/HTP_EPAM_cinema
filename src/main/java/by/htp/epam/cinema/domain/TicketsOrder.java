package by.htp.epam.cinema.domain;

/**
 * Class describing TicketsOrder entity
 * 
 * @author Arkadzi Patsko
 *
 */
public class TicketsOrder extends BaseEntity {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -5147482581752279068L;

	/**
	 * Order number. SQL trigger-generated column
	 */
	private int orderNumber;
	/**
	 * Order paid status
	 */
	private boolean isPaid;
	/**
	 * User id
	 */
	private int user_id;

	/**
	 * Constructor without parameters
	 */
	private TicketsOrder() {
	}

	/**
	 * @return {@link #orderNumber}
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @return {@link #isPaid}
	 */
	public boolean getIsPaid() {
		return isPaid;
	}

	/**
	 * @return {@link #user_id}
	 */
	public int getUserId() {
		return user_id;
	}

	/**
	 * Sets is order paid or not
	 * 
	 * @param isPaid
	 *            {@link #isPaid}
	 */
	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "TicketsOrder [id=" + getId() + ", orderNumber=" + orderNumber + ", isPaid=" + isPaid + ", user_id="
				+ user_id + "]";
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder newBuilder() {
		return new TicketsOrder().new Builder();
	}

	/**
	 * Inner class for build TicketsOrder class object
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
			TicketsOrder.this.setId(id);
			return this;
		}

		/**
		 * Sets order number
		 * 
		 * @param orderNumber
		 *            {@link #orderNumber}
		 * @return Builder class object
		 */
		public Builder setOrderNumber(int orderNumber) {
			TicketsOrder.this.orderNumber = orderNumber;
			return this;
		}

		/**
		 * Sets is order paid or not
		 * 
		 * @param isPaid
		 *            {@link #isPaid}
		 * @return Builder class object
		 */
		public Builder setIsPaid(boolean isPaid) {
			TicketsOrder.this.isPaid = isPaid;
			return this;
		}

		/**
		 * Sets user id
		 * 
		 * @param user_id
		 *            {@link #user_id}
		 * @return Builder class object
		 */
		public Builder setUserId(int user_id) {
			TicketsOrder.this.user_id = user_id;
			return this;
		}

		/**
		 * @return ready TicketsOrder class object
		 */
		public TicketsOrder build() {
			return TicketsOrder.this;
		}
	}
}
