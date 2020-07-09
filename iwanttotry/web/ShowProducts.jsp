<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%@ page import="*.*"%>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>show</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body bgcoclor="#ffffff">
<%
    Map products=new HashMap();
    products.put("one","phone","nice",8000.00);
    products.put("two","book","nice",10.00);
    products.put("three","shoes","nice",90.00);
    products.put("four","candy","nice",300.00);
%>
<h1>choise</h1>
<form name="productForm" action="http://localhost:8080/ShopCart.jsp" method="POST">
    <input type="hidden" name="action" value="purchase">
    <table border="1" cellspacing="0">
        <tr bgcolor="#CCCCCC">
            <tr bgcolor="#CCCCCC">
        <td>序号</td>
        <td>名称</td>
        <td>描述</td>
        <td>价格</td>
        <td>加入购物车</td>
            </tr>
        <%
            Set productIDSet=products.keySet();
            Iterator it=productIDSet.iterator();
            int number=1;
            while(it.hasNext()){
                String id=(String)it.next();
                Product product=(Product)products.get(id);
                %>
        <tr>
            <td>
                <%=number++%>
            </td>
            <td>
                <%=product.getName()%>
            </td>
            <td>
                <%=product.getDes()%>
            </td>
            <td>
                <%=product.getPrice()%>
            </td>
            <td>
                <a href="Buy.jsp?id=<%=product.getID()%>&action=add" target="cart">购买</a>
            </td>
        </tr>
        <%
            }
        %>
        </tr>
    </table>
</form>
</body>
</html>
