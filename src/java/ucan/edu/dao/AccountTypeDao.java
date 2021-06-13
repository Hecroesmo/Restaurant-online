package ucan.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucan.edu.exception.DaoException;
import ucan.edu.model.AccountType;

/**
 * @author tio-hecro
 */
public class AccountTypeDao 
{
    private final Connection connection;
    private PreparedStatement statement;

    public AccountTypeDao(Connection connection) 
    {
        this.connection = connection;
    }
    
    public void add(AccountType accountType) 
    {
        String sql = "INSERT INTO account_type (description)"
            + "VALUES(?)";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, accountType.getDescription());
            statement.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            throw new RuntimeException(
                "It wasn\'t possible to add account type", ex);
        }
    }
    
    public AccountType getAccountTypeById(Long id)
    {
        String sql = "SELECT * FROM account_type WHERE pk_account_type=?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            AccountType accountType = new AccountType(
                resultSet.getLong("pk_account_type"),
                resultSet.getString("description"));
            
            return accountType;
        } 
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\t get account type", ex);
        }
    }
    
    public AccountType getAccountTypeByDescription(String description) 
    {
        String sql = "SELECT * FROM account_type"
            + " WHERE description=?";
                
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, description);
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            AccountType accountType = new AccountType(
                Long.parseLong(resultSet.getString("pk_account_type")),
                resultSet.getString("description"));
            
            return accountType;
        } 
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t get the id", ex);
        }
    } 
}
