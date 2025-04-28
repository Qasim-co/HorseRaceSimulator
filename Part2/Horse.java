import java.util.ArrayList;
import java.util.List;

public class Horse {
    private String name;
    private char symbol;
    private char originalSymbol;  
    private double confidence;
    private String breed;
    private String color;
    private String saddle;
    private String horseshoes;
    private String accessory;
    private int position;
    private int racesParticipated;
    private int racesWon;
    private List<Double> raceTimes;
    private boolean fallen;      
    private double fallRisk;     

    public Horse(String name, char symbol, double confidence, String breed, String color, String saddle, String horseshoes, String accessory) {
        this.name = name;
        this.symbol = symbol;
        this.originalSymbol = symbol; 
        this.confidence = confidence;
        this.breed = breed;
        this.color = color;
        this.saddle = saddle;
        this.horseshoes = horseshoes;
        this.accessory = accessory;
        this.position = 0;
        this.racesParticipated = 0;
        this.racesWon = 0;
        this.raceTimes = new ArrayList<>();
        this.fallen = false;
        
        this.fallRisk = 0.01 + Math.random() * 0.04;
        if (horseshoes.toLowerCase().contains("cheap") || horseshoes.toLowerCase().contains("old")) {
            this.fallRisk += 0.03;  
        }
    }

    public void move() {
        if (fallen) {
            return;
        }
        if (Math.random() < fallRisk) {
            fall();
            return;
        }
        
        double moveChance = Math.random();
        if (moveChance < confidence) {
            position += 1;
        }
    }
    
    public void fall() {
        fallen = true;
        symbol = '❌'; 
        System.out.println("\n💥 " + name + " has fallen!");
    }
    
    public boolean hasFallen() {
        return fallen;
    }
    
    public void resetPosition() {
        position = 0;
        fallen = false;
        symbol = originalSymbol;  
    }

    public void recordRace(double timeTaken, boolean won) {
        racesParticipated++;
        if (won) racesWon++;
        raceTimes.add(timeTaken);
    }

    public double getAverageSpeed(int trackLength) {
        if (raceTimes.isEmpty()) return 0;
        double totalSpeed = 0;
        for (double time : raceTimes) {
            totalSpeed += (trackLength / time);
        }
        return totalSpeed / raceTimes.size();
    }

    public double getWinRatio() {
        if (racesParticipated == 0) return 0;
        return (double) racesWon / racesParticipated * 100;
    }

    public List<Double> getRaceTimes() {
        return raceTimes;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
    
    public double getConfidence() {
        return confidence;
    }
}
