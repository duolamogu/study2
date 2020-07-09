<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>请登陆！</title>
</head>
<body style="background:palegreen">

<center>
  <form action="http://localhost:8080/test/shopping/web/cart.jsp" method="get">
    account  ：<input type="text" name="username" placeholder="enter your account number">
    <br>
    password：<input type="password" name="userpassword" placeholder="enter your password">
    <br>
    <input type="submit" value="Landing">
    <input type="reset" value="Reset">
  </form>
</center>
</body>
</html>