package by.htp.epam.cinema.domain;

public class User extends BaseEntity {

	private static final long serialVersionUID = -6390489079397253530L;

	private String login;

	private String email;

	private String password;

	private String salt;

	private int role_id;

	public User() {
	}

	public User(int id, String login, String email, String password, String salt, int role_id) {
		super(id);
		this.login = login;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.role_id = role_id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getRoleId() {
		return role_id;
	}

	public void setRoleId(int role_id) {
		this.role_id = role_id;
	}

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

	@Override
	public String toString() {
		return "User [id=" + getId() + ", login=" + login + ", email=" + email + ", password=" + password + ", salt="
				+ salt + ", role_id=" + role_id + "]";
	}

	public static Builder newBuilder() {
		return new User().new Builder();
	}

	public class Builder {
		private Builder() {
		}

		public Builder setId(int id) {
			User.this.setId(id);
			return this;
		}

		public Builder setLogin(String login) {
			User.this.login = login;
			return this;
		}

		public Builder setEmail(String email) {
			User.this.email = email;
			return this;
		}

		public Builder setPassword(String password) {
			User.this.password = password;
			return this;
		}

		public Builder setSalt(String salt) {
			User.this.salt = salt;
			return this;
		}

		public Builder setRoleId(int role_id) {
			User.this.role_id = role_id;
			return this;
		}

		public User build() {
			return User.this;
		}
	}
}
