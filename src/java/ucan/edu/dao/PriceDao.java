package ucan.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucan.edu.exception.DaoException;
import ucan.edu.model.Price;

/**
 * @author tio-hecro
 */
public class PriceDao 
{
    private final Connection connection;
    private PreparedStatement statement;

    public PriceDao(Connection connection) 
    {
        this.connection = connection;
    }
    
    public void add(Price price) 
    {
        String sql = "INSERT INTO price VALUES(?,?)";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, price.getFkProduct());
            statement.setDouble(2, price.getPrice());
            statement.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t add a new price", ex);
        }
    }
    
    public List getList()
    {
        String sql = "SELECT * FROM price";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Price> prices = new ArrayList<>();
            
            while (resultSet.next())
            {
                Price price = new Price();
                price.setFkProduct(resultSet.getString("fk_product_details"));
                price.setPrice(resultSet.getDouble("price"));
                prices.add(price);
            }
            
            return prices;
        } catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t list prices", ex);
        }
    }
    
    public Price getPriceById(String id)
    {
        String sql = "SELECT * FROM price where fk_product_details=?";
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            Price price = new Price(resultSet.getString("fk_product_details"),
                resultSet.getDouble("price"));
            
            return price;
        }
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t get price by id", ex);
        }
        
    }
    
    public void alter(Price price)
    {
        String sql ="UPDATE price SET price=? WHERE fk_product_details=?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, price.getPrice());
            statement.setString(2, price.getFkProduct());
            statement.executeUpdate();
        }
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t update the price", ex);
        }
    }
    
    /*  public static void main(String []args)
    {
        
        System.out.println(new PriceDao(new ConnectionFactory().
            getConnection()).getList());
    }   */
    
}
