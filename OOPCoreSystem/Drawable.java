// ==== INTERFACE ====
// WHAT: Contract specifying methods a class MUST implement
// WHEN: Define capability that crosses class hierarchies
// HOW: public interface Name { void method(); }

public interface Drawable {
    
    // ==== ABSTRACT METHOD (implicit) ====
    // WHAT: Method without body - must be implemented
    // WHEN: All implementing classes need this behavior
    // HOW: ReturnType methodName();
    
    void draw();
    
    // ==== METHOD WITH PARAMETERS ====
    void draw(int x, int y);
    
    // ==== RETURN VALUE ====
    String getDescription();
    
    // ==== CONSTANT (implicitly public static final) ====
    // WHAT: Shared constant across all implementations
    // WHEN: Default values, limits
    // HOW: Type NAME = value;
    
    int MAX_SIZE = 1000;
    String DEFAULT_COLOR = "black";
}
