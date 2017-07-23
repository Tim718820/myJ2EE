package tw.org.iii;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener{

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		 ServletRequest req = event.getServletRequest();
		 
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		
		
	}
}
