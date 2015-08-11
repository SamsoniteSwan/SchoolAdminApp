/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package baseclasses;

/**
 *
 * @author swans_000
 */
public class OfferedClass {
    
    private Classroom mRoom;
    private String mClassName;
    private float mClassId;
    
    // CONSTRUCTORS
    public OfferedClass() {
        this( 0.0f, "", new Classroom());
    }
    public OfferedClass(float iD, String className, Classroom room) {
        //mRoom = new Classroom();
        mRoom = room;
        mClassName = className;
        mClassId = iD;
    }
    public OfferedClass(float iD, String className, String roomNumber, char roomStatus) {
      
        mClassName = className;
        mClassId = iD;
        mRoom = new Classroom(roomNumber, roomStatus);
    }
    
    // SETTERS
    public void setClassroom(Classroom room) {
        mRoom = room;
    }
    public void setClassName(String cName) {
        mClassName = cName;
    }
    public void setClassIdNumber(float classId) {
        mClassId = classId;
    }
    
    // GETTERS
    public Classroom getClassroom() {
        return mRoom;
    }
    public String getClassName() {
        return mClassName;
    }
    public float getClassIdNumber() {
        return mClassId;
    }
    
    @Override
    public String toString() {
        return "#" + mClassId + 
                "('" + mClassName +
                "' " + mRoom.toString() + ")";
    }
    
}
