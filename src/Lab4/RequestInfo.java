package Lab4;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lab4/*")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		Enumeration<String> parameters = request.getParameterNames();
		Enumeration<String> para =  request.getHeaderNames();
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Request Info</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Request Info</h1>");
		
		// Insert the page-specific content here...
        out.println( "<h3><small>Request Method: </small>" + request.getRequestURI() + "</h3>" );
        out.println( "<h3><small>Request URI: </small>" + request.getContextPath() + "</h3>" );
        out.println( "<h3><small>Context Path: </small>" + getServletContext().getRealPath("lab4") + "</h3>" );


        String acceptEncodingHeader = request.getHeader("Accept-Encoding");
        boolean isGzipSupported = acceptEncodingHeader.indexOf( "gzip" ) >= 0;

        if( isGzipSupported )
            out.println( "<h3>Yes, gzip is supported.</h3>" );
        else
            out.println( "<h3>No, gzip is not supported. </h3>" );
        
        out.println("<h1 class=\"display-4\">Request Headers</h1>");
       
        out.println("<table class=\"table table-bordered table-striped table-hover\">");
        out.println("<tr><th>Header</th><th>Value</th></tr>");
       
        while(para.hasMoreElements())
        {	
        	String currentpara = para.nextElement();
        	Enumeration<String> values = request.getHeaders(currentpara);
        	
        	out.println("<tr><td>"+currentpara+"</td><td>");
        	while(values.hasMoreElements())
        	{
        		String value = values.nextElement();
                out.println(value);
                if(values.hasMoreElements())
                	out.println(",");
                
        	}
        	out.println("</td></tr>");
        }
       
        out.println("</table>");
       
        out.println("<h1 class=\"display-4\">Request Paramaters</h1>");
       
        out.println("<table class=\"table table-bordered table-striped table-hover\">");
        out.println("<tr><th>Request Parameters</th><th>Value</th></tr>");
       
        while(parameters.hasMoreElements())
        {	
        	String currentpara = parameters.nextElement();
        	out.println("<tr><td>"+currentpara+"</td><td>");
        	String[] param = request.getParameterValues(currentpara);
        	
        	
            for (int i = 0; i < param.length; i++) {
                String valuee = param[i];
                out.println(valuee);
                if(i + 1 != param.length)
                	out.println(", ");
                
            }
        	out.println("</td></tr>");
        }
       
        out.println("</table>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}