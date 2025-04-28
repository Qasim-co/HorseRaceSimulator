public class HorseRaceSimulation {
    public static void main(String[] args) {
        Race race = new Race(20, 5);
        Horse horse1 = new Horse('♞', "THUNDER", 0.8);
        Horse horse2 = new Horse('♘', "LIGHTNING", 0.9);
        Horse horse3 = new Horse('♟', "SLOWPOKE", 0.3);
        race.addHorse(horse1, 0); 
        race.addHorse(horse2, 1); 
        race.addHorse(horse3, 2); 
        race.runRace();
    }
}

