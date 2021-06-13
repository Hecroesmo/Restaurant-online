package ucan.edu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ucan.edu.exception.DaoException;
import ucan.edu.model.Account;
import ucan.edu.model.AccountType;
import ucan.edu.model.Employee;
import ucan.edu.model.Person;

/**
 * @author tio-hecro
 */
public class PersonDao 
{
    private final Connection connection;
    private PreparedStatement statement;

    public PersonDao(Connection connection) 
    {
        this.connection = connection;
    }
    
    public void add(Person person)
    {
        String sql = "INSERT INTO person VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        RegionDao regionDao = new RegionDao(connection);
        
        try 
        {
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, person.getIdentityCardNumber());
            statement.setString(2, person.getFirstName());
            statement.setString(3, person.getLastName());
            statement.setDate(4, new Date(person.getBirthDate().getTime()));
            
            statement.setString(5, regionDao.getRegionByName(
                person.getCountry()).getPkPortfolio());
            
            statement.setString(6, regionDao.getRegionByName(
                person.getProvince()).getPkPortfolio());
            
            statement.setString(7, regionDao.getRegionByName(
                person.getMunicipality()).getPkPortfolio());
            
            statement.setString(8, regionDao.getRegionByName(
                person.getCommune()).getPkPortfolio());
            
            statement.setString(9, person.getNeigborhood());
            statement.setString(10, person.getRoad());
            statement.setString(11, person.getHouseNumber());
            statement.executeUpdate();
        }
        catch (SQLException ex) 
        {
            throw new DaoException("couldn\t add person", ex);
        }
    }
}
