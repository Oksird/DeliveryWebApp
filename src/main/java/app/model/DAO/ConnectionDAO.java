package app.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
    private static String dbUrl = "jdbc:mysql://localhost:3306/deliverywebapp";
    private static String dbUname = "root";
    private static String dbPassword = "root";
    private static String dbDriver = "com.mysql.cj.jdbc.Driver";
    static {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
