package ucan.edu.mvc.logics;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ucan.edu.dao.PriceDao;
import ucan.edu.dao.ProductDao;
import ucan.edu.dao.ProductDetailsDao;
import ucan.edu.model.Price;
import ucan.edu.model.Portfolio;
import ucan.edu.model.ProductDetails;

/**
 * @author tio-hecro
 */
public class ShowFirstLevelProductsLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        Connection connection = (Connection) req.getAttribute("connection");
        ProductDao productDao = new ProductDao(connection);
        PriceDao priceDao = new PriceDao(connection);
        
        List <ProductDetails> details = new ProductDetailsDao(connection).getList();
        List <Price> prices = new PriceDao(connection).getList();
        
        req.setAttribute("productDao", productDao);
        req.setAttribute("priceDao", priceDao);
        req.setAttribute("details", details);
        req.setAttribute("prices", prices);
        
        return "WEB-INF/view/product.jsp";
    }
}
