package ucan.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ucan.edu.exception.DaoException;
import ucan.edu.model.Account;
import ucan.edu.model.AccountType;
import ucan.edu.model.Person;

/**
 * @author tio-hecro
 */
public class AccountDao 
{
    private final Connection connection;
    private PreparedStatement statement;

    public AccountDao(Connection connection) 
    {
        this.connection = connection;
    }
    
    public void add(Account account, Person person) 
    {
        String sql = "INSERT INTO account VALUES(?,?,?,?)";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            
            AccountTypeDao dao = new AccountTypeDao(connection);
            AccountType accountType = account.getAccountType();
            
            if (account.getUsername().equals("root") &&
                account.getPassword().equals("root")) 
            {
                statement.setLong(3, dao.getAccountTypeByDescription("root").getId());
            }
            else if (account.getUsername().equals("admin") &&
                account.getPassword().equals("admin")) 
            {
                statement.setLong(3, dao.getAccountTypeByDescription("admin").getId());
            }
            else if (account.getUsername().equals("cliente") &&
                account.getPassword().equals("cliente")) 
            {
                statement.setLong(3, dao.getAccountTypeByDescription("anonymous").getId());
            }
            else
            {
                statement.setLong(3, accountType.getId());
            }
            
            statement.setString(4, person.getIdentityCardNumber());
            statement.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            throw new DaoException("It wasn\'t possible to add the account", ex);
        }        
    }
    
    
    public Account getAccountById(String username) 
    {
        String sql = "SELECT * FROM account WHERE pk_username=?";
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            Account account = new Account();
            account.setUsername(resultSet.getString("pk_username"));
            account.setPassword(resultSet.getString("password"));
            
            account.setAccountType(
                new AccountTypeDao(connection).getAccountTypeById(
                    resultSet.getLong("fk_account_type")));
            
            return account;            
        } 
        catch (SQLException ex) 
        {
            throw new DaoException(
                "It was not possible to find account by username", ex);
        }
    }
    
    public static void main(String []args) 
    {
        Account account = new Account("tio_mona", "tio_123");
        Account account1 = new AccountDao(new ConnectionFactory().getConnection())
            .getAccountById(account.getUsername());
        System.out.println(account1);
    }
}
