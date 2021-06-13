package ucan.edu.mvc.logics;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ucan.edu.dao.RegionDao;
import ucan.edu.model.Portfolio;
import ucan.edu.mvc.logics.Logic;

/**
 * @author tio-hecro
 */
public class EmployeeLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        Connection connection = (Connection) req.getAttribute("connection");
        List <Portfolio> countries = new RegionDao(connection).getCountries();
        
        req.setAttribute("countries", countries);
        return "WEB-INF/view/employeeRegister.jsp";
    }
    
}
