package kanban;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kanban.state;;

/**
 * Servlet implementation class change
 */
@WebServlet("/Change")
public class change extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
		
		// Get a reference to the Guest Book in the Servlet Context
	ArrayList<state> tasks1 = (ArrayList<state>) getServletContext().getAttribute("tasks1");
	ArrayList<state> tasks2 = (ArrayList<state>) getServletContext().getAttribute("tasks2");
	
		
		// Delete a entry from the guest book
	int i = 0;
	for (state entry : tasks1) {
		if (entry.getId() == id) {
			tasks2.add(entry);
			tasks1.remove(i);
			break;
		}
		++i;
	}
	
	// Redirect the User back to guest book
	
	// The template text/html
	response.sendRedirect("kanban");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
