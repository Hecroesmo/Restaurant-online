package ucan.edu.model;

import java.io.Serializable;

/**
 * @author tio-hecro
 */
public class Account implements Serializable
{
    private String username;
    private String password;
    private AccountType accountType;

    public Account() {}
    
    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, AccountType accountType) 
    {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public AccountType getAccountType() 
    {
        return accountType;
    }

    public void setAccountType(AccountType accountType) 
    {
        this.accountType = accountType;
    }

    @Override
    public String toString() 
    {
        return "Account{" + "username=" + username + ", password=" + password +
            ", accountType=" + accountType + '}';
    }
    
    
    
}
