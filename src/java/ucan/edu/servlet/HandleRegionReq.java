package ucan.edu.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ucan.edu.dao.RegionDao;
import ucan.edu.model.Portfolio;

/**
 * @author tio-hecro
 */
@WebServlet(name = "HandleRegionReq", urlPatterns = {"/HandleRegionReq"})
public class HandleRegionReq extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException 
    {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        
        String name = req.getParameter("name");
        
        Connection connection = (Connection) req.getAttribute("connection");
       
        RegionDao dao = new RegionDao(connection);
        Portfolio region = dao.getRegionByName(name);
        List <Portfolio> regions = dao.getRegionsById(region.getPkPortfolio());

        Gson gson = new Gson();
        String strRegions = gson.toJson(regions);
        out.write(strRegions);
    }
}
