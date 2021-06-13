package ucan.edu.mvc.logics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tio-hecro
 */
public class AgreeLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        String agree = req.getParameter("agreed");
        
        if (agree == null)
            return "WEB-INF/view/notAgreed.jsp";
        
        return "WEB-INF/view/login.jsp";
    }
    
}
