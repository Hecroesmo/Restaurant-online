package ucan.edu.mvc.logics;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ucan.edu.dao.PriceDao;
import ucan.edu.model.Price;

/**
 * @author tio-hecro
 */
public class SavePriceLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        String productId = req.getParameter("id");
        Double productPrice = Double.parseDouble(req.getParameter("price"));
        
        Price price = new Price(productId, productPrice);
        
        Connection connection = (Connection) req.getAttribute("connection");
        new PriceDao(connection).alter(price);
        
        return "mvc?logic=ShowFirstLevelProductsLogic";
    }
    
}
