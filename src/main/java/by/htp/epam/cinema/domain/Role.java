package by.htp.epam.cinema.domain;

public class Role extends BaseEntity {

	private static final long serialVersionUID = 5032248738042699962L;
	private String roleName;

	public Role() {
	}

	public Role(int id, String roleName) {
		super(id);
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public static Builder newBuilder() {
		return new Role().new Builder();
	}

	public class Builder {
		private Builder() {
		}

		public Builder setId(int id) {
			Role.this.setId(id);
			return this;
		}

		public Builder setRoleName(String roleName) {
			Role.this.roleName = roleName;
			return this;
		}

		public Role build() {
			return Role.this;
		}
	}
}
