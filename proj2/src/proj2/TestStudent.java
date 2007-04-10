/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj2
 * Date Assigned:   Thursday, 22 March 2007, 12:00 AM
 * Due date:        Monday, 16 April 2007, 08:00 PM
 * Description:
 * This module tests the student by loading up questions from a key. The points
 * worth is displayed and the user sees the question and can input their answer.
 * For multiple choice questions radio buttons are displayed for the user to make
 * their choice. The user can move back and forward between the questions and their
 * answers are preserved. Once the user has cycled to the end of the question set,
 * the test terminates.
 */	

package proj2;

import java.io.*;
/**
 * This module tests the student by loading up questions from a key. The points
 * worth is displayed and the user sees the question and can input their answer.
 * For multiple choice questions radio buttons are displayed for the user to make
 * their choice. The user can move back and forward between the questions and their
 * answers are preserved. Once the user has cycled to the end of the question set,
 * the test terminates.
 * @author  mark
 */
public class TestStudent extends javax.swing.JFrame {
    /**
     *Parent window for displaying once this one is disposed.
     */
    private javax.swing.JFrame myparent;
    
    /**
     *Test source filename.
     */
    private String source;
    
    /**
     *Filename where the student's answers will reside.
     */
    private String dest;
    
    /**
     *A reader for the questions.
     */
    private BufferedReader reader;
    
    /**
     *A writer for the student's answers.
     */
    private PrintWriter writer;
    
    /**
     *A 'pointer' to the list of questions.
     */
    private Question set;
    
    /**
     *Keeps track of which question the student is currently on.
     */
    private int counter = 1;
    
    /**
     *Keeps track of how many questions total there are.
     */
    private int counter_total = 0;
    
    /**
     *A radio button group for the radio buttons so that only one is selected.
     */
    private javax.swing.ButtonGroup radioGroup;
    
    /** Creates new form TestStudent */
    public TestStudent(javax.swing.JFrame parent, String source, String dest) {
        myparent = parent;
        this.source = source;
        this.dest = dest;
        mainInitialization();
    }
    
    /**
     *Opens the relevant files for reading and writing. Reads the questions from
     *the correct file. Initializes the GUI components. Centers the window. Creates
     *a new radio group for the radio buttons. Begins to setup the first question,
     *then displays the frame.
     */
    public void mainInitialization(){
        if(openFiles() == false){
            javax.swing.JOptionPane.showMessageDialog(this, "Error opening file(s). Quitting.");
            quit();
        }
        readQuestions();
        initComponents();
        centerApp();
        
        radioGroup = new javax.swing.ButtonGroup();
        radioGroup.add(radio1);
        radioGroup.add(radio2);
        radioGroup.add(radio3);
        radioGroup.add(radio4);
        
        setupQuestion();
        
        this.setVisible(true);
    }

    /**
     *Opens the relevant files for reading & writing.
     */
    public boolean openFiles(){
        boolean success = true;
        writer = null;
        reader = null;
        
        try{
            writer = new PrintWriter(new BufferedWriter(new FileWriter(dest)));            
        }catch(Exception e){
            e.printStackTrace();
            success = false;
        }
        
        try{
            reader = new BufferedReader(new FileReader(source));
        }catch(Exception e){
            e.printStackTrace();
            success = false;
        }        
        return success;
    }

