package ucan.edu.mvc.logics;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ucan.edu.dao.AccountDao;
import ucan.edu.dao.AccountTypeDao;
import ucan.edu.dao.EmailDao;
import ucan.edu.dao.EmployeeDao;
import ucan.edu.dao.PersonDao;
import ucan.edu.dao.PhoneNumberDao;
import ucan.edu.model.Account;
import ucan.edu.model.AccountType;
import ucan.edu.model.Employee;

/**
 * @author tio-hecro
 */
public class SaveEmployeeLogic implements Logic
{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception 
    {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthDate");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String socialSecurityNumber = req.getParameter("socialSecurityNumber");
        String identifyCardNumber = req.getParameter("identifyCardNumber");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String country = req.getParameter("country");
        String province = req.getParameter("province");
        String municipality = req.getParameter("municipality");
        String commune = req.getParameter("commune");
        String neighborhood = req.getParameter("neighborhood");
        String road = req.getParameter("road");
        String houseNumber = req.getParameter("houseNumber");
        
        
        Connection connection = (Connection) req.getAttribute("connection");
        
        AccountTypeDao accountTypeDao = new AccountTypeDao(connection);
        AccountType accountType = accountTypeDao.getAccountTypeByDescription("Employee");
        
        Account account = new Account(username, password, accountType);
        
        Employee employee = new Employee(socialSecurityNumber, salary);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
        
        employee.setBirthDate(date);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setIdentityCardNumber(identifyCardNumber);
        employee.setCountry(country);
        employee.setProvince(province);
        employee.setMunicipality(municipality);
        employee.setCommune(commune);
        employee.setNeigborhood(neighborhood);
        employee.setRoad(road);
        employee.setHouseNumber(houseNumber);
        employee.setAccount(account);
        
        new PersonDao(connection).add(employee);
        new AccountDao(connection).add(account, employee);
        new EmployeeDao(connection).add(employee);
        new PhoneNumberDao(connection).add(employee);
        new EmailDao(connection).add(employee);
        
        return "mvc?logic=EmployeeLogic";
    }
    
}
