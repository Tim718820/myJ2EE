package tw.org.iii;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test43")
public class test43 extends HttpServlet {
	private ServletContext servletContext;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servletContext = getServletContext();
		try {
			Connection conn = (Connection)servletContext.getAttribute("conn");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into member (account,passwd,realname) values ('aa','bb','cc')");
			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}

}