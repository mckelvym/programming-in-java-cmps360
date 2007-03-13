/*
 * Main(Contest).java v1.0
 *
 * Created on July 18, 2004, 12:01 AM
 * 
 */

package contesttimer;

import javax.swing.*;


/** Program to perform bookkeeping operations for a timed programming contest of
 *  up to 100 teams in two divisions, with an overlaping problem set.  Teams
 *  receive all programs at once and the clock runs on all solutions at once.
 *  Solutions submitted for judging have the clock suspended.  Solutions judged
 *  to be correct have the clock permenately stopped.  Solutions judged to be
 *  incorrect have the clock restarted.  The winning team in each division is
 *  the team that solves the most problems in the least time.  
 *
 *  Running contest backup files are backup1.txt and backup2.txt.  These files 
 *  are updated alternately once each minute.
 *
 *  If saved, statistics from the contest are placed in GameStats.csv and may
 *  be loaded into any spreadsheet.
 *
 *  This program was written in Sun Java 2 SDK 1.4.2_04.
 *
 * @author  Frank Ducrest
 */
public class Main extends Thread {
    BasicInfo bi;
    ContestControl cc;
    MasterControl mc;
    
    /** Creates a new instance of Main (Contest) and starts run() */
    public Main() {
        start();
    }
    
    /** master method of the bookkeeping system, instantiates and regulates 
     *  the startup sequence and the contest controller.
     */
    public void run() {
        int choice;
        
        mc = new MasterControl();
        bi = new BasicInfo(mc);
        choice = JOptionPane.showConfirmDialog(null, 
                    "Programming Contest Bookkeeping Program\n\n" +
                    "You may load an existing contest from a backup or\n" +
                    "you may begin a contest from scratch.  If you begin\n" +
                    "a contest from scratch, any saved data from a\n" +
                    "previous contest will be lost.\n\n" +
                    "Load existing contest from backup?", 
                    "Load a Contest from Backup or Make a New Contest?", 
                    JOptionPane.YES_NO_OPTION); 
        if (choice != JOptionPane.YES_OPTION) {
            if (!bi.QueryUser())
                System.exit(0);
            bi.start();
            mc.Pause(); 
            cc = new ContestControl(bi);
        } else
            cc = new ContestControl();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main contest = new Main();
    }
    
}
