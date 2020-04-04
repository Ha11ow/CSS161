
/**
 * This is the Account, it imports user to create an account and adds balance to the account.
 * 
 * @author (Behnam Khabazan ) 
 * @version (11/12/16)
 */
public class Account
{
    private double balance; // creating a private balance
    User newUser = new User(); //importing the user
    String firstname;
    String lastname;
    String username;
    String password;
    /*
     * constructor
     * @param User = the newUser that is created above, or else computer would not know which user to import
     */
    public Account(User newUser, double balance){
        newUser = newUser;
        this.balance = balance;
        firstname = newUser.getFirstName();
        lastname = newUser.getLastName();
        username = newUser.getUsername();
        password = newUser.getPassword();

    }

    /*
     * actions
     */
    public void addFunds(double amount){//@param double = the amount that is to be added
        if (amount >= 0){
            this.balance += amount;
            System.out.println("Adding " + amount + " to the username: " + username + "!");
        }
        else {
            throw new RuntimeException("Sorry but you cannot add negative balance");
        }
    }

    public void withdraw(double amount){//@param double = the amount that is to be removed
        if (((this.balance - amount) < 0)  && (amount < 0)){
            throw new RuntimeException("Sorry but you cannot withdraw negative amount");
        }
        else {
            System.out.println("Withdrawing " + amount + " to the username: " + username + "!");
            this.balance -= amount;
        }
    }

    /*
     * getters and setters
     */
    public double getBalance(){//gets balance and returns it
        return balance;
    }

    public boolean equals(Account other){ //overriding the toString to see if everything set in the user is the same
        if ((this.balance == (other.balance) && (this.firstname.equals(other.firstname)) && 
            (this.lastname.equals(other.lastname)) && (this.password.equals(other.password)))){ 
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * @override toString
     */ 
    public String toString(){//overriding toString to creating new toString
        return "Name: " + firstname + ", " + this.lastname + "\t    |your Username is: " + this.username + "\t    |your Password is: " + this.password + "\t"  + "   |Your balance is: " + this.getBalance();
    }

    
}
