package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("name");
        String pw = request.getParameter("password");
        
        HttpSession session = request.getSession(true);
        getServletContext().setAttribute("password", pw);
        session.setAttribute("password", pw);

        try {

            Connection c = DriverManager.getConnection("jdbc:mysql://cs3.calstatela.edu/cs3220stu100","cs3220stu100", "Bc3RmGV*"); // gets a new connection

            PreparedStatement ps = c.prepareStatement("select name,password from login where name=? and password=?");
            ps.setString(1, un);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                response.sendRedirect("Upload?name=" + un);
                return;
            }
            response.sendRedirect("Login_Register.jsp");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
