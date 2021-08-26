/******************************************************************************
 *  Compilation:  javac ColorHSB.java
 *  Execution:    java ColorHSB int hue int saturation int brightness < fileName
 *  Dependencies: StdIn.java
 *
 *  Prints a color listed from the fileName that is the closest to the listed hue,
 *  saturation, and brightness, as well as the HSB of the printed color
 *
 *  By Arib Chowdhury Pd.3 and Jason Chan Pd.8
 *
 *  java ColorHSB 25 84 97 < wiki.txt
 *  Princeton_Orange (26, 85, 96)
 *
 ******************************************************************************/

public class ColorHSB {
      private final int hue;
      private final int saturation;
      private final int brightness;
      // Creates a color with hue h, saturation s, and brightness b.
      public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) throw new IllegalArgumentException("Hue must be a value between 0 and 359");
        hue = h;
        if (s < 0 || s > 100) throw new IllegalArgumentException("Saturation must be a value between 0 and 100");
        saturation = s;
        if (b < 0 || b > 100) throw new IllegalArgumentException("Brightness must be a value between 0 and 100");
        brightness = b;
      }

      // Returns a string representation of this color, using the format (h, s, b).
      public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
      }

      // Is this color a shade of gray?
      public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
      }

      // Returns the squared distance between the two colors.
      public int distanceSquaredTo(ColorHSB that) {
        int distance = (int) (Math.min(Math.pow((this.hue - that.hue), 2), Math.pow(360 - Math.abs(this.hue - that.hue), 2)) + Math.pow((this.saturation - that.saturation), 2) + Math.pow((this.brightness - that.brightness), 2));
        return distance;
      }

      // Sample client (see below).
      public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB to_match = new ColorHSB(h, s, b);
        int dist;
        String closestColor = "";
        ColorHSB toPrint = new ColorHSB (69, 69, 69); 
        int closestDistance = Integer.MAX_VALUE;
        while (!StdIn.isEmpty()) {
          String color = "";
          String h2 = "";
          String s2 = "";
          String b2 = "";
          String line = StdIn.readLine();
          int index = 0;
          while (line.charAt(index) != ' ') {
            color += line.charAt(index);
            index++;
          }
          while(!Character.isDigit(line.charAt(index))) index++;
          while(line.charAt(index) != ' ') {
            h2 += line.charAt(index);
            index++;
          }
          while(!Character.isDigit(line.charAt(index))) index++;
          while(line.charAt(index) != ' ') {
            s2 += line.charAt(index);
            index++;
          }
          while(!Character.isDigit(line.charAt(index))) index++;
          while(index != line.length()) {
            b2 += line.charAt(index);
            index++;
          }
          ColorHSB to_test = new ColorHSB(Integer.parseInt(h2),Integer.parseInt(s2),Integer.parseInt(b2));
          dist = to_match.distanceSquaredTo(to_test);
          if (dist < closestDistance) {
            closestColor = color;
            closestDistance = dist;
            toPrint = to_test;
          }
        }
        System.out.println(closestColor.replace(" ", "") + " " + toPrint);
      }
}
