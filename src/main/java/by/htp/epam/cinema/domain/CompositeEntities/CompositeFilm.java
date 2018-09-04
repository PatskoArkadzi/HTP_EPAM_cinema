package by.htp.epam.cinema.domain.CompositeEntities;

import java.io.Serializable;
import java.util.List;

import by.htp.epam.cinema.domain.Genre;

/**
 * CompositeFilm class for passing entities to request context
 * 
 * @author Arkadzi Patsko
 *
 */
public class CompositeFilm implements Serializable {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 8389696005488781866L;
	/**
	 * Film id
	 */
	private int id;
	/**
	 * Film filmName
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
	 * Film genres
	 */
	private List<Genre> genres;

	/**
	 * Constructor without parameters
	 */
	public CompositeFilm() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param id
	 *            {@link #id}
	 * @param filmName
	 *            {@link #filmName}
	 * @param description
	 *            {@link #description}
	 * @param posterUrl
	 *            {@link #posterUrl}
	 * @param id
	 *            {@link #youTubeVideoId}
	 * @param genres
	 *            {@link #genres}
	 */
	public CompositeFilm(int id, String filmName, String description, String posterUrl, String youTubeVideoId,
			List<Genre> genres) {
		this.id = id;
		this.filmName = filmName;
		this.description = description;
		this.posterUrl = posterUrl;
		this.youTubeVideoId = youTubeVideoId;
		this.genres = genres;
	}

	/**
	 * @return {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets film id
	 * 
	 * @param id
	 *            {@link #id}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return {@link #filmName}
	 */
	public String getFilmName() {
		return filmName;
	}

	/**
	 * Sets film name
	 * 
	 * @param filmName
	 *            {@link #filmName}
	 */
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	/**
	 * @return {@link #description}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets film description
	 * 
	 * @param description
	 *            {@link #description}
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return {@link #posterUrl}
	 */
	public String getPosterUrl() {
		return posterUrl;
	}

	/**
	 * Sets film poster URL
	 * 
	 * @param posterUrl
	 *            {@link #posterUrl}
	 */
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	/**
	 * @return {@link #youTubeVideoId}
	 */
	public String getYouTubeVideoId() {
		return youTubeVideoId;
	}

	/**
	 * Sets film YouTube video id
	 * 
	 * @param youTubeVideoId
	 *            {@link #youTubeVideoId}
	 */
	public void setYouTubeVideoId(String youTubeVideoId) {
		this.youTubeVideoId = youTubeVideoId;
	}

	/**
	 * @return {@link #genres}
	 */
	public List<Genre> getGenres() {
		return genres;
	}

	/**
	 * Sets film genres
	 * 
	 * @param genres
	 *            {@link #genres}
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + id;
		result = prime * result + ((posterUrl == null) ? 0 : posterUrl.hashCode());
		result = prime * result + ((youTubeVideoId == null) ? 0 : youTubeVideoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeFilm other = (CompositeFilm) obj;
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
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id != other.id)
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
		return "CompositeFilm [id=" + id + ", filmName=" + filmName + ", description=" + description + ", posterUrl="
				+ posterUrl + ", youTubeVideoId=" + youTubeVideoId + ", genres=" + genres + "]";
	}

}
