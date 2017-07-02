package tw.org.iii;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test23")
public class test23 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salt = BCrypt.gensalt(12);
		String newpasswd = BCrypt.hashpw("123456", salt);
		System.out.println(newpasswd);
		
		if(ckPasswd("123456", newpasswd)) {
			System.out.println("OK!!");
		}else {
			System.out.println("XX");
		}
		
	}
	private static boolean ckPasswd(String orgPasswd, String hashPasswd){
		boolean isRigth = false;
		if(hashPasswd == null || !hashPasswd.startsWith("$2a$")) {
			isRigth = false;
		}
		isRigth = BCrypt.checkpw(orgPasswd, hashPasswd);
		
		return isRigth;
	}
}
