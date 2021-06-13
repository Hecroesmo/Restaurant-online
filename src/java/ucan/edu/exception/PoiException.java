package ucan.edu.exception;

/**
 * @author tio-hecro
 */
public class PoiException extends RuntimeException
{
    public PoiException()
    {
        super();
    }
    
    public PoiException(String message)
    {
        super(message);
    }
    
    public PoiException(Throwable throwable)
    {
        super(throwable);
    }
    
    public PoiException(String message, Throwable throwable) 
    {
        super(message, throwable);
    }
}
