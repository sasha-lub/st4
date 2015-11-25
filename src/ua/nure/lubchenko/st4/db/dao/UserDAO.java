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
import ua.nure.lubchenko.st4.entity.User;

public class UserDAO {
	Connection connection;

	public UserDAO() {
		DBManager dbm = DBManager.getInstance();
		try {
			connection = dbm.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addUser(User user) {
		try {
			PreparedStatement pstm = connection
					.prepareStatement("INSERT INTO users VALUES (default, ?, ?, ?, ?, false)");

			int k = 1;

			pstm.setString(k++, user.getLogin());
			pstm.setString(k++, user.getPassword());
			pstm.setString(k++, user.getFullName());
			pstm.setInt(k++, user.getIdRole());
			pstm.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(User user) {
		try {
			PreparedStatement pstm = connection.prepareStatement("DELETE FROM users WHERE id_user=?");
			int k = 1;
			pstm.setInt(k++, user.getIdUser());
			pstm.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			PreparedStatement pstm = connection.prepareStatement(
					"UPDATE users SET login=?, password=?, full_name=?, role_id=?, banned=? WHERE id_user=?");
			int k = 1;
			pstm.setString(k++, user.getLogin());
			pstm.setString(k++, user.getPassword());
			pstm.setString(k++, user.getFullName());
			pstm.setInt(k++, user.getIdRole());
			pstm.setBoolean(k++, user.isBanned());
			pstm.setInt(k++, user.getIdUser());
			pstm.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public User getUserById(int userId) {
		User user = null;
		ResultSet rs = null;
		try {
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM users WHERE id_user=?");
			int k = 1;
			pstm.setInt(k++, userId);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs.next()) {
				user = extractUser(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
		}
		return user;
	}

	public User getUserByLogin(String userLogin) {
		User user = null;
		ResultSet rs = null;
		try {
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
			int k = 1;
			pstm.setString(k++, userLogin);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs.next()) {
				user = extractUser(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
		}
		return user;
	}

	public List<User> findUsers() {
		List<User> usersList = new ArrayList<User>();
		Statement stm = null;
		ResultSet rs = null;
		try {
			stm = connection.createStatement();
			stm.executeQuery("SELECT * FROM users");
			rs = stm.getResultSet();

			while (rs.next()) {
				usersList.add(extractUser(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			System.out.println(usersList);
			close(stm);
			close(rs);
		}
		return usersList;
	}

	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();

		user.setIdUser(rs.getInt(Fields.USER_ID));
		user.setLogin(rs.getString(Fields.USER_LOGIN));
		user.setPassword(rs.getString(Fields.USER_PASSWORD));
		user.setFullName(rs.getString(Fields.USER_FULL_NAME));
		user.setIdRole(rs.getInt(Fields.USER_ROLE_ID));
		user.setBanned(rs.getBoolean(Fields.USER_BANNED));

		return user;
	}

	private void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
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
}
