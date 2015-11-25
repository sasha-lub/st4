package ua.nure.lubchenko.st4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.nure.lubchenko.st4.db.DBManager;
import ua.nure.lubchenko.st4.db.Fields;
import ua.nure.lubchenko.st4.entity.Tour;

public class TourDAO {

	Connection connection;

	public TourDAO() {
		DBManager dbm = DBManager.getInstance();
		try {
			connection = dbm.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addTour(Tour tour) {
		try {
			PreparedStatement pstm = connection
					.prepareStatement("INSERT INTO tours VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			int k = 1;
			pstm.setString(k++, tour.getCountry());
			pstm.setString(k++, tour.getCity());
			pstm.setString(k++, tour.getHotel());
			pstm.setString(k++, tour.getTourType());
			pstm.setString(k++, tour.getHotelType());
			pstm.setDate(k++, convertJavaDateToSqlDate(tour.getFromDate()));
			pstm.setDate(k++, convertJavaDateToSqlDate(tour.getToDate()));
			pstm.setInt(k++, tour.getCost());
			pstm.setInt(k++, tour.getPeopleNumber());
			pstm.setBoolean(k++, tour.getIsHot());
			pstm.execute();
			getAllTours();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editTour(Tour tour) {
		try {
			PreparedStatement pstm = connection.prepareStatement(
					"UPDATE tours SET country=?, city=?, hotel=?, type_trip=?, type_hotel=?, from_date=?,"
							+ "to_date=?, cost=?, people_number=?, hot=? WHERE id_tour=?");

			int k = 1;
			pstm.setString(k++, tour.getCountry());
			pstm.setString(k++, tour.getCity());
			pstm.setString(k++, tour.getHotel());
			pstm.setString(k++, tour.getTourType());
			pstm.setString(k++, tour.getHotelType());
			pstm.setDate(k++, convertJavaDateToSqlDate(tour.getFromDate()));
			pstm.setDate(k++, convertJavaDateToSqlDate(tour.getToDate()));
			pstm.setInt(k++, tour.getCost());
			pstm.setInt(k++, tour.getPeopleNumber());
			pstm.setBoolean(k++, tour.getIsHot());
			pstm.setInt(k++, tour.getIdTour());
			pstm.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Tour> getAllTours() {
		List<Tour> tours = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement("SELECT DISTINCT "
					+ "id_tour, country, city, hotel, type_trip, type_hotel, from_date, to_date, cost, people_number, hot "
					+ "FROM tours LEFT JOIN orders ON tours.id_tour = orders.id_trip "
					+ "WHERE ((status is NULL) " 
					+ "OR (status = 'CANCELED')) " 
					+ "ORDER BY tours.hot DESC");

			stm.executeQuery();

			rs = stm.getResultSet();
			while (rs.next()) {
				tours.add(extractTour(rs));
			}
			System.out.println(tours);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(stm);
		}
		return tours;
	}

	public List<Tour> searchByType(String type) {
		List<Tour> tours = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			pstm = connection.prepareStatement("SELECT DISTINCT "
					+ "id_tour, country, city, hotel, type_trip, type_hotel, from_date, to_date, cost, people_number, hot "
					+ "FROM tours LEFT JOIN orders ON tours.id_tour = orders.id_trip "
					+ "WHERE (((status is NULL) " 
					+ "OR (status = 'CANCELED')) AND type_trip = ?) " 
					+ "ORDER BY tours.hot DESC");
			pstm.setString(1, type);
			pstm.execute();
			rs = pstm.getResultSet();
			while (rs.next()) {
				tours.add(extractTour(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		return tours;
	}

	public List<Tour> searchByHotelType(String hotelType) {
		List<Tour> tours = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			System.out.println("dao says :  "+hotelType);
			pstm = connection.prepareStatement("SELECT DISTINCT "
					+ "id_tour, country, city, hotel, type_trip, type_hotel, from_date, to_date, cost, people_number, hot "
					+ "FROM tours LEFT JOIN orders ON tours.id_tour = orders.id_trip "
					+ "WHERE (((status is NULL) " 
					+ "OR (status = 'CANCELED')) AND type_hotel = ? ) " 
					+ "ORDER BY tours.hot DESC");
			pstm.setString(1, hotelType);
			pstm.execute();
			rs = pstm.getResultSet();
			while (rs.next()) {
				tours.add(extractTour(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		return tours;
	}

	public List<Tour> searchByPrice(double from, double to) {
		List<Tour> tours = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			pstm = connection.prepareStatement("SELECT DISTINCT "
					+ "id_tour, country, city, hotel, type_trip, type_hotel, from_date, to_date, cost, people_number, hot "
					+ "FROM tours LEFT JOIN orders ON tours.id_tour = orders.id_trip "
					+ "WHERE (((status is NULL) " 
					+ "OR (status = 'CANCELED')) AND cost BETWEEN ? AND ? ) " 
					+ "ORDER BY tours.hot DESC");
			pstm.setDouble(1, from);
			pstm.setDouble(2, to);

			pstm.execute();
			rs = pstm.getResultSet();
			while (rs.next()) {
				tours.add(extractTour(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		return tours;
	}

	public List<Tour> searchByNumberOfPeople(int numberOfPeople) {
		List<Tour> tours = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			pstm = connection.prepareStatement("SELECT DISTINCT "
					+ "id_tour, country, city, hotel, type_trip, type_hotel, from_date, to_date, cost, people_number, hot "
					+ "FROM tours LEFT JOIN orders ON tours.id_tour = orders.id_trip "
					+ "WHERE (((status is NULL) " 
					+ "OR (status = 'CANCELED')) AND people_number = ? ) " 
					+ "ORDER BY tours.hot DESC");
			pstm.setDouble(1, numberOfPeople);

			pstm.execute();
			rs = pstm.getResultSet();
			while (rs.next()) {
				tours.add(extractTour(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		return tours;
	}

	public Tour extractTour(ResultSet rs) throws SQLException {
		Tour tour = new Tour();

		tour.setIdTour(rs.getInt(Fields.TOUR_ID));
		tour.setCountry(rs.getString(Fields.TOUR_COUNTRY));
		tour.setCity(rs.getString(Fields.TOUR_CITY));
		tour.setHotel(rs.getString(Fields.TOUR_HOTEL));
		tour.setTourType(rs.getString(Fields.TOUR_TYPE));
		tour.setHotelType(rs.getString(Fields.TOUR_HOTEL_TYPE));
		tour.setFromDate(rs.getDate(Fields.TOUR_FROM_DATE));
		tour.setToDate(rs.getDate(Fields.TOUR_TO_DATE));
		tour.setCost(rs.getInt(Fields.TOUR_COST));
		tour.setPeopleNumber(rs.getInt(Fields.TOUR_PEOPLE_NUMBER));
		tour.setIsHot(rs.getBoolean(Fields.TOUR_IS_HOT));

		return tour;
	}

	public Tour getTourById(int tourId) {
		Tour tour = null;
		ResultSet rs = null;
		try {
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM tours WHERE id_tour=?");
			int k = 1;
			pstm.setInt(k++, tourId);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs.next()) {
				tour = extractTour(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
		}
		return tour;
	}

	public void deleteTour(Tour tour) {
		try {
			PreparedStatement pstm = connection.prepareStatement("DELETE FROM tours WHERE id_tour=?");
			int k = 1;
			pstm.setInt(k++, tour.getIdTour());
			pstm.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * Closes a statement object.
	 */
	private void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * Closes a result set object.
	 */
	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private java.sql.Date convertJavaDateToSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}
}
