import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class duo extends HttpServlet {
    private String message;
    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Hello World";
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
}
