// ==== ARRAY SEARCHING PATTERNS ====
// WHAT: Find elements using loops and conditions
// WHEN: Lookup by name, find max/min, check existence
// HOW: Use boolean flags and break for efficiency

public class ArraySearch {
    public static void main(String[] args) {
        
        String[] products = {"Laptop", "Phone", "Tablet", "Watch"};
        double[] prices = {999.99, 699.99, 449.99, 299.99};
        int[] stock = {5, 12, 8, 20};
        
        // ==== LINEAR SEARCH: FIND BY NAME ====
        // WHAT: Check each element until match found
        // WHEN: Unsorted array, find specific value
        // HOW: for loop + if (array[i].equals(target))
        
        String targetProduct = "Tablet";
        boolean found = false;
        int foundIndex = -1;
        
        for (int i = 0; i < products.length; i++) {
            if (products[i].equals(targetProduct)) {
                found = true;
                foundIndex = i;
                break;  // stop searching
            }
        }
        
        if (found) {
            System.out.println(targetProduct + " found at index " + foundIndex);
            System.out.println("Price: $" + prices[foundIndex]);
        } else {
            System.out.println(targetProduct + " not found");
        }
        
        // ==== CONDITIONAL SEARCH: FIND ALL MATCHING ====
        // WHAT: Collect or display all items meeting criteria
        // WHEN: Filter by price, stock level, etc.
        // HOW: if (condition) process element
        
        System.out.println("\n--- Items under $500 ---");
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < 500.00) {  // boolean condition
                System.out.println(products[i] + ": $" + prices[i]);
            }
        }
        
        // ==== FIND MAXIMUM VALUE ====
        // WHAT: Track highest value seen
        // WHEN: Best score, highest price, top stock
        // HOW: Start with first element, update if larger
        
        double maxPrice = prices[0];  // start with first
        String mostExpensive = products[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxPrice) {  // found higher
                maxPrice = prices[i];
                mostExpensive = products[i];
            }
        }
        
        System.out.println("\nMost expensive: " + mostExpensive + " at $" + maxPrice);
        
        // ==== CHECK IF ANY IN STOCK ====
        // WHAT: Boolean check across array
        // WHEN: Availability check, has items meeting criteria
        // HOW: boolean flag, set true if any match
        
        boolean hasLowStock = false;
        
        for (int qty : stock) {
            if (qty < 10) {
                hasLowStock = true;
                break;  // one is enough to know
            }
        }
        
        if (hasLowStock) {
            System.out.println("Some items need restocking");
        }
    }
}
