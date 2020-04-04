import java.util.*;
/**
 * Write a description of class Patron here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Patron
{
    private String nickname; 
    private static ArrayList<Path> paths = new ArrayList<Path>();

    public Patron(String nickname){
        this.nickname = nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getNickname(){
        return this.nickname;
    }

    public void newPath(int time1, int distance1, int time2, int distance2){
        Path path = new Path(time1, distance1, time2, distance2);
        addPath(path);
    }

    public void addPath(Path newPath){
        paths.add(newPath);
    }
    
    public void printCheckpoints(){
        for (int i = 0; i < paths.size(); i++){
                System.out.println("Paths Recorded " + i+1 + "! \tCheckpoints: " + paths.get(i).toString());
        }
    }
    
    public int getPathsSize(){
        return paths.size();
    }
    
    public void addCheckpoint(int i, int time, int distance){
        paths.get(i-1).addCheckpoint(time, distance);
    }

    public int getTotalDistance(){
        int totalDistance = 0;
        for (int i = 0; i < paths.size(); i++){
            totalDistance += paths.get(i).totalDistance();
        }
         return totalDistance;
        
    }

    public int getTotalTime(){
        int totalTime = 0;
        for (int i = 0; i < paths.size(); i++){
            totalTime += paths.get(i).totalTime();
        }
        
       return totalTime;
    }

    public double getTotalSpeed(){
        double averageSpeed = 0.0;
        double totalSpeed = 0.0;
        double counter = 0.0;
        for (int i = 0; i < paths.size(); i++){
            totalSpeed += paths.get(i).speed();
            counter++;
        }
        averageSpeed = totalSpeed / counter;
        return (averageSpeed);
    }
    
    

    public String toString(){
        double averageSpeed = 0;
        int totalTime = 0;
        int totalDistance = 0;
        if (paths.size() != 0){
            for (int i = 0; i < paths.size(); i++){
                averageSpeed += paths.get(i).speed();
                totalTime += paths.get(i).totalTime();
                totalDistance += paths.get(i).totalDistance();
            }
            return ("There are " + (paths.size()) + " Paths recorded. Your overal average speed is: " + averageSpeed + "ft./min. and your total distance covered is: " + totalDistance + " feet in a total of " + totalTime + " minutes");
        }
        else{
            return "There are no paths recorded! Try adding a path";
        }
    }
}
