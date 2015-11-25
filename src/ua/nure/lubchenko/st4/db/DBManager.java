package ua.nure.lubchenko.st4.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ua.nure.lubchenko.st4.entity.User;

public final class DBManager {
	private static DBManager instance;

	public static synchronized DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private DBManager() {
		try {
			Context initContext = new InitialContext();
			System.out.println("norm1");
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			System.out.println("norm2");
			ds = (DataSource) envContext.lookup("jdbc/ST4DB");
			System.out.println("norm3");

		} catch (NamingException ex) {
			System.out.println(ex);
			throw new RuntimeException();
		}
	}

	private DataSource ds;

	public Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException ex) {
			System.out.println("!!!" + ex.getMessage());
		}
		return con;
	}

	public List<User> findUsers() {
		List<User> usersList = new ArrayList<User>();
		Statement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			System.out.println("fu 0");
			con = getConnection();
			System.out.println("fu 1");
			stmt = con.createStatement();
			System.out.println("fu 2");

			rs = stmt.executeQuery("SELECT * FROM users");
			System.out.println("fu 3");

			int i = 0;
			while (rs.next()) {
				System.out.println("fu 4");
				usersList.add(extractUser(rs));
				System.out.println(usersList.get(i++));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new RuntimeException();
		} finally {
			close(con, stmt, rs);
		}
		return usersList;
	}

	private User extractUser(ResultSet rs) throws SQLException {
		System.out.println("extr user 0");
		User user = new User();
		System.out.println("extr user 1");

		user.setIdUser(rs.getInt(Fields.USER_ID));
		System.out.println("id");
		user.setLogin(rs.getString(Fields.USER_LOGIN));
		System.out.println("login");
		user.setPassword(rs.getString(Fields.USER_PASSWORD));
		System.out.println("pass");
		user.setFullName(rs.getString(Fields.USER_FULL_NAME));
		System.out.println("full name");
		user.setBanned(rs.getBoolean(Fields.USER_BANNED));
		System.out.println("banned");
		user.setIdRole(rs.getInt(Fields.USER_ROLE_ID));
		System.out.println("role id");
		System.out.println("extr user 2");

		return user;
	}

	/**
	 * Closes a connection.
	 * 
	 * @param con
	 *            Connection to be closed.
	 */
	private void close(Connection con) {
		if (con != null) {
			try {
				con.close();
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

	/**
	 * Closes resources.
	 */
	private void close(Connection con, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(con);
	}

	/**
	 * Rollbacks a connection.
	 * 
	 * @param con
	 *            Connection to be rollbacked.
	 */
	private void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
