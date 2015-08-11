/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package utilities;

import baseclasses.Classroom;
import baseclasses.Faculty;
import baseclasses.FacultyClass;
import baseclasses.OfferedClass;
import baseclasses.Student;
import baseclasses.StudentClass;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 *
 * @author swans_000
 */
public class DataContainer {
    
    public static final String APP_NAME = "Administrator 5000";
    public static final String DATAFILE_NAME = "data.xml";
    
    public static boolean hasNewData = false;
    
    private static ArrayList<Student> studentsList = new ArrayList<>();
    private static ArrayList<Faculty> facultyList = new ArrayList<>();
    private static ArrayList<OfferedClass> coursesList = new ArrayList<>();
    private static ArrayList<Classroom> classroomList = new ArrayList<>();
    
    private static Document dom;
    

    
    public ArrayList<Faculty> getFaculty() {
        return facultyList;
    }
    
    public ArrayList<Student> getStudents() {
        return studentsList;
    }
    
    public ArrayList<OfferedClass> getCourses() {
        return coursesList;
    }

    public ArrayList<Classroom> getClassrooms() {
        return classroomList;
    }    
    
    //************************************************************
    // DATA PERSISTANCE
    //---------------------------------------------
    //    XML
    //      OUTPUT
    public static void writeXML() {
        DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder DocBuilder = docBF.newDocumentBuilder();
            // Document Model instance
            dom = DocBuilder.newDocument();
            Element root = dom.createElement("SystemObjects");
            dom.appendChild(root);
            
            // Add the different collections
            root.appendChild(classroomsElement());
            root.appendChild(coursesElement());
            root.appendChild(facultyElement());
            root.appendChild(studentsElement());
            
            // Use default XML formatting
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);
            
            // open output stream
            XMLSerializer serializer = new XMLSerializer(new FileOutputStream(
            new File(DATAFILE_NAME)), format);
            
            // write out object
            serializer.serialize(dom);
            
            hasNewData = false;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    /**
     * Creates an element node with text for
     * adding to XML.
     * 
     * @param name String name of XML node
     * @param value String value for XML node
     * @return the element with it's value
     */
    private static Element addElement(String name, String value) {
        Element e = dom.createElement(name);
        Text text = dom.createTextNode(value);
        e.appendChild(text);
        return e;
    }
    
    private static Element classroomsElement() {
        
        Element localRoot = dom.createElement("classrooms"); // local collection name
        Element newE;
        
        for(Classroom clroom : classroomList) {
            
            // object's node
            Element indE = dom.createElement("room");
            
            // Room Number
            newE = addElement("number", clroom.getRoomNumber());
            indE.appendChild(newE);
            
            // Classroom Type
            newE = addElement("type", String.valueOf(clroom.getStatus()));
            indE.appendChild(newE);

            // Add Room to Classrooms
            localRoot.appendChild(indE);
            
        }
        return localRoot;   
    }
    
    private static Element coursesElement() {
        
        Element localRoot = dom.createElement("courses");
        
        for (OfferedClass oc : coursesList) {
            
            Element indE = dom.createElement("course");
            
            // Course ID
            indE.appendChild(addElement("courseid", String.valueOf(oc.getClassIdNumber())));            
            // Course Name
            indE.appendChild(addElement("courseName", oc.getClassName()));            
            // Course RoomNumber
            indE.appendChild(addElement("roomid", oc.getClassroom().getRoomNumber()));
            
            localRoot.appendChild(indE);
            
        }
        return localRoot;
    }
    
