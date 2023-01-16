package com.comp301.a02adventure;

import java.util.Objects;

public final class ItemImpl implements Item {
  private String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    } else {
      this.name = name;
    }
  }

  /** Getter method to retrieve the name of the Item */
  public String getName() {
    return name;
  }

  /**
   * Every class in Java is a descendant of a built-in superclass, called "Object". The Object
   * superclass defines a few useful methods for every Java object, like equals() and toString().
   * Since Object is the superclass to every class, that means every Java object has these methods.
   * Programmers can override them, if necessary, to supply a subclass-specific version of the
   * method. Every Item class should override both equals() and toString().
   *
   * <p>The equals() method tests to see if the "this" object is the same as the "other" object,
   * returning true if they are the same, or false if they are not. For this method, assume two
   * Items are the same if they have the same "name" String.
   */
  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (other != (ItemImpl) other) {
      return false;
    }
    if (!((this.getName()).equals(((ItemImpl) other).getName()))) {
      return false;
    }
    return true;
  }

  /**
   * Every class in Java is a descendant of a built-in superclass, called "Object". The Object
   * superclass defines a few useful methods for every Java object, like equals() and toString().
   * Since Object is the superclass to every class, that means every Java object has these methods.
   * Programmers can override them, if necessary, to supply a subclass-specific version of the
   * method. Every Item class should override both equals() and toString().
   *
   * <p>The toString() method generates a human-readable, String representation of the object,
   * suitable for printing to the console either for debugging or for the eventual user to read. For
   * this method, assume the "string representation" of an Item is simply the item's name String.
   */
  @Override
  public String toString() {
    return this.name;
  }
}
