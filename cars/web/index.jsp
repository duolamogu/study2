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
<%!
  static ArrayList<GoodsSingle> goodslist = new ArrayList<GoodsSingle>();
  static {
    String[] names = { "苹果", "香蕉", "菠萝", "西瓜", "葡萄" };
    float[] prince = { 2.8f, 3.1f, 2.5f, 2.3f, 2.4f };
    for (int i = 0; i < 5; i++) {
      GoodsSingle single = new GoodsSingle();
      single.setName(names[i]);
      single.setPrice(prince[i]);
      single.setNum(1);
      goodslist.add(i, single);
    }
  }
%>
<%
  session.setAttribute("goodslist", goodslist);
  response.sendRedirect("show.jsp");
%>
</body>
</html>
