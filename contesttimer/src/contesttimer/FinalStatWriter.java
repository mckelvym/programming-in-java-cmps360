/*
 * FinalStatWriter.java v1.0
 * 
 * Created on February 28, 2006
 */

package contesttimer;

import java.io.*;
import java.util.*;


/** An instance of class FinalStatWriter writes the current statistics of a 
 *  programming contest to a comma separated value file (.csv) named 
 *  ExitGameStats.csv.  This file can be loaded into any spreadsheet.  Teams 
 *  appear in order by division.
 *
 * @author  Frank Ducrest
 */
public class FinalStatWriter {
    
    /** Creates a new instance of FinalStatWriter */
    public FinalStatWriter(String title, int totalProgs, int teams, Team []tl) {
        FileWriter fw;
        ArrayList teamList = new ArrayList<Team>();
        
        for (int i=0; i<teams; i++)
            teamList.add(tl[i]);
        Collections.sort(teamList);
       
        try {
             fw = new FileWriter("ExitGameStats.csv");
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
            Team t = (Team)teamList.get(x);
            pw.print(t.GetTeamNumber() + ",");
            if (t.GetTeamDivision() == 1) {
                pw.print("L,");
                for (int y=0; y<t.GetNumProblems(); y++) {
                    if (t.IsSolved(y)) 
                        pw.print("S");
                    else if (t.IsPaused(y))
                        pw.print("P");
                    else
                        pw.print("R");
                    pw.print(Integer.toString(t.GetMinutesTaken(y)) + ",");
                }
                for (int y=t.GetNumProblems(); y<totalProgs; y++)
                    pw.print("---,");
            } else {
                pw.print("U,");
                for (int y=0; y<totalProgs-t.GetNumProblems(); y++)
                    pw.print("---,");
                for (int y=totalProgs-t.GetNumProblems(); y<totalProgs; y++) {
                    if (t.IsSolved(y-(totalProgs-t.GetNumProblems()))) 
                        pw.print("S");
                    else if (t.IsPaused(y-(totalProgs-t.GetNumProblems())))
                        pw.print("P");
                    else
                        pw.print("R");
                    pw.print(Integer.toString(t.GetMinutesTaken(y-(totalProgs-t.GetNumProblems()))) + ",");
                }
            }
                
            pw.print(t.GetTeamNumber() + ",");
            if (t.GetTeamDivision() == 1)
                pw.print("L,");
            else 
                pw.print("U,");
            pw.print(Integer.toString(t.GetNumProblemsSolved()) + ",");
            pw.println(Integer.toString(t.GetTotalMinutesTaken()));
        }

        pw.close();
    }

}
