/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;

import baseclasses.Student;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author swans_000
 */
public class RendererStudentList extends JLabel implements ListCellRenderer<Student> {
    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
    
    public RendererStudentList() {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Student> list, Student value, int index, boolean isSelected, boolean cellHasFocus) {
        
        setText(value.getName());
        
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
