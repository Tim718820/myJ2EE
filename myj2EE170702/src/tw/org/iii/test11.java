package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/test11")
@MultipartConfig
public class test11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		Part part = req.getPart("upload");
		
		Collection<String> cc = part.getHeaderNames();
		for (String header : cc) {
			
			String v = part.getHeader(header);
			out.println(header + ":" + v + "<br />");
		}
		
		String filename = part.getSubmittedFileName();
		out.print(filename + "<br>");
		String name = part.getName();	// html input name
		long size = part.getSize();
		out.print(name + ":" + size + "<br/>");
		
		// ä»¥ä?‹é?‹å?‹è???–è?‡æ??
		byte[] buf = new byte[(int)size];
		BufferedInputStream bin = 
			new BufferedInputStream(part.getInputStream());
		bin.read(buf);
		bin.close();

		ServletContext context = getServletContext();
		Enumeration<String> names = context.getInitParameterNames();
		while (names.hasMoreElements()) {
			String pname = names.nextElement();
			out.println(pname + " = " + 
				context.getInitParameter(pname) + "<br>");
		}
		
				
		
		
		
//		FileOutputStream fout = 
//			new FileOutputStream(
//				"C:\\Users\\user01\\git_j2ee\\brad2101\\WebContent\\dir1\\" + filename);
		
//		FileOutputStream fout = 
//				new FileOutputStream(
//					"dir1/" + filename);
		
//		fout.write(buf);
//		fout.flush();
//		fout.close();
		
	}

}
