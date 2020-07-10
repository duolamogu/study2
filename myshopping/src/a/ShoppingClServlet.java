package a;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.service.MyCart;

public class ShoppingClServlet extends HttpServlet {
	public void destroy() {
		super.destroy();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type=request.getParameter("type");
		System.out.println("ml++++++++++++++++++++++++++");
		if("del".equals(type)){
			String id=request.getParameter("id");
			MyCart myCart =(MyCart)request.getSession().getAttribute("myCart");
			myCart.delBook(id);
			request.setAttribute("bookList", myCart.showMyCart());
			request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
		}else if("add".equals(type)){
			String id=request.getParameter("id");
			MyCart myCart =(MyCart)request.getSession().getAttribute("myCart");
			myCart.addBook(id);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			response.sendRedirect("myshopping/GoShowMyCart");
		}else if("update".equals(type)){
			String bookIds[]=request.getParameterValues("id");
			String nums[]=request.getParameterValues("booknum");
			MyCart myCart =(MyCart)request.getSession().getAttribute("myCart");
			for(int i=0;i<bookIds.length;i++){
				myCart.updateBook(bookIds[i], nums[i]);
			}
			request.setAttribute("bookList", myCart.showMyCart());
			request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
			request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
