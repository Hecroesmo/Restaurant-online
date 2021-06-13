package ucan.edu.mvc.logics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tio-hecro
 */
public interface Logic {
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception;
}
