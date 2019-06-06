package user;

import java.io.File;





import java.io.IOException;
import java.util.List;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

import  org.apache.commons.fileupload.FileItem ;
import  org.apache.commons.fileupload.disk.DiskFileItemFactory ;
import  org.apache.commons.fileupload.servlet.ServletFileUpload ;

@WebServlet("/Upload")
public class Upload extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
    	String un = request.getParameter("name");
		Connection c = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
            c = DriverManager.getConnection("jdbc:mysql://cs3.calstatela.edu/cs3220stu100","cs3220stu100", "Bc3RmGV*"); // gets a new connection
            ps = c.prepareStatement("select filename,filepath from data where user_name=?");
            ps.setString(1, un);

	        rs = ps.executeQuery();
	        Result result = ResultSupport.toResult(rs);
	        request.setAttribute("result", result);
	        request.setAttribute("name", un);
	        RequestDispatcher rd = request.getRequestDispatcher("Upload1.jsp?name=" +un);
	        rd.forward(request, response);
	        
	    } catch(SQLException ex) {
	        throw new ServletException(ex);
	    }
    }
    

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
    	
        String un = request.getParameter("name");

    	
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        
        File repository = (File) servletContext.getAttribute( "javax.servlet.context.tempdir" );
        
        factory.setRepository( repository );

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload( factory );

        
        // The directory we want to save the uploaded files to.
        String fileDir = getServletContext().getRealPath( "/WEB-INF/uploads" );
        
        
        // Parse the request
        try
        {
            List<FileItem> items = upload.parseRequest(  request );
            Connection c = DriverManager.getConnection("jdbc:mysql://cs3.calstatela.edu/cs3220stu100","cs3220stu100", "Bc3RmGV*");
            int test = 0;
			PreparedStatement ps =(PreparedStatement) c.prepareStatement("insert into data (user_name,filename,filepath) values(?,?,?)");

			
			
            
            for( FileItem item : items )
            {
                // If the item is not a form field - meaning it's an uploaded
                // file, we save it to the target dir
                if( !item.isFormField() )
                {
                    // item.getName() will return the full path of the uploaded
                    // file, e.g. "C:/My Documents/files/test.txt", but we only
                    // want the file name part, which is why we first create a
                    // File object, then use File.getName() to get the file
                    // name.
                	// /var/usr/some/temp/dir/some-file.jpg
                	// /user/albert/3220/WEB-INF/uploads   some-file.jpg

                    String fileName = (new File( item.getName() )).getName();
                    File file = new File( fileDir, fileName );
                    item.write( file );                    
                    ps.setString(1,un);  	        
        			ps.setString(2,fileName);        
        	        ps.setString(3,fileDir);
        	        test = ps.executeUpdate();
                }
                
            }
            
			
           

        }
        catch( Exception e )
        {
            throw new IOException( e );
        }
        response.sendRedirect("Upload?name=" + un);
    }

}
