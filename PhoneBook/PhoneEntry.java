/******************************************************************************
 *  Compilation:  javac PhoneEntry.java
 *  Dependencies: none
 *
 *  Creates a Entry with the first and last name of a person along with their
 *  phone number.
 *
 ******************************************************************************/

public class PhoneEntry
{
  private String firstName;    // first name of a person
  private String lastName;    // last name of a person
  private String phone;   // their phone number

  public PhoneEntry( String f, String l, String p )
  {
    firstName = f; lastName = l; phone = p;
  }

  public String getName()  {return firstName + " " + lastName;}
  public String getLastName() {return lastName;}
  public String getFirstName() {return firstName;}
  public String getPhone() {return phone;}
}
