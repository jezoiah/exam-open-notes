// ==== INHERITANCE: CHILD CLASS ====
// WHAT: Extends parent, adds/overrides behavior
// WHEN: Specialized version of general class
// HOW: public class Child extends Parent { }

public class Student extends Person {
    
    // ==== ADDITIONAL PRIVATE FIELDS ====
    // WHAT: Fields unique to child class
    // WHEN: Child has extra attributes
    // HOW: Same encapsulation pattern
    
    private String studentId;
    private String major;
    private double gpa;
    
    // ==== CONSTRUCTOR WITH SUPER() ====
    // WHAT: Call parent constructor for inherited fields
    // WHEN: Initialize parent portion first
    // HOW: super(parentArgs) must be first line
    
    public Student(String name, int age, String id, 
                   String studentId, String major, double gpa) {
        super(name, age, id);  // initialize Person fields
        this.studentId = studentId;
        this.major = major;
        this.gpa = gpa;
    }
    
    // ==== GETTERS FOR NEW FIELDS ====
    
    public String getStudentId() {
        return this.studentId;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public double getGpa() {
        return this.gpa;
    }
    
    // ==== SETTERS FOR NEW FIELDS ====
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        }
    }
    
    // ==== METHOD OVERRIDING (@OVERRIDE) ====
    // WHAT: Replace parent method with specialized version
    // WHEN: Child needs different behavior
    // HOW: Same signature, add @Override annotation
    
    @Override
    public void displayInfo() {
        // Option: call parent version first
        // super.displayInfo();
        
        System.out.println("=== Student Info ===");
        System.out.println("Name: " + getName());  // inherited getter
        System.out.println("Age: " + getAge());    // inherited getter
        System.out.println("Person ID: " + getId());  // inherited getter
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Major: " + this.major);
        System.out.println("GPA: " + this.gpa);
    }
    
    // ==== ADDITIONAL METHOD ====
    // WHAT: Behavior unique to student
    // WHEN: Child-specific functionality
    // HOW: Regular method
    
    public boolean isHonorStudent() {
        return this.gpa >= 3.5;  // boolean return
    }
    
    public String getAcademicStatus() {
        if (this.gpa >= 3.5) {
            return "Honor";
        } else if (this.gpa >= 2.0) {
            return "Good Standing";
        } else {
            return "Probation";
        }
    }
    
    // ==== OVERRIDE TOSTRING() ====
    
    @Override
    public String toString() {
        return "Student[name=" + getName() + 
               ", major=" + major + 
               ", gpa=" + gpa + "]";
    }
}
