// ==== INPUT TEMPLATE ====
// WHAT: Scanner setup for user input
// WHEN: Any program needs keyboard input
// HOW: Copy the Scanner block, change variable names as needed

import java.util.Scanner;

public class LoginMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // ==== CREDENTIAL INPUT ====
        // WHAT: Reads username and password from user
        // WHEN: Login forms, credential validation
        // HOW: Change prompt text, add more fields if needed
        
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        // ==== BOOLEAN VALIDATION FLAGS ====
        // WHAT: Stores validation results as true/false
        // WHEN: Need to check multiple conditions separately
        // HOW: Change the conditions being checked
        
        boolean isUsernameValid = username.equals("admin");
        boolean isPasswordValid = password.equals("1234");
        boolean isNotEmpty = !username.isEmpty() && !password.isEmpty();
        
        // ==== LOGICAL OPERATORS (&&, ||) ====
        // WHAT: Combines multiple boolean checks
        // WHEN: Need all conditions (&&) or any condition (||) to pass
        // HOW: Swap && for || to change logic, add more conditions
        
        boolean canLogin = isUsernameValid && isPasswordValid && isNotEmpty;
        
        // ==== IF-ELSE DECISION ====
        // WHAT: Executes different code based on boolean result
        // WHEN: Different outcomes for different conditions
        // HOW: Add else-if blocks for more cases
        
        if (canLogin) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }
        
        // ==== STRING.EQUALS() COMPARISON ====
        // WHAT: Proper way to compare string content
        // WHEN: NEVER use == for strings, always use .equals()
        // HOW: Replace "admin" and "1234" with target values
        
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Exact match verified.");
        }
        
        input.close();
    }
}
