// ==== WRAPPER CLASSES ====
// WHAT: Object versions of primitive types
// WHEN: Need primitives in Collections (ArrayList<int> is invalid)
// HOW: Integer, Double, Boolean, Character, etc.

import java.util.ArrayList;

public class WrapperClasses {
    public static void main(String[] args) {
        
        // ==== PRIMITIVE vs WRAPPER ====
        // Primitive: int, double, boolean, char
        // Wrapper: Integer, Double, Boolean, Character
        
        int primitiveInt = 42;
        Integer wrapperInt = 42;  // Autoboxing
        
        double primitiveDouble = 3.14;
        Double wrapperDouble = 3.14;  // Autoboxing
        
        // ==== AUTOBOXING (primitive → wrapper) ====
        // WHAT: Automatic conversion
        // WHEN: Assign primitive to wrapper variable
        // HOW: Happens automatically
        
        Integer boxed = 100;  // int 100 becomes Integer
        Double boxedDouble = 2.718;
        Boolean boxedBool = true;
        
        // ==== UNBOXING (wrapper → primitive) ====
        // WHAT: Automatic conversion back
        // WHEN: Use wrapper in primitive context
        // HOW: Happens automatically
        
        int unboxed = boxed;  // Integer becomes int
        double unboxedDouble = boxedDouble;
        
        // ==== ARRAYLIST REQUIRES WRAPPERS ====
        // ArrayList<int> is INVALID
        // ArrayList<Integer> is REQUIRED
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);   // Autoboxing: 10 → Integer
        numbers.add(20);
        numbers.add(30);
        
        int first = numbers.get(0);  // Unboxing: Integer → int
        
        // ==== PARSE METHODS (String → primitive) ====
        // WHAT: Convert string to number
        // WHEN: Reading numbers from input/file
        // HOW: WrapperClass.parseType(String)
        
        String numStr = "123";
        int parsedInt = Integer.parseInt(numStr);        // 123
        double parsedDouble = Double.parseDouble("3.14"); // 3.14
        boolean parsedBool = Boolean.parseBoolean("true"); // true
        
        // ==== VALUEOF (String → Wrapper) ====
        Integer wrapped = Integer.valueOf("456");  // Returns Integer
        
        // ==== TO STRING (Number → String) ====
        String fromInt = Integer.toString(789);      // "789"
        String fromDouble = Double.toString(2.5);    // "2.5"
        
        // ==== DANGER: NULL POINTER WITH UNBOXING ====
        // WHAT: Wrapper can be null, unboxing null causes crash
        // WHEN: Collections might contain null
        // HOW: Check for null before unboxing
        
        Integer nullInteger = null;
        // int bad = nullInteger;  // RUNTIME ERROR: NullPointerException!
        
        // Safe unboxing
        if (nullInteger != null) {
            int safe = nullInteger;
            System.out.println("Safe unbox: " + safe);
        } else {
            System.out.println("Cannot unbox null");
        }
        
        // ==== == vs .equals() WITH WRAPPERS ====
        // WHAT: == compares reference, .equals() compares value
        // WHEN: Checking equality of wrappers
        // HOW: Always use .equals() for value comparison
        
        Integer a = 100;
        Integer b = 100;
        Integer c = new Integer(100);  // Deprecated but shows point
        
        System.out.println("\n=== Equality Tests ===");
        System.out.println("a == b (small cache): " + (a == b));  // true (cached -128 to 127)
        
        Integer x = 1000;
        Integer y = 1000;
        System.out.println("x == y (outside cache): " + (x == y));  // false!
        System.out.println("x.equals(y): " + x.equals(y));  // true (ALWAYS use this)
        
        // ==== USEFUL WRAPPER METHODS ====
        System.out.println("\n=== Wrapper Utilities ===");
        
        // Integer
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);  // 2147483647
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);  // -2147483648
        System.out.println("Integer.compare(5, 10): " + Integer.compare(5, 10));  // -1
        
        // Double
        System.out.println("Double.isNaN(0.0/0.0): " + Double.isNaN(0.0 / 0.0));  // true
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
        
        // Character
        System.out.println("Character.isDigit('5'): " + Character.isDigit('5'));  // true
        System.out.println("Character.isLetter('A'): " + Character.isLetter('A'));  // true
        System.out.println("Character.toUpperCase('a'): " + Character.toUpperCase('a'));  // A
        
        // ==== CONVERSION BETWEEN TYPES ====
        int toDouble = 5;
        double asDouble = (double) toDouble;  // Cast
        
        double toInt = 3.9;
        int asInt = (int) toInt;  // Truncates to 3
        
        // Wrapper way
        Double dVal = 3.9;
        int dToI = dVal.intValue();  // 3
        
        System.out.println("\nCast 3.9 to int: " + asInt);
        System.out.println("Double.intValue(): " + dToI);
    }
}
