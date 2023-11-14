package lab03;

import java.util.Random;

public class SightOrganism extends Organism {
    private int energy;
    private Position position;
    private Random random = new Random();
    private int sightRadius;

    public SightOrganism(int energy, int sightRadius) {
        super(energy);
        this.sightRadius = sightRadius;
    }
    public void move(Board board) {
        int CurrentX = getPosition().getX();
        int CurrentY = getPosition().getY();

        Organism jumpingOrganism = board.getOrganism(CurrentX, CurrentY);
        if (jumpingOrganism instanceof JumpingOrganism) {
        System.out.println("Sight organism detected Jumping organism!");

        ((JumpingOrganism) jumpingOrganism).consume(this, board);
        return;
        }

        for (int i = CurrentX - sightRadius; i <= CurrentX + sightRadius; i++) {
                for (int j = CurrentY - sightRadius; j <= CurrentY + sightRadius; j++) {
                    if (i >= 0 && i < board.getWidth() && j >= 0 && j < board.getHeight()) {
                        Organism target = board.getOrganism(i, j);
                        if (target != null && target != this) {
                            System.out.println("Sight organism detected organism at (" + i + ", " + j + ")");
                            break;
                        }
                    }
                }
             }

        int newX = CurrentX + random.nextInt(2 * sightRadius + 1) - sightRadius;
        int newY = CurrentY + random.nextInt(2 * sightRadius + 1) - sightRadius;

        newY += random.nextBoolean() ? 1 : -1;
        newX += random.nextBoolean() ? 1 : -1;

        board.moveOrganism(this, newX, newY);
        System.out.println("Sight organism moved from (" + CurrentX + ", " + CurrentY + ") to (" + newX + ", " + newY + ")");

    }
}