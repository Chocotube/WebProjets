package user;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String un = request.getParameter("name");
		String file = request.getParameter("filename");
		Connection c = null;
	    String path = "";
	    
	    try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu100";
            String username = "cs3220stu100";
            String password = "Bc3RmGV*";

            c = DriverManager.getConnection( url, username, password ); // gets a new connection
            
            PreparedStatement ps = c.prepareStatement("select filepath from data where user_name=? and filename =?");
            ps.setString(1, un);
            ps.setString(2, file);
            
            ResultSet rs = ps.executeQuery();
            
            
            if( rs.next() )
            {
            	path = rs.getString("filepath");
            }
                     
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
	    
	    
	    
        response.setHeader( "Content-Disposition", "attachment; filename="+ file );

        FileInputStream in = new FileInputStream( path );
        OutputStream out = response.getOutputStream();

        byte buffer[] = new byte[2048];
        
        int bytesRead;
        
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );

        in.close();
        


        response.sendRedirect("Upload?name=" + un);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}