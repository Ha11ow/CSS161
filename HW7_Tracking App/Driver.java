import java.util.*;
/**
 * code that written in path and patron will execute here
 * 
 * @author (Behnam khabazan) 
 * @version (112916)
 */
public class Driver
{
    public static void main(String Args[]){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Welcome to TrackKeeper, Please Type in your nickname to begin.\nNickname: ");
        String nickname = Scan.next(); //gets nickname
        Patron patron = new Patron(nickname); //creates a new object patron
        int selection; // created for the menu, to select options
        String newNickname; //this is initialized out of loop the new nickname if user wants to change
        int checkpointTime; //initializing the variable time to add checkpoints
        int checkpointDistance; //initializing the variable distance to add checkpoints
        int time1 = 1; //initializing the first variable time to add to create paths
        int time2 = 1; //initializing the first variable distance to add to create paths
        int distance1 = 1;//initializing the second variable time to add to create paths
        int distance2 = 1;//initializing the second variable distance to add to create paths
        boolean isCorrect = false; //boolean that turns true and stop the loop
        String addcheckpoint = "Y"; //initializing set up to go throught the while loop
        int counter = 0; //counter to see how many times gone through to check which paths
        do {//redos the menu
            System.out.print("\nWelcome Back, " + patron.getNickname() + 
                "\nPlease Choose One of the Bellow: " + 
                "\n1. ChangeNickname" + 
                "\n2. View Paths" + 
                "\n3. Add Path" + 
                "\n4. View Stats" + 
                "\n0. Exit" + 
                "\nYour Selection: ");
            selection = Scan.nextInt(); //selection to see what the user wants to do
            if (selection == 1){ //if user wants to change nickname
                System.out.print("What is the new nickname? ");
                newNickname = Scan.next(); //asks for new nickname
                patron.setNickname(newNickname); //passes through parameter to set the new nickname
                System.out.println("Name Successfully Changed");
            }
            else if (selection == 2){ //if user want to see all the currents paths and checkpoints
                if (counter != 0){ //if there is a path recorded
                
                patron.printCheckpoints(); //prints paths and checkpoints
            }
            else{
                System.out.println("There are no paths recorded. Try adding a path");
            }
            }
            else if (selection == 3){ //if user wants to add paths
                do{ //redo till user correctly sets a new path
                    System.out.print("\nPress 0 to exit at anypoint:\nWhat is the initial time?(1000 - 2099) ");
                    time1 = Scan.nextInt(); //ask for the first time
                    if (time1 >= 1000 && time1 < 2100){//check to see if it is correct
                        System.out.print("What is the inital distance?(7700 - 2101) ");
                        distance1 = Scan.nextInt(); //ask for the first distance
                        if (distance1 > 2100 && distance1 <= 7700){ //checks to see if correct
                            System.out.print("What is the current time?(1001 - 2100) " );
                            time2 = Scan.nextInt();//asks for the second time
                            if (time2 > 1000 && time2 <= 2100 && (time1 < time2)){ //checks to see if correct
                                System.out.print("what is the current distance?(7699 - 2100) ");
                                distance2 = Scan.nextInt();//asks for the second distance
                                
                                if (distance2 >= 2100 && distance2 <7700 && (distance2 < distance1)){ //checks to see if its correct
                                    patron.newPath(time1, distance1, time2, distance2);
                                    System.out.print("Path Successfully added.");
                                    counter++; //number of paths increases
                                    while (addcheckpoint.equalsIgnoreCase("Y")){ //loop to add checkpoints
                                    System.out.print(" Would you like to add another checkpoint?(y/n) ");
                                    addcheckpoint = Scan.next(); //asks for a y or n to continue
                                    addcheckpoint = "Y";
                                    if (addcheckpoint.equalsIgnoreCase("Y")){ //if user says yes
                                        if ((counter <= patron.getPathsSize()) && (counter >= 1)){ //and counter is less than 10 (number of max checkpoints)
                                            System.out.print("Insert Time and Distance seperated by space!\nNote: Time must increase and Distance must decrease.\nTime Range(1001 = 2100), Distance(2100-7701): ");
                                            checkpointTime = Scan.nextInt();//ask for new time
                                            checkpointDistance = Scan.nextInt();//ask for new distance
                                            
                                            patron.addCheckpoint(counter, checkpointTime, checkpointDistance); //pass time and distance to param, and add to path.
                                            System.out.println("Successfully added");
                                            
                                        }
                                    }
                                    else if(addcheckpoint.equalsIgnoreCase("n")){ //if user says no dont do anything
                                        addcheckpoint = "n";
                                    }
                                    else {
                                        System.out.println("What was that?");  //repeat till y or n
                                    }
                                }
                                    isCorrect = true; //user successfully set up so end of loop
                                }
                                else if (distance2 == 0){
                                    isCorrect = true; //user successfully set up so end of loop (to get out of loop if needed)
                                }
                                else {
                                    isCorrect = false; //user didnt successfully set up dont end loop
                                    System.out.println(" Elevation must be between 2100 and 7700 (in feet)\n and second distance must be lower than the first distance");
                                }
                            }
                            else if (time2 == 0){
                                isCorrect = true;//user successfully set up so end of loop
                            }
                            else {
                                isCorrect = false;//user didnt successfully set up dont end loop
                                System.out.println(" Time must be between 1000 (10 AM) and 2100 (9 PM)\n and  Time must be greater than last time");
                            }
                        }
                        else if (distance1 == 0){
                            isCorrect = true;//user successfully set up so end of loop (to get out of loop if needed)(user doesnt know)
                        }
                        else{
                            isCorrect = false;//user didnt successfully set up dont end loop
                            System.out.println(" First Distination must be between 2101 and 7700 (in feet)");
                        }
                    } 
                    else if (time1 == 0){
                        isCorrect = true; //(to get out of loop if needed)
                    }
                    else {
                        isCorrect = false;//user didnt successfully set up dont end loop
                        System.out.println(" Time must be between 1000 (10 AM) and 2100 (9 PM)");
                    }
                }while (isCorrect != true); //end loop if user correctly made an account

            }
            else if (selection == 4){ //if user needs to view stats
                System.out.println(patron);//print @overriden toString of patron to show stats
            }
            else if (selection == 0){ //exit if user chooses 0
                System.out.println("Thank for using TrackKeeper!");
                System.exit(0); //exit
            }
            else { //if user manages to set up a non valid selection
                System.out.println("Please choose a correct answer");
            }
        }while (selection != 0); //redo loop till user chooses 0 which exits
    }
}
