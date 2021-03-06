/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import utilities.DataContainer;
import utilities.HandlerButton;

/**
 *
 * @author swans_000
 */
public class WindowMain extends javax.swing.JFrame {

    public static DataContainer dataBox;
    /**
     * Creates new form MainWindow
     */
    public WindowMain() {
        initComponents();
        myInit();
    }
    
    private void myInit(){
        dataBox = new DataContainer();
        dataBox.readXML();
        
        // Add Action events for menu items

        HandlerButton hb = new HandlerButton(this);
        addWindowListener(hb);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
        mnuitmEnd.setActionCommand("QUIT");
        mnuitmEnd.addActionListener(hb);
        
        MenuListener ml = new MenuListener();
        
        mnuitmSave.setActionCommand("Save");
        mnuitmSave.addActionListener(ml);
        
        // User forms
        menuItemNewClassroom.setActionCommand("New Classroom");
        menuItemNewClassroom.addActionListener(ml);
        menuItemNewStudent.setActionCommand("New Student");
        menuItemNewStudent.addActionListener(ml);
        menuItemNewTeacher.setActionCommand("New Teacher");
        menuItemNewTeacher.addActionListener(ml);
        menuItemNewCourse.setActionCommand("New Course");
        menuItemNewCourse.addActionListener(ml);
        
        // Reports
        mnuitmReportsStudents.setActionCommand("reportStudents");
        mnuitmReportsStudents.addActionListener(ml);
        mnuitmReportsFaculty.setActionCommand("reportFaculty");
        mnuitmReportsFaculty.addActionListener(ml);
        mnuitmReportsCourses.setActionCommand("reportCourses");
        mnuitmReportsCourses.addActionListener(ml);
        mnuitmReportsClassrooms.setActionCommand("reportClassrooms");
        mnuitmReportsClassrooms.addActionListener(ml);
        
        mnuitmEditGrades.setActionCommand("editGrades");
        mnuitmEditGrades.addActionListener(ml);
        
        // set bg to white
        getContentPane().setBackground(Color.WHITE);
        
        //StyledDocument
        txtareaBrief.setVisible(false);
        StyledDocument sDoc = txtPaneBrief.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        sDoc.setParagraphAttributes(0, sDoc.getLength(), center, false);
        
       
    }
    
