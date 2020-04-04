import java.util.*;
/**
 * Write a description of class KhabazanBehnam here.
 * 
 * @author (Behnam Khabazan) 
 * @version (2016105)
 */
public class KhabazanBehnam_HW2_BasicMenu

{
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome To MorningCafe");
        spacer();
        System.out.print("What is your SubTotal?");
        Double subtotal = userInput.nextDouble();
        System.out.print("How much tip are you giving?");
        Double tip = userInput.nextDouble();
        spacer();
        Double totalBeforeTax = (tip + subtotal);
        Double tax= (totalBeforeTax * .098);
        Double totalAfterTax = (totalBeforeTax + tax);   
        System.out.printf("Tip Amount: %1.2f", tip);
        EmptyLine();
        System.out.printf("Tax: %1.2f", tax);      
        EmptyLine();
        System.out.printf("Total: %1.2f", totalAfterTax);
        EmptyLine();
        spacer();
        System.out.println("Thank you for shopping with us");
    }
    public static void spacer() {
        System.out.println("****************************************");
    }
    public static void EmptyLine() {
        System.out.println();
    }
}

