package ua.nure.lubchenko.st4.entity;

import java.util.Date;

public class Tour {
	private int idTour;
	private String country;
	private String city;
	private String hotel;
	private String hotelType;
	private String tourType;
	private int cost;
	private int peopleNumber;
	private Date fromDate;
	private Date toDate;
	private boolean isHot;

	/**
	 * @return the idTour
	 */
	public int getIdTour() {
		return idTour;
	}

	/**
	 * @param idTour
	 *            the idTour to set
	 */
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 *            the hotel to set
	 */
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the hotelType
	 */
	public String getHotelType() {
		return hotelType;
	}

	/**
	 * @param hotelType
	 *            the hotelType to set
	 */
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	/**
	 * @return the tourType
	 */
	public String getTourType() {
		return tourType;
	}

	/**
	 * @param tourType
	 *            the tourType to set
	 */
	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the peopleNumber
	 */
	public int getPeopleNumber() {
		return peopleNumber;
	}

	/**
	 * @param peopleNumber
	 *            the peopleNumber to set
	 */
	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate
	 *            the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * @return the isHot
	 */
	public boolean getIsHot() {
		return isHot;
	}

	/**
	 * @param isHot
	 *            the isHot to set
	 */
	public void setIsHot(boolean isHot) {
		this.isHot = isHot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tour [idTour=" + idTour + ", country=" + country + ", city=" + city + ", hotel=" + hotel
				+ ", hotelType=" + hotelType + ", tourType=" + tourType + ", cost=" + cost + ", peopleNumber="
				+ peopleNumber + ", fromDate=" + fromDate + ", toDate=" + toDate + ", isHot=" + isHot + "]";
	}
}