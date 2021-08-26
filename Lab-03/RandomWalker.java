/******************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker StepCount
 *  
 *  Simulates steps of a random walker, printing location after each step then printing
 *  the squared final distance from the origin.
 *
 *  % java RandomWalker 1
 *  (0, -1)
 *  squared distance = 1.0
 *  
 *  % java RandomWalker 2
 *  (0, -1)
 *  (0, 0)
 *  squared distance = 0.0
 *
 ******************************************************************************/


public class RandomWalker{

    public static void main(String [] args){
      int N = Integer.parseInt(args[0]);
       int x = 0;
       int y = 0;
      while (N-- > 0) {
        int random = (int) (Math.random() * 4 + 1);
        if (random == 1) x += 1;
        else if (random == 2) x -= 1;
        else if (random == 3) y += 1;
        else y -= 1;
      System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("squared distance = " + (Math.pow(x, 2) + Math.pow(y, 2)));
      }
    }
