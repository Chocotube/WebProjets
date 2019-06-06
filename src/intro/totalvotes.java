package intro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//  /<context-root>/TemplateHtml
//  /<context-root>/images

@WebServlet({"/totalvotes"})
public class totalvotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Total votes</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<h1 class=\"text-center\">Total votes</h1>");
		
		// Insert the page-specific content here...
		
		ServletContext context = this.getServletContext();
		
		// Get the current value of count
		int Chocotubevote = (int) context.getAttribute("Chocotubevote");
		int totalvotes = (int) context.getAttribute("totalvotes");
		int Eclairevote = (int) context.getAttribute("Eclairevote");
		int ApacheHelicopter = (int) context.getAttribute("ApacheHelicopter");
		
		out.println("<div class=\"row \"> ");
		out.println("<img src=\"http://cs3.calstatela.edu:8080/cs3220stu120/Chocotube.jpg\"  alt=\"...\">");
		out.println("<p class =\"lead\"> Chocotube has been voted " + Chocotubevote + " times or " + Chocotubevote * 100 / totalvotes + "% of all votes.</p>");
		out.println("</div>");
		
		out.println("<div class=\"row \"> ");
		out.println("<img src=\"http://cs3.calstatela.edu:8080/cs3220stu120/Chocotube.jpg\"  alt=\"...\">");
		out.println("<p class =\"lead\"> Eclair au chocolat has been voted " + Eclairevote + " times or " + Eclairevote * 100 / totalvotes + "% of all votes.</p>");
		out.println("</div>");
		
		out.println("<div class=\"row \"> ");
		out.println("<img src=\"http://cs3.calstatela.edu:8080/cs3220stu120/Apache.jpg\"  alt=\"...\">");
		out.println("<p class =\"lead\"> Apache Helicopter has been voted " + ApacheHelicopter + " times or " + ApacheHelicopter * 100 / totalvotes + "% of all votes.</p>");
		out.println("</div>");
		
		out.println("<a class=\"btn btn-primary\" href=\"votepage\" role=\"button\">Revote</a>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}