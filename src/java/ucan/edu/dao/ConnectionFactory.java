package ucan.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author tio-hecro
 */
public class ConnectionFactory 
{
    public Connection getConnection() 
    {
        try 
        {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost/ucandb",
                "postgres", "postgres");
        } 
        catch (Exception ex) 
        {
            throw new RuntimeException(
                "It wasn\'t possible to estabilish connection", ex);
        }
    }
    
}
