package ua.nure.lubchenko.st4.entity;

public class Order {
	private int idUser;
	private int idTour;
	private Status status;
//	private int orderId;
	private String userName;
	private String tourInfo;

//	/**
//	 * @return the orderId
//	 */
//	public int getOrderId() {
//		return orderId;
//	}
//
//	/**
//	 * @param orderId the orderId to set
//	 */
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the tourInfo
	 */
	public String getTourInfo() {
		return tourInfo;
	}

	/**
	 * @param tourInfo the tourInfo to set
	 */
	public void setTourInfo(String tourInfo) {
		this.tourInfo = tourInfo;
	}

	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the idTour
	 */
	public int getIdTour() {
		return idTour;
	}

	/**
	 * @param idTour the idTour to set
	 */
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [idUser=" + idUser + ", idTour=" + idTour + ", status=" + status + "]";
	}


}
