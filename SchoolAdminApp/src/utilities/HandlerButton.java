/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import views.WindowMain;

/**
 *
 * @author swans_000
 */
public class HandlerButton extends WindowAdapter implements ActionListener {
    
    private final JFrame frame;
    
    public HandlerButton(JFrame thisframe){
        frame = thisframe;
    }
    

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()){
            case "Close":
                frame.dispose();
                break;
            case "Clear":
                clearTheForm();
                break;
            case "QUIT":
                checkAndQuit();
                break;
            case "ChangeGrade":
                notInFreeVersion();
                break;
        }
    }
    
    public void clearTheForm(){
        if (frame instanceof Clearable) {
            Clearable clr = (Clearable)frame;
            clr.clearData();
        }            
    
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        checkAndQuit();    
    }
    
    /**
     * Check if data has been entered since last save,
     * and asks user to confirm quit if so.
     */
    private void checkAndQuit(){
        boolean doClose = false;
        if (WindowMain.dataBox.hasNewData){
            int choice = JOptionPane.showOptionDialog(
                null, "Unsaved data detected! \n Save before exit?", "Warning", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
                null, null, null);
            switch(choice){
                case JOptionPane.YES_OPTION:
                    DataContainer.writeXML(); // Save, then...               
                case JOptionPane.NO_OPTION:
                    doClose = true;           // quit.
                    break;            
                case JOptionPane.CANCEL_OPTION: // do nothing.
                    break;
            }
        } else {
            doClose = true;
        }
        
        if (doClose)
            System.exit(0);
    }
    
    private void notInFreeVersion(){
        JOptionPane.showMessageDialog(null, "This feature not available " +
           "in the free version.\nYou must send in eleventy billion dollars " +
                "to edit grades.  Please upgrade today!", 
                "Ooops!", JOptionPane.PLAIN_MESSAGE);
    }

     
}
