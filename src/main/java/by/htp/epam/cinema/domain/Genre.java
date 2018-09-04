package by.htp.epam.cinema.domain;

/**
 * Class describing Genre entity
 * 
 * @author Arkadzi Patsko
 *
 */
public class Genre extends BaseEntity {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -1045134943121533438L;
	/**
	 * Genre name
	 */
	private String genreName;

	/**
	 * Constructor without parameters
	 */
	private Genre() {
	}

	/**
	 * @return {@link #genreName}
	 */
	public String getGenreName() {
		return genreName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((genreName == null) ? 0 : genreName.hashCode());
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
		Genre other = (Genre) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genre [id=" + getId() + ", genreName=" + genreName + "]";
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder newBuilder() {
		return new Genre().new Builder();
	}

	/**
	 * Inner class for build Genre class object
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
		 * Sets genre id
		 * 
		 * @param id
		 *            {@link #id}
		 * @return Builder class object
		 */
		public Builder setId(int id) {
			Genre.this.setId(id);
			return this;
		}

		/**
		 * Sets genre name
		 * 
		 * @param genreName
		 *            {@link #genreName}
		 * @return Builder class object
		 */
		public Builder setGenreName(String genreName) {
			Genre.this.genreName = genreName;
			return this;
		}

		/**
		 * @return ready Genre class object
		 */
		public Genre build() {
			return Genre.this;
		}
	}
}
