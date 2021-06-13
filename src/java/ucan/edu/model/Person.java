package ucan.edu.model;

import java.util.Date;

/**
 * @author tio-hecro
 */
public class Person 
{
    private String identityCardNumber;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    private String country;
    private String province;
    private String municipality;
    private String commune; // or district
    private String neigborhood;
    private String road;
    private String houseNumber;
    private Account account;

    public Person() {}

    public Person(String identityCardNumber, String firstName, String lastName,
            Date birthDate, String email, String phoneNumber, String country,
            String province, String municipality, String commune, String neigborhood,
            String road, String houseNumber, Account account) 
    {
        this.identityCardNumber = identityCardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.province = province;
        this.municipality = municipality;
        this.commune = commune;
        this.neigborhood = neigborhood;
        this.road = road;
        this.houseNumber = houseNumber;
        this.account = account;
    }

    

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public Date getBirthDate() 
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) 
    {
        this.birthDate = birthDate;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() 
    {
        return country;
    }

    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getProvince() 
    {
        return province;
    }

    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getMunicipality() 
    {
        return municipality;
    }

    public void setMunicipality(String municipality) 
    {
        this.municipality = municipality;
    }

    public String getCommune() 
    {
        return commune;
    }

    public void setCommune(String commune) 
    {
        this.commune = commune;
    }

    public String getIdentityCardNumber() 
    {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) 
    {
        this.identityCardNumber = identityCardNumber;
    }

    public String getNeigborhood() 
    {
        return neigborhood;
    }

    public void setNeigborhood(String neigborhood) 
    {
        this.neigborhood = neigborhood;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() 
    {
        return "Person{" + "identityCardNumber=" + identityCardNumber +
            ", firstName=" + firstName + ", lastName=" + lastName +
            ", birthDate=" + birthDate + ", email=" + email + ", phoneNumber=" +
            phoneNumber + ", country=" + country + ", province=" + province +
            ", municipality=" + municipality + ", commune=" + commune +
            ", neigborhood=" + neigborhood + ", road=" + road + ", houseNumber=" +
        houseNumber + ", account=" + account + '}';
    }

    
}
