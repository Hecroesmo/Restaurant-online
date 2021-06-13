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
public class RegionDao implements PortfolioInterface
{
    private final Connection connection;
    private PreparedStatement statement;

    public RegionDao(Connection connection) 
    {
        this.connection = connection;
    }

    @Override
    public void add(Portfolio region) 
    {
        boolean containFkey = region.getFkPortfolio().equals("null");
        String sql;
        
        if (containFkey) 
        {
            sql = "INSERT INTO region VALUES(?,?)";
        }
        else
        {
            sql = "INSERT INTO region VALUES(?,?,?)";
        }
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, region.getPkPortfolio());
            statement.setString(2, region.getName());
            
            if (!containFkey)
            {
                statement.setString(3, region.getFkPortfolio());
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
        String sql = "SELECT * FROM region";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            List<Portfolio> regions = new ArrayList<>();
            
            while (resultSet.next())
            {
                Portfolio region = new Portfolio();
                region.setPkPortfolio(resultSet.getString("pk_region"));
                region.setName(resultSet.getString("name"));
                region.setFkPortfolio(resultSet.getString("fk_region"));
                regions.add(region);
            }
            
            return regions;
        } 
        catch (SQLException ex)
        {
            throw new DaoException("Couldn\'t list regions", ex);
        }
    }
    
    public List getCountries()
    {
        String sql ="SELECT * FROM region WHERE fk_region IS NULL";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            List<Portfolio> countries = new ArrayList<>();
            
            while (resultSet.next())
            {
                Portfolio country = new Portfolio();
                country.setPkPortfolio(resultSet.getString("pk_region"));
                country.setName(resultSet.getString("name"));
                country.setFkPortfolio(resultSet.getString("fk_region"));
                countries.add(country);
            }
            
            return countries;
        }
        catch (SQLException ex)
        {
            throw new DaoException("could\'t list countries", ex);
        }
    }
    
    public Portfolio getRegionByName(String name)
    {
        String sql = "SELECT * FROM region WHERE name=?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            
            resultSet.next();
            
            Portfolio region = new Portfolio(resultSet.getString("pk_region"),
                resultSet.getString("name"), resultSet.getString("fk_region"));
            
            return region;
        }
        catch (SQLException ex) 
        {
            throw new DaoException("couldn\'t get region by name", ex);
        }
    }
    
    public List getRegionsById(String id)
    {
        String sql = "SELECT * FROM region WHERE fk_region=?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Portfolio> regions = new ArrayList<>();
            
            while (resultSet.next())
            {
                Portfolio region = new Portfolio();
                region.setPkPortfolio(resultSet.getString("pk_region"));
                region.setName(resultSet.getString("name"));
                region.setFkPortfolio(resultSet.getString("fk_region"));
                
                regions.add(region);
            }
            
            return regions;
        }
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t list regions by id", ex);
        }
    }
    
    public Portfolio getRegionById(String id)
    {
        String sql = "SELECT * FROM region WHERE pk_region=?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            Portfolio region = new Portfolio();
            region.setPkPortfolio(resultSet.getString("pk_region"));
            region.setName(resultSet.getString("name"));
            region.setFkPortfolio(resultSet.getString("fk_region"));

            return region;
        }
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t get region by id", ex);
        }
    }
    
    /*  public static void main(String [] args)
    {
        System.out.println(new RegionDao(
            new ConnectionFactory().getConnection()).getRegionById("1.1"));
    }   */
}
