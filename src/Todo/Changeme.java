package Todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Todo.Task;

@WebServlet({"/Changeme"})
public class Changeme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Set the content type to HTML
		// Get a reference to the Print Write to talk back to the client
		/*PrintWriter out = response.getWriter();
		ArrayList<Task> tasks = (ArrayList<Task>) getServletContext().getAttribute("tasks");
		int get_me = request.getIntHeader("id");
		int i = 0;
		
		while(tasks.get(i).id != get_me)
			i++;
		tasks.remove(i);*/
			// Get the index of the entry to be deleted
		int id = Integer.parseInt(request.getParameter("id"));
			
			// Get a reference to the Guest Book in the Servlet Context
		ArrayList<Task> tasks = (ArrayList<Task>) getServletContext().getAttribute("tasks");
			
			// Delete a entry from the guest book
		for (Task entry : tasks) {
			if (entry.getId() == id) {
				entry.isDone = !entry.isDone;
				break;
			}
		}
		
		// Redirect the User back to guest book
		
		// The template text/html
		response.sendRedirect("lab5");
		
		// Insert the page-specific content here...
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}