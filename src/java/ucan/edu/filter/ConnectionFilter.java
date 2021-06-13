/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucan.edu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import ucan.edu.dao.ConnectionFactory;
import ucan.edu.exception.FilterException;

/**
 *
 * @author tio-hecro
 */
@WebFilter(filterName = "ConnectionFilter", urlPatterns = {"/*"})
public class ConnectionFilter implements Filter 
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException 
    {
        Connection connection = new ConnectionFactory().getConnection();
        
        request.setAttribute("connection", connection);
        chain.doFilter(request, response);
        
        try 
        {
            connection.close();
        }
        catch (SQLException ex) 
        {
            throw new FilterException(
                "Connection filter couldn\'t filter request", ex);
        }
    }
}
