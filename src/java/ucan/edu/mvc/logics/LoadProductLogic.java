package ucan.edu.mvc.logics;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ucan.edu.dao.ProductDao;
import ucan.edu.utility.Def;
import ucan.edu.utility.ExcelToDatabase;

/**
 * @author tio-hecro
 */
public class LoadProductLogic implements Logic
{    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        Connection connection = (Connection) req.getAttribute("connection");
        ProductDao productDao = new ProductDao(connection);
        productDao.deleteAll();
        new ExcelToDatabase(productDao, Def.PRODUCT_PATH, "Products").read();
        return "WEB-INF/view/dashboard.jsp";
    }
}
