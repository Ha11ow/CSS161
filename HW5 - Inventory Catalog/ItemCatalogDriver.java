/*
 * Behnam khabazan
 * 11/8/16
 */
public class ItemCatalogDriver {
    static ItemCatalog newCatalog = new ItemCatalog();
    static Item newItem = new Item();
    public static void main(String[] args) {
        newCatalog.initializer(); //adds the initialized menu to the 

        newItem.setName("Apples");
        newItem.setDescription("An apple a day keeps the docter away");
        newItem.setPrice(1.25);
        newItem.setQuantity(55);
        //create new item

        newItem.DisplayItem();
        //display the item

        newItem.purchaseItem(3);
        newItem.restockItem(8);
        //purhcase and restock the item

        newCatalog.DisplayItems();
        //diplay catalog

        newCatalog.AddItem(newItem);
        newCatalog.DisplayItems();
        //add item to catalog

        newItem.purchaseItem(3);
        newCatalog.CatalogArray.get(3).DisplayItem(); //number 3 is the number of the choosen item
        //diplay in catalog 

    }
}