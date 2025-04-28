public class StatisticsManager {
    public void displayHorseStatistics(Horse horse, int trackLength) {
        System.out.println("\n--- Horse Statistics for " + horse.getName() + " ---");
        System.out.println("Total Races: " + horse.getRaceTimes().size());
        System.out.println("Win Ratio: " + String.format("%.2f", horse.getWinRatio()) + "%");
        System.out.println("Average Speed: " + String.format("%.2f", horse.getAverageSpeed(trackLength)) + " units per second");
        System.out.println("Race Times: " + horse.getRaceTimes());
    }

    public void compareHorses(Horse horse1, Horse horse2, int trackLength) {
        System.out.println("\n--- Horse Comparison ---");
        System.out.println(horse1.getName() + " - Avg Speed: " + String.format("%.2f", horse1.getAverageSpeed(trackLength)) + " Win Ratio: " + String.format("%.2f", horse1.getWinRatio()) + "%");
        System.out.println(horse2.getName() + " - Avg Speed: " + String.format("%.2f", horse2.getAverageSpeed(trackLength)) + " Win Ratio: " + String.format("%.2f", horse2.getWinRatio()) + "%");
    }
}

