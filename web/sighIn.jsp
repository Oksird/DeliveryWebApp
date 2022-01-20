<%@ page session="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Sigh In</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey ">
<div class="w3-bar w3-black w3-xlarge">
    <a href="mainPage.jsp" class="w3-bar-item w3-button">Home</a>
</div>
<div  class="w3-container w3-padding">

<div class="w3-card-4">
    <div class="w3-container w3-center w3-teal">
        <h1 align="left">Sigh In Form</h1>
    </div>
    <%if(request.getAttribute("message") != null){
        out.println(request.getAttribute("message"));
    }%>
    <form action ="sighIn" method="post" class="w3-selection w3-light-grey w3-padding w3-center">
        <p><b class="w3-text-teal">User Name: </b><br><input required="required" type="text"   name="username" class="w3-input w3-animate-input w3-border w3-round-large">
        <p><b class="w3-text-teal">Password: </b><br><input required="required" type="password"  name="password" class="w3-input w3-animate-input w3-border w3-round-large">
        <p><b class="w3-text-teal">Email: </b><br><input required="required" type="text"  name="email" class="w3-input w3-animate-input w3-border w3-round-large">
        <p><b class="w3-text-teal">Phone number: </b><br><input required="required" type="text"  name="phone" class="w3-input w3-animate-input w3-border w3-round-large">

        <br>
        <input value="Log in" onclick="location.href='/logIn'" class="w3-btn w3-grey w3-round-large" >
        <input value="Submit" type="submit" class="w3-btn w3-teal w3-round-large">

    </form><br><br>

</div>
</div>
</body>
</html>