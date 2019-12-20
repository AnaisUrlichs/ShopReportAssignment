
import org.junit.Test;
import java.io.*;

/**
 * The test class ReportTest; runs all methods in main() in the Report() class.
 *
 * @author Anais Urlichs
 * @version 15.12.2019
 */
public class ReportTest
{
    @Test
    public void InventoryTestOne() throws IOException
    {
        Report inventoryReportOne = new Report(); // creates a new Report instance for the test
        inventoryReportOne.createInventory(); // calls the createInventory() method of the new Report
        inventoryReportOne.calculateRevenue(); // calls the calculateRevenue() method of the new Report
        inventoryReportOne.calculateTotalRevenue(); // calles the calculateTotalRevenue() method of the new Report
        inventoryReportOne.printInventory(); // calls the printInventory() method of the new Report
        inventoryReportOne.saveReport(); // calls the saveReport() method of the new Report
    }    
}

