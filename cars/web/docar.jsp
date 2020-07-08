<%@page import="com.sun.xml.internal.ws.encoding.MtomCodec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="GoodsSingle"%>
<%@page import="MyTools"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<jsp:useBean id="myCar" class="ShopCar" scope="session"></jsp:useBean>
<%
    String action = request.getParameter("action");
    if (action == "")
        action = "";
    if (action.equals("buy")) {
        //购买商品
        ArrayList<GoodsSingle> goodslist = (ArrayList<GoodsSingle>) session.getAttribute("goodslist");
        int id = MyTools.strToint(request.getParameter("id"));
        GoodsSingle single = (GoodsSingle) goodslist.get(id);
        myCar.addItem(single);
        response.sendRedirect("show.jsp");
    } else if (action.equals("remove")) {
        //移除商品
        String name = request.getParameter("name");
        myCar.removeItem(name);
        response.sendRedirect("shopcar.jsp");

    } else if (action.equals("clear")) {
        myCar.clearCar();
        response.sendRedirect("shopcar.jsp");
    } else {
        response.sendRedirect("show.jsp");
    }
%>

</body>
</html>