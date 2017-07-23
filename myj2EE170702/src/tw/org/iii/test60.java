package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test60")
public class test60 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mesg = request.getParameter("mesg");
		
		//資料庫更新
		Connection conn = (Connection)getServletContext().getAttribute("conn");
		if(conn !=null) {
			Statement stmt;
			try {	
				stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO message (mesg) VALUES ('" + mesg + "')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//發送
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List)servletContext.getAttribute("asyncs");

		synchronized (asyncs) {
			for (AsyncContext asyncContext : asyncs) {
				System.out.println("send");
				
				HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse(); 
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print(mesg);
				asyncContext.complete();
			}
			asyncs.clear();
		};
		response.sendRedirect("test93.html");
	}

}
