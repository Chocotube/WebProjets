package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import java.sql.*;


/**
 * Servlet implementation class result
 */
@WebServlet("/result")
public class result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    		    
    			String un = request.getParameter("name");
    			Connection c = null;
    		    PreparedStatement ps = null;
    		    ResultSet rs = null;

    		    try {
    	            c = DriverManager.getConnection("jdbc:mysql://cs3.calstatela.edu/cs3220stu100","cs3220stu100", "Bc3RmGV*"); // gets a new connection
    	            ps = c.prepareStatement("select * from data where user_name=?");
    	            ps.setString(1, un);

    		        rs = ps.executeQuery();
    		        Result result = ResultSupport.toResult(rs);
    		        request.setAttribute("result", result);
    		        RequestDispatcher rd = request.getRequestDispatcher("/showResult.jsp");
    		        rd.forward(request, response);
    		        
    		    } catch(SQLException ex) {
    		        throw new ServletException(ex);
    		    } 
    		}

}
