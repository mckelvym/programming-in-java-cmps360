/*
 * Team.java v1.0
 * 
 * Created on July 18, 2004, 12:01 AM
 * Updated on February 28, 2006
 */

package contesttimer;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

/** An object of class Teams represents one team in the programming contest and
 *  the information about each of its programming problem solutions.
 *
 * @author  Frank Ducrest
 */
public class Team extends JPanel implements Comparable {
    private int number;
    private int division;   // entry level - 1, advanced level - 2
    private int numProgs;
    private int startNum;
    private Problem []problems;
    
    private boolean visible;
    private MyActionListener mal;
    private Border blackBorder;
    
    private JButton close;
    private JPanel closePanel;
    private JLabel closeLabel;
    
       
    /** creates an instance of Class Team base on the data pased */
    public Team(int number, int division, int numProgs, int startNum) {
        mal = new MyActionListener();
        setLayout(new GridLayout(5,5));
        setBackground(Color.RED);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.number = number;
        this.division = division;
        this.numProgs = numProgs;
        this.startNum = startNum;
        
        problems = new Problem[this.numProgs];
        for (int x=0; x<this.numProgs; x++) {
            problems[x] = new Problem(x+startNum);
        }
        
        visible = false;
    }
    
    /** creates an instance of Class Team based on data read from a file */
    public Team(BufferedReader br) {
        mal = new MyActionListener();
        setLayout(new FlowLayout());
        setBackground(Color.RED);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        String line = null;
        
        try {
            line = br.readLine();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        StringTokenizer st = new StringTokenizer(line);
        number = Integer.parseInt(st.nextToken());
        division = Integer.parseInt(st.nextToken());
        numProgs = Integer.parseInt(st.nextToken());
        startNum = Integer.parseInt(st.nextToken());
        for (int x=0; x<numProgs; x++) 
            problems[x] = new Problem(Integer.parseInt(st.nextToken()),  // state
                                      Integer.parseInt(st.nextToken()),  // minutes
                                      Integer.parseInt(st.nextToken())); // number
        
        visible = false;
    }
    
    /** adds a programming problem to the team */
    public void AddProblem(int p, int state, int minutes, int pnumber) {
        problems[p] = new Problem(state, minutes, pnumber);
    }
  
    
    /** writes the state information about a team to a file along with the 
     *  status of all solutions to all problems the team is assigned
     */
    public void WriteTeam(PrintWriter pw) {
        pw.print(number);
        pw.print(" ");
        pw.print(division);
        pw.print(" ");
        pw.print(numProgs);
        pw.print(" ");
        pw.print(startNum);
        for (int x=0; x<numProgs; x++)
           problems[x].WriteProblem(pw);
    }
    
    
    private void SetTeamPanel() {
        /************************************** put stuff in panel ************/
        
        closePanel = new JPanel();
        closePanel.setBackground(Color.WHITE);
        closePanel.setLayout(new BoxLayout(closePanel, BoxLayout.Y_AXIS));
        close = new JButton("Close");
        close.addActionListener(mal);
        closeLabel = new JLabel("Team #" + number);
        closePanel.add(closeLabel);
        closePanel.add(close);
        add(closePanel);
        
        for (int x=0; x<numProgs; x++) {
            add(problems[x]);
            problems[x].SetVisible(true);
        }
    }
    
    /** updates the display of the team information and the status of all 
     *  solutions to all problems the team is assigned
     */
    public void SetVisible(boolean visible) {
        this.visible = visible;
        if (visible) {
            removeAll();
            SetTeamPanel();
            setVisible(false);
            setVisible(true);
        }
        else
            setVisible(false);
    }
    
    
    /** returns the assigned number of the team */
    public int GetTeamNumber() {
        return number;
    }
    
    /** returns the division of the team, addvanced is 2, entry level is 1 */
    public int GetTeamDivision() {
        return division;
    }
    
    /** returns the number of programs assigned to the team */
    public int GetNumProblems() {
        return numProgs;
    }
    
    /** returns the number of problems solved */
    public int GetNumProblemsSolved() {
        int solved = 0;
        
        for (int x=0; x<numProgs; x++)
            if (problems[x].IsSolved())
                solved++;
        
        return solved;
    }
    
    /** returns the minutes taken by the solution to the given program */
    public int GetMinutesTaken(int prog) {
        return problems[prog].GetMinutes();
    }
    
    /** returns the total number of minutes taken by all the solution to all 
     * solved problems 
     */
    public int GetTotalMinutesTaken() {
        int minutes = 0;
        
        for (int x=0; x<numProgs; x++)
            if (problems[x].IsSolved())
                minutes += problems[x].GetMinutes();

        return minutes;
    }

    
    
    /** returns true if the solution to the given problem has been paused for
     *  judging, false if not
     */
    public boolean IsPaused(int prog) {
        return problems[prog].IsPaused();
    }
    
    /** returns true if the solution to the given problem has been judged as
     *  correct, false if not
     */
    public boolean IsSolved(int prog) {
        return problems[prog].IsSolved();
    }
    

    
    /** adds one minute to all running problem timers */
    public void AddMinute() {
        for (int x=0; x<numProgs; x++) {
            if (!problems[x].IsPaused() && !problems[x].IsSolved())
                problems[x].AddMinute();
        }
    }

    
    /** override of compareTo of interface Comparable; compares division first, 
     *  number of problems solved second and time taken third.
     */
    public int compareTo(Object o) {
        Team other = (Team)o;
        
        if (division < other.division)
            return -1;
        else if (division > other.division)
            return +1;
        
        if (GetNumProblemsSolved() < other.GetNumProblemsSolved())
            return -1;
        else if (GetNumProblemsSolved() > other.GetNumProblemsSolved())
            return +1;

        if (GetTotalMinutesTaken() > other.GetTotalMinutesTaken())
            return -1;
        else if (GetTotalMinutesTaken() < other.GetTotalMinutesTaken())
            return +1;

        return 0;
    }

    
    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == close) {
                SetVisible(false);
            }
        }
    }

}
