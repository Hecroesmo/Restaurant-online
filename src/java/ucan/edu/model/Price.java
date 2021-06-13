package ucan.edu.model;

import java.io.Serializable;

/**
 * @author tio-hecro
 */

public class Price implements Serializable
{
    private String fkProduct;
    private double price;

    public Price() {}    

    public Price(String fk_product, double price) 
    {
        this.fkProduct = fk_product;
        this.price = price;
    }

    public String getFkProduct() 
    {
        return fkProduct;
    }

    public void setFkProduct(String fk_product) 
    {
        this.fkProduct = fk_product;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    @Override
    public String toString() 
    {
        return "Price{" + "fkProduct=" + fkProduct + ", price=" + price + '}';
    }

}
