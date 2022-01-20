package app.model.DAO;


import app.model.DTO.OrderDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class GetOrderListDAO {

    public List getAllUsersOrderList(){
        return getUserOrderList(-1);
    }

    public List getUserOrderList(int uId) {
        Connection con = ConnectionDAO.getConnection();

        String sql = "select * from `Order`" ;
        if (uId != -1){
           sql += " where user_id = "+uId;
        }
        List resultList = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            resultList = convertToList(rs);
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private List convertToList(ResultSet rs) throws SQLException {
        List resultList = new LinkedList();

        while (rs.next()) {
            int order_id = rs.getInt("id");
            String cName =rs.getString("client_name");
            String pNum = rs.getString("client_phone");
            int uId = rs.getInt("user_id");
            int weight = rs.getInt("cargo_weight");
            int size = rs.getInt("cargo_size");
            boolean isInCity = rs.getBoolean("isInCityLimitsDelivery");
            String deliveryTime = rs.getString("delivery_time");
            String creationTime = rs.getString("creation_time");
            String receipt = rs.getString("receipt");
            double price = rs.getDouble("delivery_price");
            String status = rs.getString("status");

            OrderDTO orderDTO = new OrderDTO(order_id, cName, pNum, uId, weight, size, isInCity,
                    deliveryTime, price, receipt, creationTime, status);

            resultList.add(orderDTO);
        }
        return resultList;
    }

}
