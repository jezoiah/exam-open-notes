// ==== MEGA COURSE ====
// WHAT: Advanced course with full enrollment management
// WHEN: Need course with students, grades, capacity
// HOW: Composition with ArrayList<MegaStudent>

import java.util.ArrayList;

public class MegaCourse {
    
    private String courseCode;
    private String courseName;
    private String instructor;
    private int maxCapacity;
    private int credits;
    private ArrayList<MegaStudent> enrolledStudents;
    private ArrayList<Double> studentGrades;
    
    public MegaCourse(String code, String name, String instructor, 
                      int capacity, int credits) {
        this.courseCode = code;
        this.courseName = name;
        this.instructor = instructor;
        this.maxCapacity = capacity;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
        this.studentGrades = new ArrayList<>();
    }
    
    // ==== GETTERS ====
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getCredits() { return credits; }
    public int getEnrollment() { return enrolledStudents.size(); }
    
    // ==== ENROLLMENT ====
    public boolean enrollStudent(MegaStudent s) {
        if (enrolledStudents.size() >= maxCapacity) {
            System.out.println("Course " + courseCode + " is FULL!");
            return false;
        }
        if (enrolledStudents.contains(s)) {
            System.out.println(s.getName() + " already enrolled!");
            return false;
        }
        
        enrolledStudents.add(s);
        studentGrades.add(0.0);
        s.enrollInCourse(courseCode);
        System.out.println(s.getName() + " enrolled in " + courseCode);
        return true;
    }
    
    public boolean dropStudent(MegaStudent s) {
        int index = enrolledStudents.indexOf(s);
        if (index >= 0) {
            enrolledStudents.remove(index);
            studentGrades.remove(index);
            s.dropCourse(courseCode);
            System.out.println(s.getName() + " dropped from " + courseCode);
            return true;
        }
        return false;
    }
    
    // ==== GRADES ====
    public void assignGrade(MegaStudent s, double grade) {
        int index = enrolledStudents.indexOf(s);
        if (index >= 0) {
            studentGrades.set(index, grade);
        }
    }
    
    public double getStudentGrade(MegaStudent s) {
        int index = enrolledStudents.indexOf(s);
        return (index >= 0) ? studentGrades.get(index) : -1;
    }
    
    public double getClassAverage() {
        if (studentGrades.isEmpty()) return 0.0;
        double sum = 0;
        for (double g : studentGrades) sum += g;
        return sum / studentGrades.size();
    }
    
    // ==== UTILITY ====
    public int getAvailableSeats() {
        return maxCapacity - enrolledStudents.size();
    }
    
    public boolean hasStudent(MegaStudent s) {
        return enrolledStudents.contains(s);
    }
    
    // ==== DISPLAY ====
    public void displayInfo() {
        System.out.println("\n=== " + courseCode + " ===");
        System.out.println("Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Credits: " + credits);
        System.out.println("Enrollment: " + getEnrollment() + "/" + maxCapacity);
        System.out.println("Available: " + getAvailableSeats());
        System.out.println("Class Average: " + String.format("%.2f", getClassAverage()));
    }
    
    public void displayRoster() {
        System.out.println("\n--- " + courseCode + " Roster ---");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }
        for (int i = 0; i < enrolledStudents.size(); i++) {
            MegaStudent s = enrolledStudents.get(i);
            System.out.println((i+1) + ". " + s.getName() + 
                             " (" + s.getStudentId() + ") - " + 
                             studentGrades.get(i));
        }
    }
}
