/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author swans_000
 */
public class DateUtils {
    
    public static final GregorianCalendar DEFAULT_DATE = new GregorianCalendar(1870, Calendar.JANUARY, 1);
    
    public static String mdyyyy (GregorianCalendar date) {
        
        // Calendar.MONTH is based on 0 for January, so offset
        // of +1 is required to get the proper month number.
        return (date.get(Calendar.MONTH) + 1) +
                "/" + date.get(Calendar.DAY_OF_MONTH) +
                "/" + date.get(Calendar.YEAR);
    }
    
    // using SimpleDateFormat
    public static String ddmmyy(GregorianCalendar date) {
        String result = "";
        if (date.after(DEFAULT_DATE)){
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            formatter.setCalendar(date);
            result = formatter.format(date.getTime());
        }
        return result;
    }
    
    public static String ddmmyyyy(GregorianCalendar date) {
        String result = "";
        if (date.after(DEFAULT_DATE)){
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            formatter.setCalendar(date);
            result = formatter.format(date.getTime());
        }
        return result;
    }
    
    /*
    * Converts a date String in "mm/dd/yyyy" format
    * to a GregorianCalendar.
    *
    * @param mmsddsyyyy String, example: "01/01/2015"
    *
    * @return GregorianCalendar date
    */
    public static GregorianCalendar formattedTxtFld (String mmsddsyyyy) {

        GregorianCalendar gc;
        
        try
        {
            int yyyy = Integer.parseInt(mmsddsyyyy.substring(6));
            int mm = Integer.parseInt(mmsddsyyyy.substring(0, 2));
            mm--; //Decrement month to match GC start at 0 for January
            int dd = Integer.parseInt(mmsddsyyyy.substring(3, 5));
        
            gc = new GregorianCalendar(yyyy, mm, dd);
        } // Return default date if String is empty 
        catch(StringIndexOutOfBoundsException e) {
            gc = DEFAULT_DATE;
        }

        return gc;
    }
    /**
     * Takes a date String and converts it to
     * GregorianCalendar.  
     * Note: a date of 1/1/70 will return as DEFAULT_DATE
     * 
     * @param datetext string of text separated by "/"
     * @return GregorianCalendar date
     */
    public static GregorianCalendar formattedTxtFldSplit (String datetext) {

        GregorianCalendar gc;
        if (datetext.length() == 0){
            gc = DEFAULT_DATE;
        } else {
            String[] dateparts = datetext.split("/");
        
            int mm = Integer.parseInt(dateparts[0]);
            mm--;
            int dd = Integer.parseInt(dateparts[1]);
            int yr = Integer.parseInt(dateparts[2]);
        
            if (dateparts[2].length() == 2) { // check for 2 digit year
                if (yr < 30) {
                    gc = new GregorianCalendar(yr +=2000, mm, dd);
                } else {
                    if (yr == 70 && dd == 1 && mm == 0) { // 1/1/70 defaults to 1/1/1870
                        gc = DEFAULT_DATE;
                    } else{
                        gc = new GregorianCalendar(yr +=1900, mm, dd);
                    }
                }
            } else {
                gc = new GregorianCalendar(yr, mm, dd);
            }
        }
        return gc;
    }
    
}
