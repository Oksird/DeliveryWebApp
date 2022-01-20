<%@ page import="app.model.DTO.OrderDTO" %>
<%@ page import="java.util.List" %>
<%@ page session="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-bar w3-black w3-xlarge">
    <a href="mainPage.jsp" class="w3-bar-item w3-button">Home</a>
    <a href="/profile" class="w3-bar-item w3-button">${sessionScope.username}</a>
    <a href="/logOut" class="w3-bar-item w3-button w3-right">Log Out</a>
</div>
<div class="w3-container w3-padding">

    <div class="w3-card-4 w3-padding">
        <div class="w3-container w3-center w3-teal">
            <h1 align="center">Profile</h1>
            <%if("manager".equals(session.getAttribute("role"))){%>
            <button class="w3-btn w3-grey-blue w3-round-large" style="width: 30%" onclick="location.href='/manageOrders'">
                <h2>Manage orders</h2></button>
            <%}%>
        </div>
</div>
    <%
        final String STATUS_NOT_CONFIRMED = "notConfirmed";
        final String STATUS_AWAITING_PAYMENT = "awaiting payment";
        final String STATUS_SUCCESSFULLY_PAID = "successfully paid" ;
        List<OrderDTO> orderDTOList = (List<OrderDTO>) request.getAttribute("OrderSetOfCurrentUser");

        if (orderDTOList != null && !orderDTOList.isEmpty()) {
            out.println("<ui>");
            for (OrderDTO o : orderDTOList) {
                if (o.getStatus().equals(STATUS_NOT_CONFIRMED)){
                    out.println("<div class=\"w3-panel w3-white w3-display-container w3-card-4 w3-round\">\n" +
                            "<div class=\"w3-container w3-margin-right w3-display-right\"\n>"+
                            "<p>Order awaiting confirmation</p></div>\n" +
                            "   <h5>Delivery for: "+o.getClient_name()+"</h5>\n" +
                            "   <h5>Contact phone: "+o.getClient_phone()+"</h5>\n" +
                            "   <h5>Delivery time: "+o.getDelivery_time()+"</h5>\n" +
                            "   <h5>Price: "+o.getDelivery_price()+"</h5>\n" +
                            "</div>");
                }else if(o.getStatus().equals(STATUS_AWAITING_PAYMENT)){
                    out.println("<form action=\"receipt\" method=\"get\">" +
                            "<div class=\"w3-panel w3-yellow w3-display-container w3-card-4 w3-round\">\n" +
                            "<input type=\"hidden\" name=\"receiptText\" value=\""+ o.getReceipt() +"\">" +
                            "<input type=\"hidden\" name=\"orderAuthorID\" value=\""+ o.getUser_id() +"\">" +
                            "<input type=\"hidden\" name=\"order_id\" value=\""+ o.getOrder_id() +"\">" +
                            "   <input type=\"submit\" value=\"View Receipt\"\n"+
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">\n" +
                            "   <h5>Delivery for:"+o.getClient_name()+"</h5>\n" +
                            "   <h5>Contact phone:"+o.getClient_phone()+"</h5>\n" +
                            "   <h5>Delivery time:"+o.getDelivery_time()+"</h5>\n" +
                            "   <h5>Price:"+o.getDelivery_price()+"</h5>\n" +
                            "</div>" +
                            "</form>");
                }else if(o.getStatus().equals(STATUS_SUCCESSFULLY_PAID)){
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                            "<div class=\"w3-container w3-margin-right w3-display-right\"\n>"+
                            "<p>Order successfully paid</p></div>\n" +
                            "   <h5>Delivery for: "+o.getClient_name()+"</h5>\n" +
                            "   <h5>Contact phone: "+o.getClient_phone()+"</h5>\n" +
                            "   <h5>Delivery time: "+o.getDelivery_time()+"</h5>\n" +
                            "   <h5>Price: "+o.getDelivery_price()+"</h5>\n" +
                            "</div>");
                }

            }

            out.println("</ui>");
        } else out.println("<br><p align=\"center\">There are no delivery orders yet!</p>");
    %>
</div>
</body>
</html>
