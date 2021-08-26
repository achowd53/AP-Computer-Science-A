class Diamond implements Comparable<Diamond>
{
  private String stockNumber;

  private double carot;       /* size of the diamond */
  private String clarity;  /* clarity grade of the diamond */
  private char color;      /* color grade D-Z */
  private String cut;      /* name of the cut */

  String getStock()   { return stockNumber; }
  double getCarot()   { return carot; }
  String getClarity() { return clarity; }
  char   getColor()   { return color; }
  String getCut()     { return cut; }

  public Diamond( String s, double car, String clar, char col, String ct )
  {
    stockNumber = s;  carot = car; clarity = clar; color = col; cut = ct;
  }

  public String toString()
  {
    return "Diamond Stock Number " + getStock() + " - caret: " + getCarot() + ", clarity: " + getClarity() + ", color: " + getColor() + ", cut: " + getCut();
  }
  public int compareClarity()
  {
    String clarity_to_compare = getClarity();
    if (clarity_to_compare.equals("FL")) return 0;
    if (clarity_to_compare.equals("IF")) return 2;
    if (clarity_to_compare.equals("VVS1")) return 4;
    if (clarity_to_compare.equals("VVS2")) return 6;
    if (clarity_to_compare.equals("VS1")) return 8;
    if (clarity_to_compare.equals("VS2")) return 10;
    if (clarity_to_compare.equals("SI1")) return 12;
    if (clarity_to_compare.equals("SI2")) return 14;
    if (clarity_to_compare.equals("I1")) return 16;
    if (clarity_to_compare.equals("I2")) return 18;
    else return 20;
  }
  public int compareTo( Diamond other )
  {
    if (getCarot() != other.getCarot()) return (int) Math.round(other.getCarot() - getCarot() - .5);
    String color_options = "DEFGHIJKLMNOPQRSTUVWXYZ";
    boolean choice = compareClarity() <= color_options.indexOf(getColor());
    if (getClarity().equals(other.getClarity())) choice = false;
    if ((getColor() + "").equals("" + other.getColor())) choice = true;
    if (choice) return compareClarity() - other.compareClarity();
    else return color_options.indexOf(getColor()) - color_options.indexOf(other.getColor());
  }

}
