package ucan.edu.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ucan.edu.dao.ConnectionFactory;
import ucan.edu.model.Portfolio;
import ucan.edu.dao.PortfolioInterface;
import ucan.edu.dao.ProductDao;
import ucan.edu.dao.RegionDao;
/**
 * @author tio-hecro
 */

public class ExcelToDatabase 
{   
    private final PortfolioInterface portfolio;
    private final FileInputStream stream;
    private final HSSFWorkbook workbook;
    private final HSSFSheet sheet;
    private final int rows;
    private final int cols;    

    public ExcelToDatabase(PortfolioInterface portfolio, String path, String sheetName)
        throws FileNotFoundException, IOException
    {
        this.portfolio = portfolio;
        
        stream = new FileInputStream(path);
        workbook = new HSSFWorkbook(stream);
       
        sheet = workbook.getSheet(sheetName);
        rows = sheet.getLastRowNum();
        cols = sheet.getRow(0).getLastCellNum();  
    }
    
    public void read() 
    {
        for (int r = 0; r <= rows; r++)
        {
            HSSFRow row = sheet.getRow(r);
            
            for (int c = 0; c < cols; c += 2)
            {
                HSSFCell cell = row.getCell(c);
                String cellValue = getCellValue(cell);
                
                if (cellValue != null) 
                {
                    String id = cellValue;
                    cell = row.getCell(c + 1);
                    String name = getCellValue(cell);
                
                    persist(id, name);
                }                
            }
        }
        
        close();
    }
    
    private void persist(String id, String name)
    {
        Portfolio product = new Portfolio();
        product.setName(name);
        char [] ids = id.toCharArray();

        if (ids[2] == '0')
        {
            product.setPkPortfolio(getForeignKeyById(id));
            //  System.out.printf("%s\n", product.getPkPortfolio());
            product.setFkPortfolio("null");
        }                    
        else
        {
            product.setPkPortfolio(id);
            //  System.out.printf("%s\t", product.getPkPortfolio());
            product.setFkPortfolio(getForeignKeyById(id));
            //  System.out.printf("%s\n", product.getFkPortfolio());
        }

        portfolio.add(product);
    }
    
    private String getCellValue(HSSFCell cell) 
    {        
        switch(cell.getCellType())
        {
            case STRING: 
                return cell.getStringCellValue() + "";
            case NUMERIC:
                return cell.getNumericCellValue() + "";
            case BOOLEAN:
                return cell.getBooleanCellValue() + "";
        }
        
        return null;
    }
    
    private String getForeignKeyById(String id)
    {
        id = id.trim();
        int length = id.length();
        
        int indexLast = id.lastIndexOf('.', id.charAt(length - 1) == '.' ?
            length - 2 : length - 1 );
        
        return id.substring(0, indexLast); 
    }
    
    private void close()
    {
        try 
        {
            workbook.close();
            stream.close();
        } 
        catch (IOException ex) 
        {
            throw new RuntimeException(
                "Couldn\t close workbook or the file stream", ex);
        }
    }
    
    /*  public static void main(String [] args)
    {
        RegionDao dao = new RegionDao(new ConnectionFactory().getConnection());

        try {
            new ExcelToDatabase(dao, Def.REGION_PATH, "Region").read();
        } catch (IOException ex) {
            Logger.getLogger(ExcelToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   */
}
