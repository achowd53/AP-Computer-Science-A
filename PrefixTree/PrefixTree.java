/* Problem:
 * https://www.cs.princeton.edu/courses/archive/spring04/cos126/assignments/PrefixTree.html
 * Dependencies: StdIn.java
 * $ javac  PrefixTreeTree.java
 * $ java   PrefixTreeTree < abra.pre
 *
 * character   bits   encoding
 * ---------------------------
 *    a         1      0
 *    !         3      100
 *    d         4      1010
 *    c         4      1011
 *    r         3      110
 *    b         3      111
 *
 * abracadabra!
 * Number of bits       = 28
 * Number of characters = 12
 * Compression ratio    = 29.166666666666668%
*/

import java.util.ArrayList;
public class PrefixTree{

    private char character;
    private PrefixTree left;
    private PrefixTree right;

    // constructor
    // reads in the preorder traversal of a tree from standard input
    public PrefixTree(){
	     character = StdIn.readChar();
       if (character == '*') {
         left = new PrefixTree();
         right = new PrefixTree();
       }
    }

    public void preorder_helper(PrefixTree node, ArrayList arr, String path){
      if (node.character != '*') arr.add(node.character + "" + path);
      if (node.left != null) preorder_helper(node.left, arr, path + "0");
      if (node.right != null) preorder_helper(node.right, arr, path + "1");
    }
    public void preorder(){
	System.out.println("character  bits  encoding");
  System.out.println("-------------------------");
  ArrayList<String> arr = new ArrayList<String>();
  preorder_helper(this, arr, "");
  String charact = "";
  String encoding = "";
  for (String x : arr) System.out.printf("   %-6s   %-2s    %-7s\n", x.substring(0,1), x.length() - 1, x.substring(1));
    }

  public String uncompress_helper(PrefixTree node, String path) {
    if (node.character != '*') return node.character + "" + path;
    if (path.substring(0,1).equals("0")) return uncompress_helper(node.left, path.substring(1));
    else return uncompress_helper(node.right, path.substring(1));
  }
  public void uncompress(){
    String path = StdIn.readString();
    int bits = path.length();
    String message = "";
    String result_from_helper = "";
    while (path.length() != 0) {
      result_from_helper = uncompress_helper(this, path);
      message += result_from_helper.substring(0,1);
      path = result_from_helper.substring(1);
    }
    int characters = message.length();
    System.out.println(message);
    System.out.println("Number of bits       = " + bits);
    System.out.println("Number of characters = " + characters);
    System.out.println("Compression ratio    = " + bits*100.0/characters/8.0 + "%");

    }


    public static void main(String[] args){
	PrefixTree tree = new PrefixTree();
	tree.preorder();
  tree.uncompress();
    }


}
