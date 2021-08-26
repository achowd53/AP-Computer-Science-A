/*Dependencies: Progression.java
 *
 * How to compile and run :
 * $ javac ArithmeticProgression.java
 * $ java ArithmeticProgression increment start n
 *
 * Example runs:
 * $ java ArithmeticProgression 2 0 5
 * 0 2 4 6 8
 *
 * $ java ArithmeticProgression 3 1 10
 * 1 4 7 10 13 16 19 22 25 28
 *
 * By Arib Chowdhury Pd.3 & Jason Chan Pd.8
 */

public class ArithmeticProgression extends Progression{

    // instance variables
    private long increment;

    // Constructors
    // Constructs the progression: 0,1,2,....
    public ArithmeticProgression(){
		// ***** YOUR CODE GOES HERE ******
    current = 0;
    increment = 1;
    }
    // Constructs the progression: 0,1*increment, 2*increment, ...
    public ArithmeticProgression(long increment){
		// ***** YOUR CODE GOES HERE ******
    this.increment = increment;
    current = 0;
    }

    // Constructs the arithmetic progression with arbitrary start
    // and increment: start, start + increment, start + 2*increment
    public ArithmeticProgression(long increment, long start){
	     super(start);
	     this.increment = increment;
    }

    @Override
    public void advance(){
		// ***** YOUR CODE GOES HERE ******
    current += increment;
    }


    public static void main(String [] args){
	long increment = Long.parseLong(args[0]);
	long start = Long.parseLong(args[1]);
	int n = Integer.parseInt(args[2]);
	ArithmeticProgression a = new ArithmeticProgression(increment,start);
	a.printProgression(n);

    }

}
