/*
 * StatWriter.java v1.0
 * 
 * Created on July 18, 2004, 12:01 AM
 */

package contesttimer;

import java.io.*;


/** An instance of class StatWriter writes the current statistics of a 
 *  programming contest to a comma separated value file (.csv) named 
 *  GameStats.csv.  This file can be loaded into any spreadsheet.
 *
 * @author  Frank Ducrest
 */
public class StatWriter {
    
    /** Creates a new instance of StatWriter */
    public StatWriter(String title, int totalProgs, int teams, Team []teamList) {
        FileWriter fw;

        try {
             fw = new FileWriter("GameStats.csv");
        } catch (IOException e) {
            System.out.println("Cannot write Game Stats Report:\n" + e);
            return;
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        
        pw.print("Team,Division,");
        for (int x=0; x<totalProgs; x++) 
            pw.print("P" + (x+1) + ",");
        pw.println("Team,Division,#Solved,Time");
        
        for (int x=0; x<teams; x++) {
            pw.print(teamList[x].GetTeamNumber() + ",");
            if (teamList[x].GetTeamDivision() == 1) {
                pw.print("L,");
                for (int y=0; y<teamList[x].GetNumProblems(); y++) {
                    if (teamList[x].IsSolved(y)) 
                        pw.print("S");
                    else if (teamList[x].IsPaused(y))
                        pw.print("P");
                    else
                        pw.print("R");
                    pw.print(Integer.toString(teamList[x].GetMinutesTaken(y)) + ",");
                }
                for (int y=teamList[x].GetNumProblems(); y<totalProgs; y++)
                    pw.print("---,");
            } else {
                pw.print("U,");
                for (int y=0; y<totalProgs-teamList[x].GetNumProblems(); y++)
                    pw.print("---,");
                for (int y=totalProgs-teamList[x].GetNumProblems(); y<totalProgs; y++) {
                    if (teamList[x].IsSolved(y-(totalProgs-teamList[x].GetNumProblems()))) 
                        pw.print("S");
                    else if (teamList[x].IsPaused(y-(totalProgs-teamList[x].GetNumProblems())))
                        pw.print("P");
                    else
                        pw.print("R");
                    pw.print(Integer.toString(teamList[x].GetMinutesTaken(y-(totalProgs-teamList[x].GetNumProblems()))) + ",");
                }
            }
                
            pw.print(teamList[x].GetTeamNumber() + ",");
            if (teamList[x].GetTeamDivision() == 1)
                pw.print("L,");
            else 
                pw.print("U,");
            pw.print(Integer.toString(teamList[x].GetNumProblemsSolved()) + ",");
            pw.println(Integer.toString(teamList[x].GetTotalMinutesTaken()));
        }

        pw.close();
    }

    
}
