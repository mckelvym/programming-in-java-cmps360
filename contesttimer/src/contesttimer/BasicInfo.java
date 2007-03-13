/*
 * BasicInfo.java v1.0
 *
 * Created on July 18, 2004, 12:01 AM
 */

package contesttimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/** Collects the setup information for a new contest from the user.
 *
 * @author  Frank Ducrest
 */
public class BasicInfo extends Thread {
    private int teams;
    private int minutes;
    private int totalProgs;
    private int advProgs;
    private int entProgs;
    private boolean teamAdvanced[];

    private JFrame jf;
    private Container c;
    private JCheckBox jcb[];
    private MyItemListener mil;
    private MyWindowListener mwl;
    private final int MAX_TEAMS = 100;
    
    private MasterControl mc; 
    
    /** Creates a new instance of BasicInfo */
    public BasicInfo(MasterControl mc) {
        teams = minutes = totalProgs = advProgs = entProgs = 0;
        this.mc = mc;
    }
    
    /** Queries the user for values for number of teams, minutes in the contest
     *  number of programming problems, number of programming problems in both 
     *  divisions.  Returns true is all values are valid.  Returns false if 
     *  a value is not valid.
     */
    public boolean QueryUser() {
        teamAdvanced = null;
        
        if ((teams = GetInfo("Enter Number of Teams (100 Max):",
                             "Number of teams must be postitive.",
                             "Number of teams must be an integer.")) == 0)
            return false;

        if (teams > MAX_TEAMS) teams = MAX_TEAMS;
        
        if ((minutes = GetInfo("Enter Minutes in Contest:",
                             "Minutes must be postitive.",
                             "Minutes must be an integer.")) == 0)
            return false;
        
        if ((totalProgs = GetInfo("Enter Number of Programming Problems:",
                             "Programming Problems must be postitive.",
                             "Programming Problems must be an integer.")) == 0)
            return false;

        if ((entProgs = GetInfo("Enter Number of Entry Level Programming Problems:",
                             "Entry Level Programming Problems must be postitive.",
                             "Entry Level Programming Problems must be an integer.")) == 0)
            return false;
        if (entProgs > totalProgs) entProgs = totalProgs;

        if ((advProgs = GetInfo("Enter Number of Advanced Programming Problems:",
                             "Advanced Programming Problems must be postitive.",
                             "Advanced Programming Problems must be an integer.")) == 0)
            return false;
        if (advProgs > totalProgs) advProgs = totalProgs;

        return true;
    }
    
    private int GetInfo(String message, String error1, String error2) {
        String input = null;
        int info = 0;

        do {

            input = JOptionPane.showInputDialog(message);
            try {
                info = Integer.parseInt(input);
                if (info < 0)
                info = -1;
            } catch(Exception e) {
                info = -2;
            }
            
            if (info == -1)
                JOptionPane.showMessageDialog(null, error1);
            else if (info == -2)
                JOptionPane.showMessageDialog(null, error2);

        } while(info < 0);
        
        return info;
    }

    /** Allows the user to select the teams that will be in the Advanced or 
     *  UpperDivision.  Teams not selected are in the Entry Level or Lower
     *  Division.  GetInfo should be called before this method.  Once this 
     *  method has been started, the thread of the calling Contest thread is
     *  paused.  When the frame created here is closed, the Contest thread is
     *  relased and allowed to proceed. 
     */
    public void run() {
        jf = new JFrame(); 
        mwl = new MyWindowListener();
        
        jf.addWindowListener(mwl);
        jf.setLocation(100,100);
        jf.setSize(600,400);
        jf.setTitle("Select Advanced Teams, then Close Window:");

        c = jf.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(new GridLayout(10,10));
        
        mil = new MyItemListener();        
        teamAdvanced = new boolean[teams];
        jcb = new JCheckBox[teams];
        Color purple = new Color(100,0,200);
        for (int x=0; x<teams; x++) {
            jcb[x] = new JCheckBox(Integer.toString(x+1), false);
            jcb[x].setBackground(Color.WHITE);
            jcb[x].setForeground(purple);
            teamAdvanced[x] = false;
            jcb[x].addItemListener(mil);
            c.add(jcb[x]);
        }
        
        jf.setVisible(true);
    }
    
    
    /** returns number of teams in contest */
    public int GetTeams() { return teams; }

    /** returns minutes in contest */
    public int GetMinutes() { return minutes; }

    /** returns number of programming problems in contest */
    public int GetNumProgs() { return totalProgs; }
    
    /** returns number of advanced division programs in contest */
    public int GetAdvProgs() { return advProgs; }
    
    /** returns number of entry level division programs in contest */
    public int GetEntProgs() { return entProgs; }

    /** returns a boolean array where true elements represent advanced teams
     *  and false elements represent entry level teams; note that the 
     *  information for team 1 is located at index 0, etc.
     */
    public boolean[] GetTeamDivisions() { return teamAdvanced; }

    
    private class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            for (int x=0; x<teams; x++)
                if (e.getSource() == jcb[x]) {
                    teamAdvanced[x] = jcb[x].isSelected();
                }
        }
    }
    
    private class MyWindowListener implements WindowListener {
        public void windowActivated(WindowEvent e) { }
        public void windowClosed(WindowEvent e) { }
        public void windowClosing(WindowEvent e) { mc.Proceed(); }
        public void windowDeactivated(WindowEvent e) { }
        public void windowDeiconified(WindowEvent e) { }
        public void windowIconified(WindowEvent e) { }
        public void windowOpened(WindowEvent e) { }
    }
    

}
