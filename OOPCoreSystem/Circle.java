// ==== CONCRETE SUBCLASS: CIRCLE ====
// WHAT: Extends abstract Shape, implements all abstract methods
// WHEN: Specific shape with area/perimeter formulas
// HOW: extends AbstractClass, provide all method bodies

public class Circle extends Shape {
    
    private double radius;
    
    // ==== CONSTRUCTOR ====
    public Circle(double radius) {
        this.radius = radius;
        this.name = "Circle";
        this.color = "Red";  // default
    }
    
    public Circle(double radius, String color) {
        this.radius = radius;
        this.name = "Circle";
        this.color = color;
    }
    
    // ==== IMPLEMENT ABSTRACT METHODS ====
    // WHAT: Required - provide body for all abstract methods
    // WHEN: Subclass is concrete (not abstract)
    // HOW: @Override public ReturnType methodName() { body }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void scale(double factor) {
        this.radius *= factor;
    }
    
    // ==== ADDITIONAL METHODS ====
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }
    
    // ==== OVERRIDE toString ====
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + ", area=" + 
               String.format("%.2f", getArea()) + "]";
    }
    
    // ==== OVERRIDE equals ====
    // WHAT: Compare content, not reference
    // WHEN: Two objects represent same data
    // HOW: Check class, cast, compare fields
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle other = (Circle) obj;
        return Double.compare(other.radius, radius) == 0;
    }
}
