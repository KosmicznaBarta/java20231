package lab03;

public class LifeSimulator {

  public static void main(String[] args) {
    Board board = new Board(10, 10);

    Organism jumping = new JumpingOrganism(100);
    board.addOrganism(jumping, 5, 5);

    Organism sight = new SightOrganism(100, 3);
    board.addOrganism(sight, 6, 6);

    int cycles = 0;
    while (board.countOrganisms() > 1 && cycles < 1000) {
      System.out.println("Cycle: " + cycles);
      sight.move(board);
      jumping.move(board);

      if (board.countOrganisms() == 1) {
        System.out.println("GAME OVER");
        break;
      }

      cycles++;
    }

    System.out.println("Simulation ended after " + (cycles) + " cycles.");
    System.out.println("End of simulation!");
  }
}