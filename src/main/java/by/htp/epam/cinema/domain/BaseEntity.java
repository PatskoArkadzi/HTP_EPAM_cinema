package by.htp.epam.cinema.domain;

import java.io.Serializable;

/**
 * Class parent for all entities
 * 
 * @author Arkadzi Patsko
 *
 */
public class BaseEntity implements Serializable {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -294442612361371280L;

	/**
	 * Common ID for entities
	 */
	private int id;

	/**
	 * Constructor with
	 * 
	 * @param id
	 *            {@link #id}
	 */
	public BaseEntity(int id) {
		this.id = id;
	}

	/**
	 * Constructor without parameters
	 */
	public BaseEntity() {
	}

	/**
	 * @return {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id
	 *            {@link #id}
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		BaseEntity other = (BaseEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + "]";
	}

}
