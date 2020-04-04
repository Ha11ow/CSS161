
/**
 * This is the user, it creates a new user for the project
 * 
 * @author (Behnam Khabazan) 
 * @version (110816)
 */
public class User
{
    private static String username; //creating private Username
    private static String password;//creating private Password
    private static String firstName; //creating private firstname
    private static String lastName;//creating private last name

    /*
     * Constructor
     */
    public User(){}; //overloading to allow accounts to import a user, can set up later using the setters

    public User(String firstName, String lastName, String username, String password ){ //taking new parameters for first time user set ups
        if (firstName.length() == 0){ //First name cannot be empty
            throw new RuntimeException("Firstname cannot be left out empty.");
            //make user rewrite the name.
        }
        else {
            this.firstName = firstName;
        }
        if (lastName.length() == 0){//lastname cannot be empty
            throw new RuntimeException("Lastname cannot be left out empty.");
            //make user rewrite the lastname.
        }
        else {
            this.lastName = lastName;
        }
        if (username.length() < 4){
            throw new RuntimeException("Username must be more than four characters");
            //make user rewrite the user.
        }
        else {
            this.username = username;
        }
        if (password.length() < 4){
            throw new RuntimeException("Username must be more than four characters");
            //make user rewrite the user.
        }
        else {
            this.password = password;
        }
    }

    
    /*
     * getters
     */
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }

    
    /*
     * setters
     */
    public void setFirstName(String firstName) {//@param string = taking the first name to be imported
        if (firstName.equals(null)){
            throw new RuntimeException("Firstname cannot be left out empty.");
        }
        else {
           this.firstName = firstName;
           }
    }
    public void setLastName(String lastName) { //@param string = taking the last name to be imported
        if (lastName.equals(null)){
            throw new RuntimeException("Lastname cannot be left out empty.");
        }
        else {
            this.lastName = lastName;
        }
    }
    public void setUsername(String username) {  //@param string = taking the username to be imported
        if (username.length() < 4){
            throw new RuntimeException("Username must be more than four characters");
        }
        else {
            this.username = username;
        }
    }
    public void setPassword(String password) { //@param string = taking the first name to be imported
        if (password.length() < 4){
            throw new RuntimeException("Username must be more than four characters");
        }
        else {
            this.password = password;
        }
    }

    
    /*
     * @override toString
     */
    public String toString(){ //overriding the toString to allow easier returns
        return "Name: " + this.firstName + " " + this.lastName + " |Username: " + this.username + " |Password: "
        + this.password;
    }
    public boolean equals(User other){ //overriding the toString to see if everything set in the user is the same
        if ((this.username.equals(other.username)) && (this.firstName.equals(other.firstName)) && 
            (this.lastName.equals(other.lastName)) && (this.password.equals(other.password))){ 
                return true;
        }
        else{
            return false;
        }
    }
}
