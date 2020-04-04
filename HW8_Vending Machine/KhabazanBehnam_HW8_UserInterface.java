
import java.util.*;
/**
 * Write a description of class UserInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserInterface
{
    public static void main(String[] Args){
        VendingMachine newmachine = new VendingMachine();
        Scanner s = new Scanner(System.in);
        double money;
        int selection;
        String addFunds;
        String machineStatus;
        boolean isValidInput = false;

        System.out.print("Welcome, Please insert your money. (0.25, 1.00, 5.00, 10.00): ");
        /*
         * this loop adds funds to the machine
         * it takes in money and adds balance
         * it has error handeling
         * it stops when user correctly inputs money and gets a balance
         */
        do{
            money = s.nextDouble();
            newmachine.setBalance(money); //balance becomes money
            if (newmachine.getValidBalance() == true){ //if balance correctly inputted it turns true
                System.out.println("Successfully added funds. New balance: " + newmachine.getBalance());
            }
            else { //otherwize it fails
                System.out.print("Please choose one of the following (0.25, 1.00, 5.00, 10.00): ");
            }
        }while (newmachine.getValidBalance() == false); //loops if user doesnt have correct input

        /*
         * this loops through the purchasing proccess
         * stops when user doesnt want to add funds or purchase anything else
         */
        do{ 
            /*
             * this loop is the purchasing proccess
             * it takes in an item number and checks to see if balance is higher than the amount
             * then correctly purchases the item and gives out a balance. 
             * if user fails to purchase something because choosing the wrong item or not enough balance it loops
             * stops when user correctly purchases an item
             */
            do{
                System.out.print(newmachine.toString()); //prints the menu of the items that are in the vending machine
                System.out.print("\n\tPlease Choose an option: ");

                selection = s.nextInt(); //takes in an int for the item number
                newmachine.purchase(selection); //puts it in the purchasing method and that returns a boolean
                if (newmachine.getValidPurchase() == true){ //if user correctly purchases an item then it goes here
                    System.out.println("Please pick up your item. Your new balance is: " + newmachine.getBalance());
                }
                else { //if user doesnt correctly purchase an item it returns another boolean with the problem
                    if (newmachine.getValidFunds() == false){  //if there is not enough funds then asks if the user want to import money
                        do{
                            System.out.print("This machine does not return inserted money before purchase.\nWould you like to add funds?(y/n)");
                            addFunds = s.next();
                            if (addFunds.equalsIgnoreCase("Y")){ //if user answers yes then it givens them the menu bellow (copied from above)
                                System.out.print("Please insert your money. (0.25, 1.00, 5.00, 10.00): ");
                                do{ 
                                    money = s.nextDouble();
                                    newmachine.setBalance(money);
                                    if (newmachine.getValidBalance() == true){
                                        System.out.println("Successfully added funds. New balance: " + newmachine.getBalance());
                                        isValidInput = true;
                                    }
                                    else {
                                        System.out.print("Please choose one of the following (0.25, 1.00, 5.00, 10.00): ");
                                    }
                                }while (newmachine.getValidBalance() == false); 
                            }
                            else if (addFunds.equalsIgnoreCase("N")){ //if user says no they dont get no money back :) (ITS FOR PROFIT, I KNOW HOW TO REFUND!)
                                System.out.println("Have a nice day!");
                                newmachine.setBalance(0);
                                isValidInput = false;
                                System.exit(0);
                            }
                            else { //if user puts in anything other than y or no it reloops
                               
                                isValidInput = false;
                            }
                        }while (isValidInput == false);
                    }
                }
            } while (newmachine.getValidPurchase() == false); 

            /*
             * this loop is to see if the user wants to purchase another item
             * it asks for a y or n and repeats if user doesnt answer one of the two
             */
            System.out.print("Would you like to purchase another item?(y/n) "); //declared outside because if user puts in anything wrong it says another error
            do { 
                machineStatus = s.next(); //takes in a string
                if (machineStatus.equalsIgnoreCase("N")){//if user says no then it stops both loops because the answer is n
                    System.out.println("Machine is Calculating! Please Stand-By");
                    isValidInput = true;
                }
                else if (machineStatus.equalsIgnoreCase("Y")){ //if the user wants to retry then it passes
                    isValidInput = true;
                }
                else { //if user imports anyhting other than y or n then reloop
                    System.out.print("Not a valid choice. Please choose Y or N!");
                    isValidInput = false;
                }
            }while (isValidInput == false);
        } while (machineStatus.equalsIgnoreCase("Y"));

        if (newmachine.getBalance() == 0){
            System.out.println("Have a nice day!");
        }
        else {
            System.out.println("Funds refunded: $" + newmachine.getBalance());
        }
    }
}
