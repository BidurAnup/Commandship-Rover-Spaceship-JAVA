/*
 * Class Name:    CommandShip
 *
 * Author:        Anup Bhattarai
 * Creation Date: Monday, April 17 2017, 11:59
 * Last Modified: Wednesday, April 19 2017, 15:02
 *
 * Class Description:
 *
 * This is the driver file for Assignment C OOF Semester 1 2017
 *
 *
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class CommandShip
{
   private Rover rover1;
   private Rover rover2;
   private Scanner kb;

   private final int ADD_ROVER = 1;
   private final int ADD_EXPLORER = 2;
   private final int ASSIGN_MISSION = 3;
   private final int END_MISSION = 4;
   private final int DISPLAY = 5;
   private final int ADD_FROM_FILE = 6;
   private final int EXIT = 7;

   public static void main( String [ ] args ) throws IOException
   {
      CommandShip cs = new CommandShip( );
      cs.run( );
   }

    public CommandShip( )
   {
      rover1 = null;
      rover2 = null;
      kb = new Scanner( System.in );
   }

   /*
    * This method is the main method that runs the whole program.
    * This method is fully coded, there is nothing more to add.
    *
    */

   public void run( ) throws IOException
   {
      int choice = -1;

      while( choice != EXIT )
      {
         displayMenu( );
         System.out.print("Enter choice >> " );
         choice = kb.nextInt( );
         kb.nextLine( ); // clear the \n left after the int read
         process( choice );
      }

   }

   /*
    * This is a dispatch method. It's sole job is to call the
    * corressponding method based on the choice passed in.
    *
    * This method is fully coded, there is nothing to add.
    *
    */
public void process( int choice ) throws IOException
   {
      switch( choice )
      {
         case ADD_ROVER :
            addRover( );
            break;

         case ADD_EXPLORER:
            addExplorer( );
            break;

         case ASSIGN_MISSION :
            assignMission( );
            break;

         case END_MISSION:
            endMission( );
            break;

         case DISPLAY:
            display( );
            break;

         case ADD_FROM_FILE:
            addFromFile( );
            break;

         case EXIT:
            // just trap this choice so that it doesn't
            // show as an error
            break;

         default:
            System.out.println("That is an invalid choice");
            break;
      }
   }


   /*
    * This method just displays the menu. It is fully implemented, there
    * is nothing to add
 *
    */
   public void displayMenu( )
   {
      System.out.println( "\nCommand Ship Menu " );
      System.out.println( "\t" + ADD_ROVER + ". Add Rover" );
      System.out.println( "\t" + ADD_EXPLORER + ". Add Explorer" );
      System.out.println( "\t" + ASSIGN_MISSION + ". Assign Mission" );
      System.out.println( "\t" + END_MISSION + ". End Mission" );
      System.out.println( "\t" + DISPLAY + ". Display" );
      System.out.println( "\t" + ADD_FROM_FILE + ". Add from input file" );
      System.out.println( "\t" + EXIT + ". Exit the program" );
   }

   /*
    * This method adds a Rover from the keyboard. This method must
    * check that there is a "free" Rover object reference. If there
    * is not a free Rover object reference, then the method displays
    * an appropriate message and does not ask the user for any
    * more information.
    *
    * If there is at least one Rover object refrence free then the
    * user is asked to enter a Rover id. If both Rover object
    * references are free then rover1 is assigned the Rover.
    *
    * If there is only one Rover object free then it must be the
    * second one, in which case the user entered Rover id must be
    * checked that it is not already in use.
    *
    * If the user entered Rover id is already in use, then the user
    * is informed with an appropriate message and the method
    * returns without adding the Rover.
    *
    * This method does NOT add any Explorer information, just the Rover.
    *
    */