    public DataContainer getDataContainer() {
        return dataBox;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lblWelcome = new javax.swing.JLabel();
        lblimgSchool = new javax.swing.JLabel();
        txtareaBrief = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPaneBrief = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuitmExit = new javax.swing.JMenu();
        mnuitmSave = new javax.swing.JMenuItem();
        mnuitmEnd = new javax.swing.JMenuItem();
        menuAdd = new javax.swing.JMenu();
        menuItemNewClassroom = new javax.swing.JMenuItem();
        menuItemNewCourse = new javax.swing.JMenuItem();
        menuItemNewTeacher = new javax.swing.JMenuItem();
        menuItemNewStudent = new javax.swing.JMenuItem();
        menuReports = new javax.swing.JMenu();
        mnuitmReportsClassrooms = new javax.swing.JMenuItem();
        mnuitmReportsCourses = new javax.swing.JMenuItem();
        mnuitmReportsFaculty = new javax.swing.JMenuItem();
        mnuitmReportsStudents = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        mnuitmEditGrades = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(DataContainer.APP_NAME);
        setBackground(new java.awt.Color(0, 204, 255));

        lblWelcome.setFont(new java.awt.Font("Vijaya", 1, 24)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome!");

        lblimgSchool.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblimgSchool.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/FilledSchoolClipart.jpg"))); // NOI18N

        txtareaBrief.setEditable(false);
        txtareaBrief.setColumns(20);
        txtareaBrief.setFont(new java.awt.Font("Segoe Script", 0, 13)); // NOI18N
        txtareaBrief.setLineWrap(true);
        txtareaBrief.setRows(5);
        txtareaBrief.setText("To get started, select from the menu bar above.");
        txtareaBrief.setWrapStyleWord(true);

        jScrollPane1.setBorder(null);

        txtPaneBrief.setEditable(false);
        txtPaneBrief.setBorder(null);
        txtPaneBrief.setFont(new java.awt.Font("Segoe Script", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, txtareaBrief, org.jdesktop.beansbinding.ELProperty.create("${text}"), txtPaneBrief, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(txtPaneBrief);

        mnuitmExit.setText("File");

        mnuitmSave.setText("Save");
        mnuitmExit.add(mnuitmSave);

        mnuitmEnd.setText("Exit");
        mnuitmExit.add(mnuitmEnd);

        jMenuBar1.add(mnuitmExit);

        menuAdd.setText("Add");

        menuItemNewClassroom.setText("New Classroom");
        menuAdd.add(menuItemNewClassroom);

        menuItemNewCourse.setText("New Course");
        menuAdd.add(menuItemNewCourse);

        menuItemNewTeacher.setText("New Teacher");
        menuAdd.add(menuItemNewTeacher);

        menuItemNewStudent.setText("New Student");
        menuAdd.add(menuItemNewStudent);

        jMenuBar1.add(menuAdd);

        menuReports.setText("Reports");

        mnuitmReportsClassrooms.setText("All Classrooms");
        menuReports.add(mnuitmReportsClassrooms);

        mnuitmReportsCourses.setText("All Courses");
        menuReports.add(mnuitmReportsCourses);

        mnuitmReportsFaculty.setText("All Faculty");
        menuReports.add(mnuitmReportsFaculty);

        mnuitmReportsStudents.setText("All Students");
        menuReports.add(mnuitmReportsStudents);

        jMenuBar1.add(menuReports);

        menuEdit.setText("Edit");

        mnuitmEditGrades.setText("Grades");
        menuEdit.add(mnuitmEditGrades);

        jMenuBar1.add(menuEdit);

        menuHelp.setText("Help");

        jMenuItem5.setText("About This Application");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuHelp.add(jMenuItem5);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblimgSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(txtareaBrief, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtareaBrief, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblimgSchool)
                .addGap(42, 42, 42))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        WindowAppInfo helpWindow = new WindowAppInfo();
        helpWindow.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new WindowMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblimgSchool;
    private javax.swing.JMenu menuAdd;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuItemNewClassroom;
    private javax.swing.JMenuItem menuItemNewCourse;
    private javax.swing.JMenuItem menuItemNewStudent;
    private javax.swing.JMenuItem menuItemNewTeacher;
    private javax.swing.JMenu menuReports;
    private javax.swing.JMenuItem mnuitmEditGrades;
    private javax.swing.JMenuItem mnuitmEnd;
    private javax.swing.JMenu mnuitmExit;
    private javax.swing.JMenuItem mnuitmReportsClassrooms;
    private javax.swing.JMenuItem mnuitmReportsCourses;
    private javax.swing.JMenuItem mnuitmReportsFaculty;
    private javax.swing.JMenuItem mnuitmReportsStudents;
    private javax.swing.JMenuItem mnuitmSave;
    private javax.swing.JTextPane txtPaneBrief;
    private javax.swing.JTextArea txtareaBrief;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            String strEvent = evt.getActionCommand();

            WindowReport reportWindow;
            switch(strEvent) {
                // All 'New X' menu selections:
                case "New Classroom":
                case "New Teacher":
                case "New Course":
                case "New Student":
                    WindowAddData adw = new WindowAddData(dataBox, strEvent);                    
                    adw.setVisible(true);
                    break;
                
                // Reports:
                case "reportStudents":
                    reportWindow = new WindowReport(dataBox, strEvent);
                    reportWindow.setVisible(true);
                    break;                
                case "reportFaculty":
                    reportWindow = new WindowReport(dataBox, strEvent);
                    reportWindow.setVisible(true);
                    break;
                case "reportCourses":
                    reportWindow = new WindowReport(dataBox, strEvent);
                    reportWindow.setVisible(true);
                    break;                    
                case "reportClassrooms":
                    reportWindow = new WindowReport(dataBox, strEvent);
                    reportWindow.setVisible(true);
                    break;
                    
                case "QUIT":
                    /**
                    * Todo: DOESN'T WORK
                    */
                    System.exit(0);
                    break;
                    
                case "Save":
                    DataContainer.writeXML();
                    break;
                    
                case "editGrades":
                    WindowEditStudentGrades editGradeWindow = new WindowEditStudentGrades(dataBox);
                    editGradeWindow.setVisible(true);
            }
        }
    }
    
}
