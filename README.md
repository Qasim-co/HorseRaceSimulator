# HorseRaceSimulator

## Overview
HorseRaceSimulator is a Java-based simulation of a horse race. It allows you to customize horses, select betting options, and run races on customizable tracks. The simulation also includes a statistics manager to track the performance of horses.

## Features
- **Customizable horses**: Create and modify horses with different attributes.
- **Customizable tracks**: Design your own race tracks for the simulation.
- **Betting system**: Place virtual bets on the races.
- **Race simulation**: Run races and watch them unfold with a visual representation.
- **Statistics**: Track horse performance, including wins and race times.

## Project Structure
- `Part1/`: Contains classes and components for the first part of the simulation.
- `Part2/`: Includes enhancements and additional features for the second part, such as GUI and betting system.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Qasim-co/HorseRaceSimulator.git
   cd HorseRaceSimulator
2. Dependencies:
This project requires Java to run. Ensure that you have Java 8 or higher installed.
To check your Java version:
java -version
3. Compiling and Running the Program:
Text-Based Version:
Navigate to the Part1/ directory.
Compile the Java files:
javac Part1/*.java
Run the simulation:
java Part1.HorseRaceSimulation
The startRace method will be invoked to run the race.
Graphical Version:
Navigate to the Part2/ directory.
Compile the Java files:
javac Part2/*.java
Run the graphical version of the simulation:
java Part2.HorseRaceSimulation
The startRaceGUI method will be invoked to start the graphical race simulation.

## How to Use

For Textual Race Simulation:
Once compiled, you can run the HorseRaceSimulation class in Part1/ to simulate the race in the terminal.
You will be prompted to select horses and start the race.
For Graphical Race Simulation:
For the GUI-based race simulation, run the HorseRaceSimulation class in Part2/ to launch the graphical user interface.
You can customize the horses, track, and place bets through the GUI.
Part 1: Text-Based Race Simulation

startRace (Text-Based):
This method is responsible for starting the race in the textual version. It will create and initialize horses and race settings, and then execute the race based on those inputs.
Compiling and Running:
To compile and run the textual simulation:
cd Part1/
javac *.java
java HorseRaceSimulation
Part 2: Graphical Race Simulation

startRaceGUI (Graphical):
This method is used in the GUI version to initialize and display the race simulation. It provides an interactive interface for users to customize their experience, such as selecting horses, setting up the track, and placing bets.
Compiling and Running:
To compile and run the graphical version:
cd Part2/
javac *.java
java HorseRaceSimulation
This will launch the graphical user interface where you can interact with the simulation.
