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
<jsp:useBean id="myCar" class="ShopCar" scope="session"></jsp:useBean>
<%
    ArrayList<GoodsSingle> buylist = myCar.getBuylist();
    float total = 0;
%>
<table border="1" rules="none" width="450" cellpadding="0"
       cellspacing="0">
    <tr height="50">
        <td colspan="5" align="center">购买商品如下：</td>
    </tr>
    <tr align="center" height="30" bgcolor="lightgryey">
        <td width="25%">名称</td>
        <td>价格（元/斤）</td>
        <td>数量</td>
        <td>总价（元）</td>
        <td>移除（-1/次）</td>
    </tr>
    <%
        if (buylist == null || buylist.size() == 0) {
    %>
    <tr height="100">
        <td colspan="5" align="center">您的购物车为空！</td>
    </tr>
    <%
    } else {
        for (int i = 0; i < buylist.size(); i++) {
            GoodsSingle single = (GoodsSingle) buylist.get(i);
            String name = single.getName();
            float price = single.getPrice();
            int num = single.getNum();
            float money = ((int) ((price * num + 0.05f) * 10)) / 10f;
            total += money;
    %>
    <tr height="50" align="center">
        <td><%=name%></td>
        <td><%=price%></td>
        <td><%=num%></td>
        <td><%=money%></td>
        <td><a href="docar.jsp?action=remove&name=<%=name%>">移除</a></td>
    </tr>
    <%
            }
        }
    %>
    <tr height="50" align="center">
        <td colspan="5">应付金额：<%=total%></td>
    </tr>
    <tr>
        <td colspan="2"><a href="show.jsp">继续购买</a></td>
        <td colspan="3"><a href="docar.jsp?action=clear">清空购物车</a></td>
    </tr>
</table>
</body>
</html>