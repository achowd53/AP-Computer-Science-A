import java.awt.Color;
public class Terrain3 {
  public static int[] array_combiner(int[] a, int[] b) {
    int[] c = new int[a.length+b.length];
    for (int x = 0; x < a.length; x++) c[x] = a[x];
    for (int x = a.length; x < a.length+b.length; x++) c[x] = b[x-a.length];
    return c;
  }
  public static int[] ldeterminer(int k, int n) {
    if (n == 0) {
      int[] k_placeholder = {k};
      return k_placeholder;
    }
    if (k == 1) k = 2;
    else k = 2*k - 1;
    int[] k_placeholder2 = {k};
    return array_combiner(ldeterminer(k, n-1),k_placeholder2);
  }
  public static double[][][] DefaultGrid(int k, int[] ld){
  double H = 2;
  StdDraw.setXscale(0,1);
  StdDraw.setYscale(0,1);
  int al = ld[0];
  double[][][] grid = new double[al+2][al+2][3]; //1 to n by 1 to n then each point has an x,y, and z value
  //default all values as y coords of points
  for (int y = 0; y < grid.length; y++) {
    for (int x = 0; x < grid.length; x++) {
      if (y == 0 || x == 0 || y == grid.length-1 || x == grid.length-1) grid[y][x][1] = 1.0 / 0;
      else {
        grid[y][x][0] = (1.0 / grid.length) * x - .5;
        grid[y][x][1] = (1.0 / grid.length) * y - .5;
        double temp = grid[y][x][0];
        grid[y][x][0] = .5 + temp * Math.cos(Math.toRadians(45)) - grid[y][x][1] * Math.sin(Math.toRadians(45));
        grid[y][x][1] = .5 + temp * Math.sin(Math.toRadians(45)) + grid[y][x][1] * Math.cos(Math.toRadians(45));

      }
    }
  }
return grid;
}

public static void GridConnection(double[][][] grid) {
  for (int y = 1; y < grid.length-2; y++) {
    for (int x = 1; x < grid.length-2; x++) {
      double[] xl = {grid[y][x][0], grid[y+1][x][0], grid[y+1][x+1][0], grid[y][x+1][0]};
      double[] yl = {grid[y][x][1], grid[y+1][x][1], grid[y+1][x+1][1], grid[y][x+1][1]};
      StdDraw.polygon(xl,yl);
    }
  }
}

public static double d(double var, double H) {
  return StdRandom.gaussian(0, Math.sqrt(var))*Math.pow(.5,H);
}
public static int mid(int a, int b) {
  return (a+b)/2;
}
public static void recSquare(double[][][] grid, int iteration, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, double H) {
  if (x2 - x1 == 1) return;
  //not actual x and y points but column and row of grid point
  double var = Math.sqrt(1/Math.pow(2,2*H*(iteration+1))); //replace (2) with H later
  double dc = d(var, H);
  double dt = d(var, H);
  double db = d(var, H);
  double dl = d(var, H);
  double dr = d(var, H);
  //top left corner rotating clockwise
  int[] tp = {mid(x1,x2), mid(y1,y2)};
  int[] rp = {mid(x2,x3), mid(y2,y3)};
  int[] bp = {mid(x3,x4), mid(y3,y4)};
  int[] lp = {mid(x4,x1), mid(y4,y1)};
  int[] cp = {mid(x1,x2), mid(y1,y4)};
  //stretching the points in y direction
  grid[cp[0]][cp[1]][1] += dc;
  grid[tp[0]][tp[1]][1] += dt;
  grid[bp[0]][bp[1]][1] += db;
  grid[lp[0]][lp[1]][1] += dl;
  grid[rp[0]][rp[1]][1] += dr;
  //points have been shifted in the z direction
  grid[tp[0]][tp[1]][2] = (grid[y1][x1][2] + grid[y2][x2][2]) / 2.0;
  grid[bp[0]][bp[1]][2] = (grid[y3][x3][2] + grid[y4][x4][2]) / 2.0;
  grid[lp[0]][lp[1]][2] = (grid[y4][x4][2] + grid[y1][x1][2]) / 2.0;
  grid[rp[0]][rp[1]][2] = (grid[y3][x3][2] + grid[y2][x2][2]) / 2.0;
  grid[cp[0]][cp[1]][2] = (grid[tp[0]][tp[1]][2] + grid[bp[0]][bp[1]][2] + grid[lp[0]][lp[1]][2] + grid[rp[0]][rp[1]][2]) / 4.0 + StdRandom.uniform();;
  //grid of points realligned for later iterations
  reallign(grid,x1,y1,cp[0],cp[1]);
  reallign(grid,tp[0],tp[1],rp[0],rp[1]);
  reallign(grid,lp[0],lp[1],bp[0],bp[1]);
  reallign(grid,cp[0],cp[1],x3,y3);
  //time to reiterate
  recSquare(grid,iteration+1,x1,y1,tp[0],tp[1],cp[0],cp[1],lp[0],lp[1], H);
  recSquare(grid,iteration+1,tp[0],tp[1],x2,y2,rp[0],rp[1],cp[0],cp[1], H);
  recSquare(grid,iteration+1,cp[0],cp[1],rp[0],rp[1],x3,y3,bp[0],bp[1], H);
  recSquare(grid,iteration+1,lp[0],lp[1],cp[0],cp[1],bp[0],bp[1],x4,y4, H);
}
//reminder to self y coord at top higher than bottom though value greater at top than bottom
public static void vallignment(double[][][] grid, int x, int ty, int by, double spacing) {
  for (int s = 1; s < ty - by; s++) grid[by+s][x][1] = grid[by][x][1] + spacing * s;
}
public static void hallignment(double[][][] grid, int y, int lx, int rx, double spacing) {
  for (int s = 1; s < rx - lx; s++) grid[y][lx+s][1] = grid[y][lx][1] + spacing * s;
}
public static void reallign(double[][][] grid, int tlx, int tly, int brx, int bry) {
  if (brx - tlx == 1) return;
  double spaces = tly - bry;
  double left_wall_spacing = (grid[tly][tlx][1] - grid[bry][tlx][1]) / spaces;
  double right_wall_spacing = (grid[tly][brx][1] - grid[bry][brx][1]) / spaces;
  vallignment(grid, tlx, tly, bry, left_wall_spacing);
  vallignment(grid, brx, tly, bry, right_wall_spacing);
  for (int rows = bry; rows < tly+1; rows++) {
    double horizontal_spacing =  (grid[rows][brx][1] - grid[rows][tlx][1]) / spaces;
    hallignment(grid, rows, tlx, brx, horizontal_spacing);
  }
}
//Wierd Options:
//Color On, 2, 7
//Color On, 2, 7
//Color off, 2, 7
//Color Off, 1.5, 7
public static void main(String[] args) {
  double H = Double.parseDouble(args[0]);
  int k = Integer.parseInt(args[1]) + 1;
  int[] ld = ldeterminer(1, k); //ignore first 2 values in this array
  double[][][] grid = DefaultGrid(k, ld);
  grid[1][ld[0]][2] = StdRandom.uniform();
  grid[ld[0]][ld[0]][2] = StdRandom.uniform();
  grid[ld[0]][1][2] = StdRandom.uniform();
  grid[1][1][2] = StdRandom.uniform();
  recSquare(grid,1,1,ld[0],ld[0],ld[0],ld[0],1,1,1, H);
  StdDraw.enableDoubleBuffering();
  GridConnection(grid);
  StdDraw.show();
}
}
