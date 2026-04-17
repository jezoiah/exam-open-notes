// ==== MEGA INSTRUCTOR ====
// WHAT: Extends Person, manages teaching assignments
// WHEN: Instructor with courses and salary
// HOW: Inherits Person, adds department, courses, pay

import java.util.ArrayList;

public class MegaInstructor extends Person {
    
    private String employeeId;
    private String department;
    private double monthlySalary;
    private ArrayList<String> teachingCourses;
    private static int instructorCount = 5000;
    
    public MegaInstructor(String name, int age, String personId,
                          String dept, double salary) {
        super(name, age, personId);
        this.employeeId = "E" + instructorCount++;
        this.department = dept;
        this.monthlySalary = salary;
        this.teachingCourses = new ArrayList<>();
    }
    
    // ==== GETTERS/SETTERS ====
    public String getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }
    public void setDepartment(String dept) { this.department = dept; }
    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double salary) { this.monthlySalary = salary; }
    
    // ==== COURSE MANAGEMENT ====
    public void assignCourse(String courseCode) {
        teachingCourses.add(courseCode);
    }
    
    public void removeCourse(String courseCode) {
        teachingCourses.remove(courseCode);
    }
    
    public ArrayList<String> getTeachingCourses() {
        return teachingCourses;
    }
    
    // ==== CALCULATIONS ====
    public double getAnnualSalary() {
        return monthlySalary * 12;
    }
    
    public boolean isTeachingCourse(String code) {
        return teachingCourses.contains(code);
    }
    
    public boolean isSenior() {
        return teachingCourses.size() >= 3;
    }
    
    // ==== OVERRIDE ====
    @Override
    public void displayInfo() {
        System.out.println("\n=== Instructor ===");
        System.out.println("Employee ID: " + employeeId);
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Monthly: $" + monthlySalary);
        System.out.println("Annual: $" + getAnnualSalary());
        System.out.println("Teaching: " + teachingCourses);
        System.out.println("Senior: " + isSenior());
    }
}
