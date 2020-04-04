import java.util.Arrays;
import java.util.*;
/*
 * this class contains the array list which stores items
 * the items can be called within the array
 * items can be preset int this class
 */
public class ItemCatalog {
    static ArrayList<Item> CatalogArray = new ArrayList<Item>();

    static Item Item1 = new Item();
    static Item Item2 = new Item();
    static Item Item3 = new Item();
    public void initializer(){

        Item1.setName("Cherries");
        Item1.setDescription("Everyone wants to see 3 cherries on the slot machine");
        Item1.setPrice(1.00);
        Item1.setQuantity(50);
        AddItem(Item1);

        Item2.setName("Oranges");
        Item2.setDescription("The vitamin C in oranges help anyone with the flu");
        Item2.setPrice(1.50);
        Item2.setQuantity(70);
        AddItem(Item2);

        Item3.setName("Bananas");
        Item3.setDescription("to keep them fresh, hang the banans in stead of laying them somewhere");
        Item3.setPrice(2.00);
        Item3.setQuantity(90);
        AddItem(Item3);

    }
    public void AddItem(Item newItem){ //adds all the items in the array list
        CatalogArray.add(newItem);
    }

    public void DisplayItems() { //access the array list and print all all of the Items stored.
        int i = 0;
        do{
            CatalogArray.get(i).DisplayItem();
            i++;
        }while (i < CatalogArray.size());
        System.out.println("\n");
    }
}
