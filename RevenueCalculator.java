/**
 * This class will take the attributes of each Inventory class, given by the Report class, and calculate the revenue for the individual categories
 * and the total revenue for the shop. 
 *
 * @author Anais Urlichs
 * @version 15.12.2019
 */
import java.util.Scanner; 
import java.text.DecimalFormat;

public class RevenueCalculator
{
    // instance variables private since only this class can modify them
    private double totalRevenue;
    private double revenuePerItem;
    private double totalOrderCost;
    private double orderCostPerItem;
    private double totalSale;
    private double salePerItem;
    private double revenue;
    private static DecimalFormat df2 = new DecimalFormat("##.##");
    
    /**
     * Constructor for objects of class RevenueCalculator
     */
    public RevenueCalculator() {
        totalRevenue = 0;
        revenuePerItem = 0;
        totalOrderCost = 0;
        orderCostPerItem = 0;
        salePerItem = 0;
        totalSale = 0;
        revenue = 0;
    }
    
    /**
     * Method called by getRevenuePerItem() to separate the calculation logic from the data
     * The method is private since it can only be called from the getter method of this class this class
     *
     * @param inventoryItem of type Inventory given from getRevenuePerItem()
     * @return calculated revenuePerItem
     */
    private double setRevenuePerItem(Inventory inventoryItem) {
        System.out.println(inventoryItem.numSold);
        orderCostPerItem = inventoryItem.numOrdered * inventoryItem.orderCost; // multiply individual order cost with the number of items ordered
        salePerItem = inventoryItem.numSold * inventoryItem.priceSoldAt; // multiply the number of items sold with the price the item is sold at

        totalOrderCost = totalOrderCost + orderCostPerItem; // calculates the totalOrderCost for the category
        revenuePerItem = salePerItem - orderCostPerItem; // calculate the revenue per item
        
        revenuePerItem = Double.parseDouble(df2.format(revenuePerItem)); // formats the revenue to 2 decimal numbers
        
        return revenuePerItem;
    }
    
    /**
     * Method called by getTotalRevenue() to separate the calculation logic from the data; calculates the total Revenue of the given category
     *
     * @return calculates totalRevenue
     */
    private double setTotalRevenue() {
        totalSale = totalSale + salePerItem; // calculates the totalSale of the category
        totalRevenue = totalSale - totalOrderCost; // calculates the Revenue/profit made from this category
        
        totalRevenue = Double.parseDouble(df2.format(totalRevenue)); // formats the revenue to 2 decimal numbers
        return totalRevenue;
    }
    
    /**
     * Method called by calculateRevenue() in class Report
     * 
     * @param inventoryItem of type Inventory given from calculateRevenuePerItem() method in the Report class
     * @return this.revenuePerItem
     */
    public double getRevenuePerItem(Inventory inventoryItem) {
        setRevenuePerItem(inventoryItem); // call method setRevenuePerItem() with the values of the current Inventory item 
        return revenuePerItem;
    }
    
    /**
     * Method called by calculateTotalRevenue() in class Report
     * 
     * @return this.totalRevenue
     */
    public double getTotalRevenue() {
        setTotalRevenue(); // call method setTotalRevenue()
        return totalRevenue; 
    }
}