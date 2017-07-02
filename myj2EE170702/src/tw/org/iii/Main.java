package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ResultSet rs = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			
			Connection conn = 
					DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/iii", prop);
			
			String delid = request.getParameter("delid");
			if(delid != null) {
				conn.createStatement().executeUpdate("DELETE FROM cust WHERE id =" + delid);
			}
			
			PreparedStatement pstmt =conn.prepareStatement(
					"SELECT * FROM cust");
			rs = pstmt.executeQuery();
			
			
			System.out.println("UpdateOK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		out.print("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.print("<a href='AddAccount'>Add</a>");
		out.print("<hr>");
		out.print("<table border='1' width='100%'>");
		out.print("<tr>\r\n" + 
				"		<th>ID</th>\r\n" + 
				"		<th>Name</th>\r\n" + 
				"		<th>Password</th>\r\n" + 
				"		<th>Delete</th>\r\n" + 
				"	</tr>");
		try {
			if (rs != null) {
				while (rs.next()) {
					String id = rs.getString("id");
					String account = rs.getString("account");
					out.print("<tr>");
					out.print("<td>" + id + "</td>");
					out.print("<td>" + account + "</td>");
					out.print("<td>" + rs.getString("passwd") + "</td>");
					out.print("<td><a href='?delid=" + id + 
							"' onclick='return confirm(\"Delete "
							+ account + "?\");'>Delete</a></td>");
					out.print("</tr>");
				}
			}
		}catch(Exception e) {
		}
		out.print("</table>");
		
	}

}
