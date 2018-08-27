package by.htp.epam.cinema.domain;

public class Genre extends BaseEntity {

	private static final long serialVersionUID = -1045134943121533438L;
	private String genreName;

	public Genre() {
	}

	public Genre(int id, String genreName) {
		super(id);
		this.genreName = genreName;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
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

	public static Builder newBuilder() {
		return new Genre().new Builder();
	}

	public class Builder {
		private Builder() {
		}

		public Builder setId(int id) {
			Genre.this.setId(id);
			return this;
		}

		public Builder setGenreName(String genreName) {
			Genre.this.genreName = genreName;
			return this;
		}

		public Genre build() {
			return Genre.this;
		}
	}
}
