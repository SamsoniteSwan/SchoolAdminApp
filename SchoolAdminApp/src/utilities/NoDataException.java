/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author swans_000
 */
public class NoDataException extends Exception {
    private static final String MSG = "The following fields are missing or incorrect: ";

    private ArrayList fldList;
    /**
     * Creates a new instance of <code>NoDataException</code> without detail
     * message.
     */
    public NoDataException() {
        this.fldList = new ArrayList<String>();
    }

    /**
     * Constructs an instance of <code>NoDataException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NoDataException(String msg) {
        
        super(msg);
        this.fldList = new ArrayList<String>();
        fldList.add(msg);
        JOptionPane.showMessageDialog(null, MSG + msg);
    }
    
    public NoDataException(String[] fieldName) {
        this.fldList = new ArrayList<String>();
        
        
        for(String str : fieldName) {
            fldList.add(str);
        }
        //JOptionPane.showMessageDialog(null, 
        //   MSG + fieldName.toString());
    }
    
    public NoDataException(ArrayList list) {
        this.fldList = new ArrayList<String>();
        //JOptionPane.showMessageDialog(null, "Missing data in: " + list.toString());
        fldList = list;
    }
    
    //Used by NewCoursePanel
    public void promptForFields() {
        JOptionPane.showMessageDialog(null, MSG + fldList.toString());
        
    }
    
    public void addFields(ArrayList more) {
        fldList.addAll(more);
    }
}
