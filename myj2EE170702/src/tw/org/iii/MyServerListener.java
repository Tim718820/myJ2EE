package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServerListener implements ServletContextListener {
	private ServletContext servletContext;
	private Timer timer;
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("init");
		
		ServletContext servletContext = event.getServletContext();
		servletContext.setAttribute("key3", "value3");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/brad",
					"root","root");
			servletContext.setAttribute("conn", conn);
			servletContext.setAttribute("isConnection", true);
			System.out.println("OK");
		}catch(Exception e) {
			servletContext.setAttribute("isConnection", false);
			System.out.println("XX");
		}
		
		timer = new Timer();
		//timer.schedule(new MyTask(), 1*1000, 1*1000);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("destroy");
		
		if ((Boolean)(servletContext.getAttribute("isConnection")) &&
				servletContext.getAttribute("conn") != null) {
			Connection conn = (Connection)servletContext.getAttribute("conn");
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("MySQL Close Error!");
			}
		}
		
		if (timer != null) {
			timer.cancel();
			timer.purge();
			timer = null;
		}
		
		
	}
	
	private class MyTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("TimerTask");
		}
	}
	
	
}
