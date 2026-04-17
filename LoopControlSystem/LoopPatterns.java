// ==== FOR LOOP TEMPLATE ====
// WHAT: Loop with counter, runs fixed number of times
// WHEN: Know exact iteration count, array indexing
// HOW: Change start, condition, increment as needed

public class LoopPatterns {
    public static void main(String[] args) {
        
        // ==== BASIC FOR LOOP ====
        // for (init; condition; increment)
        // condition uses boolean check (i < 10)
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }
        
        // ==== REVERSE FOR LOOP ====
        // WHAT: Counts down instead of up
        // WHEN: Process from end to start
        // HOW: Start high, decrement, check > or >=
        
        for (int i = 5; i > 0; i--) {
            System.out.println("Countdown: " + i);
        }
        
        // ==== WHILE LOOP ====
        // WHAT: Loop while condition is true
        // WHEN: Don't know exact iterations needed
        // HOW: Set condition that eventually becomes false
        
        int count = 0;
        boolean keepGoing = true;
        
        while (keepGoing) {
            System.out.println("While count: " + count);
            count++;
            
            if (count >= 3) {
                keepGoing = false;  // boolean controls exit
            }
        }
        
        // ==== BOOLEAN LOOP CONDITION ====
        // WHAT: Using boolean variable directly
        // WHEN: Complex exit logic, multiple exit points
        // HOW: Set flag to false when condition met
        
        int attempts = 0;
        boolean success = false;
        
        while (!success) {  // loop while NOT success
            attempts++;
            System.out.println("Attempt " + attempts);
            
            if (attempts == 3) {
                success = true;  // exit on 3rd attempt
            }
        }
        
        // ==== DO-WHILE LOOP ====
        // WHAT: Runs at least once, then checks condition
        // WHEN: Must execute body before checking
        // HOW: Use when first iteration is mandatory
        
        int choice = 0;
        do {
            System.out.println("Menu displayed");
            choice++;  // simulate user selection
        } while (choice < 2);
        
        // ==== SWITCH-CASE ====
        // WHAT: Multi-way branch based on value
        // WHEN: Single variable has multiple discrete values
        // HOW: Add cases, always include default
        
        int option = 2;
        
        switch (option) {
            case 1:
                System.out.println("Option 1 selected");
                break;  // exit switch
            case 2:
                System.out.println("Option 2 selected");
                break;
            case 3:
                System.out.println("Option 3 selected");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}
