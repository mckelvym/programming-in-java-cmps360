/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj2
 * Date Assigned:   Thursday, 22 March 2007, 12:00 AM
 * Due date:        Monday, 16 April 2007, 08:00 PM
 * Description:
 * Gives the user the option of creating a new test, administering a test, or
 * grading a test. The user will be prompted for input of relevant filenames before
 * continuing.
 */	

package proj2;

/**
 * Gives the user the option of creating a new test, administering a test, or
 * grading a test. The user will be prompted for input of relevant filenames before
 * continuing.
 * @author  mark
 */
public class Main extends javax.swing.JFrame {
    
    /** Creates new form Main */
    public Main() {
        initComponents();
        centerApp();
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
        testingPanel = new javax.swing.JPanel();
        createNewTest = new javax.swing.JButton();
        administerTest = new javax.swing.JButton();
        gradeTest = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        about = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test Management System");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        testingPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        testingPanel.setToolTipText("Test handling options");
        testingPanel.setName("Testing");
        createNewTest.setText("Create New Test");
        createNewTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCreate(evt);
            }
        });

        administerTest.setText("Administer Test");
        administerTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administerTestActionPerformed(evt);
            }
        });

        gradeTest.setText("Grade Test");
        gradeTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testingPanelLayout = new javax.swing.GroupLayout(testingPanel);
        testingPanel.setLayout(testingPanelLayout);
        testingPanelLayout.setHorizontalGroup(
            testingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testingPanelLayout.createSequentialGroup()
                .addGroup(testingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(createNewTest, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addGroup(testingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(administerTest, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gradeTest, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                .addContainerGap())
        );
        testingPanelLayout.setVerticalGroup(
            testingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createNewTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(administerTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradeTest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.setFont(new java.awt.Font("Granada", 1, 24));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Testing Management System");
        title.setToolTipText("TMS software control center.");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(title)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(about)
                            .addGap(239, 239, 239)
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(testingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(about)
                    .addComponent(exit))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        this.setVisible(false);
        new About(this);
    }//GEN-LAST:event_aboutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void gradeTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeTestActionPerformed
        this.setVisible(false);
        String filename1 = javax.swing.JOptionPane.showInputDialog(this, "Please input filename for key.");
        String filename2 = javax.swing.JOptionPane.showInputDialog(this, "Please enter the name of the test file.");
        new GradeTest(this,filename1, filename2);
    }//GEN-LAST:event_gradeTestActionPerformed

    private void administerTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administerTestActionPerformed
        this.setVisible(false);
        String filename1 = javax.swing.JOptionPane.showInputDialog(this, "Please input filename for this test source.");
        String filename2 = javax.swing.JOptionPane.showInputDialog(this, "Please enter the name of the file where answers will be saved.");
        new TestStudent(this,filename1, filename2);
    }//GEN-LAST:event_administerTestActionPerformed

    private void showCreate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCreate
        this.setVisible(false);
        String filename = javax.swing.JOptionPane.showInputDialog(this, "Please input filename for this test question set.");
        new Create(this,filename);
    }//GEN-LAST:event_showCreate
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton about;
    private javax.swing.JButton administerTest;
    private javax.swing.JButton createNewTest;
    private javax.swing.JButton exit;
    private javax.swing.JButton gradeTest;
    private javax.swing.JPanel testingPanel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    
}
