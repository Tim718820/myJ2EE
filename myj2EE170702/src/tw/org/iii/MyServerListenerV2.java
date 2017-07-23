package tw.org.iii;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServerListenerV2 implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext servletContext = event.getServletContext();
		
		List<AsyncContext> asyncs = new LinkedList<>();
		servletContext.setAttribute("asyncs", asyncs);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		
	}

}
