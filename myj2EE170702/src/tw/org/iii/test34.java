package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test34")
public class test34 extends HttpServlet {
	private int i;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		new Timer().schedule(new MyTask(), 1000, 1000);
		
	}
	private class MyTask extends TimerTask {
		@Override
		public void run() {
			System.out.println(i++);
			
		}
	}
}
