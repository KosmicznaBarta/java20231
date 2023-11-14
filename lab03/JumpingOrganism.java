package lab03;

import java.util.Random;

public class JumpingOrganism extends Organism {
    private int energy;
    private Position position;
    private Random random = new Random();

    public JumpingOrganism(int energy) {
        super(energy); }

    public void move(Board board) {
        int CurrentX = getPosition().getX();
        int CurrentY = getPosition().getY();

        int newX = CurrentX;
        int newY = CurrentY;

        boolean moveVertically = random.nextBoolean();

        if (moveVertically) {
            newY += random.nextBoolean() ? 2 : -2;
        } else {
            newX += random.nextBoolean() ? 2 : -2;
        }

        System.out.println("Jumping organism moved from (" + CurrentX + ", " + CurrentY + ") to (" + newX + ", " + newY + ")");

        Organism target = board.getOrganism(newX, newY);
        if (target != null && !target.equals(this)) {
            consume(target, board);
            return;
        }

        board.moveOrganism(this, newX, newY);
    }
}