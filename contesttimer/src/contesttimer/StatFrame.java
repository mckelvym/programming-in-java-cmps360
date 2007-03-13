/*
 * StatFrame.java v1.0
 * 
 * Created on July 18, 2004, 12:01 AM
 */

package contesttimer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/** An instance of class StatFrame displays the current statistics of a 
 *  programming contest.
 *
 * @author  Frank Ducrest
 */
public class StatFrame extends JFrame {
    private Container c;
    private JPanel mainPanel;
    private JTable table;
    private String cells[][];
    private String headers[];
    
    /** Creates a new instance of StatFrame */
    public StatFrame(String title, int totalProgs, int teams, Team []teamList) {
        int offset=0;
        
        setTitle(title);
        setSize(600,400);
        setLocation(0,0);
        
        c = getContentPane();
        c.setBackground(Color.WHITE);
        c.setForeground(Color.BLACK);
        c.setLayout(new BorderLayout());
        
      
        headers = new String[totalProgs+6];
        cells   = new String[teams][totalProgs+6];
        
        headers[0] = "Team";
        headers[1] = "Division";
        for (int x=0; x<totalProgs; x++) 
            headers[x+2] = "P"+(x+1);
        headers[totalProgs+2] = "Team";
        headers[totalProgs+3] = "Division";
        headers[totalProgs+4] = "#Solved";
        headers[totalProgs+5] = "Time";
        
        for (int x=0; x<teams; x++) {
            cells[x][0] = Integer.toString(teamList[x].GetTeamNumber());
            if (teamList[x].GetTeamDivision() == 1) {
                cells[x][1] = "L";
                for (int y=0; y<teamList[x].GetNumProblems(); y++) {
                    if (teamList[x].IsSolved(y)) 
                        cells[x][y+2] = "S";
                    else if (teamList[x].IsPaused(y))
                        cells[x][y+2] = "P";
                    else
                        cells[x][y+2] = "R";
                    cells[x][y+2] += Integer.toString(teamList[x].GetMinutesTaken(y));
                }
                for (int y=teamList[x].GetNumProblems(); y<totalProgs; y++)
                    cells[x][y+2] = "---";
            } else {
                cells[x][1] = "U";
                for (int y=0; y<totalProgs-teamList[x].GetNumProblems(); y++)
                    cells[x][y+2] = "---";
                for (int y=totalProgs-teamList[x].GetNumProblems(); y<totalProgs; y++) {
                    if (teamList[x].IsSolved(y-(totalProgs-teamList[x].GetNumProblems()))) 
                        cells[x][y+2] = "S";
                    else if (teamList[x].IsPaused(y-(totalProgs-teamList[x].GetNumProblems())))
                        cells[x][y+2] = "P";
                    else
                        cells[x][y+2] = "R";
                    cells[x][y+2] += Integer.toString(teamList[x].GetMinutesTaken(y-(totalProgs-teamList[x].GetNumProblems())));
                }
            }
                
            cells[x][totalProgs+2] = Integer.toString(teamList[x].GetTeamNumber());
            if (teamList[x].GetTeamDivision() == 1)
                cells[x][totalProgs+3] = "L";
            else
                cells[x][totalProgs+3] = "U";
            cells[x][totalProgs+4] = Integer.toString(teamList[x].GetNumProblemsSolved());
            cells[x][totalProgs+5] = Integer.toString(teamList[x].GetTotalMinutesTaken());
        }
                
        
    	table = new JTable(cells, headers);
    	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	table.doLayout();
      
        JScrollPane jsp = new JScrollPane(table, 
        	ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
   		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        c.add(jsp, BorderLayout.CENTER);
        setVisible(true);
    }
    
}
