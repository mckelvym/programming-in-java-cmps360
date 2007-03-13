/*
 * Problem.java v1.0
 * 
 * Created on July 18, 2004, 12:01 AM
 */

package contesttimer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/** A instance of class Problem represents the time elapsed and status (running,
 *  paused for judging or solved) of the solution to one programming problem.
 *  Visually, the a JPanel of the problem number, the elapsed time and a
 *  button to toggle through the three possible states of the solution to the 
 *  programming problem.
 *
 * @author  Frank Ducrest
 */
public class Problem extends JPanel {
    private JLabel jml, jnl;
    private JButton jb;
    private MyActionListener mal;
    
    private int state;          // 0 is running, 1 is paused, 2 is solved
    private int minutes;
    private int number;
    private boolean visible;
        
    /** Creates a new instance of Problem from a state of Running and elapsed
     *  time of 0.
     */
    public Problem(int number) {
        mal = new MyActionListener();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.RED);
        //setSize(100, 50);

        state = 0;
        minutes = 0;
        this.number = number;
        visible = false;
    }
    
    /** Creates a new instance of Problem based on the state (running-0, 
     *  paused-1 or solved-2), the number of minutes that have already elpsed.
     */
    public Problem(int state, int minutes, int number) {
        mal = new MyActionListener();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.RED);

        this.state = state;
        this.minutes = minutes;
        this.number = number;
        visible = false;
    }

    private void SetProblemPanel() {
        jnl = new JLabel("#" + Integer.toString(number));
        jml = new JLabel("Time: " + Integer.toString(minutes));        
        jb = new JButton();
        jb.addActionListener(mal);

        if (state == 0)
            jb.add(new JLabel("Running"));
        else if (state == 1) 
            jb.add(new JLabel("Paused"));
        else
            jb.add(new JLabel("Solved"));

        add(jnl);     
        add(jb);
        add(jml);     
    }
    
    
    /** returns the number of minutes elapsed */
    public int GetMinutes(){
        return minutes;
    }
    
    
    /** returns true is the clock is paused for judging the problem solution, 
     *  false if not 
     */
    public boolean IsPaused() {
        return (state == 1);
    }
    
    /** returns true if the problem has been correctly solved, false if not */
    public boolean IsSolved() {
        return (state == 2);
    }
    
    /** outputs the state, minutes number of the problem the object represents
     */
    public void WriteProblem(PrintWriter pw) {
        pw.print(" ");
        pw.print(state);
        pw.print(" ");
        pw.print(minutes);
        pw.print(" ");
        pw.print(number);
    }
    
    
    /** adds one minute to the elapsed time taken to solve the problem */
    public void AddMinute() {
        minutes++;
        if (visible) {
            removeAll();
            SetProblemPanel();
            setVisible(false);
            setVisible(true);
        }
    }

    private void ToggleState() {
        state = (state+1) % 3;
    }
  
    /** updates the displayed information */
    public void SetVisible(boolean visible) {
        this.visible = visible;
        if (visible) {
            removeAll();
            SetProblemPanel();
            setVisible(false);
            setVisible(true);
        }
    }
  
    
    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jb) {
                ToggleState();
                removeAll();
                SetProblemPanel();
                setVisible(false);
                setVisible(true);
            }
        }
    }
    
    
}
