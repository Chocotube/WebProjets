package Todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Todo.Task;

@WebServlet("/lab5")
public class todolist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("A cool task",false));
		
		getServletContext().setAttribute("tasks", tasks);
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
		out.println("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("	<title>Todo list</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Todo list</h1>");
		
		ArrayList<Task> tasks = (ArrayList<Task>) getServletContext().getAttribute("tasks");
		int todo = 0;
		for(Task task : tasks) {
			if(!task.isDone) {
				todo++;
			}
		}
		
		
		out.println("<a>Tasks remaining : " + todo + "/" + tasks.size() + "</a>");
		out.println("<a>Tasks accumplished : " + (tasks.size() - todo) + "</a>");
		
		out.println("	<table class=\"table\">");
		out.println("		<tr><th>Task</th><th>Is it done?</th><th>Modify</th></tr>");
		
		
		
		for( Task task : tasks) {
			out.println("		<tr>");
			out.println("			<td>" + task.getTaskname() + "</td>");
			out.println("			<td>" + task.getisDone() + "</td>");
			String btn = task.getisDone() ? "Mask as to do" : "Mark as done";
			
			out.println("			<td>   <a class=\"btn btn-primary\" href=\"Del?id=" + task.getId() + "\" role=\"button\">Delete</a> <a class=\"btn btn-primary\" href=\"Changeme?id=" + task.getId() + "\"role=\"button\">" + btn +"</a></td>");
			out.println("		</tr>");
		}
		
		out.println("	</table>");
		
		
		String name = request.getParameter("name");
		//String lastName = request.getParameter("lastName");
		
		name = name == null ? "" : name;
		//lastName = lastName == null ? "" : lastName;
		
		out.println("	<hr class=\"my-4\">");
		out.println("	<form action=\"lab5\" method=\"post\">");
		
		
		if (request.getAttribute("firstNameError") != null)
			out.println("<p class=\"text-danger\">" + request.getAttribute("firstNameError") + "</p>");
		
		out.println("		<input type=\"text\" value=\"" + name + "\" placeholder=\"The task name\" name=\"name\">");
		
		out.println("	</form>");
		
		out.println("<a class=\"btn btn-primary\" href=\"DelAllinactive\" role=\"Delete all done\">Delete all done</a>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String name = request.getParameter("name");
		//String lastName = request.getParameter("lastName");
		
		boolean isValidname;
		
		// Validate the first name
		if (name == null || name.trim().length() == 0)
			isValidname = false;
		else
			isValidname = true;
		if(isValidname)
		{
			ArrayList<Task> tasks = (ArrayList<Task>) getServletContext().getAttribute("tasks");
			tasks.add(new Task(name,false));
			response.sendRedirect("lab5");
			return;
		}
		// If we get here, there's a problem
		else {
			if (!isValidname)
				request.setAttribute("firstNameError", "You must enter a name");
		}
		
		doGet(request, response);
		
		
	}

}




