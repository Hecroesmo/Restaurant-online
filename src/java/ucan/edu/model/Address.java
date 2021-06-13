package ucan.edu.model;

import java.io.Serializable;

/**
 * @author tio-hecro
 */
public class Address implements Serializable
{
    private String neighborhood;
    private String road;
    private String houseNumber;

    public Address() {}

    public Address(String neighborhood, String road, String houseNumber) 
    {
        this.neighborhood = neighborhood;
        this.road = road;
        this.houseNumber = houseNumber;
    }

    public String getNeighborhood() 
    {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) 
    {
        this.neighborhood = neighborhood;
    }

    public String getRoad() 
    {
        return road;
    }

    public void setRoad(String road) 
    {
        this.road = road;
    }

    public String getHouseNumber() 
    {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) 
    {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() 
    {
        return "Address{" + "neighborhood=" + neighborhood + ", road=" + road +
            ", houseNumber=" + houseNumber + '}';
    }    
}
