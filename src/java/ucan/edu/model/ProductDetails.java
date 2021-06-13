package ucan.edu.model;

import java.io.Serializable;

/**
 * @author tio-hecro
 */
public class ProductDetails implements Serializable
{
    private String firstCategory;
    private String secondCategory;
    private String thirdCategory;
    private String fkProduct;
    private int quantity;
    private String image;

    public ProductDetails() {}

    public ProductDetails(String firstCategory, String secondCategory,
            String thirdCategory, String fkProduct, int quantity, String image) 
    {
        this.firstCategory = firstCategory;
        this.secondCategory = secondCategory;
        this.thirdCategory = thirdCategory;
        this.fkProduct = fkProduct;
        this.quantity = quantity;
        this.image = image;
    }

    public String getFirstCategory() 
    {
        return firstCategory;
    }

    public void setFirstCategory(String firstCategory)
    {
        this.firstCategory = firstCategory;
    }

    public String getSecondCategory() 
    {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) 
    {
        this.secondCategory = secondCategory;
    }

    public String getThirdCategory() 
    {
        return thirdCategory;
    }

    public void setThirdCategory(String thirdCategory) 
    {
        this.thirdCategory = thirdCategory;
    }

    public String getFkProduct() 
    {
        return fkProduct;
    }

    public void setFkProduct(String fkProduct) 
    {
        this.fkProduct = fkProduct;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public String getImage() 
    {
        return image;
    }

    public void setImage(String image) 
    {
        this.image = image;
    }

    @Override
    public String toString() 
    {
        return "ProductDetails{" + "fkProduct=" + fkProduct+ ", quantity="
            + quantity + ", image=" + image + '}';
    }    
}
