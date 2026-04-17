// ==== STRING PARSING PATTERNS ====
// WHAT: Extract and process data from strings
// WHEN: Parse input, format output, split values
// HOW: Combine indexOf, substring, and other methods

public class StringParsing {
    public static void main(String[] args) {
        
        String data = "John,25,Engineer,75000";
        String filename = "document.pdf";
        String sentence = "The quick brown fox";
        
        // ==== SPLIT STRING BY DELIMITER ====
        // WHAT: Break string into array using separator
        // WHEN: CSV data, multi-value input
        // HOW: String[] parts = str.split(",");
        
        String[] fields = data.split(",");
        // fields[0] = "John", fields[1] = "25", etc.
        
        String name = fields[0];
        int age = Integer.parseInt(fields[1]);  // convert to number
        String job = fields[2];
        
        System.out.println("Name: " + name + ", Age: " + age);
        
        // ==== CHECK STARTS WITH / ENDS WITH ====
        // WHAT: Check prefix or suffix
        // WHEN: File extensions, protocols, prefixes
        // HOW: str.startsWith("prefix"), str.endsWith("suffix")
        
        boolean isPdf = filename.endsWith(".pdf");
        boolean isImage = filename.endsWith(".jpg") || filename.endsWith(".png");
        
        if (isPdf) {
            System.out.println("PDF file detected");
        }
        
        // ==== FIND INDEX OF CHARACTER/SUBSTRING ====
        // WHAT: Get position of first occurrence
        // WHEN: Split at specific character, extract before/after
        // HOW: int pos = str.indexOf("target"); (-1 if not found)
        
        int spacePos = sentence.indexOf(" ");        // first space position
        int secondSpace = sentence.indexOf(" ", spacePos + 1);  // next space
        int notFound = sentence.indexOf("xyz");      // -1
        
        // Extract first word
        String firstWord = sentence.substring(0, spacePos);  // "The"
        
        // ==== TRIM WHITESPACE ====
        // WHAT: Remove leading and trailing spaces
        // WHEN: Clean user input
        // HOW: String clean = str.trim();
        
        String messyInput = "  hello world  ";
        String cleanInput = messyInput.trim();  // "hello world"
        
        // ==== REPLACE CHARACTERS ====
        // WHAT: Substitute characters or substrings
        // WHEN: Clean formatting, hide sensitive data
        // HOW: str.replace("old", "new")
        
        String hidden = "1234-5678-9012".replace("-", "X");  // "1234X5678X9012"
        String censored = "password123".replace("password", "****");
        
        // ==== COMBINED PARSING EXAMPLE ====
        // WHAT: Full name parsing with validation
        // WHEN: Extract components from full name field
        // HOW: Chain operations, check bounds
        
        String fullName = "Dr. Jane Smith Jr.";
        
        // Remove titles, get just first and last
        String noTitle = fullName.replace("Dr. ", "").replace("Jr.", "").trim();
        int nameSpace = noTitle.indexOf(" ");
        
        String first = noTitle.substring(0, nameSpace);
        String last = noTitle.substring(nameSpace + 1);
        
        System.out.println("First: " + first + ", Last: " + last);
        
        // ==== EMPTY AND NULL CHECK ====
        // WHAT: Validate string has content
        // WHEN: Required field validation
        // HOW: str != null && !str.isEmpty()
        
        String empty = "";
        boolean hasContent = empty != null && !empty.isEmpty();
        System.out.println("Has content: " + hasContent);
    }
}
