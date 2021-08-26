/******************************************************************************
 *  Compilation:  javac AnimatedHanoi.java
 *  Execution:    java AnimatedHanoi n
 *  Partners:     Arib Chowdhury, Vladislav Vostrikov, Brian Rabinowitz
 *
 *  Shows the solving of Hanoi’s Tower with n disks using the StdDraw library.
 *
 *  %  java AnimatedHanoi 3
 *  The following instructions are not printed but
 *  are the moves shown in the StdDraw window.
 *  0 right
 *  1 left
 *  0 right
 *  2 right
 *  0 right
 *  1 left
 *  0 right
 *
 *  % java AnimatedHanoi 4
 *  The following instructions are not printed but
 *  are the moves shown in the StdDraw window.
 *  0 left
 *  1 right
 *  0 left
 *  2 left
 *  0 left
 *  1 right
 *  0 left
 *  3 right
 *  0 left
 *  1 right
 *  0 left
 *  2 left
 *  0 left
 *  1 right
 *  0 left
 *
 ******************************************************************************/

public class AnimatedHanoi {

    // tells instructions whether to move a disk left or right
    // the left (if left is true) or right (if left is false)
    public static void hanoi(int n, boolean right, int[] stack1, int[] stack2, int[] stack3, double basex, double basey){
  		if (n==0) return;
  		hanoi(n-1,!right,stack1,stack2,stack3,basex,basey);
  		if (right) instructions(n, " right",stack1,stack2,stack3,basex,basey);
  		else instructions(n, " left",stack1,stack2,stack3,basex,basey);
  		hanoi(n-1,!right,stack1,stack2,stack3,basex,basey);
  	}
  	public static void hanoiVariant(int n, int[] stack1, int[] stack2, int[] stack3, double basex, double basey){
  		for (int i=1;i<2*n-1;i++) {
  			hanoi(i,i%2==0,stack1,stack2,stack3,basex,basey);
  		}
  		hanoi(2*n-1,(2*n-1)%2==1,stack1,stack2,stack3,basex,basey);
  		instructions(2*n, " right",stack1,stack2,stack3,basex,basey);
  		hanoi(2*n-1,(2*n-1)%2==1,stack1,stack2,stack3,basex,basey);
  		for (int i=1;i<2*n-1;i++) {
  			hanoi(2*n-1-i,(2*n-1-i)%2==0,stack1,stack2,stack3,basex,basey);
  		}
  	}

    public static void moves(int n, boolean left, int[] stack1, int[] stack2, int[] stack3, double basex, double basey) {
        if (n == 0) return;
        moves(n-1, !left ,stack1,stack2,stack3,basex,basey);
        if (left) instructions(n, " right",stack1,stack2,stack3,basex,basey);
        else      instructions(n,  " left",stack1,stack2,stack3,basex,basey);
        moves(n-1, !left ,stack1,stack2,stack3,basex,basey);
    }

    //Checks whether or not a term exists in an array
  public static boolean exists(int[] array, int term) {
    for (int x = 0; x < array.length; x++) if (array[x] == term) return true;
    return false;
  }

    //Finds the index of an array where the term is located
  public static int indexSearch(int[] array, int term) {
    for (int x = 0; x < array.length; x++) if (array[x] == term) return x;
    return -1;
  }

    //Finds where the earliest empty space, in this case 0, is in an array so that a disk can be placed there
  public static int emptyIndexSearch(int[] array) {
    for (int x = 0; x < array.length; x++) if (array[x] == 0) return x;
    return -1;
  }