public void addRover( )
   {
      if (rover1 != null && rover2 != null)
      {
         System.out.println("Maximum number of Rovers have already been assigned.");
         displayMenu();
      }
      else
      {
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter rover id: ");
         String roverID = kb.nextLine();

         if(rover1 == null )
         {
            rover1 = new Rover(roverID);
            displayMenu();
         }
         else
         {
            if(rover1.getRoverID().equals(roverID))

            {
               rover2 = new Rover(roverID);
               displayMenu();
            }
            else
            {
               System.out.println("That roverID is already in use.");
               displayMenu();
            }
         }
      }
   }

   /*
    * This method displays information about the Rovers. If there are no
    * Rovers, then that should be displayed. The format of the output
    * MUST follow the examples as shown on the assignment
    *
    */
 public void display( )
   {
      if( rover1 != null )
      {
         System.out.println(rover1.toString());
      }

   }

   /*
    *   To add an Explorer, there has to be at least one Rover.
    *   If there are no Rovers, then the user is informed with an
    *   appropriate message and no Explorer information is requested
    *   from the user.
    *
    *   Explorer id's must be unique.
    *
    *   Explorer's can be assigned to any Rover, so the user is
    *   first asked for the id of a Rover. If the Rover with that
    *   id is found, then the program must check that that Rover
    *   does not already have an Explorer. If that Rover already
    *   has an Explorer, then the user is informed with an
    *   appropriate message and no further information is requested
    *   from the user.
    *
    *   Only if the Rover id exists and that Rover does not have an
    *   Explorer already is the user asked for an Explorer id.
    *
    *   Only after checking that the user entered Explorer id is
    *   indeed unique is the user asked for the name of the Explorer.
    *
    *   It is the name and Explorer id that is passed to the
    *   relevant function in the Rover class.
    *
    *   The CommandShip class never has Explorer object attributes or
    *   Explorer object references.
    *
    */
 public void addExplorer( )
   {
      if (rover1 = null && rover2 = null)
      {
         System.out.println("There are no rovers to add Explorer");
         displayMenu();

      }
      else if(rover1 != null && rover2 != null && rover1.getExplorerObjectReference() !== null && rover2.getExplorerObjectReferenc != null)// is it correct "rover1.explorerObjectReference".
      {
         System.out.println("Both rovers already has explorers.");
      }
      else
      {
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter rover id >> ");
         String roverID = kb.nextLine();

         if (rover1 == null && rover1.getRoverID().equals(roverID))
         {
            System.out.println("Enter explorer id >>");
            String userExplorerID = kb.nextLine();
            if (rover1.getExplorerObjectReference.getExplorerID().equals(userExplorerID))
            {
               System.out.println("Explorer id's must be unique, this Explorer id is already in use");
               displayMenu();
            }
            else
            {
               System.out.println("Enter explorer name >> ");
               String explorerName = kb.nextLine();
               rover1.addExplorer(explorerName, explorerID);
            }
         }
      }
/*
       * This method assigns a mission to a Rover. First there must be at
       * least one Rover, if there are no Rovers then this method should
       * display an appropriate message and return.
       *
       * To be assigned a mission, the user must enter the id of an existing
       * Rover. If there is a Rover with that id, then the program must
       * check that that Rover has an Explorer. If the Rover does not have an
       * Explorer, then the Rover cannot be assigned a mission. Provided that
       * there is an Explorer and the Rover is not already on a mission, then
       * and only then is the user asked to enter the required tech level.
       *
       * The required tech level is passed to the appropriate method in the
       * Rover object, which returns true or false as to whether the
       * Explorer associated with the Rover can be assigned the mission.
       * This could also be done in this class, provided only that
       * there is no direct access to the technical level of the Explorer
       * in this class.
       *
       * After all these checks have been passed, then the Rover is assigned
       * the mission. This method calls the appropriate methods in the Rover
       * class to set the on mission status to true and to increment the
       * number of missions that the Explorer has undertaken.
       *
       *
       */
      public void assignMission( )
      {

      }

/*
       * This method is called to end a mission. As with most other methods,
       * this method must first check there is at least one Rover. If there
       * are no Rovers then an appropriate message is displayed to the screen
       * and the method returns.
       *
       * If there is at least one Rover, then the user is asked to enter
       * a Rover id. If that Rover id is found, then the program needs to
       * check if the Rover is actually on a mission, if it is, then the
       * appropriate method in the Rover class is called and the onMission
       * status is set to false
       *
       */
      public void endMission( )
      {
         rover1.endMission();
      }

      /*
       * This method is called when the user adds some Rover/Explorer
       * combination(s) from an input text file. The format of the input
       * is detailed in the assignment and is guaranteed to be correct.
       *
       * The user is NOT asked for an input file name if there are no free
       * Rover object references. Only if there is at least one free Rover
       * object reference is the user asked for a file name.
       *
       * There might already be an existing Rover object, in which case,
       * regardless of the number of Rover/Explorer combinations in the
       * input file, only the first one is added. Once there are 2 Rover
       * objects in the program, then any other inputs, either from the
       * input file or the keyboard are ignored.
       *
       * The input file always has information about a Rover object.
       * If there is an Explorer associated with this Rover object, then
       * this will be indicated by a 1 below the on mission status. If there
       * is a 1 then the information that follows is for the Explorer, this
       * is detailed in the assignment.
       *
       */

      public void addFromFile( ) throws IOException
      {

      }
   }

    