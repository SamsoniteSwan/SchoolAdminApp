/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package baseclasses;

/**
 *
 * @author swans_000
 */
public class Classroom {
    
    private String mRoomNumber;
    private char mStatus;
    
    // CONSTRUCTORS
    public Classroom() {
        this("/0", 'x');
    }
    public Classroom(String roomNumber, char status) {
        mRoomNumber = roomNumber;
        mStatus = status;
        
    }
    
    // SETTERS
    public void setRoomNumber(String roomNumber) {
        mRoomNumber = roomNumber;
    }
    public void setStatus(char status) {
        mStatus = status;
    }
    
    // GETTERS
    public String getRoomNumber(){
        return mRoomNumber;
    }
    public char getStatus() {
        return mStatus;
    }
    
    public String getStatusText(){
        
        String result = "";
        
        switch(mStatus) {
            case 'L':
                result = "Lab";
                break;
            case 'C':
                result = "Classroom";
                break;
            case 'H':
                result = "Lecture Hall";
                break;
        }
        
        return result;
    }
    
    @Override
    public String toString() {
        return getStatusText() + " #" + mRoomNumber;
    }
}
