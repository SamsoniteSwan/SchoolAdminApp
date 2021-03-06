/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package views;

import utilities.NoDataException;
import baseclasses.OfferedClass;
import baseclasses.Person;
import baseclasses.Student;
import baseclasses.StudentClass;
import java.awt.Component;
import java.util.ArrayList;
import utilities.Clearable;
import utilities.DataContainer;
import utilities.DateUtils;
import utilities.FieldCheckable;
import utilities.ModelMyList;
import utilities.RendererCourseList;

/**
 *
 * @author swans_000
 */
public class PanelNewStudent extends javax.swing.JPanel implements Clearable, FieldCheckable {

    private DataContainer data;
    /**
     * Creates new form Panel1
     */
    public PanelNewStudent() {
        initComponents();
        

        
        
    }
    
    public PanelNewStudent(DataContainer dc) {
        initComponents();
        data = dc;
        ModelMyList myModel = new ModelMyList(data.getCourses());
        lstClasses.setModel(myModel);
        lstClasses.setCellRenderer(new RendererCourseList());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        lblGradDate = new javax.swing.JLabel();
        personPanel1 = new views.PanelPerson();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstClasses = new javax.swing.JList();
        lblClasses = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtGradDate = new javax.swing.JFormattedTextField();
        lblDOBFormat = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblGradDate.setLabelFor(txtGradDate);
        lblGradDate.setText("Graduation Date:");

        lstClasses.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstClasses);

        lblClasses.setLabelFor(lstClasses);
        lblClasses.setText("Courses:");

        btnAdd.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 90, 150));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtGradDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM/dd/yyyy"))));

        lblDOBFormat.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblDOBFormat.setText("(MM/DD/YYYY)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(personPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGradDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblDOBFormat))
                            .addComponent(txtGradDate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblClasses)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(208, 208, 208)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(personPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGradDate)
                            .addComponent(txtGradDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDOBFormat)))
                .addGap(18, 18, 18)
                .addComponent(lblClasses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
            checkFields();
            Student s = new Student();

            //Shared Person
            Person p = personPanel1.getPerson();
            s.setName(p.getName());
            s.setSocialSecurityNumber(p.getSocialSecurityNumber());
            s.setAddress(p.getAddress());
            s.setDateOfBirth(p.getDateOfBirth());

            // Faculty native values
            s.setDateOfGraduation(DateUtils.formattedTxtFld(txtGradDate.getText()));

            // Add student classes from listbox
            ArrayList<StudentClass> stclasses = new ArrayList();
            for (Object obj : lstClasses.getSelectedValuesList()) {
                OfferedClass oc = (OfferedClass) obj;
                StudentClass sc = new StudentClass(oc);
                stclasses.add(sc);
            }
            s.setClasses(stclasses);

            // add the object to the ArrayList, then clear the form
            if (data.getStudents().add(s) == true) {
                data.hasNewData = true;
                clearData();
            }
        } catch (NoDataException e) {
            e.promptForFields();
        }

    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClasses;
    private javax.swing.JLabel lblDOBFormat;
    private javax.swing.JLabel lblGradDate;
    private javax.swing.JList lstClasses;
    private views.PanelPerson personPanel1;
    private javax.swing.JFormattedTextField txtGradDate;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clearData() {
        personPanel1.clearData();
        txtGradDate.setValue(null);
        lstClasses.clearSelection();
    }

    @Override
    public void checkFields() throws NoDataException {
        
        if (getMissingFields().size() > 0) {
            throw new NoDataException(getMissingFields());
        }
    }
    
    public ArrayList<?> getMissingFields() {
        ArrayList<String> result = new ArrayList();
        
        /*
        if (txtGradDate.getText().equals("")){
            result.add("Graduation Date");
        }*/
        if (personPanel1.missingFields().size() > 0) {
            result.addAll(personPanel1.missingFields());
        }
        return result;
    }

    @Override
    public Component[] clearableItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
