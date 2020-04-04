import java.util.*;
/**
 * Write a description of class ClassDriver here.
 * 
 * @author (Ben Khabazan) 
 * @version (11/14/16)
 */
public class ClassDriver    
{
    public static void main(String[] Args){
        AccountList AccList = new AccountList(); //initializez the account list

        //Creating User
        User user = new User("Ben", "Khabazan", "IsBenCool?", "password");
        Account account = new Account(user, 98.31);
        AccList.addAccount(account);

        //Creating User1
        User user1 = new User("Ben", "Khabazan", "BenIsCool", "password");
        Account account1 = new Account(user1, 76);
        AccList.addAccount(account1);

        //creating User2
        User user2 = new User("Hansel", "Ong", "HanselTheGreat", "Strong");
        Account account2 = new Account(user2, 102.50);
        AccList.addAccount(account2);

        //creating User3
        User user3 = new User();
        user3.setUsername("linda_davis");
        user3.setPassword("example");
        user3.setFirstName("Linda");
        user3.setLastName("Davis");
        Account account3 = new Account(user3, 100.00);
        AccList.addAccount(account3);

        //printing the accounts
        System.out.println(account);
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3 + "\n");

        //withdrawing from each Account
        account.withdraw(23.31);
        account1.withdraw(20);
        account2.withdraw(10.49);
        account3.withdraw(30.50);
        System.out.println("\n");
		
        //reprinting to see difference
        System.out.println(account);
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3 + "\n");

        //adding funds to each account
        account.addFunds(21);
        account1.addFunds(40);
        account2.addFunds(20.55);
        account3.addFunds(50.97);
        System.out.println("\n");
AccList.printarraylist();
        //reprinting to see difference
        System.out.println(account);
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

        //checking equals methods
        System.out.println(account1.equals(account));
        System.out.println(user1.equals(user));
    }

}