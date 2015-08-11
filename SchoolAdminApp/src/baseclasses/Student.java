/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package baseclasses;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import utilities.DateUtils;

/**
 * object for attending student
 * @author swans_000
 */
public class Student extends Person {
    
    private GregorianCalendar mGradDate;
    private ArrayList<StudentClass> mClasses;
    
    // CONSTRUCTORS
    public Student() {
        this(DateUtils.DEFAULT_DATE);
    }

    public Student(GregorianCalendar gradDate) {
        //mGradDate = new GregorianCalendar();
        mGradDate = gradDate;
        mClasses = new ArrayList<>();        
    }
    
    // SETTERS
    public void setDateOfGraduation(GregorianCalendar gradDate) {
        mGradDate = gradDate;
    }
    public void setClasses(ArrayList<StudentClass> classes) {
        mClasses = classes;
    }
    
    public void addClass(StudentClass newclass) {
        mClasses.add(newclass);
    }
    
    // GETTERS
    public GregorianCalendar getDateOfGraduation() {
        return mGradDate;
    }
    public ArrayList<StudentClass> getClasses() {
        return mClasses;
    }
    

    @Override
    public String toString() {
        return super.toString() + 
                "; DateOfGraduation:" + DateUtils.mdyyyy(mGradDate) + 
                //Disabled due to null error when courses have no classroom assigned
                //"; Classes:" + mClasses.toString() + 
                "; CurrentGPA:" + getCurrentGPA();
    }
    

    /**
     * Gets the average value of all grades
     * from all classes
     * @return avg the average grade
     *//*
       public float getCurrentGPA() {
           
        float tot = 0.0f;
        int count = 0; 
        float avg;
        
        for (int i = 0; i < mClasses.size(); i++) { // loop through classes
            // reference the class's ArrayList of grades
            ArrayList grades = mClasses.get(i).getGrades(); 
            float courseAvg = 0.0f;
            
            for (int n = 0; n < grades.size(); n++, count++) { // loop through grades, increment count
                courseAvg += (float)grades.get(n);
                //tot += (float)grades.get(n); // add grade to the running total
            }
            courseAvg = courseAvg/grades.size();
            tot += courseAvg;
        }
        avg = tot/count; // divide total by the count of values
        return avg;
    }*/ 
       
       private float avg(ArrayList<Float> fltList) {
           float result = 0.0f;
           for (Float val : fltList){
               result += val;
           }
           result = result/fltList.size();
           return result;
       }
       
       private float gpa(float grade) {
           float result = 0.0f;
           result = (grade - 59) / 10;
           if (result < 0.0) {
               result = 0.0f;
           }
           
           return result;
       }
       
       public float getCurrentGPA() {
           float tot = 0.0f;
           for(StudentClass sc : mClasses) {
               tot += gpa(avg(sc.getGrades()));
               //tot = 
           }
           tot = tot/mClasses.size();
           return tot;
       }
}
