package intro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/votepage"})
public class votepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext context = this.getServletContext();
		context.setAttribute("Chocotubevote", 0);
		context.setAttribute("Eclairevote", 0);
		context.setAttribute("ApacheHelicopter", 0);
		context.setAttribute("totalvotes", 0);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// Set the content type to HTML
		response.setContentType("text/html");
		
		// Get a reference to the Print Write to talk back to the client
		PrintWriter out = response.getWriter();
		
		// The template text/html
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>What do you call this ?</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		
		out.println("	<h1 class=\"text-center\">What is your favorite ?</h1>");
		
		
		// Insert the page-specific content here...
		out.println("<div class=\"row \"> ");
		out.println("<div class=\"col-md-4\">");
		out.println("<img src=\"http://cs3.calstatela.edu:8080/cs3220stu120/Chocotube.jpg\"  alt=\"...\">");
		out.println("</div>");
		
		out.println("<div class=\"col-md-4\">");
		out.println("<img src=\"http://cs3.calstatela.edu:8080/cs3220stu120/Chocotube.jpg\"alt=\"...\">");
		out.println("</div>");
		
		out.println("<div class=\"col-md-4\">");
		out.println("<img src=\"http://cs3.calstatela.edu:8080/cs3220stu120/Apache.jpg\" alt=\"...\">");
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class=\"row \"> ");
		
		out.println("<div class=\"col-md-4\">");
		out.println("<a class=\"btn btn-primary\" href=\"Eclairevote\" role=\"button\">Eclair au Chocolat</a>");
		out.println("</div>");
		
		out.println("<div class=\"col-md-4\">");		
		out.println("<a class=\"btn btn-primary\" href=\"Chocotubevote\"  role=\"button\">Chocotube</a>");
		out.println("</div>");
		
		out.println("<div class=\"col-md-4\">");
		out.println("<a class=\"btn btn-primary\" href=\"ApacheHelicopter\" role=\"button\">ApacheHelicopter</a>");
		out.println("</div>");
		out.println("</div>");
		
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}