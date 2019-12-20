
/**
 * The class Inventory creates and defines the object of Inventory
 *
 * @author Anais Urlichs
 * @version 15.12.2019
 */
import java.util.Scanner;
import java.util.InputMismatchException; 

public class Inventory
{
    // instance variables
    public String inventoryType;
    public String itemName;
    public int numOrdered;
    public int numInShop;
    public double orderCost;
    public double priceSoldAt;
    public int numSold;
    Scanner scan = new Scanner(System.in); // Create Scanner, used throughout this class
    
    /**
     * Constructor for objects of class Inventory
     */
    public Inventory()
    {
        inventoryType = getInventoryType();
        itemName = getItemName();
        numOrdered = getNumOrdered();
        numInShop = getNumInShop();
        orderCost = getOrderCost();
        priceSoldAt = getPriceSoldAt();
        numSold = getNumSold();
    }

    /**
     * Method called by the constructor to get a new inventory type
     *
     * @return inventoryType
     */
    private String getInventoryType() { //method returns a variable of the datatype String
        System.out.println("Please enter the name of the inventory (tools, grocery, stationery): ");
        inventoryType = scan.nextLine();
        while (!inventoryType.equals("tools") && !inventoryType.equals("stationery") && !inventoryType.equals("grocery")){ // validates the user input
            System.out.println("Invalid input! Please enter the name of the inventory (tools, grocery, stationery): ");
            inventoryType = scan.nextLine();
        }
        return inventoryType; // return the newly created inventoryType
    }
    
    /**
     * Method called by the constructor to get a new itemName
     *
     * @return itemName
     */
    private String getItemName() {
        System.out.println("Please enter the name of the item purchased: "); // print request to the user
        String itemName = scan.nextLine();  // Read user input            
        return itemName; // returns the newly created itemName
    }
    
    /**
     * Method called by the constructor to get a new numOrdered
     *
     * @return numOrdered
     */
    private int getNumOrdered() {
        try { // try to receive the right user input; otherwise, terminates the program
            System.out.println("Please enter the number of items ordered: "); // print request to the user
            int numOrdered = scan.nextInt(); // Read user input
            return numOrdered;
        } catch (InputMismatchException e) { // print exception in the case of invalid input
            System.out.println("Invalid input! Please enter the number of items ordered.");
        } 
        return numOrdered;
    }
    
    /**
    * Method called by the constructor to get a new numOrdered
    *
    * @return numInShop
    */
    private int getNumInShop() {
        try { // try to receive the right user input; otherwise, terminates the program
            System.out.println("Please enter the number of items in the shop: "); // print request to the user
            int numInShop = scan.nextInt(); // Read user input
            return numInShop;
        } catch (InputMismatchException e) { // print exception in the case of invalid input
            System.out.println("Invalid input! Please enter the number of items in the shop.");
        } 
        return numInShop;
    }
    
    /**
     * Method called by the constructor to get a new numOrdered
     *
     * @return orderCost
     */
    private double getOrderCost() {
        try { // try to receive the right user input; otherwise, terminates the program
            System.out.println("Please enter the order cost of the individual item: "); // print request to the user
            double orderCost = scan.nextDouble(); // Read user input
            return orderCost;
        } catch (InputMismatchException e) { // print exception in the case of invalid input
            System.out.println("Invalid input! Please enter the costs of the individual item.");
        }
        return orderCost;
    }
    
    /**
     * Method called by the constructor to get a new numOrdered
     *
     * @return priceSoldAt
     */
    private double getPriceSoldAt() {
        try { // try to receive the right user input; otherwise, terminates the program
            System.out.println("Please enter the shop price of the individual item: "); // print request to the user
            double priceSoldAt = scan.nextDouble(); // Read user input
            return priceSoldAt;
        } catch (InputMismatchException e) { // print exception in the case of invalid input
            System.out.println("Invalid input! Please enter the shop price of the individual item.");
        }
        return priceSoldAt;
    }
    
    /**
     * Method called by the constructor to get a new numOrdered
     *
     * @return numSold
     */
    private int getNumSold() {
        try { // try to receive the right user input; otherwise, terminates the program
            System.out.println("Please enter the number sold this month: "); // print request to the user
            int numSold = scan.nextInt(); // Read user input
            return numSold;
        } catch (InputMismatchException e) { // print exception in the case of invalid input
            System.out.println("Invalid input! Please enter the number of items sold this month.");
        } 
        return numSold;
    }
}