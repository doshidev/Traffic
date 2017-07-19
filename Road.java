/**
 * Created by Devang on 7/18/2017.
 */
public class Road {
    // Properties
    String name;
    int upward;
    int downward;
    Signal s;
    
    
    // Constructor
    public Road (String name){
        this.name = name;
        this.upward = 0;
        this.downward = 0;
        this.s = Signal.RED;
    }
    
    public Road(String name, int upward, int downward){
        this.name = name;
        this.upward = upward;
        this.downward = downward;
        this.s = Signal.RED;
    }
    
    
    // Methods
    public void ChangeSignal(Signal s, int secs){
        if(s == Signal.RED){
            upward += secs;
            downward += secs;
        } else if(s == Signal.GREEN) {
            int carsToGo = secs - 1;
            if(upward >= carsToGo) {
                upward -= carsToGo;
            } else {
                upward = 0;
            }
            
            if(downward >= carsToGo) {
                downward -= carsToGo;
            } else {
                downward = 0;
            }
        }
    }
    
    public String toString(){
        return name + "[U:" + this.upward + ", D: " + this.downward + "]";
        // Route66[U:15, D:11]
    }
}
