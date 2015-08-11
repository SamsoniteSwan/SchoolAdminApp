/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package views;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import utilities.HandlerButton;
import utilities.Clearable;
import utilities.DataContainer;

/**
 *
 * @author swans_000
 */
public class WindowAddData extends javax.swing.JFrame implements Clearable {

    private DataContainer dataBox;
    private PanelCardAdd pnlCardAdd;
    /**
     * Creates new form AddDataWindow
     */
    public WindowAddData() {
        initComponents();
        
        myInit();
        CardLayout cl = (CardLayout)pnlCardAdd.getLayout();
        cl.show(pnlCardAdd, "newClassroom");
    }
    
    public WindowAddData(DataContainer dc, String cardName) {
        initComponents();
        pnlCardAdd = new PanelCardAdd(dc);
        //
        this.getContentPane().add(pnlCardAdd);
        LayoutManager lyt = this.getContentPane().getLayout();
        GroupLayout grpLay = (GroupLayout) lyt;
        grpLay.replace(pnlTemp, pnlCardAdd);
        
        this.setTitle(cardName);
        //
        //this.getContentPane().add(pnlCardAdd).setBounds(20, 20, 500, 500);
        //LayoutManager lyt = this.getContentPane().getLayout();
        //GroupLayout grpLay = (GroupLayout) lyt;
        //pack();
        /**
         * ----------------------------------------
         * Copied from NetBeans generated code to replace
         */
        /*
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlCardAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(cmdClear)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblFieldsAreRequired1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFieldsAreRequired)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cmdClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFieldsAreRequired)
                            .addComponent(lblFieldsAreRequired1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlCardAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(cmdClear)
                .addContainerGap())
        );
        */
        //------------------------------------------------
        
        //GroupLayout gl = (GroupLayout) this.getLayout();
        //gl.setHorizontalGroup(gl.);
        //gl.setVerticalGroup(null);
        
        dataBox = dc;
        CardLayout cl = (CardLayout)pnlCardAdd.getLayout();
        cl.show(pnlCardAdd, cardName);
        
        myInit();

    }
    
    private void myInit(){
        // prevent Java from closing out completely
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        
        // button events
        HandlerButton bh = new HandlerButton(this);
        cmdClose.setActionCommand("Close");
        cmdClose.addActionListener(bh);
        cmdClear.setActionCommand("Clear");
        cmdClear.addActionListener(bh);
        
        
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
        cmdClear = new javax.swing.JButton();
        lblFieldsAreRequired = new javax.swing.JLabel();
        lblFieldsAreRequired1 = new javax.swing.JLabel();
        pnlTemp = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmdClose.setText("Close");

        cmdClear.setText("Clear");

        lblFieldsAreRequired.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        lblFieldsAreRequired.setText("fields are required");

        lblFieldsAreRequired1.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        lblFieldsAreRequired1.setForeground(new java.awt.Color(255, 0, 0));
        lblFieldsAreRequired1.setText("RED");
        lblFieldsAreRequired1.setPreferredSize(new java.awt.Dimension(22, 13));

        javax.swing.GroupLayout pnlTempLayout = new javax.swing.GroupLayout(pnlTemp);
        pnlTemp.setLayout(pnlTempLayout);
        pnlTempLayout.setHorizontalGroup(
            pnlTempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTempLayout.setVerticalGroup(
            pnlTempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(cmdClear)
                                .addGap(73, 73, 73)
                                .addComponent(cmdClose))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(lblFieldsAreRequired1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFieldsAreRequired, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 255, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFieldsAreRequired)
                    .addComponent(lblFieldsAreRequired1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdClear)
                    .addComponent(cmdClose))
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
            java.util.logging.Logger.getLogger(WindowAddData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowAddData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowAddData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowAddData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowAddData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClear;
    private javax.swing.JButton cmdClose;
    private javax.swing.JLabel lblFieldsAreRequired;
    private javax.swing.JLabel lblFieldsAreRequired1;
    private javax.swing.JPanel pnlTemp;
    // End of variables declaration//GEN-END:variables

    /*
    @Override
    public void actionPerformed(ActionEvent evt) {
       switch (evt.getActionCommand()){
           case "Clear":
                Component[] arrayComps = cardAddPanel1.getComponents();
                
                // loop through objects(panels) in CardPanel
                for (Component c : arrayComps) {
                    if (c instanceof Clearable){
                        Clearable clr = (Clearable) c;
                        clr.clearData(); 
                    }
                }
        }
    
    }*/

    @Override
    public void clearData() {
        
                Component[] arrayComps = pnlCardAdd.getComponents();
                
                // loop through objects(panels) in CardPanel
                for (Component c : arrayComps) {
                    if (c instanceof Clearable){
                        Clearable clr = (Clearable) c;
                        clr.clearData(); 
                    }
                }
    }

    @Override
    public Component[] clearableItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
