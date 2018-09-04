package by.htp.epam.cinema.domain;

/**
 * Class describing Role entity
 * 
 * @author Arkadzi Patsko
 *
 */
public class Role extends BaseEntity {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 5032248738042699962L;
	/**
	 * Role name
	 */
	private String roleName;

	/**
	 * Constructor without parameters
	 */
	private Role() {
	}

	/**
	 * @return {@link #roleName}
	 */
	public String getRoleName() {
		return roleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Role other = (Role) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [id=" + getId() + ", roleName=" + roleName + "]";
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder newBuilder() {
		return new Role().new Builder();
	}

	/**
	 * Inner class for build Role class object
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
			Role.this.setId(id);
			return this;
		}

		/**
		 * Sets role name
		 * 
		 * @param roleName
		 *            {@link #roleName}
		 * @return Builder class object
		 */
		public Builder setRoleName(String roleName) {
			Role.this.roleName = roleName;
			return this;
		}

		/**
		 * @return ready Role class object
		 */
		public Role build() {
			return Role.this;
		}
	}
}