    private static Element facultyElement() {
        
        Element localRoot = dom.createElement("faculty");
        
        for(Faculty f : facultyList) {
            
            Element indE = dom.createElement("teacher");

            // Teacher Name
            indE.appendChild(addElement("name", f.getName()));            
            indE.appendChild(addElement("ssn", f.getSocialSecurityNumber()));            
            indE.appendChild(addElement("address", f.getAddress()));            
            indE.appendChild(addElement("dob", DateUtils.ddmmyyyy(f.getDateOfBirth())));            
            indE.appendChild(addElement("doh", DateUtils.ddmmyyyy(f.getDateOfHire())));            
            indE.appendChild(addElement("dot", DateUtils.ddmmyyyy(f.getDateOfTermination())));            
            indE.appendChild(addElement("status", String.valueOf(f.getStatus())));            
            indE.appendChild(addElement("salary", String.valueOf(f.getSalary())));

            for(FacultyClass oc : f.getClasses()) {
                indE.appendChild(addElement("facultycourse",String.valueOf(oc.getClassIdNumber())));
            }
            
            localRoot.appendChild(indE);
        }
        
        return localRoot;
    }
    
 
        private static Element studentsElement() {
        
        Element localRoot = dom.createElement("students");
        
        for(Student s : studentsList) {
            
            Element indE = dom.createElement("student");

            // Student info
            indE.appendChild(addElement("name", s.getName()));            
            indE.appendChild(addElement("ssn", s.getSocialSecurityNumber()));            
            indE.appendChild(addElement("address", s.getAddress()));            
            indE.appendChild(addElement("dob", DateUtils.ddmmyyyy(s.getDateOfBirth())));            
            indE.appendChild(addElement("dog", DateUtils.ddmmyyyy(s.getDateOfGraduation())));            
            indE.appendChild(addElement("gpa", String.valueOf(s.getCurrentGPA())));
            
            
             // saved working code for adding classes WITHOUT grades
            for(StudentClass oc : s.getClasses()) {
                indE.appendChild(addElement("studentcourse",String.valueOf(oc.getClassIdNumber())));
            }
            /*
            for(StudentClass oc : s.getClasses()) {
                Element course = dom.createElement("studentcourse");
                //course.setNodeValue(String.valueOf(oc.getClassIdNumber()));
                
                //course.setAttribute("courseid", String.valueOf(oc.getClassIdNumber()));
                course.appendChild(addElement("grades", oc.getGrades().toString()));
                
                //indE.appendChild(addElement("studentcourse",String.valueOf(oc.getClassIdNumber())));
                //for (Float grade : oc.getGrades()) {
                    
                indE.appendChild(course);
                
            }*/
            
            localRoot.appendChild(indE);
        }
        
        return localRoot;
    }
        
    //-------------------------------------------------
    //   XML
    //      INPUT
        
