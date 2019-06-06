package kanban;

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
import kanban.state;
//  /<context-root>/TemplateHtml
//  /<context-root>/images

@WebServlet({"/kanban"})
public class tasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<state> tasks1 = new ArrayList<state>();
		tasks1.add(new state("A cool task","cool desc",1));
		
		ArrayList<state> tasks2 = new ArrayList<state>();
		tasks2.add(new state("the current cool task","cool desc",2));
		tasks2.add(new state("the current cool tasks","cool desc",2));
		tasks2.add(new state("the current cool taskss","cool desc",2));
		tasks2.add(new state("the current cool tasksss","cool desc",2));
		
		ArrayList<state> tasks3 = new ArrayList<state>();
		tasks3.add(new state("the done cool task","cool desc",3));
		
		
		getServletContext().setAttribute("tasks1", tasks1);
		getServletContext().setAttribute("tasks2", tasks2);
		getServletContext().setAttribute("tasks3", tasks3);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		ArrayList<state> tasks1 = (ArrayList<state>) getServletContext().getAttribute("tasks1");
		ArrayList<state> tasks2 = (ArrayList<state>) getServletContext().getAttribute("tasks2");
		ArrayList<state> tasks3 = (ArrayList<state>) getServletContext().getAttribute("tasks3");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Kanban</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<h1>KanBan</h1>");
		
		int i = 0;
		int j = 0;
		int k = 0;
		// Insert the page-specific content here...
		out.println("	<table class=\"table\">");
		out.println("		<tr><th>To do</th><th>Doing</th><th>Done</th></tr>");
		
		
		while(i < tasks1.size() || j < tasks2.size() || k < tasks3.size())
		{
			out.println("<tr>");
			if(i < tasks1.size())
			{
				out.println("			<td>Task name : " + tasks1.get(i).getTaskname() + "<br> description : " + tasks1.get(i).getdesc() + "<br> <a class=\"btn btn-primary\" href=\"Change?id=" + tasks1.get(i).getId() + "\" role=\"button\">Mark as doing</a> <a class=\"btn btn-primary\" href=\"Del1?id=" + tasks1.get(i).getId() + "\" role=\"button\">Delete</a> </td>");
				++i;
			}
			else {
				out.println("			<td></td>");
			}
			if(j < tasks2.size())
			{
				out.println("			<td>Task name : " + tasks2.get(j).getTaskname() + "<br> description : " + tasks2.get(j).getdesc() + "<br> <a class=\"btn btn-primary\" href=\"Change1?id=" + tasks2.get(j).getId() + "\" role=\"button\">Mark as done</a> <a class=\"btn btn-primary\" href=\"Del2?id=" + tasks2.get(j).getId() + "\" role=\"button\">Delete</a> </td>");
				++j;
			}
			else {
				out.println("			<td></td>");
			}
			if(k < tasks3.size())
			{
				out.println("			<td>" + tasks3.get(k).getTaskname() + "<br> description : " + tasks3.get(k).getdesc() + " </td>");
				++k;
			}
			else {
				out.println("			<td></td>");
		    }
			out.println("</tr>");
		}	
		
		String taskname = request.getParameter("taskname");
		taskname = "";
		String desc = request.getParameter("desc");
		desc = "";
		
		out.println("	</table>");
		
		out.println("<h1> ADD A KANBAN </h1>");
		
		out.println("<form action = \"kanban\" method = \"post\"> ");
		out.println("<div class = \"form-group\"> ");
		out.println("<label class = \"\" for=\"title\">Title</label>");
		out.println("<input id=\"title\" class=\"form-control\" type=\"text\" name=\"taskname\" value=\"" + taskname + "\" placeholder=\"Enter a Title\"></input>");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label class =\"\" for=\"description\"> Description </label>");
		out.println("<textarea class=\"form-control\" rows=\"5\" id=\"description\" name=\"desc\" value=\"" + desc + " \" placeholder=\"Enter a description\"></textarea>");
		out.println("</div>");
		out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Add Card\">");
		out.println("</form>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<state> tasks1 = (ArrayList<state>) getServletContext().getAttribute("tasks1");
		String taskname = request.getParameter("taskname");
		String desc = request.getParameter("desc");
		tasks1.add(new state(taskname,desc,1));
		doGet(request, response);
	}

}