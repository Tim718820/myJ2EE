package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		if (account != null) {
			// ??•ç?†æ–°å¢?
			addAccount(account,passwd);
			response.sendRedirect("Main");
		}
		
		out.println("<form>");
		out.println("Account: <input name='account'><br>");
		out.println("Password: <input type='password' name='passwd'><br>");
		out.println("<input type='submit' value='Add'>");
		out.println("</form>");
	}
	
	private void addAccount(String account, String passwd) {
		String salt = BCrypt.gensalt(12);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			
			Connection conn = 
					DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/iii", prop);
			
			PreparedStatement pstmt =conn.prepareStatement(
					"INSERT INTO cust (account,passwd) VALUES (?,?)");
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, salt));
			pstmt.executeUpdate();
			
			
			System.out.println("UpdateOK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}


}
