package midterm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.box;
//  /<context-root>/TemplateHtml
//  /<context-root>/images

@WebServlet({"/midterm/home"})
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<box> boxes = new ArrayList<box>();
		boxes.add(new box("z0r.de","best gif website ever"));
		
		
		
		getServletContext().setAttribute("boxes", boxes);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Favorite websites</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Favorite websites</h1>");
		ArrayList<box> boxes = (ArrayList<box>) getServletContext().getAttribute("boxes");
		for(box box : boxes) {
			out.println("<h2> <a href= http://www."+ box.getboxname() + ">" + box.getboxname() + "</a></h2> <a href=\"delete?id=" + box.getId() + "\">Delete </a><br>");
			out.println(box.getdesc() + "<br>");
			out.println(box.getlike() + " likes " + box.getdislike() + " dislikes <a href=\"like?id=" + box.getId() + "\">Like </a>");
			out.println("<a href=\"dislike?id=" + box.getId() + "\">Dislike </a> <br><br>");
		}
		
		// Insert the page-specific content here...
		out.println("<h1> Add a Favorite website </h1>");
		
		String taskname = request.getParameter("taskname");
		taskname = "";
		String desc = request.getParameter("desc");
		desc = "";
		
		out.println("<form action = \"home\" method = \"post\"> ");
		out.println("<div class = \"form-group\"> ");
		out.println("<label class = \"\" for=\"title\">URL</label>");
		out.println("<input id=\"title\" class=\"form-control\" type=\"text\" name=\"taskname\" value=\"" + taskname + "\" placeholder=\"Enter an URL\"></input>");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label class =\"\" for=\"description\"> Description </label>");
		out.println("<textarea class=\"form-control\" rows=\"5\" id=\"description\" name=\"desc\" value=\"" + desc + " \" placeholder=\"Enter a description\"></textarea>");
		out.println("</div>");
		out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Add website\">");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<box> boxes = (ArrayList<box>) getServletContext().getAttribute("boxes");
		String taskname = request.getParameter("taskname");
		String desc = request.getParameter("desc");
		if("" != taskname && "" != desc)
			boxes.add(new box(taskname,desc));
		doGet(request, response);
	}

}