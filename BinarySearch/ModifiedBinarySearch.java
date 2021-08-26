/******************************************************************************
 *  Compilation:  javac ModifiedBinarySearch.java
 *  Execution:    java ModifiedBinarySearch wordlist.txt < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/java/42sort/emails.txt
 *                https://introcs.cs.princeton.edu/java/42sort/whitelist.txt
 *
 *  Read in an alphabetical list of words from the given file.
 *  Then prompt the user to enter words. The program reports which
 *  words are *not* in the wordlist.
 *
 *  % java ModifiedBinarySearch whitelist.txt < emails.txt
 *  Done reading words
 *  Done sorting words
 *  marvin@spam
 *  mallory@spam
 *  eve@airport
 *
 ******************************************************************************/

import java.util.Arrays;

public class ModifiedBinarySearch {

    // return the index of the key in the sorted array a[]; -1 if not found
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length-1);
    }
    public static int search(String key, String[] a, int lo, int hi) {
        // possible key indices in [lo, hi)
        while (hi > lo) {
          int mid = lo + (hi - lo) / 2;
          int cmp = a[mid].compareTo(key);
          if (cmp >= 0) hi = mid;
          else if (cmp < 0) lo = mid+1;
        }
        return a[lo].equals(key)?lo:-1*lo;
      }


    // whitelist, exception filter
    public static void main(String[] args) {
        In in = new In(args[0]);
        String s = in.readAll();
        String[] words = s.split("\\s+");
        System.err.println("Done reading words");

        // sort the words (if needed)
        Arrays.sort(words);
        System.err.println("Done sorting words");

        // prompt user to enter a word and check if it's there
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (search(key, words) < 0) StdOut.println(key);
        }
    }
}
