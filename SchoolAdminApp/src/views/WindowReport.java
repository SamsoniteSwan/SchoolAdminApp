/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package views;

import baseclasses.Classroom;
import baseclasses.Faculty;
import baseclasses.OfferedClass;
import baseclasses.Student;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import utilities.HandlerButton;
import utilities.DataContainer;
import utilities.DateUtils;

/**
 *
 * @author swans_000
 */
public class WindowReport extends javax.swing.JFrame { //implements java.awt.event.ActionListener {

    /**
     * Creates new form ReportFrameTwo
     */
    public WindowReport() {
        initComponents();
        myInit();
    }
    
    public WindowReport(DataContainer dataBox, String openTo) {
        initComponents();
        myInit();
        
        
        DefaultTableModel defTblModel = new DefaultTableModel();
        
        // set String arrays of column names
        String[] personHeaders = {"SSN", "Name", "DOB", "Address"};
        String[] facultyHeaders = {"Hire Date", "Termination Date", "Salary", "Status", "Classes"};
        String[] studentHeaders = {"Grad Date", "GPA", "Classes"};
        String[] classroomHeaders = {"Room Number", "Type"};
        String[] courseHeaders = {"Course ID", "Name", "Classroom"};
        
        tableGeneric.setModel(defTblModel);
        
        // Add the general 'Person' fields
        if (openTo.compareTo("reportStudents")== 0 || openTo.compareTo("reportFaculty") == 0){
                for(String s : personHeaders){
                    defTblModel.addColumn(s);
                }
        }
        
        Vector lineItem;
        // use switch on openTo to set the label, and populate the default table
        switch (openTo) {
            
            case "reportStudents":
                lblDataName.setText("All Students");
                for(String s : studentHeaders) {
                    defTblModel.addColumn(s);
                }
                ArrayList<Student> sList = dataBox.getStudents();
                for(Student s : sList) {
                    lineItem = new Vector();
                    lineItem.add(s.getSocialSecurityNumber());
                    lineItem.add(s.getName());
                    lineItem.add(DateUtils.mdyyyy(s.getDateOfBirth()));
                    lineItem.add(s.getAddress());
                    lineItem.add(DateUtils.ddmmyy(s.getDateOfGraduation()));
                    lineItem.add(s.getCurrentGPA());
                    lineItem.add(s.getClasses().toString().substring(
                            1, s.getClasses().toString().length() - 1));
                    defTblModel.addRow(lineItem);
                }
                break;
                
            case "reportFaculty":
                lblDataName.setText("All Faculty");
                
                for(String s : facultyHeaders) {
                    defTblModel.addColumn(s);
                }
                ArrayList<Faculty> fList = dataBox.getFaculty();
                for(Faculty f : fList){
                    lineItem = new Vector();
                    lineItem.add(f.getSocialSecurityNumber());
                    lineItem.add(f.getName());
                    lineItem.add(DateUtils.mdyyyy(f.getDateOfBirth()));
                    lineItem.add(f.getAddress());
                    lineItem.add(DateUtils.ddmmyy(f.getDateOfHire()));
                    lineItem.add(DateUtils.ddmmyy(f.getDateOfTermination()));
                    lineItem.add(f.getSalary());
                    lineItem.add(String.valueOf(f.getStatus()));
                    String facClasses = f.getClasses().toString();
                    lineItem.add(facClasses.substring(
                            1, facClasses.length() - 1));
                    defTblModel.addRow(lineItem);
                }
                break;
                
            case "reportClassrooms":
                lblDataName.setText("All Classrooms");
                for(String s : classroomHeaders) {
                    defTblModel.addColumn(s);
                }
                ArrayList<Classroom> clList = dataBox.getClassrooms();
                for(Classroom cl : clList) {
                    lineItem = new Vector();
                    lineItem.add(cl.getRoomNumber());
                    lineItem.add(cl.getStatus());
                    defTblModel.addRow(lineItem);
                }
                break;
                
            case "reportCourses":
                lblDataName.setText("All Classes");
                for(String s : courseHeaders) {
                    defTblModel.addColumn(s);
                }
                ArrayList<OfferedClass> ocList = dataBox.getCourses();
                for(OfferedClass oc : ocList) {
                    lineItem = new Vector();
                    lineItem.add(oc.getClassIdNumber());
                    lineItem.add(oc.getClassName());
                    lineItem.add(oc.getClassroom());
                    defTblModel.addRow(lineItem);
                }
                break;         
        }
        
        tableGeneric.setModel(defTblModel);

    }
    
    public void myInit(){
        // prevent Java from closing out completely
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        HandlerButton bh = new HandlerButton(this);
        cmdClose.setActionCommand("Close");
        cmdClose.addActionListener(bh);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdClose = new javax.swing.JButton();
        lblDataName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGeneric = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmdClose.setText("Close");

        lblDataName.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        lblDataName.setText("Unknown Report");

        tableGeneric.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableGeneric);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDataName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdClose)
                    .addComponent(lblDataName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(WindowReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataName;
    private javax.swing.JTable tableGeneric;
    // End of variables declaration//GEN-END:variables

    /*
    @Override
    public void actionPerformed(ActionEvent evnt) {
           switch (evnt.getActionCommand()){
                case "Close":
                    this.dispose();
                    break;
           }
    }*/
}
