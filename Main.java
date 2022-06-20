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
