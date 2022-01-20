package app.model.DAO;


import app.model.DTO.OrderDTO;

import java.sql.*;

public class ReceiptDAO {


    private final static String STATUS_AWAITING_PAYMENT = "awaiting payment";
    private final static String STATUS_SUCCESSFULLY_PAID = "successfully paid" ;

    public static void generateReceipt(String order_id) {

        Connection connection = ConnectionDAO.getConnection();

        String receiptContent = formatReceiptContent(getOrderFromDB(order_id));

        String sql = "UPDATE `Order` SET receipt = ?, status = ? WHERE ID = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, receiptContent);
            ps.setString(2, STATUS_AWAITING_PAYMENT);
            ps.setString(3, order_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String formatReceiptContent(OrderDTO orderFromDB) {
        return new StringBuilder("<p><b>This is receipt content:</b><br>")
            .append("<p><b>Order Number: ").append(orderFromDB.getOrder_id())
            .append("</b><br><p><b>Client name: ").append(orderFromDB.getClient_name())
            .append("</b><br><p><b>Delivery type: ").append(orderFromDB.isInCityLimitsDelivery() ? "In city Limits" : "Transportation between cities")
            .append("</b><br><p><b>Delivery time: ").append(orderFromDB.getDelivery_time())
            .append("</b><br><p><b>Total cost: ").append(orderFromDB.getDelivery_price()).append("</b><br>")
            .toString();
    }

    private static OrderDTO getOrderFromDB(String order_id) {

        Connection connection = ConnectionDAO.getConnection();

        String sql = "select * from `Order` where id = " + order_id;
        OrderDTO orderDTO = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            orderDTO = new OrderDTO(
                    rs.getInt("id"),
                    rs.getString("client_name"),
                    rs.getString("client_phone"),
                    rs.getInt("user_id"),
                    rs.getInt("cargo_weight"),
                    rs.getInt("cargo_size"),
                    rs.getBoolean("isInCityLimitsDelivery"),
                    rs.getString("delivery_time"),
                    rs.getDouble("delivery_price"),
                    rs.getString("receipt"),
                    rs.getString("creation_time"),
                    null
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDTO;
    }

    public static void imitatePayment(String order_id){

        Connection con = ConnectionDAO.getConnection();
        String sql = "UPDATE `Order` SET status = ? WHERE ID = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, STATUS_SUCCESSFULLY_PAID);
            ps.setString(2, order_id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
