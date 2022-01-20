package app.model.DAO;


import app.model.DTO.OrderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateOrderDAO {

    public void createOrder(OrderDTO orderDTO)
    {
        Connection con = ConnectionDAO.getConnection();

        String sql = "INSERT IGNORE INTO `Order` (client_name, client_phone, user_id, cargo_weight," +
                " cargo_size, isInCityLimitsDelivery, delivery_time, delivery_price, creation_time, status) " +
                " VALUES ( ?, ?, ?, ?,?, ?, ?, ?, ?, ?); ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, orderDTO.getClient_name());
            ps.setString(2, orderDTO.getClient_phone());
            ps.setInt(3, orderDTO.getUser_id());
            ps.setInt(4, orderDTO.getCargo_weight());
            ps.setInt(5, orderDTO.getCargo_size());
            ps.setBoolean(6, orderDTO.isInCityLimitsDelivery());
            ps.setString(7, orderDTO.getDelivery_time());
            ps.setDouble(8, orderDTO.getDelivery_price());
            ps.setString(9, orderDTO.getCreation_time());
            ps.setString(10, orderDTO.getStatus());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
