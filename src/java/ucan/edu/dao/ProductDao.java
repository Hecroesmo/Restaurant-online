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
import ucan.edu.model.Portfolio;

/**
 * @author tio-hecro
 */
public class ProductDao implements PortfolioInterface
{
    private final Connection connection;
    private PreparedStatement statement;
    
    public ProductDao(Connection connection) 
    {
        this.connection = connection;
    }
    
    @Override
    public void add(Portfolio product) 
    {
        boolean containFkey = product.getFkPortfolio().equals("null");
        String sql;
        
        if (containFkey) 
        {
            sql = "INSERT INTO product VALUES(?,?)";
        }
        else
        {
            sql = "INSERT INTO product VALUES(?,?,?)";
        }
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, product.getPkPortfolio());
            statement.setString(2, product.getName());
            
            if (!containFkey)
            {
                statement.setString(3, product.getFkPortfolio());
            }
            
            statement.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            throw new DaoException("It wasn\'t possible add", ex);
        }   
    }
    
    public List getList()
    {
        String sql = "SELECT * FROM product";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            List<Portfolio> products = new ArrayList<>();
            
            while (resultSet.next())
            {
                Portfolio product = new Portfolio();
                product.setPkPortfolio(resultSet.getString("pk_product"));
                product.setName(resultSet.getString("name"));
                product.setFkPortfolio(resultSet.getString("fk_product"));
                products.add(product);
            }
            
            return products;
        } 
        catch (SQLException ex)
        {
            throw new DaoException("Couldn\'t list products", ex);
        }
    }
    
    public List getFirstLevelList()
    {
        String sql ="SELECT * FROM product WHERE fk_product IS NULL";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            List<Portfolio> products = new ArrayList<Portfolio>();
            
            while (resultSet.next())
            {
                Portfolio product = new Portfolio();
                product.setPkPortfolio(resultSet.getString("pk_product"));
                product.setName(resultSet.getString("name"));
                product.setFkPortfolio(resultSet.getString("fk_product"));
                products.add(product);
            }
            
            return products;
        }
        catch (SQLException ex)
        {
            throw new DaoException("could\'t list first level products", ex);
        }
    }
    
    public Portfolio getProductByName(String productName)
    {
        String sql = "SELECT * FROM product WHERE name=?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, productName);
            ResultSet resultSet = statement.executeQuery();
            
            resultSet.next();
            
            Portfolio product = new Portfolio(resultSet.getString("pk_product"),
                resultSet.getString("name"), resultSet.getString("fk_product"));
            
            return product;
        }
        catch (SQLException ex) {
            throw new DaoException("couldn\'t get product by name", ex);
        }
    }
    
    public List getListById(String id)
    {
        String sql = "SELECT * FROM product WHERE fk_product=?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Portfolio> products = new ArrayList<>();
            
            while (resultSet.next())
            {
                Portfolio newProduct = new Portfolio();
                newProduct.setPkPortfolio(resultSet.getString("pk_product"));
                newProduct.setName(resultSet.getString("name"));
                newProduct.setFkPortfolio(resultSet.getString("fk_product"));
                
                products.add(newProduct);
            }
            
            return products;
        }
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t get list by id", ex);
        }
    }
    
    public Portfolio getProductById(String id)
    {
        String sql = "SELECT * FROM product WHERE pk_product=?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            Portfolio product = new Portfolio();
            product.setPkPortfolio(resultSet.getString("pk_product"));
            product.setName(resultSet.getString("name"));
            product.setFkPortfolio(resultSet.getString("fk_product"));
            
            return product;
        } 
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t get the product by id", ex);
        }
    }
    
    public void deleteAll() 
    {
        String sql = "DELETE FROM product";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch (SQLException ex) 
        {
            throw new DaoException("It was not possible to delete all product", ex);
        }
    }
    
    /*  public static void main(String [] args)
    {
        System.out.println(new ProductDao(
            new ConnectionFactory().getConnection()).getProductById("1.1.1.3"));
    }   */
}
