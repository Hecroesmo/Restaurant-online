package ucan.edu.exception;

import javax.servlet.ServletException;

/**
 * @author tio-hecro
 */
public class FilterException extends ServletException
{
    public FilterException()
    {
        super();
    }
    
    public FilterException(String message)
    {
        super(message);
    }
    
    public FilterException(Throwable throwable)
    {
        super(throwable);
    }
    
    public FilterException(String message, Throwable throwable) 
    {
        super(message, throwable);
    }
}
