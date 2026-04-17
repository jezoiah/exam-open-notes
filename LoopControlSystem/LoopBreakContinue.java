// ==== LOOP CONTROL FLOW ====
// WHAT: break and continue statements
// WHEN: Skip iterations or exit early
// HOW: Use boolean conditions to trigger control

public class LoopBreakContinue {
    public static void main(String[] args) {
        
        // ==== BREAK STATEMENT ====
        // WHAT: Exits loop immediately
        // WHEN: Found target, stop searching
        // HOW: if (condition) break;
        
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;  // exit at 5, don't continue to 9
            }
            System.out.println("Before break: " + i);
        }
        
        // ==== CONTINUE STATEMENT ====
        // WHAT: Skips to next iteration
        // WHEN: Skip certain values, filter processing
        // HOW: if (skipCondition) continue;
        
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {  // if even
                continue;  // skip even numbers
            }
            System.out.println("Odd number: " + i);
        }
        
        // ==== BOOLEAN LOOP WITH NESTED IF ====
        // WHAT: Complex exit logic
        // WHEN: Multiple conditions to stop
        // HOW: Combine booleans with && and ||
        
        int max = 20;
        boolean found = false;
        int target = 7;
        
        for (int i = 1; i <= max && !found; i++) {
            if (i == target) {
                found = true;
                System.out.println("Found target at: " + i);
            }
        }
        
        // ==== NESTED LOOPS ====
        // WHAT: Loop inside loop
        // WHEN: 2D data, combinations
        // HOW: Track indices carefully
        
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                if (row == col) {
                    continue;  // skip diagonal
                }
                System.out.println("Row " + row + ", Col " + col);
            }
        }
        
        // ==== WHILE WITH COMPLEX BOOLEAN ====
        // WHAT: Multiple conditions in while
        // WHEN: Exit on several possible triggers
        // HOW: Use || for any-condition exit, && for all-required
        
        int a = 0, b = 10;
        boolean running = true;
        
        while (running && a < 5 && b > 0) {
            a++;
            b--;
            System.out.println("a=" + a + ", b=" + b);
            
            if (a == b) {  // exit when equal
                running = false;
            }
        }
    }
}
