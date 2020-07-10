package a;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.domain.Users1;
import b.service.BookService;
import b.service.MyCart;
import b.service.Users1Service;
public class GoHallUI extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		if(request.getSession().getAttribute("loginUser")!=null){
			BookService bookService=new BookService();
			ArrayList al=bookService.getAllBook();
			request.setAttribute("books", al);
			request.getRequestDispatcher("hall.jsp").forward(request, response);
			return;
		}
		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		String p=request.getParameter("passwd");
		Users1 loginUser=new Users1(Integer.parseInt(id),p);
		Users1Service user1Service=new Users1Service();
		if(user1Service.checkUser(loginUser)){
			request.getSession().setAttribute("loginUser", loginUser);
			MyCart myCart=new MyCart();
			request.getSession().setAttribute("myCart", myCart);
			BookService bookService=new BookService();
			ArrayList al=bookService.getAllBook();
			request.setAttribute("books", al);
			request.getRequestDispatcher("hall.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
