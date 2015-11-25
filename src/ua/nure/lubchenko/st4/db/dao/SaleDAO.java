package ua.nure.lubchenko.st4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.nure.lubchenko.st4.db.DBManager;
import ua.nure.lubchenko.st4.db.Fields;

public class SaleDAO {
	Connection connection;

	public SaleDAO() {
		DBManager dbm = DBManager.getInstance();
		try {
			connection = dbm.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateHotSale(int hotSale) {
		try {
			PreparedStatement pstm = connection.prepareStatement("UPDATE sales SET hot_sale=? WHERE id = 0");
			pstm.setInt(1, hotSale);
			pstm.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void updateStepSale(int stepSale) {
		try {
			PreparedStatement pstm = connection.prepareStatement("UPDATE sales SET step_sale=? WHERE id = 0");
			pstm.setInt(1, stepSale);
			pstm.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateMaxStepSale(int maxStepSale) {
		try {
			PreparedStatement pstm = connection.prepareStatement("UPDATE sales SET max_step_sale=? WHERE id = 0");
			pstm.setInt(1, maxStepSale);
			pstm.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public int getMaxStepSale() {
		int maxStepSale = 0;
		try {
			Statement stm = connection.createStatement();
			stm.executeQuery("SELECT max_step_sale FROM sales WHERE id = 0");
			ResultSet rs = stm.getResultSet();
			if (rs.next()) {
				maxStepSale = rs.getInt(Fields.SALES_MAX_STEP_SALE);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return maxStepSale;
	}

	public int getStepSale() {
		int stepSale = 0;
		try {
			Statement stm = connection.createStatement();
			stm.executeQuery("SELECT step_sale FROM sales WHERE id = 0");
			ResultSet rs = stm.getResultSet();
			if (rs.next()) {
				stepSale = rs.getInt(Fields.SALES_STEP_SALE);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return stepSale;
	}

	public int getHotSale() {
		int hotSale = 0;
		try {
			Statement stm = connection.createStatement();
			stm.executeQuery("SELECT hot_sale FROM sales WHERE id = 0");
			ResultSet rs = stm.getResultSet();
			if (rs.next()) {
				hotSale = rs.getInt(Fields.SALES_HOT_SALE);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return hotSale;
	}
	
	public int getNumberOfUserOrders(int userId) {
		int ordersCounter = 0;
		try {
			PreparedStatement pstm = connection.prepareStatement("SELECT count(*)as NumberOfOrders FROM orders "
					+ "WHERE id_user = ? AND status = 'PAID'");
			pstm.setInt(1, userId);
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			if (rs.next()) {
				ordersCounter = rs.getInt(Fields.NUMBER_OF_ORDERS);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ordersCounter;
	}
}
