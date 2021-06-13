package ucan.edu.mvc.logics;

import java.sql.Connection;
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
public class SaveProductDetailsLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception
    {
        String productFirstCategory = req.getParameter("productFirstCategory");
        String productSecondCategory = req.getParameter("productSecondCategory");
        String productThirdCategory = req.getParameter("productThirdCategory");
        String productName = req.getParameter("product");
        String quantity = req.getParameter("quantity");
        String priceStr = req.getParameter("price");
        String image = req.getParameter("image");
        
        Connection connection = (Connection) req.getAttribute("connection");
        
        Portfolio product = new ProductDao(connection).
            getProductByName(productName);
        
        ProductDetails details = new ProductDetails();
        details.setFirstCategory(productFirstCategory);
        details.setSecondCategory(productSecondCategory);
        details.setThirdCategory(productThirdCategory);
        details.setFkProduct(product.getPkPortfolio());
        details.setQuantity(Integer.parseInt(quantity));
        details.setImage(image);
        
        new ProductDetailsDao(connection).add(details);
        
        Price price = new Price(details.getFkProduct(),
            Double.parseDouble(priceStr));
        
        new PriceDao(connection).add(price);
        
        return "mvc?logic=ShowFirstLevelProductsLogic";
    }
    
}
