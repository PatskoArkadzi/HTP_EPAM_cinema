package by.htp.epam.cinema.domain;

/**
 * Class describing Film entity
 * 
 * @author Arkadzi Patsko
 *
 */
public class Film extends BaseEntity {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -2248408866984238822L;

	/**
	 * Film name
	 */
	private String filmName;

	/**
	 * Film description
	 */
	private String description;

	/**
	 * Film posterUrl
	 */
	private String posterUrl;

	/**
	 * Film youTubeVideoId
	 */
	private String youTubeVideoId;

	/**
	 * Constructor without parameters
	 */
	private Film() {
	}

	/**
	 * @return {@link #filmName}
	 */
	public String getFilmName() {
		return filmName;
	}

	/**
	 * @return {@link #description}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return {@link #posterUrl}
	 */
	public String getPosterUrl() {
		return posterUrl;
	}

	/**
	 * @return {@link #youTubeVideoId}
	 */
	public String getYouTubeVideoId() {
		return youTubeVideoId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (filmName == null) {
			if (other.filmName != null)
				return false;
		} else if (!filmName.equals(other.filmName))
			return false;
		if (posterUrl == null) {
			if (other.posterUrl != null)
				return false;
		} else if (!posterUrl.equals(other.posterUrl))
			return false;
		if (youTubeVideoId == null) {
			if (other.youTubeVideoId != null)
				return false;
		} else if (!youTubeVideoId.equals(other.youTubeVideoId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
		result = prime * result + ((posterUrl == null) ? 0 : posterUrl.hashCode());
		result = prime * result + ((youTubeVideoId == null) ? 0 : youTubeVideoId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Film [id=" + getId() + ", filmName=" + filmName + ", description=" + description + ", posterUrl="
				+ posterUrl + ", youTubeVideoId=" + youTubeVideoId + "]";
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder newBuilder() {
		return new Film().new Builder();
	}

	/**
	 * Inner class for build Film class object
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
			Film.this.setId(id);
			return this;
		}

		/**
		 * Sets film name
		 * 
		 * @param filmName
		 *            {@link #filmName}
		 * @return Builder class object
		 */
		public Builder setFilmName(String filmName) {
			Film.this.filmName = filmName;
			return this;
		}

		/**
		 * Sets film description
		 * 
		 * @param description
		 *            {@link #description}
		 * @return Builder class object
		 */
		public Builder setDescription(String description) {
			Film.this.description = description;
			return this;
		}

		/**
		 * Sets film poster URL.
		 * 
		 * @param posterUrl
		 *            {@link #posterUrl}
		 * @return Builder class object
		 */
		public Builder setPosterUrl(String posterUrl) {
			Film.this.posterUrl = posterUrl;
			return this;
		}

		/**
		 * Sets film youTube video id.
		 * 
		 * @param youTubeVideoId
		 *            {@link #youTubeVideoId}
		 * @return Builder class object
		 */
		public Builder setYouTubeVideoId(String youTubeVideoId) {
			Film.this.youTubeVideoId = youTubeVideoId;
			return this;
		}

		/**
		 * @return ready Film class object
		 */
		public Film build() {
			return Film.this;
		}
	}
}
