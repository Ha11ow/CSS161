import java.util.*;
/*
 * this class includes all the data for an Item. 
 * Item can be created in this class
 * item can be reduced and increased using this class
 */
public class Item {
    double price = 0; //initial price of the item
    int quantity = 0; //initial quanitity of item
    String name = ""; //initial name of item
    String description = ""; //initial descripiton of item
public void setName(String newName) { // adds the new name or crashed if false statment inserted 
        if (newName == null) { //if there name is left empty
            System.out.println("name column was left empty");
            System.exit(0);
        } else {
            name = newName; //sets the name to the new name
        }
    
    }

    public void setDescription(String newDescription) { //adds the new description or crashed is false statement inserted
        if (newDescription == null) { //if it is left empty
            System.out.println("no descreipiton inserted");
            System.exit(0);
        } else
            description = newDescription; //add the description to the item
    }

    public void setPrice(double newPrice) { //adds the new price of the item or crashed if false price inserted
        if (newPrice <= 0) {
            System.out.println("no price was inserted");
            System.exit(0);
        } else
            price = newPrice; //new item price is set
    }

    public void setQuantity(int newQuantity) { //adds the new quantity or crahses if false quantity is lower than 0
        if (newQuantity <= 0) {
            System.out.println("The quantity has excerted 0, that is not possible");
            System.exit(0);
        } else
            quantity = newQuantity; //new quantity is set
    }





    public void DisplayItem() { // displays the item that was set
        if (name.length() > 0) {
            System.out.println(name + ". " + description+ ". $"  + price + " each. Quantity: " + quantity + ". Available for sale");
        }
        else {
            System.out.println(name + ". " + description + ". $"  + price + " each. Quantity: " + quantity + ". Out of stock");
        }
   }

    public void purchaseItem(int purchase) { //reduces quantity 
        System.out.println("Currnet quantity set: " + quantity + " " + name + " are now availabe");
        System.out.println("How much " + name + " do you need to purchase? "  + purchase);

        if (!((purchase < quantity) && (purchase >= 0))) {
            System.out.println("invalid input. Purchase must be equal or greater than 0; and less than the valid quantity");
            System.exit(0);
        } else {
            quantity -= purchase;
            System.out.println("New quantity: " + quantity + "\n");
        }
        
    }

    public void restockItem(int restock) { //adds to the quantity
        System.out.println("Quantity of " + name + " need to be added: " + restock);
        
        if (restock > 0) {
            quantity += restock;
            System.out.println("Successfully Restocked " + restock + " " + name + ". New quantity: " + quantity + "\n");
        }
        else {
            System.out.println("not a valid quantity");
        }
      
    }
}