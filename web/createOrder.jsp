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
        <div class="w3-container w3-center w3-teal">
            <h1 align="center">Create Order</h1>
        </div>

        <form action ="createOrder" method="post" class="w3-selection w3-light-grey w3-padding w3-center">
            <p><b class="w3-text-teal">Your name: </b><br>
                <input value="${sessionScope.username}" required="required" type="text"   name="client_name" class="w3-input w3-animate-input w3-border w3-round-large">
            <p><b class="w3-text-teal">Contact number: </b><br>
            <input value="${sessionScope.phoneNumber}" required="required" type="text"  name="client_phone" class="w3-input w3-animate-input w3-border w3-round-large">
            <div class="w3-container w3-teal w3-row-padding w3-border">
                <br><br><label class="w3-padding">Distance of Delivery</label><br><hr>

                <input class="w3-radio w3-padding" required="required" type="radio" name="isInCityDel" value="true" checked>
                <label>Is in City limits</label>

                <input class="w3-radio w3-padding" type="radio" name="isInCityDel" value="false">
                <label>Of the City limits</label><hr>
            </div>
            <p><b class="w3-text-teal">Cargo weight (kg): </b><br>
                <input required="required" type="number" name="weight" class="w3-input w3-animate-input w3-border w3-round-large">
            <p><b class="w3-text-teal">Cargo size (m3): </b><br>
                <input  required="required" type="number"  name="size" class="w3-input w3-animate-input w3-border w3-round-large">
            <p><b class="w3-text-teal">Delivery time</b><br>
                <input  required="required" type="datetime-local"  name="deliveryTime" class="w3-input w3-animate-input w3-border w3-round-large">
                <br>
                <input value="Confirm" type="submit" class="w3-btn w3-teal w3-round-large">
        </form>


    </div>
</div>
</body>
</html>
