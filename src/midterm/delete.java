package midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.box;

/**
 * Servlet implementation class delete
 */
@WebServlet("/midterm/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
			
			// Get a reference to the Guest Book in the Servlet Context
		ArrayList<box> boxes = (ArrayList<box>) getServletContext().getAttribute("boxes");
		
			
			// Delete a entry from the guest book
		int i = 0;
		for (box entry : boxes) {
			if (entry.getId() == id) {
				boxes.remove(i);
				break;
			}
			++i;
		}
		response.sendRedirect("home");
		}
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
