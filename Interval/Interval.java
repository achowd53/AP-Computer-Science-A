/******************************************************************************
 *  Compilation:  javac Interval.java
 *  Execution:    N/A
 *  Dependencies: None
 *
 *  Allows for representation of an interval from a left number to a right number
 *  in the form of an Interval object.
 *
 * By Arib Chowdhury (Pd. 3)
 ******************************************************************************/

 public class Interval {
  private double left_value;
  private double right_value;
  //Constructs an interval with the parameters of the start value and end value of the interval
  public Interval(double left, double right) {
    if (left > right) throw new IllegalArgumentException("The left value can't be greater than the right");
    left_value = left;
    right_value = right;
  }
  //is x in this interval?
  public boolean contains(double x) {
    return left_value <= x && x <= right_value;
  }
  //does this interval and b intersect?
  public boolean intersects(Interval b) {
    return Math.max(left_value, b.left_value) <= Math.min(right_value, b.right_value);
  }
  //string representation ex. [2.1,3.4]
  public String toString() {
    return "["+left_value+","+right_value+"]";
  }
}
