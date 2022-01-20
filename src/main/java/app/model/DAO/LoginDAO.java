package app.model.DAO;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {

	public static void configureSession(String username, String password, HttpSession session) {

		Connection con = ConnectionDAO.getConnection();

		String sql = "select id, email, phoneNumber, role from USER where login = ? and password =?";
		session.setAttribute("username", username);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			session.setAttribute("id",rs.getInt("id"));
			session.setAttribute("email",rs.getString("email"));
			session.setAttribute("phoneNumber",rs.getString("phoneNumber"));
			session.setAttribute("role",rs.getString("role"));
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean validate(String username, String password) {
		boolean status = false;

		Connection con = ConnectionDAO.getConnection();
		
		String sql = "select * from USER where login = ? and password =?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	}

