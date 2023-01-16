# Adventure

In this assignment, I designed and implemented a text-based, directional adventure video game that can be played in the console. The player will explore a two-dimensional, gridded map in search of treasures. The player will navigate through the world by entering keyword inputs such as "go north" or "go east" into the console. Each input will return a message based on what the player chose to do and their current surroundings. Some locations in the map will have "chests" containing items; the player can "open" a chest and take the items inside. The goal of the game is to find all the treasure in the map.

The environment that the player will navigate through is two-dimensional, so let's assume a 2D, integer Cartesian coordinate system. This means the player's current position on the map can be modeled by two integers representing their `x` and `y` location. The player should be able to move north (i.e. in the positive-`y` direction), south (i.e. in the negative-`y` direction), east (i.e. in the positive-`x` direction), and west (i.e. in the negative-`x` direction) through the environment.


* `Item` - An interface that represents an item in the game. The objective of the game is to search for and collect different items as the player navigates through the game environment. In a more complex game, there might be multiple implementations of `Item`, each having unique behavior within the game. For example, there might be `Furniture` items, `Weapon` items, `Clothing` items, `Tool` items, etc. To keep it simple, for this assignment we're just going to create one implementation of the `Item` interface: `ItemImpl`. The `ItemImpl` class will encapsulate a single instance field: a `String` to represent the name of the item.


* `Inventory` - An interface that represents a collection of `Items`. For this assignment, the `Player` object will have an `Inventory` to store the items that they have collected. As the player finds more items in the game, they will add the items to their inventory. Additionally, some locations on the map will contain "chests" that store items for the player to find. Each chest will be represented by an`Inventory` instance.


* `Position` - An interface that represents an `(x, y)` position in the environment. A `Position` object will simply encapsulate an `x` value and a `y` value. The environment we are creating for this game is a "grid", so all coordinate values must be integers. Double values are too slow and complicated anyway, what with their crazy rounding problems and all. ;-) Finally, note that `Position` objects *are intended to be immutable*! Review the lecture slides if you don't remember what this means.


* `Player` - An interface representing the player of the game. At all times, the player is located at a particular `Position` and has a personal `Inventory` full of the `Items` they have collected. Thus, this object will be an *aggregation* of these two objects.


* `Cell` - An interface representing *the contents* of an `(x, y)` location in the environment. Each accessible location in the environment will encapsulate a name and a description, so these will be `String` values stored in the `Cell` object. Some `Cells` will contain a chest (represented by the `Inventory` object). Ultimately, the game environment will be represented as a 2D array of `Cell` objects.


* `Map` - This interface encapsulates a two-dimensional array of `Cell` objects that represent the environment that the player will explore.


* `Game` - This interface represents *the composition of* a `Player` together with a `Map`, allowing the game to be played!


## Playing the Game

The starter code also includes the classes `MapUNC` and `Main`, which have been commented out. These can be used to play a short treasure hunting game that uses the UNC-CH campus as a map! Feel free to play it as is, make modifications, or create an entirely new game!

To play, open the `Main` class file and hit run.
