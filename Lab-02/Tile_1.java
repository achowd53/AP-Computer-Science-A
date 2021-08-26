/******************************************************************************
 * Partners: Arib Chowdhury and Vladislav Vostrikov
 *
 *  Compilation:  javac Tile_1.java
 *  Execution:    java Tile_1
 *  Dependencies: StdDraw.java
 *
 *  Creates a specific tile pattern using StdDraw
 *
 *  % java Tile_1
 *
 ******************************************************************************/

public class Tile_1 {
    public static void main(String[] args) {
      double[] k = {0,0,1,1};
      double[] l = {0,1,1,0};
      StdDraw.filledPolygon(k,l);
      //The above prints a black background
      StdDraw.setPenColor(StdDraw.GRAY);
      double[] a = {0,.5,1,.5};
      double[] b = {.5,0,.5,1};
      StdDraw.filledPolygon(a,b);
      //The above prints a gray rhombus in the center
      StdDraw.setPenColor(StdDraw.WHITE);
      double[] c = {0,.25,.25};
      double[] d = {.75,.75,1};
      StdDraw.filledPolygon(c,d);
      double[] e = {0,.25,.25};
      double[] f = {.25,0,.25};
      StdDraw.filledPolygon(e,f);
      double[] g = {.75,.75,1};
      double[] h = {.75,1,.75};
      StdDraw.filledPolygon(g,h);
      double[] i = {.75,.75,1};
      double[] j = {.25,0,.25};
      StdDraw.filledPolygon(i,j);
      //The above prints a white triangle in each corner
}
}
