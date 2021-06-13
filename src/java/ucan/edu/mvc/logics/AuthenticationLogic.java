package ucan.edu.mvc.logics;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ucan.edu.dao.AccountDao;
import ucan.edu.dao.AccountTypeDao;
import ucan.edu.dao.ProductDao;
import ucan.edu.model.Account;
import ucan.edu.model.AccountType;

/**
 * @author tio-hecro
 */
public class AuthenticationLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        Connection connection = (Connection) req.getAttribute("connection");
        
        Account account = new Account(username, password);        
        Account databaseAccount = new AccountDao(connection).getAccountById(username);
        
        if (databaseAccount == null || !(password.equals(
            databaseAccount.getPassword()))) 
        {
            String errorMessage = "Autenticação falhou!";
            req.setAttribute("error", errorMessage);
            return "WEB-INF/view/login.jsp";
        }
        
        HttpSession session = req.getSession();
        session.setAttribute("account", databaseAccount);
        return "WEB-INF/view/index.jsp";
    }
    
}
