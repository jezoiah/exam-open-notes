// ==== STATIC MEMBERS ====
// WHAT: Belongs to class, not instance
// WHEN: Utility methods, counters, shared constants
// HOW: Use static for methods and fields

public class StaticMethods {
    
    // ==== STATIC FIELD ====
    // WHAT: Shared across all objects
    // WHEN: Count instances, store class-wide data
    // HOW: private static Type name;
    
    private static int objectCount = 0;  // counts how many created
    private static final String VERSION = "1.0";  // constant
    
    // ==== INSTANCE FIELD ====
    // WHAT: Unique to each object
    // WHEN: Object-specific data
    // HOW: private Type name;
    
    private String name;
    private int id;
    
    // ==== CONSTRUCTOR WITH STATIC COUNTER ====
    // WHAT: Track how many objects created
    // WHEN: Need statistics across all instances
    // HOW: increment static in constructor
    
    public StaticMethods(String name) {
        this.name = name;
        this.id = ++objectCount;  // each gets unique ID
    }
    
    // ==== INSTANCE METHOD ====
    // WHAT: Needs object data to work
    // WHEN: Accessing instance fields
    // HOW: No static keyword
    
    public String getInfo() {
        return "ID " + this.id + ": " + this.name;
    }
    
    // ==== STATIC METHOD ====
    // WHAT: Works without object instance
    // WHEN: Utility calculations, class info
    // HOW: public static ReturnType methodName()
    
    public static int getObjectCount() {
        return objectCount;  // accesses static field
    }
    
    public static String getVersion() {
        return VERSION;
    }
    
    // ==== STATIC UTILITY METHOD ====
    // WHAT: Helper that doesn't need object state
    // WHEN: Math, validation, formatting
    // HOW: Call via ClassName.method(), not object.method()
    
    public static boolean isValidId(int id) {
        return id > 0 && id <= objectCount;
    }
    
    // ==== MAIN: DEMONSTRATION ====
    
    public static void main(String[] args) {
        // Access static methods WITHOUT creating object
        System.out.println("Version: " + StaticMethods.getVersion());
        System.out.println("Initial count: " + StaticMethods.getObjectCount());
        
        // Create objects
        StaticMethods obj1 = new StaticMethods("First");
        StaticMethods obj2 = new StaticMethods("Second");
        StaticMethods obj3 = new StaticMethods("Third");
        
        // Instance methods need object
        System.out.println(obj1.getInfo());  // ID 1
        System.out.println(obj2.getInfo());  // ID 2
        
        // Static method via class (preferred) or object
        System.out.println("Total created: " + StaticMethods.getObjectCount());
        
        // Static utility
        boolean valid = StaticMethods.isValidId(2);
        System.out.println("ID 2 valid? " + valid);
    }
}
