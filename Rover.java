/*
 * Class Name:    Rover
 *
 * Author:        Anup Bhattarai
 * Creation Date: Monday, April 17 2017, 12:06
 * Last Modified: Wednesday, April 19 2017, 15:03
 *
 * Class Description:
 *
 *  This is the Rover class for Assignment C OOF Semester 1 2017
 */

public class Rover
{
   private boolean onMission;
   private String roverID;
   private Explorer explorerObjectReference;


   public Rover(String roverID)
   {
      this.roverID = roverID;
      this.onMission = false;
      explorerObjectReference = null;
   }
   public Rover(String roverID, boolean onMission)
   {
      this.roverID = roverID;
      this.onMission = onMission;
      explorerObjectReference = null;
   }
   public String toString()
   {
      String description = "\nRover[Id: " +
         roverID +
         ((onMission)?"": " not " ) +
         " on a mission " + "\n";
      return description;
   }
   public void addExplorer(String name, String explorerID)
   {
      explorerObjectReference = new Explorer(name, explorerID );
   }
           public String getRoverID()
   {
      return roverID;
   }

    public String getExplorerID()
   {
      String explorerID =  explorerObjectReference.getExplorerID();
      return explorerID;
   }
   public Explorer getExplorerObjectReference()
   {
      return explorerObjectReference;
   }

   public void startMission()
   {
      onMission = true;
      explorerObjectReference.setIncreaseMission();
   }
   public void endMission()
   {
      onMission = false;
   }
   public boolean hasTechnicalLevel(String reqdTechnicalLevel)
   {
      if(reqdTechnicalLevel.equals("monitor"))
      {
         return true;
      }
      else if (reqdTechnicalLevel.equals("flight qual"))
      {
         if(explorerObjectReference.getTechLevel().equals("flight qual") || explorerObjectReference.getTechLevel().equals("aerial recon") || explorerObjectReference.getTechLevel().equals("ground explorer"))
         {
            return true;
         }
         else
         {
            return false;
         }
      }
      else if(explorerObjectReference.getTechLevel().equals("aerial recon"))
      {
         if(explorerObjectReference.getTechLevel().equals("aerial recon") || explorerObjectReference.getTechLevel().equals("ground explorer"))
         {
            return true;
         }
         else
         {
            return false;}
      }
      if(explorerObjectReference.getTechLevel().equals("ground explorer"))
      {
         return true;
      }
      else
      {
         return false;
      }

      // return false;
   }
   // public void getobjectReference()
   //{
   // return explorerObjectReference;
   //  }

   // public explorerObjectReference clone()
   //{
   //  explorerObjectReference clonedExplorer = new explorerObjectReference(name, explorerID);
   // }
}

                          