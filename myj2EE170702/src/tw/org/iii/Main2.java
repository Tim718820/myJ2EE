package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Main2")
public class Main2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("member") == null) {
			//View
			response.sendRedirect("Login");
		}else {
		//System.out.println(session.getAttribute(arg0));
		//View
		request.getRequestDispatcher("Main2.jsp").forward(request, response);
		}
	}
}
