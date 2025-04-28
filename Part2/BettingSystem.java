import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BettingSystem {
    private double balance;
    private Map<Horse, Double> odds;
    private Map<Horse, Double> bets;

    public BettingSystem() {
        this.balance = 1000.0; 
        this.odds = new HashMap<>();
        this.bets = new HashMap<>();
    }

    public void calculateOdds(Horse[] horses) {
        Random rand = new Random();
        odds.clear();
        for (Horse horse : horses) {
            if (horse != null) {
                double base = 1.5 + rand.nextDouble() * 2.5; 
                odds.put(horse, base);
            }
        }
    }

    public void displayOdds() {
        System.out.println("\n--- Betting Odds ---");
        for (Horse horse : odds.keySet()) {
            System.out.println(horse.getName() + " (" + horse.getSymbol() + "): " + String.format("%.2f", odds.get(horse)) + "x");
        }
    }

    public void placeBet(Horse horse, double amount) {
        if (amount > balance) {
            System.out.println("Not enough balance to place bet!");
            return;
        }
        balance -= amount;
        bets.put(horse, amount);
    }

    public void processRaceResult(Horse winner) {
        if (bets.containsKey(winner)) {
            double winnings = bets.get(winner) * odds.get(winner);
            System.out.println("You won! You earned: $" + String.format("%.2f", winnings));
            balance += winnings;
        } else {
            System.out.println("You lost your bet.");
        }
        bets.clear();
    }
    
    public void processNoWinner() {
        System.out.println("Since no horse finished the race, all bets are lost.");
        bets.clear();
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }
}

