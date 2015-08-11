/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package baseclasses;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import utilities.DateUtils;
/**
 *
 * @author swans_000
 */
public class Faculty extends Person {
    
    private GregorianCalendar mDOH;
    private GregorianCalendar mDOT;
    private double mSalary;
    private ArrayList<FacultyClass> mClasses;
    private char mStatus;
    
    // CONSTRUCTORS
    /**
     * No-Argument Constructor
     */
    public Faculty() {
        this(DateUtils.DEFAULT_DATE, 
                DateUtils.DEFAULT_DATE,
                0.0, '\0');
    }
    
    public Faculty(GregorianCalendar dOH, GregorianCalendar dOT, 
            double salary, char status) {
        
        mDOH = new GregorianCalendar();
        mDOH = dOH;
        //mDOT = new GregorianCalendar();
        mDOT = dOT;
        mSalary = salary;
        mClasses = new ArrayList();
        mStatus = status;
        
        
        
    }
    
    // SETTERS
    public void setDateOfHire(GregorianCalendar dOH) {
        mDOH = dOH;
    }
    public void setDateOfTermination(GregorianCalendar dOT) {
        mDOT = dOT;
    }
    public void setSalary(double salary) {
       mSalary = salary;
    }
    public void setClasses(ArrayList<FacultyClass> classes) {
        mClasses = classes;
    }
    public void setStatus(char status) {
        mStatus = status;
    }
    
    // GETTERS
    public GregorianCalendar getDateOfHire() {
        return mDOH;
    }
    public GregorianCalendar getDateOfTermination() {
        return mDOT;
    }
    public double getSalary() {
        return mSalary;
    }
    public ArrayList<FacultyClass> getClasses() {
        return mClasses;
    }
    public char getStatus() {
        return mStatus;
    }
    
    /**
     * Add a class to the Classes ArrayList
     * @param eClass 
     */
    public void addClass(FacultyClass eClass) {
        mClasses.add(eClass); 
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() +
                "; DateOfHire:" + DateUtils.ddmmyy(mDOH) + 
                "; DateOfTermination:" + DateUtils.ddmmyy(mDOT) +
                "; Salary:" + mSalary +
                "; Status:" + mStatus;
    }
    
    

    
    
}
