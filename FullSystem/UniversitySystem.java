// ==== UNIVERSITY SYSTEM MAIN ====
// WHAT: Complete integrated system with menu
// WHEN: Full application demonstrating all OOP concepts
// HOW: Scanner input, loops, switch-case, object interactions

import java.util.Scanner;
import java.util.ArrayList;

public class UniversitySystem {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // ==== CREATE MANAGER AND COURSES ====
        StudentManager manager = new StudentManager();
        Course cs101 = new Course("CS101", "Intro to Programming", 3);
        Course math201 = new Course("MATH201", "Calculus II", 2);
        
        // ==== ADD SAMPLE DATA ====
        manager.addStudent("Alice Johnson", 20, "Computer Science", 3.8);
        manager.addStudent("Bob Smith", 21, "Mathematics", 3.5);
        manager.addStudent("Carol White", 19, "Computer Science", 3.2);
        
        // Enroll sample students
        Student s1 = manager.findByStudentId("S1000");
        Student s2 = manager.findByStudentId("S1001");
        if (s1 != null) cs101.enrollStudent(s1);
        if (s2 != null) math201.enrollStudent(s2);
        
        // ==== MAIN LOOP ====
        boolean running = true;
        
        while (running) {
            // ==== MENU DISPLAY ====
            System.out.println("\n====== UNIVERSITY SYSTEM ======");
            System.out.println("1. Add New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Student GPA");
            System.out.println("6. Remove Student");
            System.out.println("7. Display Statistics");
            System.out.println("8. Enroll in Course");
            System.out.println("9. View Course Info");
            System.out.println("10. Exit");
            System.out.print("\nChoice: ");
            
            // ==== INPUT WITH VALIDATION ====
            int choice = 0;
            if (input.hasNextInt()) {
                choice = input.nextInt();
            }
            input.nextLine();  // clear buffer
            
            // ==== SWITCH-CASE HANDLING ====
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    System.out.print("Age: ");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.print("Major: ");
                    String major = input.nextLine();
                    System.out.print("GPA: ");
                    double gpa = input.nextDouble();
                    input.nextLine();
                    manager.addStudent(name, age, major, gpa);
                    break;
                    
                case 2:
                    manager.displayAllStudents();
                    break;
                    
                case 3:
                    System.out.print("Enter Student ID (e.g., S1000): ");
                    String id = input.nextLine();
                    Student found = manager.findByStudentId(id);
                    if (found != null) {
                        found.displayInfo();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = input.nextLine();
                    ArrayList<Student> results = manager.findByName(searchName);
                    if (results.isEmpty()) {
                        System.out.println("No matches found.");
                    } else {
                        System.out.println("Found " + results.size() + " student(s):");
                        for (Student s : results) {
                            System.out.println("- " + s.getName() + " (" + s.getStudentId() + ")");
                        }
                    }
                    break;
                    
                case 5:
                    System.out.print("Student ID: ");
                    String updateId = input.nextLine();
                    System.out.print("New GPA: ");
                    double newGpa = input.nextDouble();
                    input.nextLine();
                    manager.updateGpa(updateId, newGpa);
                    break;
                    
                case 6:
                    System.out.print("Student ID to remove: ");
                    String removeId = input.nextLine();
                    manager.removeStudent(removeId);
                    break;
                    
                case 7:
                    manager.displayStatistics();
                    break;
                    
                case 8:
                    System.out.println("Courses: 1. CS101  2. MATH201");
                    System.out.print("Select course (1 or 2): ");
                    int courseChoice = input.nextInt();
                    input.nextLine();
                    System.out.print("Student ID: ");
                    String enrollId = input.nextLine();
                    Student toEnroll = manager.findByStudentId(enrollId);
                    if (toEnroll != null) {
                        if (courseChoice == 1) {
                            cs101.enrollStudent(toEnroll);
                        } else if (courseChoice == 2) {
                            math201.enrollStudent(toEnroll);
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                    
                case 9:
                    cs101.display(true);
                    math201.display(true);
                    break;
                    
                case 10:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        }
        
        input.close();
    }
}
