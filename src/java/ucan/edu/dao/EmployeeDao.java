package ucan.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ucan.edu.exception.DaoException;
import ucan.edu.model.Employee;

/**
 * @author tio-hecro
 */
public class EmployeeDao 
{
    private final Connection connection;
    private PreparedStatement statement;

    public EmployeeDao(Connection connection) 
    {
        this.connection = connection;
    }
    
    public void add(Employee employee)
    {
        String sql = "INSERT INTO employee VALUES (?,?,?)";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getSocialSecurityNumber());
            statement.setDouble(2, employee.getSalary());
            statement.setString(3, employee.getIdentityCardNumber());
            statement.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            throw new DaoException("Couldn\'t add new employee", ex);
        }
    }
    
    public List getList()
    {
        String sql = "SELECT * FROM person AS P INNER JOIN employee "
            + "ON pk_identify_card_number = fk_identify_card_number";
        RegionDao regionDao = new RegionDao(connection);
        try 
        {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List <Employee> employees = new ArrayList<>();
            
            while (resultSet.next())
            {
                Employee employee = new Employee();
                employee.setIdentityCardNumber(
                    resultSet.getString("pk_identify_card_number"));
                
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setBirthDate(new Date(resultSet.getDate("birth_date").getTime()));
                
                employee.setCountry(regionDao.getRegionById(
                    resultSet.getString("fk_country")).getName());
                
                employee.setProvince(regionDao.getRegionById(
                    resultSet.getString("fk_province")).getName());
                
                employee.setMunicipality(regionDao.getRegionById(
                    resultSet.getString("fk_municipality")).getName());
                
                employee.setCommune(regionDao.getRegionById(
                    resultSet.getString("fk_commune")).getName());
                
                //  -------------------------------------MISSING
            }
            
            return employees;
        } 
        catch (SQLException ex) 
        {
            throw new DaoException("couldn\t list employess", ex);
        }  
        
    }
}
