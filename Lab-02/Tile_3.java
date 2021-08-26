/******************************************************************************
 * Partners: Arib Chowdhury and Vladislav Vostrikov
 *
 *  Compilation:  javac Tile_3.java
 *  Execution:    java Tile_3
 *  Dependencies: StdDraw.java
 *
 *  Creates a specific tile pattern using StdDraw
 *
 *  % java Tile_3
 *
 ******************************************************************************/

public class Tile_3 {
    public static void main(String[] args) {
      double[] k = {0,0,1,1};
      double[] l = {0,1,1,0};
      StdDraw.filledPolygon(k,l);
      //The above makes a black background
      StdDraw.setPenColor(StdDraw.GRAY);
      double[] a = {0,.5,1,.5};
      double[] b = {.5,0,.5,1};
      StdDraw.filledPolygon(a,b);
      //The above makes a gray rhombus
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.filledSquare(.125,.125,.125);
      StdDraw.filledSquare(.125,.875,.125);
      StdDraw.filledSquare(.875,.125,.125);
      StdDraw.filledSquare(.875,.875,.125);
      //The above makes 4 white squares in the corners


}
}
