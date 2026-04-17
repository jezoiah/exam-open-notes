// ==== INTERFACE DEMONSTRATION ====
// WHAT: Shows interface usage, polymorphism with interfaces
// WHEN: Exam asks for "interface implementation" or "multiple inheritance"
// HOW: Interface refs hold implementing objects

public class InterfaceTest {
    public static void main(String[] args) {
        
        // ==== INTERFACE REFERENCES ====
        // WHAT: Variable of interface type holds implementing object
        // WHEN: Code to interface, not implementation
        // HOW: InterfaceName var = new ImplementingClass();
        
        Drawable d1 = new DrawableCircle(5.0, 100, 100);
        Resizable r1 = new DrawableCircle(10.0, 200, 200);
        
        // Can only call Drawable methods through d1
        d1.draw();
        System.out.println(d1.getDescription());
        
        // Can only call Resizable methods through r1
        r1.resize(2.0);
        
        // ==== CAST TO ACCESS FULL OBJECT ====
        // WHAT: Cast interface ref to concrete class for all methods
        // WHEN: Need methods not in interface
        // HOW: if (ref instanceof Class) { Class c = (Class) ref; }
        
        if (d1 instanceof DrawableCircle) {
            DrawableCircle dc = (DrawableCircle) d1;
            dc.moveTo(150, 150);
            dc.resize(3.0);  // Resizable method
        }
        
        // ==== POLYMORPHIC INTERFACE ARRAY ====
        Drawable[] drawables = new Drawable[3];
        drawables[0] = new DrawableCircle(5.0, 10, 10);
        drawables[1] = new DrawableCircle(3.0, 50, 50);
        drawables[2] = new DrawableCircle(7.0, 100, 100);
        
        System.out.println("\n=== Drawing All ===");
        for (Drawable d : drawables) {
            d.draw();
            System.out.println();
        }
        
        // ==== MULTIPLE INTERFACES CHECK ====
        System.out.println("=== Interface Checks ===");
        DrawableCircle test = new DrawableCircle(4.0, 0, 0);
        
        // instanceof with interfaces
        System.out.println("test instanceof Drawable: " + (test instanceof Drawable));
        System.out.println("test instanceof Resizable: " + (test instanceof Resizable));
        System.out.println("test instanceof Circle: " + (test instanceof Circle));
        System.out.println("test instanceof Shape: " + (test instanceof Shape));
        
        // ==== INTERFACE CONSTANTS ====
        System.out.println("\n=== Interface Constants ===");
        System.out.println("Drawable.MAX_SIZE: " + Drawable.MAX_SIZE);
        System.out.println("Drawable.DEFAULT_COLOR: " + Drawable.DEFAULT_COLOR);
        // Constants are public static final
        
        // ==== DEFAULT METHOD ====
        System.out.println("\n=== Default Method ===");
        test.resetToDefault();  // Calls Resizable default method
        
        // ==== COMBINED CAPABILITIES ====
        System.out.println("\n=== Full Object Usage ===");
        DrawableCircle full = new DrawableCircle(10.0, 50, 50);
        
        // All inherited and implemented methods available
        full.setColor("Blue");           // from Shape
        full.scale(2.0);                 // from Shape (abstract implemented in Circle)
        full.draw();                      // from Drawable
        full.resize(0.5);                 // from Resizable
        full.resetToDefault();           // default from Resizable
        
        System.out.println("Final description: " + full.getDescription());
    }
}
