/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package baseclasses;

import java.util.Calendar;
import java.util.GregorianCalendar;
import utilities.DateUtils;

/**
 * General Person object
 * @author swans_000
 */
public class Person {
    
    private String mName;
    private String mAddress;
    private String mSSN;
    private GregorianCalendar mDOB;
    
    /**
     * No-Argument constructor;
     */
    public Person() {
        this("", "", "", DateUtils.DEFAULT_DATE);                
    }
    
    // OVERLOADED CONSTRUCTOR
    public Person(String name, String address, String sSN, GregorianCalendar dOB) {
        mName = name;
        mAddress = address;
        mSSN = sSN;
        /**if (dOB == null) {
              GregorianCalendar dateOB = new GregorianCalendar();
            dateOB.set(2015, 1, 5);
            dOB = dateOB;
        }
        * */
        //mDOB = new GregorianCalendar();
        mDOB = dOB;
    }
    
    // SETTERS
    /**
     * 
     * @param name Person's name
     */
    public void setName(String name) {
        mName = name;
    }
    public void setAddress(String address) {
        mAddress = address;
    }
    public void setSocialSecurityNumber(String ssn) {
        mSSN = ssn;
    }
    public void setDateOfBirth(GregorianCalendar dob) {
        mDOB = dob;
    }
    
    
    // GETTERS
    /**
     * 
     * @return 
     */
    public String getName() {
        return mName;
    }
    public String getAddress() {
        return mAddress;
    }
    public String getSocialSecurityNumber() {
        return mSSN;
    }
    public GregorianCalendar getDateOfBirth() {
        return mDOB;
    }
    
    @Override
    public String toString() {
        String result = "";
        result += mName.toUpperCase();
        result += " (SSN " + mSSN + ", ";
        result += "DOB " + DateUtils.ddmmyy(mDOB) + ")";
        
        return result;
    }
    
}
