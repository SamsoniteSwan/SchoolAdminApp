/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package baseclasses;

import baseclasses.Classroom;
import baseclasses.Faculty;
import baseclasses.FacultyClass;
import baseclasses.OfferedClass;
import baseclasses.Student;
import baseclasses.StudentClass;
import java.util.GregorianCalendar;

/**
 * @author Elizabeth Kramer
 */
public class BaseClassCreationTest {

  public static void main (String[] args) {

       // Create a date object 
       GregorianCalendar gregorianCalendarDate = new GregorianCalendar(1975,GregorianCalendar.JULY, 3);
       
       // Create a classroom object
       Classroom classroom = new Classroom("PA100", 'l');
               
       // Create an OfferedClass object
       OfferedClass java90301 = new OfferedClass(90.301f, "Java Programming", classroom);
       
       // Create a Student object
       Student newStudent = new Student();
       newStudent.setDateOfBirth(gregorianCalendarDate);
       newStudent.setName("Kathy Smith");
       newStudent.setAddress("1 Beech Ave");
       newStudent.setSocialSecurityNumber("567876567");
       newStudent.setDateOfGraduation(gregorianCalendarDate);
       
       // Create a StudentClass object based on the OfferedClass created above
       StudentClass studentClass = new StudentClass();
       studentClass.setClassIdNumber(java90301.getClassIdNumber());
       studentClass.setClassName(java90301.getClassName());
       studentClass.setClassroom(java90301.getClassroom());
       
       // Add grades to StudentClass object
       studentClass.getGrades().add(90.5f);
       studentClass.getGrades().add(100f);
       studentClass.getGrades().add(70.5f);
       studentClass.getGrades().add(65f);

       // Add the StudentClass object to the Student object
       newStudent.getClasses().add(studentClass);

       // Print out the data for the new Student object
       System.out.println(newStudent.toString());

       // Create a Faculty object
       Faculty faculty = new Faculty();
       faculty.setDateOfBirth(gregorianCalendarDate);
       faculty.setName("Elizabeth Kramer");
       faculty.setAddress("1 University Ave");
       faculty.setSocialSecurityNumber("123456789");
       faculty.setStatus('f');
       faculty.setDateOfHire(gregorianCalendarDate);
       faculty.setDateOfTermination(gregorianCalendarDate);
    
       // Create a FacultyClass object based on the OfferedClass created above
       FacultyClass fc = new FacultyClass();
       fc.setClassIdNumber(java90301.getClassIdNumber());
       fc.setClassName(java90301.getClassName());
       fc.setClassroom(java90301.getClassroom());

       // Add the Student object created above, to the FacultyClass object
       fc.addStudent(newStudent);
      
       // Add the FacultyClass object to the Faculty object
       faculty.addClass(fc);

       // Print out the Faculty object data
       System.out.println(faculty.toString());
       
       // MY TESTS -- REMOVE
       /**
       GregorianCalendar changer = new GregorianCalendar(1990,GregorianCalendar.AUGUST, 4);
       gregorianCalendarDate = changer;
       faculty.setDateOfTermination(gregorianCalendarDate);
       System.out.println("CALENDAR CHANGED");
       System.out.println(newStudent.toString());
       System.out.println(faculty.toString());
       */
   }
}
