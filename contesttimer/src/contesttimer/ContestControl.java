/*
 * ContestControl.java v1.0
 *
 * Created on July 18, 2004, 12:01 AM
 */

package contesttimer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author  Frank Ducrest
 */
public class ContestControl extends JFrame {
    private int teams;
    private int minutes;
    private int totalProgs;
    private int advProgs;
    private int entProgs;
    private boolean teamAdvanced[];    
    
    private TimerActionListener tal;
    private Timer minuteMan;  
    private boolean timerOn;

    private Container c;
    private MainWindowListener mwl;
    
    private JButton toggleTimer;
    private JButton saveGame;
    private JButton showResults;
    private JButton saveResults;
    private JButton exitGame;
    private ButtonListener bl;
    private JPanel northPanel;

    private JComboBox pickTeam;
    private TeamItemListener til;
    private Team []teamList;
    private Team teamPicked;
    private int display = 0;
    private int timeLeft = 0;
    private JLabel timerLabel;
    
    private boolean backupToggle = true;
    
    private StatFrame statFrame;
    
    /** Creates a new instance of ContestControl */
    public ContestControl() {
        mwl = new MainWindowListener();
        addWindowListener(mwl);
        
        File f1 = new File("backup1.txt");
        File f2 = new File("backup2.txt");
        FileReader fr;
        
        try {
            
            if (f1.isFile() && f2.isFile()) {
                if (f1.lastModified() > f2.lastModified())
                    fr = new FileReader("backup1.txt");        
                else
                    fr = new FileReader("backup2.txt");        
            } else if (f1.isFile())
                fr = new FileReader("backup1.txt");        
            else 
                fr = new FileReader("backup2.txt");        
        
            BufferedReader br = new BufferedReader(fr);
            teams = Integer.parseInt(br.readLine());
            timeLeft = minutes = Integer.parseInt(br.readLine());
            totalProgs = Integer.parseInt(br.readLine());
            advProgs = Integer.parseInt(br.readLine());
            entProgs = Integer.parseInt(br.readLine());
        
            timerOn = false;
        
            SetFrame();        
            ReadTeams(br);
            br.close();
            SetFrameButtons();
            ActivateTimer();
            setVisible(true);        
            
        } catch (Exception e) {
            System.exit(0);
        }
        
    }

    public ContestControl(BasicInfo bi) {
        mwl = new MainWindowListener();
        addWindowListener(mwl);
        
        teams = bi.GetTeams();
        minutes = bi.GetMinutes();
        totalProgs = bi.GetNumProgs();
        advProgs = bi.GetAdvProgs();
        entProgs = bi.GetEntProgs();
        teamAdvanced = bi.GetTeamDivisions();
        timerOn = false;
        timeLeft = minutes;
        
        SetFrame();        
        SetTeams();
        SetFrameButtons();
        ActivateTimer();
        setVisible(true);
    }

    private void SetFrame() { 
        setLocation(100,100);
        setSize(650,400);
        c = getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(Color.RED);
    }

    private void ReadTeams(BufferedReader br) {
        int number, division, numProgs, startnum;
        int state, minutes, pnumber;
        String line = null;
        Problem p;

        teamList = new Team[teams];
        for (int x=0; x<teams; x++) {
            try {
                line = br.readLine();
            } catch (Exception e) {
                System.exit(0);
            }
            StringTokenizer st = new StringTokenizer(line);

            number = Integer.parseInt(st.nextToken());
            division = Integer.parseInt(st.nextToken());
            numProgs = Integer.parseInt(st.nextToken());
            startnum = Integer.parseInt(st.nextToken());

            teamList[x] = new Team(number,division,numProgs,startnum);
            
            
            for (int y=0; y<numProgs; y++) {
                state = Integer.parseInt(st.nextToken());
                minutes = Integer.parseInt(st.nextToken());   
                pnumber = Integer.parseInt(st.nextToken());
                
                teamList[x].AddProblem(y, state, minutes, pnumber);
            }
            
        }
        display = 0;
        c.add(teamList[display],BorderLayout.CENTER);
        teamList[display].SetVisible(true);
    }
    
    
    private void SetTeams() {
        teamList = new Team[teams];
        for (int x=0; x<teams; x++) {
            if (teamAdvanced[x])
                teamList[x] = new Team(x+1,2,advProgs,totalProgs-advProgs+1);
            else
                teamList[x] = new Team(x+1,1,entProgs,1);
        }
        display = 0;
        c.add(teamList[display],BorderLayout.CENTER);
        teamList[display].SetVisible(true);
    }
        
