/*Dependencies: Progression.java
 *
 * How to compile and run :
 * $ javac GeometricProgression.java
 * $ java GeometricProgression base start n
 *
 * Example runs:
 * $ java GeometricProgression 3 4 5
 * 4 12 36 108 324
 *
 * java GeometricProgression 10 10 10
 * 10 100 1000 10000 100000 1000000 10000000 100000000 1000000000 10000000000
 *
 * By Arib Chowdhury Pd.3 & Jason Chan Pd.8
 */



public class GeometricProgression extends Progression{

    // instance variables
    private long base;

    // Constructors
    // Constructs the progression: 1,2,4,8,16....
    public GeometricProgression(){
		// ***** YOUR CODE GOES HERE ******
        super();
        base = 2;
    }
    // Constructs the progression: 1,base, base*base, ...
    public GeometricProgression(long base){
		// ***** YOUR CODE GOES HERE ******
        super();
        this.base = base;
    }

    // Constructs the arithmetic progression with arbitrary start
    // and increment: start, start * b, start * base * base
    public GeometricProgression(long base, long start){
		// ***** YOUR CODE GOES HERE ******
        super(start);
        this.base = base;
    }

    @Override
    public void advance(){
		// ***** YOUR CODE GOES HERE ******
        this.current *= this.base;
    }


    public static void main(String [] args){
	long base = Long.parseLong(args[0]);
	long start = Long.parseLong(args[1]);
	int n = Integer.parseInt(args[2]);
	GeometricProgression a = new GeometricProgression(base,start);
	a.printProgression(n);

    }

}
