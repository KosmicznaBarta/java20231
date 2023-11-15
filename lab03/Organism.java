package lab03;

import java.util.Random;

public abstract class Organism {
  private int energy;
  private Position position;
  private Random random = new Random();

  Organism(int energy) {
    this.energy = energy;
  }

  public void move(Board board) {
    int newX = position.getX();
    int newY = position.getY();

    boolean moveVertically = random.nextBoolean();

    if (moveVertically) {
      newY += random.nextBoolean() ? 1 : -1;
    } else {
      newX += random.nextBoolean() ? 1 : -1;
    }

    Organism target = board.getOrganism(newX, newY);
    if (target != null && !target.equals(this)) {
      consume(target, board);
      return;
    }

    board.moveOrganism(this, newX, newY);
    System.out.println("Jumping organism moved from (" + position.getX() + ", " + position.getY() + ") to (" + newX + ", " + newY + ")");
  }

  public void consume(Organism target, Board board) {
    int consumedEnergy = target.getEnergy();
    setEnergy(getEnergy() + consumedEnergy);
    target.setEnergy(0);
    board.removeOrganism(target.getPosition());
    System.out.println("Organism ate target on position (" + target.getPosition().getX() + ", " + target.getPosition().getY() + ")");
    System.out.println("Its energy: " + getEnergy());
  }
  public void setPosition(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public int getEnergy() {
    return energy;
  }

  public void setEnergy(int energy) {
    this.energy = energy;
  }
}
