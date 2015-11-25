package ua.nure.lubchenko.st4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nure.lubchenko.st4.db.DBManager;
import ua.nure.lubchenko.st4.db.Fields;
import ua.nure.lubchenko.st4.entity.Order;
import ua.nure.lubchenko.st4.entity.Status;

public class OrderDAO {

	private Connection connection;

	public OrderDAO() {
		DBManager dbm = DBManager.getInstance();
		try {
			connection = dbm.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addOrder(Order order) {
		try {
			PreparedStatement pstm = connection.prepareStatement("INSERT INTO orders VALUES (?, ?, ?)");
			int k = 1;
			pstm.setInt(k++, order.getIdUser());
			pstm.setInt(k++, order.getIdTour());
			pstm.setString(k++, order.getStatus().toString());
			pstm.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void updateOrder(Order order) {
		try {
			PreparedStatement pstm = connection.prepareStatement("UPDATE orders SET status=? WHERE id_user=? AND id_trip=? ");
			int k = 1;
			pstm.setString(k++, order.getStatus().toString());
			pstm.setInt(k++, order.getIdUser());
			pstm.setInt(k++, order.getIdTour());
			pstm.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public Order getOrdersByUserIdAndTourId(int userId, int tripId) {
		Order order = null;
		try {
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM orders WHERE id_user=? AND id_trip=?");
			int k = 1;
			pstm.setInt(k++, userId);
			pstm.setInt(k++, tripId);
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			if (rs.next()) {
				order = extractOrder(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return order;
	}

	public String getUserNameByUserId(int userId) {
		String userName="";
		try {
			PreparedStatement pstm = connection.prepareStatement("SELECT full_name FROM users WHERE id_user=?");
			pstm.setInt(1, userId);
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			if (rs.next()) {
				userName = rs.getString(Fields.USER_FULL_NAME);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userName;
	}
	
	public String getTourInfByTourId(int tourId) {
		String tourInf="";
		try {
			PreparedStatement pstm = connection.prepareStatement("SELECT city, hotel FROM tours WHERE id_tour=?");
			pstm.setInt(1, tourId);
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			if (rs.next()) {
				tourInf = rs.getString(Fields.TOUR_CITY)+", "+rs.getString(Fields.TOUR_HOTEL)+" hotel";
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return tourInf;
	}
	
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		try {
			Statement stm = connection.createStatement();
			stm.executeQuery("SELECT * FROM orders");
			ResultSet rs = stm.getResultSet();
			while (rs.next()) {
				orders.add(extractOrder(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return orders;
	}

	public List<Order> getUserOrders(int userId) {
		List<Order> orders = new ArrayList<>();
		try {
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM orders WHERE id_user = ?");
			pstm.setInt(1, userId);
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			while (rs.next()) {
				orders.add(extractOrder(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return orders;
	}
	
	public Order extractOrder(ResultSet rs) throws SQLException {
		Order order = new Order();
		order.setIdUser(rs.getInt("id_user"));
		order.setIdTour(rs.getInt("id_trip"));
		order.setStatus(Status.valueOf(rs.getString("status")));
		order.setTourInfo(getTourInfByTourId(order.getIdTour()));
		order.setUserName(getUserNameByUserId(order.getIdUser()));
		
		return order;
	}
}
