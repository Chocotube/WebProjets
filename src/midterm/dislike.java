package midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dislike
 */
@WebServlet("/midterm/dislike")
public class dislike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
			
			// Get a reference to the Guest Book in the Servlet Context
		ArrayList<box> boxes = (ArrayList<box>) getServletContext().getAttribute("boxes");
		
			
			// Delete a entry from the guest book
		for (box entry : boxes) {
			if (entry.getId() == id) {
				entry.plusdislike();
				break;
			}
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
