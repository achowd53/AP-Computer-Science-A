/******************************************************************************
 * Partners: Arib Chowdhury and Vladislav Vostrikov
 *
 *  Compilation:  javac Tile_4.java
 *  Execution:    java Tile_4
 *  Dependencies: StdDraw.java
 *
 *  Creates a specific tile pattern using StdDraw
 *
 *  % java Tile_4
 *
 ******************************************************************************/

public class Tile_4 {
    public static void main(String[] args) {
      double[] k = {0,0,1,1};
      double[] l = {0,1,1,0};
      StdDraw.filledPolygon(k,l);
      //The above makes a black background
      StdDraw.setPenColor(StdDraw.GRAY);
      double[] a = {0,.5,1,.5};
      double[] b = {.5,0,.5,1};
      StdDraw.filledPolygon(a,b);
      //The above makes the gray rhombus
      StdDraw.setPenColor(StdDraw.WHITE);
      double[] c = {.875,1,.75,.625};
      double[] d = {.625,.75,1,.875};
      StdDraw.filledPolygon(c,d);
      double[] e = {.875,1,.75,.625};
      double[] f = {.375,.25,0,.125};
      StdDraw.filledPolygon(e,f);
      double[] g = {.125,0,.25,.375};
      double[] h = {.625,.75,1,.875};
      StdDraw.filledPolygon(g,h);
      double[] i = {.125,0,.25,.375};
      double[] j = {.375,.25,0,.125};
      StdDraw.filledPolygon(i,j);
      //The above makes 4 white rectangles in the corners
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.filledSquare(.125,.125,.125);
      StdDraw.filledSquare(.125,.875,.125);
      StdDraw.filledSquare(.875,.125,.125);
      StdDraw.filledSquare(.875,.875,.125);
      //The above makes 4 gray squares in the corners


}
}
