/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package views;

import utilities.NoDataException;
import baseclasses.Classroom;
import baseclasses.OfferedClass;
import java.awt.Component;
import java.util.ArrayList;
import utilities.Clearable;
import utilities.DataContainer;
import utilities.ModelMyComboBox;
import utilities.ModelMyList;

/**
 *
 * @author swans_000
 */
public class PanelNewCourse extends javax.swing.JPanel implements Clearable {

    private DataContainer dc;
    /**
     * Creates new form NewCoursePanel
     */
    public PanelNewCourse() {
        initComponents();
        

    }

    public PanelNewCourse(DataContainer data){
        initComponents();
        dc = data;
        
        ArrayList<Classroom> roomList = dc.getClassrooms();
        
        ModelMyComboBox cmbModel = new ModelMyComboBox(roomList);
        cmbClassroom.setModel(cmbModel);

        for(Classroom room : roomList){
            cmbClassroom.addItem(room);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCourseName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCourseIDNumber = new javax.swing.JTextField();
        lblCourseIDNumber = new javax.swing.JLabel();
        cmbClassroom = new javax.swing.JComboBox();
        lblClassroom = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();

        txtCourseName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel1.setLabelFor(txtCourseName);
        jLabel1.setText("Course Name:");

        txtCourseIDNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        lblCourseIDNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCourseIDNumber.setText("ID:");

        cmbClassroom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbClassroom.setName(""); // NOI18N
        cmbClassroom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbClassroomFocusGained(evt);
            }
        });

        lblClassroom.setLabelFor(cmbClassroom);
        lblClassroom.setText("Classroom:");

        btnAdd.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 90, 150));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCourseIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClassroom, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCourseIDNumber, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbClassroom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addGap(121, 121, 121)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCourseIDNumber))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClassroom))
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        

        try {
            checkFields(); // throws NoDataException
            OfferedClass oc = new OfferedClass();
            oc.setClassIdNumber(Float.valueOf(txtCourseIDNumber.getText()));
            oc.setClassName(txtCourseName.getText());
            oc.setClassroom((Classroom)cmbClassroom.getSelectedItem());

            // add the object to the ArrayList, then clear the form
            if(WindowMain.dataBox.getCourses().add(oc) == true){
                WindowMain.dataBox.hasNewData = true;
                clearData();
            }
        } catch (NoDataException e) {
            e.promptForFields();
        } catch (NumberFormatException e) {
            NoDataException nde = new NoDataException("ID");
            //nde.promptForFields();
        }
        

        
    }//GEN-LAST:event_btnAddActionPerformed

    private void cmbClassroomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbClassroomFocusGained
        /*
        cmbClassroom.removeAllItems(); // Clear combobox
        
        // Add each value to the combobox when combobox is selected
        for (Classroom c : WindowMain.dataBox.getClassrooms()) {
            cmbClassroom.addItem(c);
        }*/
    }//GEN-LAST:event_cmbClassroomFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox cmbClassroom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblClassroom;
    private javax.swing.JLabel lblCourseIDNumber;
    private javax.swing.JTextField txtCourseIDNumber;
    private javax.swing.JTextField txtCourseName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clearData() {
        txtCourseIDNumber.setText(null);
        txtCourseName.setText(null);
        cmbClassroom.setSelectedItem(null);
    }
    
    public void checkFields() throws NoDataException {
        
        ArrayList<String> fieldNames = new ArrayList();
        
        if (txtCourseName.getText().equals("")){
            fieldNames.add("Course Name");           
        }
        if (txtCourseIDNumber.getText().equals("") || Float.valueOf(txtCourseIDNumber.getText()).isNaN()) {
            fieldNames.add("ID");
        }

        if (fieldNames.size() > 0) 
            throw new NoDataException(fieldNames);
            
        
    }

    @Override
    public Component[] clearableItems() {
        return new Component[]{txtCourseIDNumber, txtCourseName, cmbClassroom};
    }
}
