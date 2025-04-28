import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Horse> horses;
    private int trackLength;
    private int numLanes;

    // Constructor
    public Race(int trackLength, int numLanes) {
        this.trackLength = trackLength;
        this.numLanes = numLanes;
        this.horses = new ArrayList<>();
    }

    // Add horse to race
    public void addHorse(Horse horse) {
        if (horses.size() < numLanes) {
            horses.add(horse);
        } else {
            System.out.println("Cannot add more horses, race is full.");
        }
    }

    // Get all horses
    public List<Horse> getHorses() {
        return horses;
    }

    // Get track length
    public int getTrackLength() {
        return trackLength;
    }

    // Method to update the race, check if the race is finished
    public boolean updateRace() {
        boolean raceFinished = false;

        for (Horse horse : horses) {
            if (horse != null) {
                horse.move();  // Move each horse forward
                if (horse.getPosition() >= trackLength) {
                    raceFinished = true;
                }
            }
        }

        // Check if all horses have finished or fallen
        if (allHorsesFallenOrFinished()) {
            raceFinished = true;
        }

        return raceFinished;
    }

    // Helper method to check if all horses are either finished or fallen
    private boolean allHorsesFallenOrFinished() {
        for (Horse horse : horses) {
            if (horse != null && !horse.hasFallen() && horse.getPosition() < trackLength) {
                return false;
            }
        }
        return true;
    }

    // Run the race (start and keep updating the race until it's finished)
    public void runRace() {
        boolean raceFinished = false;
        while (!raceFinished) {
            raceFinished = updateRace();
            try {
                Thread.sleep(500); // Wait for 0.5 second before updating again (simulating race time)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Race Finished!");
        displayRaceResults();
    }

    // Display the results of the race
    public void displayRaceResults() {
        System.out.println("\n--- Race Results ---");
        for (Horse horse : horses) {
            System.out.println(horse.getName() + " - Position: " + horse.getPosition());
        }
    }

    // Display horse statistics
    public void displayHorseStatistics() {
        System.out.println("\n--- Horse Statistics ---");
        for (Horse horse : horses) {
            System.out.println("Name: " + horse.getName());
            System.out.println("Total Races: " + horse.getRaceTimes().size());
            System.out.println("Win Ratio: " + String.format("%.2f", horse.getWinRatio()) + "%");
            System.out.println("Average Speed: " + String.format("%.2f", horse.getAverageSpeed(trackLength)) + " units per second");
            System.out.println("Race Times: " + horse.getRaceTimes());
            System.out.println();
        }
    }

    // Other getter methods
    public int getNumLanes() {
        return numLanes;
    }

}

