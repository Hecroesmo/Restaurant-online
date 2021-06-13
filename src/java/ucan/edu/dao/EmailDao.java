package ucan.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ucan.edu.exception.DaoException;
import ucan.edu.model.Person;

/**
 * @author tio-hecro
 */
public class EmailDao 
{
    private final Connection connection;
    private PreparedStatement statement;

    public EmailDao(Connection connection) 
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
            statement.setString(2, person.getEmail());
            statement.executeUpdate();
        }
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t add the email", ex);
        }
    }    
}
