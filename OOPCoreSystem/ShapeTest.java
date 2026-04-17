// ==== ABSTRACT CLASS + POLYMORPHISM TEST ====
// WHAT: Demonstrates abstract class usage
// WHEN: Exam question asks for "shape hierarchy" or "abstract class"
// HOW: Use polymorphic array, call methods on abstract reference

public class ShapeTest {
    public static void main(String[] args) {
        
        // ==== CANNOT INSTANTIATE ABSTRACT CLASS ====
        // Shape s = new Shape();  // ERROR! Cannot instantiate
        
        // ==== CREATE CONCRETE INSTANCES ====
        Circle c1 = new Circle(5.0, "Red");
        Circle c2 = new Circle(3.0, "Blue");
        Rectangle r1 = new Rectangle(4.0, 6.0);
        Rectangle r2 = new Rectangle(5.0);  // square
        
        // ==== POLYMORPHIC ARRAY ====
        // WHAT: Array of abstract type holds different concrete objects
        // WHEN: Process different types uniformly
        // HOW: AbstractType[] array = new AbstractType[size];
        
        Shape[] shapes = new Shape[4];
        shapes[0] = c1;
        shapes[1] = c2;
        shapes[2] = r1;
        shapes[3] = r2;  // Square is Rectangle
        
        // ==== POLYMORPHIC METHOD CALLS ====
        // WHAT: Same method call, different behavior
        // WHEN: Process array of mixed types
        // HOW: loop + abstractReference.abstractMethod()
        
        System.out.println("=== Shape Areas ===");
        for (Shape s : shapes) {
            System.out.println(s.getName() + ": " + s.getArea());
            // Calls Circle.getArea() or Rectangle.getArea() based on actual object
        }
        
        // ==== TOTAL AREA CALCULATION ====
        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.getArea();
        }
        System.out.println("\nTotal area of all shapes: " + totalArea);
        
        // ==== FIND LARGEST SHAPE ====
        Shape largest = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > largest.getArea()) {
                largest = shapes[i];
            }
        }
        System.out.println("Largest shape: " + largest.getName() + 
                          " with area " + largest.getArea());
        
        // ==== INSTANCEOF + TYPE CASTING ====
        // WHAT: Check actual type, cast to call specific methods
        // WHEN: Need subclass-specific method not in abstract class
        // HOW: if (obj instanceof ClassName) { ClassName c = (ClassName) obj; }
        
        System.out.println("\n=== Circle Details ===");
        for (Shape s : shapes) {
            if (s instanceof Circle) {
                // Downcast to access Circle-specific method
                Circle c = (Circle) s;
                System.out.println("Circle radius: " + c.getRadius());
            }
        }
        
        // ==== COUNT BY TYPE ====
        int circleCount = 0;
        int rectangleCount = 0;
        for (Shape s : shapes) {
            if (s instanceof Circle) {
                circleCount++;
            } else if (s instanceof Rectangle) {
                rectangleCount++;
            }
        }
        System.out.println("\nCircles: " + circleCount + ", Rectangles: " + rectangleCount);
        
        // ==== SAFE CASTING WITH CHECK ====
        // WHAT: Always check before casting to avoid ClassCastException
        // WHEN: Downcasting in polymorphic collections
        // HOW: if (obj instanceof TargetClass) { TargetClass t = (TargetClass) obj; }
        
        Shape someShape = shapes[2];  // Actually a Rectangle
        
        // Wrong cast - would crash
        // Circle badCast = (Circle) someShape;  // RUNTIME ERROR!
        
        // Safe cast
        if (someShape instanceof Rectangle) {
            Rectangle rect = (Rectangle) someShape;
            System.out.println("\nSafe cast succeeded:");
            System.out.println("Width: " + rect.getWidth() + ", Height: " + rect.getHeight());
            System.out.println("Is square: " + rect.isSquare());
        }
        
        // ==== SCALE ALL SHAPES ====
        System.out.println("\n=== Scaling all by 2x ===");
        for (Shape s : shapes) {
            System.out.println(s.getName() + " before: " + s.getArea());
            s.scale(2.0);
            System.out.println(s.getName() + " after: " + s.getArea());
        }
        
        // ==== EQUALS METHOD ====
        Circle c3 = new Circle(5.0, "Yellow");
        Circle c4 = new Circle(5.0, "Green");  // Same radius, different color
        
        System.out.println("\n=== Equals Test ===");
        System.out.println("c1 == c3: " + (c1 == c3));  // false (different objects)
        System.out.println("c1.equals(c3): " + c1.equals(c3));  // true (same radius)
        System.out.println("c1.equals(c4): " + c1.equals(c4));  // true (same radius)
        
        // ==== PRINT ALL INFO ====
        System.out.println("\n=== Full Shape Info ===");
        for (Shape s : shapes) {
            s.printInfo();
            System.out.println();
        }
    }
}
