package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/test13")
@MultipartConfig
public class test13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String uploadPath = getServletContext().getInitParameter("upload-path");
		Part part = request.getPart("upload");
		
		String header = part.getHeader("Content-Disposition");
		//out.print(myAPI.getHeaderFileName(header)); //??�解字串
		
		String filename = myAPI.getHeaderFileName(header);
		
//		String filename = part.getSubmittedFileName();
		part.write(uploadPath + "/" + filename);
		out.print("Upload Success");
	}

}
