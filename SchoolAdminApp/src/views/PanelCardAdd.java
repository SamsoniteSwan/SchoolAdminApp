/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package views;

import utilities.DataContainer;

/**
 *
 * @author swans_000
 */
public class PanelCardAdd extends javax.swing.JPanel {
    
    DataContainer dataBox;
    
    private PanelNewClassroom pnlNewClassroom;
    private PanelNewCourse pnlNewCourse;
    private PanelNewTeacher pnlNewTeacher;
    private PanelNewStudent pnlNewStudent;

    /**
     * Creates new form CardAddPanel
     */
    public PanelCardAdd() {
        initComponents();
        pnlNewClassroom = new views.PanelNewClassroom();
        pnlNewCourse = new views.PanelNewCourse(dataBox);
        pnlNewTeacher = new views.PanelNewTeacher(dataBox);
        pnlNewStudent = new views.PanelNewStudent(dataBox);
        
        setLayout(new java.awt.CardLayout());
        add(pnlNewClassroom, "New Classroom");
        add(pnlNewCourse, "New Course");
        add(pnlNewStudent, "New Student");
        add(pnlNewTeacher, "New Teacher");
    }
    
    public PanelCardAdd(DataContainer dc) {
        dataBox = dc;
        initComponents();
        pnlNewClassroom = new views.PanelNewClassroom();
        pnlNewCourse = new views.PanelNewCourse(dataBox);
        pnlNewTeacher = new views.PanelNewTeacher(dataBox);
        pnlNewStudent = new views.PanelNewStudent(dataBox);
        
        setLayout(new java.awt.CardLayout());
        add(pnlNewClassroom, "New Classroom");
        add(pnlNewCourse, "New Course");
        add(pnlNewStudent, "New Student");
        add(pnlNewTeacher, "New Teacher");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    public void setDataContainer(DataContainer data) {
        dataBox = data;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
