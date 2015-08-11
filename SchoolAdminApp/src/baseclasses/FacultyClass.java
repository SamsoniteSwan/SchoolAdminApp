/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package baseclasses;

import java.util.ArrayList;

/**
 *
 * @author swans_000
 */
public class FacultyClass extends OfferedClass {
    
    private ArrayList<Student> mStudents;
    
    // CONSTRUCTORS    
    public FacultyClass() {
        this(new ArrayList(), 0.0f, "", new Classroom());
    }    
    public FacultyClass(ArrayList<Student> students, float iD, String roomName, Classroom room) {
        super(iD, roomName, room);
        mStudents = students;
        
    }
    
    public FacultyClass(OfferedClass oc) {
        super(oc.getClassIdNumber(), oc.getClassName(), oc.getClassroom());
        mStudents = new ArrayList();
    }
    
    // SETTER
    public void setStudents(ArrayList<Student> students) {
        mStudents = students;
    }
    
    // GETTER
    public ArrayList<Student> getStudents() {
        return mStudents;
    }
    
    /**
     * Returns a single student by index
     * @param index
     * @return Student object by index
     */
    public Student getStudent(int index) {
        return mStudents.get(index);
    }
    
    /**
     * Add a student to the ArrayList
     * @param newStudent Student object to add
     */
    public void addStudent(Student newStudent) {
        mStudents.add(newStudent);
    }
    
    @Override
    public String toString() {
        return super.toString() + mStudents.toString() +
                "; Students:" + mStudents.toString();
    }
}
