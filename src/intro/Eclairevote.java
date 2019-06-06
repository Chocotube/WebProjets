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

@WebServlet({"/Eclairevote"})
public class Eclairevote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext context = this.getServletContext();
		int Eclairevote = (int) context.getAttribute("Eclairevote");
		int totalvotes = (int) context.getAttribute("totalvotes");
		
		++Eclairevote;
		++totalvotes;
		
		context.setAttribute("Eclairevote", Eclairevote);
		context.setAttribute("totalvotes", totalvotes);
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta http-equiv=\"refresh\" content=\"0; URL='totalvotes\" />");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Document</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>You voted for Eclairevote</h1>");
		
		
		
		// Get the current value of count
		
		
		// Insert the page-specific content here...
		out.println("<a class=\"btn btn-primary\" href=\"totalvotes\" role=\"button\">Link</a>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}