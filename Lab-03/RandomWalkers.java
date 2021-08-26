/******************************************************************************
 *  Compilation:  javac RandomWalkers.java
 *  Execution:    java RandomWalkers StepCount ExperimentCount
 *  
 *  Determines the mean squared distance of the squared distances from the origin
 *  gathered from the different experiments of a random walker walking a number of steps.
 * 
 *
 ******************************************************************************/


public class RandomWalkers{

    public static void main(String [] args){
      int N = Integer.parseInt(args[0]);
      int T = Integer.parseInt(args[1]);
       int x = 0;
       int y = 0;
       double total = 0;
	int step = N;
      for (int i = 0; i < T; i++) {
	step = N;
	x = 0;
        y = 0;
      while (step-- > 0) {
        int random = (int) (Math.random() * 4 + 1);
        if (random == 1) x += 1;
        else if (random == 2) x -= 1;
        else if (random == 3) y += 1;
        else y -= 1;

        }

      total += Math.pow(x, 2) + Math.pow(y, 2);
    }
    System.out.println("mean squared distance = " + (total / T));
    }
    }

// java RandomWalkers 10 100000
// mean squared distance = 10.01774

// java RandomWalkers 100 100000
// mean squared distance = 100.28614

// java RandomWalkers 1000 100000
// mean squared distance = 998.30654

// As N increases, the mean squared distance grows at a nearly linear rate along with it as seen by the example inputs above.
