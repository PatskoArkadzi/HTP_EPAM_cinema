package by.htp.epam.cinema.domain;

/**
 * Class describing User entity
 * 
 * @author Arkadzi Patsko
 *
 */
public class User extends BaseEntity {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -6390489079397253530L;
	/**
	 * User login
	 */
	private String login;
	/**
	 * User email
	 */
	private String email;
	/**
	 * User password
	 */
	private String password;
	/**
	 * User salt for hashing password
	 */
	private String salt;
	/**
	 * User role id
	 */
	private int role_id;

	/**
	 * Constructor without parameters
	 */
	private User() {
	}

	/**
	 * @return {@link #login}
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return {@link #email}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return {@link #password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets user password
	 * 
	 * @param password
	 *            {@link #password}
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return {@link #salt}
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * Sets user salt
	 * 
	 * @param salt
	 *            {@link #salt}
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return {@link #role_id}
	 */
	public int getRoleId() {
		return role_id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role_id;
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
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
		User other = (User) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role_id != other.role_id)
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "User [id=" + getId() + ", login=" + login + ", email=" + email + ", password=" + password + ", salt="
				+ salt + ", role_id=" + role_id + "]";
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder newBuilder() {
		return new User().new Builder();
	}

	/**
	 * Inner class for build User class object
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
			User.this.setId(id);
			return this;
		}

		/**
		 * Sets login
		 * 
		 * @param login
		 *            {@link #login}
		 * @return Builder class object
		 */
		public Builder setLogin(String login) {
			User.this.login = login;
			return this;
		}

		/**
		 * Sets email
		 * 
		 * @param email
		 *            {@link #email}
		 * @return Builder class object
		 */
		public Builder setEmail(String email) {
			User.this.email = email;
			return this;
		}

		/**
		 * Sets password
		 * 
		 * @param password
		 *            {@link #password}
		 * @return Builder class object
		 */
		public Builder setPassword(String password) {
			User.this.password = password;
			return this;
		}

		/**
		 * Sets salt
		 * 
		 * @param salt
		 *            {@link #salt}
		 * @return Builder class object
		 */
		public Builder setSalt(String salt) {
			User.this.salt = salt;
			return this;
		}

		/**
		 * Sets user role id
		 * 
		 * @param role_id
		 *            {@link #role_id}
		 * @return Builder class object
		 */
		public Builder setRoleId(int role_id) {
			User.this.role_id = role_id;
			return this;
		}

		/**
		 * @return ready User class object
		 */
		public User build() {
			return User.this;
		}
	}
}
