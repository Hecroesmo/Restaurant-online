package ucan.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucan.edu.exception.DaoException;
import ucan.edu.model.Person;

/**
 * @author tio-hecro
 */
public class PhoneNumberDao 
{
    private final Connection connection;
    private PreparedStatement statement;

    public PhoneNumberDao(Connection connection)
    {
        this.connection = connection;
    }
    
    public void add(Person person)
    {
        String sql = "INSERT INTO email VALUES (?,?)";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, person.getIdentityCardNumber());
            statement.setString(2, person.getPhoneNumber());
            statement.executeUpdate();
        }
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t add the phoneNumber", ex);
        }
    }
}
