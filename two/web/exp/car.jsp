<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的购物车</title>
</head>
<body>



<p>去<a href="goods.jap">商城</a></p>

<table border="1">
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>总价</td>
    </tr>

    <tr>
        <%
            Map<String,Double> goods=new TreeMap<>();
            goods.put("1",9);
            goods.put("2",8);
            goods.put("3",7);
            goods.put("4",6);
            goods.put("5",5);
            Map<String.Integer> choose=new TreeMap<>();
            if(session.getAttribute("choose")!=null){
                choose=(Map<String,Integer>)(session.getAttribute("choose"));
            }


            double total=0;
            for(String f:choose.keySet()){
                total+=goods.get(f)*choose.get(f);
                %>
        <tr>
    //计算单价时使用，用表格来输出
    <td><%=f%></td>
    <td><%=goods.get(f)%></td>
    <td><%=choose.get(f)%></td>
    <td><%=goods.get(f)*choose.get(f)%></td>
</tr>
     <%       }

        %>
    </tr>
</table>
总价<%=total%>

</body>
</html>