package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private String name;
  private Position start;
  private Inventory chest;

  public PlayerImpl(String name, int startX, int startY) {
    this.name = name;
    this.start = new PositionImpl(startX, startY);
    this.chest = new InventoryImpl();
  }
  /** Getter method for the player's current position */
  public Position getPosition() {
    return this.start;
  }

  /** Getter method for the player's inventory */
  public Inventory getInventory() {
    return this.chest;
  }

  /** Getter method for the player's name */
  public String getName() {
    return this.name;
  }

  /**
   * Blindly moves the player's position one unit in the indicated direction, without checking
   * whether the new location is valid
   */
  public void move(Direction direction) {
    start = start.getNeighbor(direction);
  }
}
