/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author swans_000
 */
public class ModelMyComboBox<M> extends DefaultComboBoxModel {

    ArrayList<M> theList;
    
    public ModelMyComboBox(ArrayList<M> lst) {
        theList = lst;
        //super(lst);
    }
    
    public ModelMyComboBox() {
        this(new ArrayList());
    }
    
    

    /*
    @Override
    public int getSize() {
        return theList.size();
    }

    @Override
    public M getElementAt(int index) {
        return theList.get(index);
    }

    */
    
}
