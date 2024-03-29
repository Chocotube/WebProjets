package Lab4;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/SimpleAdder")
public class SimpleAdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Simple Adder</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Simple Adder</h1>");
		
		// Insert the page-specific content here...
		// The sum of <number1> and <number2> is: <sum>
		String str1 = request.getParameter("number1");
		String str2 = request.getParameter("number2");
		
		int num1 = 0, num2 = 0; // Defined here for Scope
		
		try {
			num1 = Integer.parseInt( str1 );
			num2 = Integer.parseInt( str2 );
		} catch(NumberFormatException e) {
			response.sendRedirect("../SimpleAdder.html");
			return; // Ensure that the doGet method stops executing.
		}
		
		out.println("<p class=\"lead\">The sum of " + num1 + " and " + num2 + " = " + (num1 + num2) + "</p>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}