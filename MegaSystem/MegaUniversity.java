// ==== MEGA UNIVERSITY MAIN ====
// WHAT: 1000+ line system using separate OOP files
// WHEN: Full exam demonstration with proper inheritance
// HOW: Uses MegaStudent, MegaCourse, MegaInstructor via imports
// Requires: Student.java, Person.java from OOPCoreSystem

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

// NOTE: Compile with: javac MegaSystem/*.java OOPCoreSystem/*.java
// Classes from OOPCoreSystem: Person, Student

public class MegaUniversity {
    
    // ==== MANAGERS (Static for system-wide access) ====
    private static ArrayList<MegaStudent> students = new ArrayList<>();
    private static ArrayList<MegaCourse> courses = new ArrayList<>();
    private static ArrayList<MegaInstructor> instructors = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static boolean running = true;
    private static int nextPersonId = 100;
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   MEGA UNIVERSITY - OOP EDITION v3.0");
        System.out.println("   Proper Inheritance + Composition");
        System.out.println("========================================");
        
        initializeData();
        
        while (running) {
            showMenu();
            int choice = getInt("Choice: ");
            
            switch (choice) {
                case 1: studentManagement(); break;
                case 2: courseManagement(); break;
                case 3: instructorManagement(); break;
                case 4: enrollmentSystem(); break;
                case 5: gradingSystem(); break;
                case 6: reportsAndStats(); break;
                case 7: searchOperations(); break;
                case 8: fileOperations(); break;
                case 9: demoAllConcepts(); break;
                case 0: 
                    running = false;
                    System.out.println("System shutting down...");
                    break;
                default: System.out.println("Invalid!");
            }
        }
        
