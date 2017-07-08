package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test27")
public class test27 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		Cookie cookieAccount = new Cookie("account", "Andy");
		cookieAccount.setMaxAge(1*60);
		response.addCookie(cookieAccount);
		
		Cookie cookiePassed = new Cookie("passwd", "12345");
		cookiePassed.setMaxAge(1*60);
		response.addCookie(cookiePassed);
		
		Cookie cookieRemember = new Cookie("remember", "false");
		cookieRemember.setMaxAge(1*60);
		response.addCookie(cookieRemember);
	}
}
