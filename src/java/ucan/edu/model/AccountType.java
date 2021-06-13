package ucan.edu.model;

import java.io.Serializable;

/**
 * @author tio-hecro
 */
public class AccountType implements Serializable
{
    private Long id;
    private String description;
    
    public AccountType() {}

    public AccountType(Long id, String description) 
    {
        this.id = id;
        this.description = description;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    @Override
    public String toString() 
    {
        return "AccountType{" + "id=" + id + ", description=" + description + '}';
    }
    
}
