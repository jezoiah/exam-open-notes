// ==== COURSE CLASS ====
// WHAT: Demonstrates composition with Student
// WHEN: Course enrollment, grade tracking
// HOW: Course has enrolled Students (ArrayList)

import java.util.ArrayList;

public class Course {
    
    // ==== PRIVATE FIELDS ====
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private ArrayList<Student> enrolledStudents;
    
    // ==== CONSTRUCTOR ====
    public Course(String code, String name, int capacity) {
        this.courseCode = code;
        this.courseName = name;
        this.maxCapacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }
    
    // ==== GETTERS ====
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public int getMaxCapacity() {
        return maxCapacity;
    }
    
    // ==== ENROLLMENT METHODS ====
    
    public boolean enrollStudent(Student s) {
        if (enrolledStudents.size() >= maxCapacity) {
            System.out.println("Course is full!");
            return false;
        }
        
        if (enrolledStudents.contains(s)) {
            System.out.println("Student already enrolled!");
            return false;
        }
        
        enrolledStudents.add(s);
        System.out.println(s.getName() + " enrolled in " + courseCode);
        return true;
    }
    
    public boolean dropStudent(Student s) {
        if (enrolledStudents.remove(s)) {
            System.out.println(s.getName() + " dropped from " + courseCode);
            return true;
        }
        System.out.println("Student not found in course.");
        return false;
    }
    
    // ==== DISPLAY METHODS ====
    
    public void displayCourseInfo() {
        System.out.println("\n--- Course Info ---");
        System.out.println("Code: " + courseCode);
        System.out.println("Name: " + courseName);
        System.out.println("Capacity: " + enrolledStudents.size() + "/" + maxCapacity);
    }
    
    public void displayEnrolledStudents() {
        System.out.println("\n--- Enrolled in " + courseCode + " ---");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }
        
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName() + " (" + s.getStudentId() + ")");
        }
    }
    
    // ==== UTILITY METHODS ====
    
    public int getAvailableSeats() {
        return maxCapacity - enrolledStudents.size();
    }
    
    public boolean hasStudent(Student s) {
        return enrolledStudents.contains(s);
    }
    
    public double getAverageGpaOfEnrolled() {
        if (enrolledStudents.isEmpty()) {
            return 0.0;
        }
        
        double total = 0;
        for (Student s : enrolledStudents) {
            total += s.getGpa();
        }
        return total / enrolledStudents.size();
    }
    
    // ==== OVERLOADED DISPLAY ====
    
    public void display(boolean showDetails) {
        if (showDetails) {
            displayCourseInfo();
            displayEnrolledStudents();
        } else {
            System.out.println(courseCode + ": " + courseName + 
                             " (" + enrolledStudents.size() + "/" + maxCapacity + ")");
        }
    }
}
