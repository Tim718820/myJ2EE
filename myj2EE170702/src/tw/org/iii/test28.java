package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test28")
public class test28 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account="",passwd ="";
		boolean isRemember = false;
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				
				if(name.equals("remember") && value.equals("true")) {
					isRemember = true;
				}
				if(name.equals("account")) {
					account = value;
				}
				if(name.equals("passwd")) {
					passwd = value;
				}
			}
			if(isRemember) {
				out.print(account + ":" + passwd);
			}else {
				out.print("No remeber");
			}
		}
	}
}
