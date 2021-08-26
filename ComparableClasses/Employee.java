class Employee implements Comparable<Employee>
{
  private String firstName;
  private String lastName;

  private int birthYear;

  String getFirstName()  { return firstName; }
  String getLastName()   { return lastName; }
  int    getBirthYear()  { return birthYear; }

  public Employee( String f, String l, int year )
  {
    firstName = f; lastName = l; birthYear = year;
  }

  public String toString(){
    return getFirstName() + " " + getLastName() + ", " + getBirthYear();
  }

  public int compareTo( Employee other ) {
    if (!getLastName().equals(other.getLastName())) return getLastName().compareTo(other.getLastName());
    if (!getFirstName().equals(other.getFirstName())) return getFirstName().compareTo(other.getFirstName());
    return getBirthYear() - other.getBirthYear();
  }

}
