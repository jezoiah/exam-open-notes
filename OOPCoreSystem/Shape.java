// ==== ABSTRACT CLASS ====
// WHAT: Class that cannot be instantiated, may have abstract methods
// WHEN: Common base with some shared code, some methods must be implemented
// HOW: abstract class Name { abstract void method(); }

public abstract class Shape {
    
    // ==== PROTECTED FIELD ====
    // WHAT: Accessible to subclasses
    // WHEN: Child needs direct access
    // HOW: protected Type name;
    
    protected String name;
    protected String color;
    
    // ==== CONCRETE METHOD (shared) ====
    // WHAT: Method with implementation
    // WHEN: All subclasses use same logic
    // HOW: regular method
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String getName() {
        return this.name;
    }
    
    // ==== ABSTRACT METHOD (no body) ====
    // WHAT: Method signature without implementation
    // WHEN: Each subclass MUST implement differently
    // HOW: abstract ReturnType methodName();
    
    public abstract double getArea();
    
    public abstract double getPerimeter();
    
    // ==== ABSTRACT METHOD with parameter ====
    public abstract void scale(double factor);
    
    // ==== CONCRETE METHOD using abstract ====
    // WHAT: Uses abstract methods (polymorphism)
    // WHEN: Shared algorithm, specific implementations
    // HOW: call abstract methods inside concrete method
    
    public void printInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Color: " + color);
        System.out.println("Area: " + getArea());      // calls subclass implementation
        System.out.println("Perimeter: " + getPerimeter());  // calls subclass
    }
}
