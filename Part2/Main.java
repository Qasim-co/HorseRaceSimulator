import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = null;
        RaceGUI raceGUI = null;

        while (true) {
            System.out.println("\n=== Horse Race Simulator ===");
            System.out.println("1. Create Track");
            System.out.println("2. Create Horses");
            System.out.println("3. Place Bets");
            System.out.println("4. Start Race");
            System.out.println("5. View Statistics");
            System.out.println("6. Start Graphical Race");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                race = createTrack(scanner);
            } else if (choice == 2) {
                if (race == null) {
                    System.out.println("You must create a track first!");
                } else {
                    createHorses(scanner, race);
                }
            } else if (choice == 3) {
                if (race != null) {
                    placeBets(scanner, race);
                } else {
                    System.out.println("Create a track and horses first!");
                }
            } else if (choice == 4) {
                if (race != null) {
                    race.runRace();
                } else {
                    System.out.println("Create a track and horses first!");
                }
            } else if (choice == 5) {
                if (race != null) {
                    race.displayHorseStatistics();
                } else {
                    System.out.println("No race data yet!");
                }
            } else if (choice == 6) {
                // Convert Horse[] to List<Horse>
                List<Horse> horseList = new ArrayList<>();
                for (Horse horse : race.getHorses()) {
                    if (horse != null) {
                        horseList.add(horse);
                    }
                }

                // Start the graphical race
                raceGUI = new RaceGUI(horseList, race.getTrackLength()); // Pass trackLength
                raceGUI.startRace();  // Start graphical race
            } else if (choice == 7) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again!");
            }
        }
        scanner.close();
    }

    private static Race createTrack(Scanner scanner) {
        System.out.print("Enter track length: ");
        int length = scanner.nextInt();
        System.out.print("Enter number of lanes: ");
        int lanes = scanner.nextInt();
        scanner.nextLine();
        return new Race(length, lanes);
    }

    private static void createHorses(Scanner scanner, Race race) {
        // Method for creating horses (same as before)
    }

    private static void placeBets(Scanner scanner, Race race) {
        // Method for placing bets (same as before)
    }
}

