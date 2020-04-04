import java.util.*;
/**
 * Write a description of class KhabazanBehnam_HW3_CheckoutCounter here.
 * 
 * @author (Behnam Khabazan) 
 * @version (10/17/16)
 */
public class KhabazanBehnam_HW3_CheckoutCounter
{

    static double apple = 0; // This is the initial price of apple
    static double kiwis = 0; // This is the initial price of kiwis
    static double oranges = 0; // This is the initial price of oranges
    static int totalApples = 0; // This is the lbs. of apple
    static int totalKiwis = 0; // This is the lbs. of kiwis
    static int totalOranges = 0;  // This is the lbs. of oranges
    public static void MainMenu(Scanner s){      
        int selection; // THis is the precondition and the selection of the menu
        do{
        System.out.println("\n********************************* Main Menu *********************************");
        System.out.print("1- Purchase Items\n2- Display Current Purchases\n3-Print Receipt\nPlease choose from the above menu: ");
        selection = s.nextInt();         //This asks for input from user and if the number is one of the if statement bellow it chooses that option

        if (selection == 1){ //if the input is equal to one, This will go to the purchasing items, This will repeat until user puts input as 0
            PurchasingItems(s);

        }
        /*
         * This if statement is for checking the cart and price
         * This will tell the user of the items they have
         * in this if statement if the cart does not have an item it will not print it
         * This if statement does not show tax and it is not meant to!
         */
        if (selection == 2){
            DisplayMenu(s);

        }
        /*
         * This if statement contains the ^ if statement
         * This if statement also has the tax and discount
         * This statement shows the final price and stops the code (end of program)
         */
        if (selection == 3){
            PrintReciept(s);
        }
        /*
         * if the selection from main menu is not 1,2,3 then it gives an error saying choose a valid selection and loops
         */
        if ((selection != 1) && (selection != 2) && (selection != 3))   {
            System.out.println("That is not a valid selection. Please choose an option from the list.");
        }            
    }while (selection != 3);
}

    public static void PurchasingItems (Scanner s){
        System.out.println("\n***************************** Purchasing Items ******************************");
        int nextSelection;
        //This is the precondition of the loop, must be outside to stop creating a variable everytime loops
        /*
         * This do loop is the purchasing menu,
         * In this do loop the user purchases items, it will loop until user sets input to 0
         * The user can buy an item multiple times
         * This do loop will add the price of the input everytime and count how many has been choosen
         * Unaccepted number will give error and reshow the loop
         */
        do {
            System.out.print("1- Apples - $3.49/lb\n2- Kiwis - $5.99/lb\n3- Oranges - $2.99/lb\nPlease choose from the above menu(0 to go back to main menu): "); // this is the menu that user chooses from
            nextSelection = s.nextInt();

            if (nextSelection == 1){ // This if statement will choose apple if input is 1
                System.out.print("How much? ");
                int amount = s.nextInt();
                if (amount < 0) { //this tells the user not to put a negative number because they cannot return to our store!
                    System.out.println("That is not a vaild selection\n");
                }
                else{ // if user puts in a positive number or 0, the number will be stored as the number of lbs. and will be multiplied by the price to get the total price
                    apple = apple + (amount * 3.49); // having initial apple add to the price will allow the user to loop through and buy more apples and both prices will be stored
                    System.out.println("");
                    totalApples = totalApples + amount; // having initial total will allow code to know how many total apples purchased even after the loop
                }
            }
            else if (nextSelection == 2){ // This if statement will choose kiwis if input is 2
                System.out.print("How much? ");
                int amount = s.nextInt();
                if (amount < 0) {
                    System.out.println("That is not a vaild selection\n");
                }
                else{
                    kiwis = kiwis + (amount * 5.99); // having initial kiwi add to the price will allow the user to loop through and buy more kiwi and both prices will be stored
                    System.out.println("");
                    totalKiwis = totalKiwis+ amount; // having initial total will allow code to know how many total kiwi purchased even after the loop
                }
            }
            else if (nextSelection == 3){  // This if statement will choose oranges if input is 3
                System.out.print("How much? ");
                int amount = s.nextInt();
                if (amount < 0) {
                    System.out.println("That is not a vaild selection\n");
                }
                else{
                    oranges = oranges + (amount * 2.99); // having initial oranges add to the price will allow the user to loop through and buy more oranges and both prices will be stored
                    System.out.println("");
                    totalOranges = totalOranges + amount; // having initial total will allow code to know how many total oranges purchased even after the loop
                }
            }
            else if (nextSelection == 0){ //This if statement is null. I needed to declear this for the next else statement :) carry on!!!
            }
            else { //if user chooses any other number than 0,1,2,3 the code will loop and tell the user to have a valid input
                System.out.println("Please make a valid selection\n");
            }
        }while (nextSelection != 0); // if the user chooses 0 as the selection in this loop, the loop will finish and go to the begining of the 1st loop.
    }