    public void readXML() {
        Logger.enableLogging();
        Logger.setLogLevel(4);
        DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
        NodeList instanceList;
        
        try {
            DocumentBuilder DocBuilder = docBF.newDocumentBuilder();
            Document dom = DocBuilder.parse(DATAFILE_NAME);
            
            Element docRoot = dom.getDocumentElement();
            // CLASSROOMS
            instanceList = docRoot.getElementsByTagName("room");
            for (int i = 0; i < instanceList.getLength(); i++) { // loop through classrooms
                Classroom room = new Classroom();
                NodeList flds = instanceList.item(i).getChildNodes();
                for(int j = 0; j < flds.getLength(); j++){
                    if (flds.item(j).getNodeType() == Node.ELEMENT_NODE) { // check if node is an Element
                        Element fld = (Element)flds.item(j);
                        switch(fld.getNodeName()){
                            case "number":
                                room.setRoomNumber(fld.getTextContent());
                                break;
                            case "type":
                                room.setStatus(fld.getTextContent().charAt(0));
                                break;
                        }
                    }
                }
                classroomList.add(room);
            }
            // COURSES
            instanceList = docRoot.getElementsByTagName("course");
            for (int i = 0; i < instanceList.getLength(); i++) { // loop through courses
                OfferedClass course = new OfferedClass();
                NodeList flds = instanceList.item(i).getChildNodes();
                for(int j = 0; j < flds.getLength(); j++){
                    if (flds.item(j).getNodeType() == Node.ELEMENT_NODE) { // check if node is an Element
                        Element fld = (Element)flds.item(j);
                        switch(fld.getNodeName()){
                            case "courseid":
                                course.setClassIdNumber(Float.parseFloat(fld.getTextContent()));
                                break;
                            case "courseName":
                                course.setClassName(fld.getTextContent());
                                break;
                            case "roomid":
                                for (Classroom rm : classroomList) {
                                    // loop through classrooms to find the one with the same roomnumber
                                    if (rm.getRoomNumber().compareTo(fld.getTextContent()) == 0){
                                        course.setClassroom(rm);
                                    }
                                }
                                
                        }
                    }
                }
                coursesList.add(course);
            }
            
            // FACULTY
            instanceList = docRoot.getElementsByTagName("teacher");
            for (int i = 0; i < instanceList.getLength(); i++) { // loop through faculty
                Faculty t = new Faculty();
                NodeList flds = instanceList.item(i).getChildNodes();
                for(int j = 0; j < flds.getLength(); j++){
                    if (flds.item(j).getNodeType() == Node.ELEMENT_NODE) { // check if node is an Element
                        Element fld = (Element)flds.item(j);
                        switch(fld.getNodeName()){
                            case "name":
                                t.setName(fld.getTextContent());
                                break;
                            case "ssn":
                                t.setSocialSecurityNumber(fld.getTextContent());
                                break;
                            case "address":
                                t.setAddress(fld.getTextContent());
                                break;
                            case "dob":
                                t.setDateOfBirth(DateUtils.formattedTxtFldSplit(fld.getTextContent()));
                                break;
                            case "doh":
                                t.setDateOfHire(DateUtils.formattedTxtFldSplit(fld.getTextContent()));
                                break;
                            case "dot":
                                t.setDateOfTermination(DateUtils.formattedTxtFldSplit(fld.getTextContent()));
                                break;
                            case "status":
                                t.setStatus(fld.getTextContent().charAt(0));
                                break;
                            case "salary":
                                t.setSalary(Float.parseFloat(fld.getTextContent()));
                                break;
                            case "facultycourse":
                                for (OfferedClass oc : coursesList){

                                    if (oc.getClassIdNumber() == Float.parseFloat(fld.getTextContent())){
                                        FacultyClass facclass = new FacultyClass(oc);
                                        t.addClass(facclass);
                                    }
                                }
                        }
                    }
                }
                facultyList.add(t);
            }

            // STUDENTS
            instanceList = docRoot.getElementsByTagName("student");
            for (int i = 0; i < instanceList.getLength(); i++) { // loop through students
                Student s = new Student();
                NodeList flds = instanceList.item(i).getChildNodes();
                for(int j = 0; j < flds.getLength(); j++){
                    if (flds.item(j).getNodeType() == Node.ELEMENT_NODE) { // check if node is an Element
                        Element fld = (Element)flds.item(j);
                        switch(fld.getNodeName()){
                            case "name":
                                s.setName(fld.getTextContent());
                                break;
                            case "ssn":
                                s.setSocialSecurityNumber(fld.getTextContent());
                                break;
                            case "address":
                                s.setAddress(fld.getTextContent());
                                break;
                            case "dob":
                                s.setDateOfBirth(DateUtils.formattedTxtFldSplit(fld.getTextContent()));
                                break;
                            case "dog":
                                s.setDateOfGraduation(DateUtils.formattedTxtFldSplit(fld.getTextContent()));
                                break;
                            case "studentcourse":
                                //Element sub = (Element)fld.getElementsByTagName("studentcourse");
                                for (OfferedClass oc : coursesList){
                                    // WORKING BACUP
                                    if (oc.getClassIdNumber() == Float.parseFloat(fld.getTextContent())){
                                        StudentClass studclass = new StudentClass(oc);
                                        s.addClass(studclass);
                                    }
                                    /*
                                    if (oc.getClassIdNumber() == Float.parseFloat(fld.getAttribute("courseid"))){
                                        StudentClass studclass = new StudentClass(oc);
                                        s.addClass(studclass);
                                        NodeList coursenodes = fld.getChildNodes();
                                        for(int x = 0; x < coursenodes.getLength(); x++){
                                            if(coursenodes.item(x).getNodeType() == Node.ELEMENT_NODE){
                                                Element courseEl = (Element)coursenodes.item(x);
                                                if (courseEl.getNodeName().compareTo("grades")==0){
                                                    List<String> gradeSA = Arrays.asList(fld.getTextContent());
                                                    System.out.println(fld.getTextContent());
                                                    for(String grd : gradeSA){
                                                        studclass.addGrade(Float.parseFloat(grd));
                                                    }                                                
                                                }
                                            }
                                    

                                            
                                        }
                                    }*/

                                }
                             
                            //case "gpa":
                            //    s.setfld.getTextContent()));
                            //    break;
                        }
                    }
                }
                studentsList.add(s);
            }            
            
        } catch(Exception e) {
            Logger.logError(e.getMessage());
        }
    }
    

    private void classroomsImpXML() {
    
        
    }
    
}
