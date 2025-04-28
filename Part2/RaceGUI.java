import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RaceGUI extends JPanel {
    private List<Horse> horses;  // Change to List<Horse>
    private int trackLength;

    public RaceGUI(List<Horse> horses, int trackLength) {
        this.horses = horses;
        this.trackLength = trackLength;
        setPreferredSize(new Dimension(800, 400));  // Set the panel size
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTrack(g);
        drawHorses(g);
    }

    private void drawTrack(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 50, trackLength * 10, 30); // Drawing the race track
    }

    private void drawHorses(Graphics g) {
        for (Horse horse : horses) {
            g.setColor(Color.BLACK);
            g.fillOval(horse.getPosition() * 10, 50, 20, 20); // Drawing horses as circles
        }
    }

    public void updateHorsePositions() {
        for (Horse horse : horses) {
            horse.move();
        }
        repaint();
    }

    public void startRace() {
        while (true) {
            updateHorsePositions();
            try {
                Thread.sleep(500); // Pause to simulate time passing in the race
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

