// ==== BOOLEAN REFERENCE FILE ====
// WHAT: All common boolean patterns in one place
// WHEN: Need to check conditions, create flags, loop controls
// HOW: Copy the pattern you need, paste and modify

public class BooleanConditions {
    public static void main(String[] args) {
        int age = 25;
        String role = "student";
        double score = 85.5;
        
        // ==== COMPARISON OPERATORS (>, <, ==, !=) ====
        // WHAT: Compare numbers and check equality
        // WHEN: Any numeric or value comparison
        // HOW: Change variable and target value
        
        boolean isAdult = age >= 18;           // greater than or equal
        boolean isMinor = age < 18;             // less than
        boolean isPerfect = score == 100.0;     // equal to (numbers)
        boolean hasFailed = score != 100.0;     // not equal to
        boolean inRange = age > 12 && age < 20; // between range
        
        // ==== LOGICAL COMBINATIONS ====
        // WHAT: && (AND), || (OR), ! (NOT)
        // WHEN: && = all must be true, || = any can be true
        // HOW: Combine boolean variables or expressions
        
        boolean studentAndAdult = role.equals("student") && isAdult;
        boolean studentOrTeacher = role.equals("student") || role.equals("teacher");
        boolean notGuest = !role.equals("guest");
        
        // ==== BOOLEAN IN IF CONDITIONS ====
        // WHAT: Direct use of boolean in control flow
        // WHEN: Controlling program flow based on checks
        // HOW: Use boolean variable as condition directly
        
        if (isAdult) {
            System.out.println("Adult access granted");
        }
        
        if (studentAndAdult) {
            System.out.println("Adult student confirmed");
        } else if (studentOrTeacher) {
            System.out.println("School member confirmed");
        } else {
            System.out.println("Access denied");
        }
        
        // ==== MULTI-CONDITION CHECK ====
        // WHAT: Complex boolean logic in single if
        // WHEN: Need specific combination of conditions
        // HOW: Add parentheses for clarity, nest if needed
        
        boolean complexCheck = (isAdult && score >= 60) || (isMinor && score >= 70);
        
        if (complexCheck) {
            System.out.println("Pass condition met");
        }
    }
}
