package ucan.edu.mvc.logics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tio-hecro
 */
public class SignUpLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        return "WEB-INF/view/signup.jsp";
    }
    
}
