<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="iwanttotry.Cart.*" %>

<%
    Cart c = (Cart)session.getAttribute("cart");
    if(c == null) {
        c = new Cart();
        session.setAttribute("cart", c);
    }

    double totalPrice = c.getTotalPrice();

    request.setCharacterEncoding("GBK");
    String action = request.getParameter("action");

    Map products = (HashMap)session.getAttribute("products");

    if(action != null && action.trim().equals("add")) {
        String id = request.getParameter("id");
        Product p = (Product)products.get(id);
        CartItem ci = new CartItem();
        ci.setProduct(p);
        ci.setCount(1);
        c.add(ci);
    }

    if(action != null && action.trim().equals("delete")) {
        String id = request.getParameter("id");
        c.deleteItemById(id);
    }

    if(action != null && action.trim().equals("update")) {
        for(int i=0; i<c.getItems().size(); i++) {
            CartItem ci = c.getItems().get(i);
            int count = Integer.parseInt(request.getParameter("p" + ci.getProduct().getId()));
            ci.setCount(count);
        }
    }
%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
    List<CartItem> items = c.getItems();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB18030">
    <title>���ﳵ</title>

</head>
<body>

<!-- c��ֵ�ǣ�<%=(c == null) %> items��ֵ�ǣ�<%=(items == null) %> -->
<form action="Buy.jsp" method="get">
    <input type="hidden" name="action" value="update"/>
    <table align="center" border="1">
        <tr>
            <td>��ƷID</td>
            <td>��Ʒ����</td>
            <td>��������</td>
            <td>��λ�۸�</td>
            <td>�ܼ�</td>
            <td>����</td>
        </tr>
        <%
            for(Iterator<CartItem> it = items.iterator(); it.hasNext(); ) {
                CartItem ci = it.next();
        %>
        <tr>
            <td><%=ci.getProduct().getId() %></td>
            <td><%=ci.getProduct().getName() %></td>
            <td>
                <input type="text" size=3 name="<%="p" + ci.getProduct().getId() %>" value="<%=ci.getCount() %>"
                       onkeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;"
                       onchange="document.forms[0].submit()">
            </td>
            <td><%=ci.getProduct().getPrice() %></td>
            <td><%=ci.getProduct().getPrice()*ci.getCount() %></td>
            <td>

                <a href="Buy.jsp?action=delete&id=<%=ci.getProduct().getId() %>">ɾ��</a>

            </td>
        </tr>
        <%
            }
        %>


        <tr>
            <td colspan=3 align="right">
                ȫ����Ʒ�ܼ۸�Ϊ��
            </td>
            <td colspan=3><%=c.getTotalPrice() %></td>
        </tr>


        <tr>
            <td colspan=6 align="right">
                <a href="">�µ�</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>