    /**
     *Called when the window is closed. Handles closing of readers/writers as well
     *as outputting student's answers to the right file. Sets parent window visible
     *before disposing self.
     */
    public void quit(){
        try{ reader.close(); }catch(Exception e){e.printStackTrace();}
        //write to file
        while(set.prev != null){
            set = set.prev;
        }
        while(set.next != null){
            writer.println("--" + set.answer_value);
            writer.println("++");
            set = set.next;
        }
        writer.close();
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        previousQuestion = new javax.swing.JButton();
        nextQuestion = new javax.swing.JButton();
        points = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        typeValue = new javax.swing.JLabel();
        pointsValue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionValue = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        answerValue = new javax.swing.JTextArea();
        questionNum = new javax.swing.JLabel();
        questionNumValue = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        choicePanel = new javax.swing.JPanel();
        radio1 = new javax.swing.JRadioButton();
        radio2 = new javax.swing.JRadioButton();
        radio3 = new javax.swing.JRadioButton();
        radio4 = new javax.swing.JRadioButton();
        answer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        previousQuestion.setText("Previous");
        previousQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestionActionPerformed(evt);
            }
        });

        nextQuestion.setText("Next");
        nextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionActionPerformed(evt);
            }
        });

        points.setText("Points:");

        question.setText("Question:");

        typeValue.setText("jLabel4");

        pointsValue.setText("jLabel5");

        jScrollPane1.setEnabled(false);
        questionValue.setColumns(20);
        questionValue.setEditable(false);
        questionValue.setLineWrap(true);
        questionValue.setRows(5);
        questionValue.setWrapStyleWord(true);
        questionValue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(questionValue);

        answerValue.setColumns(20);
        answerValue.setLineWrap(true);
        answerValue.setRows(5);
        answerValue.setWrapStyleWord(true);
        answerValue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(answerValue);

        questionNum.setText("Question #");

        questionNumValue.setText("jLabel8");

        type.setText("Type:");

        radio1.setText("jRadioButton1");
        radio1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radio1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        radio2.setText("jRadioButton2");
        radio2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radio2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        radio3.setText("jRadioButton3");
        radio3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radio3.setMargin(new java.awt.Insets(0, 0, 0, 0));

        radio4.setText("jRadioButton4");
        radio4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radio4.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout choicePanelLayout = new javax.swing.GroupLayout(choicePanel);
        choicePanel.setLayout(choicePanelLayout);
        choicePanelLayout.setHorizontalGroup(
            choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choicePanelLayout.createSequentialGroup()
                        .addComponent(radio1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radio2))
                    .addGroup(choicePanelLayout.createSequentialGroup()
                        .addComponent(radio3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radio4)))
                .addContainerGap())
        );
        choicePanelLayout.setVerticalGroup(
            choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio1)
                    .addComponent(radio2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(choicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio3)
                    .addComponent(radio4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        answer.setText("Your Answer:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(type)
                            .addComponent(points))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pointsValue)
                            .addComponent(typeValue)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionNumValue))
                    .addComponent(question)
                    .addComponent(answer)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(previousQuestion)
                        .addComponent(nextQuestion))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(questionNum)
                        .addComponent(questionNumValue, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type)
                    .addComponent(typeValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(points)
                    .addComponent(pointsValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(question)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *Called when window is closing, calls quit()
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        quit();
    }//GEN-LAST:event_formWindowClosing

    /**
     *Handles setting up of a question by clearing all relevant fields, updating
     *all important information, and handling for the type of question is done here.
     */
    private void setupQuestion(){
        questionNumValue.setText(String.valueOf(counter) + "/" + String.valueOf(counter_total));
        typeValue.setText(set.type);
        pointsValue.setText(String.valueOf(set.points));
        if(set.type.equals("choice")){
            answerValue.setVisible(false);
            choicePanel.setVisible(true);
            questionValue.setText(set.question_value.substring(2, set.question_value.indexOf(";")));
            String tmp[] = set.question_value.split(";");
            radioGroup.clearSelection();
            radio1.setVisible(false);
            radio2.setVisible(false);
            radio3.setVisible(false);
            radio4.setVisible(false);
            int limit = 5;
            if(tmp.length < limit){ limit = tmp.length; }
            for(int i = 1; i < limit; i++){
                switch(i){
                    case 1:
                        radio1.setText(tmp[i]);
                        radio1.setVisible(true);
                        break;
                    case 2:
                        radio2.setText(tmp[i]);
                        radio2.setVisible(true);
                        break;
                    case 3:
                        radio3.setText(tmp[i]);
                        radio3.setVisible(true);
                        break;
                    case 4:
                        radio4.setText(tmp[i]);
                        radio4.setVisible(true);
                        break;
                }
            }
            if(radio1.getText().equals(set.answer_value)){
                radio1.setSelected(true);
            }
            else if(radio2.getText().equals(set.answer_value)){
                radio2.setSelected(true);
            }
            else if(radio3.getText().equals(set.answer_value)){
                radio3.setSelected(true);
            }
            else if(radio4.getText().equals(set.answer_value)){
                radio4.setSelected(true);
            }
        }
        else{
            choicePanel.setVisible(false);
            answerValue.setVisible(true);
            questionValue.setText(set.question_value.substring(2).replace("_", "_____"));
            answerValue.setText(set.answer_value);
        }
    }
    
    /**
     *This is typically called before clearing all forms, it grabs the users answer
     *and stores it in a temporary variable to be saved later.
     */
    private void getAnswer(){
        if(choicePanel.isVisible()){
            if(radio1.isSelected()){
                set.answer_value = radio1.getText();
            }
            else if(radio2.isSelected()){
                set.answer_value = radio2.getText();
            }
            else if(radio3.isSelected()){
                set.answer_value = radio3.getText();
            }
            else if(radio4.isSelected()){
                set.answer_value = radio4.getText();
            }            
        }
        else{
            set.answer_value = answerValue.getText();
        }
        
    }
    
    /**
     *Used to cycle to the previous question
     */
    private void previousQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionActionPerformed
        getAnswer();
        if(set.prev != null){
            set = set.prev;
            counter--;
            setupQuestion();
        }
    }//GEN-LAST:event_previousQuestionActionPerformed

    /**
     *Used to cycle to the next qeustion
     */
    private void nextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionActionPerformed
        getAnswer();
        if(set.next != null && set.next.question_value != null){
            set = set.next;
            counter++;
            setupQuestion();            
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "You are done with the test.\nPlease notify the administrator.");
            quit();
        }
    }//GEN-LAST:event_nextQuestionActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answer;
    private javax.swing.JTextArea answerValue;
    private javax.swing.JPanel choicePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nextQuestion;
    private javax.swing.JLabel points;
    private javax.swing.JLabel pointsValue;
    private javax.swing.JButton previousQuestion;
    private javax.swing.JLabel question;
    private javax.swing.JLabel questionNum;
    private javax.swing.JLabel questionNumValue;
    private javax.swing.JTextArea questionValue;
    private javax.swing.JRadioButton radio1;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JRadioButton radio3;
    private javax.swing.JRadioButton radio4;
    private javax.swing.JLabel type;
    private javax.swing.JLabel typeValue;
    // End of variables declaration//GEN-END:variables
    
    /**
     *A temporary class for holding information about a question.
     */
    private class Question{
        public String type;
        public int points;
        public String question_value;
        public String answer_value;
        public Question next;
        public Question prev;
    }
    
    /**
     *Reads questions from a file and stores them in a temporary variable for
     *use later.
     */
    private void readQuestions(){
        String tmp;
        Question q = new Question();
        q.prev = null;
        q.next = null;
        
        try{
            while((tmp = reader.readLine()) != null){
                counter_total++;
                q.type = tmp;
                q.points = Integer.parseInt(reader.readLine());
                q.question_value = reader.readLine();
                while(!(tmp = reader.readLine()).startsWith("--")){
                    q.question_value += tmp;
                }
                q.answer_value="";
                q.next = new Question();
                q.next.prev = q;
                q.next.next = null;
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
