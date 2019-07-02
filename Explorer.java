/*
 * Class Name:    Explorer
 *
 * Author:        Anup Bhattarai
 * Creation Date: Monday, April 17 2017, 12:09
 * Last Modified: Wednesday, April 19 2017, 15:03
 *
 * Class Description:
 *
 * This is Explorer class for Assignment C OOF Semester 1 2017
 *
 * All Explorers start with 0 missions.
 *
 * The missions that the Explorer is qualified to undertake
 * depends on their technical level
 *
 * If the number of missions is 0 - 2 (inclusive) then the mission
 * level is "monitor"
 *
 * If the number of missions is 3 - 7 inclusive, then the mission
 * level is "flight qual"
 *
 * If the number of missions is 8 - 11 inclusive, then the mission
 * level is "aerial recon"
 *
 * If the number of missions is 12 +, then the mission level is
 * "ground explorer"
 *
 * An explorer can always undertake a mission that requires a mission
 * equal to less than their level. They cannot undertake a mission that
 * requires a higher level.
 *
 * For example, an explorer with the tech level "aerial recon" could
 * undertake "aerial recon", "flight qual" and "monitor" missions.
 *
 * Each time an Explorer completes a mission, their number of missions
 * is increased by 1. This means that their techLevel has to be checked
 * after each mission as it may increase.
 *
 * *******************************************************************
 * When a mission is assigned, or being checked, it is the technical level
 * at the START of the mission, thatis, their current level,
 * that determines if the Explorer has * the required technical level to undertake the mission.
 *
 * If the mission is assigned, then the Explorer has
 * their number of missions incremented.
 * *****************************************************************
 */

public class Explorer
{
   private String name;
   private String explorerID;
   private int missions;
   private String technicalLevel;

   public Explorer(String name, String explorerID, int missions)
   {
      this.name = name;
      this.explorerID = explorerID;
      this.missions = missions;
      setTechnicalLevel();
   }

   public Explorer(String name, String explorerID)
   {

      this.name = name;
      this.explorerID = explorerID;
      this.missions = 0;
      setTechnicalLevel();
   }

     public void  setTechnicalLevel()
   {
      if (missions >= 0 && missions <= 2)
      {
         technicalLevel = "monitor";
      }
      else if (missions >= 3 && missions <= 7)
      {
         technicalLevel = "flight qual";
      }
      else if (missions >= 8 && missions <= 11)
      {
         technicalLevel = "aerial recon";
      }
      else
      {
         technicalLevel = "ground explorer";
      }
      //return technicalLevel;
   }

   public void setIncreaseMission()
   {
      missions++;
      setTechnicalLevel();
   }

   public String getTechLevel()
   {
      return technicalLevel;
   }

   public String getName()
   {
      return name;
   }
 public String getExplorerID()
   {
      return explorerID;
   }

   public int getMissions()
   {
      return missions;
   }

   public String getTechnicalLevel()
   {
      return technicalLevel;
   }
   public String toString()
   {
      return ("[ Name: " + name + "Exp id: " + explorerID +
              "\n Tech level: " + technicalLevel + " Number of Missions: " +  missions);
   }
}


       