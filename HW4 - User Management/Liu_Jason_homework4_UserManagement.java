
import java.util.*;
import java.util.ArrayList;

public class  Liu_Jason_homework4_UserManagement {

    static String username1;
    static String password1;
    static int count = 0;
    static ArrayList<String> Usernames = new ArrayList<String>();
    static ArrayList<String> Passwords = new ArrayList<String>();

    public static void main(String[] args){
        //Scanner s = new Scanner(System.in);
        //signout(s);
        int[] numbers = new int[5];
        int num;
        for (int i = 1; i < 6; i++){
            num = i * 10;
            numbers[i-1] = num;
            System.out.println(numbers[i-1]);
    }
    
        int[] number(unknown size + unknown contains)
        getnumber.length()
        sum = 0;
        for (int i =0; i<length(); i++){
            sum+= number[i];
    }
        System.out.print(sum);
}
    /*
    public static void signout(Scanner s){
        System.out.println("1) Create a new user");
        System.out.println("2) Sign in as existing user");
        System.out.println("3) Exit program");

        int input = s.nextInt();
        switch(input){
            case 1:
            CreateAccount(s);
            count++;
            break;
            case 2:
            signin(s);
            break;
            case 3:
            Exit();
            break;
            case 4:
            System.out.println(Usernames + " \n" + Passwords);

            default:
            System.out.println("Invalid input");
            signout(s);
        }
    }

    public static void signin(Scanner s){
        
        System.out.println("Username: ");
        String inputname = s.next();
        System.out.println("Password: ");
        String inputcode = s.next();
        int i;
        for (i = 0; i < (Usernames.size); i++){
            if (Usernames[0] == 2){
                System.out.println("works");
            }

            /*
            if (inputname.equals(Usernames) &&  inputcode.equals(Passwords))
            {
            System.out.println("1) Change password");
            System.out.println("2) Sign out from current user");
            System.out.println("3) Exit program");
            int input = s.nextInt();
            switch(input){
            case 1:
            changepassword(s);
            break;
            case 2:
            signout(s);
            break;
            case 3:
            Exit();
            break;
            default:
            System.out.println("Invalid input");
            signin(s);
            break;
            }           
            }
            else
            {
                System.out.println("invalid input");
                signin(s);
            }
        }
    }

    public static void CreateAccount(Scanner s){

        System.out.println("username: ");
        String username = s.next();
        Usernames.add(username);
        System.out.println("password: ");
        String password = s.next();
        Passwords.add(password);

        signout(s);
    }

    public static void changepassword(Scanner s){
        System.out.println("password: ");
        s.next();
        signout(s);
    }

    public static void Exit(){
        System.out.println("Thank you for useing the program.");

    }*/
}

