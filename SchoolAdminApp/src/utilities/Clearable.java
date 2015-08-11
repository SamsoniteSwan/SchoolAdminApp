/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;

import java.awt.Component;

/**
 *
 * @author swans_000
 */
public interface Clearable {
    

    /**
     * Removes data from all user-populated fields
     */
    public void clearData();
    
    public Component[] clearableItems();
    
}
