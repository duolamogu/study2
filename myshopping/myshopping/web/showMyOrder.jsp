<%@ page language="java" import="java.util.*,b.domain.*" pageEncoding="utf-8"%>
<%@ page import="b.domain.Users1" %>
<%@ page import="b.domain.Book" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>我的订单</title>
    <script type="text/javascript">
    function GoSubmitOrder(){
    	window.location.href="/myshopping/SumbitOrderServlet";
    }
    </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
    <h1>我的订单</h1>
    <table style="border-collapse:collapse" border="1">
    <tr><th colspan="2">用户个人信息</th></tr>
    <tr><th>用户名：</th><td><%=((Users1)session.getAttribute("loginUser")).getName() %></td></tr>
    <tr><th>电子邮件：</th><td><%=((Users1)session.getAttribute("loginUser")).getEmail() %></td></tr>
    <tr><th>用户级别：</th><td><%=((Users1)session.getAttribute("loginUser")).getGrade() %></td></tr>
    </table>
    <br/>
    <table style="border-collapse:collapse" border="1">
    <tr><th>BookId</th><th>书名</th><th>价格</th><th>出版社</th><th>数量</th></tr>
    <%
    ArrayList al=(ArrayList)request.getAttribute("orderinfo");
    for(int i=0;i<al.size();i++){
    Book book=(Book)al.get(i);
    %>
    <tr><td><%=book.getId() %></td><td><%=book.getName() %></td><td><%=book.getPrice() %></td><td><%=book.getPublishHouse() %></td><td><%=book.getShoppingNum() %></td></tr>
    <%
    }
     %>
     <tr ><td colspan="5">总价格为：<%=request.getAttribute("totalPrice")%></td></tr>
    </table>
    <input type="button" onclick="GoSubmitOrder()" value="确认订单"/>  
    </body>
</html>
