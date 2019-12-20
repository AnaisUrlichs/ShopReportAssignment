
/**
 * The Report class contains the main method that creates a new instanc of Report; each of which
 * calls several methods to set the state of a new Report.
 *
 * @author Anais Urlichs
 * @version 15.12.2019
 */
import java.io.*; 

public class Report
{
    int inventorySize = 1; // variable to store the array size; the number of inventory items 
    Inventory inventory[] = new Inventory[inventorySize]; // new inventory array of type Inventory
    double revenues[] = new double[inventorySize]; //new revenue array
    
    /*
     * List of new RevenueCalculator objects set per category of inventory items
     */
    RevenueCalculator tools = new RevenueCalculator(); 
    RevenueCalculator stationery = new RevenueCalculator();
    RevenueCalculator grocery = new RevenueCalculator();
    
    /*
     * Each Report will create the following variables of datatype double since they store the revenue
     */
    private double totalToolRevenue = 0;
    private double totalStationeryRevenue = 0;
    private double totalGroceryRevenue = 0;
    private double totalRevenue = 0;
    
    /*
     * Main Java method of the program, this method is used to run the program
     */
    public static void main(String args[]) throws IOException
    {
        Report report = new Report(); // creates a new Report instance

        report.createInventory(); // calls the createInventory() method of the new Report
        report.calculateRevenue(); // calls the calculateRevenue() method of the new Report
        report.calculateTotalRevenue(); // calles the calculateTotalRevenue() method of the new Report
        report.printInventory(); // calls the printInventory() method of the new Report
        report.saveReport(); // calls the saveReport() method of the new Report
    }
    
    /*
     * Method called by main() to fill the inventory array with new inventory items
     */
    public void createInventory() {
        for(int i = 0; i < inventory.length; i ++) { // iterate through the length of the array starting at 0
            inventory[i] = new Inventory(); // for every i in inventory[i] create a new Inventory object
        }
    }
    
    /*
     * Method called by main() to calculate the revenue per inventory object in inventory[]
     */
    public void calculateRevenue() {
         for(int i = 0; i < inventory.length; i ++) { // iterate through the length of the array starting at 0           
            String type = inventory[i].inventoryType; // type is the itemType per Inventory object in inventory[]
            Inventory inventoryItem = inventory[i]; // inventoryItem is the current inventory object

            if(type.equals("tools")) { // identify the categroy of type
               double revenue = this.tools.getRevenuePerItem(inventoryItem); // set revenue to the calculated revenue of category tools
               revenues[i] = revenue; // set the calculated revenue to the current place in revenue[]
               
            }else if(type.equals("stationery")) { // identify the categroy of type
               double revenue = this.stationery.getRevenuePerItem(inventoryItem);
               revenues[i] = revenue; // set the calculated revenue to the current place in revenue[]
               
            }else if(type.equals("grocery")) { // identify the categroy of type
               double revenue = this.grocery.getRevenuePerItem(inventoryItem);
               revenues[i] = revenue; // set the calculated revenue to the current place in revenue[]
            }
        }
    }

    /*
     * Method called by main() to calculate the total Revenue per category by calling the getTotalRevenue() method in the RevenueCalculator() class
     */
    public void calculateTotalRevenue() { 
        this.totalToolRevenue = this.tools.getTotalRevenue(); // calculates the total revenue through the getTotalRevenue() class 
        this.totalStationeryRevenue = this.stationery.getTotalRevenue();
        this.totalGroceryRevenue = this.grocery.getTotalRevenue();
        this.totalRevenue = this.totalToolRevenue + this.totalStationeryRevenue + this.totalGroceryRevenue; // adds up all revenues
    }
    
    /*
     * Method called by main() to print the Inventory Report of each item to the console
     */
    public void printInventory() {
        for(int i = 0; i < inventory.length; i ++) { // iterate through the length of the array starting at 0 
            System.out.print(inventory[i].inventoryType.toUpperCase() + "\t");
            System.out.print(inventory[i].itemName + "\t");
            System.out.print(inventory[i].numOrdered + "\t");
            System.out.print(inventory[i].numInShop + "\t");
            System.out.print(inventory[i].numSold + "\t" );
            if (revenues[i] > 0){ // check whether the revenue per item is bigger than 0 print the following
                System.out.print("£" + revenues[i] + " profit \n" );
            }else{ // else, the revenue is below 0 print the following
                System.out.print("£" + revenues[i] + " loss \n" );
            } 
        }
        System.out.print("\n" ); // Next line to show clear division between reports
        System.out.println("TOTAL TOOLS: " + "\t \t \t \t £" + this.totalToolRevenue); // Print totalToolRevenue
        System.out.println("TOTAL STATIONERY: " + "\t \t \t £" + this.totalStationeryRevenue); // print totalStationeryRevenue
        System.out.println("TOTAL GROCERY: " + "\t \t \t \t £" + this.totalGroceryRevenue); // print totalGrocery Revenue
        System.out.println("TOTAL REVENUE:" + "\t \t \t \t £" + this.totalRevenue); //print totalRevenue
    }
    
    /*
     * Method called by main() to print the Inventory Report variables of each item into a file
     */
    public void saveReport() throws FileNotFoundException { // throws FileNotFoundException in case the file is not found
        PrintWriter pw = new PrintWriter("RevenueReport.txt"); // create new PrintWriter
        for(int i = 0; i < inventory.length; i ++) {  // iterate through the length of the array starting at 0 
            pw.print(inventory[i].inventoryType.toUpperCase() + "\t");
            pw.print(inventory[i].itemName + "\t");
            pw.print(inventory[i].numOrdered + "\t");
            pw.print(inventory[i].numInShop + "\t");
            pw.print(inventory[i].numSold + "\t" );
            if (revenues[i] > 0){ // check whether the revenue per item is bigger than 0 print the following
                pw.print("£" + revenues[i] + " profit \n" );
            }else{ // else, the revenue is below 0 print the following
                pw.print("£" + revenues[i] + " loss \n" );
            } 
        }
        
        pw.print("\n"); // Next line to show clear division between reports
        pw.print("TOTAL TOOLS: " + "\t \t \t \t £" + this.totalToolRevenue + " \n");
        pw.print("TOTAL STATIONERY: " + "\t \t \t £" + this.totalStationeryRevenue + " \n");
        pw.print("TOTAL GROCERY: " + "\t \t \t \t £" + this.totalGroceryRevenue + " \n");
        pw.print("TOTAL REVENUE:" + "\t \t \t \t £" + this.totalRevenue + " \n");
      
        pw.flush(); // ensures that all data has been written to the stream of output into the file
        pw.close(); // closes the output stream 
    }
}