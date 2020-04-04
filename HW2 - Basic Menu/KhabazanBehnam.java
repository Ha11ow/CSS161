import java.util.*;
import java.lang.String;
/**
 * Write a description of class KhabazanBehnam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KhabazanBehnam
{
    public static void main(String[] Args){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        do {
            System.out.println("Welcome, choose an option bellow:\n1)Magic Box\n2)Conversion Rates\n3)Statical Analysis");
            System.out.print("Your option number: ");
            int optionNumber = scan.nextInt();
            if (optionNumber == 1){ //the option that user has and what it calls
                System.out.println("choose a number between 1 to 3");
                int boxNumber = scan.nextInt();     
                magicBox(boxNumber); //calls the method bellow
            }
            else if(optionNumber == 2){
                System.out.println("Choose a conversion: \n1)U.S. Dollar to Japanese Yen\n2)U.S. Dollar to Iranian Rial");
                conversionRates(); //calls the method bellow
            }
            else if  (optionNumber == 3){
                System.out.print("Give me three numbers seperated by spaces then press ENTER: ");
                staticalAnalysis(); //calls the method bellow
            }
            else { //if user chooses other than the options given he gets this error
                System.out.println("Please restart the program and follow the prompt");
            }
            System.out.print("Would you like to play again?(yes/no) "); // end of code: doing bonus and asking player if they want to play again.
            String replay = scan.next(); //repeats the game like a loop so player can play again without having to restart
            if (replay.equalsIgnoreCase("yes")){
                x = 2; // this makes the initial number to change so if player answers yes they are allowed to play again
            }
            else if (replay.equalsIgnoreCase("no")){
                x = -2;// this makes the inital number negetive so player says no it stops the loop.
            }
            else {
                System.out.println("You did not answer correctly. Program closing...");
                x = -1;
            }
            System.out.print("Good Game!"); //says good name when player is done playing
        }while( x >= 0 );
    }
    //onverts the two given rates 1 is us dollars to japanese Yen and 2 is us dollars to iranian rials
    public static void conversionRates(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Your option number: "); //prompts the question
        int conversionNumber = scan.nextInt(); // users choice of conversion
        if (conversionNumber == 1){   // selecting the given number by user translates us dollars to japanese yen. 
            System.out.print("\tU.S. Dollar amount: "); //prompts the question
            double USDollar1 = scan.nextDouble(); // asks for dollar amount
            double JPYen = (USDollar1 * 104.51); //difference between yen and usd 
            System.out.println("\t" + USDollar1 + " US Dollars is equivalent to " + JPYen + " Yen"); // prints the final answer
        }
        else if (conversionNumber == 2) {      // selecting the given number by user
            System.out.print("\tU.S. Dollar amount: "); // prompts the question
            double USDollar2 = scan.nextDouble(); //asks for dollar amount
            double IRRials = (USDollar2 * 31565.66); //difference between rial and usd
            System.out.println("\t" + USDollar2 + " US Dollars is equivalent to " + IRRials + " Rials"); // prints the final answer
        }
        else {    //if user uses any other number other than 1 or 2 this the error they will recieve
            System.out.println("Please restart the program and follow the prompt");
        }
    }
    //this is the magic box, there are three boxes to choose from and each gives a different price
    public static void magicBox(int boxNumber) {
        if (boxNumber == 1){ //if user chooses box number 1 he gets a rock
            System.out.println("In box number 1, there was a rock. You are now the pround owner of a rock!");
        }
        else if (boxNumber == 2){ //if user chooses box 2 he gets gem
            System.out.println("In box number 2, there was a bright red gem. You are now a wealthy person!");
        }
        else if (boxNumber == 3){ //if user chooses 3 he gets a book
            System.out.println("In box number 3, there was a book. KNOWLEDGE");
        }
        else { // if user chooses other than the options given he gets this error
            System.out.println("Please restart the program and follow the prompt");
        }
    }
    //This method creates a statical analysis and finds teh average , max, and min
    public static void staticalAnalysis() {
        Scanner scan = new Scanner(System.in);
        double firstNum = scan.nextDouble(); //this is the first number given
        double secondNum = scan.nextDouble();//this is the second number given
        double thirdNum = scan.nextDouble(); // this is the thir number given
        double Max = Math.max(Math.max(firstNum, secondNum), thirdNum); //this finds the max of all 3
        double Min = Math.min(Math.min(firstNum, secondNum), thirdNum); // this finds the min of all 3
        double avg = ((firstNum + secondNum + thirdNum) / 3); //this gives the average of all 3
        System.out.println("The maximum of " + firstNum + ", " + secondNum + ", " + thirdNum + " is: " + Max);// prints out the max
        System.out.println("The minimum of " + firstNum + " " + secondNum + " " + thirdNum + " is: " + Min);  // prints out the min
        System.out.println("The average of " + firstNum + ", " + secondNum + " " + thirdNum + " is: " + avg); // prints out the average

    }
}
