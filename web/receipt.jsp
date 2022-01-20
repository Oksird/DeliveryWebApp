<%@ page session="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-bar w3-black w3-xlarge">
    <a href="mainPage.jsp" class="w3-bar-item w3-button">Home</a>
    <a href="/profile" class="w3-bar-item w3-button">${sessionScope.username}</a>
    <a href="/logOut" class="w3-bar-item w3-button w3-right">Log Out</a>
</div>
<div  class="w3-container w3-padding">

<div class="w3-card-4">
    <div class="w3-container w3-center w3-teal w3-selection w3-light-grey w3-padding">
        <h1 align="center">Receipt</h1>
    </div>
        <b class="w3-padding"><%out.print(request.getAttribute("receiptText"));%></b><br>
    <button class="w3-btn w3-teal w3-round-large" style="width: 30%" onclick="location.href='/profile'">back</button>

    <% if(request.getAttribute("orderAuthorID").equals(String.valueOf(session.getAttribute("id")))){%>
                <form action ="imitatePayment" method="get">
                    <input type="hidden" name="order_id" value="<%out.print(request.getAttribute("order_id"));%>" >
                    <input value="Pay for Receipt" type="submit" class="w3-btn w3-teal w3-round-large">
                </form>
            <%}%>
</div></div>
</body>
</html>
