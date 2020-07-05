<%@ page import="java.util.*,java.io.*" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8"
    <title>Document</title>
    <style type="text/css">
        img{
            width:50px;
            height:40px;
        }
    </style>
</head>
<body>
<%
    Map<String.Double>fruits=new TreeMap();
    Map<String.Integer>car=new TreeMap();
%>
<%
    fruits.put("apple",2.5);
    fruits.put("apple",3.5);
    fruits.put("apple",4.5);
    fruits.put("apple",5.5);
    fruits.put("apple",6.5);
%>
<h1>水果店</h1>
<%
    String name=(String)session.getAttribute("username");
    if(name==null){
        out.println("您还没有登陆，请<a href='login.jsp'>登陆</a>");
    }
    else{
        car=(Map<String,Integer>)session.getAttribute("car");
        %>
<p>欢迎<%=name%>
    <table border="1">
    <tr>
        <td>图片</td>
        <td>商品名称</td>
        <td>单价</td>
        <td>购买</td>
    </tr>
    <tr>
        <%
        for(String f:fruits.keySet()){
            out.println(String.fromat("<tr><td><img src='%s'></td><td>%s</td><td>%.2f</td><td><a href='buy.jsp?name=%s'>BUY</a></td></tr>));

        }%>
    </tr>
</table>
    <%}
%>
<p>查看我的<a h购物车</p>
</body>
</html>
