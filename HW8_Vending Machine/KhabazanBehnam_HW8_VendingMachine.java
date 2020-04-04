import java.util.*;
/**
 * This is the vending machine. it accepts money for balance and returns items that are stored within its array
 * 
 * @author (Behnam Khabazan) 
 * @version (120616)
 */
public class VendingMachine
{
    private ArrayList<Item> storage = new ArrayList<Item>();
    private double balance;
    private boolean isValidPurchase;
    private boolean isValidBalance;
    private boolean isValidFunds;

    /*
     * constructor that sets the initial items in the vending machine
     */
    public VendingMachine(){
        initializer();
    }

    /*
     * Adds the new paramater that is a new Item to the arraylist
     */
    public void addItem (Item newItem){ //add the object Item to the arraylist
        storage.add(newItem);
    }

    /*
     * create a new instance of the Item.
     * add it to the arraylist
     * parameter includes the new name, new price, and new stock
     * the if statements check to see if variables are true;
     */
    private void newItem(String name, double price, int stock){ 
        if (name != null){
            if (price > 0){
                if (stock > 0){
                    Item newItem = new Item(name, price, stock);
                    addItem(newItem);
                }
                else{
                    System.out.println ("Didn't go through!");
                }
            }else{
                System.out.println ("Didn't go through!");
            }
        }else{
            System.out.println ("Didn't go through!");
        }
    }

    /*
     * This initializes the menu for purchasing items
     * creates new Items
     * adds them to the array by calling addItem() method.
     */
    public void initializer(){
        Item Item1 = new Item("Chips", 2.50, 5);
        addItem(Item1);
        Item Item2 = new Item("Cookies", 1.25, 2);
        addItem(Item2);
        Item Item3 = new Item("Oreos", 2.50, 7);
        addItem(Item3);
        Item Item4 = new Item("Gum", 1.50, 3);
        addItem(Item4);
        Item Item5 = new Item("Soda", 3.00, 9);
        addItem(Item5);
        Item Item6 = new Item("Juice", 1.25, 4);
        addItem(Item6);
        Item Item7 = new Item("Water", 1.50, 6);
        addItem(Item7);
    }

    /*
     * Sets the private instance variable balance
     * checks to see if the new balance is lower than 0
     * parameter brings the new balance
     */
    public void setBalance(double balance){
        if (balance > 0){
            if (balance == 1){
                this.balance += balance;
                isValidBalance = true;
            }
            else if (balance == 0.25){
                this.balance += balance;
                isValidBalance = true;
            }
            else if (balance == 5){
                this.balance += balance;
                isValidBalance = true;
            }
            else if (balance == 10){
                this.balance += balance;
                isValidBalance = true;
            }
            else {
                isValidBalance = false;
            }
        }
    }

    /*
     * returns the balance if it is higher than 0
     * if balance is somehow lower or no value returns 0
     */
    public double getBalance(){
        if (this.balance > 0){
            return this.balance;
        }
        else {
            return 0;
        }
    }

    /*
     * Takes in the Item number from the parameter
     * checks to see if the balance is higher than the item price
     * checks if the purchase is validly completed. else figures an error to respond with
     */
    public void purchase(int itemNum){
        if (storage.size() >= itemNum && itemNum > 0){
            if (this.balance >= storage.get(itemNum - 1).getPrice()){
                if (storage.get(itemNum - 1).getStock() > 0){
                    this. balance -= storage.get(itemNum - 1).getPrice();
                    storage.get(itemNum-1).stockAfterPurchase();
                    isValidPurchase = true;
                    isValidFunds = true;
                }
                else {
                    System.out.println("Sorry, We are currently out of that item");
                }
            }
            else {
                System.out.println("Not enough funds!");
                isValidFunds = false;
                isValidPurchase = false;
            }
        }

        else {
            System.out.println("Not a valid selection!");
            isValidPurchase = false;
            isValidFunds = true;
        }
    }    
    
    /*
     * returns boolean isValidPurchase
     */
    public boolean getValidPurchase(){
        return isValidPurchase;
    }

    /*
     * sets the boolean isValidPurhcase
     */
    public void setValidPurchase(boolean isValidPurchase){
        this.isValidPurchase = isValidPurchase;
    }

    /*
     * returns boolean isValidBalance
     */
    public boolean getValidBalance(){
        return isValidBalance;
    }

    /*
     * returns boolean isValidFunds
     */
    public boolean getValidFunds(){
        return isValidFunds;
    }

    /*
     * Overriding the toString so it prints out all the Items in the Vending Machine
     * gives them labels as wells as numbers + the price + the stock
     */
    public String toString(){
        String finalReturn = "";
        for (int i = 0; i < storage.size(); i++){
            finalReturn += "\n" + (i+1) + ". " + storage.get(i).toString();
        }
        return finalReturn;
    }
}
