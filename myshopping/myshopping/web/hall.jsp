<%@ page language="java" import="java.util.*,com.hsp.domain.*" pageEncoding="utf-8"%>
<%@ page import="b.domain.Book" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>hall.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
    <h1>欢迎访问购物大厅</h1>
    <table border="1">
    <tr><th>书名</th><th>价格</th><th>出版社</th><th>点击购买</th></tr>
    <%
    ArrayList al=(ArrayList)request.getAttribute("books");
    for (int i=0;i<al.size();i++){
    Book book=(Book)al.get(i);
    %>
    <tr><td><%=book.getName() %></td><td><%=book.getPrice() %></td><td><%=book.getPublishHouse() %></td><td><a href='/myshopping/ShoppingClServlet?type=add&id=<%=book.getId()%>'>购买</a></td></tr>
    <%
    }
     %>
    <tr><td colspan="4"><input type="button" value="查看购物车"/></td></tr>
    </table>
    <a href="/myshopping/index.jsp">返回登陆</a>
  </body>
</html>
