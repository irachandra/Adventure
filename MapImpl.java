package com.comp301.a02adventure;

public class MapImpl implements Map {
  private int width;
  private int height;
  private int numItems;
  private Cell[][] thecell;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 | height <= 0) {
      throw new IllegalArgumentException();
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    thecell = new CellImpl[width][height];
  }

  /** Getter method for the width of the map */
  public int getWidth() {
    return this.width;
  }

  /** Getter method for the height of the map */
  public int getHeight() {
    return this.height;
  }

  /**
   * Getter method for a specific cell on the map. Throws an IndexOutOfBoundsException for
   * coordinate parameters that are not on the map
   */
  public Cell getCell(int x, int y) {
    if (x >= width | y >= height | x < 0 | y < 0) {
      throw new IndexOutOfBoundsException();
    }
    return thecell[x][y];
  }

  /**
   * Overloaded getter method for a specific cell on the map. Throws an IndexOutOfBoundsException
   * for coordinate parameters that are not on the map
   */
  public Cell getCell(Position position) {
    if (position.getX() >= width | position.getX() >= height) {
      throw new IndexOutOfBoundsException();
    }
    return thecell[position.getX()][position.getY()];
  }

  /**
   * Initializes a new CellImpl object at the specified location on the map, overwriting any
   * existing Cell at that location. Throws an IndexOutOfBoundsException for coordinate parameters
   * that are not on the map
   */
  public void initCell(int x, int y) {
    if (x >= width | y >= height) {
      throw new IllegalArgumentException();
    } else {
      thecell[x][y] = new CellImpl(x, y);
    }
  }

  /**
   * Getter method for the total number of items that need to be collected in order for the player
   * to win. This field is immutable.
   */
  public final int getNumItems() {
    return numItems;
  }
}
