/******************************************************************************
 *  Compilation:  javac PhoneBook.java
 *  Dependencies: PhoneEntry.java
 *
 *  A PhoneBook object has a phoneBook array that stores different PhoneEntry
 *  objects and has the ability to create and add new PhoneEntrys to the array
 *  as well as remove them or search for the corresponding phone number of a
 *  PhoneEntry object given the name.
 *
 ******************************************************************************/

public class PhoneBook
{
  private PhoneEntry[] phoneBook;

  public PhoneBook()    // constructor
  {
    phoneBook = new PhoneEntry[ 100 ] ;

    phoneBook[0] = new PhoneEntry( "James", "Barclay", "(418) 665-1223" );
    phoneBook[1] = new PhoneEntry( "Grace", "Dunbar", "(860) 399-3044" );
    phoneBook[2] = new PhoneEntry( "Paul", "Kratides", "(815) 439-9271" );
    phoneBook[3] = new PhoneEntry( "Violet", "Smith", "(312) 223-1937" );
    phoneBook[4] = new PhoneEntry( "John", "Wood", "(913) 883-2874" );
    phoneBook[5] = new PhoneEntry( "Richard", "Smith", "(646) 231-1987" );
    phoneBook[6] = new PhoneEntry( "Alice", "Dunbar", "(860) 412-3072" );

  }

  //Adds an PhoneEntry into phoneBook if there is any null value left in it
  public void add(String lastName, String firstName, String phone) {
    for ( int j=0; j < phoneBook.length; j++ )
    {
      if ( phoneBook[ j ] == null)
      {
        phoneBook[j] = new PhoneEntry( firstName, lastName, phone);
        break;
      }
    }
  }

  //Deletes the given name from the phoneBook if it exists and shifts the phoneBook so that the null values are at the end
  public void delete(String lastName, String firstName) {
    String targetName = firstName + " " + lastName;
    boolean notFound = true;
    int emptySpot = 0;
    for ( int j=0; j < phoneBook.length; j++ )
    {
      if (notFound && phoneBook[ j ] != null && phoneBook[ j ].getName().toUpperCase().equals(targetName.toUpperCase()) )
      {
          emptySpot = j;
          notFound = false;
      }
      if (notFound == false && (phoneBook[ j + 1] == null || j + 1 == phoneBook.length))
      {
        phoneBook[ emptySpot ] = new PhoneEntry(phoneBook[j].getFirstName(), phoneBook[j].getLastName(), phoneBook[j].getPhone());
        phoneBook[ j ] = null;
        break;
      }
  }
  System.out.println();
}

  //Searches for a last name in the phoneBook and prints out all PhoneEntry objects with that last name
  public void search( String last )
  {
    boolean notFound = true;
    for ( int j=0; j < phoneBook.length; j++ )
    {
      if (phoneBook[ j ] == null) break;
      if (phoneBook[ j ].getLastName().toUpperCase().equals( last.toUpperCase() ) )
      {
        System.out.println(phoneBook[ j ].getName() + ": " + phoneBook[ j ].getPhone());
        notFound = false;
      }
    }
    if (notFound) System.out.println("Name not found.");
  }

  //Searches for a full name in the phoneBook and prints out their number if it finds it
  public PhoneEntry search( String last, String first )
  {
    String targetName = first + " " + last;
    for ( int j=0; j < phoneBook.length; j++ )
    {
      if (phoneBook[ j ] == null) break;
      if (phoneBook[ j ].getName().toUpperCase().equals( targetName.toUpperCase() ) )
        return phoneBook[ j ];
   }
   return null;
 }
}
