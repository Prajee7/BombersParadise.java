import java.util.Random;
import java.util.Scanner;

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