    private void SetFrameButtons() {
        toggleTimer = new JButton("Start Timer");
        saveGame    = new JButton("Backup Game");
        showResults = new JButton("Show Stats ");
        saveResults = new JButton("Save Stats ");
        exitGame    = new JButton("Exit Game  ");
        timerLabel  = new JLabel(Integer.toString(timeLeft));
        
        bl = new ButtonListener();
        toggleTimer.addActionListener(bl);
        saveGame.addActionListener(bl);
        showResults.addActionListener(bl);
        saveResults.addActionListener(bl);
        exitGame.addActionListener(bl);
        
        pickTeam = new JComboBox();       
        for (int x=0; x<teams; x++)
            pickTeam.addItem(Integer.toString(x+1));
        til = new TeamItemListener();
        pickTeam.addItemListener(til);
        
        northPanel = new JPanel();
        northPanel.setBackground(Color.YELLOW);
        //northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.setLayout(new FlowLayout());
        northPanel.add(toggleTimer);
        northPanel.add(saveGame);
        northPanel.add(pickTeam);
        northPanel.add(showResults);
        northPanel.add(saveResults);
        northPanel.add(exitGame);
        northPanel.add(timerLabel);
        
        c.add(northPanel,BorderLayout.NORTH);
        
        
    }
    
    private void ActivateTimer() {
        tal = new TimerActionListener();
        minuteMan = new Timer(60000,tal); 
        timerOn = false;
    }
    
    private void BackupGame() {
        FileWriter writer;
        
        try {
            if (backupToggle) 
                writer = new FileWriter("backup1.txt");
            else
                writer = new FileWriter("backup2.txt");
        } catch (Exception e) {
            return;
        }
        BufferedWriter bw = new BufferedWriter(writer);
        PrintWriter pw = new PrintWriter(bw);
        
        pw.println(teams);
        pw.println(timeLeft);
        pw.println(totalProgs);
        pw.println(advProgs);
        pw.println(entProgs);
        for (int x=0; x<teams; x++) {
            teamList[x].WriteTeam(pw);
            pw.print("\n");
        }
        
        pw.close();
        backupToggle = !backupToggle;        
    }

    private void ShowResults() {
        statFrame = new StatFrame(("Game Standings at " + timeLeft),
                                  totalProgs,
                                  teams,
                                  teamList
                                 );
        statFrame.show();
    }
    
    private void SaveResults() {
        new StatWriter(("Game Standings at " + timeLeft),
                                  totalProgs,
                                  teams,
                                  teamList
                                 );
    }

    
    private void FinalResults() {
        new FinalStatWriter(("Game Standings at " + timeLeft),
                                  totalProgs,
                                  teams,
                                  teamList
                                 );
    }
    
  
    
    private class TimerActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int x=0; x<teams; x++)
                teamList[x].AddMinute();

            timeLeft--;
            northPanel.remove(timerLabel);
            timerLabel  = new JLabel(Integer.toString(timeLeft));
            northPanel.add(timerLabel);
            northPanel.setVisible(false);
            northPanel.setVisible(true);
             
            if (timeLeft == 0) {
                minuteMan.stop();
                northPanel.remove(toggleTimer);
                northPanel.setVisible(false);
                northPanel.setVisible(true);
            }

            BackupGame();
        }
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == toggleTimer) {

                northPanel.removeAll();
                timerOn = !timerOn;
                if (timerOn) {
                    toggleTimer = new JButton("Stop Timer");
                    timerLabel  = new JLabel(Integer.toString(timeLeft));
                    minuteMan.start();
                }
                else {
                    toggleTimer = new JButton("Start Timer");
                    timerLabel  = new JLabel(Integer.toString(timeLeft));
                    minuteMan.stop();
                }
           
                toggleTimer.addActionListener(bl);
                northPanel.add(toggleTimer);
                northPanel.add(saveGame);
                northPanel.add(pickTeam);
                northPanel.add(showResults);
                northPanel.add(saveResults);
                northPanel.add(exitGame);
                northPanel.add(timerLabel);
                
                northPanel.setVisible(false);
                northPanel.setVisible(true);

            } else if (e.getSource() == saveGame) { 
                BackupGame();
            } else if (e.getSource() == showResults) {
                ShowResults();
            } else if (e.getSource() == saveResults) {
                SaveResults();
            } else if (e.getSource() == exitGame) {
                if (JOptionPane.showConfirmDialog(null, 
                    "Exit the Program?", "Exit the Program?", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        if (!timerOn) minuteMan.stop();
                        BackupGame();
                        FinalResults();
                        System.exit(0);
                }
            }
        }
    }

    private class TeamItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            c.remove(teamList[display]);
            display = Integer.parseInt((String)e.getItem()) - 1;
            c.add(teamList[display],BorderLayout.CENTER);
            teamList[display].SetVisible(true);
        }
    }
    
    
    private class MainWindowListener implements WindowListener {
        public void windowActivated(WindowEvent e)   {}
        public void windowClosed(WindowEvent e)      {}
        public void windowClosing(WindowEvent e)     {
            if (!timerOn) minuteMan.stop();
            BackupGame();
            FinalResults();
            System.exit(0);
        }
        public void windowDeactivated(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowIconified(WindowEvent e)   {}
        public void windowOpened(WindowEvent e)      {}
    }
    
}
