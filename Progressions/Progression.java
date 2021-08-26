/*Dependencies: Progression.java
 *
 * $ javac Progression.java
 * $ java Progression start n
 *
 * example run:
 * $ java Progression 3 4
 *   3 4 5 6
 * $ java Progression -1 10
 *   -1 0 1 2 3 4 5 6 7 8
 *
 * By Arib Chowdhury Pd.3 & Jason Chan Pd.8
*/



public class Progression{

    // instance variables
    protected long current;

    // constructors
    public Progression(){
		this(0);
    }

    public Progression(long start){
	// ***** YOUR CODE GOES HERE ******
    	current = start;
    }

    // Mutator Methods
    // returns the next value in the progression
    public long nextValue() {
	// ***** YOUR CODE GOES HERE ******
    long x = this.current;
    advance();
    return x;
    }

    // advances the current value to the next
    public void advance(){
	// ***** YOUR CODE GOES HERE ******
    	this.current = this.current + 1;
    }

    // value of the progression
    // prints the next n values
    // of the progression
    public void printProgression(int n){
	// ***** YOUR CODE GOES HERE ******
    	for (int i = 0; i < n; i++) System.out.print(nextValue() + " ");
      System.out.println();
    }

    public static void main(String [] args){
	int start = Integer.parseInt(args[0]);
	int n = Integer.parseInt(args[1]);
	Progression p = new Progression(start);
	p.printProgression(n);

    }


}
