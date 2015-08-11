/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;

import baseclasses.OfferedClass;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author swans_000
 */
public class RendererCourseList extends JLabel implements ListCellRenderer<OfferedClass> {

    public RendererCourseList() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends OfferedClass> list, OfferedClass oc, int index, boolean isSelected, boolean cellHasFocus) {
        
        setText(oc.getClassIdNumber() + " (" + oc.getClassName() + ")");
        
        if(isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        
        return this;
    }
    
}
