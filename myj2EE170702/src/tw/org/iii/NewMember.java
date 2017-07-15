package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.org.iii.bean.Member2;

@WebServlet("/NewMember")
public class NewMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//1.prepare
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String realname = request.getParameter("realname");
		
		//2.Model
		try {
			Member2 member = new Member2();
			member.setAccount(account);
			member.setPasswd(passwd);
			member.setRealname(realname);
			boolean result = member.newInsert();
			
			//View
			request.setAttribute("result", result);
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("syserror.jsp").forward(request, response);
		}
	}
}
