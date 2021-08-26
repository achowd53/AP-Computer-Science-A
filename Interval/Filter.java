/******************************************************************************
 *  Compilation:  javac Filter.java
 *  Execution:    java Filter x filename
 *  Dependencies: In.java, Interval.java
 *
 *  Tests each interval in filename and outputs each interval that contains x
 *  and then each interval that intersects the interval [-x,x]
 *
 *
 * Given the file : intervals.txt
 *   1.0  3.0
 *   -2.0  5.0
 *   2.1  9.0
 *   11.2  20.8
 *  -1.4  2.00001
 *   7.28  52.23
 *  -1.0  -1.5
 *   44.0  81.0
 *   19.5  19.6
 *   0.45  0.48
 *
 * $ java Filter 3 intervals.txt
 *   Testing contains
 *   [1.0,3.0] contains 3.0
 *   [-2.0,5.0] contains 3.0
 *   [2.1,9.0] contains 3.0
 *
 *   Testing intersects
 *   [1.0,3.0] intersects  [-3.0,3.0]
 *   [-2.0,5.0] intersects  [-3.0,3.0]
 *   [2.1,9.0] intersects  [-3.0,3.0]
 *   [-1.4,2.00001] intersects  [-3.0,3.0]
 *   [-1.0,-1.5] intersects  [-3.0,3.0]
 *   [0.45,0.48] intersects  [-3.0,3.0]
 *
 * By Arib Chowdhury (Pd. 3)
 ******************************************************************************/

//Reads intervals from a given file and goes through them printing all intervals that contain x and all intervals that intersect [-x,x]
public class Filter {
  public static void main(String[] args) {
    int x = Integer.parseInt(args[0]);
    In input = new In(args[1]);
    double[] intervals = input.readAllDoubles();
    System.out.println("Testing Contains");
    for (int i = 0; i < intervals.length-1; i+=2) {
      Interval cont = new Interval(intervals[i], intervals[i+1]);
      if (cont.contains(x)) System.out.println(cont + " contains " + x);
    }
    System.out.println();
    System.out.println("Testing Intersects");
    Interval interval_x = new Interval(-1 * Math.abs(x), Math.abs(x));
    for (int i = 0; i < intervals.length-1; i+=2) {
      Interval inter = new Interval(intervals[i], intervals[i+1]);
      if (inter.intersects(interval_x)) System.out.println(inter + " intersects " + interval_x);
    }
  }
}
