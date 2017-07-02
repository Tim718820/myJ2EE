package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/test14")
@MultipartConfig
public class test14 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String uploadPath = getServletContext().getInitParameter("upload-path");
		
		Collection<Part> parts = request.getParts();
		
		//out.print(parts.isEmpty());
		for(Part part:parts) {
			String header = part.getHeader("Content-Disposition");
			String filename = myAPI.getHeaderFileName(header);
			if(filename != null && filename.length() > 0) {
				part.write(uploadPath + "/" + filename);
			}
		}
	}

}
