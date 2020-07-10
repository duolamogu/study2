package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.service.MyCart;
public class GoShowMyCart extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		MyCart myCart =(MyCart)request.getSession().getAttribute("myCart");
		request.setAttribute("bookList", myCart.showMyCart());
		request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
		request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
