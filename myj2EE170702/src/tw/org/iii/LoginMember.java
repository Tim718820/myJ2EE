package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.org.iii.bean.Member2;

/**
 * Servlet implementation class LoginMember
 */
@WebServlet("/LoginMember")
public class LoginMember extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//1.prepare
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		//2.Model
		try {
			Member2 member = new Member2();
			member.setAccount(account);
			member.setPasswd(passwd);
			
			System.out.println(member.getAccount());
			if(member.isValidMember()) {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("Main2");
			}else {
				out.print("XX");
			}
		} catch (Exception e) {
			out.print(e);
		}
	}

}
