/* Requires StdIn.java, StdOut.java , StdArrayIO.java
 * $ javac Stats.java
 * $ java Stats < smallData.txt
 * 10
 *   3     4     5     5     3     2    1     5    44     3
 * median: 3.5
 * mode: [3, 5]
 *
 * In the data file data : smallData.txt,
 * the first integer,n, is the size of the data set
 * followed by n integers.


 */



import java.util.Arrays;
import java.util.ArrayList;

public class Stats{

    // pre: a is not sorted
    // post: returns the median in O(nlogn) time.
    public static double median(int [] a){
	     Arrays.sort(a);
       int n = a.length;
       if (n%2==1) return a[n/2];
       else return a[n/2] / 2.0 + a[n/2 - 1] / 2.0;
    }

    // pre: a is not sorted
    // post: returns a list of the modes in O(nlogn) time.
    public static ArrayList<Integer> mode(int [] a){
  	   Arrays.sort(a);
       ArrayList<Integer> output = new ArrayList<Integer>();
       int max = 0;
       int current_value = a[0];
       int current_count = 0;
       for (int x : a) {
         if (current_value == x) current_count++;
         else {
           current_value = x;
           if (current_count > max) max = current_count;
           current_count = 1;
         }
       }
       current_value = a[0];
       current_count = 0;
       for (int x : a) {
         if (current_value == x) current_count++;
         else {
           if (current_count == max) output.add(current_value);
           current_value = x;
           current_count = 1;
         }
       }
      return output;
    }

    public static void main(String [] args){
	int [] a = StdArrayIO.readInt1D();
	int n = a.length;
	if (n < 100) StdArrayIO.print(a);
        double median = median(a);
	System.out.println("median: " + median);
	System.out.println("mode: " + mode(a));



    }




}
