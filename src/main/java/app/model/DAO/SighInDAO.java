package app.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SighInDAO {

    public static boolean isUserNameAvailable(String username) {
        boolean status = true;

        Connection con = ConnectionDAO.getConnection();
        System.out.println("User "+username);
        String sql = "select * from USER where login = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !status;
    }



    public static void addUserToDB(String login, String password, String email, String phoneNumber)
    {
        Connection con = ConnectionDAO.getConnection();

        String sql = "INSERT IGNORE INTO User (login, password, email, phoneNumber, role ) " +
                " VALUES ( ?, ?, ?, ?, 'user'); ";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, phoneNumber);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