        input.close();
    }
    
    // ============================================
    // SECTION 1: INITIALIZATION
    // ============================================
    
    private static void initializeData() {
        // Create students using inheritance chain
        addStudent("Alice Johnson", 20, "Computer Science", 3.8);
        addStudent("Bob Smith", 21, "Mathematics", 3.5);
        addStudent("Carol White", 19, "Computer Science", 3.2);
        addStudent("David Lee", 22, "Physics", 2.8);
        addStudent("Emma Brown", 20, "Mathematics", 3.9);
        addStudent("Frank Chen", 21, "Computer Science", 3.6);
        addStudent("Grace Taylor", 19, "Physics", 3.1);
        addStudent("Henry Wilson", 22, "Mathematics", 2.9);
        
        // Create courses
        addCourse("CS101", "Intro to Programming", "Dr. Turing", 30, 3);
        addCourse("CS201", "Data Structures", "Dr. Hopper", 25, 4);
        addCourse("CS301", "Algorithms", "Dr. Knuth", 20, 4);
        addCourse("MATH101", "Calculus I", "Dr. Newton", 40, 4);
        addCourse("MATH201", "Linear Algebra", "Dr. Noether", 20, 3);
        addCourse("PHY101", "General Physics", "Dr. Einstein", 35, 4);
        
        // Create instructors
        addInstructor("Dr. Alan Turing", 45, "Computer Science", 8000);
        addInstructor("Dr. Grace Hopper", 50, "Computer Science", 8500);
        addInstructor("Dr. Isaac Newton", 60, "Mathematics", 9000);
        addInstructor("Dr. Albert Einstein", 55, "Physics", 9500);
        
        // Enroll some students
        enroll("S1000", "CS101");
        enroll("S1001", "CS101");
        enroll("S1000", "MATH101");
        enroll("S1002", "CS201");
        
        System.out.println("System initialized with " + students.size() + 
                          " students, " + courses.size() + " courses.\n");
    }
    
    private static void addStudent(String name, int age, String major, double gpa) {
        String id = "P" + nextPersonId++;
        String sid = "S" + (1000 + students.size());
        MegaStudent s = new MegaStudent(name, age, id, sid, major, gpa);
        students.add(s);
    }
    
    private static void addCourse(String code, String name, String inst, int cap, int cred) {
        courses.add(new MegaCourse(code, name, inst, cap, cred));
    }
    
    private static void addInstructor(String name, int age, String dept, double salary) {
        String id = "P" + nextPersonId++;
        instructors.add(new MegaInstructor(name, age, id, dept, salary));
    }
    
    // ============================================
    // SECTION 2: MENUS
    // ============================================
    
    private static void showMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Instructor Management");
        System.out.println("4. Enrollment System");
        System.out.println("5. Grading System");
        System.out.println("6. Reports & Statistics");
        System.out.println("7. Search Operations");
        System.out.println("8. File Operations");
        System.out.println("9. Demo: All Java Concepts");
        System.out.println("0. Exit");
    }
    
    private static void studentManagement() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- STUDENT MANAGEMENT ---");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student Details");
            System.out.println("4. Update Student GPA");
            System.out.println("5. Remove Student");
            System.out.println("6. View Honor Students");
            System.out.println("7. Students by Major");
            System.out.println("8. Student Schedule");
            System.out.println("9. Back");
            
            int c = getInt("Choice: ");
            switch (c) {
                case 1:
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    int age = getInt("Age: ");
                    System.out.print("Major: ");
                    String major = input.nextLine();
                    double gpa = getDouble("GPA: ");
                    addStudent(name, age, major, gpa);
                    System.out.println("Student added!");
                    break;
                    
                case 2:
                    System.out.println("\n--- ALL STUDENTS ---");
                    for (MegaStudent s : students) {
                        System.out.println(s.getStudentId() + ": " + s.getName() + 
                                         " (" + s.getMajor() + ", GPA: " + s.getGpa() + ")");
                    }
                    break;
                    
                case 3:
                    System.out.print("Student ID: ");
                    MegaStudent s = findStudent(input.nextLine());
                    if (s != null) s.displayInfo();
                    else System.out.println("Not found!");
                    break;
                    
                case 4:
                    System.out.print("Student ID: ");
                    MegaStudent us = findStudent(input.nextLine());
                    if (us != null) {
                        double ng = getDouble("New GPA: ");
                        us.setGpa(ng);
                        System.out.println("Updated!");
                    }
                    break;
                    
                case 5:
                    System.out.print("Student ID to remove: ");
                    String rid = input.nextLine();
                    MegaStudent rs = findStudent(rid);
                    if (rs != null) {
                        students.remove(rs);
                        System.out.println("Removed!");
                    }
                    break;
                    
                case 6:
                    System.out.println("\n--- HONOR STUDENTS (GPA >= 3.5) ---");
                    for (MegaStudent st : students) {
                        if (st.isHonorStudent()) {
                            System.out.println(st.getName() + ": " + st.getGpa());
                        }
                    }
                    break;
                    
                case 7:
                    System.out.print("Major: ");
                    String m = input.nextLine();
                    System.out.println("Students in " + m + ":");
                    for (MegaStudent st : students) {
                        if (st.getMajor().equalsIgnoreCase(m)) {
                            System.out.println("- " + st.getName());
                        }
                    }
                    break;
                    
                case 8:
                    System.out.print("Student ID: ");
                    MegaStudent sched = findStudent(input.nextLine());
                    if (sched != null) {
                        System.out.println(sched.getName() + " enrolled in:");
                        for (String cc : sched.getEnrolledCourses()) {
                            System.out.println("  " + cc);
                        }
                    }
                    break;
                    
                case 9: inMenu = false; break;
            }
        }
    }
    
    private static void courseManagement() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- COURSE MANAGEMENT ---");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. View Course Details");
            System.out.println("4. View Roster");
            System.out.println("5. Change Instructor");
            System.out.println("6. Available Seats");
            System.out.println("7. Back");
            
            int c = getInt("Choice: ");
            switch (c) {
                case 1:
                    System.out.print("Code: ");
                    String code = input.nextLine();
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    System.out.print("Instructor: ");
                    String inst = input.nextLine();
                    int cap = getInt("Capacity: ");
                    int cred = getInt("Credits: ");
                    addCourse(code, name, inst, cap, cred);
                    System.out.println("Added!");
                    break;
                    
                case 2:
                    for (MegaCourse co : courses) {
                        System.out.println(co.getCourseCode() + ": " + co.getCourseName() +
                                         " (" + co.getEnrollment() + "/" + co.getMaxCapacity() + ")");
                    }
                    break;
                    
                case 3:
                    System.out.print("Course Code: ");
                    MegaCourse mc = findCourse(input.nextLine());
                    if (mc != null) mc.displayInfo();
                    break;
                    
                case 4:
                    System.out.print("Course Code: ");
                    MegaCourse roster = findCourse(input.nextLine());
                    if (roster != null) roster.displayRoster();
                    break;
                    
                case 5:
                    System.out.print("Course Code: ");
                    MegaCourse chg = findCourse(input.nextLine());
                    if (chg != null) {
                        System.out.print("New Instructor: ");
                        chg.setInstructor(input.nextLine());
                        System.out.println("Updated!");
                    }
                    break;
                    
                case 6:
                    for (MegaCourse co : courses) {
                        System.out.println(co.getCourseCode() + ": " + co.getAvailableSeats() + " seats");
                    }
                    break;
                    
                case 7: inMenu = false; break;
            }
        }
    }
    
    private static void instructorManagement() {
        System.out.println("\n--- INSTRUCTOR MANAGEMENT ---");
        System.out.println("1. View All Instructors");
        System.out.println("2. View Details");
        System.out.println("3. By Department");
        System.out.println("4. Back");
        
        int c = getInt("Choice: ");
        switch (c) {
            case 1:
                for (MegaInstructor i : instructors) {
                    System.out.println(i.getEmployeeId() + ": " + i.getName());
                }
                break;
            case 2:
                System.out.print("Employee ID: ");
                String eid = input.nextLine();
                for (MegaInstructor i : instructors) {
                    if (i.getEmployeeId().equals(eid)) {
                        i.displayInfo();
                        break;
                    }
                }
                break;
            case 3:
                System.out.print("Department: ");
                String dept = input.nextLine();
                for (MegaInstructor i : instructors) {
                    if (i.getDepartment().equalsIgnoreCase(dept)) {
                        System.out.println("- " + i.getName());
                    }
                }
                break;
        }
    }
    
    // ============================================
    // SECTION 3: ENROLLMENT & GRADING
    // ============================================
    
    private static void enrollmentSystem() {
        System.out.println("\n--- ENROLLMENT ---");
        System.out.println("1. Enroll Student");
        System.out.println("2. Drop Student");
        System.out.println("3. Back");
        
        int c = getInt("Choice: ");
        if (c == 1) {
            System.out.print("Student ID: ");
            String sid = input.nextLine();
            System.out.print("Course Code: ");
            String cid = input.nextLine();
            enroll(sid, cid);
        } else if (c == 2) {
            System.out.print("Student ID: ");
            String sid = input.nextLine();
            System.out.print("Course Code: ");
            String cid = input.nextLine();
            MegaStudent s = findStudent(sid);
            MegaCourse co = findCourse(cid);
            if (s != null && co != null) co.dropStudent(s);
        }
    }
    
    private static void enroll(String sid, String cid) {
        MegaStudent s = findStudent(sid);
        MegaCourse c = findCourse(cid);
        if (s != null && c != null) {
            c.enrollStudent(s);
        } else {
            System.out.println("Invalid ID or code!");
        }
    }
    
    private static void gradingSystem() {
        System.out.println("\n--- GRADING ---");
        System.out.print("Course Code: ");
        MegaCourse c = findCourse(input.nextLine());
        if (c == null) {
            System.out.println("Course not found!");
            return;
        }
        
        c.displayRoster();
        System.out.print("Student ID: ");
        MegaStudent s = findStudent(input.nextLine());
        if (s != null && c.hasStudent(s)) {
            double grade = getDouble("Grade (0-100): ");
            c.assignGrade(s, grade);
            System.out.println("Grade recorded!");
        } else {
            System.out.println("Student not in this course!");
        }
    }
    
    // ============================================
    // SECTION 4: SEARCH & STATISTICS
    // ============================================
    
    private static void searchOperations() {
        System.out.println("\n--- SEARCH OPERATIONS ---");
        System.out.println("1. Search Student by Name");
        System.out.println("2. Search by Partial Name");
        System.out.println("3. Find Top GPA Student");
        System.out.println("4. Find Students in Range");
        
        int c = getInt("Choice: ");
        switch (c) {
            case 1:
                System.out.print("Exact name: ");
                String name = input.nextLine();
                for (MegaStudent s : students) {
                    if (s.getName().equalsIgnoreCase(name)) {
                        s.displayInfo();
                    }
                }
                break;
            case 2:
                System.out.print("Partial name: ");
                String partial = input.nextLine().toLowerCase();
                for (MegaStudent s : students) {
                    if (s.getName().toLowerCase().contains(partial)) {
                        System.out.println(s.getStudentId() + ": " + s.getName());
                    }
                }
                break;
            case 3:
                MegaStudent top = null;
                double max = 0;
                for (MegaStudent s : students) {
                    if (s.getGpa() > max) {
                        max = s.getGpa();
                        top = s;
                    }
                }
                if (top != null) {
                    System.out.println("Top: " + top.getName() + " with " + max);
                }
                break;
            case 4:
                double min = getDouble("Min GPA: ");
                double maxg = getDouble("Max GPA: ");
                System.out.println("Students in range " + min + "-" + maxg + ":");
                for (MegaStudent s : students) {
                    if (s.getGpa() >= min && s.getGpa() <= maxg) {
                        System.out.println("- " + s.getName() + ": " + s.getGpa());
                    }
                }
                break;
        }
    }
    
    private static void reportsAndStats() {
        System.out.println("\n--- STATISTICS ---");
        
        int total = students.size();
        double sumGpa = 0;
        int honors = 0;
        int probation = 0;
        
        for (MegaStudent s : students) {
            sumGpa += s.getGpa();
            if (s.isHonorStudent()) honors++;
            if (s.getAcademicStatus().equals("Probation")) probation++;
        }
        
        System.out.println("Total Students: " + total);
        System.out.println("Average GPA: " + String.format("%.2f", sumGpa/total));
        System.out.println("Honor Students: " + honors);
        System.out.println("On Probation: " + probation);
        
        System.out.println("\n--- COURSE STATS ---");
        for (MegaCourse c : courses) {
            System.out.println(c.getCourseCode() + ": " + c.getEnrollment() + 
                             " students, avg: " + String.format("%.2f", c.getClassAverage()));
        }
    }
    
    // ============================================
    // SECTION 5: FILE OPERATIONS
    // ============================================
    
    private static void fileOperations() {
        System.out.println("\n--- FILE OPERATIONS ---");
        System.out.println("1. Save Students to File");
        System.out.println("2. Check File Exists");
        System.out.println("3. Back");
        
        int c = getInt("Choice: ");
        if (c == 1) {
            try (PrintWriter pw = new PrintWriter(new FileWriter("students_export.txt"))) {
                for (MegaStudent s : students) {
                    pw.println(s.toFileString());
                }
                System.out.println("Saved " + students.size() + " students!");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (c == 2) {
            System.out.print("Filename: ");
            File f = new File(input.nextLine());
            System.out.println("Exists: " + f.exists());
        }
    }
    
    // ============================================
    // SECTION 6: COMPREHENSIVE DEMO
    // ============================================
    
    private static void demoAllConcepts() {
        System.out.println("\n========================================");
        System.out.println("     COMPREHENSIVE JAVA CONCEPTS DEMO");
        System.out.println("========================================");
        
        // Variables & Types
        System.out.println("\n1. VARIABLES & TYPES:");
        int whole = 42;
        double decimal = 3.14;
        boolean flag = true;
        char letter = 'A';
        String text = "Hello";
        System.out.println("int: " + whole + ", double: " + decimal + 
                        ", boolean: " + flag + ", char: " + letter + ", String: " + text);
        
        // Boolean Logic
        System.out.println("\n2. BOOLEAN LOGIC:");
        int x = 10, y = 5;
        System.out.println("x > y: " + (x > y));
        System.out.println("x < y: " + (x < y));
        System.out.println("x == 10 && y == 5: " + (x == 10 && y == 5));
        System.out.println("x > 5 || y > 10: " + (x > 5 || y > 10));
        System.out.println("!(x == y): " + !(x == y));
        
        // If-Else
        System.out.println("\n3. IF-ELSE CONDITIONS:");
        int score = 85;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
        
        // Switch
        System.out.println("\n4. SWITCH-CASE:");
        int day = 3;
        switch (day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday"); break;
            case 5: System.out.println("Friday"); break;
            default: System.out.println("Weekend"); break;
        }
        
        // For Loops
        System.out.println("\n5. FOR LOOPS:");
        System.out.print("Count 0-4: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        System.out.print("Reverse 5-1: ");
        for (int i = 5; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // While Loop
        System.out.println("\n6. WHILE LOOP:");
        int count = 0;
        while (count < 3) {
            System.out.println("While iteration: " + count);
            count++;
        }
        
        // Do-While
        System.out.println("\n7. DO-WHILE:");
        int dw = 0;
        do {
            System.out.println("Do-while: " + dw);
            dw++;
        } while (dw < 2);
        
        // Break & Continue
        System.out.println("\n8. BREAK & CONTINUE:");
        System.out.print("Numbers 0-9, skip 3, stop at 7: ");
        for (int i = 0; i < 10; i++) {
            if (i == 3) continue;
            if (i == 7) break;
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Nested Loops
        System.out.println("\n9. NESTED LOOPS (3x3):");
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                System.out.print("(" + row + "," + col + ") ");
            }
            System.out.println();
        }
        
        // Arrays
        System.out.println("\n10. ARRAYS:");
        int[] nums = {5, 2, 8, 1, 9};
        System.out.print("Array: ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println("\nLength: " + nums.length);
        
        // Find max in array
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        System.out.println("Max: " + max);
        
        // ArrayList
        System.out.println("\n11. ARRAYLIST:");
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("Size: " + list.size());
        System.out.println("Get(1): " + list.get(1));
        list.remove("Banana");
        System.out.println("After remove: " + list);
        System.out.println("Contains 'Apple': " + list.contains("Apple"));
        
        // Strings
        System.out.println("\n12. STRING METHODS:");
        String str = "Hello World";
        System.out.println("Original: " + str);
        System.out.println("Length: " + str.length());
        System.out.println("Upper: " + str.toUpperCase());
        System.out.println("Lower: " + str.toLowerCase());
        System.out.println("Substring(0,5): " + str.substring(0, 5));
        System.out.println("Contains 'World': " + str.contains("World"));
        System.out.println("Equals 'hello world': " + str.equals("hello world"));
        System.out.println("EqualsIgnoreCase: " + str.equalsIgnoreCase("hello world"));
        
        String csv = "John,25,Engineer";
        String[] parts = csv.split(",");
        System.out.println("Split result: " + parts[0] + ", " + parts[1] + ", " + parts[2]);
        
        // OOP - Inheritance Display
        System.out.println("\n13. OOP - INHERITANCE & POLYMORPHISM:");
        System.out.println("MegaStudent extends Student extends Person");
        System.out.println("Total MegaStudents created: " + MegaStudent.getTotalMegaStudents());
        
        // Static Demo
        System.out.println("\n14. STATIC MEMBERS:");
        System.out.println("Static fields shared across all objects");
        System.out.println("Students in system: " + students.size());
        
        // Composition
        System.out.println("\n15. COMPOSITION:");
        MegaCourse demoCourse = new MegaCourse("DEMO101", "Demo", "Prof", 30, 3);
        MegaStudent demoStudent = findStudent("S1000");
        if (demoStudent != null) {
            demoCourse.enrollStudent(demoStudent);
            System.out.println("Course has " + demoCourse.getEnrollment() + " student(s)");
        }
        
        // Search
        System.out.println("\n16. SEARCH ALGORITHMS:");
        System.out.println("Linear search in ArrayList completed");
        
        // File I/O
        System.out.println("\n17. FILE I/O:");
        System.out.println("FileWriter, PrintWriter, File classes available");
        
        System.out.println("\n========================================");
        System.out.println("           DEMO COMPLETE");
        System.out.println("========================================");
    }
    
    // ============================================
    // UTILITY METHODS
    // ============================================
    
    private static MegaStudent findStudent(String id) {
        for (MegaStudent s : students) {
            if (s.getStudentId().equals(id)) return s;
        }
        return null;
    }
    
    private static MegaCourse findCourse(String code) {
        for (MegaCourse c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) return c;
        }
        return null;
    }
    
    private static int getInt(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Enter integer: ");
        }
        int v = input.nextInt();
        input.nextLine();
        return v;
    }
    
    private static double getDouble(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextDouble()) {
            input.next();
            System.out.print("Enter number: ");
        }
        double v = input.nextDouble();
        input.nextLine();
        return v;
    }
}
