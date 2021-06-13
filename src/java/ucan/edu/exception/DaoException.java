package ucan.edu.exception;

/**
 * @author tio-hecro
 */
public class DaoException extends RuntimeException
{
    public DaoException() 
    {
        super();
    }
    
    public DaoException(String message) 
    {
        super(message);
    }
    
    public DaoException(Throwable throwable) 
    {
        super(throwable);
    }
    
    public DaoException(String message, Throwable throwable) 
    {
        super(message, throwable);
    }
}
