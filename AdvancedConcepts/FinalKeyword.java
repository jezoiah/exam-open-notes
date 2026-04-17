// ==== FINAL KEYWORD ====
// WHAT: Makes variables, methods, or classes unchangeable
// WHEN: Constants, prevent override, prevent inheritance
// HOW: final modifier

public class FinalKeyword {
    
    // ==== FINAL VARIABLE (CONSTANT) ====
    // WHAT: Value cannot change after assignment
    // WHEN: Mathematical constants, fixed configuration
    // HOW: final Type NAME = value;
    
    public static final double PI = 3.14159;
    public static final int MAX_STUDENTS = 30;
    public static final String SCHOOL_NAME = "University of Java";
    
    // ==== FINAL INSTANCE VARIABLE ====
    // WHAT: Must be assigned in constructor, then never changes
    // WHEN: Object has immutable property
    // HOW: final Type field;
    
    private final String id;  // Set once in constructor
    private String name;       // Can change
    
    public FinalKeyword(String id, String name) {
        this.id = id;  // Assign final variable
        this.name = name;
        // this.id = "new";  // ERROR! Cannot reassign final
    }
    
    public String getId() {
        return id;  // Can read
    }
    
    public void setName(String name) {
        this.name = name;  // OK, not final
    }
    
    // ==== FINAL METHOD ====
    // WHAT: Cannot be overridden by subclasses
    // WHEN: Critical algorithm that must not change
    // HOW: final ReturnType methodName()
    
    public final void displayId() {
        System.out.println("ID: " + id);
    }
    
    // ==== FINAL PARAMETER ====
    // WHAT: Parameter cannot be modified in method
    // WHEN: Ensure input not changed
    // HOW: final Type paramName
    
    public void process(final int value) {
        // value = 10;  // ERROR! Cannot modify final parameter
        System.out.println("Processing: " + value);
    }
    
    public static void main(String[] args) {
        System.out.println("=== FINAL KEYWORD DEMONSTRATION ===\n");
        
        // ==== CONSTANTS ====
        System.out.println("1. Constants (static final):");
        System.out.println("PI: " + PI);
        System.out.println("MAX_STUDENTS: " + MAX_STUDENTS);
        System.out.println("SCHOOL: " + SCHOOL_NAME);
        // PI = 3.14;  // ERROR! Cannot modify final
        
        // ==== FINAL INSTANCE VARIABLE ====
        System.out.println("\n2. Final instance variable:");
        FinalKeyword obj1 = new FinalKeyword("P001", "Alice");
        FinalKeyword obj2 = new FinalKeyword("P002", "Bob");
        
        System.out.println("obj1 ID: " + obj1.getId());  // P001
        System.out.println("obj2 ID: " + obj2.getId());  // P002
        // obj1.id = "P003";  // ERROR! Cannot change
        
        // ==== FINAL LOCAL VARIABLE ====
        System.out.println("\n3. Final local variable:");
        final int maxAttempts = 3;
        System.out.println("Max attempts: " + maxAttempts);
        // maxAttempts = 5;  // ERROR!
        
        // ==== FINAL REFERENCE ====
        System.out.println("\n4. Final reference (tricky!):");
        final StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");  // OK! Object state can change
        System.out.println("Modified: " + sb.toString());
        
        // sb = new StringBuilder("New");  // ERROR! Cannot reassign reference
        
        // ==== FINAL ARRAY ====
        final int[] numbers = {1, 2, 3};
        numbers[0] = 100;  // OK! Array contents can change
        System.out.println("\n5. Final array (contents mutable):");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        // numbers = new int[5];  // ERROR! Cannot reassign
        
        // ==== BLANK FINAL ====
        // Declared final, assigned later (must be exactly once)
        final int blankFinal;
        blankFinal = 42;  // First assignment OK
        // blankFinal = 100;  // ERROR! Already assigned
        System.out.println("\n\n6. Blank final: " + blankFinal);
        
        System.out.println("\n=== KEY TAKEAWAYS ===");
        System.out.println("final variable: value/reference cannot change");
        System.out.println("final method: cannot be overridden");
        System.out.println("final class: cannot be extended (no subclasses)");
        System.out.println("static final: class-level constant");
    }
}

// ==== FINAL CLASS ====
// WHAT: Cannot be extended (no inheritance)
// WHEN: Security, immutability (like String class)
// HOW: final class ClassName

final class SecureConfiguration {
    private final String apiKey;
    
    public SecureConfiguration(String key) {
        this.apiKey = key;
    }
    
    // This class cannot have subclasses!
}

// class HackedConfig extends SecureConfiguration {}  // ERROR! Cannot extend final
