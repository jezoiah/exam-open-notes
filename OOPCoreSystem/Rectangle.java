// ==== CONCRETE SUBCLASS: RECTANGLE ====
// WHAT: Another shape extending abstract class
// WHEN: Need different area/perimeter formulas
// HOW: extends Shape, implement all abstract methods

public class Rectangle extends Shape {
    
    private double width;
    private double height;
    
    // ==== CONSTRUCTORS ====
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.name = "Rectangle";
        this.color = "Blue";
    }
    
    public Rectangle(double side) {
        // Square is special rectangle
        this.width = side;
        this.height = side;
        this.name = "Square";
        this.color = "Green";
    }
    
    // ==== IMPLEMENT ABSTRACT METHODS ====
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public void scale(double factor) {
        this.width *= factor;
        this.height *= factor;
    }
    
    // ==== GETTERS/SETTERS ====
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public boolean isSquare() {
        return width == height;
    }
    
    // ==== METHOD OVERLOADING within class ====
    public void resize(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }
    
    // Overloaded - single parameter makes square
    public void resize(double side) {
        this.width = side;
        this.height = side;
    }
}
