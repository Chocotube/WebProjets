package project;

import java.io.IOException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class user
 */
@WebServlet("/register4531531")
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean hasError = false;
		if(username == null || username.trim().length() == 0) {
			hasError = true;
			request.setAttribute("UsernameError", "You must enter your username");
		}
		if (hasError)
			doGet(request, response);
		else {
			int err = 0;
			// Insert the record into the database
			java.sql.Connection c = null;
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu100";
				String sqlusername = "cs3220stu100";
	            String sqlpassword = "Bc3RmGV*";

	            c = DriverManager.getConnection( url, sqlusername, sqlpassword );
	            java.sql.Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from login" );

	            // Create an array list of guestbook entries to hold the data we retrieve from db
	       
	            
	            // For each record, create a new entry and add it to the list
	            while( rs.next() && err == 0)
	            {
	            	String name = rs.getString("name");

	            	if(name.equals(username)) {
	            		err = 1;
	            	}
	            	
	            }

	            if(err == 0) {
	            //String sql = "INSERT INTO guestbook (name, message) VALUES('" + name + "', '" + message + "')";
		            String sql = "INSERT INTO login (name, password) VALUES (?, ?)";
		            //ystem.out.println("Query: " + sql);
		            
		            PreparedStatement pstmt = c.prepareStatement(sql);
		            pstmt.setString(1, username);
		            pstmt.setString(2, password);
		            
		            int numberOfRowsAffected = pstmt.executeUpdate();
	            }
	            else {
	            	request.setAttribute("UsernameError", "You must enter your username or it has been already taken");
	            }
			}
			catch(SQLException e) {
				throw new ServletException(e);
			}
			finally
			{
				  try
		            {
		                if( c != null ) c.close();
		            }
		            catch( SQLException e )
		            {
		                throw new ServletException( e );
		            }
			}
			if(err == 0) {
				response.sendRedirect("register");
			}
			else {
				doGet(request, response);
			}
			
		
		}
		
	}


}
