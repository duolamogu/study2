package a;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import b.domain.Users1;
import b.service.MyCart;
import b.service.OrderService;
import b.service.SendMail;
public class SumbitOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try{
			OrderService orderService=new OrderService();
			MyCart myCart=(MyCart)request.getSession().getAttribute("myCart");
			Users1 user=(Users1)request.getSession().getAttribute("loginUser");
			orderService.submitOrder(myCart, user);
		}catch(Exception e){
			System.out.println(e.getMessage());
			request.getRequestDispatcher("errInfo.jsp").forward(request, response);
		}
		Users1 user=(Users1)request.getSession().getAttribute("loginUser");
		System.out.println("���뷢��email");
		SendMail.sendToSomebody("<html>hello</html>", user.getName()+"��xx����g������������Ʒ����ȷ��", user.getEmail());
		request.getRequestDispatcher("orderOk.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
