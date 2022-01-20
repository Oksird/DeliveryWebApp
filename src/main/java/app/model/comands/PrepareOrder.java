package app.model.comands;

import app.model.DTO.OrderDTO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PrepareOrder {
    private final String STATUS_NOT_CONFIRMED = "notConfirmed";
    private OrderDTO preparedOrder;
    private SimpleDateFormat fromHTMLForm = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
    private SimpleDateFormat toSqlForm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PrepareOrder(HttpServletRequest req, int uId) {
        String cName = req.getParameter("client_name");
        String pNum = req.getParameter("client_phone");
        int weight = Integer.parseInt(req.getParameter("weight"));
        int size = Integer.parseInt(req.getParameter("size"));
        boolean isInCity = Boolean.parseBoolean(req.getParameter("isInCityDel"));
        String deliveryTime = toSqlFormat(req.getParameter("deliveryTime"));
        String creationTime = datetimeOfThisMoment();

        double price = Calc.calculateCost(isInCity ? 1 : 2, size, weight);

        preparedOrder = new OrderDTO(null, cName, pNum, uId, weight, size, isInCity, deliveryTime,
                price, null, creationTime, STATUS_NOT_CONFIRMED);
    }

    private String toSqlFormat(String delivery_time) {
        try {
            return toSqlForm.format(fromHTMLForm.parse(delivery_time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    private String datetimeOfThisMoment() {
        return toSqlForm.format(new java.sql.Date(System.currentTimeMillis()));
    }

    public OrderDTO getPreparedOrder() {
        return preparedOrder;
    }
}
