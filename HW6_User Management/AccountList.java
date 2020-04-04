import java.util.*;
/**
 * This is the AccountList, it takes in the accounts and stores them in an array, it allows the list to be searched for duplicates on the usernames.
 * 
 * @author (Behnam) 
 * @version (11/14/16)
 */
public class AccountList
{
    static ArrayList<Account> accountList = new ArrayList<Account>(); //creates an array list for the accounts to be stored in, no limit on the users

    /*
     * actions
     */
    public void addAccount (Account newAccount) { //if the account does not have a similar name with other accounts, then it adds it to the array list
        if (equals(newAccount) == true){
            accountList.add(newAccount);
        }
        else{       
            throw new RuntimeException("Sorry that username is taken");
        }
    }

    public void printarraylist(){
        System.out.println(accountList);
    }

    public boolean equals(Account otherAccount){ //uses a loop to check to see if the username that is in the account is used in another account

        for (int i = 0; i < accountList.size(); i++){ //creates an integer that adds up everytime it goes throught the instructions, stops after it reaches array list size
            if (accountList.get(i).username.equals(otherAccount.username)){ //checks inside the array list, checks inside the accounts
                return false;
            }

        }
        return true;
    }
}
