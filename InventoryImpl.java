package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private final ArrayList<Item> itemList;

  public InventoryImpl() {
    itemList = new ArrayList<Item>();
  }

  /** Returns true if the Inventory is empty */
  public boolean isEmpty() {
    if (itemList.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  /** Getter method for the number of Items currently stored in the inventory */
  public int getNumItems() {
    return itemList.size();
  }

  /** Getter method which returns a cloned list of the Items in the Inventory */
  public List<Item> getItems() {
    return new ArrayList<Item>(itemList);
  }

  /** Adds an Item to the Inventory */
  public void addItem(Item item) {
    itemList.add(item);
  }

  /** Removes an Item from the Inventory */
  public void removeItem(Item item) {
    (this.itemList).remove(item);
  }

  /** Clears the Inventory */
  public void clear() {
    this.itemList.clear();
  }

  /** Removes the Items from an "other" Inventory, and adds them into "this" Inventory */
  public void transferFrom(Inventory other) {
    ArrayList<Item> othercopy = (ArrayList<Item>) other.getItems();
    for (int i = 0; i < othercopy.size(); i++) {
      this.addItem(othercopy.get(i));
    }
    other.clear();
    othercopy.clear();
  }
}
