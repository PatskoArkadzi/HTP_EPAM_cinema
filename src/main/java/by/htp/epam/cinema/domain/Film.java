package by.htp.epam.cinema.domain;

public class Film extends BaseEntity {

	private String filmName;

	private String description;

	private String posterUrl;

	private String youTubeVideoId;

	public Film() {
	}

	public Film(int id, String filmName, String description, String posterUrl, String youTubeVideoId) {
		super(id);
		this.filmName = filmName;
		this.description = description;
		this.posterUrl = posterUrl;
		this.youTubeVideoId = youTubeVideoId;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public String getTrailerUrl() {
		return youTubeVideoId;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.youTubeVideoId = trailerUrl;
	}

	public String getYouTubeVideoId() {
		return youTubeVideoId;
	}

	public void setYouTubeVideoId(String youTubeVideoId) {
		this.youTubeVideoId = youTubeVideoId;
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
	public String toString() {
		return "Film [filmName=" + filmName + ", description=" + description + ", posterUrl=" + posterUrl
				+ ", youTubeVideoId=" + youTubeVideoId + "]";
	}

}
