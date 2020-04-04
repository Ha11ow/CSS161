
/**
 * This is the item class. It creates an instance of an item which has a price, a name, and a stock
 * there are actions that are defyined in this such as reducing the stock by 1 when the class is called and many more
 * 
 * @author (Behnam Khabazan) 
 * @version (120616)
 */
public class Item
{
    private String name;
    private double price;
    private int stock;

    public Item (String name, double price, int stock){ //constructor sets up the value of everything delcared in ITEM class
        setName(name);
        setPrice(price);
        setStock(stock);
    }

    public void setName(String name){ //gets a string in parameter and replaces the given name at top
        if (name != null){
            this.name = name;
        }
    }

    public void setPrice(double price){ //gets a double in parameter and replaces the given price at top
        if (price > 0){
            this.price = price;
        }
    }

    public void setStock(int stock){  //gets an int in parameter and replaces the given stock at top
        if (stock > 0){
            this.stock = stock;
        }
    }
    
    public void stockAfterPurchase(){ //if user purchases something the stock goes down once everytime this class is called
        stock--;
    }

    public String getName(){ //this returns the name if there is any name set
        if (this.name != null){
            return this.name;
        }
        else {
            return "there is no name set up yet";
        }
    }

    public double getPrice(){ //this method returns a price if it is declared else is 0
        if (this.price > 0){
            return this.price;
        }
        else{
            return 0;
        }
    }

    public int getStock(){ //this method returns an int of stock of it is declared else is 0
        if (this.stock > 0){
            return this.stock;
        }
        else{
            return 0;
        }
    }
    
    public String toString(){// this is the override of to string to return what is needed
        return (getName() + "   \tPrice: " + getPrice() + "\t|" + getStock() + " remaining"); 
    }
}