    //Checks which stack contains the disk that is supposed to be moved
  //Then based on whether left or right is called, removes the disk from the original stack after finding the index its located at,
    //brings it upwards, moves it above the stack it is being moved to, then drops the disk back at the earliest empty space in the stack the disk is supposed to move to
  //It calls the draw function after moving the disk up, after moving it left or right, then after moving it down
  public static void instructions(int n, String direction, int[] stack1, int[] stack2, int[] stack3, double basex, double basey) {
    if (exists(stack1, n)) {
      stack1[stack1.length-1] = n;
            stack1[indexSearch(stack1, n)] = 0;
            draw(stack1, stack2, stack3, basex, basey);
            stack1[stack1.length-1] = 0;
            if (direction == " left") stack3[stack1.length-1] = n;
      if (direction == " right") stack2[stack1.length-1] = n;
            draw(stack1, stack2, stack3, basex, basey);
            if (direction == " left") stack3[stack1.length-1] = 0;
      if (direction == " right") stack2[stack1.length-1] = 0;
      if (direction == " left") stack3[emptyIndexSearch(stack3)] = n;
      if (direction == " right") stack2[emptyIndexSearch(stack2)] = n;
    }
    else if (exists(stack2, n)) {
            stack2[stack1.length-1] = n;
      stack2[indexSearch(stack2, n)] = 0;
            draw(stack1, stack2, stack3, basex, basey);
            stack2[stack1.length-1] = 0;
            if (direction == " left") stack1[stack1.length-1] = n;
      if (direction == " right") stack3[stack1.length-1] = n;
            draw(stack1, stack2, stack3, basex, basey);
            if (direction == " left") stack1[stack1.length-1] = 0;
      if (direction == " right") stack3[stack1.length-1] = 0;
      if (direction == " left") stack1[emptyIndexSearch(stack1)] = n;
      if (direction == " right") stack3[emptyIndexSearch(stack3)] = n;
    }
    else if (exists(stack3, n)) {
            stack3[stack1.length-1] = n;
      stack3[indexSearch(stack3, n)] = 0;
            draw(stack1, stack2, stack3, basex, basey);
            stack3[stack1.length-1] = 0;
            if (direction == " left") stack2[stack2.length-1] = n;
      if (direction == " right") stack1[stack1.length-1] = n;
            draw(stack1, stack2, stack3, basex, basey);
            if (direction == " left") stack2[stack1.length-1] = 0;
      if (direction == " right") stack1[stack1.length-1] = 0;
      if (direction == " left") stack2[emptyIndexSearch(stack2)] = n;
      if (direction == " right") stack1[emptyIndexSearch(stack1)] = n;
    }
   draw(stack1, stack2, stack3, basex, basey);
  }

    //Prints out hanoi's tower in StdDraw at its current state at the time of calling this function
  public static void draw(int[] stack1, int[] stack2, int[] stack3, double basex, double basey) {
    StdDraw.clear();
    StdDraw.enableDoubleBuffering();
    double stacky = basey/2;
    double stackx = 0;
    double shift = 0;
    for (int x : stack1) {
      if (x != 0) {
      stackx = basex * x;
      shift = (.33 - basex * x) / 2;
      StdDraw.filledRectangle(shift + stackx / 2, stacky, basex * x / 2, basey / 2);
        }
      stacky += basey;
    }
    stacky = basey/2;
    stackx = 0;
    shift = 0;
    for (int x : stack2) {
      if (x != 0) {
      stackx = basex * x;
      shift = (.33 - basex * x) / 2;
      StdDraw.filledRectangle(1.0 / 3 + shift + stackx / 2, stacky, basex * x / 2, basey / 2);
        }
      stacky += basey;
    }
    stacky = basey/2;
    stackx = 0;
    shift = 0;
    for (int x : stack3) {
      if (x != 0) {
      stackx = basex * x;
      shift = (.33 - basex * x) / 2;
      StdDraw.filledRectangle(2.0 / 3 + shift + stackx / 2, stacky, basex * x / 2, basey / 2);
        }
      stacky += basey;
    }
    StdDraw.pause(200); //Control Speed of Movement by lowering or increasing this
    StdDraw.show();
  }

    //Inputs in the number of disks for the tower
  //Defaults the three different stacks/towers of Hanoi to all disks being in the first tower, none in the others, and also defaults the other variables
  //Finally, prints out the base state of Hanoi’s tower then calls moves to start the moving of disks
    public static void main(String[] args) {
      int n = Integer.parseInt(args[0]);
      double basedisky = 1.0 / (2*n+1);
      double basediskx = 1.0 / 6 / n;
      int[] stack1 = new int[2*n+1];
      int z = 2*n + 1;
      for (int x = 0; x < n; x++) stack1[x] = (z = z - 2); //smaller disks later in list
      int[] stack2 = new int[2*n+1];
            stack1[n] = 0;
      int[] stack3 = new int[2*n+1];
      z = 2*n + 2;
      for (int x = 0; x < n; x++) stack3[x] = (z = z - 2);
      draw(stack1, stack2, stack3, basediskx, basedisky);
      hanoiVariant(n,stack1,stack2,stack3,basediskx,basedisky);
    }

}
