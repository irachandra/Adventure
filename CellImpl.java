package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private int x;
  private int y;
  private String name;
  private String description;
  private Inventory chest;
  private Position current;
  private boolean visited;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null | description == null) {
      throw new IllegalArgumentException();
    }
    this.x = x;
    this.y = y;
    this.current = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  /** Getter method for the cell's name */
  public String getName() {
    return this.name;
  }

  /** Getter method for the cell's description */
  public String getDescription() {
    return this.description;
  }

  /** Getter method for the position of the cell */
  public Position getPosition() {
    return this.current;
  }

  /** Getter method for the "chest" Inventory object stored at the cell */
  public Inventory getChest() {
    return this.chest;
  }

  /** Getter method which returns true if the cell has been visited */
  public boolean getIsVisited() {
    if (this.visited) {
      return true;
    } else {
      return false;
    }
  }

  /** Returns true if the cell has a chest */
  public boolean hasChest() {
    if (this.chest != null) {
      return true;
    } else {
      return false;
    }
  }

  // ********************************************************************************
  // SETTER METHODS

  // Note: The setName(), setDescription(), and setChest() methods should perform setter validation
  // and throw an IllegalArgumentException for incoming "null" values

  /** Setter method for changing the cell's name */
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  /** Setter method for changing the cell's description */
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException();
    }
    this.description = description;
  }

  /** Setter method for the "chest" Inventory object stored at the cell */
  public void setChest(Inventory chest) {
    this.chest = new InventoryImpl();
    chest = this.chest;
  }

  /** Marks that the cell has been visited */
  public void visit() {
    visited = true;
  }
}
