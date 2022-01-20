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
    <%if(session != null && session.getAttribute("username") != null){%>
    <a href="/profile" class="w3-bar-item w3-button">${sessionScope.username}</a>
    <a href="/logOut" class="w3-bar-item w3-button w3-right">Log Out</a>
    <%}else{%>
    <a href="/logIn" class="w3-bar-item w3-button w3-right">Log In</a>
    <%}%>
</div>
<div  class="w3-container w3-padding">

    <div class="w3-card-4 w3-center">
        <div class="w3-container w3-center w3-teal">
            <h1>Calculate Delivery Price</h1>
        </div>

        <form action="calcServlet" method="get" class="w3-selection w3-center w3-light-grey w3-padding">
            <div class="w3-container w3-teal w3-row-padding w3-border">
                <br><br><label class="w3-padding">Distance of Delivery</label><br><hr>

                <input class="w3-radio w3-padding" required="required" type="radio" name="isInCityDel" value="1" checked>
                    <label >Is in City limits</label>

                <input class="w3-radio w3-padding" type="radio" name="isInCityDel" value="2">
                    <label >Of the City limits</label><hr>
            </div>



            <p>
                <label class="w3-text-teal"><b>Cargo size (м3):</b></label>
                <input class="w3-input w3-border w3-light-grey" name="size" type="number" min="1" required="required" ></p>
            <p>
                <label class="w3-text-teal"><b>Cargo weight (kg):</b></label>
                <input class="w3-input w3-border w3-light-grey" name="weight" type="number" min="1" required="required"></p>

            <%if(request.getAttribute("price") != null){%>
            <p class="w3-text-teal">Price: <%out.print(request.getAttribute("price"));%> USD</p>
            <%}%>


            <input value="Calculate" type="submit" class="w3-btn w3-teal w3-round-large">

        </form>

        <button class="w3-btn w3-teal w3-round-large w3-center" style="width: 30%" onclick="location.href='/createOrder'"><h1>Create Order</h1></button>
        <br>
    </div>
    </div>
</body>
</html>
