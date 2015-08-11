/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;

import baseclasses.OfferedClass;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author swans_000
 */
public class ModelMyList<M> extends AbstractListModel {
    
    ArrayList<M> dataList;
    
    public ModelMyList(ArrayList<M> list) {
        dataList = list;
    }
    
    public ModelMyList(){
        this(new ArrayList());
    }
    

    @Override
    public int getSize() {
        return dataList.size();
    }

    
    @Override
    public Object getElementAt(int index) {
        Object oc = dataList.get(index);
        return oc;
    }
    
}
