package ucan.edu.mvc.logics;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ucan.edu.dao.PriceDao;
import ucan.edu.model.Price;

/**
 * @author tio-hecro
 */
public class AlterPriceLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        String productId = req.getParameter("id");
        
        Connection connection = (Connection) req.getAttribute("connection");
        
        Price price = new PriceDao(connection).getPriceById(productId);
        
        req.setAttribute("price", price);
        
        return "WEB-INF/view/alterPrice.jsp";
    }
}
