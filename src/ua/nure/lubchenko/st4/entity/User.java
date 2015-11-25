package ua.nure.lubchenko.st4.entity;

public class User {
	private int idUser;
	private String login;
	private String password;
	private String fullName;
	private int idRole;
	private boolean banned;
	private String role;

	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 *            the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the idRole
	 */
	public int getIdRole() {
		return idRole;
	}

	public String getRole() {
		role = Roles.getRole(this).toString();
		return role;
	}

	/**
	 * @param idRole
	 *            the idRole to set
	 */
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the banned
	 */
	public boolean isBanned() {
		return banned;
	}

	/**
	 * @param banned
	 *            the banned to set
	 */
	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + ", fullName=" + fullName
				+ ", idRole=" + idRole + ", banned=" + banned + "]";
	}
}
