import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsServer;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletRequest resp)throws ServletException,IOException{
        doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletRequest)throws ServletException,IOException{
        String partname=req.getParameter("partname");//搜索内容
        IApostService service=new ApostService();
        List<Apost>aposts=service.findByPartName(partname);
        req.setAttribute("at",aposts);
        ServletResponse resp;
        req.getRequestDispatcher("search.jsp").forward(req,resp);
    }

    private class IApostService {
        public List<Apost> findByPartName(String partname) {
        }
    }

    private class ApostService extends IApostService {
    }

    private class Apost {
    }
}
