package tw.org.iii;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test26")
public class test26 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		
		String imgPath = getServletContext().getInitParameter("upload-path");
		File imgFile = new File(imgPath, "777.png");
		BufferedImage bimg = ImageIO.read(imgFile);
		Graphics2D g2d = bimg.createGraphics();
		
		//畫
		Font font = new Font(null, Font.BOLD+Font.ITALIC, 48);
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(45),100,0);
		Font newfont = font.deriveFont(tran);
		
		g2d.setFont(newfont);
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Hello World", 100, 200);
		
		//out
		OutputStream out = response.getOutputStream();
		File outFile = new File(imgPath, "my777.png");
		ImageIO.write(bimg, "png", out);
		ImageIO.write(bimg, "png", outFile);
		out.flush();
		out.close();
		
		
	}
}
