/* How to compile:
 *  $ javac StrawStack.java  (requires StdIn.java)
 *  $ java StrawStack max < tobe.txt
 *  to be not that or be
 *
 * tobe.txt
 *  to be or not to - be - - that - - - is
 */


public class StrawStack{

    private String [] a;
    private int n = 0;     // index to place an item

    public StrawStack(int max){
	a = new String[max];
    }

    // O(1)
    public boolean isEmpty(){
	return n == 0;
    }

    //Problem 2
    public boolean isFull(){
  return n == a.length;
    }

    //Problem 3
    // O(1)
    public void push (String item){
  if (isFull()) throw new IllegalStateException("Stack is full");
	a[n++] = item;
    }

    //Problem 4
    public String peek(){
  if (isEmpty()) throw new IllegalStateException("Stack is empty");
  return a[n-1];
    }

    //O(1)
    public String pop(){
	return a[--n];
    }

    // O(1)
    public int size(){
	return n;
    }


    // test client
    public static void main(String [] args){
	int max = Integer.parseInt(args[0]);
	StrawStack stack = new StrawStack(max);
	while (!StdIn.isEmpty()){
	    String item = StdIn.readString();
	    if (item.equals("-"))
		System.out.print(stack.pop() + " ");
	    else
		stack.push(item);
	}
	System.out.println();
    }


}
