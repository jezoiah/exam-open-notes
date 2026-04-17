// ==== METHOD OVERLOADING ====
// WHAT: Same method name, different parameters
// WHEN: Same operation, different inputs
// HOW: Different parameter count or types

public class MethodOverloadDemo {
    
    // ==== OVERLOADED: CALCULATE AREA ====
    // WHAT: Calculate area for different shapes
    // WHEN: Same concept, different dimensions needed
    // HOW: int area(int) for square, int area(int, int) for rectangle
    
    // Square: one side
    public int calculateArea(int side) {
        return side * side;
    }
    
    // Rectangle: width and height
    public int calculateArea(int width, int height) {
        return width * height;
    }
    
    // Circle: radius (double)
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
    
    // ==== OVERLOADED: DISPLAY MESSAGE ====
    // WHAT: Print with different format options
    // WHEN: Flexible output formatting
    // HOW: Add boolean, int, or other modifiers
    
    public void display(String message) {
        System.out.println(message);
    }
    
    public void display(String message, boolean uppercase) {
        if (uppercase) {
            System.out.println(message.toUpperCase());
        } else {
            System.out.println(message);
        }
    }
    
    public void display(String message, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(message);
        }
    }
    
    // ==== OVERLOADED: SUM VALUES ====
    // WHAT: Add different number of values
    // WHEN: Variable input count
    // HOW: 2 param, 3 param, array param versions
    
    public int sum(int a, int b) {
        return a + b;
    }
    
    public int sum(int a, int b, int c) {
        return a + b + c;
    }
    
    public int sum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    // ==== MAIN: DEMONSTRATION ====
    // Shows all overloads in action
    
    public static void main(String[] args) {
        MethodOverloadDemo demo = new MethodOverloadDemo();
        
        // Area calculations - compiler picks correct version
        int squareArea = demo.calculateArea(5);        // calls (int)
        int rectArea = demo.calculateArea(4, 6);     // calls (int, int)
        double circleArea = demo.calculateArea(3.0);   // calls (double)
        
        System.out.println("Square: " + squareArea);
        System.out.println("Rectangle: " + rectArea);
        System.out.println("Circle: " + circleArea);
        
        // Display overloads
        demo.display("Hello");                    // simple
        demo.display("Hello", true);              // uppercase
        demo.display("Repeat", 3);                // repeat 3 times
        
        // Sum overloads
        int sum2 = demo.sum(10, 20);              // 2 numbers
        int sum3 = demo.sum(10, 20, 30);          // 3 numbers
        int sumArray = demo.sum(new int[]{1,2,3,4,5}); // array
        
        System.out.println("Sum of 2: " + sum2);
        System.out.println("Sum of 3: " + sum3);
        System.out.println("Sum of array: " + sumArray);
    }
}
