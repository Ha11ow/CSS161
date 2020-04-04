import java.util.*;
import java.util.ArrayList;

/*
 * Author(Behnam Khabazan)
 * Version: 111116
 */
public class BehnamKhabazan_HW4_UserManagement {
    static ArrayList<String> UserName = new ArrayList<String>();  //array list for the usernames
    static String userName; //declared usernames
    static String setUser; //this is the set of users
    static ArrayList<String> PassWord = new ArrayList<String>();  //array list for the passwords
    static String passWord; //declared passwords
    static String setPass; //this is to change pass
    public static void MainMenu(Scanner Scan) { //normal main menu with scanner as the parameter
        System.out.println("1) Create a new user");             
        System.out.println("2) Sign in as existing user"); 
        System.out.println("3) Exit program");

        int selection = Scan.nextInt();
        if (selection == 1){
            Register(Scan); //calls register method to register acc
        }
        else if (selection == 2) {
            Sign_In(Scan); //calls sign in method to sign in
        }
        else if (selection == 3){
            System.out.println("You have successfully exited the program!"); //stops program
            System.exit(10);
        }
        else {
            System.out.println("\nNOT A VALID SELECTION!"); // error
            MainMenu(Scan); //recursion and redo
        }
    }
    public static void MainMenu2(Scanner Scan) {//mainmenu 2 is when ur logged in, different options
        System.out.println("1) Change passWord");
        System.out.println("2) Sign out from current user");
        System.out.println("3) Exit program");
        int selection = Scan.nextInt();
        if (selection == 1){ //compares options
            ChangePassWord(Scan);
        }
        else if (selection == 2) {//compares options
            Sign_Out(Scan);
        }
        else if (selection == 3){//compares options 
            System.out.println("You have successfully exited the program!");
            System.exit(10); //stops the program 
        }
        else {
            System.out.println("\nNOT A VALID SELECTION!");
            MainMenu2(Scan);
        }
    }
    public static void Sign_In(Scanner Scan) { //Sign_In as exiting user
        System.out.println("Username: ");
        setUser = Scan.next();
        for (int i = 0; i < UserName.size(); i++) { //i is the number of element in array, keeps increasing until it matches the inputuser 

                if ((setUser.toLowerCase()).contains(UserName.get(i))) { //if there is a match between input and array:
                System.out.println("Password: "); 
                setPass = Scan.next(); //ask for password
                if ((setPass.equals(PassWord.get(i)))) { //checks for password for the same user
                    MainMenu2(Scan);
                } else { //password is incorrect
                    System.out.println("Password incorrect");
                    MainMenu(Scan);
                }

            }
            if (i >= UserName.size()) {  //looks for username and then stops loop
                break;
            }
        }
        System.out.println("Username was not found, please try again"); //if user doesnt exist it errors out of loop and skips to this and then to mainmenu
        MainMenu(Scan);

    }

    public static void Sign_Out(Scanner Scan) { // sign out menu, goes back to mainmenu
        System.out.println("You have successfully Signed Out!");
        MainMenu(Scan);
    }

    public static void Register(Scanner Scan) { //create an account here

        System.out.println("Username: ");
        userName = Scan.next(); //user inputs username
        if ((userName.length() >= 3) && (userName.length() < 10)) {// username must be at least 3 letters

            if (!((UserName.contains(userName.toLowerCase())))) { //searches to see if username exists
                UserName.add(userName.toLowerCase());      //transfer all selection username into lower case, then saves in the string
                System.out.println("Password: ");
                passWord = Scan.next(); //asks for password
                if (passWord.length() >= 3) { //password must be at least 3 letters
                    PassWord.add(passWord);
                    MainMenu(Scan);
                } else {
                    System.out.println("Password must be at least 3 dights.");
                    UserName.remove(userName); //removes username if password doesnt work
                    Register(Scan);//recalls the method to retry
                }
            } else {
                System.out.println("Username exist, choose another username");
                Register(Scan); //calls the method to retry
            }
        } else {
            System.out.println("The Username must have 3 letters, and cannot be more than 10");
            MainMenu(Scan);
        }

    }

    public static void ChangePassWord(Scanner Scan) {//change passWord
        System.out.println("Changing password for " + setUser);
        System.out.println("What's your last password ");
        String lastPassword = Scan.next();//asks for password

        if (lastPassword.contains(setPass)) {
            System.out.println("Whats your new password: ");
            String passWord = Scan.next(); //asks for new password
            if (passWord.length() >= 3) {
                PassWord.set(UserName.indexOf(setUser.toLowerCase()),passWord);
                System.out.println("New passWord has set successfully!\n");

                
            } else {
                System.out.println("Password must have 3 letters");
                ChangePassWord(Scan);
            }
        } else {
            System.out.println("Please put in the old Password"); 
            ChangePassWord(Scan);// redoes the method
        }
        MainMenu2(Scan);
    }
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        MainMenu(Scan);
        
    }
}
