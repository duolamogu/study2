
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>useBean</title>
</head>
<body>
//1.<jsp:useBean id="date" class="java.util.Date"/>
/*2.<%
    //2.1java.util.Date date=new java.util.Date();//创建一个date
    //2.2Object date=Class.forName("java.util.Date").newInstance();//反射
    %>
*/
<p>日期为：<%=date%></p>
</body>
</html>
