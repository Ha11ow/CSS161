import java.util.*;
/**
 * create an object of path. it has displacement, time and speed calculated of the given path
 * 
 * @author (Behnam Khabazan) 
 * @version (112616)
 */
public class Path
{
    private int[][] checkpoint = new int[10][2]; //column 1 = time, column 2 = distance
    private int counterRow = 0;

    /**
     * Constructor for objects of class Path
     */
    public Path(int time1, int distance1, int time2, int distance2) //2 times and 2 distance required to make a checkpoint
    { //error handling
        if (time1 >= 1000 && time1 < 2100){
            checkpoint[counterRow][0] = time1;
            if (distance1 > 2100 && distance1 <= 7700){
                checkpoint[counterRow][1] = distance1;
            }
            else {
                throw new RuntimeException(" Elevation must be between 2100 and 7700 (in feet)");
            }
            counterRow++;
        }
        else {
            throw new RuntimeException(" Time must be between 1000 (10 AM) and 2100 (9 PM)");
        }

        if (time2 >= 1000 && time2 <= 2100){
            if (time1 < time2){
                checkpoint[counterRow][0] = time2;
                if (distance2 >= 2100 && distance2 <7700){
                    if (distance2 < distance1){
                        checkpoint[counterRow][1] = distance2;
                    }
                    else{
                        throw new RuntimeException(" second distance must be bigger than the first distance");
                    }
                }
                else {
                    throw new RuntimeException(" Elevation must be between 2100 and 7700 (in feet)");
                }
            }
            else {
                throw new RuntimeException(" Time must be greater than last time");
            }
            counterRow++;
        }
        else {
            throw new RuntimeException(" Time must be between 1000 (10 AM) and 2100 (9 PM)");
        }

    }

    public void addCheckpoint(int time, int distance){ //to add another check point need another time and distance
        /*
         * This is repeeated in driver just to be sure not to allow a wrong value is passed
         */
        if (counterRow < 10){
            if (time >= 1000 && time < 2100){ //checks that time is between 10-9
                if (time > checkpoint[counterRow - 1][0]){ //checks that time is larger than last time
                    checkpoint[counterRow][0] = time;
                    if (distance >= 2100 && distance <7700){ //checks if distance is between 2100 to 7700
                        if (distance < checkpoint[counterRow - 1][1]){ //checks to see if distance is less than last one
                            checkpoint[counterRow][1] = distance;
                        }
                        else {
                            throw new RuntimeException(" Elevation must be negative");
                        }
                    }
                    else {
                        throw new RuntimeException(" Elevation must be between 2100 and 7700 (in feet)");
                    }
                    counterRow++;
                }
                else {
                    throw new RuntimeException(" Time must be smaller than previous recorded time");
                }
            }
            else {
                throw new RuntimeException (" Time must be between 1000 (10 AM) and 2100 (9 PM)");
            }
        }
        else {//make this in driver (done)
            throw new RuntimeException(" you can only have 10 checkpoints");
        }
    }

    public int totalTime(){ //this gets the total time of the path
        int max = 0;
        for (int i = 0; i < 10; i++){
            if (checkpoint[i][0] > max){
                max = checkpoint[i][0];
            }
        }
        return (max - checkpoint[0][0]);
    }

    public int totalDistance(){ //this gets the total distance of the path
        int min = 7700;
        for (int i = 0; i < 10; i++){
            if (checkpoint[i][1] < min && checkpoint[i][1] >= 2100){
                min = checkpoint[i][1];
            }
        }
        return (checkpoint[0][1] - min);
    }

    public double speed(){ // gets speed of the path(feet per second)
        return (this.totalDistance() / this.totalTime());
    }

    public int getCounterRow(){ //this shows how many checkpoints if needed else where in the program
        return this.counterRow;
    }

    public String toString(){ //toString overriden to return everycheckpoint and their time and distance
        String returns = "";
        for (int i = 0; i <this.counterRow; i++){ //repeats for the amount of checkpoints
            returns += ("\n\t " + (i + 1) + ". Time = " + this.checkpoint[i][0] + " | Distance = " + this.checkpoint[i][1]);
        }
        return (returns);//returns the statement on top
    }

}
