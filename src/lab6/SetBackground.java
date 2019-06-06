package lab6;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
//  /<context-root>/TemplateHtml
//  /<context-root>/images

@WebServlet({"/lab6/SetBackground"})
public class SetBackground extends HttpServlet {
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
		String name = getName(request);
		String del =( String)request.getParameter("delete");
		
		if (del != null && del.equals("1")) {
			
			Cookie[] cookies = request.getCookies();
			Cookie cookie = new Cookie("bgColor", "blue");
			cookie.setPath( request.getContextPath() );
			cookie.setMaxAge(0);
			response.addCookie( cookie );
			response.sendRedirect("SetBackground");
			
		}
		
		out.println("	<h1>Change your Bg color</h1>");
		
		out.println("	<form action=\"SetBackground\" method=\"post\">");
		
		
		
		out.println("		Color name : <input type=\"text\" name=\"name\"> <br>");
		

		out.println("		<input class=\"btn btn-success\" type=\"submit\" name=\"submitBtn\" value=\"Change color\">");
		out.println("	</form>");
		
		out.println("<style type=\"text/css\">");
		out.println("body { background: " + name + "!important; }");
		out.println("</style>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		if (name != null && name.trim().length() > 0) {
			
			Cookie cookie = new Cookie("bgColor", name);
			cookie.setPath( request.getContextPath() );
			cookie.setMaxAge(60*60*24*5);
			response.addCookie( cookie );
		}
		response.sendRedirect("ViewBackground");
		doGet(request, response);
		
		
	}

}
