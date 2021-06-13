package ucan.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ucan.edu.mvc.logics.Logic;

/**
 * @author tio-hecro
 */
public class ControllerServlet extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException 
    {
        String parameter = req.getParameter("logic");  
        String className = "ucan.edu.mvc.logics." + parameter;
        
        try 
        {
            Class theClass = Class.forName(className);
            Logic logic = ( Logic ) theClass.newInstance();
            String page = logic.execute(req, resp);
            req.getRequestDispatcher(page).forward(req, resp);
        } 
        catch (Exception ex) 
        {
            
        }
    }
    

}
