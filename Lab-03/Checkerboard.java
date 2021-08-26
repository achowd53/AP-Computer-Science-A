/******************************************************************************
 *  Compilation:  javac Checkerboard.java
 *  Execution:    java Checkerboard NumberOfAstericksPerRow
 *  
 *  Creates N by N astericks in a checkerboard pattern with spaces
 *
 *  % java Checkerboard 3
 *  * * *
 *   * * *
 *  * * *
 *
 *  
 *  % java Checkerboard 2
 *  * *
 *   * *
 *  
 *
 ******************************************************************************/

public class Checkerboard {
  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    for (int i = 1; i <= N; i++) {
      String x = "";
      for (int j = 1; j <= 2 * N; j++) {
        if (i % 2 == j % 2) {
          x += "*";
        }
        else {
          x += " ";
        }
      }
      System.out.println(x);
    }

  }
}
