// ==== MEGA STUDENT ====
// WHAT: Extends Student with enrollment tracking
// WHEN: Need student with course management
// HOW: Inherits from Student, adds ArrayList for courses

import java.util.ArrayList;

public class MegaStudent extends Student {
    
    private ArrayList<String> enrolledCourses;
    private static int totalMegaStudents = 0;
    
    public MegaStudent(String name, int age, String id, 
                       String studentId, String major, double gpa) {
        super(name, age, id, studentId, major, gpa);
        this.enrolledCourses = new ArrayList<>();
        totalMegaStudents++;
    }
    
    // ==== COURSE ENROLLMENT ====
    public void enrollInCourse(String courseCode) {
        if (!enrolledCourses.contains(courseCode)) {
            enrolledCourses.add(courseCode);
        }
    }
    
    public void dropCourse(String courseCode) {
        enrolledCourses.remove(courseCode);
    }
    
    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }
    
    public int getCourseCount() {
        return enrolledCourses.size();
    }
    
    public static int getTotalMegaStudents() {
        return totalMegaStudents;
    }
    
    // ==== OVERRIDE DISPLAY ====
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Enrolled Courses: " + enrolledCourses);
        System.out.println("Course Count: " + getCourseCount());
    }
    
    // ==== FILE FORMAT ====
    public String toFileString() {
        return getName() + "," + getAge() + "," + getId() + "," +
               getStudentId() + "," + getMajor() + "," + getGpa();
    }
}
