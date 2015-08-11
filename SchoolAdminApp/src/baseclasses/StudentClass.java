/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package baseclasses;

import java.util.ArrayList;

/**
 * Class to hold an ArrayList of grades a student
 * achieved in the course
 * @author swans_000
 */
public class StudentClass extends OfferedClass {
    
    private ArrayList<Float> mGrades;
    
    // CONSTRUCTORS
    public StudentClass() {
        this(new ArrayList(), 0.0f, "", new Classroom()); 
    } 
    public StudentClass(ArrayList<Float> grades, float iD, String className, Classroom room) {
        super(iD, className, room);
        mGrades = grades;
        
    }
    public StudentClass(ArrayList<Float> grades, float iD, String className) {
        super(iD, className, new Classroom());
        mGrades = grades;
    }
    
    public StudentClass(OfferedClass oc){
        super(oc.getClassIdNumber(), oc.getClassName(), oc.getClassroom());
        mGrades = new ArrayList();
    }
    
    // SETTERS
    public void setGrades(ArrayList<Float> grades) {
        mGrades = grades;
    }
    
    // GETTERS
    /**
     * 
     * @return ArrayList entire Array of grades
     */
    public ArrayList<Float> getGrades() {
        return mGrades;
    }
    
    /**
     * Add a grade to ArrayList
     * @param newGrade Float grade to add
     */
    public void addGrade(Float newGrade) {
        mGrades.add(newGrade);
    }
    
    /**
     * get a specific grade from the ArrayList
     * @param index integer of location in ArrayList
     * @return Float of specified index
     */
    public float getGrade(int index) {
        return mGrades.get(index);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    public float averageGrade() {
        float result = 0.00f;
        for(Float grd : mGrades) {
            result += grd;
        }
        return result/mGrades.size();
    }
}
