package lab03;

public class Board {
  private int width;
  private int height;
  private Organism[][] organisms;

  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    this.organisms = new Organism[width][height];
  }

  public void addOrganism(Organism organism, int x, int y) {
    if (organisms[x][y] == null) {
      organisms[x][y] = organism;
      organism.setPosition(new Position(x, y));
    } else {
      System.out.println("Position already occupied!");
    }
  }

  public void moveOrganism(Organism organism, int newX, int newY) {
    if (newX >= 0 && newX < width && newY >= 0 && newY < height && organisms[newX][newY] == null) {
      organisms[organism.getPosition().getX()][organism.getPosition().getY()] = null;
      organisms[newX][newY] = organism;
      organism.setPosition(new Position(newX, newY));
    }
    else {
      System.out.println("Invalid move below! This organism won't move until next cycle!");
    }
  }

  public void removeOrganism(Position position) {
    organisms[position.getX()][position.getY()] = null;
  }

  public Organism getOrganism(int x, int y) {
    if (x >= 0 && x < width && y >= 0 && y < height) {
    return organisms[x][y]; }
    else {
      return null;
    }
  }

  public int countOrganisms() {
    int count = 0;
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (organisms[i][j] != null) {
          count++;
        }
      }
    }
    return count;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
