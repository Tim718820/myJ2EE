package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test19")
public class test19 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//0.prepare
		String x = request.getParameter("x");
		String y = request.getParameter("y");
	    if (x == null) x = "0";
	    if (y == null) y = "0";
	    
	    //1.Model
	    test20 model = new test20(x,y);
	    int result = model.add();
	    
	    //2.forward -> View 
	    request.setAttribute("x", x);
	    request.setAttribute("y", y);
	    request.setAttribute("result", result);
	    request.getRequestDispatcher("test21").forward(request, response);
		
	}
	
}
