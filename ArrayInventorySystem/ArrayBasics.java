// ==== STATIC ARRAY DECLARATION ====
// WHAT: Create fixed-size array with known values
// WHEN: Data is known at compile time
// HOW: Change type and values as needed

public class ArrayBasics {
    public static void main(String[] args) {
        
        // ==== ARRAY INIT: DECLARE + ALLOCATE + ASSIGN ====
        // Format: Type[] name = new Type[size];
        // Or: Type[] name = {val1, val2, val3};
        
        int[] numbers = new int[5];           // empty, all 0
        String[] items = {"Pen", "Book", "Bag"}; // pre-filled
        double[] prices = {1.50, 12.99, 45.00};
        
        // ==== ARRAY TRAVERSAL: FOR LOOP ====
        // WHAT: Visit every element by index
        // WHEN: Need index position or modify values
        // HOW: Change array name, use array.length as limit
        
        System.out.println("--- Array Contents ---");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Index " + i + ": " + items[i]);
        }
        
        // ==== ARRAY TRAVERSAL: FOR-EACH ====
        // WHAT: Visit every element, no index needed
        // WHEN: Read-only access to all elements
        // HOW: for (Type var : arrayName) { use var }
        
        System.out.println("--- Quick List ---");
        for (String item : items) {
            System.out.println(item);
        }
        
        // ==== UPDATING ARRAY VALUES ====
        // WHAT: Change element at specific index
        // WHEN: Modify inventory, update scores
        // HOW: array[index] = newValue;
        
        numbers[0] = 100;
        numbers[1] = 200;
        numbers[2] = numbers[0] + numbers[1];  // 300
        
        System.out.println("--- Updated Numbers ---");
        for (int num : numbers) {
            System.out.println(num);
        }
        
        // ==== ARRAY LENGTH PROPERTY ====
        // WHAT: Get number of elements (not last index)
        // WHEN: Loop bounds, capacity checks
        // HOW: array.length (no parentheses!)
        
        int itemCount = items.length;
        int lastIndex = items.length - 1;  // last valid index
        
        System.out.println("Total items: " + itemCount);
        System.out.println("Last item: " + items[lastIndex]);
    }
}
