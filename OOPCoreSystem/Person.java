// ==== ENCAPSULATION: PARENT CLASS ====
// WHAT: Private fields with public getters/setters
// WHEN: Data hiding, controlled access, validation
// HOW: Copy structure, change field names and types

public class Person {
    
    // ==== PRIVATE FIELDS ====
    // WHAT: Data hidden from direct access
    // WHEN: Protect internal state
    // HOW: private Type fieldName;
    
    private String name;
    private int age;
    private String id;
    
    // ==== DEFAULT CONSTRUCTOR ====
    // WHAT: No-argument constructor
    // WHEN: Object creation without initial values
    // HOW: public ClassName() { }
    
    public Person() {
        // Can set defaults here
        this.name = "";
        this.age = 0;
        this.id = "";
    }
    
    // ==== PARAMETERIZED CONSTRUCTOR ====
    // WHAT: Constructor with initial values
    // WHEN: Create fully initialized object
    // HOW: public ClassName(Type param) { this.field = param; }
    
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    
    // ==== GETTER METHODS ====
    // WHAT: Read private field values
    // WHEN: Need to access field outside class
    // HOW: public Type getFieldName() { return field; }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String getId() {
        return this.id;
    }
    
    // ==== SETTER METHODS ====
    // WHAT: Modify private field values
    // WHEN: Update object state
    // HOW: public void setFieldName(Type value) { this.field = value; }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        // Can add validation in setters
        if (age >= 0) {
            this.age = age;
        }
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    // ==== DISPLAY METHOD (TO BE OVERRIDDEN) ====
    // WHAT: Show object state
    // WHEN: Testing, logging
    // HOW: Print fields, return string
    
    public void displayInfo() {
        System.out.println("=== Person Info ===");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("ID: " + this.id);
    }
    
    // ==== TOSTRING() ====
    // WHAT: String representation of object
    // WHEN: Printing object directly
    // HOW: Override Object class method
    
    public String toString() {
        return "Person[name=" + name + ", age=" + age + ", id=" + id + "]";
    }
}
