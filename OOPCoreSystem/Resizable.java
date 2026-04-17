// ==== SECOND INTERFACE ====
// WHAT: Another capability interface
// WHEN: Class can implement multiple interfaces
// HOW: Same syntax, different capability

public interface Resizable {
    
    // ==== RESIZE METHODS ====
    void resize(double scale);
    
    void resize(double width, double height);
    
    // ==== QUERY METHOD ====
    boolean canResizeTo(double width, double height);
    
    // ==== DEFAULT METHOD (Java 8+) ====
    // WHAT: Method with default implementation
    // WHEN: Share common behavior, still overridable
    // HOW: default ReturnType methodName() { body }
    
    default void resetToDefault() {
        System.out.println("Resetting to default size...");
        resize(1.0);
    }
}
