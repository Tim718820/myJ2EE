package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test56", asyncSupported=true)
public class test56 extends HttpServlet {
	private ExecutorService executorService = 
			Executors.newFixedThreadPool(10);
	AsyncContext asyncContext;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		asyncContext = request.startAsync();
		executorService.submit(new AsyncRequest());
	}
	@Override
	public void destroy() {
		executorService.shutdown();
		super.destroy();
	}
	private class AsyncRequest implements Runnable{
		@Override
		public void run() {
			try {
				Thread.sleep(10 * 1000);
				
				PrintWriter out = asyncContext.getResponse().getWriter();
				out.print("OK3:" + (int)(Math.random()*49+1));
				asyncContext.complete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
