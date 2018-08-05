package by.htp.epam.cinema.domain;

public class Genre extends BaseEntity {

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
		return "Genre [genreName=" + genreName + "]";
	}

}
