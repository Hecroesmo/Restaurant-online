package ucan.edu.model;

import java.io.Serializable;

/**
 * @author tio-hecro
 */
public class Portfolio implements Serializable
{
    private String pkPortfolio;
    private String name;
    private String fkPortfolio;

    public Portfolio() {}

    public Portfolio(String pkPortfolio, String name, String fkPortfolio) {
        this.pkPortfolio = pkPortfolio;
        this.name = name;
        this.fkPortfolio = fkPortfolio;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getPkPortfolio() 
    {
        return pkPortfolio;
    }

    public void setPkPortfolio(String pkPortfolio) 
    {
        this.pkPortfolio = pkPortfolio;
    }

    public String getFkPortfolio() 
    {
        return fkPortfolio;
    }

    public void setFkPortfolio(String fkPortfolio) 
    {
        this.fkPortfolio = fkPortfolio;
    }

    @Override
    public String toString() 
    {
        return "Product{" + "pkProduct=" + pkPortfolio + ", name=" + name + ","
            + " fkProduct=" + fkPortfolio + '}';
    } 
}
