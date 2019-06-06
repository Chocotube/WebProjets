package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;


/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("name");
		request.setAttribute("name", un);
		RequestDispatcher rd = request.getRequestDispatcher("Upload1.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String filename = request.getParameter("filename");	
	    String un = request.getParameter("name");

	    try {
	        
	        Connection c = DriverManager.getConnection("jdbc:mysql://cs3.calstatela.edu/cs3220stu100","cs3220stu100", "Bc3RmGV*"); // gets a new connection

            PreparedStatement ps = c.prepareStatement("delete from data where filename=?");
            ps.setString(1, filename);
	        int i = ps.executeUpdate();
	        if(i > 0) {
				request.setAttribute("deletevalue", "File deleted !");
	        }

	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
        response.sendRedirect("Upload?name=" + un);

	}

}
