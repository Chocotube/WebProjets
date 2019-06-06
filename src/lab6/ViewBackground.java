package lab6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//  /<context-root>/TemplateHtml
//  /<context-root>/images

@WebServlet({"/lab6/ViewBackground"})
public class ViewBackground extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String getName( HttpServletRequest request )
    {
        Cookie[] cookies = request.getCookies();
        
        if( cookies != null )
            for( Cookie cookie : cookies )
                if( cookie.getName().equals( "bgColor" ) )
                    return cookie.getValue();

        return null;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Document</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Your Heading Here</h1>");
		out.println("<a href=\"SetBackground?delete=1\" class=\"btn btn-secondary btn-lg active\" role=\"button\" aria-pressed=\"true\">Call the cookie monster (delete cookies)</a>");
		out.println("<a href=\"SetBackground\" class=\"btn btn-secondary btn-lg active\" role=\"button\" aria-pressed=\"true\">Set another color</a>");
		// Insert the page-specific content here...
		String name = getName(request);
		out.println("<style type=\"text/css\">");
		out.println("body { background: " + name + "!important; }");
		out.println("</style>");
		
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

