package ucan.edu.model;

import java.util.Date;

/**
 * @author tio-hecro
 */
public class Employee extends Person
{
    private String socialSecurityNumber;
    private double salary;
      
    public Employee()
    {
        super();
    }

    public Employee(String socialSecurityNumber, double salary) 
    {
        this.socialSecurityNumber = socialSecurityNumber;
        this.salary = salary;
    }

    public Employee(String socialSecurityNumber, double salary, 
            String identityCardNumber, String firstName, String lastName,
            Date birthDate, String email, String phoneNumber, String country,
            String province, String municipality, String commune, String neigborhood,
            String road, String houseNumber, Account account) 
    {
        super(identityCardNumber, firstName, lastName, birthDate, email,
            phoneNumber, country, province, municipality, commune, neigborhood,
            road, houseNumber, account);
        
        this.socialSecurityNumber = socialSecurityNumber;
        this.salary = salary;
    }

    public String getSocialSecurityNumber() 
    {
        return socialSecurityNumber;
    }

    public double getSalary() 
    {
        return salary;
    }

    @Override
    public String toString() 
    {
        return "Employee{" + "socialSecurityNumber=" + socialSecurityNumber +
            ", salary=" + salary + '}';
    }
    
    
    
}
