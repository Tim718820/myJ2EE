package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test08")
public class test08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request
				int x, y, result, op;
				try {
					x = Integer.parseInt(request.getParameter("x"));
					y = Integer.parseInt(request.getParameter("y"));
					op = Integer.parseInt(request.getParameter("op"));
					
					switch (op) {
						case 1: result = x + y; break;
						case 2: result = x - y; break;
						case 3: result = x * y; break;
						case 4: result = x / y; break;
						default:
							result = 0;
					}
				}catch(Exception e) {
					x = y = result = op = 0;
				}
				
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append("<form>")
					.append("<input type='text' name='x' value='" + x + "' />")
					.append("<select name='op'>\n" + 
							"	<option value='1' " + (op==1?"selected":"") + ">+</option>\n" + 
							"	<option value='2' " + (op==2?"selected":"") + ">-</option>\n" + 
							"	<option value='3' " + (op==3?"selected":"") + ">x</option>\n" + 
							"	<option value='4' " + (op==4?"selected":"") + ">/</option>\n" + 
							"</select>")
					.append("<input type='text' name='y' value='" + y + "' />")
					.append("<input type='submit' value='=' />")
					.append("<span>" + result + "</span>")
					.append("</form>");
				
			}
	
	

}
