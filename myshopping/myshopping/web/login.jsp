<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>login.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
   <h1>登陆界面</h1>
   <form action="/myshopping/GoHallUI" method="post">
	<table border="1">
	<tr><td>用户id:</td><td><input type="text" name="id"/></td></tr>
	<tr><td>密     码：</td><td><input type="password" name="passwd"/></td></tr>
	<tr><td><input type="submit" value="登陆"/></td><td><input type="reset" value="清空输入"/></td></tr>
	</table>
	</form>
  </body>
</html>