    public static void DisplayMenu(Scanner s){
        System.out.println("\n*************************** Displaying Purchases ****************************");
        double subtotal = apple + oranges + kiwis; // this adds the price of every object in cart
        if (apple != 0){ // if the price of apple is not 0 then print the total number of it and then the price of it. if not then skip this 
            System.out.println(totalApples + " pounds of apples at $3.49/lb. = " + String.format("%.2f", apple)); // the string format will show 2 decimals only (makes "cents" riggggggggggggght???)
        }
        if (kiwis != 0){ // if the price of kiwis is not 0 then print the total number of it and then the price of it. if not then skip this 
            System.out.println(totalKiwis + " pounds of kiwis at $5.99/lb. =  " + String.format("%.2f", kiwis)); // the string format will show 2 decimals only (makes "cents" riggggggggggggght???)
        }
        if (oranges != 0){  // if the price of oranges is not 0 then print the total number of it and then the price of it. if not then skip this 
            System.out.println(totalOranges + " pounds of oranges at $2.99/lb. = " + String.format("%.2f", oranges));  // the string format will show 2 decimals only (makes "cents" riggggggggggggght???)
        }
        if (subtotal == 0) { //if adding the total and getting 0, then tell user cart is empty
            System.out.println("You do not have any items in your cart");
        }
        else { // if subtotal is larger than 0 then print the total 
            System.out.println("\nYour current subtotal before tax is $" + String.format("%.2f", subtotal)); // the string format will show 2 decimals only (makes "cents" riggggggggggggght???)
        }
    }

    public static void PrintReciept(Scanner s){ //prints the reciept useing the same code as display menu + more
        System.out.println("\n***************************** Printing Receipt ******************************");
        double total = apple + oranges + kiwis;
        if (apple != 0){
            System.out.println(totalApples + " pounds of apples at $3.49/lb. = " + String.format("%.2f", apple)); // the string format will show 2 decimals only (makes "cents" riggggggggggggght???)
        }
        if (kiwis != 0){
            System.out.println(totalKiwis + " pounds of kiwis at $5.99/lb. =  " + String.format("%.2f", kiwis)); // the string format will show 2 decimals only (makes "cents" riggggggggggggght???)
        }
        if (oranges != 0){
            System.out.println(totalOranges + " pounds of oranges at $2.99/lb. = " + String.format("%.2f", oranges)); // the string format will show 2 decimals only (makes "cents" riggggggggggggght???)
        }
        if (total == 0) { 
            System.out.println("Your cart is empty, have a nice day!");
        }
        /*
         * everyting on top is the same as selection == 2
         * so look at the comments on top if doesn't make sense which it should 
         */
        else {
            String discount = "Behnam"; //this declares the discount code
            System.out.print("Please enter your discount code: "); 
            String discountInput = s.next(); //this is the users s of the code
            if (discount.equalsIgnoreCase(discountInput)) { //this if statement compares what is inside the two strings not the location!!! and if they are the same it will give 20% discount
                System.out.println("You are eligible for 20% discount for today");
                double reduce = ((total * 20)/ 100); // this is 20% of the total purchase
                total = total - reduce; //this reduces the total amount from the discount
            }
            else { //if the discount is not the same as the discount code set, it will tell them the discount is not available 
                System.out.println("Sorry, that discount is not available today");
            }
            double tax = ((total * 9.8)/ 100); // this calculates 10 percent of the total left over, and gives out tax
            System.out.println("\nYour tax is $" + String.format("%.2f", tax)); //this prints out tax as two decimals only (not going to repeat the joke cause its dry now)
            System.out.println("Your total is $" + String.format("%.2f", (total + tax)));//this prints out the total as two decimals only (not going to repeat the joke cause its dry now)

        }
    }

    public static void main(String[] Args){
        Scanner s = new Scanner(System.in);
        MainMenu(s); //calls main menu to get things started

    }
}

