package classroom;

import java.util.ArrayList;
import java.util.List;

public
class Classroom {

    private int capacity;
    private
    List<Student> data;

    public
    Classroom (int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<> ();
    }

    public
    int getCapacity () {
        return this.capacity;
    }

    public
    List<Student> getStudents () {
        return this.data;
    }
    public int getStudentCount(){
        return this.data.size ();
    }

    public String registerStudent(Student student){
        if (this.capacity>this.data.size ()&&!this.data.contains (student)){
            this.data.add (student);
            return String.format ("Added student %s %s",student.getFirstName (),student.getLastName ());
        }else if (this.data.contains (student)){
            return "Student is already in the classroom";
        }
        return "No seats in the classroom";
    }
    public String dismissStudent(Student student){
        if (this.data.contains (student)){
            this.data.remove (student);
            return String.format ("Removed student %s %s",student.getFirstName (),student.getLastName ());
        }
        return "Student not found";
    }
    public String getSubjectInfo(String subject){
        boolean empty = true;
        for (Student s : this.data) {
            if (s.getBestSubject ().equals (subject)){
                empty = false;break;
            }
        }
        if (empty){
            return "No students enrolled for the subject";
        }
        StringBuilder sb = new StringBuilder ("Subject: " + subject);
        sb.append (System.lineSeparator ()).append ("Students:").append (System.lineSeparator ());
        for (Student student : this.data) {
            if (student.getBestSubject ().equals (subject)){
                sb.append (student.getFirstName ()).append (" ").append (student.getLastName ()).append (System.lineSeparator ());
            }
        }
        return sb.toString ().trim ();
    }
    public Student getStudent(String firstName, String lastName){
        for (Student st : this.data) {
            if (st.getFirstName ().equals (firstName)&&st.getLastName ().equals (lastName)){
                return st;
            }
        }
        return null;
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder ("Classroom size: " + this.data.size ());
        sb.append (System.lineSeparator ());

        for (Student st : this.data) {
            sb.append (st.toString ()).append (System.lineSeparator ());
        }
        return sb.toString ().trim ();
    }

}
