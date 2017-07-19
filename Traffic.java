import java.util.ArrayList;

/**
 * Created by Devang on 7/18/2017.
 */
public class Traffic {
    public static void main(String[] args) {
        ArrayList<Road> roads = new ArrayList<>();
        roads.add(new Road("Snail"));
        roads.add(new Road("Weaver"));
        
        test(roads, 20, 3, 1);
        // test(roads, 20, 4, 1);
        
    }
    
    public static void test(ArrayList<Road> roads, int totalTime, int greenTime, int redTime){
        System.out.printf("Testing: TT:  %d, GT: %d, RT: %d\n", totalTime, greenTime, redTime);
        System.out.println("--------------------------------------------------");
        if(roads.size() > 0){
            int timeLeft = totalTime;
            int roadNum = 0;
            while(timeLeft > 0) {
                if(roadNum == roads.size()){
                    roadNum = 0;
                }
    
                
                System.out.println();
                System.out.println("Time Left: " + timeLeft);
                
                int green = (timeLeft < greenTime) ? timeLeft : greenTime;
                System.out.println("Road: " + roads.get(roadNum).name + " / " + "Green / " + green);
                SignalGreen(roads, green, roadNum);
                printRoadStatus(roads);
                timeLeft -= green;
                
                
                if(timeLeft > 0) {
                    int red = (timeLeft < redTime) ? timeLeft : redTime;
                    System.out.println("Road: ALL ROADS " + "/ " + "Red/ " + red);
                    SignalRed(roads, red);
                    printRoadStatus(roads);
                    timeLeft -= red;
    
                    roadNum++;
                }
            }
        }
        
    }
    
    public static void SignalGreen(ArrayList<Road> roads, int secs, int roadNum){
        for (int i = 0; i < roads.size(); i++) {
            Road thisRoad = roads.get(i);
            if(i == roadNum){
                thisRoad.ChangeSignal(Signal.GREEN, secs);
                System.out.println(thisRoad.name + ": GREEN");
            } else {
                thisRoad.ChangeSignal(Signal.RED, secs);
            }
        }
    }
    
    
    public static void SignalRed(ArrayList<Road> roads, int secs){
        for (int i = 0; i < roads.size(); i++) {
            Road thisRoad = roads.get(i);
            thisRoad.ChangeSignal(Signal.RED, secs);
            
        }
    }
    
    public static void printRoadStatus(ArrayList<Road> roads) {
        for (int i = 0; i < roads.size(); i++) {
            System.out.println(roads.get(i));
        }
    }
    
    
}
