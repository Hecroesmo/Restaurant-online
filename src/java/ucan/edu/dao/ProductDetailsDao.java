package ucan.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ucan.edu.exception.DaoException;
import ucan.edu.model.Portfolio;
import ucan.edu.model.ProductDetails;

/**
 * @author tio-hecro
 */
public class ProductDetailsDao 
{
    private final Connection connection;
    private PreparedStatement statement;

    public ProductDetailsDao(Connection connection) 
    {
        this.connection = connection;
    }
    
    public void add(ProductDetails details)
    {
        String sql = "INSERT INTO product_details VALUES (?,?,?,?,?,?)";
        ProductDao productDao = new ProductDao(connection);
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, details.getFkProduct());
            statement.setInt(2, details.getQuantity());
            statement.setString(3, details.getImage());
            
            statement.setString(4, productDao.getProductByName(
                details.getFirstCategory()).getPkPortfolio());
            
            statement.setString(5, productDao.getProductByName(
                details.getSecondCategory()).getPkPortfolio());   
            
            statement.setString(6, productDao.getProductByName(
                details.getThirdCategory()).getPkPortfolio()); 
            
            statement.executeUpdate();
        } 
        catch (SQLException ex)
        {
            throw new DaoException(
                "it wasn\'t possible to add this product detail", ex);
        }
    }
    
    public List getList() 
    {
        String sql = "SELECT * FROM product_details";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List <ProductDetails> productDetails = new ArrayList<>();
            
            while (resultSet.next()) 
            {
                ProductDetails details = new ProductDetails();
                details.setFkProduct(resultSet.getString("fk_product"));
                details.setQuantity(resultSet.getInt("quantity"));
                details.setImage(resultSet.getString("image"));
                productDetails.add(details);
            }
            
            return productDetails;
            
        } catch (SQLException ex) 
        {
            throw new DaoException("Could\'nt list product details", ex);
        }
        
    }
        
    /*  public static void main(String []args)
    {
        Portfolio product = new ProductDao(
            new ConnectionFactory().getConnection()).getProductByName("Bolo rei");
        
        ProductDetails details = new ProductDetails();
        details.setFkProduct(product.getPkProduct());
        details.setQuantity(5);
        details.setImage("food-712665_640.jpg");
        
        //  new ProductDetailsDao(new ConnectionFactory().getConnection()).add(details);
        
        System.out.println(new ProductDetailsDao(new ConnectionFactory().
            getConnection()).getList());
    }   */
}
