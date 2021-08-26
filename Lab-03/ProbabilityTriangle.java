/******************************************************************************
 *  Compilation:  javac ProbabilityTriangle.java
 *  Execution:    java ProbabilityTriangle NumberOfTrials
 *
 *  Prints "Final probability of triangle: 0.498848
 *  Final probability of triangle being obtuse: 0.5724609500288665" 
 *  where "0.498848" is replaced by the probability of x, y, and z forming a
 *  triangle based on data gathered from the trial and "0.5724609500288665" is 
 *  replaced by the probability of a resulting triangle from x, y, and z values
 *  being obtuse.
 *
 *  For the question involving what the probability was that x, y, and z would
 *  form the side lengths of a triangle, my answer was .5 or 50%.
 *
 *  For the question involving what the probability was that x, y, and z would 
 *  form the sides of a obtuse triangle given that they form the sides of a triangle
 *  is .57 or 57%.
 *
 ******************************************************************************/

public class ProbabilityTriangle{

    public static void main(String [] args){
	int trials = Integer.parseInt(args[0]);
	int hits = 0;
	int trial = 0;
	for(int i = 1; i <=  trials; i++){
	    double x = Math.random();
	    double y = Math.random();
	    double z = Math.random();
	    double max = Math.max(Math.max(x, y), z);
            double min = Math.min(Math.min(x, y), z);
            double mid = x + y + z - max - min;
	    boolean isTriangle = x + y > z && x + z > y && y + z > x; //isTriangle simply figures out whether x, y, and z form a triangle
	    if (isTriangle) {
		trial++; //trial is the number of times the values form a triangle, this number being the number of trials for the obtuse test and the number of successes for the triangle test
		boolean isObtuse = Math.pow(min, 2) + Math.pow(mid, 2) < Math.pow(max, 2); //isObtuse figures out if a formed triangle is obtuse
		if (isObtuse)
			hits++; //how many times a triangle is seen to be obtuse

}
	}
	System.out.println("Final probability of triangle: " + trial * 1.0 / trials);
	System.out.println("Final probability of triangle being obtuse: "  +  hits * 1.0 / trial);

    }

}
