package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }
  /** Getter method for the x-coordinate of the position */
  public int getX() {
    return x;
  }

  /** Getter method for the y-coordinate of the position */
  public int getY() {
    return y;
  }

  /**
   * Constructs and returns a new Position object located one unit in the indicted direction from
   * the "this" object
   */
  public Position getNeighbor(Direction direction) {
    if (direction == Direction.EAST) {
      return new PositionImpl(x + 1, y);
    } else if (direction == Direction.WEST) {
      return new PositionImpl(x - 1, y);
    } else if (direction == Direction.NORTH) {
      return new PositionImpl(x, y + 1);
    } else if (direction == Direction.SOUTH) {
      return new PositionImpl(x, y - 1);
    } else {
      throw new IllegalArgumentException();
    }
  }
}
