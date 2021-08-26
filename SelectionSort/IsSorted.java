/******************************************************************************
 *  Compilation:  javac IsSorted.java
 *  Execution: java IsSorted
 *  Dependencies: None
 *
 *  Includes method for checking if an array is sorted in ascending order, the
 *  number of pairs of values that are not in ascending order and the overall
 *  percentage of the array sorted
 *
 * $ java IsSorted
 * values:
 * 12, 23, -5, 56, 32, 17, -4, -49, -1, -23, 45,
 * Is NOT in order
 * There are 6 pairs that are out of order
 * The array is 40.0 percent sorted
 *
 ******************************************************************************/

public class IsSorted
{
  public static boolean isSorted( int[] array )
 {
   boolean inOrder = true;

   // scan the list starting at index 0
   for ( int j=0; j<array.length-1 && inOrder; j++ )
   {
     // check the pair starting at j
     inOrder = array[j] <= array[j+1];
   }

   return inOrder;
 }

 //Returns the number of pairs in the array that are not in ascending order
 public static int countOut( int[] array )
 {
   int outOfOrder = 0;
   for ( int j=0; j<array.length-1; j++ )
   {
     if (array[j] > array[j+1]) outOfOrder++;
   }
   return outOfOrder;
 }

//Returns the percentage of the array sorted as the number of pairs that are correctly sorted divided by the total number of pairs
public static double percentSorted( int[] array )
{
  return (array.length - 1 - countOut(array)) * 100 / (array.length-1);
}

public static void main ( String[] args )
{
  int[] values = {12, 23, -5, 56, 32, 17, -4, -49, -1, -23, 45 };

  // print out the array
  System.out.println("values: ");
  for ( int val : values )
    System.out.print( val + ", " );

  System.out.println( );

  // determine if it is in order
  if ( isSorted(values) )
    System.out.println( "Is in order" );
  else
    System.out.println( "Is NOT in order" );

  System.out.println("There are " + countOut(values) + " pairs that are out of order");
  System.out.println("The array is " + percentSorted(values) + " percent sorted");

 }
}
