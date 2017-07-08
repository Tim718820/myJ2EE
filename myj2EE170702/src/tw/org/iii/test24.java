package tw.org.iii;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test24")
public class test24 extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		String rate = request.getParameter("rate");
		float floatRate = Float.parseFloat(rate);
		
		BufferedImage bimg = new BufferedImage(400, 20, BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bimg.createGraphics();
		
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, 400, 20);
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, (int)(400*floatRate/100), 20);
		
		//Output
		OutputStream out = response.getOutputStream();
		ImageIO.write(bimg, "jpeg", out);
		out.flush();
		out.close();
	}
	
}
