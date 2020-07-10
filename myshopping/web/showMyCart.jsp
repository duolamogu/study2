<%@ page language="java" import="java.util.*,b.Book,b.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>查看购物车</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
  </head>
  <body>
    <h2>我的购物车</h2>
  <a href="/myshopping/GoHallUI">返回购物大厅</a>
  <form action="/myshopping/ShoppingClServlet?type=update" method="post">
  <table border="1" style="border-collapse:collapse width:1200px">
  <tr><th>bookId</th><th>书名</th><th>价格</th><th>出版社</th><th>数量</th><th>删除</th></tr>
 <%
 	ArrayList<Book> al=(ArrayList<Book>)request.getAttribute("bookList");
 	for(int i=0;i<al.size();i++){
 	Book book=(Book)al.get(i);
  %>
  <tr><td><%=book.getId() %><input type='hidden' name="id" value="<%=book.getId() %>"/></td><td><%=book.getName() %></td><td><%=book.getPrice() %></td><td><%=book.getPublishHouse() %></td><td><input type="text" name="booknum" value="<%=book.getShoppingNum() %>"/>本</td><td><a href='/myshopping/ShoppingClServlet?type=del&id=<%=book.getId() %>'>删除</a></td></tr>
   <%} %>
      <tr><td colspan="6"><input type="submit" value="update"/></td></tr>
      <tr><td colspan="6">购物车的总价格：${totalPrice }元</td></tr>
  </table>
  </form>
  <a href="/myshopping/GoMyOrderServlet">提交订单</a>
  </body>
</html>
