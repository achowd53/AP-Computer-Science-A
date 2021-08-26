/******************************************************************************
 *  Compilation:  javac SelectionSortTester.java
 *  Execution: java SelectionSortTester
 *  Dependencies: StdIn.java
 *
 *  Includes methods for testing if an array is sorted in ascending order,
 *  sortiing an array in ascending order, finding the number of integers with
 *  duplicates in a sorted array, finding the number of integers with duplicates
 *  in an unsorted array and printing the number of duplicates
 *  in an array where the minimum value is 0 and the maximum value is 100.
 *
 *  Given user input of SIZE, creates an array of random integers of size SIZE,
 *  and prints if it is sorted and the number od duplicates in it. Then sorts
 *  it twice, printing execution time for both, and prints whether or not it is
 *  sorted in ascending order afterwards, once again also printing the number of
 *  duplicates.
 *
 * $ java SelectionSortTester
 * size of the array -->50000
 * Before:NOT sorted
 * Number of Duplicates: 1
 * Total execution time: 1498
 * Total execution time: 1411
 * After:SORTED
 * Number of Duplicates: 1
 *
 ******************************************************************************/

public class SelectionSortTester
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

 //Counts the number of integers with duplicates in a sorted array by counting the number of pairs with equal values
 public static int countDuplicatesSorted ( int[] array)
 {
    int duplicates = 0;
    String checked = "";
    for ( int j=0; j<array.length-1; j++ )
    {
      if (checked.indexOf(array[j] + "") != -1) continue;
      if (array[j] == array[j+1]) {
        checked += array[j] + " ";
        duplicates++;
      }
    }
    return duplicates;
 }

 //Counts the number of integers with duplicates in an unsorted array by checking for each value in the array, all previous values to see if they are a duplicate
 public static int countDuplicatesUnsorted (int[] array) {
    int duplicates = 0;
    String checked = "";
    for ( int j=1; j<array.length; j++ )
    {
      if (checked.indexOf(""+array[j]) != -1) continue;
      for ( int i = 0; i<j; i++ )
      {
        if (array[i] == array[j])
        {
          duplicates++;
          checked += array[j] + " ";
          break;
        }
      }
    }
    return duplicates;
 }

 //Prints all values that have duplicates in an unsorted array where the minimum value is 0 and the maximum is 100
 public static void printDuplicatesUnsortedRange0To100 (int[] array) {
   //If there are below 101 values, the following method is used
   if (array.length < 101)
   {
     String seen = "";
     String results = "";
     for ( int j=0; j<array.length; j++ )
     {
       //The first time a value is seen, it is added to the String seen
       if (seen.indexOf(""+array[j]) == -1) seen += array[j] + " ";
       else
       {
         //The next time a value is seen, they are added to results where results will not have the same value twice
         if (results.indexOf(""+array[j]) == -1) results += array[j] + " ";
       }
     }
     System.out.print("Integers appearing as duplicates are: ");
     //All values in results are duplicates in the array so they are printed
     for (int i = 0; i < results.length(); i++)
     {
       seen = "";
       while (results.charAt(i) != ' ')
       {
         seen += results.charAt(i);
         i++;
       }
       System.out.print(seen + ", ");
     }
     System.out.println();
   }
   //If there are over 101 values in the array, the following method is used
   else
   {
     //For each value, array[j], setting the value at index array[j] up by 1000 if its below 2000
     //Essentially just checking how many times a value was seen but marking the number of times only up to 2
     for ( int j=0; j<array.length; j++ )
     {
       if (array[array[j]%1000] < 2000) array[array[j]%1000] += 1000;
     }
     System.out.print("Integers appearing as duplicates are: ");
     //Print out every index which was seen as a value atleast twice
     for (int j = 0; j<101; j++)
     {
       if (array[j] >= 2000) System.out.print(j + ", ");
       array[j] %= 1000;
     }
     System.out.println();
   }
 }

  // Sort the Array
  //
  public static void selectionSort( int[] array )
  {

    // Find the integer that should go in each cell j of
    // the array, from cell 0 to the end
    for ( int j=0; j<array.length-1; j++ )
    {
      // Find min: the index of the integer that should go into cell j.
      // Look through the unsorted integers (those at j or higher)
      int min = j;
      for ( int k=j+1; k<array.length; k++ )
        if ( array[k] < array[min] ) min = k;

      // Swap the int at j with the int at min
      int temp = array[j];
      array[j] = array[min];
      array[min] = temp;
    }

  }

  public static void main ( String[] args )
  {
    //User input for array size
    System.out.print("size of the array -->");
    int SIZE = StdIn.readInt();
    int[] values = new int[SIZE];

    //Creates an array of size SIZE with random values
    for (int i = 0; i < SIZE; i++) {
      values[i] = Integer.MIN_VALUE + (int)(Math.random() * (((double) Integer.MAX_VALUE - Integer.MIN_VALUE) + 1));
    }
    //Tests if array is sorted to start off with
    if (isSorted(values)) System.out.println("Before:SORTED");
    else System.out.println("Before:NOT sorted");

    //Counts duplicates in unsorted array
    System.out.println("Number of Duplicates: " + countDuplicatesUnsorted(values));

    //Starts time
    long startTime = System.currentTimeMillis();

    // sort the array
    selectionSort( values );

    //Ends Time and prints execution time
    long endTime = System.currentTimeMillis();
    System.out.println("Total execution time: " + (endTime - startTime) );

    //Starts time
    startTime = System.currentTimeMillis();

    // sort the array again
    selectionSort( values );

    //Ends time and prints execution time which should be less than the previous execution time as array[k] will never be less than array[min]
    endTime = System.currentTimeMillis();
    System.out.println("Total execution time: " + (endTime - startTime) );

    //Tests if array is sorted in ascending order
    if (isSorted(values)) System.out.println("After:SORTED");
    else System.out.println("After:NOT sorted");

    //Counts duplicates in a sorted array
    System.out.println("Number of Duplicates: " + countDuplicatesSorted(values));
   }
}
