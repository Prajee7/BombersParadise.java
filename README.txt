Welcome to Bomber Paradise:

The controls to play this game includes 
W to move up
S to move down
D to move right
E to move left

From the title you can probably tell what the game is about, you need to survive and not go next to the bombs. 
Avoid them at all costs do not go close to them!

You start @ Index [0,0] and you need to reach the bottom right corner [9, 9]
The catch though is that you need to stay at least 1 box away from the bombs or you BLOW up and you LOSE.

Get to the End and you WIN

There are 3 Modes to this game:

1. Medium
2. Hard 
3. Impossible

This game is based on luck as well as skill, sometimes you are given a horrible board other times you are given easy boards!

I wish you luck and use you skills to beat the game!







Code includes: 8 Out of 9 Completed

Functional Decomposition
Looping with Repetition Control Structures
Nested Loops
Branching with Selection Control Structures
Using Multiple Classes
One-dimensional arrays
Class Design using Access Modifiers
Multi-Dimensional Arrays

CODE:

Main.java

/**
 * Bomber Paradise Main Class
 * Run this class to start the game
 * @Prajeet Pounraj
 * 12/5/21
 */
public class Main {
  public static void main(String[] main) {
    System.out.println("Welcome to Bomber Paradise");
    System.out.println("Don't get BLOWN away");

    MazeControl obj = new MazeControl();

    // Player: (AKA The Maze Runner)
    obj.getDifficulty();
    obj.printMaze();

    while (!obj.win()) {
      obj.move();
      if(obj.checkForBomb()) {
        System.out.println("You got blown up! You LOST.");
        System.out.println("Well Played tho!");
        System.exit(0);
      }
    }

  } //end of main 
  
} // end of class


SetBomb.java

/**
 * Bomber Paradise SetBomb class
 * This class sets the number of bombs in the game
 * @Prajeet Pounraj
 * 12/5/21
 */

public class SetBomb {
  int numberOfBombs;
  int dif;

  SetBomb() {
    dif = 0;
    numberOfBombs = 0;
  }

  int getNumberOfBombs() {
    return numberOfBombs;
  }

  // takes the user input for difficulty and calls a method to set the bombs
  void difficulty() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Choose a difficulty: 1 2 3");
    dif = scan.nextInt();
    setNumberOfBombs();
  }
  
  // uses Random object to return a random index in which the bomb is set to in maze[][]
  int rngBomb() {
      Random rng = new Random();
      int x = rng.nextInt(numberOfBombs);
      while(x > 9) {
        x = rng.nextInt(10);
      }
      return x;
  }
  
  // sets the number of bombs on the field
  void setNumberOfBombs() {
    if (dif == 1) {
      numberOfBombs = 5;
      System.out.println("works");
    }
    if (dif == 2) {
      numberOfBombs = 10;
    }
    if (dif == 3) {
      numberOfBombs = 15;
    }
  }

}


MazeControl.java

/**
 * Bomber Paradise Maze Class
 * This class controls everything from 
 * creation of the maze to editing maze to 
 * checking for rules
 * @Prajeet Pounraj
 * 12/5/21
 */

public class MazeControl {
  private int xLocation;
  private int yLocation;
  private String direction;
  private String[][] maze;
  private SetBomb bomb;

  MazeControl() {
    bomb = new SetBomb();
    xLocation = 0;
    yLocation = 0;
    maze = new String[10][10];
    maze[0][0] = "o";
  }

  // returns current x-axis location
  int getXLocation() {
    return xLocation;
  }

  // returns current y-axis location
  int getYLocation() {
    return yLocation;
  }

  // called from main which calls a method from SetBomb
  void getDifficulty() {
    bomb.difficulty();
    setBombs();
  }

  // uses a method from SetBomb to randomly disperse the bombs in the maze array
  void setBombs() {
    int x, y;
    int count = bomb.getNumberOfBombs();
    while (count != 0) {
      x = bomb.rngBomb();
      y = bomb.rngBomb();
      while (x == 0 && y == 0 || x == 9 && y == 9) {
        x = bomb.rngBomb();
        y = bomb.rngBomb();
      }
      maze[x][y] = "@";
      count--;
    }
  }

  // retunrs the side the current location is moving
  String getDirection() {
    return direction;
  }

  // this method checks to see if the bomb is close by and if not it lets
  // the character move ahead.
  String currentLocation() {
    if ((0 < getXLocation() && getXLocation() < 9) && (0 < getYLocation() && getYLocation() < 9)) {
      if (maze[getXLocation() + 1][getYLocation()] == "@") {
        return maze[getXLocation()][getYLocation()] = "X";
      } else if (maze[getXLocation() - 1][getYLocation()] == "@") {
        return maze[getXLocation()][getYLocation()] = "X";
      }
      if (maze[getXLocation()][getYLocation() + 1] == "@") {
        return maze[getXLocation()][getYLocation()] = "X";
      } else if (maze[getXLocation()][getYLocation() - 1] == "@") {
        return maze[getXLocation()][getYLocation()] = "X";
      }
    }
      return maze[getXLocation()][getYLocation()] = "o";
  }

  // prints the actual maze and calls another method to reflect the frame
  void printMaze() {
    // setBXY();
    for (int i = 0; i < maze[0].length; i++) {
      System.out.print("|");
      for (int j = 0; j < maze[i].length; j++) {
        updateScreen(i, j);
      }
      System.out.println();
    }
  }

  // this method prints the frame of the maze, the bombs and the current location
  void updateScreen(int i, int j) {
    if (i == getXLocation() && j == getYLocation()) {
      System.out.print(maze[i][j]);
      System.out.print("|");
    } else if (maze[i][j] == "@") {
      System.out.print(maze[i][j]);
      System.out.print("|");
    } else {
      System.out.print("_|");
    }
    currentLocation();
  }

  // checks to see if the player made it to the end
  boolean win() {
    if (maze[9][9] == "o") {
      System.out.println("Good Job! You escaped the Bombs!");
      return true;
    }
    return false;
  }
  
  // changes the players circle to X from o when the game is ended
  boolean checkForBomb() {
    if (maze[getXLocation()][getYLocation()] == "X") {
      return true;
    }
    return false;
  }

  // Asks the user which way to move
  public void move() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Choose the direction you want to move: (W - up, D - right, A - left, S - down)");
    direction = scan.next();

    while (direction.length() > 1) {
      System.out.println("Invalid output");
      direction = scan.next();
    }

    setLocation(direction);
  }

  // this method calls printmaze and checks if the move the player did was legal
  void setLocation(String direction) {
    if (direction.equalsIgnoreCase("s")) {
      if (xLocation == 9) {
        System.out.println("Cannot move in that direction");
        move();
      } else {
        xLocation += 1;
      }
    } else if (direction.equalsIgnoreCase("w")) {
      if (xLocation == 0) {
        System.out.println("Cannot move in that direction");
        move();
      } else {
        xLocation -= 1;
      }
    }
    if (direction.equalsIgnoreCase("d")) {
      if (yLocation == 9) {
        System.out.println("Cannot move in that direction");
        move();
      } else {
        yLocation += 1;
      }
    } else if (direction.equalsIgnoreCase("a")) {
      if (yLocation == 0) {
        System.out.println("Cannot move in that direction");
        move();
      } else {
        yLocation -= 1;
      }
    }
    System.out.println("[" + xLocation + " " + yLocation + "]");
    printMaze();
  }

}

