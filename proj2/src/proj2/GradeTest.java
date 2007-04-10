/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj2
 * Date Assigned:   Thursday, 22 March 2007, 12:00 AM
 * Due date:        Monday, 16 April 2007, 08:00 PM
 * Description:
 * Allows an administrator to grade a test by loading up the answer key and a file
 * that contains answers from a student's test. The module keeps track of questions
 * and points earned as well as points possible. The administrator can change the
 * number of points awarded at any time, but multiple choice and fill in the blank
 * type questions are automatically scored for correctness.
 */	

package proj2;

import java.io.*;

/**
 * Allows an administrator to grade a test by loading up the answer key and a file
 * that contains answers from a student's test. The module keeps track of questions
 * and points earned as well as points possible. The administrator can change the
 * number of points awarded at any time, but multiple choice and fill in the blank
 * type questions are automatically scored for correctness.
 * @author  mark
 */
public class GradeTest extends javax.swing.JFrame {
    /**
     *Parent window, used for setting visible when this one is disposed.
     */
    private javax.swing.JFrame myparent;
    
    /**
     *Test key filename
     */
    private String key;
    
    /**
     *Test answers filename
     */
    private String test;
    
    /**
     *Readers for the test key and test answers files.
     */
    private BufferedReader r_key, r_test;
    
    /**
     *Temporary variable where the questions are stored.
     */
    private Question set;
    
    /**
     *Keeps track of current question that the user is on.
     */
    private int count = 1;
    
    /**
     *Keeps track of the total number of questions.
     */
    private int count_total = 0;
    
    /**
     *Keeps track of the total possible points for a test.
     */
    private int points_possible_total = 0;
    
    /**
     *Keeps track of the total points awarded for a test
     */
    private int points_earned_total = 0;
        
    /** Creates new form GradeTest */
    public GradeTest(javax.swing.JFrame parent, String key, String test) {
        myparent = parent;
        this.key = key;
        this.test = test;
        mainInitialization();
    }
    
    /**
     *Opens relevant files for reading, reads questions in, initializes components,
     *centers the window, sets up the first question, then displays this window
     */
    public void mainInitialization(){
        if(openFiles() == false){
            javax.swing.JOptionPane.showMessageDialog(this, "Error opening file(s). Quitting.");
            quit();
        }
        readQuestions();
        initComponents();
        centerApp();
           
        setupQuestion();
        
        this.setVisible(true);
    }
         
    /**
     *Opens the files for reading.
     */
    public boolean openFiles(){
        boolean success = true;
        r_key = null;
        r_test = null;
        
        try{
            r_key = new BufferedReader(new FileReader(key));
            r_test = new BufferedReader(new FileReader(test));
        }catch(Exception e){
            e.printStackTrace();
            success = false;
        }        
        return success;
    }
    
    /**
     *Closes the readers, sets the parent visible, disposes of self.
     */
    public void quit(){
        try{ r_key.close(); }catch(Exception e){e.printStackTrace();}
        try{ r_test.close(); }catch(Exception e){e.printStackTrace();}
        myparent.setVisible(true);
        dispose();
    }
    
    /**
     *Centers the window on the screen.
     */
    private void centerApp(){
        java.awt.Dimension screenSize = this.getToolkit().getScreenSize();
        java.awt.Dimension appSize = this.getSize();
        this.setLocation((screenSize.width - appSize.width) / 2,(screenSize.height - appSize.height) / 2);
    }
    
    /**
     *Sets up each question and clears/resets all relevant fields.
     */
    private void setupQuestion(){
        questionNumValue.setText(String.valueOf(count) + "/" + String.valueOf(count_total));
        pointsEarnedValue.setText(String.valueOf(points_earned_total));
        pointsPossibleValue.setText(String.valueOf(points_possible_total));
        percentageValue.setText(String.valueOf(((float)points_earned_total/(float)points_possible_total)*100));
        worthValue.setText(String.valueOf(set.points));
                
        if(set.type.equals("choice")){
            questionValue.setText(set.question_value.substring(2, set.question_value.indexOf(";")));
        }
        else if(set.type.equals("blank")){
            questionValue.setText(set.question_value.substring(2).replace("_","_____"));
        }
        else{
            questionValue.setText(set.question_value.substring(2));
        }
        correctAnswerValue.setText(set.answer_value.substring(2));
        studentAnswerValue.setText(set.student_answer_value.substring(2));
        
        if(!set.type.equals("essay") && !correctAnswerValue.getText().equals(studentAnswerValue.getText())){
            awardedValue.setText("0");
        }
        else awardedValue.setText(String.valueOf(set.points_awarded));
        
        
    }

     /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        statsPanel = new javax.swing.JPanel();
        questionNum = new javax.swing.JLabel();
        questionNumValue = new javax.swing.JLabel();
        pointsEarned = new javax.swing.JLabel();
        pointsEarnedValue = new javax.swing.JLabel();
        pointsPossible = new javax.swing.JLabel();
        pointsPossibleValue = new javax.swing.JLabel();
        percentage = new javax.swing.JLabel();
        percentageValue = new javax.swing.JLabel();
        percentageSymbol = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        nextQuestion = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        worth = new javax.swing.JLabel();
        awarded = new javax.swing.JLabel();
        worthValue = new javax.swing.JLabel();
        awardedValue = new javax.swing.JTextField();
        question = new javax.swing.JLabel();
        correctAnswer = new javax.swing.JLabel();
        studentAnswer = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        questionValue = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        correctAnswerValue = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentAnswerValue = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        statsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        questionNum.setText("Question #");

        questionNumValue.setText("jLabel1");

        pointsEarned.setText("Points Earned:");

        pointsEarnedValue.setText("jLabel2");

        pointsPossible.setText("Points Possible:");

