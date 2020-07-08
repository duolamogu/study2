<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="GoodsSingle"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    ArrayList<GoodsSingle> goodslist =(ArrayList<GoodsSingle>)session.getAttribute("goodslist");
%>
<table border="1" rules="none" width="450" cellpadding="0"
       cellspacing="0">
    <tr height="50">
        <td colspan="3" align="center">提供商品如下：</td>
    </tr>
    <tr align="center" height="30" bgcolor="lightgryey">
        <td>名称</td>
        <td>价格</td>
        <td>购买</td>
    </tr>
    <%
        if (goodslist == null || goodslist.size() == 0) {
    %>
    <tr height="100">
        <td colspan="3" align="center">没有商品显示！</td>
    </tr>
    <%
    } else {
        for (int i = 0; i < goodslist.size(); i++) {
            GoodsSingle single = (GoodsSingle) goodslist.get(i);
    %>
    <tr height="50" align="center">
        <td><%=single.getName()%></td>
        <td><%=single.getPrice()%></td>
        <td><a href="docar.jsp?action=buy&id=<%=i%>">购买</a></td>
    </tr>
    <%
            }
        }
    %>
    <tr height="50">
        <td align="center" colspan="3"><a href="shopcar.jsp">查看购物车</a></td>
    </tr>
</table>
</body>
</html>