// ==== ERROR TRAPPING REFERENCE ====
// WHAT: Exception handling with try-catch-finally
// WHEN: Prevent crashes from invalid input/operations
// HOW: try { risky code } catch (ExceptionType e) { handle }

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorTrappingPatterns {
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== ERROR TRAPPING DEMONSTRATION ===\n");
        
        demo1_numberFormatException();
        demo2_inputMismatch();
        demo3_arrayIndexBounds();
        demo4_nullPointer();
        demo5_ioException();
        demo6_multipleCatch();
        demo7_parseWithDefault();
        demo8_validationLoop();
    }
    
    // ==== 1. NumberFormatException ====
    // WHAT: String to number conversion fails
    // WHEN: Integer.parseInt() on non-numeric string
    // HOW: try-catch NumberFormatException
    
    private static void demo1_numberFormatException() {
        System.out.println("1. NumberFormatException Handling:");
        
        String badInput = "abc123";
        String goodInput = "42";
        
        // WITHOUT error trapping - program crashes
        // int num = Integer.parseInt(badInput); // CRASH!
        
        // WITH error trapping
        try {
            int num = Integer.parseInt(badInput);
            System.out.println("Parsed: " + num);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: '" + badInput + "' is not a valid number!");
        }
        
        // Successful parse
        try {
            int num = Integer.parseInt(goodInput);
            System.out.println("SUCCESS: Parsed '" + goodInput + "' to " + num);
        } catch (NumberFormatException e) {
            System.out.println("This won't execute for valid input");
        }
        
        System.out.println();
    }
    
    // ==== 2. InputMismatchException ====
    // WHAT: Scanner receives wrong type
    // WHEN: nextInt() gets "hello"
    // HOW: try-catch + input.nextLine() to clear buffer
    
    private static void demo2_inputMismatch() {
        System.out.println("2. InputMismatchException Handling:");
        System.out.println("Enter text (not a number) to see error handling: ");
        
        try {
            int number = input.nextInt(); // Will fail if text entered
            System.out.println("You entered: " + number);
        } catch (java.util.InputMismatchException e) {
            System.out.println("ERROR: That's not a valid integer!");
            input.nextLine(); // CRITICAL: Clear the invalid input
        }
        
        System.out.println();
    }
    
    // ==== 3. ArrayIndexOutOfBoundsException ====
    // WHAT: Access index outside array bounds
    // WHEN: array[10] but array only has 5 elements
    // HOW: Check bounds OR try-catch
    
    private static void demo3_arrayIndexBounds() {
        System.out.println("3. ArrayIndexOutOfBoundsException:");
        
        int[] numbers = {1, 2, 3, 4, 5};
        int index = 10; // Invalid!
        
        // Method 1: Check bounds first (PREFERRED)
        if (index >= 0 && index < numbers.length) {
            System.out.println("Value: " + numbers[index]);
        } else {
            System.out.println("ERROR: Index " + index + " out of bounds!");
        }
        
        // Method 2: Try-catch
        try {
            System.out.println("Trying index " + index + "...");
            int value = numbers[index];
            System.out.println("Value: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("CAUGHT: Array index " + index + " is invalid!");
            System.out.println("Valid range: 0 to " + (numbers.length - 1));
        }
        
        System.out.println();
    }
    
    // ==== 4. NullPointerException ====
    // WHAT: Access method/field on null object
    // WHEN: obj.method() but obj is null
    // HOW: Null check OR try-catch
    
    private static void demo4_nullPointer() {
        System.out.println("4. NullPointerException:");
        
        String nullString = null;
        
        // Method 1: Null check (PREFERRED)
        if (nullString != null) {
            System.out.println("Length: " + nullString.length());
        } else {
            System.out.println("String is null - cannot get length");
        }
        
        // Method 2: Try-catch
        try {
            int len = nullString.length();
            System.out.println("Length: " + len);
        } catch (NullPointerException e) {
            System.out.println("CAUGHT: Tried to use null object!");
        }
        
        // Safe method chaining
        String safeResult = getNullableString();
        if (safeResult != null && safeResult.length() > 0) {
            System.out.println("Safe result: " + safeResult.toUpperCase());
        }
        
        System.out.println();
    }
    
    private static String getNullableString() {
        return null; // Simulates method that might return null
    }
    
    // ==== 5. IOException ====
    // WHAT: File operation fails
    // WHEN: File not found, no permission, disk full
    // HOW: try-catch IOException OR throws clause
    
    private static void demo5_ioException() {
        System.out.println("5. IOException (File Operations):");
        
        String filename = "readonly_folder/output.txt"; // Likely fails
        
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Hello");
            pw.close();
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("FILE ERROR: " + e.getMessage());
            System.out.println("Could not write to: " + filename);
        }
        
        // Check if file exists before reading
        File file = new File("nonexistent.txt");
        if (file.exists()) {
            System.out.println("File exists, can read");
        } else {
            System.out.println("File does not exist - would cause error if read");
        }
        
        System.out.println();
    }
    
    // ==== 6. Multiple Catch Blocks ====
    // WHAT: Handle different errors differently
    // WHEN: Code might throw multiple exception types
    // HOW: Catch most specific first, general last
    
    private static void demo6_multipleCatch() {
        System.out.println("6. Multiple Catch Blocks:");
        
        String[] inputs = {"100", "abc", null};
        
        for (String s : inputs) {
            try {
                if (s == null) {
                    throw new NullPointerException("Input is null");
                }
                int num = Integer.parseInt(s);
                int result = 100 / num; // Potential divide by zero
                System.out.println("Processed '" + s + "': result = " + result);
                
            } catch (NumberFormatException e) {
                System.out.println("BAD NUMBER: '" + s + "' - " + e.getMessage());
                
            } catch (NullPointerException e) {
                System.out.println("NULL VALUE: " + e.getMessage());
                
            } catch (ArithmeticException e) {
                System.out.println("MATH ERROR: " + e.getMessage());
                
            } catch (Exception e) {
                System.out.println("OTHER ERROR: " + e.getMessage());
            }
        }
        
        System.out.println();
    }
    
    // ==== 7. Parse with Default Value ====
    // WHAT: Return default if parsing fails
    // WHEN: Need safe number conversion
    // HOW: try-catch with default return
    
    private static void demo7_parseWithDefault() {
        System.out.println("7. Safe Parsing with Default:");
        
        String good = "50";
        String bad = "invalid";
        
        int val1 = safeParseInt(good, 0);
        int val2 = safeParseInt(bad, -1);
        
        System.out.println("'" + good + "' parsed to: " + val1);
        System.out.println("'" + bad + "' defaulted to: " + val2);
        
        System.out.println();
    }
    
    // UTILITY: Parse with default
    public static int safeParseInt(String input, int defaultValue) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }
    
    // ==== 8. Input Validation Loop ====
    // WHAT: Keep asking until valid input
    // WHEN: Must have valid data to proceed
    // HOW: while loop + try-catch
    
    private static void demo8_validationLoop() {
        System.out.println("8. Validation Loop (enter 'abc' twice, then a number):");
        
        int validNumber = getValidInt("Enter a valid integer: ");
        System.out.println("You entered: " + validNumber);
        
        double validDouble = getValidDouble("Enter a valid decimal: ");
        System.out.println("You entered: " + validDouble);
        
        System.out.println();
    }
    
    // UTILITY: Get validated integer
    public static int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a whole number!");
            }
        }
    }
    
    // UTILITY: Get validated double
    public static double getValidDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a valid number!");
            }
        }
    }
    
    // ==== BONUS: Try-Catch-Finally ====
    // WHAT: Execute code regardless of error
    // WHEN: Must clean up resources (files, connections)
    // HOW: finally block always executes
    
    public static void bonusFinallyDemo() {
        System.out.println("BONUS: Try-Catch-Finally");
        
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("test.txt"));
            writer.println("Hello World");
            // Simulate error
            int x = 1 / 0;
        } catch (IOException e) {
            System.out.println("IO Error");
        } catch (ArithmeticException e) {
            System.out.println("Math Error");
        } finally {
            // ALWAYS executes - even if error occurred
            if (writer != null) {
                writer.close();
                System.out.println("File closed in finally block");
            }
        }
    }
}