        pointsPossibleValue.setText("jLabel1");

        percentage.setText("Percentage:");

        percentageValue.setText("jLabel1");

        percentageSymbol.setText("%");

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(questionNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionNumValue))
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(pointsEarned)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pointsEarnedValue))
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(pointsPossible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pointsPossibleValue))
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(percentage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(percentageValue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(percentageSymbol)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionNum)
                    .addComponent(questionNumValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pointsEarned)
                    .addComponent(pointsEarnedValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pointsPossible)
                    .addComponent(pointsPossibleValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percentage)
                    .addComponent(percentageValue)
                    .addComponent(percentageSymbol)))
        );

        nextQuestion.setText("Next");
        nextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionActionPerformed(evt);
            }
        });

        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addComponent(nextQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quit))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nextQuestion)
                .addComponent(quit))
        );

        worth.setText("This Question's Worth:");

        awarded.setText("Points Awarded:");

        worthValue.setText("jLabel3");

        awardedValue.setColumns(5);
        awardedValue.setText("jTextField1");

        question.setText("Question:");

        correctAnswer.setText("Correct Answer:");

        studentAnswer.setText("Student Answer:");

        questionValue.setColumns(20);
        questionValue.setEditable(false);
        questionValue.setLineWrap(true);
        questionValue.setRows(5);
        questionValue.setWrapStyleWord(true);
        questionValue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(questionValue);

        correctAnswerValue.setColumns(20);
        correctAnswerValue.setEditable(false);
        correctAnswerValue.setLineWrap(true);
        correctAnswerValue.setRows(5);
        correctAnswerValue.setWrapStyleWord(true);
        correctAnswerValue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(correctAnswerValue);

        studentAnswerValue.setColumns(20);
        studentAnswerValue.setEditable(false);
        studentAnswerValue.setLineWrap(true);
        studentAnswerValue.setRows(5);
        studentAnswerValue.setWrapStyleWord(true);
        studentAnswerValue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane4.setViewportView(studentAnswerValue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(worth)
                                    .addComponent(awarded))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(worthValue)
                                    .addComponent(awardedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(statsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(question)
                        .addContainerGap(362, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(correctAnswer)
                        .addContainerGap(323, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(studentAnswer)
                        .addContainerGap(320, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(worth)
                            .addComponent(worthValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(awarded)
                            .addComponent(awardedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(question)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(correctAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *Quit button pushed, calls quit()
     */
    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        quit();
    }//GEN-LAST:event_quitActionPerformed

    /**
     *Handles moving to evaluation of next question. Keeps track of points.
     *When all questions have been viewed/graded, displays a summary dialog
     *to the user.
     */
    private void nextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionActionPerformed
        count++;
        set.points_awarded = Integer.parseInt(awardedValue.getText());
        points_earned_total += set.points_awarded;
        points_possible_total += set.points;
        if(set.next != null && set.next.question_value != null){
            set = set.next;
            setupQuestion();
        }
        else{
            this.setVisible(false);
            javax.swing.JOptionPane.showMessageDialog(this, "This test has been graded.\nPoints Possible: " 
                    + points_possible_total + "\nPoints Awarded: " + points_earned_total + "\nPercentage: " 
                    + ((float)points_earned_total/(float)points_possible_total)*100 + "%");   
            quit();
        }
    }//GEN-LAST:event_nextQuestionActionPerformed

    /**
     *Called when the window is closing, calls quit()
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        quit();
    }//GEN-LAST:event_formWindowClosing
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel awarded;
    private javax.swing.JTextField awardedValue;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel correctAnswer;
    private javax.swing.JTextArea correctAnswerValue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton nextQuestion;
    private javax.swing.JLabel percentage;
    private javax.swing.JLabel percentageSymbol;
    private javax.swing.JLabel percentageValue;
    private javax.swing.JLabel pointsEarned;
    private javax.swing.JLabel pointsEarnedValue;
    private javax.swing.JLabel pointsPossible;
    private javax.swing.JLabel pointsPossibleValue;
    private javax.swing.JLabel question;
    private javax.swing.JLabel questionNum;
    private javax.swing.JLabel questionNumValue;
    private javax.swing.JTextArea questionValue;
    private javax.swing.JButton quit;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JLabel studentAnswer;
    private javax.swing.JTextArea studentAnswerValue;
    private javax.swing.JLabel worth;
    private javax.swing.JLabel worthValue;
    // End of variables declaration//GEN-END:variables
    
    /**
     *A temporary class for storing information about each question.
     */
    private class Question{
        public String type;
        public int points;
        public int points_awarded;
        public String question_value;
        public String answer_value;
        public String student_answer_value;
        public Question next;
        public Question prev;
    }
    
    /**
     *Reads into temporary variables the questions, right answers, and student
     *answers for later comparison.
     */
    private void readQuestions(){
        String tmp;
        Question q = new Question();
        q.prev = null;
        q.next = null;
        
        try{
            while((tmp = r_key.readLine()) != null){
                count_total++;
                q.type = tmp;
                q.points = Integer.parseInt(r_key.readLine());
                q.points_awarded = q.points;
                q.question_value = r_key.readLine();
                while(!(tmp = r_key.readLine()).startsWith("--")){
                    q.question_value += tmp;
                }
                q.answer_value = tmp;
                q.next = new Question();
                q.next.prev = q;
                q.next.next = null;
                q = q.next;
            }   
            while(q.prev != null){
                q = q.prev;
            }
            while((tmp = r_test.readLine()) != null){
                q.student_answer_value = tmp;
                while(!(tmp = r_test.readLine()).startsWith("++")){
                    q.student_answer_value += tmp;
                }
                q = q.next;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        while(q.prev != null){
            q = q.prev;
        }        
        set = q;
    }
}
