/******************************************************************************
 *  Compilation:  javac Huntingtons.java
 *  Execution:    java Huntingtons fileName.txt
 *  Dependencies: In.java
 *
 *  Reads a string of DNA from a text file and diagnoses whether that person has huntingtons
 *
 *  By Arib Chowdhury (Pd. 3) and Jason Chan (Pd. 8)
 *
 ******************************************************************************/
 public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
      int consecutive = 0;
      int bestScore = 0;
      for (int i = 0; i < dna.length() - 2; i++) {
        if (dna.substring(i,i+3).equals("CAG")) {
          i += 2;
          consecutive += 1;
        }
        else {
          if (bestScore < consecutive) bestScore = consecutive;
          consecutive = 0;
        }
      }
      return bestScore;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
      s = s.replace(" ","");
      s = s.replace("\n","");
      s = s.replace("\t","");
      return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
      if (maxRepeats >= 181) return "not Human";
      else if (maxRepeats >= 40) return "Huntington's";
      else if (maxRepeats >= 36) return "high risk";
      else if (maxRepeats >= 10) return "normal";
      else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
      String name = args[0];
                In file = new In(name);
                String text = file.readAll();
                text = removeWhitespace(text);
                int n = maxRepeats(text);
                System.out.println("maxRepeats = " + n);
                System.out.println(diagnose(n));    }

}
