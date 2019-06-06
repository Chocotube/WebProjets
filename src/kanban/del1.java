package kanban;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class del1
 */
@WebServlet("/Del1")
public class del1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
		
		// Get a reference to the Guest Book in the Servlet Context
	ArrayList<state> tasks2 = (ArrayList<state>) getServletContext().getAttribute("tasks1");
	
		
		// Delete a entry from the guest book
	int i = 0;
	for (state entry : tasks2) {
		if (entry.getId() == id) {
			tasks2.remove(i);
			break;
		}
		++i;
	}
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
