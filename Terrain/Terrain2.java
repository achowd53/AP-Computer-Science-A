public class Terrain2 {
  public static void main(String[] args) {
	double H = Double.parseDouble(args[0]);
	StdDraw.setXscale(0,2);
	StdDraw.setYscale(0,2);
	int k = Integer.parseInt(args[1]);
	Draw(.5,1,1,1.5,1.5,1,1,.5, H, k, 1);
  //Left then up then right then bottom
  }
  public static double d(double avg, double var, double H) {
    return StdRandom.gaussian(0, Math.sqrt(var))*Math.pow(.5,H);

  }
  public static double m(double c1, double c2) {return (c1+c2)/2;}
  public static double[] Draw(double x0,double y0,double x1,double y1, double x2, double y2, double x3, double y3, double H, int n, int x) {
    System.out.println("isBeingDrawn");
    if (n == 0) {
      System.out.println(x0 + " " + y0);
      System.out.println(x1 + " " + y1);
      System.out.println(x2 + " " + y2);
      System.out.println(x3 + " " + y3);
      System.out.println();
      StdDraw.setPenColor(StdDraw.GREEN);
      double[] lx = {x0,x1,x2,x3};
      double[] ly = {y0,y1,y2,y3};
      StdDraw.polygon(lx,ly);
      double [] points  = {x0,y0,x1,y1,x2,y2,x3,y3};
      return points;
    }
    double var = Math.sqrt(1/Math.pow(2,2*H*(x+1)));
    double x5 = m(m(x0,x1),m(x2,x3));
    double y5 = m(m(y0,y1),m(y2,y3));
    double avg = (y0 + y1 + y2 + y3 + y5) / 5;
    y0 += d(avg, var, H);
    y1 += d(avg, var, H);
    y2 += d(avg, var, H);
    y3 += d(avg, var, H);
    y5 += d(avg, var, H);
    double[] dontuse = {x0,y0,x1,y1,x2,y2,x3,y3};
    dontuse = Draw(m(x0,x3), m(y0,y3), x0, y0, m(x0,x1), m(y0,y1), x5, y5, H, n-1, x+1);
    double savex = dontuse[0];
    System.out.println("not broken yet");
    double savey = dontuse[1];
    dontuse = Draw(dontuse[6], dontuse[7], dontuse[4], dontuse[5], x1, y1, m(x1,x2), m(y1,y2), H, n-1, x+1);
    dontuse = Draw(m(x2,x3), m(y2,y3), dontuse[0], dontuse[1], dontuse[6], dontuse[7], x2, y2, H, n-1, x+1);
    dontuse = Draw(x3, y3, savex, savey, dontuse[2], dontuse[3], dontuse[0], dontuse[1], H, n-1, x+1);
    return dontuse;
  }
}
//Intialize A list of all vertices in the end product
//Displace every other vertice, then every 3 vertices
//Finally connect the dots
