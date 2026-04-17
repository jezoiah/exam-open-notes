// ==== STUDENT MANAGER CLASS ====
// WHAT: Manages collection of Student objects
// WHEN: CRUD operations, search, statistics
// HOW: ArrayList + static counter + encapsulation

import java.util.ArrayList;

public class StudentManager {
    
    // ==== STATIC FIELDS ====
    private static int totalStudents = 0;
    private static int nextId = 1000;
    
    // ==== INSTANCE FIELD ====
    private ArrayList<Student> students;
    
    // ==== CONSTRUCTOR ====
    public StudentManager() {
        this.students = new ArrayList<>();
    }
    
    // ==== ADD STUDENT ====
    public void addStudent(String name, int age, String major, double gpa) {
        String studentId = "S" + nextId++;
        String personId = "P" + (nextId - 1000);
        
        Student s = new Student(name, age, personId, studentId, major, gpa);
        students.add(s);
        totalStudents++;
        
        System.out.println("Added: " + name + " (ID: " + studentId + ")");
    }
    
    // ==== DISPLAY ALL ====
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        
        System.out.println("\n--- All Students ---");
        for (Student s : students) {
            s.displayInfo();
            System.out.println();
        }
    }
    
    // ==== SEARCH BY ID ====
    public Student findByStudentId(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }
    
    // ==== SEARCH BY NAME ====
    public ArrayList<Student> findByName(String name) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }
    
    // ==== REMOVE STUDENT ====
    public boolean removeStudent(String studentId) {
        Student s = findByStudentId(studentId);
        if (s != null) {
            students.remove(s);
            totalStudents--;
            System.out.println("Removed: " + s.getName());
            return true;
        }
        System.out.println("Student not found: " + studentId);
        return false;
    }
    
    // ==== UPDATE GPA ====
    public boolean updateGpa(String studentId, double newGpa) {
        Student s = findByStudentId(studentId);
        if (s != null) {
            s.setGpa(newGpa);
            System.out.println("Updated GPA for " + s.getName());
            return true;
        }
        return false;
    }
    
    // ==== STATISTICS ====
    public void displayStatistics() {
        if (students.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        
        double totalGpa = 0;
        int honorCount = 0;
        double maxGpa = 0;
        String topStudent = "";
        
        for (Student s : students) {
            double gpa = s.getGpa();
            totalGpa += gpa;
            
            if (s.isHonorStudent()) {
                honorCount++;
            }
            
            if (gpa > maxGpa) {
                maxGpa = gpa;
                topStudent = s.getName();
            }
        }
        
        double averageGpa = totalGpa / students.size();
        
        System.out.println("\n--- Statistics ---");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Average GPA: " + String.format("%.2f", averageGpa));
        System.out.println("Honor Students: " + honorCount);
        System.out.println("Top Student: " + topStudent + " (GPA: " + maxGpa + ")");
    }
    
    // ==== STATIC GETTERS ====
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    public int getStudentCount() {
        return students.size();
    }
}
