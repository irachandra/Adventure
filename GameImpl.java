package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private Map map;
  private Player player;

  public GameImpl(Map map, Player player) {
    if (map == null | player == null) {
      throw new IllegalArgumentException();
    }
    this.map = map;
    this.player = player;
  }
  /** Getter method for the Player's current location as a Position object */
  public Position getPlayerPosition() {
    return (this.player).getPosition();
  }

  /** Getter method for the Player's name */
  public String getPlayerName() {
    return (this.player).getName();
  }

  /** Getter method for a cloned List of the the Items in the Player's Inventory */
  public List<Item> getPlayerItems() {
    return (this.player).getInventory().getItems();
  }

  /** Returns true if all items on the map have been collected by the player */
  public boolean getIsWinner() {
    if (player.getInventory().getNumItems() == map.getNumItems()) {
      return true;
    }
    return false;
  }

  /**
   * This method prints information about the Cell where the Player is currently located, according
   * to the following format:
   *
   * <p>First, print "Location: " followed by the Cell's name. For example, if the Cell is named
   * "Polk Place", then this should print: "Location: Polk Place"
   *
   * <p>Next, print the Cell's description on its own line. For example, a description of Polk Place
   * might be: "A beautiful park surrounded by college buildings and an old library. This is the
   * heart of UNC's campus."
   *
   * <p>Next, if the Cell has already been visited before, print the following text on a new line:
   * "You have already visited this location."
   *
   * <p>Next, if there is a chest in the Cell, print the following text on the next line of output:
   * "You found a chest! Type 'open' to see what's inside, or keep moving."
   *
   * <p>Finally, this method should formally mark the Cell "visited" by calling the Cell's visit()
   * method
   */
  public void printCellInfo() {
    System.out.println("Location: " + (map.getCell(getPlayerPosition())).getName());
    System.out.println((map.getCell(getPlayerPosition())).getDescription());
    if (map.getCell(getPlayerPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (map.getCell(getPlayerPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    map.getCell(getPlayerPosition()).visit();
  }

  /**
   * This method handles a user's interaction when they try to open a treasure chest at the current
   * location. If a chest exists in the current Cell, it should be opened and its contents
   * transferred to the Player's Inventory. Hint: Use the transferFrom() method.
   *
   * <p>If there is no chest at the current Cell, print: "No chest to open, sorry!"
   *
   * <p>If there is a chest at the current Cell, but it is empty, print: "The chest is empty."
   *
   * <p>If the chest is not empty, transfer the chest contents to the Player's Inventory and print:
   * "You collected these items: [list of chest items]"
   *
   * <p>Hint: If you correctly set up the toString() method in the ItemImpl class, you should be
   * able to print the whole inventory by simply printing the chest items list. For example
   * something like: System.out.println("You collected these items: " + chest.getItems());
   */
  public void openChest() {
    if (!(map.getCell(getPlayerPosition()).hasChest())) {
      System.out.println("No chest to open, sorry!");
    } else {
      if (map.getCell(getPlayerPosition()).getChest().isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println(
            "You collected these items: " + map.getCell(getPlayerPosition()).getChest().getItems());
        player.getInventory().transferFrom(map.getCell(getPlayerPosition()).getChest());
      }
    }
  }

  /**
   * Returns true if the player can indeed move in a specified direction. A player can only move in
   * a direction if there is a non-null cell in that direction and if the direction is within the
   * map grid bounds.
   */
  public boolean canMove(Direction direction) {
    Position position = new PositionImpl(player.getPosition().getX(), player.getPosition().getY());
    position = position.getNeighbor(direction);
    if (position.getX() >= map.getWidth()
        | position.getY() >= map.getHeight()
        | position.getX() < 0
        | position.getY() < 0) {
      return false;
    }
    Cell cell = map.getCell(position.getX(), position.getY());
    return cell != null;
  }

  /**
   * Attempts to move the player one unit in the indicated direction. If the player cannot be moved
   * in that direction (i.e., canMove() returns false), this method should instead print the
   * following String on its own line: "You can't go that way! Try another direction." If the move
   * operation was successful, then print the new cell's info to the console using the
   * printCellInfo() method.
   */
  public void move(Direction direction) {
    if (canMove(direction) == false) {
      System.out.println("You can't go that way! Try another direction.");
      return;
    }
    player.move(direction);
    printCellInfo();
  }
}
