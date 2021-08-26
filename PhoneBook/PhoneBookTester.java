/******************************************************************************
 *  Compilation:  javac PhoneBookTester.java
 *  Execution:    java PhoneBookTester
 *  Dependencies: StdIn.java, PhoneBook.java, PhoneEntry.java
 *
 *  Allows for user input to make actions such as adding PhoneEntry(s), deleting
 *  them or searching for them given a name in a PhoneBook object.
 *
 *  $ java PhoneBookTester
 *  Menu
 *  1-Search
 *  2-Add Name
 *  3-Delete Name
 *  4-Quit
 *  1
 *  Last Name? Smith
 *  First Name? Violet
 *  Violet Smith: (312) 223-1937
 *
 *  Menu
 *  1-Search
 *  2-Add Name
 *  3-Delete Name
 *  4-Quit
 *  1
 *  Last Name? Smith
 *  First Name? ?
 *  John Smith: (812) 339-4916
 *  Violet Smith: (312) 223-1937
 *  Willoughby Smith: (312) 992-8761
 *
 *  Menu
 *  1-Search
 *  2-Add Name
 *  3-Delete Name
 *  4-Quit
 *  2
 *  Last Name: Byrd
 *  First Name: James
 *  Phone Number: (231) 343-9923
 *
 *  Menu
 *  1-Search
 *  2-Add Name
 *  3-Delete Name
 *  4-Quit
 *  1
 *  Last Name? Byrd
 *  First Name? ?
 *  James Byrd: (231) 343-9923
 *
 *  Menu
 *  1-Search
 *  2-Add Name
 *  3-Delete Name
 *  4-Quit
 *  3
 *  Last Name: Smith
 *  First Name: Violet
 *
 *  Menu
 *  1-Search
 *  2-Add Name
 *  3-Delete Name
 *  4-Quit
 *  1
 *  Last Name? Smith
 *  First Name? ?
 *  John Smith: (812) 339-4916
 *  Willoughby Smith: (312) 992-8761
 *
 *  Menu
 *  1-Search
 *  2-Add Name
 *  3-Delete Name
 *  4-Quit
 *  good-bye
 *
 ******************************************************************************/

public class PhoneBookTester
{
  public static void main ( String[] args )
  {
    PhoneBook pb = new PhoneBook();
    String first = "";
    String last = "";
    String phone = "";
    String action = "";

    //Asks for actions until user quits
    while(true) {
      System.out.println("Menu\n1-Search\n2-Add Name\n3-Delete Name\n4-Quit");
      action = StdIn.readLine();

      //If action is to quit, program ends
      if (action.equals("4")) break;

      //If action is to search, user will be prompted to search for a name
      if (action.equals("1"))
      {
          System.out.print("Last Name? ");
          last = StdIn.readLine();

          System.out.print("First Name? ");
          first = StdIn.readLine();

          if (first.equals("?")) pb.search(last);
          else {
            PhoneEntry entry = pb.search(last, first);
            if (entry != null) System.out.println("Phone Number: " + entry.getPhone());
            else System.out.println("Name not found.");
          }
      }

      //If action is to add names, user will be prompted for name and phone number to add one
      if (action.equals("2")) {
          System.out.print("Last Name: ");
          last = StdIn.readLine();

          System.out.print("First Name: ");
          first = StdIn.readLine();

          System.out.print("Phone Number: ");
          phone = StdIn.readLine();

          pb.add(last, first, phone);
          System.out.println();
      }

      //If action is to delete, user will be prompted for last and first name to delete from phoneBook
      if (action.equals("3")) {
          System.out.print("Last Name: ");
          last = StdIn.readLine();

          System.out.print("First Name: ");
          first = StdIn.readLine();

          pb.delete(last, first);
      }
      System.out.println();
    }
    System.out.println("good-by");
  }
}
