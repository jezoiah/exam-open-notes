// ==== OOP CONCEPTS TEST DEMONSTRATION ====
// WHAT: Shows all OOP concepts working together
// WHEN: Testing inheritance, polymorphism, encapsulation
// HOW: Create objects, call methods, verify behavior

public class OOPTestMain {
    public static void main(String[] args) {
        
        // ==== PARENT CLASS OBJECT ====
        // WHAT: Using Person class directly
        // WHEN: General person data needed
        // HOW: new Person(name, age, id)
        
        Person person1 = new Person("Alice", 30, "P001");
        
        System.out.println("--- Person Object ---");
        System.out.println("Name: " + person1.getName());  // getter
        person1.displayInfo();  // parent version
        
        // ==== CHILD CLASS OBJECT ====
        // WHAT: Using Student (extends Person)
        // WHEN: Student-specific data needed
        // HOW: new Student(name, age, id, studentId, major, gpa)
        
        Student student1 = new Student("Bob", 20, "P002", 
                                       "S100", "Computer Science", 3.8);
        
        System.out.println("\n--- Student Object ---");
        System.out.println("Inherited name: " + student1.getName());  // inherited getter
        System.out.println("Student ID: " + student1.getStudentId());   // own getter
        
        // ==== METHOD OVERRIDING IN ACTION ====
        // WHAT: Same method name, different output
        // WHEN: Student needs different display format
        // HOW: Override in child, call to see new behavior
        
        student1.displayInfo();  // Student's version (overridden)
        
        // ==== POLYMORPHISM ====
        // WHAT: Parent reference holds child object
        // WHEN: Treat different types uniformly
        // HOW: Person p = new Student(...); p.displayInfo() calls Student version
        
        Person polyPerson = new Student("Carol", 22, "P003",
                                        "S101", "Math", 3.2);
        
        System.out.println("\n--- Polymorphism Demo ---");
        polyPerson.displayInfo();  // calls Student's displayInfo() due to override
        
        // ==== BOOLEAN METHODS ====
        // WHAT: Methods returning true/false
        // WHEN: Status checks, validation
        // HOW: Use return value in if conditions
        
        boolean isHonor = student1.isHonorStudent();
        System.out.println("\nIs honor student: " + isHonor);
        
        if (student1.isHonorStudent()) {  // boolean in if
            System.out.println(student1.getName() + " is on honor roll");
        }
        
        // ==== MODIFY VIA SETTERS ====
        // WHAT: Update object state
        // WHEN: Changing values after creation
        // HOW: object.setField(newValue)
        
        student1.setGpa(3.9);
        System.out.println("\nUpdated GPA: " + student1.getGpa());
        System.out.println("New status: " + student1.getAcademicStatus());
        
        // ==== MULTIPLE STUDENTS ====
        // WHAT: Array of objects
        // WHEN: Managing collections
        // HOW: Type[] array = new Type[size];
        
        Student[] students = new Student[2];
        students[0] = student1;
        students[1] = new Student("Dan", 19, "P004", "S102", "Physics", 2.8);
        
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s.getName() + " - " + s.getAcademicStatus());
        }
        
        // ==== ENCAPSULATION CHECK ====
        // WHAT: Cannot access private fields directly
        // WHEN: Must use getters/setters
        // HOW: this.name is private, use getName() instead
        
        // WRONG: person1.name (private, won't compile)
        // CORRECT: person1.getName() (public getter)
        
        System.out.println("\n--- Encapsulation Verified ---");
        System.out.println("Access through getters only: " + person1.getName());
    }
}
