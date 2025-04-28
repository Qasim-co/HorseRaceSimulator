import java.util.concurrent.TimeUnit;
import java.lang.Math;
public class Race {
    private int raceLength;
    private int numLanes;
    private Horse[] horses;

    public Race(int distance, int lanes) {
        // initialize instance variables
        raceLength = distance;
        numLanes = lanes;
        horses = new Horse[numLanes];
    }
    
    public Race(int distance) {
        this(distance, 3); // Default to 3 lanes for compatibility
    }
    
    public void addHorse(Horse theHorse, int laneNumber) {
        if (laneNumber >= 0 && laneNumber < numLanes) {
            horses[laneNumber] = theHorse;
        } else {
            System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
        }
    }
    
    public void startRace() {
        runRace(); 
    }
    
    public void runRace() {
        boolean finished = false;
        Horse winner = null;
        
        for (int i = 0; i < numLanes; i++) {
            if (horses[i] != null) {
                horses[i].goBackToStart();
            }
        }
                      
        while (!finished) {
            for (int i = 0; i < numLanes; i++) {
                if (horses[i] != null) {
                    moveHorse(horses[i]);
                }
            }
                    
            printRace();
    
            winner = getWinner();
            if (winner != null) {
                finished = true;
            }
           
            try { 
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(Exception e) {}
        }
        
        System.out.println("And the winner is... " + winner.getName() + "!");
    }
    
    private Horse getWinner() {
        for (int i = 0; i < numLanes; i++) {
            if (horses[i] != null && raceWonBy(horses[i])) {
                return horses[i];
            }
        }
        return null;
    }
    
    private void moveHorse(Horse theHorse) {
        if (!theHorse.hasFallen()) {
            if (Math.random() < theHorse.getConfidence()) {
               theHorse.moveForward();
            }
            
            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence())) {
                theHorse.fall();
                theHorse.setConfidence(theHorse.getConfidence() * 0.95);
            }
            if (theHorse.getDistanceTravelled() >= raceLength) {
                theHorse.setConfidence(Math.min(1.0, theHorse.getConfidence() * 1.05));
            }
        }
    }
        
    private boolean raceWonBy(Horse theHorse) {
        return theHorse.getDistanceTravelled() >= raceLength;
    }
    
    private void printRace() {
        System.out.print('\u000C');  
        
        multiplePrint('=', raceLength + 3); 
        System.out.println();
        
        for (int i = 0; i < numLanes; i++) {
            if (horses[i] != null) {
                printLane(horses[i]);
                System.out.print(" " + horses[i].getName() + " (Current confidence " + 
                          String.format("%.1f", horses[i].getConfidence()) + ")");
            } else {
                printEmptyLane();
            }
            System.out.println();
        }
        
        multiplePrint('=', raceLength + 3); 
        System.out.println();    
    }
    
    private void printEmptyLane() {
        System.out.print('|');
        multiplePrint(' ', raceLength);
        System.out.print('|');
    }
    
    private void printLane(Horse theHorse) {
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        
        System.out.print('|');
        
        multiplePrint(' ', spacesBefore);
        
        if (theHorse.hasFallen()) {
            System.out.print('❌');
        } else {
            System.out.print(theHorse.getSymbol());
        }
        
        multiplePrint(' ', spacesAfter);
        
        System.out.print('|');
    }
    
    private void multiplePrint(char aChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(aChar);
        }
    }
}
