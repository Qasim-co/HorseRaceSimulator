public class Horse {
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean hasFallen;
    private double confidence;
    
    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.symbol = horseSymbol;
        this.name = horseName;
        this.confidence = horseConfidence;
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }
    
    public void fall() {
        this.hasFallen = true;
    }
    
    public double getConfidence() {
        return this.confidence;
    }
    
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }
    
    public String getName() {
        return this.name;
    }
    
    public char getSymbol() {
        return this.symbol;
    }
    
    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }
    
    public boolean hasFallen() {
        return this.hasFallen;
    }
    
    public void moveForward() {
        this.distanceTravelled++;
    }
    
    public void setConfidence(double newConfidence) {
        this.confidence = newConfidence;
    }
    
    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }
}
