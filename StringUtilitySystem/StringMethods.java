// ==== STRING METHOD REFERENCE ====
// WHAT: Common string operations with examples
// WHEN: Text processing, validation, formatting
// HOW: string.methodName(parameters)

public class StringMethods {
    public static void main(String[] args) {
        
        String text = "Hello World";
        String email = "student@university.edu";
        String password = "SecurePass123";
        
        // ==== LENGTH() ====
        // WHAT: Returns character count
        // WHEN: Check input length, truncate validation
        // HOW: int len = str.length();
        
        int textLen = text.length();  // 11 (includes space)
        System.out.println("Length: " + textLen);
        
        boolean isValidLength = email.length() > 5 && email.length() < 50;
        
        // ==== EQUALS() AND EQUALSIGNORECASE() ====
        // WHAT: Compare string content (NEVER use ==)
        // WHEN: Password check, username match
        // HOW: str1.equals(str2), str1.equalsIgnoreCase(str2)
        
        String inputUser = "admin";
        String storedUser = "Admin";
        
        boolean exactMatch = inputUser.equals(storedUser);        // false
        boolean caseInsensitive = inputUser.equalsIgnoreCase(storedUser); // true
        
        // ==== CONTAINS() ====
        // WHAT: Check if substring exists
        // WHEN: Search keywords, validate format
        // HOW: boolean hasIt = str.contains("searchTerm");
        
        boolean hasDomain = email.contains("@university.edu");
        boolean hasNumber = password.contains("123");
        
        if (hasDomain) {
            System.out.println("Valid university email");
        }
        
        // ==== SUBSTRING() ====
        // WHAT: Extract portion of string
        // WHEN: Get domain, prefix, suffix
        // HOW: str.substring(start), str.substring(start, end)
        
        String afterSpace = text.substring(6);      // "World" (from index 6)
        String first5 = text.substring(0, 5);          // "Hello" (0 to 4)
        
        // Extract username from email
        int atIndex = email.indexOf("@");
        String username = email.substring(0, atIndex);  // "student"
        
        System.out.println("Username: " + username);
        
        // ==== TOUPPERCASE() AND TOLOWERCASE() ====
        // WHAT: Change case of all characters
        // WHEN: Normalize input, display formatting
        // HOW: str.toUpperCase(), str.toLowerCase()
        
        String upper = text.toUpperCase();   // "HELLO WORLD"
        String lower = text.toLowerCase();   // "hello world"
        
        // Common use: normalize for comparison
        String userInput = "Admin";
        if (userInput.toLowerCase().equals("admin")) {
            System.out.println("Login accepted (case-insensitive)");
        }
        
        // ==== CHAINING METHODS ====
        // WHAT: Multiple operations in sequence
        // WHEN: Complex transformation
        // HOW: str.method1().method2().method3()
        
        String processed = email.substring(0, 7).toUpperCase();  // "STUDENT"
        
        // ==== VALIDATION COMBINATION ====
        // WHAT: Multiple checks using string methods
        // WHEN: Password validation, email format
        // HOW: Combine with && and ||
        
        boolean validPassword = password.length() >= 8 
                             && password.contains("123")
                             && !password.toLowerCase().equals("password");
        
        System.out.println("Password valid: " + validPassword);
    }
}
