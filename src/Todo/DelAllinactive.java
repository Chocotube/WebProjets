package Todo;
 
import java.io.IOException;

import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import Todo.Task;;
 
/**
 * Servlet implementation class Remove
 */
@WebServlet("/DelAllinactive")
public class DelAllinactive extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
@SuppressWarnings("unchecked")
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        try {
            // Get a reference to the Guest Book in the Servlet Context
            ArrayList<Task> Entries = (ArrayList<Task>) getServletContext().getAttribute("tasks");
           
            // Delete a entry from the guest book
            int i = 0;
            int size = Entries.size();
            while (i < size)
            {
                if(Entries.get(i).isDone)
                {
                Entries.remove(i);
                size = Entries.size();
                }
                else {
                    i++;
                }
                }
            } catch (Exception e) {}
       
        // Redirect the User back to guest book
        response.sendRedirect("lab5");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
 
}